package com.tranquangvi.QLHoatDongSinhVien.modules.user.services;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.TieuChiEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.ChucVuEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.repositories.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChucVuService {
    @Autowired
    private ChucVuRepository chucVuRepository;
    public List<ChucVuEntity> findAll(){
        return chucVuRepository.findAll();
    }

    public ChucVuEntity findById(String id){
        Optional<ChucVuEntity> optional = chucVuRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new RuntimeException("Mã chức vụ không tồn tại!");
    }

    public void addChucVu(ChucVuEntity chucVu){
        Optional<ChucVuEntity> optional = chucVuRepository.findById(chucVu.getMaChucVu());
        if(optional.isPresent()){
            throw new RuntimeException("Mã chức vụ đã tồn tại!");
        }
        else
            chucVuRepository.save(chucVu);

    }


    public void edit(String maChucVu, ChucVuEntity chucVu){
        try {
            ChucVuEntity entity = findById(maChucVu);
            if(entity!=null){
                chucVuRepository.save(chucVu);
            }
            else
                throw new RuntimeException("Không tìm thấy chức vụ!");
        }catch (Exception e){
            throw new RuntimeException("Lỗi khi xóa: "+ e.getMessage());
        }
    }
    public void deleteById(String maChucVu){
        try {
            chucVuRepository.deleteById(maChucVu);

        }catch (Exception e){
            throw new RuntimeException("Chức vụ đang được sử dụng. Không thể xóa!");
        }
    }

}
