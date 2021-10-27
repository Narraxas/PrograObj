import java.time.LocalDate;

public class ManipulationEtudiant {
	public static void main (String[]args)
	{
		Promotion P2016 = new Promotion(2016);
		System.out.println(P2016);
		Promotion P2021 = new Promotion();

		Etudiant samia = new Etudiant("Ferdjoukh", 2000, ModalitéRecrutement.parcoursSup);
		Etudiant antoine = new Etudiant("Bertier", 2001, ModalitéRecrutement.eCandidat);
		samia.setNote(19, 0);
		samia.setNote(12, 1);
		samia.setNote(16, 2);
		antoine.setNote(17, 0);
		antoine.setNote(2, 1);
		antoine.setNote(0, 2);

		P2021.inscrire(samia);
		P2021.inscrire(antoine);

		System.out.println(P2021);
		System.out.println("Nbre admis : " + P2021.admis());
		System.out.println("Moyenne generale : " + P2021.moyenneGenerale());
		System.out.println("Majors : " + P2021.majors().toString());
		System.out.println("Etudiants venant de l'exterieur "
		                        + P2021.populationIssueDeRecrutementExterieur().toString());
	}
}