import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../_dto/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) {}

  create(product: Product): Observable<null> {
    const productSend: Product = { name: product.name, type: product.type };
    return this.http.post<null>('http://localhost:8081/product/create', productSend);
  }

  search(): Observable<Product[]> {
    return this.http.get<Product[]>('http://localhost:8081/product');
  }
}
