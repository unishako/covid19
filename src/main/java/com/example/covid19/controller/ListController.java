package com.example.covid19.controller;

import com.example.covid19.model.dto.Covid19;
import com.example.covid19.model.service.Covid19Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/list")
@RequiredArgsConstructor
public class ListController {

    private final Covid19Service covid19Service;

    /**
     * 初期表示
     *
     * @return {@link String} 一覧画面
     */
    @GetMapping
    public String init() {
        return "list";
    }

    @PostMapping
    public String search() {
        List<Covid19> covid19List = covid19Service.search("21");
        return "list";
    }
}
