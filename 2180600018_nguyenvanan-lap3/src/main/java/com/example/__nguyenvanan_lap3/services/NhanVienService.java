package com.example.__nguyenvanan_lap3.services;

import com.example.__nguyenvanan_lap3.entity.NhanVien;
import com.example.__nguyenvanan_lap3.repository.INhanvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private INhanvienRepository nhanvienRepository;

    public List<NhanVien> getAllNhanviens() {
        return nhanvienRepository.findAll();
    }

    public NhanVien getNhanvienById(String maNV) {
        return nhanvienRepository.findById(maNV).orElse(null);
    }

    public void addNhanvien(NhanVien nhanvien) {
        nhanvienRepository.save(nhanvien);
    }

    public void deleteNhanvien(String maNV) {
        nhanvienRepository.deleteById(maNV);
    }

    public void updateNhanvien(NhanVien nhanvien) {
        nhanvienRepository.save(nhanvien);
    }
}