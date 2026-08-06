package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeActivityWebPreviewBinding implements ViewBinding {
    public final ImageView btnBack;
    public final TextView btnRetry;
    public final TextView btnStartAgent;
    public final FrameLayout errorContainer;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final TextView statusError;
    public final TextView statusErrorDesc;
    public final TextView tvTitle;
    public final WebView webview;

    private TraeActivityWebPreviewBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, FrameLayout frameLayout, ProgressBar progressBar, TextView textView3, TextView textView4, TextView textView5, WebView webView) {
        this.rootView = linearLayout;
        this.btnBack = imageView;
        this.btnRetry = textView;
        this.btnStartAgent = textView2;
        this.errorContainer = frameLayout;
        this.progressBar = progressBar;
        this.statusError = textView3;
        this.statusErrorDesc = textView4;
        this.tvTitle = textView5;
        this.webview = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeActivityWebPreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityWebPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_activity_web_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityWebPreviewBinding bind(View view) {
        int i = R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.btn_retry;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.btn_start_agent;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.error_container;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = R.id.progress_bar;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            i = R.id.status_error;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.status_error_desc;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.tv_title;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.webview;
                                        WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
                                        if (webView != null) {
                                            return new TraeActivityWebPreviewBinding((LinearLayout) view, imageView, textView, textView2, frameLayout, progressBar, textView3, textView4, textView5, webView);
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
