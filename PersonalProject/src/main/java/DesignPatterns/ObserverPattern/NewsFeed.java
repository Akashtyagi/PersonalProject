package DesignPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class NewsFeed implements Observerable {
    ArrayList newsChannels = new ArrayList();
    private ArrayList<String> newsFeed = new ArrayList<>();


    @Override
    public void addObserver(Observer observer) {
        System.out.println("Observer added to the Observerable: " + observer.getClass().getName());
        this.newsChannels.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.newsChannels.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Updating all the obversers ...");
        for(Object observer: newsChannels) {
            Observer channel = (Observer) observer;
            channel.update();

        }
    }

    public ArrayList getNews(){
        return newsFeed;
    }

    private void addNews(String news){
        this.newsFeed.add(news);
    }

    public static void main(String[] args) {

        /*
        News Feed is the central class from which all news channels pull info. Hence Newsfeed: Observable
        HTNewsChannel is a news channel that needs to be updated with the news from NewsFeed. Hence HTNewsChannel: Observer
         */
        NewsFeed newsFeed = new NewsFeed();
        HTNewsChannel htNewsChannel = new HTNewsChannel(newsFeed);

        // HTNewsChannel has some news of its own
        htNewsChannel.addNews("News ht101").addNews("News ht102").addNews("News ht103");
        System.out.println("News in HT News Channel: ");
        htNewsChannel.printNews();

        // NewsFeed gets some news
        newsFeed.addNews("News 1");
        newsFeed.addNews("News 2");
        newsFeed.addNews("News 3");

        // NewsFeed updates all its subscribers about latest news.
        System.out.println("\n Updating All News Channels with latest news");
        newsFeed.notifyObservers();

        // Using the above pattern, not all the observers had to be handled separately.
    }
}
