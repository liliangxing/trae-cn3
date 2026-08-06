package com.bytedance.trae.common_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common_ui.C0591R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeActivitySimpleWebviewBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TraeTitleBar titleBar;
    public final WebView webview;

    private TraeActivitySimpleWebviewBinding(LinearLayout linearLayout, TraeTitleBar traeTitleBar, WebView webView) {
        this.rootView = linearLayout;
        this.titleBar = traeTitleBar;
        this.webview = webView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeActivitySimpleWebviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivitySimpleWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0591R.layout.trae_activity_simple_webview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivitySimpleWebviewBinding bind(View view) {
        int i = C0591R.id.title_bar;
        TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
        if (traeTitleBar != null) {
            i = C0591R.id.webview;
            WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
            if (webView != null) {
                return new TraeActivitySimpleWebviewBinding((LinearLayout) view, traeTitleBar, webView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
