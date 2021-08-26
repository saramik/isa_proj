import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserReg } from 'src/app/model/userregister';
import { AuthentificationService } from 'src/app/service/authentification.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  user: User;
  oldUser: User;
  userForm: FormGroup;
  submitionErrorUser: boolean = false;
  userNotFound: boolean = false;
  us : string = '';
  lek : [];

  constructor(private fb: FormBuilder, private authService: AuthentificationService, public router: Router) { 
    this.user = new User();
    this.oldUser = new User();
    this.userForm = this.fb.group({
      'email':['',[Validators.required, Validators.email]],
      'ime': ['', Validators.required],
      'prezime': ['', Validators.required],
      'adresa': ['', Validators.required],
      'grad': ['', Validators.required],
      'drzava': ['', Validators.required],
      'broj': ['', Validators.required],
      'penali' : ['']
    })
  }

  ngOnInit(): void {
    this.loadUser();
  }

  loadUser() {
    this.authService.getUser().subscribe(
      result => {
        console.log(result);
        this.user = result as User;
        this.lek = this.user.alergijeLekovi;
        this.userForm.patchValue({
          'email' : this.user.email,
          'ime':  this.user.ime,
          'prezime':  this.user.prezime,
          'adresa':  this.user.adresa,
          'grad':  this.user.grad,
          'drzava':  this.user.drzava,
          'broj':  this.user.broj,
          'penali' :  this.user.penali
        })
      },
      error => {
        this.submitionErrorUser = true;
      }
    );
  }

  onSubmit(){
    let Uid = JSON.parse(localStorage.getItem('currentUser') || "")?.id;
    console.log(Uid);
  }

}
