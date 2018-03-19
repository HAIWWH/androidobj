package com.stengg.android.sns.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.stengg.android.sns.R;
/*
 * Powered By [178zhe.com]
 * Web Site: http://www.178zhe.com 
 * Since 2010 - 2011
 */

public class LoadableListActivity extends ListActivity {

    private int mNoSearchResultsString = getNoSearchResultsStringId();

    private ProgressBar mEmptyProgress;
    
    private TextView mEmptyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.loadable_list_view);
        mEmptyProgress = (ProgressBar)findViewById(R.id.emptyProgress);
        mEmptyText = (TextView)findViewById(R.id.emptyText);
        setLoadingView();
    }

    public void setEmptyView() {
        mEmptyProgress.setVisibility(ViewGroup.GONE);
        mEmptyText.setText(mNoSearchResultsString);
    }

    public void setLoadingView() {
        mEmptyProgress.setVisibility(ViewGroup.VISIBLE);
        mEmptyText.setText(R.string.loading);
    }

    public int getNoSearchResultsStringId() {
        return R.string.no_search_results;
    }
}