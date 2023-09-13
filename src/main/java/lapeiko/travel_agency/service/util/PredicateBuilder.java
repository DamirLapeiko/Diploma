package lapeiko.travel_agency.service.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lapeiko.travel_agency.model.tour.TourShortDto;
import lapeiko.travel_agency.service.exception.NoSearchParameterException;

public class PredicateBuilder {

    protected static EntityManager entityManager;


    public static Predicate[] buildPredicate(TourSearchParameter[] parameters) throws NoSearchParameterException {
        int size = parameters.length;
        int count = 0;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TourShortDto> tourCriteria = criteriaBuilder.createQuery(TourShortDto.class);
        Root<TourShortDto> tourRoot = tourCriteria.from(TourShortDto.class);
        Predicate[] predicates = new Predicate[size];
        for (TourSearchParameter parameter : parameters) {
            switch (parameter) {
                case DURATION_PARAMETER:
                    predicates[count] = criteriaBuilder.equal(tourRoot.get("duration"), parameters[count].getValue());
                    break;
                case MAX_COST_PARAMETER:
                    predicates[count] = criteriaBuilder.lessThanOrEqualTo(tourRoot.get("cost"), (Double) parameters[count].getValue());
                    break;
                case MIN_COST_PARAMETER:
                    predicates[count] = criteriaBuilder.greaterThanOrEqualTo(tourRoot.get("cost"), (Double) parameters[count].getValue());
                    break;
                default:
                    throw new NoSearchParameterException("There is no such parameter to search");
            }
            count++;
        }
        return predicates;
    }
}
