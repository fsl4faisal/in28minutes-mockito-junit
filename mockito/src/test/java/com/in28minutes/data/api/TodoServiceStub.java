package com.in28minutes.data.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TodoServiceStub implements TodoService {

    Map<String, List<String>> map = Map
            .of(
                    "Faisal", new ArrayList<>(Arrays.asList("Get Grocery", "Study Spring", "complete k8s")),
                    "Ankit", new ArrayList<>(Arrays.asList("Get Books", "Study docker", "Study JPA"))
            );
    /*We have to wrap this around with new ArrayList<>(); is because when we do Arrays.asList(), it
      it creates arraylist of fixed size and then it's size can't be changed later,
      similarly if we use List.of(), then it's immutable, Map.of() is also immutable too
    * */

    @Override
    public List<String> retrieveTodos(String user) {
        return map.get(user);
    }

    @Override
    public void deleteTodo(String user, String todo) {
        var list = map.get(user);
        list.removeIf(item -> item.contains(todo));
    }
}
