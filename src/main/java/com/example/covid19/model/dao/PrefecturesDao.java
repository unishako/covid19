package com.example.covid19.model.dao;

import com.example.covid19.model.dto.Prefectures;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface PrefecturesDao {

    /**
     * 都道府県コードで検索
     *
     * @return {@link List <Prefectures>} 都道府県リスト
     */
    @Select
    List<Prefectures> findAll();
}
