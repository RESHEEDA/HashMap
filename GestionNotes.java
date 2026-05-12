import java.util.HashMap;
public class GestionNotes {
    private HashMap<String, Double> notesEtudiants;
    public GestionNotes() {
        notesEtudiants = new HashMap<>();
    }

    public void ajouterEtudiant(String nom, double note) {
        notesEtudiants.put(nom, note);
        System.out.println("\tL'étudiant " + nom + " de la note : " + note);
    }

    public void afficherToutesLesNotes() {
        if (notesEtudiants.isEmpty()) {
            System.out.println("Aucun étudiant dans la liste.");
            return;
        }
        System.out.println("\nLa liste des notes des étudiants");
        for (String nom : notesEtudiants.keySet()) {
            System.out.println(nom + " : " + notesEtudiants.get(nom));
        }
    }

    public void rechercherNote(String nom) {
        if (notesEtudiants.containsKey(nom)) {
            System.out.println("La note de " + nom + " : " + notesEtudiants.get(nom));
        } else {
            System.out.println("L'étudiant " + nom + " non trouvé.");
        }
    }

    public void modifierNote(String nom, double nouvelleNote) {
        if (notesEtudiants.containsKey(nom)) {
            notesEtudiants.put(nom, nouvelleNote);
            System.out.println("La note de " + nom + " modifiée est : " + nouvelleNote);
        } else {
            System.out.println("L'étudiant de nom " + nom + " est non trouvé. Impossible de modifier.");
        }
    }

    public void supprimerEtudiant(String nom) {
        if (notesEtudiants.containsKey(nom)) {
            notesEtudiants.remove(nom);
            System.out.println("L'étudiant de nom " + nom + " est supprimé.");
        } else {
            System.out.println("L'étudiant de nom " + nom + " est non trouvé. Impossible de supprimer.");
        }
    }

    public void calculerMoyenneGenerale() {
        if (notesEtudiants.isEmpty()) {
            System.out.println("Aucun étudiant, moyenne impossible à calculer.");
            return;
        }
        double somme = 0;
        for (double note : notesEtudiants.values()) {
            somme += note;
        }
        double moyenne = somme / notesEtudiants.size();
        System.out.println("La moyenne générale de la classe est : " + String.format("%.2f", moyenne));
    }

    public static void main(String[] args) {
        GestionNotes gestion = new GestionNotes();
        
        System.out.println("L'ajout des étudiants");
        gestion.ajouterEtudiant("Ali AL", 15.5);
        gestion.ajouterEtudiant("Karim KR", 12.0);
        gestion.ajouterEtudiant("Sara SR", 17.5);
        gestion.ajouterEtudiant("Mohemed MH", 10.25);
        gestion.ajouterEtudiant("Youssef YS", 20.75);
        gestion.ajouterEtudiant("Marouan MR", 14.0);

        gestion.afficherToutesLesNotes();
        
        System.out.println("\nLa recherche des notes");
        gestion.rechercherNote("Youssef YS");
        gestion.rechercherNote("Laila LA");
        
        System.out.println("\nModification de la note");
        gestion.modifierNote("Mona MN", 18.0);
        
        System.out.println("\nSuppression d'étudiant");
        gestion.supprimerEtudiant("Karim KR");
        
        System.out.println("\nCalcul de la moyenne");
        gestion.calculerMoyenneGenerale();
        
        gestion.afficherToutesLesNotes();
        
    }
}