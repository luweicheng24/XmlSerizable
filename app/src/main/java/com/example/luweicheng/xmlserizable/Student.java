package com.example.luweicheng.xmlserizable;

/**
 * Created by luweicheng on 2016/3/30.
 */
public class Student {
private String name;
  private String age;

    public Student(String age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
