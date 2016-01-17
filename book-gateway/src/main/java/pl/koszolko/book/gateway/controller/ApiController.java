package pl.koszolko.book.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import pl.koszolko.book.gateway.model.BookDetails;
import pl.koszolko.book.gateway.service.integration.IntegrationService;
import rx.Observable;
import rx.Observer;

@RestController
public class ApiController {

    @Autowired
    private IntegrationService integrationService;

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
    public DeferredResult<BookDetails> getBookDetails(@PathVariable Long id) {
        return toDeferredResult(integrationService.getBookDetails(id));
    }

    private DeferredResult<BookDetails> toDeferredResult(Observable<BookDetails> details) {
        DeferredResult<BookDetails> result = new DeferredResult<>();
        details.subscribe(new Observer<BookDetails>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(BookDetails bookDetails) {
                result.setResult(bookDetails);
            }
        });
        return result;
    }
}
