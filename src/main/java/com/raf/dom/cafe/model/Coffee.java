package com.raf.dom.cafe.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Coffee {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 2, max = 35, message = "Must be between 3 and 35 characters!")
    private String name;

    @NotNull
    private String faculty;

    @NotNull
    private String type;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer howMuch;

    public Coffee() {
    }

    public Coffee(String name, String faculty, Integer howMuch, String type) {
        this.name = name;
        this.type = type;
        this.faculty = faculty;
        this.howMuch = howMuch;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getHowMuch() {
        return howMuch;
    }

    public void setHowMuch(Integer howMuch) {
        this.howMuch = howMuch;
    }
}
