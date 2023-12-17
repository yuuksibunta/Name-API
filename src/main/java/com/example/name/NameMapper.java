package com.example.name;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Optional;


@Mapper
public interface NameMapper {

    @Select("SELECT * FROM names")
    List<Name> findAllNames();

    @Select("SELECT * FROM names WHERE name LIKE CONCAT(#{name}, '%')")
    List<Name> findByNameStartingWith(String prefix);

    @Select("SELECT * FROM names WHERE id = #{id}")
    Optional<Name> findById(int id);

    @Insert("INSERT INTO names (name, age) VALUES (#{name}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Name name);

}