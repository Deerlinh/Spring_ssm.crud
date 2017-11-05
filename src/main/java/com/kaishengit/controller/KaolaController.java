package com.kaishengit.controller;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.kaishengit.entity.Kaola;
import com.kaishengit.service.KaolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

/**
 * Created by 蔡林红 on 2017/11/4.
 */
@Controller
@RequestMapping("/product")
public class KaolaController {
    @Autowired
    private KaolaService kaolaService;

    @GetMapping
    public  String list(@RequestParam(name="p",required = false,defaultValue = "1")Integer pageNo,
                        @RequestParam(required = false,defaultValue = "" )String productName,
                        @RequestParam(required = false,defaultValue = "") String place,
                        @RequestParam(required = false,defaultValue = "") String typeId,
                        Model model
                        ){
        Map<String,Object> map= Maps.newHashMap();
        map.put("productName",productName);
        map.put("place",place);
        map.put("typeId",typeId);

        PageInfo<Kaola> pageInfo=kaolaService.findByPageNo(pageNo,map);

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("placeList",kaolaService.findProducrPlaceList());
        model.addAttribute("typeList",kaolaService.findByTypeAll());
        return "product/list";
    }

    @GetMapping("/new")
    public String findProduct(Model model){
        model.addAttribute("typeList",kaolaService.findByTypeAll());
        return "product/new";

    }

    @PostMapping("/new")
    public String findProduct(Kaola kaola,RedirectAttributes redirectAttributes){
        kaolaService.save(kaola);
        redirectAttributes.addFlashAttribute("message","添加成功");
        return "redirect:/product";
    }

    @GetMapping("/{id:\\d+}")
    public String shawProduct(@PathVariable Integer id,Model model){
    Kaola kaola= kaolaService.findById(id);
    model.addAttribute("kaola",kaola);
    return "product/show";
    }

    @GetMapping("/{id:\\d+}/edit")
    public String edit(@PathVariable Integer id, Model model){
       model.addAttribute("typeList", kaolaService.findByTypeAll());
       model.addAttribute("product",kaolaService.findById(id));
        return  "product/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String edit(Kaola kaola,RedirectAttributes redirectAttributes){
        kaolaService.editKaola(kaola);
        redirectAttributes.addFlashAttribute("message","修改成功");
        return  "redirect:/product/"+kaola.getId();

    }

    @GetMapping("/{id:\\d+}/delete")
    public  String delete(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        kaolaService.deleteKaola(id);
        redirectAttributes.addFlashAttribute("message","删除成功");
        return "redirect:/product";
    }
}
