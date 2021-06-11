package com.example.covid19.controller;

import com.example.covid19.model.dto.Covid19Dto;
import com.example.covid19.model.dto.ListForm;
import com.example.covid19.model.dto.PrefecturesDto;
import com.example.covid19.model.service.Covid19Service;
import com.example.covid19.model.service.PrefecturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/list")
@RequiredArgsConstructor
public class ListController {

    /**
     * 都道府県サービス
     */
    private final PrefecturesService prefecturesService;
    /**
     * Covid19サービス
     */
    private final Covid19Service covid19Service;

    /**
     * 画面表示
     *
     * @param model    {@link Model} モデル
     * @param listForm {@link ListForm} フォーム
     * @return {@link String} 遷移先画面
     */
    @RequestMapping
    public String execute(Model model, ListForm listForm) {

        model.addAttribute("listForm", listForm);

        List<PrefecturesDto> prefecturesDtoList = prefecturesService.list();
        model.addAttribute("prefecturesDtoList", prefecturesDtoList);

        if ("検索".equals(listForm.getAction())) {
            List<Covid19Dto> covid19DtoList = covid19Service.search(listForm.getPrefecturesCode());
            model.addAttribute("covid19DtoList", covid19DtoList);
        }
        return "list";
    }
}
