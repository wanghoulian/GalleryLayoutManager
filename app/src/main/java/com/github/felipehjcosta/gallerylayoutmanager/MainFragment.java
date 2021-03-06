package com.github.felipehjcosta.gallerylayoutmanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.github.felipehjcosta.gallerylayoutmanager.base.BaseRestoreFragment;

public class MainFragment extends BaseRestoreFragment implements Toolbar.OnMenuItemClickListener {
    @BindView(com.github.felipehjcosta.gallerylayoutmanager.R.id.toolbar)
    Toolbar mToolbar;
    @BindView(com.github.felipehjcosta.gallerylayoutmanager.R.id.main_btn_pager)
    Button mMainBtnPager;
    @BindView(com.github.felipehjcosta.gallerylayoutmanager.R.id.main_btn_gallery)
    Button mMainBtnGallery;


    private MainActivity mMainActivity;

    /**
     * Generate by live templates.
     * Use FragmentManager to find this Fragment's instance by tag
     */
    public static MainFragment findFragment(FragmentManager manager) {
        return (MainFragment) manager.findFragmentByTag(MainFragment.class.getSimpleName());
    }

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivity = (MainActivity) context;
    }

    @Override
    protected View onCreateContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(com.github.felipehjcosta.gallerylayoutmanager.R.layout.fragment_main, container, false);
    }

    @Override
    protected void initView(View root, Bundle savedInstanceState) {
        ButterKnife.bind(this, root);
        mToolbar.inflateMenu(com.github.felipehjcosta.gallerylayoutmanager.R.menu.base_github);
        mToolbar.setOnMenuItemClickListener(this);
    }


    @Override
    protected void initData(Bundle savedInstanceState) {

    }


    @OnClick({com.github.felipehjcosta.gallerylayoutmanager.R.id.main_btn_pager, com.github.felipehjcosta.gallerylayoutmanager.R.id.main_btn_gallery})
    public void onClick(View view) {
        if (mMainActivity == null) {
            return;
        }
        switch (view.getId()) {
            case com.github.felipehjcosta.gallerylayoutmanager.R.id.main_btn_pager:
                mMainActivity.gotoFragment(MainActivity.SHOW_PAGER);
                break;
            case com.github.felipehjcosta.gallerylayoutmanager.R.id.main_btn_gallery:
                mMainActivity.gotoFragment(MainActivity.SHOW_GALLERY);
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == com.github.felipehjcosta.gallerylayoutmanager.R.id.menu_github) {
            openMyGitHub();
            return true;
        }
        return false;
    }

    private void openMyGitHub() {
        Uri uri = Uri.parse("https://github.com/BCsl");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }
}
