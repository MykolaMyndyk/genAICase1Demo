# Customer Order Service

This service is designed to manage customer orders. It consists of two main classes: `Customer` and `OrderLine`.

## Classes

### Customer

The `Customer` class represents a customer who places orders. It contains a list of `OrderLine` objects, each representing a product in the order. The `Customer` class provides methods to add a product to the order and calculate the total cost of the order.

### OrderLine

The `OrderLine` class represents a line item in an order. It contains properties such as name, code, quantity, and price.

## How to Use

### Add a product to an order

Create an `OrderLine` object and set its properties. Then, call the `addProduct` method on a `Customer` object, passing the `OrderLine` object as an argument. This will add the product to the customer's order.

### Calculate the total cost of an order

Call the `calculateSum` method on a `Customer` object, passing the name of the product to exclude as an argument. This will return the total cost of the order, excluding the specified product.

## Tests

This service includes a suite of unit tests, written using JUnit. They cover all the functionality of the `Customer` class.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)