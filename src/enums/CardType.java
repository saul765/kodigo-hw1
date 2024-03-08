package enums;

public enum CardType {

    TYPE1(1),
    TYPE2(2),
    TYPE3(3),
    OTHER(4);

    private final Integer tier;

    CardType(Integer tier) {
        this.tier = tier;
    }

    public Integer getTier() {
        return tier;
    }

}
