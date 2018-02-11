package io.github.mpao.drawerlayouttemplate.di;

import android.app.Application;

public class App extends Application {

    public static Graph graph;

    @Override
    public void onCreate(){

        super.onCreate();
        graph = DaggerGraph.builder()
                .newsModule( new NewsModule() )
                .build();

    }

}
