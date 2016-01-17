package pl.koszolko.book.gateway.service.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    private long id;
    private long bookId;
    private String reviewText;

}
