import { Component, OnInit } from '@angular/core';
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
export class ProductComponent implements OnInit {
  productTypes: KeyValue[] = PRODUCT_TYPES;
  ELEMENT_DATA?: Product[];
  name?: string;
  type?: number;
  displayedColumns: string[] = [ 'name', 'type' ];
  dataSource?: MatTableDataSource<Product>;

  constructor(
          private productService: ProductService) {
  }

  ngOnInit(): void {
    this.search();
  }

  applyFilter(event: Event) {
    if (this.dataSource !== undefined) {
      const filterValue = (event.target as HTMLInputElement).value;
      this.dataSource.filter = filterValue.trim().toLowerCase();
    }  
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

  search(): void {
    this.ELEMENT_DATA = undefined;
    this.productService.search().subscribe({
      next: (value: Product[]): void => {
        value.forEach((data: Product) => {
          if (typeof data.type === 'number') {
            const type: string | undefined = this.productTypes[data.type].key;
            data.type = type !== undefined ? type : '';
          }
        });
        //TODO: riempitre data source
        if(this.ELEMENT_DATA === undefined) {
          this.ELEMENT_DATA = value;
        } else {
          value.forEach((v: Product) => this.ELEMENT_DATA!.push(v));
        }
        this.dataSource = new MatTableDataSource(this.ELEMENT_DATA);
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
