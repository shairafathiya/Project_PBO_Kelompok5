import java.util.Scanner;

public class CustomerDriver extends Driver {
    // Mengelola interaksi customer dengan barang dan admin
    private ListBarang listBarang;
    private AdminDriver adminDriver;

    // Menginisialisasi customer, daftar barang, dan admin
    public CustomerDriver(Customer customer, ListBarang listBarang, AdminDriver adminDriver) {
        super(customer);
        this.listBarang = listBarang;
        this.adminDriver = adminDriver;
    }

    // Menu utama customer
    @Override
    public void handleMenu() {
        Scanner sc = new Scanner(System.in);
        Customer customer = (Customer) akun;

        while (true) {
            customer.menu();
            System.out.print("Pilih: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            // Switch case untuk menangani pilihan menu
            switch (choice) {
                case 1:
                    // Menampilkan daftar barang
                    System.out.println(listBarang);
                    System.out.println("Daftar Barang:");
                    System.out.println("+----------+----------------------+----------------------+");
                    System.out.printf("| %-8s | %-20s | %-20s |\n", "ID", "Nama Barang", "Harga Barang");
                    System.out.println("+----------+----------------------+----------------------+");
                    for (Barang barang : listBarang.getBarangList()) { // Pastikan ada metode getBarangList() di ListBarang
                        System.out.printf("| %-8s | %-20s | %-20.2f |\n",
                        barang.getId(), barang.getNama(), barang.getHarga());
                    }
                    System.out.println("+----------+----------------------+----------------------+");
                    break;
                case 2:
                    // Menambahkan barang ke keranjang customer
                    System.out.print("ID Barang: ");
                    String idBarang = sc.nextLine();
                    Barang barang = listBarang.getBarang(idBarang);
                    if (barang != null) {
                        customer.getKeranjang().addBarang(barang);
                        System.out.println("Barang berhasil ditambahkan ke keranjang.");
                    } else {
                        System.out.println("Barang tidak ditemukan.");
                    }
                    break;
                case 3:
                    // Menampilkan isi keranjang customer
                    System.out.println("Keranjang:");
                    if (customer.getKeranjang().getBarang().isEmpty()) {
                        System.out.println("Keranjang kosong.");
                    } else {
                        System.out.println("+----------+----------------------+----------------------+");
                        System.out.printf("| %-8s | %-20s | %-20s |\n", "ID", "Nama Barang", "Harga Barang" );
                        System.out.println("+----------+----------------------+----------------------+");
                        for (Barang item : customer.getKeranjang().getBarang()) { // Ganti nama variabel
                            System.out.printf("| %-8s | %-20s | %-20.2f |\n",
                                    item.getId(), item.getNama(), item.getHarga());
                        }
                        System.out.println("+----------+----------------------+----------------------+");
                    }
                    break;
                case 4:
                    // Proses check out dan pembayaran
                    if (customer.getKeranjang().getBarang().isEmpty()) {
                        System.out.println("Keranjang kosong.");
                    } else {
                        System.out.println("Pilih metode pembayaran: ");
                        System.out.println("1. QRIS");
                        System.out.println("2. Bank");
                        System.out.println("3. COD");
                        System.out.print("Pilihan Anda: ");
                        int metode = sc.nextInt();
                        Pembayaran pembayaran;
                        switch (metode) {
                            case 1:
                                pembayaran = new QRIS();
                                break;
                            case 2:
                                pembayaran = new Bank();
                                break;
                            case 3:
                                pembayaran = new COD();
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                                continue;
                        }
                        System.out.println("Pembayaran melalui " + pembayaran + " diterima.");

                        // Membuat transaksi dan invoice setelah pembayaran diterima
                        Transaksi transaksi = new Transaksi(customer, customer.getKeranjang().getBarang());
                        Invoice invoice = new Invoice(transaksi, pembayaran);
                        customer.getInvoiceSelesai().add(invoice);
                        adminDriver.approveTransaksi(transaksi);
                        customer.getKeranjang().clear();
                        System.out.println("Checkout berhasil.");
                    }
                    break;
                case 5:
                    // Menampilkan riwayat transaksi (invoice) customer
                    for (Invoice invoice : customer.getInvoiceSelesai()) {
                        System.out.println(invoice);
                    }
                    break;
                case 6:
                    // Logout dari sistem
                    System.out.println("Logout...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
