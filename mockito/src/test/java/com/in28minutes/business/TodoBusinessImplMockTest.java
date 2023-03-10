package com.in28minutes.business;


import com.in28minutes.data.api.TodoService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TodoBusinessImplMockTest {
    TodoService todoService = mock(TodoService.class);
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

    @Test
    public void testRetrieveTodosRelatedToSpring() {
        when(todoService.retrieveTodos("faisal")).thenReturn(List.of("Get Grocery", "Study Spring", "Study LLD", "Complete k8s"));
        var filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("faisal");
        assertEquals(1, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpringBDD() {
        //Given
        given(todoService.retrieveTodos("faisal")).willReturn(List.of("Get Grocery", "Study Spring", "Study LLD", "Complete k8s"));

        //When
        var filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("faisal");

        //Then
        assertEquals(1, filteredTodos.size());
        //assertThat(filteredTodos.size(),is(1)); this is not working in junit 5
    }

    @Test
    public void testDeleteTodoRelatedToSpringBDD() {
        //given
        var todos = List.of("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoService.retrieveTodos("Faisal")).willReturn(todos);

        //when
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Faisal");

        //then
        //verify(todoService).deleteTodo("Faisal", "Learn to Dance");//this will fail
        verify(todoService).deleteTodo("Faisal", "Spring");//this will fail
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