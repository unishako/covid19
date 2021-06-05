package com.example.covid19.controller;

import com.example.covid19.model.dto.Covid19Dto;
import com.example.covid19.model.dto.ListForm;
import com.example.covid19.model.service.Covid19Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/list")
@RequiredArgsConstructor
public class ListController {

    private final Covid19Service covid19Service;

    @RequestMapping
    public String execute(ListForm form) {
        List<Covid19Dto> dtoList = covid19Service.search("21");
        return "list";
    }
}
