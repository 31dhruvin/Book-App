import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {

   }
    public loginUser(user:any){
      return this.http.post(`${baseUrl}/generate-token`,user);
 
    } 
    public loginStore(token:any){
      localStorage.setItem('token',token);
      return true;
    }
    public islogin(){
      let find=localStorage.getItem('token')
      if(find == null || find == undefined || find == ""){
        return false;
      }
      return true;
    }
    public logout(){
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      return true;
    }
    public getToken(){
      return localStorage.getItem('token');
    }
    public setUser(user:any){
      localStorage.setItem('user',JSON.stringify(user));
    }
    public getUser(){
      let user1=localStorage.getItem('user');
      if(user1 == null || user1 == undefined || user1 == ""){
        this.logout();
        return null;
      }
      return JSON.parse(user1);
    }
    public getCurrentUser(){
      return this.http.get(`${baseUrl}/current-user`);
    }
}
