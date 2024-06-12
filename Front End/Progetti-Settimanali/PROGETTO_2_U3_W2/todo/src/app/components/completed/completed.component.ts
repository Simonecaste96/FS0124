import { Component, OnInit } from '@angular/core';
import { InterfaceTodo } from 'src/app/interfaces/interface-todo';
import { InterfaceUser } from 'src/app/interfaces/interface-user';
import { ServiceService } from 'src/app/services/service.service';

@Component({
  selector: 'app-completed',
  templateUrl: './completed.component.html',
  styleUrls: ['./completed.component.scss']
})
export class CompletedComponent implements OnInit {
todos:InterfaceTodo[]=[];
users:InterfaceUser[]=[];

constructor(private Service:ServiceService){}

async ngOnInit():Promise<void>{
  const responseTodo = await this.Service.getTodo();
  this.todos = responseTodo;
  const responseUser = await this.Service.getUser();
  this.users = responseUser;
}
toggleCompleted(user: any): void {
  user.completed = !user.completed;
}


}
