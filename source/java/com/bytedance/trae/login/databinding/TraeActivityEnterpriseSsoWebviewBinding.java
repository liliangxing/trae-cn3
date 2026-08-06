package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.login.R;

/* loaded from: classes4.dex */
public final class TraeActivityEnterpriseSsoWebviewBinding implements ViewBinding {
    public final ImageView btnBack;
    public final ProgressBar pbLoading;
    private final LinearLayout rootView;
    public final WebView webview;

    private TraeActivityEnterpriseSsoWebviewBinding(LinearLayout linearLayout, ImageView imageView, ProgressBar progressBar, WebView webView) {
        this.rootView = linearLayout;
        this.btnBack = imageView;
        this.pbLoading = progressBar;
        this.webview = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeActivityEnterpriseSsoWebviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityEnterpriseSsoWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_activity_enterprise_sso_webview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityEnterpriseSsoWebviewBinding bind(View view) {
        int i = R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.pb_loading;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null) {
                i = R.id.webview;
                WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
                if (webView != null) {
                    return new TraeActivityEnterpriseSsoWebviewBinding((LinearLayout) view, imageView, progressBar, webView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
