import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginData={
    username:"",
    password:""

  }

  constructor(private login:LoginService, private router:Router) { }

  ngOnInit(): void {
  }
  formSubmit(){
    //if (sessionStorage.getItem('id') == null) {
      //window.location.href = '/home';
      //return false;
  //}
  //return true;
    //
    //
    //
    //
    console.log(this.loginData);
    if(this.loginData.username==""||this.loginData.password=="" || this.loginData.username.trim()=="" || this.loginData.password.trim()==""){
      alert("Please fill all the fields");
      return;
    }
    this.login.loginUser(this.loginData).subscribe(
      (res:any)=>{
        console.log(res);
        // alert("Login successful");
        this.login.loginStore(res.token);
        this.login.getCurrentUser().subscribe(
          (res:any)=>{
            console.log(res);
            this.login.setUser(res);
            this.router.navigate(['home']);
            
          },
          
          
        )
      },
      (err)=>{
        console.log(err);
        alert("Login failed");
      }
    )

  }
}
