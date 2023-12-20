package com.example.name;

<<<<<<< HEAD

import jakarta.validation.constraints.NotBlank;

public class NameRequest {
    @NotBlank(message = "Name cannot be blank")
    private String name;

=======
public class NameRequest {
    private String name;
>>>>>>> 1c97a1300676b342a4fce1b06f0d3e4ac5025703
    private int age;

    public NameRequest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
<<<<<<< HEAD
    public boolean isValid() {

        return name != null && !name.trim().isEmpty();
    }

}
=======

    public boolean isValid() {
        return name != null && !name.trim().isEmpty();
    }
}
>>>>>>> 1c97a1300676b342a4fce1b06f0d3e4ac5025703
