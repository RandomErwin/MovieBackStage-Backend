package org.web.controller;

import org.springframework.web.bind.annotation.*;
import org.web.dto.Result;
import org.web.entity.Orders;
import org.web.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public Result createOrder(@RequestBody Orders orders){
        System.out.println(orders);
        return orderService.createOrder(orders);
    }
    @PutMapping("/updateOder")
    public Result updateOder(@RequestBody Orders orders){
        return orderService.updateOder(orders);
    }
    @DeleteMapping("/deleteOrder/{id}")
    public Result deleteOrder(@PathVariable Integer id){
        return orderService.deleteOrder(id);
    }
    @GetMapping("/getOrder/{id}")
    public Result getOrder(@PathVariable Integer id){
        return orderService.getOrder(id);
    }


}
