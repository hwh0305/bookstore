package org.hao.bookstore.modules.weixin.dto;

import org.hao.bookstore.modules.weixin.constants.MessageType;

public class ImageRecevieMsg extends RecevieMsg {

    private static final long serialVersionUID = 7500736726488746211L;
    private String            picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public MessageType getMsgType() {
        return MessageType.image;
    }

    
}
