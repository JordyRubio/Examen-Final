/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.entity.Pedido;
import com.example.demo.service.PedidoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/prod")
public class PedidoController {
     @Autowired
    private PedidoService pedidoService;
    
    @GetMapping("/all")
    public String listarCl(Model model){
        //String keyword = "Yogurt";
        model.addAttribute("pedido", pedidoService.readAll());
        return "prod/listarCl";
    }
    
    @GetMapping("/form")
    public String createCl(Model model){
        model.addAttribute("titulo", "Registrar Pedido");
        model.addAttribute("pedido", new Pedido());
        return "prod/formCl";
    }
    
    @PostMapping("/add")
    public String saveCl(@Valid @ModelAttribute Pedido cl, BindingResult result, Model model, RedirectAttributes attributes){
        pedidoService.create(cl);
        //model.addAttribute("categorias", categoriaService.readAll());
        return "redirect:/prod/all";
    }
    
    @GetMapping("/del/{id}")
    public String deleteCl(Model model, @PathVariable("id") Integer idcl ){
        pedidoService.delete(idcl);
        return "redirect:/prod/all";
    }
    
    @GetMapping("/edit/{id}")
    public String editCl(Model model, @PathVariable("id") Integer idcl ){
        Pedido pedido = pedidoService.read(idcl);
        model.addAttribute("titulo", "Modificar pedido");
        model.addAttribute("pedido", pedido);
        return "prod/formCl";
    }
    
    @PostMapping("/{id}")
    public String readCl(Model model, @PathVariable("id") Integer idcl ){
        model.addAttribute("prod", pedidoService.read(idcl));
        return "redirect:/prod";
    }
    
}

