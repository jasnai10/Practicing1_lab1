package com.example.demo.controller;

import com.example.demo.Beans.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String paginaPrincipal (){
        return "Bienvenidos a GTICS 20204-2";
    }

    @RequestMapping(value = {"/holaGTICS", "/prueba", "test"}, method = RequestMethod.GET)
    public String holaGTICS(){
        return "hola";
    }

    @PostMapping("/persona/guardar")
    public String guardarPersona (@RequestParam("nombre") String nombrePersona,
                                  @RequestParam("apellido") String apellidoPersona,
                                  @RequestParam(name = "dni") String dniPersona){
        System.out.println("Nombre: " + nombrePersona + "\n" +
                "Apellido: " + apellidoPersona + "\n" +
                "DNI: " + dniPersona);
        return "redirect:/persona?id=" + dniPersona;
    }

    @GetMapping("/persona")
    public String formularioPersona (){
        return "form1";
    }


    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("msg", "este es un mensaje");
        model.addAttribute("nombre1", "Carlos");
        model.addAttribute("cantidad1", 20);
        return "home";
    }

    @GetMapping("/persona1")
    public String unaPersona(Model model){
        Persona persona = new Persona("Juan", "Perez","1234567",20);
        model.addAttribute("persona", persona);
        return "home";
    }

}
