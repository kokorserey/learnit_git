package FactoryPattern;

public class FatoryMethodParttenEx {
	public static void main(String[] args) {
	     // Using Concrete Creator A
	     Creator creatorA = new ConcreteCreatorA();
	     creatorA.performOperation();

	     // Using Concrete Creator B
	     Creator creatorB = new ConcreteCreatorB();
	     creatorB.performOperation();
	 }
}


//Concrete Product A
class ConcreteProductA implements Product {
 @Override
 public void create() {
     System.out.println("Product A created");
 }
}

//Concrete Product B
class ConcreteProductB implements Product {
 @Override
 public void create() {
     System.out.println("Product B created");
 }
}

//Creator (Abstract Creator)
abstract class Creator {
 // The factory method that is responsible for creating products
 abstract Product createProduct();

 // Some operation that uses the created product
 void performOperation() {
     Product product = createProduct();
     product.create();
 }
}

//Concrete Creator A
class ConcreteCreatorA extends Creator {
 @Override
 Product createProduct() {
     return new ConcreteProductA();
 }
}

//Concrete Creator B
class ConcreteCreatorB extends Creator {
 @Override
 Product createProduct() {
     return new ConcreteProductB();
 }
}