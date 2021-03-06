package com.example.covid19.model.service;

import com.example.covid19.model.dao.Covid19Dao;
import com.example.covid19.model.dto.Covid19;
import com.example.covid19.model.dto.Covid19Dto;
import com.example.covid19.util.FormatUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Covid19Service {
    /**
     * Covid19Dao
     */
    private final Covid19Dao covid19Dao;

    /**
     * covid19を都道府県コードで検索
     *
     * @param prefecturesCode {@link String} 都道府県コード
     * @return {@link List<Covid19Dto>} covid19リスト
     */
    public List<Covid19Dto> search(String prefecturesCode) {

        List<Covid19> list = covid19Dao.findByPrefecturesCode(prefecturesCode);
        List<Covid19Dto> dtoList = new ArrayList<>();
        list.forEach(e -> {
            Covid19Dto dto = new Covid19Dto() {
                {
                    setYyyyMmDd(e.getYyyyMmDd());
                    setPrefecturesCode(e.getPrefecturesCode());
                    setPrefecturesName(e.getPrefecturesName());
                    setInfectionPersonCountOneDay(FormatUtil.toComma(e.getInfectionPersonCountOneDay()));
                    setInfectionPersonCountTotal(FormatUtil.toComma(e.getInfectionPersonCountTotal()));
                    setDeadCountOneDay(FormatUtil.toComma(e.getDeadCountOneDay()));
                    setDeadCountTotal(FormatUtil.toComma(e.getDeadCountTotal()));
                }
            };
            dtoList.add(dto);
        });
        return dtoList;
    }

}
