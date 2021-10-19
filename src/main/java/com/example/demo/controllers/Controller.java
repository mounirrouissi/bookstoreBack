package com.example.demo.controllers;

import com.example.demo.models.Author;
import com.example.demo.models.Feedback;
import com.example.demo.repos.AuthorRepo;
import com.example.demo.repos.BookRepo;
import com.example.demo.service.FeedbackMailSender;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import javax.xml.bind.ValidationException;


@RestController
@CrossOrigin("*")
public class Controller {

    private AuthorRepo authorRepo;
private FeedbackMailSender feedbackMailSender;
    private BookRepo bookRepo;
    public Controller(AuthorRepo authorRepo, FeedbackMailSender feedbackMailSender, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.feedbackMailSender = feedbackMailSender;
        this.bookRepo = bookRepo;

    }
@GetMapping("/authors")
    public Page<Author> getAuthor(@PathParam("page")Integer page,@PathParam("size")Integer size){
        return authorRepo.findAll(PageRequest.of(page,size, Sort.by(Sort.Direction.ASC,"name")));
}

@PostMapping("/feedback/")
    public void sendFeedback(@RequestBody Feedback feedback, BindingResult bindingResult) throws ValidationException {
if (bindingResult.hasErrors())
    throw new ValidationException("Erro while sending feedback");
    System.out.println("feedback"+feedback);
this.feedbackMailSender.sendFeedback(feedback.getEmail(), feedback.getName(), feedback.getFeedback());
}


}

