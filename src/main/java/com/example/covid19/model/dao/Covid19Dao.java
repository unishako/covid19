package com.example.covid19.model.dao;

import com.example.covid19.model.dto.Covid19;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface Covid19Dao {

    /**
     * 都道府県コードで検索
     *
     * @param prefecturesCode {@link String} 都道府県コード
     * @return {@link List<Covid19>} covid19リスト
     */
    @Select
    List<Covid19> selectByPrefecturesCode(String prefecturesCode);
}
