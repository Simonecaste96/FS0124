package Esercizio;

import java.time.LocalDate;
import java.util.*;


public class MainEsercizio {


    public static void main(String[] args) {
        //Clienti

        Customer customer1 = new Customer(29341, "Simone", 2);
        Customer customer2 = new Customer(67890, "Anna", 2);
        Customer customer3 = new Customer(12345, "Marco", 3);
        Customer customer4 = new Customer(24680, "Laura", 2);
        Customer customer5 = new Customer(13579, "Luca", 1);
        Customer customer6 = new Customer(97531, "Giulia", 3);
        Customer customer7 = new Customer(86420, "Federico", 1);

        //Prodotti
        Product product1 = new Product(1234, "Books", "Harry Potter: Il calice di fuoco", 20);
        Product product2 = new Product(5678, "Books", "Il Codice Da Vinci", 110);
        Product product3 = new Product(91011, "Books", "Il silenzio degli innocenti", 18);
        Product product4 = new Product(121314, "Books", "Il Signore degli Anelli", 25);
        Product product5 = new Product(151617, "Books", "Orgoglio e pregiudizio", 101);

        Product product6 = new Product(242526, "Boys", "Action Figure - Supereroe", 20);
        Product product7 = new Product(272829, "Boys", "Set di Costruzioni - Veicoli da Guerra", 25);
        Product product8 = new Product(303132, "Boys", "Nintendo Switch", 150);
        Product product9 = new Product(333435, "Boys", "Auto da Corsa Radiocomandata", 30);
        Product product10 = new Product(363738, "Boys", "Set di Nerf Blaster", 40);
        Product product11 = new Product(394041, "Boys", "Modellino di Aereo Militare", 35);
        Product product12 = new Product(515253, "Baby", "Coperta Morbida in Pile", 15);
        Product product13 = new Product(545556, "Baby", "Set di Biberon Colorati", 20);
        Product product14 = new Product(575859, "Baby", "Tappetino per Bagnetto Antiscivolo", 10);
        Product product15 = new Product(606162, "Baby", "Libro Morbido per Neonati", 8);

        //Lista con tutti i prodotti
        ArrayList<Product> listaProdotti = new ArrayList<>();
        listaProdotti.add(product1);
        listaProdotti.add(product2);
        listaProdotti.add(product3);
        listaProdotti.add(product4);
        listaProdotti.add(product5);
        listaProdotti.add(product6);
        listaProdotti.add(product7);
        listaProdotti.add(product8);
        listaProdotti.add(product9);
        listaProdotti.add(product10);
        listaProdotti.add(product11);
        listaProdotti.add(product12);
        listaProdotti.add(product13);
        listaProdotti.add(product14);
        listaProdotti.add(product15);

        System.out.println();
        System.out.println();

        listaProdotti.stream().forEach(e -> System.out.println(e));

        System.out.println();
        System.out.println();


        //Ottengo lista solo per categoria books
        listaProdotti.stream().filter(e -> e.getCategory().equals("Books")).filter(e -> e.getPrice() < 100).toList().stream().forEach(e -> System.out.println("Prodotti categoria Books: " + e));

        System.out.println();
        System.out.println();

        //Ottengo una lista per categoria boys ed applico sconto del 10 %
        listaProdotti.stream().filter(e -> e.getCategory().equals("Boys"))
                .map(e -> {
                    double prezzoScontato = e.getPrice() * 0.9;
                    e.setPrice(prezzoScontato);
                    return e;
                }).toList().forEach(e -> System.out.println("Sconti di primavera, categoria Boys scontata del 10%, approfittane! " + e));


//Lista con gli ordini dei clienti
        ArrayList listaOrdinicustomer1 = new ArrayList<>();
        listaOrdinicustomer1.add(product1);
        listaOrdinicustomer1.add(product6);
        listaOrdinicustomer1.add(product13);

        ArrayList listaOrdinicustomer2 = new ArrayList<>();
        listaOrdinicustomer2.add(product3);
        listaOrdinicustomer2.add(product8);
        listaOrdinicustomer2.add(product13);

        ArrayList listaOrdinicustomer3 = new ArrayList<>();
        listaOrdinicustomer3.add(product9);
        listaOrdinicustomer3.add(product12);
        listaOrdinicustomer3.add(product13);

        ArrayList listaOrdinicustomer4 = new ArrayList<>();
        listaOrdinicustomer4.add(product1);
        listaOrdinicustomer4.add(product6);
        listaOrdinicustomer4.add(product13);

        ArrayList listaOrdinicustomer5 = new ArrayList<>();
        listaOrdinicustomer5.add(product1);
        listaOrdinicustomer5.add(product7);
        listaOrdinicustomer5.add(product3);

        ArrayList listaOrdinicustomer6 = new ArrayList<>();
        listaOrdinicustomer6.add(product10);
        listaOrdinicustomer6.add(product8);
        listaOrdinicustomer6.add(product6);

        ArrayList listaOrdinicustomer7 = new ArrayList<>();
        listaOrdinicustomer7.add(product6);
        listaOrdinicustomer7.add(product14);
        listaOrdinicustomer7.add(product4);


        Order order1 = new Order(320391241, "Consegnato", LocalDate.parse("2021-02-01"), LocalDate.parse("2021-02-03"), listaOrdinicustomer1, customer1);
        Order order2 = new Order(320391241, "Consegnato", LocalDate.parse("2021-02-01"), LocalDate.parse("2021-02-03"), listaOrdinicustomer2, customer2);
        Order order3 = new Order(320391241, "Consegnato", LocalDate.parse("2021-02-01"), LocalDate.parse("2021-02-03"), listaOrdinicustomer3, customer3);
        Order order4 = new Order(320391241, "Consegnato", LocalDate.parse("2021-05-01"), LocalDate.parse("2021-05-03"), listaOrdinicustomer4, customer4);
        Order order5 = new Order(320391241, "Consegnato", LocalDate.parse("2021-06-01"), LocalDate.parse("2021-06-03"), listaOrdinicustomer5, customer5);
        Order order6 = new Order(320391241, "Consegnato", LocalDate.parse("2021-01-01"), LocalDate.parse("2021-01-03"), listaOrdinicustomer6, customer6);
        Order order7 = new Order(320391241, "Spedito", LocalDate.parse("2024-04-23"), LocalDate.parse("2024-04-26"), listaOrdinicustomer7, customer7);

        ArrayList<Order> listaOrdiniTotali = new ArrayList<>();
        listaOrdiniTotali.add(order1);
        listaOrdiniTotali.add(order2);
        listaOrdiniTotali.add(order3);
        listaOrdiniTotali.add(order4);
        listaOrdiniTotali.add(order5);
        listaOrdiniTotali.add(order6);
        listaOrdiniTotali.add(order7);

        System.out.println();
        System.out.println();

        listaOrdiniTotali.stream().flatMap(e -> e.getProducts().stream()).filter(e -> e.getCategory().equals("Baby")).toList().forEach(e -> System.out.println("Lista degli ordini con SOLO categoria Baby: " + e));


        System.out.println();
        System.out.println();

        listaOrdiniTotali.stream()
                .filter(order -> order.getOrderDate().isAfter(LocalDate.parse("2021-01-31"))
                        && order.getOrderDate().isBefore(LocalDate.parse("2021-04-02"))
                        && order.getCostumer().getTier() == 2)
                .forEach(order -> System.out.println("Lista ordine di utenti con livello 2 e data di ordine tra 2021-02-01 e 2021-04-01: " + order));
    }


}
