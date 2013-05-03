package org.hao.bookstore.modules.weixin.dto;

import org.hao.bookstore.modules.weixin.constants.MessageType;

public class EventMsg extends BaseMsg {

    private static final long serialVersionUID = -7713437368316075425L;
    private String event;
    private String eventKey;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @Override
    public MessageType getMsgType() {
        return MessageType.event;
    }

}
