public class Mark {
    public String _examName;
    public float _mark;

    public Mark(String examName, float mark) {
        _examName = examName;
        _mark = mark;
    }

    public String toString() {
        return "Mark [examName=" + _examName + ", mark=" + _mark + "]";
    }
}