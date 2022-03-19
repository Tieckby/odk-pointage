import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {
loginData : any;
userRole:any;
  constructor(private router:Router, 
    public toast: ToastrService,) { }

  ngOnInit(): void {
    this.loginData = JSON.parse(localStorage["isLogin"]);
    console.log(this.loginData);

    if(this.loginData.genre == "HOMME"){
      this.toast.success("BIENVENUE Mr " + this.loginData.nom)
    }else if(this.loginData.genre == "FEMME"){
      this.toast.success("BIENVENUE Mme " + this.loginData.nom)
    }
    if(localStorage["userRole"]){
      this.userRole=JSON.parse(localStorage["userRole"]);
    }
  }

  listAdmins(){
    this.router.navigate(['/listAdmins']);
  }

  listUsers(){
    this.router.navigate(['/listUsers']);
  }

  listPointage(){
    this.router.navigate(['/listPointage']);
  }

  log(){
    this.router.navigate(['/log']);
  }

  logOut(){
    localStorage.removeItem('isLogin');
    this.router.navigate(['/login']);
  }
}
