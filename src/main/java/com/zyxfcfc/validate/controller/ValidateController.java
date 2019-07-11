package com.zyxfcfc.validate.controller;

import com.google.common.util.concurrent.*;
import com.zyxfcfc.validate.domain.Account;
import com.zyxfcfc.validate.util.AccountChecks;
import com.zyxfcfc.validate.util.JsonUtils;
import com.zyxfcfc.validate.util.ValidationUtils;
import com.zyxfcfc.validate.util.annotation.MyLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.concurrent.*;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2019-06-26
 * @Description:
 */
@RestController
@Slf4j
public class ValidateController {

    @GetMapping("/saveString")
    @MyLog("query")
    public String query(@RequestParam @NotNull String param) throws Exception {
        String returnMsg = null;
        Account account = null;
        try {
            //account = JsonUtils.json2pojo(param, Account.class);
            account = Account.builder().userName("").passWord("123").build();
            //new Account();
            //account.setAlias("kalakala");
            //account.setUserName("wokalakala");
            //account.setPassWord("密码");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ValidationUtils.ValidResult validResult = ValidationUtils.validateBean(account, Default.class, AccountChecks.class);
        if (validResult.hasErrors()) {
            String resultMsg = validResult.getErrors();
            log.error(resultMsg);
            throw new Exception(resultMsg);
        }
        return returnMsg;
    }

    /**
     * @param account
     * @return {"userName":"wokalakala","alias":"kalakala","passWord":"Aa1","level":100}
     */
    @PostMapping("/saveAccount")
    public String saveAccount(@RequestBody @Valid Account account) {
        return "保存成功";
    }

}
