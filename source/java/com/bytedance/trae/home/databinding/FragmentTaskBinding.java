package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeLoadingView;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentTaskBinding implements ViewBinding {
    public final Button btnRetryNetwork;
    public final ImageButton btnTaskSearchClear;
    public final ImageButton btnTaskSearchExit;
    public final EditText etTaskSearch;
    public final FloatingActionButton fabAdd;
    public final ImageView ivTaskSearchInputIcon;
    public final TraeLoadingView ivTaskSearchLoading;
    public final LinearLayout layoutEmptyState;
    public final LinearLayout layoutNetworkError;
    public final LinearLayout layoutTaskSearchEmptyState;
    public final ConstraintLayout layoutTaskSearchHeader;
    public final LinearLayout layoutTaskSearchInput;
    public final LinearLayout layoutTaskSearchLoading;
    private final ConstraintLayout rootView;
    public final RecyclerView rvTasks;
    public final SwipeRefreshLayout swipeRefresh;
    public final TraeTitleBar titleBar;
    public final TextView tvTaskSearchEmptyText;

    private FragmentTaskBinding(ConstraintLayout constraintLayout, Button button, ImageButton imageButton, ImageButton imageButton2, EditText editText, FloatingActionButton floatingActionButton, ImageView imageView, TraeLoadingView traeLoadingView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ConstraintLayout constraintLayout2, LinearLayout linearLayout4, LinearLayout linearLayout5, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TraeTitleBar traeTitleBar, TextView textView) {
        this.rootView = constraintLayout;
        this.btnRetryNetwork = button;
        this.btnTaskSearchClear = imageButton;
        this.btnTaskSearchExit = imageButton2;
        this.etTaskSearch = editText;
        this.fabAdd = floatingActionButton;
        this.ivTaskSearchInputIcon = imageView;
        this.ivTaskSearchLoading = traeLoadingView;
        this.layoutEmptyState = linearLayout;
        this.layoutNetworkError = linearLayout2;
        this.layoutTaskSearchEmptyState = linearLayout3;
        this.layoutTaskSearchHeader = constraintLayout2;
        this.layoutTaskSearchInput = linearLayout4;
        this.layoutTaskSearchLoading = linearLayout5;
        this.rvTasks = recyclerView;
        this.swipeRefresh = swipeRefreshLayout;
        this.titleBar = traeTitleBar;
        this.tvTaskSearchEmptyText = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTaskBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_task, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentTaskBinding bind(View view) {
        FloatingActionButton findChildViewById;
        ConstraintLayout findChildViewById2;
        RecyclerView findChildViewById3;
        SwipeRefreshLayout findChildViewById4;
        int i = C0820R.id.btn_retry_network;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = C0820R.id.btn_task_search_clear;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
            if (imageButton != null) {
                i = C0820R.id.btn_task_search_exit;
                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i);
                if (imageButton2 != null) {
                    i = C0820R.id.et_task_search;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.fab_add))) != null) {
                        i = C0820R.id.iv_task_search_input_icon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = C0820R.id.iv_task_search_loading;
                            TraeLoadingView traeLoadingView = (TraeLoadingView) ViewBindings.findChildViewById(view, i);
                            if (traeLoadingView != null) {
                                i = C0820R.id.layout_empty_state;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = C0820R.id.layout_network_error;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = C0820R.id.layout_task_search_empty_state;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0820R.id.layout_task_search_header))) != null) {
                                            i = C0820R.id.layout_task_search_input;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout4 != null) {
                                                i = C0820R.id.layout_task_search_loading;
                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout5 != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = C0820R.id.rv_tasks))) != null && (findChildViewById4 = ViewBindings.findChildViewById(view, (i = C0820R.id.swipe_refresh))) != null) {
                                                    i = C0820R.id.title_bar;
                                                    TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                                                    if (traeTitleBar != null) {
                                                        i = C0820R.id.tv_task_search_empty_text;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView != null) {
                                                            return new FragmentTaskBinding((ConstraintLayout) view, button, imageButton, imageButton2, editText, findChildViewById, imageView, traeLoadingView, linearLayout, linearLayout2, linearLayout3, findChildViewById2, linearLayout4, linearLayout5, findChildViewById3, findChildViewById4, traeTitleBar, textView);
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
