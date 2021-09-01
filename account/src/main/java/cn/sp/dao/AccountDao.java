package cn.sp.dao;

import cn.sp.bean.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/8/23
 */
@Mapper
public interface AccountDao extends BaseMapper<Account> {

}
