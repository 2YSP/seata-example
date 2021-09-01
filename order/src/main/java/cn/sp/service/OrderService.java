package cn.sp.service;

import cn.sp.bean.Order;
import cn.sp.client.AccountClient;
import cn.sp.dao.OrderDao;
import cn.sp.dto.AccountDeductDTO;
import cn.sp.dto.OrderDTO;
import cn.sp.vo.OrderVO;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/8/23
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AccountClient accountClient;

    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public OrderVO create(OrderDTO orderDTO) {
        // 创建订单
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO,order);
        orderDao.insert(order);
        // 扣除账户余额
        AccountDeductDTO accountDeductDTO = new AccountDeductDTO();
        Integer total = orderDTO.getMoney() * orderDTO.getCount();
        accountDeductDTO.setMoney(total);
        accountDeductDTO.setUserId(orderDTO.getUserId());
        accountClient.deduct(accountDeductDTO);
        return new OrderVO(order.getId());
    }
}
