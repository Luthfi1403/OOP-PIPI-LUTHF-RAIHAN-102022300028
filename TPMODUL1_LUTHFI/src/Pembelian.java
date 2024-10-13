import java.util.*;

public class Pembelian {
    public static void main(String[] args) {
        List<Penerbangan> daftarPenerbangan = Arrays.asList(
            new Penerbangan("GA101", "CGK, Jakarta", "DPS, Bali", "06:30", "08:15", 1200000),
            new Penerbangan("QZ202", "SUB, Surabaya", "KNO, Medan", "09:00", "11:45", 1350000)
        );
        
        Scanner scanner = new Scanner(System.in);
        Penumpang penumpang = null;
        Penerbangan penerbanganDipilih = null;
        int pilihan;
        
        do {
            System.out.println("======= EAD Ticket Booking System =======");
            System.out.println("1. Tampilkan Daftar Penerbangan");
            System.out.println("2. Beli Tiket");
            System.out.println("3. Tampilkan Pesanan Tiket");
            System.out.println("4. Exit");
            System.out.print("Silahkan pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline setelah nextInt
            
            switch (pilihan) {
                case 1 -> daftarPenerbangan.forEach(p -> p.tampilDaftarPenerbangan(daftarPenerbangan.indexOf(p)));
                
                case 2 -> {
                    if (penumpang == null) {
                        System.out.println("\nSilakan isi data diri anda terlebih dahulu!");
                        System.out.print("Masukkan NIK: ");
                        String NIK = scanner.nextLine();
                        System.out.print("Masukkan Nama Depan: ");
                        String namaDepan = scanner.nextLine();
                        System.out.print("Masukkan Nama Belakang: ");
                        String namaBelakang = scanner.nextLine();
                        penumpang = new Penumpang(NIK, namaDepan, namaBelakang);
                        System.out.println("Data pelanggan berhasil diisi.");
                    }

                    System.out.println("\n== Daftar Penerbangan ==");
                    daftarPenerbangan.forEach(p -> p.tampilDaftarPenerbangan(daftarPenerbangan.indexOf(p)));
                    System.out.print("Pilih nomor penerbangan: ");
                    int nomor = scanner.nextInt() - 1;

                    if (nomor >= 0 && nomor < daftarPenerbangan.size()) {
                        penerbanganDipilih = daftarPenerbangan.get(nomor);
                        System.out.println("Pemesanan tiket berhasil!");
                    } else {
                        System.out.println("Nomor penerbangan tidak valid!");
                    }
                }
                
                case 3 -> {
                    if (penerbanganDipilih != null && penumpang != null) {
                        System.out.println("======= Detail Tiket Penerbangan =======");
                        penumpang.tampilDetailPenumpang();
                        System.out.println("Nomor Penerbangan: " + penerbanganDipilih.getNomorPenerbangan());
                        System.out.println("Harga Tiket: Rp." + penerbanganDipilih.getHargaTiket());
                    } else {
                        System.out.println("Pembelian tiket tidak ada.");
                    }
                }
                
                case 4 -> System.out.println("Terima kasih!");
                
                default -> System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (pilihan != 4);
    }
}

// Class Penerbangan
class Penerbangan {
    private String nomorPenerbangan, bandaraKeberangkatan, bandaraTujuan, waktuKeberangkatan, waktuKedatangan;
    private float hargaTiket;

    public Penerbangan(String nomorPenerbangan, String bandaraKeberangkatan, String bandaraTujuan, 
                       String waktuKeberangkatan, String waktuKedatangan, float hargaTiket) {
        this.nomorPenerbangan = nomorPenerbangan;
        this.bandaraKeberangkatan = bandaraKeberangkatan;
        this.bandaraTujuan = bandaraTujuan;
        this.waktuKeberangkatan = waktuKeberangkatan;
        this.waktuKedatangan = waktuKedatangan;
        this.hargaTiket = hargaTiket;
    }

    public void tampilDaftarPenerbangan(int index) {
        System.out.println((index + 1) + ". " + nomorPenerbangan + " | " + bandaraKeberangkatan + " -> " 
                            + bandaraTujuan + " | " + waktuKeberangkatan + " - " + waktuKedatangan + " | Rp." + hargaTiket);
    }

    public String getNomorPenerbangan() {
        return nomorPenerbangan;
    }

    public float getHargaTiket() {
        return hargaTiket;
    }
}

// Class Penumpang
class Penumpang {
    private String NIK, namaDepan, namaBelakang;

    public Penumpang(String NIK, String namaDepan, String namaBelakang) {
        this.NIK = NIK;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
    }

    public void tampilDetailPenumpang() {
        System.out.println("Penumpang: " + namaDepan + " " + namaBelakang + " | NIK: " + NIK);
    }
}
