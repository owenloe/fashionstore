import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.Customer;
import model.DetailOrder;
import model.Karyawan;
import model.Order;
import model.Produk;

import java.time.LocalTime; // import the LocalTime class
import java.time.format.DateTimeFormatter;

public class App {
    static Scanner scanner = new Scanner(System.in); //tryfix
    static ArrayList<Customer> customerList = new ArrayList<>();
    static ArrayList<Produk> produkList = new ArrayList<>();
    static ArrayList<Karyawan> karyawanList = new ArrayList<>();
    static ArrayList<Order> orderList = new ArrayList<>();
    static ArrayList<DetailOrder> detailOrderList = new ArrayList<>();

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Integer choice = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Karyawan");
            System.out.println("3. Add Produk");
            System.out.println("4. Add Order");
            System.out.println("5. Add Detail Order");
            System.out.println("6. Add Settlement");
            System.out.println("7. View Customer");
            System.out.println("8. View Karyawan");
            System.out.println("9. View Produk");
            System.out.println("10. View Order");
            System.out.println("11. View Detail Order");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");


        if (scanner.hasNextInt()) {
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
    } else {
        System.out.println("Invalid choice. Please enter a valid menu option.");
        
        scanner.nextLine(); // Consume the invalid input
        continue; // Restart the loop
    }

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    addKaryawan();
                    break;
                case 3:
                    addProduk();
                    break;
                case 4:
                    addOrder(); //TRY FIX
                    //scanner.nextLine(); //try fix
                    break;
                case 5:
                    addDetailOrder();
                    break;
                case 6:
                    //addSettlement();
                    break;
                case 7:
                    viewCustomer();
                    break;
                case 8:
                    viewKaryawan();
                    break;
                case 9:
                    viewProduk();
                    break;
                case 10:
                    viewOrder();
                    break;
                case 11:
                    viewDetailOrder();
                    break;
                case 12:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid menu option.");
            }
            //scanner.nextLine(); try fix, original active
        } while (choice != 12);
        scanner.close(); //TRY FIX
    }


    public static void addCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();

        // Create a new Customer object and add it to the customerList ArrayList
        Customer customer = new Customer(name, phoneNumber, email, address);
        customerList.add(customer);
        System.out.println("Customer added successfully!");
    }

    public static void viewCustomer() {
        if (customerList.isEmpty()) {
            System.out.println("No Customer found.");
        } else {
            System.out.println("--------------------------------------------------------");
            System.out.println("Available Customers:");
            System.out.println("--------------------------------------------------------");
            System.out.printf("| %-5s | %-20s | %-15s |\n", "No", "Customer Name", "Phone Number");
    
            for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            System.out.printf("| %-5d | %-20s | %-15s |\n", (i + 1), customer.getCustomerName(), customer.getCustomerPhoneNumber());
            }
    
        System.out.println("--------------------------------------------------------");}
    }


    public static void addOrder() { //try fix  original nothing inside
    //Scanner scanner = new Scanner(System.in); //try fix

    LocalTime localTime = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String tanggalPesanan = localTime.format(formatter);
    int index = orderList.size() + 1;

    String orderID = "OR" + String.format("%03d", index); // Assuming a maximum of 999 Orders

    viewCustomer();

    // Prompt for customer selection
    System.out.print("Select a customer: ");
    int selectedCustomerIndex;

    if (scanner.hasNextInt()) {
        selectedCustomerIndex = scanner.nextInt();
    } else {
        System.out.println("Invalid input. Please enter a valid integer.");
        scanner.close();
        return;
    }

    if (selectedCustomerIndex < 1 || selectedCustomerIndex > customerList.size()) {
        System.out.println("Invalid customer selection.");
        scanner.close();
        return;
    }

    Customer selectedCustomer = customerList.get(selectedCustomerIndex - 1);
    String customerName = selectedCustomer.getCustomerName();
    String customerPhoneNumber = selectedCustomer.getCustomerPhoneNumber();

    viewKaryawan();

    scanner.nextLine(); // Consume the newline character after reading the integer

    System.out.print("Enter the ID of the karyawan: ");
    String selectedKaryawanID = scanner.nextLine(); //TRY FIX
    //scanner.nextLine(); //trying fix add nextline convert up to next
    String karyawanName = " ";

    // Find the karyawan in the karyawanList based on the ID
    Karyawan selectedKaryawan = null;
    for (Karyawan karyawan : karyawanList) {
        if (karyawan.getIdKaryawan().equals(selectedKaryawanID)) {
            selectedKaryawan = karyawan;
            break;
        }
    }

    if (selectedKaryawan != null) {
        // Retrieve selected karyawan data
        karyawanName = selectedKaryawan.getNamaKaryawan();
    } else {
        System.out.println("Invalid karyawan ID.");
        //scanner.close();
        return;
    }
    
    //scanner.nextLine(); //fix error //edit: doesnt work.
    Integer hargaTotal = null;

    Order order = new Order(orderID, customerName, customerPhoneNumber, tanggalPesanan, hargaTotal, karyawanName);

    order.setOrderID(orderID);
    order.setKaryawan(karyawanName);

    // Add the order to the orderList
    orderList.add(order);
    System.out.println("Order added successfully!");

   // scanner.close();
}

public static void viewOrder() {
    if (orderList.isEmpty()) {
        System.out.println("No Order found.");
    } else {
        System.out.println("--------------------------------------------------------");
        System.out.println("Available Orders:");
        System.out.println("--------------------------------------------------------");
        System.out.printf("| %-8s | %-20s | %-15s | %-15s | %-15s | %-12s |\n",
                "Order ID", "Customer Name", "Phone Number", "Tanggal Pesanan", "Karyawan", "Total Price");

        for (Order order : orderList) {
            System.out.printf("| %-8s | %-20s | %-15s | %-15s | %-15s | %-12d |\n",
                    order.getOrderID(), order.getCustomerName(),
                    order.getCustomerPhoneNumber(), order.getTanggalPesanan(),
                    order.getKaryawan(), order.getHargaTotal());
        }

        System.out.println("--------------------------------------------------------");
    }
}




    public static void addProduk() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter product brand: ");
    String merkProduk = scanner.nextLine();
    System.out.print("Enter product name: ");
    String namaProduk = scanner.nextLine();
    System.out.print("Enter product category: ");
    String kategoriProduk = scanner.nextLine();
    System.out.print("Enter product price: ");
    int hargaProduk = scanner.nextInt();
    System.out.print("Enter product stock: ");
    int stokProduk = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character
    System.out.print("Enter product color: ");
    String warnaProduk = scanner.nextLine();
    System.out.print("Enter product size: ");
    String ukuranProduk = scanner.nextLine();

    // Generate the Produk ID based on the index of the ArrayList
    int index = produkList.size() + 1;
    String idProduk = "PK" + String.format("%03d", index); // Assuming a maximum of 999 Produk
    

    // Create a new Produk object and set its properties
    Produk produk = new Produk(idProduk, merkProduk, namaProduk, kategoriProduk, hargaProduk, stokProduk, warnaProduk, ukuranProduk);
    produk.setIdProduk(idProduk);
    // Add the produk to the ArrayList
    produkList.add(produk);

    System.out.println("Produk added successfully!");
}

public static void viewProduk() {
    if (produkList.isEmpty()) {
        System.out.println("No Produk found.");
    } else {
        System.out.println("Produk List:");
        System.out.println("--------------------------------------------------------");
        System.out.println("Available Produk:");
        System.out.println("--------------------------------------------------------");
        System.out.printf("| %-5s | %-20s | %-15s | %-10s |\n", "ID", "Nama Produk", "Harga Satuan", "Stok Produk");

        for (int i = 0; i < produkList.size(); i++) {
            Produk produk = produkList.get(i);
            System.out.printf("| %-5s | %-20s | %-15d | %-10d |\n", produk.getIdProduk(), produk.getNamaProduk(), produk.getHargaProduk(), produk.getStokProduk());
        }

        System.out.println("--------------------------------------------------------");
    }
}



    public static void addKaryawan() {
    Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Karyawan Name: ");
        String namaKaryawan = scanner.nextLine();
        System.out.print("Enter Karyawan Phone Number: ");
        String nomorTeleponKaryawan = scanner.nextLine();
        System.out.print("Enter Karyawan Jabatan: ");
        String jabatan = scanner.nextLine();
        System.out.print("Enter Karyawan Departemen: ");
        String departemen = scanner.nextLine();
        System.out.print("Enter Karyawan Gaji: ");
        String gaji = scanner.nextLine();

        // Generate the Karyawan ID based on the index of the ArrayList
        int index = karyawanList.size() + 1;
        String idKaryawan = "KR" + String.format("%03d", index); // Assuming a maximum of 999 karyawan

        // Create a new Karyawan object and add it to the karyawanList ArrayList
        Karyawan karyawan = new Karyawan(idKaryawan, namaKaryawan, nomorTeleponKaryawan, jabatan, departemen, gaji);
        karyawan.setIdKaryawan(idKaryawan);
        karyawanList.add(karyawan);
        
        System.out.println("Karyawan added successfully!");
    }

    public static void viewKaryawan() {
        if (karyawanList.isEmpty()) {
            System.out.println("No karyawan found.");
        } else {
            System.out.println("Karyawan List:");
        System.out.println("--------------------------------------------------------");
        System.out.println("Available Karyawan:");
        System.out.println("--------------------------------------------------------");
        System.out.printf("| %-5s | %-20s | %-15s | %-10s |\n", "ID", "Nama", "Jabatan", "Departemen");

        for (int i = 0; i < karyawanList.size(); i++) {
            Karyawan karyawan = karyawanList.get(i);
            System.out.printf("| %-5s | %-20s | %-15s | %-10s |\n", karyawan.getIdKaryawan(), karyawan.getNamaKaryawan(), karyawan.getJabatan(), karyawan.getDepartemen());
        }

        System.out.println("--------------------------------------------------------");
    }
        
    }
    public static void addDetailOrder() {
    viewOrder();

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter Order ID: ");
    String orderID = scanner.nextLine();

    // Create an ArrayList to store the products
    ArrayList<DetailOrder> detailOrderList = new ArrayList<>();

    // Prompt the user to add products
    boolean addMoreProducts = true;
    while (addMoreProducts) {
        viewProduk();

        System.out.print("Enter the ID of the product: ");
        String idProduk = scanner.nextLine();

        Produk selectedProduk = null;
        for (Produk produk : produkList) {
            if (produk.getIdProduk().equals(idProduk)) {
                selectedProduk = produk;
                break;
            }
        }

        if (selectedProduk != null) {
            System.out.println("Selected Product: " + selectedProduk.getNamaProduk());

            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Check if the entered quantity is available in stock
            if (quantity > selectedProduk.getStokProduk()) {
                System.out.println("Insufficient stock available.");
                continue; // Skip adding this product to the order
            }

            int hargaSatuan = selectedProduk.getHargaProduk();
            int hargaTotal = quantity * hargaSatuan;

            // Deduct the quantity from the stock of the selected product
            selectedProduk.setStokProduk(selectedProduk.getStokProduk() - quantity);

            // Create a new DetailOrder object for the current product and add it to the products ArrayList
            DetailOrder detailOrder = new DetailOrder(orderID, idProduk, quantity, hargaSatuan, hargaTotal);
            detailOrderList.add(detailOrder);
        } else {
            System.out.println("Invalid product ID.");
        }

        System.out.print("Add another product? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("no")) {
            addMoreProducts = false;
        }
    }

    // Calculate the total harga for the order based on the detailOrderList
    int hargaTotal = 0;
    for (DetailOrder detailOrder : detailOrderList) {
        hargaTotal += detailOrder.getHargaTotal();
    }

    // Find the order in the orderList based on the orderID and update the hargaTotal
    for (Order order : orderList) {
        if (order.getOrderID().equals(orderID)) {
            order.setHargaTotal(hargaTotal);
            break;
        }
    }

    System.out.println("Detail Order added successfully!");
}
public static void viewDetailOrder() {
    viewOrder();

    System.out.print("Enter Order ID: ");
    String orderID = scanner.nextLine();

    boolean found = false;

    for (Order order : orderList) {
        if (order.getOrderID().equals(orderID)) {
            found = true;
            List<DetailOrder> detailOrderList = order.getDetailOrderList();

            if (detailOrderList.isEmpty()) {
                System.out.println("No Detail Orders found for this order.");
            } else {
                System.out.println("Detail Orders:");
                System.out.println("--------------------------------------------------------");
                System.out.printf("| %-5s | %-10s | %-8s | %-12s | %-10s |\n",
                        "No", "Product ID", "Quantity", "Unit Price", "Total Price");
                int index = 1;
                for (DetailOrder detailOrder : detailOrderList) {
                    System.out.printf("| %-5d | %-10s | %-8d | %-12d | %-10d |\n",
                            index++, detailOrder.getIdProduk(), detailOrder.getQuantity(),
                            detailOrder.getHargaSatuan(), detailOrder.getHargaTotal());
                }
                System.out.println("--------------------------------------------------------");

                // Calculate the grand total
                int grandTotal = order.getHargaTotal();
                System.out.println("Grand Total: " + grandTotal);
            }
            break;
        }
    }

    if (!found) {
        System.out.println("Invalid Order ID. Order not found.");
    }
}
}






