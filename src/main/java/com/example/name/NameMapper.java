package com.example.name;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;


@Mapper
public interface NameMapper {

    @Select("SELECT * FROM names")
    List<Name> findAll();

}
