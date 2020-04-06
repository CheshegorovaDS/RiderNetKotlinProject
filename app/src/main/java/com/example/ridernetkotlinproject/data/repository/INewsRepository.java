package com.example.ridernetkotlinproject.data.repository;

import com.example.ridernetkotlinproject.presentation.model.news.News;

public interface INewsRepository {
    void addedNews(News news);
    News getNews();
    void deleteNews(News news);
    void editNews(News news);

    //List<News> getNewsBy
}
