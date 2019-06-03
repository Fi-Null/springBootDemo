package com.springboot.example.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author null
 * @version 1.0
 * @title
 * @description
 * @createDate 6/3/19 4:13 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "UserLombook")
public class UserLombook {

    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "age")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
