package com.example.__nguyenvanan_lap3.controller;


import com.example.__nguyenvanan_lap3.entity.NhanVien;
import com.example.__nguyenvanan_lap3.services.NhanVienService;
import com.example.__nguyenvanan_lap3.services.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanvienService;

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String showAllNhanviens(Model model) {
        List<NhanVien> nhanviens = nhanvienService.getAllNhanviens();
        model.addAttribute("nhanviens", nhanviens);
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String addNhanvienForm(Model model) {
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("phongbans", phongBanService.getAllPhongBans());
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNhanvien(@Valid @ModelAttribute("nhanvien") NhanVien nhanvien, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("phongbans", phongBanService.getAllPhongBans());
            return "nhanvien/add";
        }
        nhanvienService.addNhanvien(nhanvien);
        return "redirect:/nhanviens";
    }

//    @GetMapping("/edit/{maNV}")
//    public String editNhanvien(@PathVariable("maNV") String maNV, Model model) {
//        NhanVien nhanvien = nhanvienService.getNhanvienById(maNV);
//        model.addAttribute("nhanvien", nhanvien);
//        model.addAttribute("phongbans", phongBanService.getAllPhongBans());
//        return "nhanvien/edit";
//    }
//
//    @PostMapping("/edit")
//    public String editNhanvien(@Valid @ModelAttribute("nhanvien") NhanVien nhanvien, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("phongbans", phongBanService.getAllPhongBans());
//            return "nhanvien/edit";
//        }
//        nhanvienService.updateNhanvien(nhanvien);
//        return "redirect:/nhanviens";
//    }

    @GetMapping("/edit/{maNV}")
    public String editNhanvien(@PathVariable("maNV") String maNV, Model model) {
        NhanVien nhanvien = nhanvienService.getNhanvienById(maNV);
        model.addAttribute("nhanvien", nhanvien);
        model.addAttribute("phongbans", phongBanService.getAllPhongBans());
        return "nhanvien/edit";
    }

    @PostMapping("/edit")
    public String editNhanvien(@Valid @ModelAttribute("nhanvien") NhanVien nhanvien, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("phongbans", phongBanService.getAllPhongBans());
            return "nhanvien/edit";
        }
        nhanvienService.updateNhanvien(nhanvien);
        return "redirect:/nhanviens";
    }


    @PostMapping("/delete/{maNV}")
    public String deleteNhanvien(@PathVariable("maNV") String maNV) {
        nhanvienService.deleteNhanvien(maNV);
        return "redirect:/nhanviens";
    }



}