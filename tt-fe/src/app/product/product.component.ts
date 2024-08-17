import { Component } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Product } from '../_dto/product';
import { PRODUCT_TYPES } from '../_mock/mock-product-type';
import { KeyValue } from '../_dto/key-value';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {
  productTypes: KeyValue[] = PRODUCT_TYPES;
  ELEMENT_DATA: Product[] = [
    new Product('mela', 50 ),
    new Product('arancia', 120 )
  ];

  /*filterName?: string;
  filterMinQty?: number;
  filterMaxQty?: number;*/
  name?: string;
  type?: number;
  displayedColumns: string[] = ['position', 'name', 'quantity'];
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  create(): void {}
}
