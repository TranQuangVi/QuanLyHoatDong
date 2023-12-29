package com.tranquangvi.QLHoatDongSinhVien.modules.event.service;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.TieuChiEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.repository.TieuChiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TieuChiService {
    @Autowired
    private TieuChiRepository tieuChiRepository;

//    public List<TieuChiEntity> getAll(){
//        return tieuChiRepository.findAll();
//    }
    public Page<TieuChiEntity> getAll(Pageable pageable){
        return tieuChiRepository.findAll(pageable);
    }
    public void save(TieuChiEntity tieuChi){
        tieuChiRepository.save(tieuChi);
    }
    public TieuChiEntity getById(String id){
        Optional<TieuChiEntity> tieuChi= tieuChiRepository.findById(id);
        if(tieuChi.isPresent())
            return tieuChi.get();
        else
            throw new RuntimeException("Tiêu chí không tồn tại!");
    }
    public void edit(String maTieuChi, TieuChiEntity tieuChi){
        try {
            TieuChiEntity entity = getById(maTieuChi);
            if(entity!=null){
                tieuChiRepository.updateTieuChi(maTieuChi,tieuChi.getMaTieuChi(),tieuChi.getTenTieuChi());
            }
            else
                throw new RuntimeException("Tiêu chí không tồn tại!");
        }catch (Exception e){
            throw new RuntimeException("Lỗi khi xóa: "+ e.getMessage());
        }
    }
    public void deleteById(String maTieuChi){
        try {
            tieuChiRepository.deleteById(maTieuChi);

        }catch (Exception e){
            throw new RuntimeException("Tiêu chí đang được sử dụng. Không thể xóa!");
        }
    }
}
