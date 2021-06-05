package com.example.covid19.model.service;

import com.example.covid19.model.dao.PrefecturesDao;
import com.example.covid19.model.dto.Prefectures;
import com.example.covid19.model.dto.PrefecturesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrefecturesService {

    private final PrefecturesDao prefecturesDao;

    public List<PrefecturesDto> list() {
        List<Prefectures> list = prefecturesDao.findAll();
        List<PrefecturesDto> dtoList = new ArrayList<>();
        list.forEach(e -> {
            PrefecturesDto dto = new PrefecturesDto() {
                {
                    setPrefecturesCode(e.getPrefecturesCode());
                    setPrefecturesName(e.getPrefecturesName());
                }
            };
            dtoList.add(dto);
        });
        return dtoList;
    }
}
