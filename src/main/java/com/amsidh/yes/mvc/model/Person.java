package com.amsidh.yes.mvc.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Person {
    private Integer id;
    private String personName;
    private String emailId;
    private String address;
}
