package org.hao.bookstore.modules.weixin.dto;

import org.hao.bookstore.modules.weixin.constants.MessageType;

public class LinkRecevieMsg extends RecevieMsg {

    private static final long serialVersionUID = 4522596030298327482L;
    private String            title;
    private String            description;
    private String            url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public MessageType getMsgType() {
        return MessageType.link;
    }

}
