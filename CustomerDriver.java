import java.util.Scanner;

public class CustomerDriver extends Driver {
    private ListBarang listBarang;
    private AdminDriver adminDriver;

    public CustomerDriver(Customer customer, ListBarang listBarang, AdminDriver adminDriver) {
        super(customer);
        this.listBarang = listBarang;
        this.adminDriver = adminDriver;
    }

    @Override
    public void handleMenu() {
        Scanner sc = new Scanner(System.in);
        Customer customer = (Customer) akun;

        while (true) {
            customer.menu();
            System.out.print("Pilih: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println(listBarang);
                    System.out.println("Daftar Barang:");
                    System.out.println("+----------+----------------------+------------+----------+");
                    System.out.printf("| %-8s | %-20s | %-20s |\n", "ID", "Nama Barang", "Harga Barang");
                    System.out.println("+----------+----------------------+------------+----------+");
                    for (Barang barang : listBarang.getBarangList()) { // Pastikan ada metode getBarangList() di ListBarang
                        System.out.printf("| %-8s | %-20s | %-20.2f |\n",
                        barang.getId(), barang.getNama(), barang.getHarga());
                    }
                    System.out.println("+----------+----------------------+------------+----------+");
                    break;
                case 2:
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
                    System.out.println(customer.getKeranjang());
                    break;
                case 4:
                    if (customer.getKeranjang().getBarang().isEmpty()) {
                        System.out.println("Keranjang kosong.");
                    } else {
                        System.out.println("Pilih metode pembayaran: 1. QRIS, 2. Bank, 3. COD");
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
                        Transaksi transaksi = new Transaksi(customer, customer.getKeranjang().getBarang());
                        Invoice invoice = new Invoice(transaksi, pembayaran);
                        customer.getInvoiceSelesai().add(invoice);
                        adminDriver.approveTransaksi(transaksi);
                        customer.getKeranjang().clear();
                        System.out.println("Checkout berhasil.");
                    }
                    break;
                case 5:
                    for (Invoice invoice : customer.getInvoiceSelesai()) {
                        System.out.println(invoice);
                    }
                    break;
                case 6:
                    System.out.println("Logout...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
