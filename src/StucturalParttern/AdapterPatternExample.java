package StucturalParttern;

//Target interface (Expected by the client)
interface Target {
 void request();
}

//Adaptee (The class to be adapted)
class Adaptee {
 void specificRequest() {
     System.out.println("Adaptee's specific request");
 }
}

//Adapter (Adapts Adaptee to Target)
class Adapter implements Target {
	 private Adaptee adaptee;
	
	 // Constructor accepting Adaptee object
	 public Adapter(Adaptee adaptee) {
	     this.adaptee = adaptee;
	 }
	
	 // Implementing the Target interface by delegating to Adaptee
	 @Override
	 public void request() {
	     adaptee.specificRequest();
	 }
}

//Client code that expects to work with Target interface
class Client {
	 public void makeRequest(Target target) {
	     target.request();
	 }
}

public class AdapterPatternExample {
 public static void main(String[] args) {
     // Create an instance of Adaptee
     Adaptee adaptee = new Adaptee();

     // Create an Adapter and pass Adaptee to it
     Adapter adapter = new Adapter(adaptee);

     // Client makes a request to the Target interface
     Client client = new Client();
     client.makeRequest(adapter);
 }
}
