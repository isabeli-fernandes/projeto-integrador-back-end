package br.com.rd.projetoVelhoLuxo.controller;

import br.com.rd.projetoVelhoLuxo.model.dto.OrderDTO;
import br.com.rd.projetoVelhoLuxo.model.dto.response.OrderDashboardDTO;
import br.com.rd.projetoVelhoLuxo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class OrderController {
    @Autowired
    OrderService service;


    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO toCreate){
        return service.create(toCreate);
    }

    @GetMapping("/user/{id}")
    public List<OrderDTO> findByUser(@PathVariable("id") Long id){
        return service.findOrderByUser(id);
    }
    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable("id") Long id){
        return service.findByIdOrder(id);
    }

    @PutMapping("/{id}")
    public OrderDTO updateOrderStatusByIdOrder(@RequestBody OrderDTO dto, @PathVariable("id") Long id) {
        return service.updateOrderStatusByIdOrder(dto, id);
    }

    @PostMapping("/mail")
    public Boolean sendMail(@RequestBody OrderDTO toCreate) throws Exception {
        try {
            return service.sendConfirmationOrderEmail(toCreate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
