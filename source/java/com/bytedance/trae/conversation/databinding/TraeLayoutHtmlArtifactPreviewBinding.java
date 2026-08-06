package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeLayoutHtmlArtifactPreviewBinding implements ViewBinding {
    public final TextView btnMainDownload;
    public final TextView downloadStatusTile;
    public final ImageView ivLoading;
    public final LinearLayout layoutContent;
    public final LinearLayout progressBar;
    private final FrameLayout rootView;
    public final TraeTitleBar titleBar;
    public final WebView webview;

    private TraeLayoutHtmlArtifactPreviewBinding(FrameLayout frameLayout, TextView textView, TextView textView2, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, TraeTitleBar traeTitleBar, WebView webView) {
        this.rootView = frameLayout;
        this.btnMainDownload = textView;
        this.downloadStatusTile = textView2;
        this.ivLoading = imageView;
        this.layoutContent = linearLayout;
        this.progressBar = linearLayout2;
        this.titleBar = traeTitleBar;
        this.webview = webView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeLayoutHtmlArtifactPreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeLayoutHtmlArtifactPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_layout_html_artifact_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeLayoutHtmlArtifactPreviewBinding bind(View view) {
        int i = C0637R.id.btn_main_download;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C0637R.id.download_status_tile;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = C0637R.id.iv_loading;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = C0637R.id.layout_content;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = C0637R.id.progress_bar;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = C0637R.id.title_bar;
                            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                            if (traeTitleBar != null) {
                                i = C0637R.id.webview;
                                WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
                                if (webView != null) {
                                    return new TraeLayoutHtmlArtifactPreviewBinding((FrameLayout) view, textView, textView2, imageView, linearLayout, linearLayout2, traeTitleBar, webView);
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
