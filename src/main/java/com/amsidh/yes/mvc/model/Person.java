package com.amsidh.yes.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Person {
    private Integer id;
    private String personName;
    private String emailId;
    private String address;
}
