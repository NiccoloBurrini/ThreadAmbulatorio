public class App {
    public static void main(String[] args) throws Exception {
        Ambulatorio a1 = new Ambulatorio(1, 1);
        Animale cane1 = new Animale("Fuffi", "cane", a1);
        Animale gatto1 = new Animale("rob", "gatto", a1);
        Animale gatto2 = new Animale("rr", "gatto", a1);
        Animale cane2 = new Animale("sin", "cane", a1);

        cane1.start();
        gatto1.start();
        gatto2.start();
        cane2.start();
    }
}
