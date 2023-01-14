package com.in28minutes.data.api;

import java.util.List;

public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return List.of("Get Grocery", "Study Spring", "Study LLD", "Complete k8s");
    }
}
