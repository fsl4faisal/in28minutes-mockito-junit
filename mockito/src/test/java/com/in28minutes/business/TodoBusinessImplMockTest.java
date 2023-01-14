package com.in28minutes.business;


import com.in28minutes.data.api.TodoService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring() {
        var todoService = mock(TodoService.class);
        when(todoService.retrieveTodos("faisal")).thenReturn(List.of("Get Grocery", "Study Spring", "Study LLD", "Complete k8s"));
        var todoBusinessImpl = new TodoBusinessImpl(todoService);
        var filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("faisal");
        assertEquals(1, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_withEmptyList() {
        var todoService = mock(TodoService.class);
        when(todoService.retrieveTodos("faisal")).thenReturn(List.of());
        var todoBusinessImpl = new TodoBusinessImpl(todoService);
        var filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("faisal");
        assertEquals(0, filteredTodos.size());
    }

}