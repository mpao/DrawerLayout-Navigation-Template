package io.github.mpao.drawerlayouttemplate.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.github.mpao.drawerlayouttemplate.R;
import io.github.mpao.drawerlayouttemplate.databinding.FragmentNewsBinding;
import io.github.mpao.drawerlayouttemplate.viewmodels.NewsViewModel;

public class NewsFragment extends Fragment {

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FragmentNewsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false);
        NewsViewModel viewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        viewModel.init();
        viewModel.getData().observe( this, binding.mockText::setText);

        return binding.getRoot();

    }

}
