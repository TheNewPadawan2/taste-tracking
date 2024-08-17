export class Product {
    position?: number;
    name: string;
    quantity: number;

    constructor(name: string, quantity: number = 1, position?: number) {
        this.name = name;
        this.quantity = quantity;
        this.position = position;
    }
}
