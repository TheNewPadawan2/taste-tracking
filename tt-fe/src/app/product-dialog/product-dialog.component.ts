import { Component, Inject } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Product } from '../_dto/product';
import { PRODUCT_TYPES } from '../_mock/mock-product-type';
import { KeyValue } from '../_dto/key-value';
import { ProductService } from '../_service/product.service';

@Component({
  selector: 'app-product-dialog',
  templateUrl: './product-dialog.component.html',
  styleUrl: './product-dialog.component.css'
})
export class ProductDialogComponent {
  readonly productTypes: KeyValue[] = PRODUCT_TYPES;
  product: Product;
  productUpdated: Product;

  constructor(
          private productService: ProductService,
          @Inject(MAT_DIALOG_DATA) private data: Product) {
    this.product = data;
    this.productUpdated = { name: this.product.name, type: this.product.type };
  }

  update(): void {
    this.productService.update(this.product, this.productUpdated).subscribe({
      next: (): void => {
        console.log("success");
      },
      error: (res: HttpErrorResponse): void => {
        console.error(res.status);
        console.error(res.error);
      },
      complete: (): void => {
        console.log("complete");
      }
    });
  }

}
