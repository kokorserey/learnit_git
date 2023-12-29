package deadecoratorPattern;

//Component interface (the base interface or abstract class)
interface Coffee {
 double cost(); // returns the cost of the coffee
 String description(); // returns the description of the coffee
}

//Concrete Component (the basic implementation of the component interface)
class SimpleCoffee implements Coffee {
 @Override
 public double cost() {
     return 1.0; // simple coffee costs $1.0
 }

 @Override
 public String description() {
     return "Simple Coffee";
 }
}

//Decorator abstract class (provides a common interface for all concrete decorators)
abstract class CoffeeDecorator implements Coffee {
 protected Coffee decoratedCoffee; // the wrapped coffee

 public CoffeeDecorator(Coffee decoratedCoffee) {
     this.decoratedCoffee = decoratedCoffee;
 }

 @Override
 public double cost() {
     return decoratedCoffee.cost();
 }

 @Override
 public String description() {
     return decoratedCoffee.description();
 }
}

//Concrete Decorator (adds milk to the coffee)
class MilkDecorator extends CoffeeDecorator {
 public MilkDecorator(Coffee decoratedCoffee) {
     super(decoratedCoffee);
 }

 @Override
 public double cost() {
     return super.cost() + 0.5; // cost of milk is $0.5
 }

 @Override
 public String description() {
     return super.description() + " with Milk";
 }
}

//Concrete Decorator (adds sugar to the coffee)
class SugarDecorator extends CoffeeDecorator {
	 public SugarDecorator(Coffee decoratedCoffee) {
	     super(decoratedCoffee);
	 }
	
	 @Override
	 public double cost() {
	     return super.cost() + 0.2; // cost of sugar is $0.2
	 }
	
	 @Override
	 public String description() {
	     return super.description() + " with Sugar";
	 }
}

public class DecoratorPatternExample {
 public static void main(String[] args) {
     // Create a simple coffee
     Coffee simpleCoffee = new SimpleCoffee();
     System.out.println("Cost: $" + simpleCoffee.cost() + ", Description: " + simpleCoffee.description());

     // Add milk to the coffee
     Coffee milkCoffee = new MilkDecorator(simpleCoffee);
     System.out.println("Cost: $" + milkCoffee.cost() + ", Description: " + milkCoffee.description());

     // Add sugar to the coffee
     Coffee sugarCoffee = new SugarDecorator(simpleCoffee);
     System.out.println("Cost: $" + sugarCoffee.cost() + ", Description: " + sugarCoffee.description());

     // Add both milk and sugar to the coffee
     Coffee milkAndSugarCoffee = new SugarDecorator(new MilkDecorator(simpleCoffee));
     System.out.println("Cost: $" + milkAndSugarCoffee.cost() + ", Description: " + milkAndSugarCoffee.description());
 }
}
