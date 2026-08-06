package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeActivityArtifactListBinding implements ViewBinding {
    public final ImageView btnBack;
    public final TextView btnRetry;
    public final LinearLayout layoutError;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final RecyclerView rvArtifactList;
    public final TextView tvEmpty;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private TraeActivityArtifactListBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, LinearLayout linearLayout2, ProgressBar progressBar, RecyclerView recyclerView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.btnBack = imageView;
        this.btnRetry = textView;
        this.layoutError = linearLayout2;
        this.progressBar = progressBar;
        this.rvArtifactList = recyclerView;
        this.tvEmpty = textView2;
        this.tvSubtitle = textView3;
        this.tvTitle = textView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeActivityArtifactListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityArtifactListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_activity_artifact_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityArtifactListBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0637R.id.btn_retry;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = C0637R.id.layout_error;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = C0637R.id.progress_bar;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                    if (progressBar != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_artifact_list))) != null) {
                        i = C0637R.id.tv_empty;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = C0637R.id.tv_subtitle;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = C0637R.id.tv_title;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    return new TraeActivityArtifactListBinding((LinearLayout) view, imageView, textView, linearLayout, progressBar, findChildViewById, textView2, textView3, textView4);
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
