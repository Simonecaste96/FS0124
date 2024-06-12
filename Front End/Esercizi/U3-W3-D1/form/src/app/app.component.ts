import { Component,ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FormInterface } from './interfaces/form-interface';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Template driven form';

@ViewChild('form',{static:true}) form!:NgForm;

user: FormInterface = {
  name: '',
  surname: '',
  gender: '',
  userImg: '',
  username: '',
  bio: '',
  email: '',
  password: '',
  passwordCheck: ''
};




ngOnInit():void{
 this.form.statusChanges?.subscribe(status=>{
  console.log('Stato del form: ', status);
 }); 
}

submit(){
  console.log(this.form.value);
  
    // Assegna i valori dei campi del form agli oggetti FormInterface
    this.user.name = this.form.value.name;
    this.user.surname = this.form.value.surname;
    this.user.gender = this.form.value.gender;
    this.user.userImg = this.form.value.userImg;
    this.user.username = this.form.value.username;
    this.user.bio = this.form.value.bio;
    this.user.email = this.form.value.email;
    this.user.password = this.form.value.password;
    this.user.passwordCheck = this.form.value.passwordCheck;
  
  console.log('Form inviato correttamente:', this.form);

  this.form.reset();
}



}
