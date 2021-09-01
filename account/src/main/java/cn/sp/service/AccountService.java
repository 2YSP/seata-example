package cn.sp.service;

import cn.sp.bean.Account;
import cn.sp.dao.AccountDao;
import cn.sp.dto.AccountDeductDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/8/23
 */
@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(rollbackFor = Exception.class)
    public void deduct(AccountDeductDTO accountDeductDTO) {
        QueryWrapper<Account> wrapper = new QueryWrapper();
        wrapper.lambda().eq(Account::getUserId, accountDeductDTO.getUserId());
        Account account = accountDao.selectOne(wrapper);
        Integer money = account.getMoney() - accountDeductDTO.getMoney();
        account.setMoney(money);

        // 更新余额
        accountDao.updateById(account);

//        int i = 1 / 0;
    }
}
