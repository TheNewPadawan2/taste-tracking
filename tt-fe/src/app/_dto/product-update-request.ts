import { Product } from "./product";

export interface productUpdateRequest {
    old: Product;
    updated: Product;
}