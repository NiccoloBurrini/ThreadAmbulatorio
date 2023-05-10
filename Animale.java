public class Animale extends Thread {
    private Ambulatorio ambulatorio;
    private String tipo = "";

    public Animale(String nome, String tipo, Ambulatorio ambulatorio) {
        super(nome);
        this.tipo = tipo;
        this.ambulatorio = ambulatorio;
    }

    public String getTipo() {
        return this.tipo;
    }

    @Override
    public void run() {
        long tempoInAmbulatorio = (int) (Math.random() * 3000) + 1;
        ambulatorio.join(getTipo());
        try {
            Thread.sleep(tempoInAmbulatorio);
        } catch (InterruptedException e) {
        }
        ambulatorio.leave(getTipo());
    }
}
