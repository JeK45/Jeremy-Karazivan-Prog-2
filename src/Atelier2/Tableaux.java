package Atelier2;

public class Tableaux {
    public Tableaux() {

    }

    static int[] TriCroissantSSS(int[] tab) {
        int imin;
        int tmp;

        for (int i = 0; i < tab.length - 1; i++) {
            imin = i;
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[j] < tab[imin]) {
                    imin = j;
                }
            }
            if (imin != i) {
                tmp = tab[i];
                tab[i] = tab[imin];
                tab[imin] = tmp;
            }
        }
        return tab;
    }

//    static int[] TriCroissantSSS(String[] tab) {
//        int imin;
//        int tmp;
//
//        for (int i = 0; i < tab.length - 1; i++) {
//            imin = i;
//            for (int j = i + 1; j < tab.length; j++) {
//                if (tab[j] < tab[imin]) {
//                    imin = j;
//                }
//            }
//            if (imin != i) {
//                tmp = tab[i];
//                tab[i] = tab[imin];
//                tab[imin] = tmp;
//            }
//        }
//        return tab;
//    }

    static int[] TriDecroissantSSS(int[] tab) {
        int imin;
        int tmp;

        for (int i = 0; i < tab.length - 1; i++) {
            imin = i;
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[j] > tab[imin]) {
                    imin = j;
                }
            }
            if (imin != i) {
                tmp = tab[i];
                tab[i] = tab[imin];
                tab[imin] = tmp;
            }
        }
        return tab;
    }

    static int maximum(int[] liste) {
        int max = liste[0];
        for (int i: liste) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    static int minimum(int[] liste) {
        int min = liste[0];
        for (int i: liste) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    static int somme(int[] liste) {
        int somme = 0;
        for (int elem: liste) {
            somme += elem;
        }
        return somme;
    }

    static double moyenne(int[] liste) {
        int somme = 0;
        for (int elem: liste) {
            somme += elem;
        }
        return (double) somme / (double) liste.length;
    }

    static int fouilleSeq(int[] liste, int recherche) {
        int i = 0;
        while (i < liste.length && liste[i] != recherche) {
            i++;
        }
        return i >= liste.length ? -1 : i;
    }
}
