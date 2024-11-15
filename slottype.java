public enum slottype {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    A(8),
    P(9),
    D(10),
    H(11),
    C(12),
    S(13);


    private final int value;
    slottype(int value){
        this.value=value;
    }
    public int getValue() {
        return value;
    }

    public static slottype fromValue(int value) {
        for (slottype slot : slottype.values()) {
            if (slot.getValue() == value) {
                return slot;
            }
        }
        throw new IllegalArgumentException("Error slottype value");
    }


}
