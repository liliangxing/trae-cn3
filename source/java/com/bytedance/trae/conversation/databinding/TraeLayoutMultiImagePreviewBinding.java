package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeLayoutMultiImagePreviewBinding implements ViewBinding {
    public final ImageView btnBack;
    public final FrameLayout btnDownload;
    public final ProgressBar progressBar;
    private final FrameLayout rootView;
    public final FrameLayout topBar;
    public final TextView tvGeneratedByAi;
    public final TextView tvIndicator;
    public final ViewPager2 viewPager;

    private TraeLayoutMultiImagePreviewBinding(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, ProgressBar progressBar, FrameLayout frameLayout3, TextView textView, TextView textView2, ViewPager2 viewPager2) {
        this.rootView = frameLayout;
        this.btnBack = imageView;
        this.btnDownload = frameLayout2;
        this.progressBar = progressBar;
        this.topBar = frameLayout3;
        this.tvGeneratedByAi = textView;
        this.tvIndicator = textView2;
        this.viewPager = viewPager2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeLayoutMultiImagePreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeLayoutMultiImagePreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_layout_multi_image_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeLayoutMultiImagePreviewBinding bind(View view) {
        ViewPager2 findChildViewById;
        int i = C0637R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0637R.id.btn_download;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = C0637R.id.progress_bar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null) {
                    i = C0637R.id.top_bar;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout2 != null) {
                        i = C0637R.id.tv_generated_by_ai;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = C0637R.id.tv_indicator;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.view_pager))) != null) {
                                return new TraeLayoutMultiImagePreviewBinding((FrameLayout) view, imageView, frameLayout, progressBar, frameLayout2, textView, textView2, findChildViewById);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
