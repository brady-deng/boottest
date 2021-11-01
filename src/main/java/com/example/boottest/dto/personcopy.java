package com.example.boottest.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Map;

@Data
@ApiModel("人力资源")
@AllArgsConstructor
@NoArgsConstructor
public class personcopy {

    public personcopy(@NotBlank(message = "姓名不能为空") String name) {
        this.name = name;
    }

    /**
     * 姓名lalalal
     */
    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名person",name = "person_name")
    private String name;
    /**
     * 年龄
     */
    @NotBlank(message = "年龄不能为空")
    @ApiModelProperty(value="年龄person",name = "person_age")
    private String age;
    /**
     * 手机app
     */
    private String money;

    /**
     * 主键id
     */
    private long id;


    public personcopy(@NotBlank(message = "姓名不能为空") String name, @NotBlank(message = "年龄不能为空") String age) {
        this.name = name;
        this.age = age;
    }
}
