package programa;


import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import entities.Product;
import entities.OrderItem;
import entities.Order;
import entities.Client;
import entitiesEnum.OrderStatus;



public class Programa {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("Enter cliente data: ");

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Email: ");
        String email = input.nextLine();

        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date dateOfBirth = sdf1.parse(input.nextLine());

        Client client = new Client(name, email, dateOfBirth);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = input.nextLine().toUpperCase();
        System.out.print("How many items to this order? ");
        int quantidadeProdutos = input.nextInt();

        Order order  = new Order(new Date(), OrderStatus.valueOf(status), client);
        for (int i = 1; i <= quantidadeProdutos;i++){

            System.out.printf("Enter #%d item data: \n", i);

            System.out.print("Product name: ");
            String nameOfProduct = input.nextLine();
            input.nextLine();

            System.out.print("Product price: ");
            double valueOfProduct = input.nextDouble();

            System.out.print("Quantity: ");
            int quantityOfProduct = input.nextInt();

            OrderItem item = new OrderItem(quantityOfProduct, valueOfProduct, new Product(nameOfProduct, valueOfProduct));
            order.addItem(item);
        }

        System.out.println("ORDER SUMMARY: ");
        System.out.print(order);

    input.close();
    }
}
