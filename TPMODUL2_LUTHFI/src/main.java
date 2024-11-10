public class main {
    public static void main(String[] args) {
        hewan hewan = new hewan("hewan MAGNUS", 5);
        hewan.suara();
        hewan.makan();
        hewan.makan("rumput");
        hewan.infoHewan();

        System.out.println();

        kucing kucing = new kucing("Luna", 2, "Persia");
        kucing.suara();
        kucing.infoHewan();

        System.out.println();

        burung burung = new burung("Cici", 1, "Kuning");
        burung.suara();
        burung.infoHewan();
    }
}
