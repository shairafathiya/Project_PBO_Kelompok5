import java.util.ArrayList;

public class Customer extends Akun {
    private Keranjang keranjang;
    private ArrayList<Invoice> invoiceSelesai;

    public Customer(String id, String username, String password) {
        super(id, username, password);
        this.keranjang = new Keranjang();
        this.invoiceSelesai = new ArrayList<>();
    }

    public Keranjang getKeranjang() {
        return keranjang;
    }

    public ArrayList<Invoice> getInvoiceSelesai() {
        return invoiceSelesai;
    }

    @Override
    public void menu() {
        System.out.println("Customer Menu:");
        System.out.println("1. Lihat Barang");
        System.out.println("2. Tambah ke Keranjang");
        System.out.println("3. Lihat Keranjang");
        System.out.println("4. Checkout");
        System.out.println("5. Lihat Riwayat Belanja");
        System.out.println("6. Keluar");
    }
}
