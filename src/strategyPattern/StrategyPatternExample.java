package strategyPattern;

//Strategy interface
interface PaymentStrategy {
 void pay(int amount);
}

//Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
 private String cardNumber;

 public CreditCardPayment(String cardNumber) {
     this.cardNumber = cardNumber;
 }

 @Override
 public void pay(int amount) {
     System.out.println("Paid " + amount + " using credit card: " + cardNumber);
 }
}

class PayPalPayment implements PaymentStrategy {
 private String email;

 public PayPalPayment(String email) {
     this.email = email;
 }

 @Override
 public void pay(int amount) {
     System.out.println("Paid " + amount + " using PayPal with email: " + email);
 }
}

//Context class that uses the strategy
class ShoppingCart {
 private PaymentStrategy paymentStrategy;

 public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
     this.paymentStrategy = paymentStrategy;
 }

 public void checkout(int amount) {
     paymentStrategy.pay(amount);
 }
}

//Client code
public class StrategyPatternExample {
 public static void main(String[] args) {
     // Create a shopping cart
     ShoppingCart cart = new ShoppingCart();

     // Use credit card payment strategy
     PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432");
     cart.setPaymentStrategy(creditCardPayment);
     cart.checkout(100);

     // Use PayPal payment strategy
     PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
     cart.setPaymentStrategy(payPalPayment);
     cart.checkout(50);
 }
}
