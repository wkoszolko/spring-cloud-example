package pl.koszolko.book.gateway.service.review;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.util.Arrays;
import java.util.List;

@Component
public class ReviewService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "stubReviews")
    public Observable<List<Review>> getReviewsBy(long bookId) {
        return Observable.just(invokeReviewService(bookId));
    }

    private List<Review> invokeReviewService(long bookId) {
        ParameterizedTypeReference<List<Review>> responseType = new ParameterizedTypeReference<List<Review>>() {
        };
        return restTemplate.exchange("http://review-service/reviewsFor/{bookId}", HttpMethod.GET, null, responseType, bookId).getBody();
    }

    private List<Review> stubReviews(long bookId) {
        return Arrays.asList(
                Review.builder()
                .bookId(bookId)
                .reviewText("Stub review")
                .build()
        );
    }
}
