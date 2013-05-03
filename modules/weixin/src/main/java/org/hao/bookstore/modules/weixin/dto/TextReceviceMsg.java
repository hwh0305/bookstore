package org.hao.bookstore.modules.weixin.dto;

import org.hao.bookstore.modules.weixin.constants.MessageType;

public class TextReceviceMsg extends RecevieMsg {

    private static final long serialVersionUID = 5719702572904893808L;

    private String            content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public MessageType getMsgType() {
        return MessageType.text;
    }

}
