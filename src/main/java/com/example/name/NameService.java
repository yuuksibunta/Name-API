package com.example.name;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NameService {

    private final NameMapper nameMapper;

    public NameService(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    public Name findByld(int id) {
        Optional<Name> name = this.nameMapper.findById(id);
        if (name.isPresent()) {
            return name.get();
        } else {
            throw new NameNotFoundException("指定されたIDの名前は存在しません");
        }
    }

    public Name insert(String name, Integer age) {
        Name newName = new Name(null, name, age);
        nameMapper.insert(newName);
        return newName;
    }
}
