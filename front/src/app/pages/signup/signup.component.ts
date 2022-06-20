import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(
    private userService:UserService,
    private router:Router
  
  ) { }
  public user={
    username:"",
    password:"",
    email:"",
    phone:"",
    lastName:"",
    firstName:"",

  }

  ngOnInit(): void {
  }
  formSubmit(){
    console.log(this.user);
    if(this.user.username===""||this.user.password===""||this.user.email===""||this.user.phone===""||this.user.lastName===""||this.user.firstName===""){
      alert("Please fill all the fields");
      return;
    }
    this.userService.addUser(this.user).subscribe(
      (res)=>{
        console.log(res);
        alert("User added successfully kindly login");
        this.router.navigate(['']);
        
      },
      (err)=>{
        console.log(err);
        alert("something went wrong");
      }

    )
  }

}
