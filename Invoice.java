import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// Kelas Invoice merepresentasikan tagihan untuk transaksi tertentu.
// Kelas ini menyimpan detail transaksi dan metode pembayaran yang digunakan.
public class Invoice {
    private Transaksi transaksi;
    private Pembayaran pembayaran;

    // Konstruktor kelas Invoice.
    public Invoice(Transaksi transaksi, Pembayaran pembayaran) {
        this.transaksi = transaksi;
        this.pembayaran = pembayaran;
    }

    // Override method toString() untuk memberikan representasi string dari objek Invoice.
    // Method ini juga menulis isi invoice ke dalam file "Invoice.txt".
    @Override
    public String toString() {
         try (BufferedWriter catat  = new BufferedWriter(new FileWriter("Invoice.txt"))) {
           catat.write("Invoice:\n" +transaksi + "Metode Pembayaran: " + pembayaran);

        } catch (IOException ex) {
        }
           
        // Mengembalikan representasi string dari invoice untuk ditampilkan di konsol atau digunakan di tempat lain.
        return "Invoice:\n" + transaksi + "Metode Pembayaran: " + pembayaran;
    }
}

