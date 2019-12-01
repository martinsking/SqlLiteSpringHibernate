package com.martinsking.dto;

import javax.persistence.*;

@Entity
@Table(name = "Records")
public class RecordDto {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Record [id="
                + id
                + ", name="
                + name
                + "]";
    }
}
