package com.example.covid19.model.service;

import com.example.covid19.model.dao.Covid19Dao;
import com.example.covid19.model.dto.Covid19;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Covid19Service {

    private final Covid19Dao covid19Dao;

    /**
     * covid19を都道府県コードで検索
     *
     * @param prefecturesCode {@link String} 都道府県コード
     * @return {@link List<Covid19>} covid19リスト
     */
    public List<Covid19> search(String prefecturesCode) {
        return covid19Dao.selectByPrefecturesCode(prefecturesCode);
    }
}
