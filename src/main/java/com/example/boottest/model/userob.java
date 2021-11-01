package com.example.boottest.model;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@TableName("user")
public class userob implements Cloneable{
    private int id;
    private String Name;
    private String Age;
    private String Sex;

    public userob (userob source){
        this.id = source.id+1;
        this.Name = source.Name;
        this.Age = source.Age+"222";
        this.Sex = source.Sex;
    }
    public userob clone() throws CloneNotSupportedException {
        userob temp = (userob) super.clone();
        return temp;
    }
}
