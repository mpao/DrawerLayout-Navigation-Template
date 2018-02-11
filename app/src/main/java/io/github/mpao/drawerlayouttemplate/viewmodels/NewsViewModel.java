package io.github.mpao.drawerlayouttemplate.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import javax.inject.Inject;
import io.github.mpao.drawerlayouttemplate.di.App;
import io.github.mpao.drawerlayouttemplate.models.repositories.NewsData;

public class NewsViewModel extends ViewModel {

    private LiveData<String> data;
    @Inject NewsData repo;

    public void init()  {

        App.graph.inject(this);
        this.data = repo.get();

    }

    public LiveData<String> getData() {

        return this.data;

    }

}
