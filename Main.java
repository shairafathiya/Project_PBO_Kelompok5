import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Setup data awal
        ListBarang listBarang = new ListBarang();
        Admin admin = new Admin("A1", "admin", "admin123");
        AdminDriver adminDriver = new AdminDriver(admin, listBarang);

        // Setup Barang
        listBarang.addBarang(new Barang(listBarang.generateId(), "Charger", 50000));
        listBarang.addBarang(new Barang(listBarang.generateId(), "Casing Smartphone", 14000));
        listBarang.addBarang(new Barang(listBarang.generateId(), "Earphone", 350000));
        listBarang.addBarang(new Barang(listBarang.generateId(), "USB", 140000));

        Customer customer = new Customer("C1", "customer", "customer123");
        CustomerDriver customerDriver = new CustomerDriver(customer, listBarang, adminDriver);

        Scanner scanner = new Scanner(System.in);

        // Menu Login
        while (true) {
            System.out.println("======= Pilih Menu =======");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Customer");
            System.out.println("3. Keluar");
            System.out.println("==========================");
            System.out.print("Pilih: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            if (pilihan == 1) {
                // Login sebagai Admin
                System.out.println("~~~ Login sebagai Admin ~~~");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                    adminDriver.handleMenu();

                } else {
                    System.out.println("Username atau password salah.");
                }
            } else if (pilihan == 2) {
                // Login sebagai Customer
                System.out.println("=== Login sebagai Customer ===");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                if (username.equals(customer.getUsername()) && password.equals(customer.getPassword())) {
                    customerDriver.handleMenu();
                } else {
                    System.out.println("Username atau password salah.");
                }
            } else if (pilihan == 3) {
                // Keluar dari aplikasi
                System.out.println("Terima kasih! Program akan keluar.");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        }
    }
}

