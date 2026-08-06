package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeActivityPureShowWidgetFullscreenBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TraeTitleBar titleBar;
    public final WebView webview;

    private TraeActivityPureShowWidgetFullscreenBinding(LinearLayout linearLayout, TraeTitleBar traeTitleBar, WebView webView) {
        this.rootView = linearLayout;
        this.titleBar = traeTitleBar;
        this.webview = webView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeActivityPureShowWidgetFullscreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityPureShowWidgetFullscreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_activity_pure_show_widget_fullscreen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityPureShowWidgetFullscreenBinding bind(View view) {
        int i = C0637R.id.title_bar;
        TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
        if (traeTitleBar != null) {
            i = C0637R.id.webview;
            WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
            if (webView != null) {
                return new TraeActivityPureShowWidgetFullscreenBinding((LinearLayout) view, traeTitleBar, webView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
