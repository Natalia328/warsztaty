package com.airhacks.rest.store_rest;

import com.airhacks.rest.*;
import com.airhacks.store.service.OrderService;
import com.airhacks.store.service.UserService;
import com.airhacks.university.lecturer.service.LecturerService;
import com.airhacks.university.lecturer.service.SubjectService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;


@Path("store_users")
@Consumes("application/json")
@Produces("application/json")
public class UsersResource {

        @Inject
        private UserService userService;

        @Inject
        private OrderService orderService;

        @POST
        @Path("user")
        public void addNewUser(@RequestBody UserRequest request){
            userService.addUser(request);
        }

        @GET
        @Path("user/{id}")
        public UserResponse getUser(@PathParam("id") Long id){
            return userService.getUser(id);
        }

        @GET
        @Path("users")
        public UsersResponse getUsers(){
            return userService.getUsers();
        }

//        post nie działa :(
        @POST
        @Path("orders")
        public void addNewOrder(@RequestBody OrderRequest request){
            orderService.addNewOrder(request);
        }
        @GET
        @Path("orders/{id}")
        public OrderResponse getOrder(@PathParam("id") Long id) {
            return orderService.getOrder(id);
        }
}
