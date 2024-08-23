import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../_dto/product';
import { productUpdateRequest } from '../_dto/product-update-request';

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

  update(productOld: Product, productUpdated: Product): Observable<Product> {
    const dto: productUpdateRequest = { old: productOld, updated: productUpdated };
    return this.http.put<Product>('http://localhost:8081/product', dto);
  }  
}
