import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Etudiant {
    //Enumérations
    public enum stOrigin_e {
        FORMATION_LOCALE,
        E_CANDIDAT,
        DISPOSITIF_ETUDE_FRANCE;
    }

    public enum mention_e {
        REDOUBLEMENT,
        TRICHEUR,
        ADMIS_DE_JUSTESSE,
        ASSEZ_BIEN,
        BIEN,
        TRES_BIEN,
        EXCELLENT,
        GOD_TIER;
    }

    //Attributs
    private String _name;
    private String _firstname;
    private int _age;
    private LocalDate _birthday;
    private stOrigin_e _origin;
    private Map<String, Double> _marks;

    //Getters
    String getName() {
        return _name;
    }

    String getFirstname() {
        return _firstname;
    }

    int getAge() {
        return _age;
    }

    LocalDate getBirthday() {
        return _birthday;
    }

    stOrigin_e getOrigin() {
        return _origin;
    }

    Map<String, Double> getMarks() {
        return _marks;
    }

    //Setters
    void setName(String name) {
        _name = name;
    }

    void setFirstname(String firstname) {
        _firstname = firstname;
    }

    void setAge(int age) {
        _age = age;
    }

    void setBirthday(LocalDate birthday) {
        _birthday = birthday;
    }

    void setOrigin(stOrigin_e origin) {
        _origin = origin;
    }

    void setMark(String name, Double mark) {
        _marks.put(name, mark);
    }

    void unsetMark(String name, Double mark) {
        _marks.remove(name, mark);
    }

    //Other Methods
    public int calcAge() {
        _age = (int)_birthday.until(LocalDate.now(), ChronoUnit.YEARS);
        return _age;
    }

    public Etudiant(String name, String firstname, int age, LocalDate birthday, stOrigin_e origin) {
        _name = name;
        _firstname = firstname;
        _birthday = birthday;
        _age = calcAge();
        _origin = origin;
        _marks = new HashMap<String, Double>();
    }

    public String toString() {
        return "Etudiant [name=" + _name + ", firstname=" + _firstname + ", age=" + _age + ", birthday=" + _birthday + ", origin=" + _origin + ", marks=" + _marks + "]";
    }

    //Calcule et retourne la moyenne des notes de l'étudiant
    public float calcAverage() {
        float average = 0;

        if (_marks.size() != 0) {
            for (String subject : _marks.keySet())
                average += _marks.get(subject);
            average /= _marks.size();
        }
        return average;
    }

    //Retourne la mention correspondant à la moyenne de l'étudiant
    public mention_e calcMention(float average) {
        if (average >= 21)
            return mention_e.TRICHEUR;
        else if (average >= 19.5)
            return mention_e.GOD_TIER;
        else if (average >= 18)
            return mention_e.EXCELLENT;
        else if (average >= 16)
            return mention_e.TRES_BIEN;
        else if (average >= 14)
            return mention_e.BIEN;
        else if (average >= 12)
            return mention_e.ASSEZ_BIEN;
        else if (average >= 10)
            return mention_e.ADMIS_DE_JUSTESSE;
        else
            return mention_e.REDOUBLEMENT;
    }
}