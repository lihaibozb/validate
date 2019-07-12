package com.zyxfcfc.validate.generator.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "goods")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
    @Id()
    private Long goodsId;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_type")
    private Long goodsType;

    private static final long serialVersionUID = 1L;
}