package io.github.mpao.drawerlayouttemplate.models.repositories;

import android.arch.lifecycle.LiveData;

public interface NewsData {

    LiveData<String> get();

}
