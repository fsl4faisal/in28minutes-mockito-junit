package com.in28minutes.business;


import com.in28minutes.data.api.TodoServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoBusinessImplStubTest {

    @Test
    public void test() {
        var todoService = new TodoServiceStub();
        var todoBusinessImpl = new TodoBusinessImpl(todoService);
        var filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("faisal");
        assertEquals(1, filteredTodos.size());
    }

}