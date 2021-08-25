package com.haebun.erhb.search;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.haebun.erhb.R;

public class SearchFragment extends Fragment {
    int layout;

    private WebView web;

    public SearchFragment(int layout) {
        this.layout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layout, container, false);

        web = (WebView) view.findViewById(R.id.search_dak_gg);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://dak.gg/bser/players/%ED%98%9C%EC%99%80%EC%99%80");
        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClientClass());


        return view;
    }
    
    private class WebViewClientClass extends WebViewClient {//페이지 이동
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}