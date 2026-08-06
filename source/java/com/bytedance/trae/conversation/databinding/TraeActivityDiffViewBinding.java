package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeActivityDiffViewBinding implements ViewBinding {
    public final ImageView btnBack;
    public final ImageView btnExtend;
    public final TextView btnRetry;
    public final LinearLayout btnRight;
    public final LinearLayout layoutError;
    public final LinearLayout llTitleContainer;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final Toolbar toolbar;
    public final TextView tvErrorSubtitle;
    public final TextView tvErrorTitle;
    public final TextView tvSubtitle;
    public final TextView tvTitle;
    public final WebView webviewDiff;

    private TraeActivityDiffViewBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ProgressBar progressBar, Toolbar toolbar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, WebView webView) {
        this.rootView = linearLayout;
        this.btnBack = imageView;
        this.btnExtend = imageView2;
        this.btnRetry = textView;
        this.btnRight = linearLayout2;
        this.layoutError = linearLayout3;
        this.llTitleContainer = linearLayout4;
        this.progressBar = progressBar;
        this.toolbar = toolbar;
        this.tvErrorSubtitle = textView2;
        this.tvErrorTitle = textView3;
        this.tvSubtitle = textView4;
        this.tvTitle = textView5;
        this.webviewDiff = webView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeActivityDiffViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityDiffViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_activity_diff_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityDiffViewBinding bind(View view) {
        Toolbar findChildViewById;
        int i = C0637R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0637R.id.btn_extend;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = C0637R.id.btn_retry;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C0637R.id.btn_right;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = C0637R.id.layout_error;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = C0637R.id.ll_title_container;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout3 != null) {
                                i = C0637R.id.progress_bar;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                if (progressBar != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.toolbar))) != null) {
                                    i = C0637R.id.tv_error_subtitle;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = C0637R.id.tv_error_title;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = C0637R.id.tv_subtitle;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = C0637R.id.tv_title;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = C0637R.id.webview_diff;
                                                    WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
                                                    if (webView != null) {
                                                        return new TraeActivityDiffViewBinding((LinearLayout) view, imageView, imageView2, textView, linearLayout, linearLayout2, linearLayout3, progressBar, findChildViewById, textView2, textView3, textView4, textView5, webView);
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
