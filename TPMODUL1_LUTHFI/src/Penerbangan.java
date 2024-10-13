public class Penerbangan {
    private final String nomorPenerbangan, bandaraKeberangkatan, bandaraTujuan, waktuKeberangkatan, waktuKedatangan;
    private final float hargaTiket;

    public Penerbangan(String nomorPenerbangan, String bandaraKeberangkatan, 
                       String bandaraTujuan, String waktuKeberangkatan, 
                       String waktuKedatangan, float hargaTiket) {
        this.nomorPenerbangan = nomorPenerbangan;
        this.bandaraKeberangkatan = bandaraKeberangkatan;
        this.bandaraTujuan = bandaraTujuan;
        this.waktuKeberangkatan = waktuKeberangkatan;
        this.waktuKedatangan = waktuKedatangan;
        this.hargaTiket = hargaTiket;
    }

    public void tampilDaftarPenerbangan(int index) {
        System.out.println((index + 1) + ". Nomor Penerbangan: " + nomorPenerbangan);
        System.out.println("Bandara: " + bandaraKeberangkatan + " --> " + bandaraTujuan);
        System.out.println("Waktu: " + waktuKeberangkatan + " ---> " + waktuKedatangan);
        System.out.println("Harga Tiket: Rp." + hargaTiket);
        System.out.println("---------------------------------------------");
    }

    public String getNomorPenerbangan() {
        return nomorPenerbangan;
    }

    public float getHargaTiket() {
        return hargaTiket;
    }
}
