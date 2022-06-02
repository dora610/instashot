package link.karurisuro.instashot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommnetController {

    @GetMapping("/show")
    public String getComments(@RequestParam(name = "postId", defaultValue = "1", required = true) String postId){
        return null;
    }
}
