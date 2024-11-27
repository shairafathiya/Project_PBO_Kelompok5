import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class AdminDriver extends Driver {
    // Mengelola data barang dan transaksi
    private ListBarang listBarang;
    private ArrayList<Transaksi> listTransaksi;
    private static final String invoice = "Invoice.txt";

    // Menginisialisasi admin dan daftar barang
    public AdminDriver(Admin admin, ListBarang listBarang) {
        super(admin);
        this.listBarang = listBarang;
        this.listTransaksi = new ArrayList<>();
    }

    // Menu utama admin
    @Override
    public void handleMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            akun.menu();
            System.out.print("Pilih: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            // Switch case untuk menangani berbagai pilihan menu
            switch (choice) {
                case 1:
                    // Menambah barang baru ke list
                    System.out.print("Nama Barang: ");
                    String nama = sc.nextLine();
                    System.out.print("Harga: ");
                    double harga = sc.nextDouble();
                    listBarang.addBarang(new Barang(listBarang.generateId(), nama, harga));
                    System.out.println("Barang berhasil ditambahkan.");
                    break;
                case 2:
                    // Menghapus barang berdasarkan ID
                    System.out.print("ID Barang: ");
                    String idHapus = sc.nextLine();
                    if (listBarang.removeBarang(idHapus)) {
                        System.out.println("Barang berhasil dihapus.");
                    } else {
                        System.out.println("Barang tidak ditemukan.");
                    }
                    break;
                case 3:
                    // Mengedit harga barang berdasarkan ID
                    System.out.print("ID Barang: ");
                    String idEdit = sc.nextLine();
                    System.out.print("Harga Baru: ");
                    double hargaBaru = sc.nextDouble();
                    if (listBarang.editHarga(idEdit, hargaBaru)) {
                        System.out.println("Harga barang berhasil diperbarui.");
                    } else {
                        System.out.println("Barang tidak ditemukan.");
                    }
                    break;
                case 4:
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
                    
                case 5:
                    // Membaca dan menampilkan data invoice dari file
                     try (BufferedReader baca = new BufferedReader(new FileReader(invoice))) {
                    String line;
                    boolean isEmpty = true;
            
                    while ((line = baca.readLine()) != null) {
                        System.out.println(line);
                        isEmpty = false;
                    }
            
                    if (isEmpty) {
                        System.out.println("Belum ada transaksi.");
                    }
                } catch (Exception e) {
                    System.out.println("Belum ada transaksi (File tidak ditemukan). " + e.getMessage());
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

    public void approveTransaksi(Transaksi transaksi) {
        listTransaksi.add(transaksi);
        System.out.println("Transaksi diterima.");
    }
}
