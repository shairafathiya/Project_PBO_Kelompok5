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

        Customer customer = new Customer("C1", "customer1", "customer123");
        CustomerDriver customerDriver = new CustomerDriver(customer, listBarang, adminDriver);

        Scanner scanner = new Scanner(System.in);

        // Menu Login
        while (true) {
            System.out.println("=== Login ===");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                // Login as Admin
                adminDriver.handleMenu();
            } else if (username.equals(customer.getUsername()) && password.equals(customer.getPassword())) {
                // Login as Customer
                customerDriver.handleMenu();
            } else {
                System.out.println("Username atau password salah.");
            }
            scanner.close();
        }
    }
}
