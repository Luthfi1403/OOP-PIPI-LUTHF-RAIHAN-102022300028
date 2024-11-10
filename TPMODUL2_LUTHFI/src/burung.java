public class burung extends hewan {
    private final String warnaBulu;

    public burung(String nama, int umur, String warnaBulu) {
        super(nama, umur);
        this.warnaBulu = warnaBulu;
    }

    @Override
    public void suara() {
        System.out.println(nama + " berkicau.");
    }

    @Override
    public void infoHewan() {
        System.out.println("Nama: " + nama + ", Umur: " + umur + " tahun, Warna Bulu: " + warnaBulu);
    }
}
