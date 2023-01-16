package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import lombok.AllArgsConstructor;

import java.util.List;


/*
TOdoBusinessImpl is SUT(System Under Test)
 */

@AllArgsConstructor
public class TodoBusinessImpl {
    private final TodoService todoService;

    public List<String> retrieveTodoRelatedToSpring(String user) {
        return todoService
                .retrieveTodos(user).stream()
                .filter(todo -> todo.contains("Spring"))
                .toList();
    }

    public void deleteTodosNotRelatedToSpring(String user) {
        todoService.deleteTodo(user, "Spring");
    }
}
