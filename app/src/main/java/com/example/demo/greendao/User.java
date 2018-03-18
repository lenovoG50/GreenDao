package com.example.demo.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 59246 on 2018/3/16.
 */
@Entity
public class User {
    @Id
    @Unique
    private Long id;
    @Property(nameInDb = "USERNAME")
    private String username;
    @Property(nameInDb = "AGE")
    private int age;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 1484728154)
    public User(Long id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    @Generated(hash = 586692638)
    public User() {
    }
}
