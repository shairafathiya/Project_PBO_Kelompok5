import java.util.ArrayList;
import java.util.Scanner;

public class AdminDriver extends Driver {
    private ListBarang listBarang;
    private ArrayList<Transaksi> listTransaksi;

    public AdminDriver(Admin admin, ListBarang listBarang) {
        super(admin);
        this.listBarang = listBarang;
        this.listTransaksi = new ArrayList<>();
    }

    @Override
    public void handleMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            akun.menu();
            System.out.print("Pilih: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Nama Barang: ");
                    String nama = sc.nextLine();
                    System.out.print("Harga: ");
                    double harga = sc.nextDouble();
                    listBarang.addBarang(new Barang(listBarang.generateId(), nama, harga));
                    System.out.println("Barang berhasil ditambahkan.");
                    break;
                case 2:
                    System.out.print("ID Barang: ");
                    String idHapus = sc.nextLine();
                    if (listBarang.removeBarang(idHapus)) {
                        System.out.println("Barang berhasil dihapus.");
                    } else {
                        System.out.println("Barang tidak ditemukan.");
                    }
                    break;
                case 3:
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
                    System.out.println(listBarang);
                    break;
                case 5:
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
                    System.out.println("An error occurred: " + e.getMessage());
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

    public void approveTransaksi(Transaksi transaksi) {
        listTransaksi.add(transaksi);
        System.out.println("Transaksi diterima.");
    }
}
