package testData;

public enum Cities {
    MOSCOW("Москва"),
    SAINT_PETERSBURG("Санкт-Петербург");

    private String city;

    Cities(String city) {
        this.city = city;
    }

    public String getValue() {
        return city;
    }
}
