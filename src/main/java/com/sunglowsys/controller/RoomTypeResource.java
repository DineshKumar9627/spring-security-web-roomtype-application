package com.sunglowsys.controller;
import com.sunglowsys.domain.RoomType;
import com.sunglowsys.service.RoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/api")
public class RoomTypeResource {

    private final Logger log = LoggerFactory.getLogger(RoomTypeService.class);

    private final RoomTypeService roomTypeService;

    public RoomTypeResource(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }
    @GetMapping
    public ModelAndView home(){
       log.debug("Web request to  create home page");
        Page<RoomType> page = roomTypeService.findAll(PageRequest.of(0,20));
        return  new ModelAndView("index","roomtypes",page.getContent());
    }

    @GetMapping("/roomtypes/create")
    public ModelAndView createform(@ModelAttribute RoomType roomType){
        log.debug("Web request to create form: {}",roomType);
        return  new ModelAndView("add-roomtype","roomType",new RoomType());
    }
    @PostMapping("/roomtypes")
    public ModelAndView createRoomType(@ModelAttribute RoomType roomType){
        log.debug("Web request to create roomtype: {}",roomType);
        return  new ModelAndView("redirect:/","roomtypes",roomTypeService.save(roomType));
    }

    @GetMapping("/roomtypes/update/{id}")
    public ModelAndView update(@PathVariable Long id){
        log.debug("Web request to update roomtype:{}",id);
        return  new ModelAndView("Add-roomtype","roomtype",roomTypeService.findById(id).get());
    }
    @GetMapping("/roomtypes")
    public ModelAndView searchText(@RequestParam String searchText){
        log.debug("Web request to search roomtypes");
        return new ModelAndView("index","roomtype",roomTypeService.search(searchText));
    }

    @GetMapping("/roomtypes/delete/{id}")
    public ModelAndView delete(@PathVariable Long id ){
        log.debug("Web request to delete roomtype: {}",id);
        return new ModelAndView("redirect:/");

    }

}
