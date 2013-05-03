package org.hao.bookstore.modules.weixin.dto;

import java.io.Serializable;
import java.util.Date;

import org.hao.bookstore.modules.weixin.constants.MessageType;

public abstract class BaseMsg implements Serializable {

    private static final long serialVersionUID = 3067296205407660315L;

    private String            toUserName;

    private String            fromUserName;

    private long              createTime;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Date getCreateTime() {
        return createTime == 0L ? null : new Date(createTime);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime == null ? 0L : createTime.getTime();
    }

    abstract public MessageType getMsgType();
}
