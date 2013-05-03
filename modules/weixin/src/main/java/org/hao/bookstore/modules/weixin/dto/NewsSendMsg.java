package org.hao.bookstore.modules.weixin.dto;

import java.io.Serializable;
import java.util.List;

import org.hao.bookstore.modules.weixin.constants.MessageType;

public class NewsSendMsg extends SendMsg {

    private static final long serialVersionUID = -3962234022315209910L;
    private int               articleCount;
    private List<News>        articles;

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }

    @Override
    public MessageType getMsgType() {
        return MessageType.news;
    }

    public static class News implements Serializable {

        private static final long serialVersionUID = 8938633714734475133L;
        private String            title;
        private String            description;
        private String            picUrl;
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

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }
}
