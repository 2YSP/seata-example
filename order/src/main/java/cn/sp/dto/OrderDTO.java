package cn.sp.dto;

import lombok.Data;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/8/23
 */
@Data
public class OrderDTO {

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;
}
