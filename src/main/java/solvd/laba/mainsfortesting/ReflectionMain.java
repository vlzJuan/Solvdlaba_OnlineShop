package solvd.laba.mainsfortesting;

import solvd.laba.enums.ProductCategory;
import solvd.laba.products.Product;

import java.lang.reflect.*;

public class ReflectionMain {
    public static void main(String[] args) {
        try {
            System.out.println("Reflection usage");
            // Grab the class of Product:
            Class<Product> productClass = Product.class;
            System.out.println("Class Name: " + productClass.getName());

            System.out.println("\nConstructors available in this class:");
            Constructor<?>[] constructors = productClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.print(constructor.toString() + " Parameter types taken: ");
                Parameter[] parameters = constructor.getParameters();
                for (Parameter parameter : parameters) {
                    System.out.print(parameter.getType() + " " + parameter.getName() + "; ");
                }
                System.out.println();
            }

            // Create an instance of Product using reflection
            Constructor<Product> productConstructor = productClass.getConstructor(String.class, int.class, double.class, ProductCategory.class);
            Product prod = productConstructor.newInstance("Sample", 10, 9.99, ProductCategory.TEXTILE);
            System.out.println("\nCreated Product Instance: " + prod);

            // Retrieve and print fields
            System.out.println("\nFields:");
            Field[] fields = productClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("Field: " + field.getName() + ", Type: " + field.getType()
                        + ", Modifiers: " + field.getModifiers()
                        + " {" + Modifier.toString(field.getModifiers()) + "}");

                // Accessing private field 'stock'
                if (field.getName().equals("stock")) {
                    field.setAccessible(true); // Allows access to private field
                    System.out.println("Current stock value: " + field.get(prod));
                }
            }

            // Touch on the stock field with reflection:
            Field reflectedStock = productClass.getDeclaredField("stock");
            reflectedStock.setAccessible(true);     // Make it public for now
            System.out.println("Directly accessed value for stock = " + reflectedStock.get(prod));
            reflectedStock.setAccessible(false);    //  Make it private again

            // Retrieve and print methods
            System.out.println("\nMethods:");
            Method[] methods = productClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.print("Method: " + method.getName() +
                        ", Return Type: " + method.getReturnType().getSimpleName() + " || ");
                Parameter[] parameters = method.getParameters();
                if(parameters.length==0){
                    System.out.print("None. This method does not take parameters.");
                }
                else {
                    System.out.print(" Parameters: ");
                    for (Parameter parameter : parameters) {
                        System.out.print(parameter.getType() + " " + parameter.getName() + ", ");
                    }
                }
                System.out.print("\n");
            }

            // Call methods using reflection
            // store the hasStock method
            Method hasStockMethod = productClass.getMethod("hasStock");
            System.out.println("Reflected method, 'hasStock'... Does it? " + hasStockMethod.invoke(prod));
            // Store the restock method
            Method restockMethod = productClass.getMethod("restock", int.class);
            restockMethod.invoke(prod, 50); //  Adds 50 units of the product.
            System.out.println("Stock after restocking 50 units: " + prod.getStock());
            // Store the removeStock method
            Method consumeStockMethod = productClass.getMethod("removeStock", int.class);
            consumeStockMethod.invoke(prod, 60);    // hasStock should return false now.
            // Check if hasStock works when I've taken all stock from the product.
            System.out.println("Reflected method, 'hasStock'... Does it? " + hasStockMethod.invoke(prod));

        } catch (Exception e) {
            System.out.println("Exception found while trying reflection: \n" + e);
        }
    }
}
