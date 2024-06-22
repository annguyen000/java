package com.example.__nguyenvanan_lap3.services;
import com.example.__nguyenvanan_lap3.entity.PhongBan;
import com.example.__nguyenvanan_lap3.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PhongBanService {
        @Autowired
        private IPhongBanRepository phongBanRepository;

        public List<PhongBan> getAllPhongBans() {
                return phongBanRepository.findAll();
        }

        public PhongBan getPhongBanById(String maCa) {
                return phongBanRepository.findById(maCa).orElse(null);
        }

        public PhongBan savePhongBan(PhongBan phongBan) {
                return phongBanRepository.save(phongBan);
        }

        public void deletePhongBan(String maCa) {
                phongBanRepository.deleteById(maCa);
        }
}