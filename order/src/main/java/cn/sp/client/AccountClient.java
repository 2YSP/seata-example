package cn.sp.client;

import cn.sp.dto.AccountDeductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/8/23
 */
@RequestMapping("/account")
@FeignClient(value = "account")
public interface AccountClient {

    @PostMapping("/deduct")
    void deduct(@RequestBody AccountDeductDTO accountDeductDTO);
}
