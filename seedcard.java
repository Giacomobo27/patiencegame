public enum seedcard {
    d("D"),
    h("H"),
    c("C"),
    s("S");


    private final String cc;
    seedcard(String cc) {
        this.cc = cc;
    }
    public String getStr() {
        return cc;
    }
    @Override
    public String toString() {
        switch(this) {
            case d: return "D";
            case h: return "H";
            case c: return "C";
            case s: return "S";
            default: return "Unknown";
        }
    }
}
