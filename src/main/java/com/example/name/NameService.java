package com.example.name;

import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class NameService {

    private final NameMapper nameMapper;

    public NameService(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

<<<<<<< HEAD
    public Name findByld(int id) {
=======
    public Name findName(int id) {
>>>>>>> 1c97a1300676b342a4fce1b06f0d3e4ac5025703
        Optional<Name> name = this.nameMapper.findById(id);
        if (name.isPresent()) {
            return name.get();
        } else {
            throw new NameNotFoundException("存在しません");
        }
    }


    public Name insert(String name, Integer age) {
        Name newName = new Name(null, name, age);
        nameMapper.insert(newName);
        return newName;
    }

}
