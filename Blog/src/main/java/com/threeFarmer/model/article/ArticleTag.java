package com.threeFarmer.model.article;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 文章栏目实体类
 */
public class ArticleTag implements Serializable {

    private Integer id;
    @NotBlank(message = "栏目名称不能为空")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}