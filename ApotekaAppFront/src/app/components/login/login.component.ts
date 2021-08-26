import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthentificationService, AuthResponseData } from 'src/app/service/authentification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  isLoading = false;
  error: string = null;

  constructor(private authService: AuthentificationService, private router: Router, private http: HttpClient) {}

  ngOnInit(): void {
    if(this.authService.isLoggedIn())
      this.router.navigate(['/home-page-user']); 
  }

  onSubmit(form : NgForm){
    if (!form.valid) {
      return;
    }
    const email = form.value.email;
    const password = form.value.password;

    let authObs: Observable<AuthResponseData>;

    this.isLoading = true;

    this.authService.login(email, password).subscribe(
      resData => {
        if(JSON.parse(localStorage.getItem('currentUser') || "")?.roles?.includes("ROLE_PACIJENT")){
          this.router.navigate(['/home-page-user']); 
        }else{
          this.router.navigate(['/']); 
        }
      },
      errorMessage => {
        console.log(errorMessage);
        this.error = errorMessage;
        this.isLoading = false;
      }
    );
    form.reset();
  }

}
