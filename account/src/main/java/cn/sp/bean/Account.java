package cn.sp.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/8/23
 */
@Data
@TableName("account_tbl")
public class Account {

    @TableId
    private String userId;

    private Integer money;
}
