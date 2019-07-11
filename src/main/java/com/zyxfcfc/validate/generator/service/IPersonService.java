package com.zyxfcfc.validate.generator.service;

import com.zyxfcfc.validate.generator.pojo.Person;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/11 1:33 PM
 */
public interface IPersonService {

    int deleteByPrimaryKey(Long id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

}
