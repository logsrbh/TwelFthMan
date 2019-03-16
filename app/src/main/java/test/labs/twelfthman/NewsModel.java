package test.labs.twelfthman;

public class NewsModel {

    public NewsModel() {
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    String newstitle;

    String news_id;

    public NewsModel(String newstitle, String news_id, String content, String imageUrl) {
        this.newstitle = newstitle;
        this.news_id = news_id;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    String content;

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    String imageUrl;
}
