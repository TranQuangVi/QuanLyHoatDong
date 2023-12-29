package com.tranquangvi.QLHoatDongSinhVien.modules.event.service;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.LoaiHoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.repository.LoaiHoatDongRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class LoaiHoatDongService {
    @Autowired
    private LoaiHoatDongRepository loaiHoatDongRepository;

    public LoaiHoatDongEntity save(LoaiHoatDongEntity loaiHoatDong) {
        return loaiHoatDongRepository.save(loaiHoatDong);
    }

    public void deleteById(String id) {
        loaiHoatDongRepository.deleteById(id);
    }

    public LoaiHoatDongEntity getById(String id) {
        return loaiHoatDongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loaihoatdong not found with id: " + id));
    }

    public void update(LoaiHoatDongEntity loaiHoatDong, String id) {
        LoaiHoatDongEntity entity = getById(id);
        if(entity==null)
            throw new RuntimeException("Loại hoạt động không tồn tại!");
        loaiHoatDongRepository.updateLoai(id,loaiHoatDong.getMaLoaiHoatDong(), loaiHoatDong.getTenLoaiHoatDong());
    }

    public Page<LoaiHoatDongEntity> getAll(Pageable pageable){
        return loaiHoatDongRepository.findAll(pageable);
    }
}
