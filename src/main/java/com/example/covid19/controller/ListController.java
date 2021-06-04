package com.example.covid19.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
@RequiredArgsConstructor
public class ListController {

    /**
     * 初期表示
     *
     * @return {@link String} 一覧画面
     */
    @GetMapping
    public String init() {
        return "list";
    }

}
