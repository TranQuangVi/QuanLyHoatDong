package com.tranquangvi.QLHoatDongSinhVien.modules.event.service;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.NoiDungToChucDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.NoiDungToChucEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper.NoiDungToChucMapperImpl;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.repository.NoiDungToChucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.*;


@Service
public class NoiDungToChucService {
    @Autowired
    private  NoiDungToChucRepository noiDungToChucRepository;
    @Autowired
    private NoiDungToChucMapperImpl noiDungToChucMapper;
    @Autowired
    private HoatDongService hoatDongService;


    public List<NoiDungToChucDto> getAll(){
        List<NoiDungToChucEntity> noiDungToChucs = noiDungToChucRepository.findAll();
        List<NoiDungToChucDto> listDto = new ArrayList<NoiDungToChucDto>();
        for (NoiDungToChucEntity noiDung: noiDungToChucs) {
            NoiDungToChucDto dto = noiDungToChucMapper.toDto(noiDung);
            dto.setMaHoatDong(noiDung.getHoatDong().getMaHoatDong());
            listDto.add(dto);
        }
        return listDto;
    }

//    public List<NoiDungToChucDto>  getByHoatdongId(String maHoatDong){
//        List<NoiDungToChucEntity> noiDungToChucs = noiDungToChucRepository.findAll();
//        return  noiDungToChucs;
//    }

    public NoiDungToChucDto getById(String maNoiDung)
    {
        Optional<NoiDungToChucEntity> entity = noiDungToChucRepository.findById(maNoiDung);
        if(entity.isPresent()){
            NoiDungToChucDto dto = noiDungToChucMapper.toDto(entity.get());
            return dto;
        }
        throw new RuntimeException("Ma noi dung not found!");
    }

    public List<NoiDungToChucDto> getByMaHoatDong(String maHoatDong){
        List<NoiDungToChucDto> list = noiDungToChucMapper.toDto(noiDungToChucRepository.findByMaHoatDong(maHoatDong));
        for(NoiDungToChucDto item: list){
            item.setMaHoatDong(maHoatDong);
        }
        return list;
    }

    public void add(NoiDungToChucDto dto){
        if(noiDungToChucRepository.findById(dto.getMaNoiDung()).isPresent()){
            throw new  RuntimeException("Tên nội dung đã tồn tại!");
        }
        NoiDungToChucEntity entity = noiDungToChucMapper.toEntity(dto);
        entity.setHoatDong(hoatDongService.getById(dto.getMaHoatDong()));
        noiDungToChucRepository.save(entity);

    }

    public void delete(String id){
        Optional<NoiDungToChucEntity> entity = noiDungToChucRepository.findById(id);
        if(entity.isPresent()){
            noiDungToChucRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Ma noi dung not found!");

        }
    }

    public void update(NoiDungToChucDto dto){
        try {
            Optional<NoiDungToChucEntity> entity = noiDungToChucRepository.findById(dto.getMaNoiDung());
            if(entity.isPresent()){
                NoiDungToChucEntity noidung = noiDungToChucMapper.toEntity(dto);
                noidung.setHoatDong(hoatDongService.getById(dto.getMaHoatDong()));
                noiDungToChucRepository.save(noidung);
            }
            else {
                throw new RuntimeException("Không tìm thấy mã nội dung: " + dto.getMaNoiDung());
            }
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
}
