package org.hao.bookstore.modules.weixin.dto;

import org.hao.bookstore.modules.weixin.constants.MessageType;

public class MusicSendMsg extends SendMsg {

    private static final long serialVersionUID = 2465148522116473838L;
    private String            musicUrl;
    private String            hqMusicUrl;

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }

    @Override
    public MessageType getMsgType() {
        return MessageType.music;
    }

}
