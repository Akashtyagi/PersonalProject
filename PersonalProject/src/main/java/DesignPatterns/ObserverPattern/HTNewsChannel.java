package DesignPatterns.ObserverPattern;

import java.util.ArrayList;

public class HTNewsChannel implements Observer {

    private ArrayList<String> news = new ArrayList();
    private NewsFeed newsFeed;

    public HTNewsChannel(NewsFeed newsFeed){
        newsFeed.addObserver(this);
        this.newsFeed = newsFeed;
    }

    @Override
    public void update() {
        news.addAll(this.newsFeed.getNews());
        System.out.println("News updated in HT News Channel: " );
        for (Object news: this.news) {
            System.out.println(news);
        }
    }

    public void printNews(){
        for(String news: this.news){
            System.out.println(news);
        }
    }

    public HTNewsChannel addNews(String news){
        this.news.add(news);
        return this;
    }
}
