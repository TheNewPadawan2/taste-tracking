import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Product } from '../_dto/product';
import { PRODUCT_TYPES } from '../_mock/mock-product-type';
import { KeyValue } from '../_dto/key-value';

@Component({
  selector: 'app-product-dialog',
  templateUrl: './product-dialog.component.html',
  styleUrl: './product-dialog.component.css'
})
export class ProductDialogComponent {
  readonly productTypes: KeyValue[] = PRODUCT_TYPES;
  product: Product;
  productUpdated: Product;

  constructor(@Inject(MAT_DIALOG_DATA) private data: Product) {
    this.product = data;
    this.productUpdated = { name: this.product.name, type: this.product.type };
  }

}
