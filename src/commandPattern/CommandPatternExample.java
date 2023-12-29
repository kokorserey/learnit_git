package commandPattern;


//Command interface
interface Command {
	void execute(); 
}


//Concrete command classes
class LightOnCommand implements Command {
	 private Light light;
	
	 public LightOnCommand(Light light) {
	     this.light = light;
	 }
	
	 @Override
	 public void execute() {
	     light.turnOn();
	 }
}

class LightOffCommand implements Command {
	 private Light light;
	
	 public LightOffCommand(Light light) {
	     this.light = light;
	 }
	
	 @Override
	 public void execute() {
	     light.turnOff();
	 }
}

//Receiver class
class Light {
	 public void turnOn() {
	     System.out.println("Light is ON");
	 }
	
	 public void turnOff() {
	     System.out.println("Light is OFF");
	 }
}

//Invoker class
class RemoteControl {
	 private Command command;
	
	 public void setCommand(Command command) {
	     this.command = command;
	 }
	
	 public void pressButton() {
	     command.execute();
	 }
}

//Client code
public class CommandPatternExample {
 public static void main(String[] args) {
     // Create instances
     Light light = new Light();
     LightOnCommand lightOnCommand = new LightOnCommand(light);
     LightOffCommand lightOffCommand = new LightOffCommand(light);

     // Set commands to invoker
     RemoteControl remoteControl = new RemoteControl();
     remoteControl.setCommand(lightOnCommand);

     // Press the button
     remoteControl.pressButton();

     // Change the command and press the button again
     remoteControl.setCommand(lightOffCommand);
     remoteControl.pressButton();
 }
}
