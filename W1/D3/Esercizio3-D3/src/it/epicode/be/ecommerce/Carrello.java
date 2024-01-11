package it.epicode.be.ecommerce;

public class Carrello {

    private Cliente cliente;
    private Articolo[] elencoArticoli;

    public Carrello(Cliente c) {
        this.cliente = c;
        this.elencoArticoli = new Articolo[0];
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Articolo[] getElencoArticoli() {
        return elencoArticoli;
    }

    public void setElencoArticoli(Articolo[] elencoArticoli) {
        this.elencoArticoli = elencoArticoli;
    }

    public double getTotaleCostoArticoli() {
        double totale = 0;
        for (int i = 0; i < elencoArticoli.length; i++) {
            int disponibilità = elencoArticoli[i].getNumeroPezziInMagazzino();
            System.out.println(elencoArticoli[i].getNumeroPezziInMagazzino());
            if (disponibilità == 0) {
                System.out.println("Abbiamo terminato la disponibilità di: " + elencoArticoli[i].getCodice());
                continue;
            } else {
                totale += elencoArticoli[i].getPrezzo();
            }

        }
        return totale;
    }
}
