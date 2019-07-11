package com.zyxfcfc.validate.generator.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "person")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Byte age;

    @Column(name = "mobile")
    private String mobile;

}