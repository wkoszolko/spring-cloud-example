package pl.koszolko.book.gateway.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.koszolko.book.gateway.service.review.Review;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDetails {

    private long id;
    private String title;
    private String description;
    private List<Review> reviews;
}
