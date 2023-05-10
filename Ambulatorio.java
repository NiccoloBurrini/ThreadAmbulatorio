public class Ambulatorio {
    private int max_gatti;
    private int max_cani;

    private int num_cani;
    private int num_gatti;

    private int numGattiAttesa = 0;

    Ambulatorio(int max_cani, int max_gatti) {
        this.max_cani = max_cani;
        this.max_gatti = max_gatti;
        this.num_cani = 0;
        this.num_gatti = 0;
    }

    public synchronized void join(String tipo) {
        // CANI E GATTI INSIEME NO
        // PRIORITA' AI GATTI
        // String name = Thread.currentThread().getName();

        System.out.println("");
        if (tipo.equals("gatto")) {
            numGattiAttesa++;
        }

        while (tipo.equals("cane") && num_gatti > 0 || tipo.equals("gatto") && num_cani > 0
                || numGattiAttesa > 0 && tipo.equals("cane") || num_gatti >= max_gatti || num_cani >= max_cani) {

            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        // cane o gatto entra
        System.out.println("ENTRA " + tipo);
        if (tipo.equals("cane"))
            num_cani++;
        else
            num_gatti++;

    }

    public synchronized void leave(String tipo) {
        // String name = Thread.currentThread().getName();
        System.out.println("ESCE " + tipo);
        if (tipo.equals("gatto")) {
            numGattiAttesa--;
            num_gatti--;
        } else {
            num_cani--;
        }
        notifyAll();
    }

}
