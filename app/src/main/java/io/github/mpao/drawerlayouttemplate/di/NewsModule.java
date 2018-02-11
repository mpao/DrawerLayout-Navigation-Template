package io.github.mpao.drawerlayouttemplate.di;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import io.github.mpao.drawerlayouttemplate.models.repositories.NewsData;
import io.github.mpao.drawerlayouttemplate.models.repositories.NewsDataImpl;

@Module
public class NewsModule {

    @Singleton
    @Provides
    public NewsData provide(){
        return new NewsDataImpl();
    }

}

