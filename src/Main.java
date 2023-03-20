import Imobiliare.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Apartament> apartamente = new ArrayList<>();
        apartamente.add(new Apartament(100.0, 50.0, new Date(2022, Calendar.APRIL, 22), CategorieApartament.DOUACAMERE));
        apartamente.get(0).adaugaCompartiment(new Compartiment("bucatarie", CategorieCompartiment.BUCATARIE));
        apartamente.get(0).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(0).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(0).adaugaCompartiment(new Compartiment("baie", CategorieCompartiment.BAIE));
        apartamente.get(0).adaugaCompartiment(new Compartiment("balcon", CategorieCompartiment.BALCON));

        apartamente.add(new Apartament(200.0, 100.0, new Date(2020, Calendar.APRIL, 12), CategorieApartament.TREICAMERE));
        apartamente.get(1).adaugaCompartiment(new Compartiment("bucatarie", CategorieCompartiment.BUCATARIE));
        apartamente.get(1).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(1).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(1).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(1).adaugaCompartiment(new Compartiment("baie", CategorieCompartiment.BAIE));
        apartamente.get(1).adaugaCompartiment(new Compartiment("balcon", CategorieCompartiment.BALCON));

        apartamente.add(new Apartament(300.0, 150.0, null, CategorieApartament.DUPLEX));
        apartamente.get(2).adaugaCompartiment(new Compartiment("bucatarie", CategorieCompartiment.BUCATARIE));
        apartamente.get(2).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(2).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(2).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(2).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(2).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(2).adaugaCompartiment(new Compartiment("baie", CategorieCompartiment.BAIE));
        apartamente.get(2).adaugaCompartiment(new Compartiment("baie", CategorieCompartiment.BAIE));

        apartamente.add(new Apartament(400.0, 200.0, new Date(2021, Calendar.DECEMBER, 2), CategorieApartament.OPENSPACE));
        apartamente.get(3).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(3).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(3).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(3).adaugaCompartiment(new Compartiment("baie", CategorieCompartiment.BAIE));
        apartamente.get(3).adaugaCompartiment(new Compartiment("balcon", CategorieCompartiment.BALCON));

        apartamente.add(new Apartament(1000.0, 50.0, null, CategorieApartament.DOUACAMERE));
        apartamente.get(4).adaugaCompartiment(new Compartiment("bucatarie", CategorieCompartiment.BUCATARIE));
        apartamente.get(4).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(4).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(4).adaugaCompartiment(new Compartiment("baie", CategorieCompartiment.BAIE));

        apartamente.add(new Apartament(400.0, 200.0, new Date(2022, Calendar.JANUARY, 15), CategorieApartament.OPENSPACE));
        apartamente.get(5).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(5).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(5).adaugaCompartiment(new Compartiment("camera", CategorieCompartiment.CAMERA));
        apartamente.get(5).adaugaCompartiment(new Compartiment("baie", CategorieCompartiment.BAIE));
        apartamente.get(5).adaugaCompartiment(new Compartiment("balcon", CategorieCompartiment.BALCON));

        System.out.println("----Task 1:");
        List<Apartament> apartamenteSortate = sortareApartamente(apartamente);
        System.out.println("Apartamentele sortate dupa numarul de camere:");
        for (Apartament apartament : apartamenteSortate) {
            System.out.println(apartament + ": " + apartament.getNrCamere() + " camere");
        }
        System.out.println("\n");

        System.out.println("----Task 2:");
        utilitatiApartamente(apartamente);
        System.out.println("\n");

        System.out.println("----Task 3:");
        topVanzari(apartamente);
        System.out.println("\n");

        System.out.println("----Task 4:");
        nrCamere(apartamente);
        System.out.println("\n");
    }

    static List<Apartament> sortareApartamente(List<Apartament> apartamente) {
        return apartamente.stream().sorted((a1,a2) -> a1.getNrCamere().compareTo(a2.getNrCamere())).toList();
    }

    static void utilitatiApartamente(List<Apartament> apartamente) {
        for (Apartament apartament : apartamente) {
            System.out.println("Apartamentul " + apartament.getId() + ": ");
            apartament.getCompartimente().forEach(c -> System.out.println("    Compartimentul " +
                    c.getTipCompartiment() + " are utilitatile: " + c.getUtilitati()));
        }
    }

    static void topVanzari(List<Apartament> apartamente) {
        Map<CategorieApartament, Long> topVanzari = apartamente.stream()
                .filter(a -> a.getDataOcuparii() != null)
                .collect(Collectors.groupingBy(Apartament::getTipApartament, Collectors.counting()));
        System.out.println("Top vanzari: ");
        topVanzari.entrySet().stream()
                        .sorted((c1,c2) -> c2.getValue().compareTo(c1.getValue())).forEach(c ->
                        System.out.println(c.getKey() + ": " + c.getValue()));
    }

    static void nrCamere(List<Apartament> apartamente) {
        Map<Integer, Long> grupareNrCamere = apartamente.stream()
                        .collect(Collectors.groupingBy(Apartament::getNrCamere, Collectors.counting()));
        grupareNrCamere.entrySet().stream()
                        .forEach(c -> System.out.println("Apartamente cu " + c.getKey() + " camere: " + c.getValue()));
    }
}