package com.example.__nguyenvanan_lap3.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "phongban")
public class PhongBan {
    @Id
    @Column(name ="Ma_Ca",nullable = false,length = 50)
    private String maCa;
    @Column(name = "Ca",nullable = false,length = 30)
    private  String Ca;


}