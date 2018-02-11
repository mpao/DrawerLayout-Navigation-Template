package io.github.mpao.drawerlayouttemplate.di;

import javax.inject.Singleton;
import dagger.Component;
import io.github.mpao.drawerlayouttemplate.viewmodels.NewsViewModel;

@Singleton
@Component(modules = {
        NewsModule.class
})
public interface Graph {

    void inject(NewsViewModel newsViewModel);

}
