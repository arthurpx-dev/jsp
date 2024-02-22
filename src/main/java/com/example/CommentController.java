package com.example;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.CsrfValid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Controller
@Path("comments")
public class CommentController {
    @Inject
    private CommentsService commentsService;

    @Inject
    private Models models;

    @GET
    public String show() {
        models.put("comments", commentsService.getComments());
        return "comments.jsp";
    }

    @POST
    @CsrfValid
    public String post(@BeanParam CommentForm commentForm) {
        commentsService.addComment(commentForm.getComment());
        return "redirect:/app/comments";
    }
}
