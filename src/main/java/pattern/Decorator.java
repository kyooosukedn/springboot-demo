package pattern;

// Test program
public class Decorator {
    public static void main(String[] args) {
        // Create a Cheesecake with Chocolate Sprinkles and Whipped Cream
        Cake cheesecake = new WhippedCreamDecorator(new ChocolateSprinklesDecorator(new Cheesecake()));

        // Create a Sachertorte with Whipped Cream
        Cake sachertorte = new WhippedCreamDecorator(new Sachertorte());

        // Print the descriptions and prices of the cakes
        System.out.println("Cheesecake: " + cheesecake.getDescription());
        System.out.println("Price: $" + cheesecake.getPrice());

        System.out.println();

        System.out.println("Sachertorte: " + sachertorte.getDescription());
        System.out.println("Price: $" + sachertorte.getPrice());
    }
}

// Abstract base class for cakes
abstract class Cake {
    public abstract String getDescription();
    public abstract double getPrice();
}

// Concrete cake class: Cheesecake
class Cheesecake extends Cake {
    @Override
    public String getDescription() {
        return "Cheesecake";
    }

    @Override
    public double getPrice() {
        return 10.0;
    }
}

// Concrete cake class: Sachertorte
class Sachertorte extends Cake {
    @Override
    public String getDescription() {
        return "Sachertorte";
    }

    @Override
    public double getPrice() {
        return 12.0;
    }
}

// Abstract decorator class for cake decorations
abstract class CakeDecorator extends Cake {
    protected Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }
}

// Concrete decorator class: Chocolate Sprinkles
class ChocolateSprinklesDecorator extends CakeDecorator {
    public ChocolateSprinklesDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getDescription() {
        return cake.getDescription() + ", Chocolate Sprinkles";
    }

    @Override
    public double getPrice() {
        return cake.getPrice() + 1.5;
    }
}

// Concrete decorator class: Whipped Cream
class WhippedCreamDecorator extends CakeDecorator {
    public WhippedCreamDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getDescription() {
        return cake.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getPrice() {
        return cake.getPrice() + 2.0;
    }
}


