package fr.formation.views;


public class Views {

	public static class Common {
	}
	public static class Categorie extends Common {
	}
	public static class Etape extends Common {
	}
	public static class Idee extends Common {
	}
	public static class Modele extends Common {
	}
	public static class Utilisateur extends Common {
	}
	public static class Note extends Common {
	}
	public static class ModeleWithNotes extends Modele {
	}
	public static class ModeleWithCategories extends Modele {
	}
	public static class ModeleWithEtapes extends Modele {
	}
	public static class CategorieWithModeles extends Categorie {
	}
	public static class CategorieWithEnfants extends Categorie {
	}
}
