package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentSiteMessageSettingsBinding implements ViewBinding {
    public final ProgressBar loading;
    private final LinearLayout rootView;
    public final ScrollView scrollView;
    public final LinearLayout stackView;
    public final TraeTitleBar titleBar;

    private FragmentSiteMessageSettingsBinding(LinearLayout linearLayout, ProgressBar progressBar, ScrollView scrollView, LinearLayout linearLayout2, TraeTitleBar traeTitleBar) {
        this.rootView = linearLayout;
        this.loading = progressBar;
        this.scrollView = scrollView;
        this.stackView = linearLayout2;
        this.titleBar = traeTitleBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSiteMessageSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSiteMessageSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_site_message_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSiteMessageSettingsBinding bind(View view) {
        int i = C0820R.id.loading;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
        if (progressBar != null) {
            i = C0820R.id.scroll_view;
            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
            if (scrollView != null) {
                i = C0820R.id.stack_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = C0820R.id.title_bar;
                    TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                    if (traeTitleBar != null) {
                        return new FragmentSiteMessageSettingsBinding((LinearLayout) view, progressBar, scrollView, linearLayout, traeTitleBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
