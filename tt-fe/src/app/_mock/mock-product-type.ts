import { KeyValue } from "../_dto/key-value";

let i = 0;

/**
 * Relate with tt-be\login\src\main\java\it\uniecampus\lfulgione\tastetracking\ttbe\login\dto\ProductType.java
 */
export const PRODUCT_TYPES: KeyValue[] = [
    { index: i++, key: 'FRUTTA', value: 'Frutta' },
    { index: i++, key: 'VERDURA', value: 'Verdura' },
    { index: i++, key: 'TUBERI', value: 'Tuberi' },
    { index: i++, key: 'UOVA_LATTE_DERIVATI', value: 'Uova, Latte e derivati' },
    { index: i++, key: 'CARNE', value: 'Carne' },
    { index: i++, key: 'INSACCATI', value: 'Insaccati' },
];
