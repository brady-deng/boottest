package com.example.boottest.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
//@Builder
//@ConfigurationProperties(prefix = "person")
@NoArgsConstructor
public class Personob implements Serializable {


    private static final long serialVersionUID = -4826192455962005880L;
    private String name;
    private String age;
}
