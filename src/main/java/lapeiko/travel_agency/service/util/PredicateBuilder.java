package lapeiko.travel_agency.service.util;

import jakarta.persistence.criteria.*;
import lapeiko.travel_agency.model.hotel.Hotel;
import lapeiko.travel_agency.model.tour.Tour;
import lapeiko.travel_agency.service.exception.NoSearchParameterException;
import org.hibernate.Session;


public class PredicateBuilder {
    public static Predicate[] buildPredicate(TourSearchParameter[] parameters, Session session) throws NoSearchParameterException {
        int size = parameters.length;
        int count = 0;
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Tour> tourCriteria = criteriaBuilder.createQuery(Tour.class);
        Root<Tour> tourRoot = tourCriteria.from(Tour.class);
        Predicate[] predicates = new Predicate[size];
        for (TourSearchParameter parameter : parameters) {
            switch (parameter) {
                case COUNTRY_PARAMETER:
                    predicates[count] = criteriaBuilder.equal(tourRoot.get("countryId"), parameters[count].getValue());
                    break;
                case DURATION_PARAMETER:
                    predicates[count] = criteriaBuilder.equal(tourRoot.get("duration"), parameters[count].getValue());
                    break;
                case MAX_COST_PARAMETER:
                    predicates[count] = criteriaBuilder.lessThanOrEqualTo(tourRoot.get("cost"), (Double)parameters[count].getValue());
                    break;
                case MIN_COST_PARAMETER:
                    predicates[count] = criteriaBuilder.greaterThanOrEqualTo(tourRoot.get("cost"), (Double)parameters[count].getValue());
                    break;
                case HOTEL_STARS_PARAMETER:
                    Root<Hotel> hotelRoot = tourCriteria.from(Hotel.class);
                    Join<Hotel,Tour> tours = hotelRoot.join("tours");
                    predicates[count] = criteriaBuilder.equal(hotelRoot.get("stars"),parameters[count].getValue());
                    break;
                default:
                    throw new NoSearchParameterException("There is no such parameter to search");
            }
            count++;
        }
        return predicates;
    }
}
