package cn.sp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/8/23
 */
@Data
@TableName("order_tbl")
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;
}
