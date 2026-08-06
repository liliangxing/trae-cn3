package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeLayoutArtifactPreviewBinding implements ViewBinding {
    public final ImageView btnBack;
    public final FrameLayout btnDownload;
    public final TextView btnMainDownload;
    public final TextView downloadStatusTile;
    public final FrameLayout imageContainer;
    public final SimpleDraweeView ivPreview;
    public final LinearLayout layoutContent;
    public final LinearLayout llTitleContainer;
    public final LinearLayout llTrailingActions;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final ScrollView scrollMarkdown;
    public final ScrollView scrollTxt;
    public final SimpleMarkdownTextView tvMarkdown;
    public final TextView tvSubtitle;
    public final TextView tvTitle;
    public final TextView tvTxt;
    public final WebView webview;

    private TraeLayoutArtifactPreviewBinding(LinearLayout linearLayout, ImageView imageView, FrameLayout frameLayout, TextView textView, TextView textView2, FrameLayout frameLayout2, SimpleDraweeView simpleDraweeView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ProgressBar progressBar, ScrollView scrollView, ScrollView scrollView2, SimpleMarkdownTextView simpleMarkdownTextView, TextView textView3, TextView textView4, TextView textView5, WebView webView) {
        this.rootView = linearLayout;
        this.btnBack = imageView;
        this.btnDownload = frameLayout;
        this.btnMainDownload = textView;
        this.downloadStatusTile = textView2;
        this.imageContainer = frameLayout2;
        this.ivPreview = simpleDraweeView;
        this.layoutContent = linearLayout2;
        this.llTitleContainer = linearLayout3;
        this.llTrailingActions = linearLayout4;
        this.progressBar = progressBar;
        this.scrollMarkdown = scrollView;
        this.scrollTxt = scrollView2;
        this.tvMarkdown = simpleMarkdownTextView;
        this.tvSubtitle = textView3;
        this.tvTitle = textView4;
        this.tvTxt = textView5;
        this.webview = webView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeLayoutArtifactPreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeLayoutArtifactPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_layout_artifact_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeLayoutArtifactPreviewBinding bind(View view) {
        SimpleDraweeView findChildViewById;
        int i = C0637R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0637R.id.btn_download;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = C0637R.id.btn_main_download;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C0637R.id.download_status_tile;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = C0637R.id.image_container;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.iv_preview))) != null) {
                            i = C0637R.id.layout_content;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = C0637R.id.ll_title_container;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = C0637R.id.ll_trailing_actions;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout3 != null) {
                                        i = C0637R.id.progress_bar;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                        if (progressBar != null) {
                                            i = C0637R.id.scroll_markdown;
                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                            if (scrollView != null) {
                                                i = C0637R.id.scroll_txt;
                                                ScrollView scrollView2 = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                if (scrollView2 != null) {
                                                    i = C0637R.id.tv_markdown;
                                                    SimpleMarkdownTextView simpleMarkdownTextView = (SimpleMarkdownTextView) ViewBindings.findChildViewById(view, i);
                                                    if (simpleMarkdownTextView != null) {
                                                        i = C0637R.id.tv_subtitle;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = C0637R.id.tv_title;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = C0637R.id.tv_txt;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = C0637R.id.webview;
                                                                    WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
                                                                    if (webView != null) {
                                                                        return new TraeLayoutArtifactPreviewBinding((LinearLayout) view, imageView, frameLayout, textView, textView2, frameLayout2, findChildViewById, linearLayout, linearLayout2, linearLayout3, progressBar, scrollView, scrollView2, simpleMarkdownTextView, textView3, textView4, textView5, webView);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
