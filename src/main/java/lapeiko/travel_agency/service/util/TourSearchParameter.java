package lapeiko.travel_agency.service.util;

public enum TourSearchParameter {
    DURATION_PARAMETER("tempValue"),
    MIN_COST_PARAMETER("tempValue"),
    MAX_COST_PARAMETER("tempValue");
    private Object value;

    TourSearchParameter(Object value) {
        this.value = value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
