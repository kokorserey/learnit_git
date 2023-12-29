package compositePattern;

import java.util.ArrayList;
import java.util.List;

// Component interface
interface Component {
    void operation();
}

// Leaf class (implements the Component interface)
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf: " + name);
    }
}

// Composite class (implements the Component interface)
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite:");
        for (Component component : children) {
            component.operation();
        }
    }
}

// Client code
public class CompositePatternExample {
    public static void main(String[] args) {
        // Creating leaf objects
        Component leaf1 = new Leaf("Leaf 1");
        Component leaf2 = new Leaf("Leaf 2");
        Component leaf3 = new Leaf("Leaf 3");

        // Creating composite objects
        Composite composite1 = new Composite();
        composite1.add(leaf1);
        composite1.add(leaf2);

        Composite composite2 = new Composite();
        composite2.add(leaf3);

        // Creating a higher-level composite
        Composite rootComposite = new Composite();
        rootComposite.add(composite1);
        rootComposite.add(composite2);

        // Invoking operation on the entire hierarchy
        rootComposite.operation();
    }
}
