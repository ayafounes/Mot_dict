public class Dictionnaire {
    private int nb_mots;
    Mon_dict dict[];
    private String nom;

    public Dictionnaire(int nb, String nom) {
        this.nb_mots = nb;
        this.nom = nom;
        dict = new Mon_dict[100];
    }

    public void ajouter_mot(Mon_dict mot) {
        if (nb_mots < dict.length) {
            dict[nb_mots] = mot;
            nb_mots++;
        } else {
            System.out.println("Le dictionnaire est plein.");
        }
    }

    void trier() {
        for (int i = 1; i < this.nb_mots; i++) {
            Mon_dict ch = dict[i];
            int j = i - 1;
            while (j >= 0 && dict[j] != null && dict[j].getMot().compareTo(ch.getMot()) > 0) {
                dict[j + 1] = dict[j];
                j = j - 1;
            }
            dict[j + 1] = ch;
        }
    }


    void supprimer(Mon_dict mot) {
        int index = -1;
        for (int i = 0; i < nb_mots; i++) {
            if (dict[i] != null && dict[i].getMot().equals(mot.getMot())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < nb_mots - 1; i++) {
                dict[i] = dict[i + 1]; 
            }
            dict[nb_mots - 1] = null; 
            nb_mots--;
        } else {
            System.out.println("Mot non trouvé.");
        }
    }


    public String recherche_dicho(String mott) {
        int g = 0;
        int d = nb_mots - 1;
        while (g <= d) {
            int milieu = g + (d - g) / 2;
            Mon_dict mot = dict[milieu];
            int comparaison = mot.getMot().compareTo(mott);
            if (comparaison == 0) {
                return mot.getDefinition();
            } else if (comparaison > 0) {
                d = milieu - 1;
            } else {
                g = milieu + 1;
            }
        }
        return "Mot non trouvé.";
    }

    public void lister_dict() {
        for (int i = 0; i < nb_mots; i++) { 
            if (dict[i] != null) { 
                Mon_dict mot = dict[i];
                System.out.println(mot.getMot() + " | " + mot.getDefinition());
            }
        }
    }

    public int nbr_synonyme(Mon_dict m) {
        int nb = 0;
        for (int i = 0; i < nb_mots; i++) {
            if (m.synonyme(dict[i])) {
                nb++;
            }
        }
        return nb;
    }
}
