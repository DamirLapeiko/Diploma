package lapeiko.travel_agency.model.tour;

public enum TourType {
    BUS_TOUR("bus tour"),
    WEEKEND_TOUR("weekend tour"),
    EVENT_TOUR("event tour"),
    FAMILY_TOUR("family tour"),
    SHOPPING_TOUR("shopping tour"),
    WEEDING_TOUR("weeding tour"),
    SAFARI("safari"),
    SIGHTSEEING_YOUR("sightseeing tour"),
    HEALTH_TOUR("health tour"),
    CHILD_TOUR("child tour");

    private final String value;

    TourType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
