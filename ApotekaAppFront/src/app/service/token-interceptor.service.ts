import { Injectable } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http';
import { HttpRequest } from '@angular/common/http';
import { HttpHandler } from '@angular/common/http';
import { HttpEvent } from '@angular/common/http';
import { Injector } from '@angular/core';
import { AuthentificationService } from './authentification.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor {

  
  constructor(private inj: Injector) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authenticationService:AuthentificationService = this.inj.get(AuthentificationService); 
    request = request.clone({
      setHeaders: {
        'Authorization': `Bearer ${authenticationService.getToken()}`
      }
    });

    return next.handle(request);
  }
}
