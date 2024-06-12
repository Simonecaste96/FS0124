import { Component, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/services/service.service';
import { InterfaceUser } from 'src/app/interfaces/interface-user';
import { InterfaceTodo } from 'src/app/interfaces/interface-todo';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {
users:InterfaceUser[]=[];
todos:InterfaceTodo[]=[];

constructor(private Service:ServiceService){
}

async ngOnInit():Promise<void>{
  const responseUser = await this.Service.getUser();
  this.users = responseUser;
  const responseTodo = await this.Service.getTodo();
  this.todos = responseTodo;
}
toggleCompleted(user: any): void {
  user.completed = !user.completed;
}


}
