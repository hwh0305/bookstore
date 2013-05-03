package org.hao.bookstore.modules.weixin.dto;

public abstract class RecevieMsg extends BaseMsg {

    private static final long serialVersionUID = -6235326937232978383L;
    private long              msgId;

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

}
