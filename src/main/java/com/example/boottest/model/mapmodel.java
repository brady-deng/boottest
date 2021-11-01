package com.example.boottest.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;


@Builder
@Data
public class mapmodel {
    private String company;
    private Map<String,Integer> workhour;
}
