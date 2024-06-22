package com.example.__nguyenvanan_lap3.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @Column(name="Ma_NV",nullable = false,length = 3)
    private String maNV;

    @Column(name="Ten_NV",nullable = false,length = 100)
    private String tenNV;


    @Column(name="Ma_Ca",length = 50)
    private  String maCa;


    @ManyToOne
    @JoinColumn(name = "Ma_Ca", insertable = false, updatable = false)
    private PhongBan phongban;

}