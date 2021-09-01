package cn.sp.controller;

import cn.sp.dto.OrderDTO;
import cn.sp.service.OrderService;
import cn.sp.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/8/23
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public OrderVO create(@RequestBody OrderDTO orderDTO){
        return orderService.create(orderDTO);
    }


}
