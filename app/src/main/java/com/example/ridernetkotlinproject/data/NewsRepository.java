package com.example.ridernetkotlinproject.data;

import com.example.ridernetkotlinproject.data.repository.INewsRepository;
import com.example.ridernetkotlinproject.presentation.model.news.News;

public class NewsRepository implements INewsRepository {
    @Override
    public void addedNews(News news) {

    }

    @Override
    public News getNews() {
        return null;
    }

    @Override
    public void deleteNews(News news) {

    }

    @Override
    public void editNews(News news) {

    }
}
