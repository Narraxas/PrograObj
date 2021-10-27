import java.time.LocalDate;

public class ManipulationEtudiant {
        public static void main (String[] args) {
                Etudiant Antoine = new Etudiant("Verlyck", "Antoine", 28, LocalDate.of(1993, 1, 21), Etudiant.stOrigin_e.FORMATION_LOCALE);

                Antoine.setMark("UE1", 12.0);
                Antoine.setMark("UE2", 19.8);
                Antoine.setMark("UE3", 14.5);
                Antoine.setMark("UE4", 15.3);
                Antoine.setMark("UE5", 9.2);
                Antoine.setMark("UE6", 7.0);
                Antoine.setMark("Flemmardise", 21.0);
                System.out.println(Antoine.toString());
                System.out.println("Average = " + Antoine.calcAverage());
                System.out.println("Mention = " + Antoine.calcMention(Antoine.calcAverage()));
        }
}