package lapeiko.travel_agency.model.review;

import jakarta.persistence.*;
import lapeiko.travel_agency.model.BaseEntity;
import lapeiko.travel_agency.model.client.Client;
import lapeiko.travel_agency.model.tour.Tour;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;

@Entity
@Table(name = "review")
@Getter
@Setter
@Accessors(chain = true)
public class Review extends BaseEntity {

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "tour_id")
    private Tour tour;



}
