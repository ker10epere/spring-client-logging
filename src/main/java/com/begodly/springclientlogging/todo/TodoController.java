package com.begodly.springclientlogging.todo;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/todos")
@RestController
public class TodoController {
    private final TodoClient client;

    @GetMapping
    public String getAll() {
        return client.getAll();
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Integer id) {
        return client.get(id);
    }
}
