package com.day19.newsSubscription;

public interface NewsAgency {
	void subscribe(Subscriber s);

	void unSubscribe(Subscriber s);

	void publishNews(String news);

}
