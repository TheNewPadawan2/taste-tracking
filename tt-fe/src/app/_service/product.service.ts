import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../_dto/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) {}
  
  create(product: Product): Observable<null> {
    return this.http.post<null>('http://localhost:8081/product/create', product);
  }

  search(): Observable<Product[]> {
    return this.http.get<Product[]>('http://localhost:8081/product');
  } 
}
