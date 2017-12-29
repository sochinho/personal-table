package org.personal.table.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NoteController  {

    @GetMapping("/hello")
    public String returnHello() {
        return "Hello world";
    }

}
