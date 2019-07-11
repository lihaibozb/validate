package com.zyxfcfc.validate.generator.service.impl;

import com.zyxfcfc.validate.generator.dao.PersonMapper;
import com.zyxfcfc.validate.generator.pojo.Person;
import com.zyxfcfc.validate.generator.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/11 1:33 PM
 */
@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return personMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Person record) {
        return personMapper.insert(record);
    }

    @Override
    public int insertSelective(Person record) {
        return personMapper.insertSelective(record);
    }

    @Override
    public Person selectByPrimaryKey(Long id) {
        return personMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Person record) {
        return personMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Person record) {
        return personMapper.updateByPrimaryKey(record);
    }
}
