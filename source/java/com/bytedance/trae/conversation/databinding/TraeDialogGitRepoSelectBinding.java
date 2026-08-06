package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeDialogGitRepoSelectBinding implements ViewBinding {
    public final TextView btnGoToGithub;
    public final EditText etSearch;
    public final ImageView ivSearchClear;
    public final ImageView ivSearchIcon;
    public final LinearLayout layoutContainer;
    public final LinearLayout layoutEmptyState;
    public final ProgressBar pbLoadingMore;
    public final ProgressBar pbSearchLoading;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final RecyclerView rvRepositories;
    public final FrameLayout searchContainer;
    public final TraeTitleBar titleBar;
    public final TextView tvEmptyHint;
    public final TextView tvSearchEmpty;

    private TraeDialogGitRepoSelectBinding(LinearLayout linearLayout, TextView textView, EditText editText, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, LinearLayout linearLayout3, ProgressBar progressBar, ProgressBar progressBar2, ProgressBar progressBar3, RecyclerView recyclerView, FrameLayout frameLayout, TraeTitleBar traeTitleBar, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnGoToGithub = textView;
        this.etSearch = editText;
        this.ivSearchClear = imageView;
        this.ivSearchIcon = imageView2;
        this.layoutContainer = linearLayout2;
        this.layoutEmptyState = linearLayout3;
        this.pbLoadingMore = progressBar;
        this.pbSearchLoading = progressBar2;
        this.progressBar = progressBar3;
        this.rvRepositories = recyclerView;
        this.searchContainer = frameLayout;
        this.titleBar = traeTitleBar;
        this.tvEmptyHint = textView2;
        this.tvSearchEmpty = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeDialogGitRepoSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeDialogGitRepoSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_dialog_git_repo_select, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeDialogGitRepoSelectBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.btn_go_to_github;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C0637R.id.et_search;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = C0637R.id.iv_search_clear;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = C0637R.id.iv_search_icon;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = C0637R.id.layout_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = C0637R.id.layout_empty_state;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = C0637R.id.pb_loading_more;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                if (progressBar != null) {
                                    i = C0637R.id.pb_search_loading;
                                    ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                    if (progressBar2 != null) {
                                        i = C0637R.id.progress_bar;
                                        ProgressBar progressBar3 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                        if (progressBar3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_repositories))) != null) {
                                            i = C0637R.id.search_container;
                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                            if (frameLayout != null) {
                                                i = C0637R.id.title_bar;
                                                TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                                                if (traeTitleBar != null) {
                                                    i = C0637R.id.tv_empty_hint;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = C0637R.id.tv_search_empty;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            return new TraeDialogGitRepoSelectBinding((LinearLayout) view, textView, editText, imageView, imageView2, linearLayout, linearLayout2, progressBar, progressBar2, progressBar3, findChildViewById, frameLayout, traeTitleBar, textView2, textView3);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
