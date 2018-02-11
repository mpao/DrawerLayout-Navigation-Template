package io.github.mpao.drawerlayouttemplate.models.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.Handler;

public class NewsDataImpl implements NewsData {

    private MutableLiveData<String> data = new MutableLiveData<>();

    @Override
    public LiveData<String> get() {

        new Handler().postDelayed( ()-> data.setValue("value from background"), 5000);

        return data;
    }

}
