package com.in28minutes.business;


import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoBusinessImplStubTest {
    TodoService todoService = new TodoServiceStub();
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

    @Test
    public void testRetrieveTodoByUser() {
        var filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Faisal");
        assertEquals(1, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodoByUserAndDeleteTodo() {
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Faisal");
        var todos = todoBusinessImpl.retrieveTodoRelatedToSpring("Faisal");
        assertEquals(0, todos.size());
    }
}