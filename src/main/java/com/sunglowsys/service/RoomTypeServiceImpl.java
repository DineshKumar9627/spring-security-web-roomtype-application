package com.sunglowsys.service;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.repository.RoomTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeServiceImpl implements RoomTypeService{

    private final Logger  log = LoggerFactory.getLogger(RoomTypeServiceImpl.class);

    private final RoomTypeRepository roomTypeRepository ;

    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }


    @Override
    public RoomType save(RoomType roomType) {
        log.debug("Request to create roomtype: {} ",roomType);
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType update(RoomType roomType) {
        log.debug("Request to update roomtype: {}",roomType);
        return roomTypeRepository.save(roomType);
    }

    @Override
    public Optional<RoomType> findById(Long id) {
        log.debug("request to find roomtype by id :{}",id);
        return roomTypeRepository.findById(id);
    }

    @Override
    public Page<RoomType> findAll(Pageable pageable) {
        log.debug("Request to find all roomtype:",pageable);
        return roomTypeRepository.findAll(pageable);
    }

    @Override
    public List<RoomType> search(String searchText) {
        log.debug("Request to search roomtype ");
        return roomTypeRepository.searchText(searchText);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete roomtype:{}",id);
        roomTypeRepository.deleteById(id);
    }
}
