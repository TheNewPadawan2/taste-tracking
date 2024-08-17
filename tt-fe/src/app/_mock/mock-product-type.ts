import { KeyValue } from "../_dto/key-value";

let i = 0;

/**
 * Relate with tt-be\login\src\main\java\it\uniecampus\lfulgione\tastetracking\ttbe\login\dto\ProductType.java
 */
export const PRODUCT_TYPES: KeyValue[] = [
    { key: 'Frutta', value: i++ },
    { key: 'Verdura', value: i++ },
    { key: 'Tuberi', value: i++ },
    { key: 'Uova, Latte e derivati', value: i++ },
    { key: 'Carne', value: i++ },
    { key: 'Insaccati', value: i++ },
];