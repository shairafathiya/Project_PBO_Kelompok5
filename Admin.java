public class Admin extends Akun {
    public Admin(String id, String username, String password) {
        super(id, username, password);
    }

    @Override
    public void menu() {
        System.out.println("Admin Menu:");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Hapus Barang");
        System.out.println("3. Edit Barang");
        System.out.println("4. Lihat Barang");
        System.out.println("5. Lihat Transaksi");
        System.out.println("6. Keluar");
    }
}
