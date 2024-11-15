public enum numbercard {
    ace(1),
    two(2),
    three(3),
    four(4),
    five(5),
    six(6),
    seven(7),
    eight(8),
    nine(9),
    ten(10),
    jack(11),
    queen(12),
    king(13);

    private final int number;
    numbercard(int number) {
        this.number = number;
    }
    public int getValue() {
        return number;
    }

    public static numbercard fromValue(int value) {
        for (numbercard  n : numbercard .values()) {
            if (n.getValue() == value) {
                return n;
            }
        }
        throw new IllegalArgumentException("Error numbercard value");
    }

    public String toString() {
        switch(this) {
            case ace: return "1";
            case two: return "2";
           case three: return "3";
            case four: return "4";
            case five: return "5";
            case six: return "6";
            case seven: return "7";
            case eight: return "8";
            case nine: return "9";
            case ten: return "10";
            case jack: return "J";
            case queen: return "Q";
            case king: return "K";
            default: return "Unknown";
        }
    }

}
