package com.zyxfcfc.validate.domain;

import com.zyxfcfc.validate.util.AccountChecks;
import com.zyxfcfc.validate.util.DateValidator;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;
import java.util.Date;

/**
 * @author lihaibo…
 * @version V1.0
 * @date 2019-06-26
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    private String id;
    @NotNull(message = "userName can not be null!")
    @Length(max = 20)
    private String userName;
    @NotNull
    @Pattern(regexp = "[A-Z][a-z][0-9]")
    private String passWord;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date createTime;
    @DateValidator(dateFormat = "yyyy-MM-dd", groups = {Default.class, AccountChecks.class})
    private String updateTime;
    private String alias;
    @Max(10)
    @Min(1)
    private Integer level;
    private Integer vip;
}