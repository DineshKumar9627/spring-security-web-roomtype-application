package com.sunglowsys.service;

import com.sunglowsys.domain.RoomType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RoomTypeService {

    RoomType save(RoomType roomType);
    RoomType update(RoomType roomType);
    Optional<RoomType> findById(Long id);
    Page<RoomType> findAll(Pageable pageable);
    List<RoomType> search(String searchText);
    void delete(Long id);
}
