import { Injectable } from '@angular/core';
import { InterfaceTodo } from '../interfaces/interface-todo';
import { InterfaceUser } from '../interfaces/interface-user';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  todos:InterfaceTodo[]=[];
  users:InterfaceUser[]=[];

  constructor() {}
  async getTodo (){
    let response = await fetch('../../assets/db_todo.json');
    let dataTodo = await response.json();
    return dataTodo;
  }
  async getUser (){
    let response = await fetch('../../assets/db_user.json');
    let dataUser = await response.json();
    return dataUser;
  }
}
