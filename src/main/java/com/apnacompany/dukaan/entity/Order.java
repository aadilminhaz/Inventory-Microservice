package com.apnacompany.dukaan.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "o_fid",referencedColumnName = "orderId")
    private List<Line> lines = new ArrayList<Line>();

    public Order() {
    }

    public Order(Long orderId, String name, List<Line> lines) {
        this.orderId = orderId;
        this.name = name;
        this.lines = lines;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}
