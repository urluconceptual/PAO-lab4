package Imobiliare;

public class Compartiment {
    private String utilitati;
    private CategorieCompartiment tipCompartiment;

    public Compartiment(String utilitati, CategorieCompartiment tipCompartiment) {
        this.utilitati = utilitati;
        this.tipCompartiment = tipCompartiment;
    }

    public String getUtilitati() {
        return utilitati;
    }

    public CategorieCompartiment getTipCompartiment() {
        return tipCompartiment;
    }

    public void setTipCompartiment(CategorieCompartiment tipCompartiment) {

        this.tipCompartiment = tipCompartiment;
    }

    public void setUtilitati(String utilitati) {
        this.utilitati = utilitati;
    }

    @Override
    public String toString() {
        return "Compartiment{" +
                "utilitati='" + utilitati + '\'' +
                ", tipCompartiment=" + tipCompartiment +
                '}';
    }
}
