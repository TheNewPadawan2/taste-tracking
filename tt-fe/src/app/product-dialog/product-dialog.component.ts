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
  product: Product;
  productUpdated: Product;

  constructor(@Inject(MAT_DIALOG_DATA) private data: Product) {
    this.product = { name: data.name, type: data.type };
    PRODUCT_TYPES.forEach((kv: KeyValue) => {
      if (data.type.toString().toLowerCase() === kv.key.toLowerCase()) {
        this.product.type = kv.value;
      }
    });
    this.productUpdated = { name: this.product.name, type: this.product.type };
  }

}
