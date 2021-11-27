package com.example.pojo;

import javax.persistence.*;

@Entity
@Table(name = "lake")
public class Lake {
    //    Уникальный идентификатор озера
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //    Площадь озера
    private Double area;
    //    Глубина озера
    private Double depth;
    //    Название озера
    private String name;

    public Long getId() {
        return id;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
