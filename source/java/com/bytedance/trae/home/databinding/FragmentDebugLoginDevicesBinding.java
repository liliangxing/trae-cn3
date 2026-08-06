package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentDebugLoginDevicesBinding implements ViewBinding {
    public final ProgressBar progressLoading;
    private final LinearLayout rootView;
    public final RecyclerView rvLoginDevices;
    public final TraeTitleBar titleBar;
    public final TextView tvEmpty;

    private FragmentDebugLoginDevicesBinding(LinearLayout linearLayout, ProgressBar progressBar, RecyclerView recyclerView, TraeTitleBar traeTitleBar, TextView textView) {
        this.rootView = linearLayout;
        this.progressLoading = progressBar;
        this.rvLoginDevices = recyclerView;
        this.titleBar = traeTitleBar;
        this.tvEmpty = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDebugLoginDevicesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDebugLoginDevicesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_debug_login_devices, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentDebugLoginDevicesBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0820R.id.progress_loading;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
        if (progressBar != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.rv_login_devices))) != null) {
            i = C0820R.id.title_bar;
            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
            if (traeTitleBar != null) {
                i = C0820R.id.tv_empty;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new FragmentDebugLoginDevicesBinding((LinearLayout) view, progressBar, findChildViewById, traeTitleBar, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
