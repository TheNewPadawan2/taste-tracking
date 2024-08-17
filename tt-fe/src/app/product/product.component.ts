import { Component } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { MatTableDataSource } from '@angular/material/table';
import { KeyValue } from '../_dto/key-value';
import { Product } from '../_dto/product';
import { PRODUCT_TYPES } from '../_mock/mock-product-type';
import { ProductService } from '../_service/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {
  productTypes: KeyValue[] = PRODUCT_TYPES;
  ELEMENT_DATA: Product[] = [
    { name: 'mela', type: 0 },
    { name: 'arancia', type: 0 },
    { name: 'zucchina', type: 1 },
    { name: 'carota', type: 2 },
  ];
  name?: string;
  type?: number;
  displayedColumns: string[] = [ 'name', 'type' ];
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);

  constructor(
          private productService: ProductService) {
    this.ELEMENT_DATA.forEach((data: Product) => {
      if (typeof data.type === 'number') {
        const type: string | undefined = this.productTypes[data.type].key;
        data.type = type !== undefined ? type : '';
      }
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  create(): void {
    if (this.name !== undefined && this.type !== undefined) {
      const product: Product = { name: this.name, type: this.type };
      this.productService.create(product).subscribe({
        next: (): void => {
          console.log("success");
        },
        error: (res: HttpErrorResponse): void => {
          console.error(res.status);
          console.error(res.error);
        },
        complete: (): void => {
          console.log("complete");
          // product.type = typeof product.type === 'number' ? this.productTypes[product.type].key : '';
          // this.ELEMENT_DATA.push(product);
        }
      });
    }
  }
}
