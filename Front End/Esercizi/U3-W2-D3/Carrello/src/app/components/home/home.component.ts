import { Component, OnDestroy, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';
import { Model } from 'src/app/models/model';
import { CartInterface } from 'src/app/models/cart-interface';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {

  models: Model[] = [];
  cart:CartInterface[]=[];
  sub!: Subscription;

  constructor(private http: ApiService) {}

  ngOnInit(): void {
    this.caricaModelli();
  }

  ngOnDestroy(): void {
    if (this.sub) {
      this.sub.unsubscribe();
    }
  }

  caricaModelli(): void {
    this.sub = this.http.GET().subscribe((e) => {
      this.models = e;
    });
  }
  aggiungiAlCarrello(){
    const cloneModello = { ...this.models }; // Clona il modello per evitare effetti collaterali
    this.cart.push(); 
  }

  eliminaDalCarrello(id: number): void {
    this.sub = this.http.DELL(id).subscribe();
  }

  aggiungiAiPreferiti(): void {
  this.http.addFavorite();
  }
}
