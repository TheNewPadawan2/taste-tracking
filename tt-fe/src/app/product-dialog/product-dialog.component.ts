import { Component, Inject } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
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
  errorMessage?: string;
  processing: boolean = false;

  constructor(
          private productService: ProductService,
          @Inject(MAT_DIALOG_DATA) private data: Product,
          private dialogRef: MatDialogRef<ProductDialogComponent>) {
    this.product = data;
    this.productUpdated = { name: this.product.name, type: this.product.type };
  }

  update(): void {
    this.processing = true;
    this.productService.update(this.product, this.productUpdated).subscribe({
      next: (value: Product): void => {
        this.product.name = value.name;
        this.product.type = value.type;
        let type: string | number | undefined;
        for (let i = 0; i < this.productTypes.length; i++) {
          if (this.productTypes[i].key === this.product.type) {
            type = this.productTypes[i].value;
            break;
          }
        }
        this.product.typeReadable = type !== undefined && typeof type === 'string' ? type : this.product.type;
      },
      error: (res: HttpErrorResponse): void => {
        this.errorMessage = res.status === 0 || res.error.message === undefined ? 'Il sistema è offline' : res.error.message;
        this.processing = false;
      },
      complete: (): void => {
        this.errorMessage = undefined;
        this.dialogRef.close();
        this.processing = false;
      }
    });
  }

  delete(): void {
    this.processing = true;
    this.productService.delete(this.product.name).subscribe({
      next: (): void => {
        console.log('success');
      },
      error: (res: HttpErrorResponse): void => {
        console.log(res);
        this.processing = false;
      },
      complete: (): void => {
        this.errorMessage = undefined;
        this.dialogRef.close();
        this.processing = false;
      }
    })
  }
}
