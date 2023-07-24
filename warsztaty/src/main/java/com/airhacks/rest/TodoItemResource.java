package com.airhacks.rest;


import com.airhacks.todo.service.TodoDatabaseService;
import com.airhacks.todo.service.TodoItemService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("todo-items")
@Consumes("application/json")
@Produces("application/json")
public class TodoItemResource {

    @Inject
    private TodoItemService service;
    @Inject
    private TodoDatabaseService todoDatabaseService;



    @POST
        public void addTodoItem(AddTodoItemRequest request) {
        todoDatabaseService.addItem(request.getName(), request.getPriority());
    }

    @GET
        public GetTodoItemResponse getTodoItem(@QueryParam("name") String name) {
        List<String> todoItems = service.getTodoItemStrings(name);
        GetTodoItemResponse response = new GetTodoItemResponse();
        response.setTodoItems(todoItems);
        return response;
    }

    @GET
    @Path("/{id}")
    public Response getTodoItem(@PathParam("id") Long id) {
        Optional<TodoItemDTO> optionalTodoItemDTO = service.getTodoItem(id);
        if (optionalTodoItemDTO.isPresent()) {
            return Response.ok(optionalTodoItemDTO.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/{id}")
    public TodoItemResponse getItem(@PathParam("id") Long id){

        return todoDatabaseService.getItem(id);
    }


//    @DELETE
//    @Path("/{id}")
//    public Response deleteTodoItem(@PathParam("id") Long id) {
//        Optional<TodoItemDTO> optionalTodoItemDTO = service.getTodoItem(id);
//        if (optionalTodoItemDTO.isPresent()) {
//            service.delete(id);
//            return Response.noContent().build();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//    }

    @DELETE
        public void deleteAllItems() {
        service.deleteTodoItems();
    }

}
