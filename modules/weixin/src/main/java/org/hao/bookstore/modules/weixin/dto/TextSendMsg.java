package org.hao.bookstore.modules.weixin.dto;

import org.hao.bookstore.modules.weixin.constants.MessageType;

public class TextSendMsg extends SendMsg {

    private static final long serialVersionUID = 7447891517813729945L;
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
