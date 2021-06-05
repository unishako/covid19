package com.example.covid19.model.dto;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;

@Entity(metamodel = @Metamodel)
@Data
public class Prefectures {
    /**
     * 都道府県コード
     */
    @Id
    private String prefecturesCode;
    /**
     * 都道府県名
     */
    private String prefecturesName;
}
