package lapeiko.travel_agency.model.hotel;

public enum HotelFeatures {
    WITH_WIFI("with WiFi"),
    WITHOUT_WIFI("without WiFi"),
    ALL_INCLUSIVE("all inclusive"),
    WITH_SWIMMING_POOL("with swimming pool"),
    WITH_MINI_BAR("with mini bar"),
    WITH_PARKING("with parking"),
    WITH_CINEMA("with a cinema"),
    HAS_A_PRESIDENT_ROOM("has a president room"),
    NEAR_THE_BEACH("near the beach"),
    LOW_COST("low cost");

    private final String value;

    HotelFeatures(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
