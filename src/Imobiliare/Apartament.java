package Imobiliare;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Date;

public class Apartament {
    private static Integer index = 1;
    private Integer id = index++;
    private Double pret;
    private Double dimensiune;
    private Date dataOcuparii;
    private CategorieApartament tipApartament;
    private List <Compartiment> compartimente;

    public Apartament(Double pret, Double dimensiune, Date dataOcuparii, CategorieApartament tipApartament) {
        this.pret = pret;
        this.dimensiune = dimensiune;
        this.dataOcuparii = dataOcuparii;
        this.tipApartament = tipApartament;
        this.compartimente = new ArrayList<>();
    }

    public Double getPret() {
        return pret;
    }

    public Double getDimensiune() {
        return dimensiune;
    }

    public Date getDataOcuparii() {
        return dataOcuparii;
    }

    public CategorieApartament getTipApartament() {
        return tipApartament;
    }

    public List<Compartiment> getCompartimente() {
        return Collections.unmodifiableList(compartimente);
    }

    public Integer getNrCompartimente() {
        return compartimente.size();
    }

    public Integer getId() {
        return id;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public void setDimensiune(Double dimensiune) {
        this.dimensiune = dimensiune;
    }

    public void setDataOcuparii(Date dataOcuparii) {
        this.dataOcuparii = dataOcuparii;
    }

    public void setTipApartament(CategorieApartament tipApartament) {
        this.tipApartament = tipApartament;
    }

    public void setCompartimente(List<Compartiment> compartimente) {
        this.compartimente = compartimente;
    }

    public Integer getNrCamere() {
        return compartimente.stream().filter(compartiment ->
                compartiment.getTipCompartiment() == CategorieCompartiment.CAMERA).toArray().length;
    }

    public void adaugaCompartiment(Compartiment compartiment) {
        compartimente.add(compartiment);
    }

    public void afiseazaCompartimente() {
        for (Compartiment compartiment : compartimente) {
            System.out.println(compartiment);
        }
    }

    @Override
    public String toString() {
        return "Apartament{" +
                "id=" + id +
                ", pret=" + pret +
                ", dimensiune=" + dimensiune +
                ", dataOcuparii='" + (dataOcuparii != null? dataOcuparii : "apartamentul nu este ocupat") + '\'' +
                ", tipApartament=" + tipApartament +
                ", compartimente=" + compartimente +
                '}';
    }
}
