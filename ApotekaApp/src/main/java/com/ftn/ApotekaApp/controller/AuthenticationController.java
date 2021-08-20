package com.ftn.ApotekaApp.controller;

import com.ftn.ApotekaApp.dto.UserDTO;
import com.ftn.ApotekaApp.dto.UserLoginDTO;
import com.ftn.ApotekaApp.dto.UserTokenStateDTO;
import com.ftn.ApotekaApp.event.OnRegistrationCompleteEvent;
import com.ftn.ApotekaApp.helper.PacijentMapper;
import com.ftn.ApotekaApp.model.Korisnik;
import com.ftn.ApotekaApp.security.TokenUtils;
import com.ftn.ApotekaApp.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    private KorisnikService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    private PacijentMapper pacijentMapper;

   public AuthenticationController() {
       this.pacijentMapper = new PacijentMapper();
   }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody UserLoginDTO authenticationRequest,
                                                       HttpServletResponse response) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()));

        // Ubaci korisnika u trenutni security kontekst
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token za tog korisnika
        Korisnik user = (Korisnik) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user); // prijavljujemo se na sistem sa email adresom
        int expiresIn = tokenUtils.getExpiredIn();

        // Vrati token kao odgovor na uspesnu autentifikaciju
        return ResponseEntity.ok(new UserTokenStateDTO(user.getId(), jwt, expiresIn));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserDTO userRequest, UriComponentsBuilder ucBuilder) throws Exception {
       try {
           Korisnik user = userService.createPacijent(pacijentMapper.toEntity(userRequest));
           HttpHeaders headers = new HttpHeaders();
           headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri());
           eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user));
           return new ResponseEntity<>("User successfully registered.", HttpStatus.CREATED);
       } catch (Exception e) {
           e.printStackTrace();
           return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/registration-confirm/{token}")
    public ResponseEntity<?> confirmRegistration(@PathVariable("token") String token) throws URISyntaxException {
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            userService.verifyRegistrationToken(token);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("https://localhost:4200/register-success-redirect"))
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("https://localhost:4200/register-token-expired"))
                    .build();
        }
    }



//    @GetMapping("/registration-confirm/{token}")
//    public ResponseEntity<?> confirmRegistration(@PathVariable("token") String token) throws URISyntaxException {
//       HttpHeaders httpHeaders = new HttpHeaders();
//       try {
//            registeredUserService.verifyRegistrationToken(token);
//            return ResponseEntity.status(HttpStatus.FOUND)
//                    .location(URI.create("https://localhost:4200/register-success-redirect"))
//                    .build();
//        } catch (Exception e) {
//           return ResponseEntity.status(HttpStatus.FOUND)
//                   .location(URI.create("https://localhost:4200/register-token-expired"))
//                   .build();
//        }
//    }
}
