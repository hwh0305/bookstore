package org.hao.bookstore.modules.goods.dto;

import java.io.Serializable;

import org.hao.bookstore.modules.commons.dto.BasePaginationQuery;

public class ProductQuery extends BasePaginationQuery implements Serializable {

    private static final long serialVersionUID = -7412556374995327378L;

    private String            keyword;

    private String            nickName;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
