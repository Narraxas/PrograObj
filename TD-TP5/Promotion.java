
import java.util.*;

public class Promotion {

	// ATTRIBUTS
	private ArrayList<Etudiant> _etudiants = new ArrayList<Etudiant>();
	private int _annee;

	// CONSTRUCTEURS
	public Promotion() {
		_annee = new GregorianCalendar().get(Calendar.YEAR);
	}

	public Promotion(int annee) {
		_annee = annee;
	}

	// ACCESSEURS
	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		_annee = annee;
	}

	public Etudiant getEtudiant(int i)
	{
		return _etudiants.get(i-1);
	}

	public int taillePromo()
	{
		return _etudiants.size();
	}

	public String toString()
	{
		return "Promotion " + annee + " : " + taillePromo() + " etudiants";
	}

	public void inscrire(Etudiant e)
	{
		_etudiants.add(e);
	}

	public double moyenneGenerale()
	{
		if (taillePromo() == 0) return -1;
		double total = 0;
		for (Etudiant e : _etudiants)
			total += e.moyenne();
		return total / taillePromo();
	}

	public void afficheResultats()
	{
		System.out.println(toString());
		for (Etudiant e : _etudiants)
			System.out.println(e.ligneResultats());
	}

	public Etudiant getEtudiant (String nom)
	{
		for (int i = 0; i < _etudiants.size(); i++)
			Etudiant e = _etudiants.get(i);
			if (e.getNom().equals(nom))
				return e;
		return null;
	}

	public int admis()
	{
		int total = 0;
		for (Etudiant e : _etudiants)
			if (e.moyenne() >= 10)
				total++;
		return total;
	}

	public ArrayList<Etudiant> populationIssueDeRecrutementExterieur()
	{
		ArrayList<Etudiant> l = new ArrayList<Etudiant>();
		for (Etudiant e : _etudiants)
		{
			if (e.getOrigine() == ModalitéRecrutement.eCandidat ||
					e.getOrigine() == ModalitéRecrutement.etudesEnFrance	)
				l.add(e);
		}
		return l;
	}

	public double meilleureMoyenne()
	{
		double m = 0;
		for (Etudiant e : _etudiants) {
			double mE = e.moyenne();
			if (mE > m)
				m = mE;
		}
		return m;
	}

	public ArrayList<Etudiant> majors()
	{
		ArrayList<Etudiant> l = new ArrayList<Etudiant>();
		double m = meilleureMoyenne();
		for (Etudiant e : _etudiants) {
			if (m - e.moyenne() < 0.1)
				l.add(e);
		}
		return l;
	}

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
