package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeItemBrainstormFileCellBinding implements ViewBinding {
    public final FrameLayout cardFileCell;
    public final ImageView ivFileClose;
    public final ImageView ivFileTypeIcon;
    public final LinearLayout llFileContent;
    public final FrameLayout overlayFileFailed;
    public final FrameLayout overlayFileLoading;
    private final FrameLayout rootView;
    public final TextView tvFileName;
    public final TextView tvFileStatus;

    private TraeItemBrainstormFileCellBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, FrameLayout frameLayout3, FrameLayout frameLayout4, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.cardFileCell = frameLayout2;
        this.ivFileClose = imageView;
        this.ivFileTypeIcon = imageView2;
        this.llFileContent = linearLayout;
        this.overlayFileFailed = frameLayout3;
        this.overlayFileLoading = frameLayout4;
        this.tvFileName = textView;
        this.tvFileStatus = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemBrainstormFileCellBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemBrainstormFileCellBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_item_brainstorm_file_cell, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemBrainstormFileCellBinding bind(View view) {
        int i = R.id.card_file_cell;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.iv_file_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_file_type_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.ll_file_content;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.overlay_file_failed;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout2 != null) {
                            i = R.id.overlay_file_loading;
                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout3 != null) {
                                i = R.id.tv_file_name;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tv_file_status;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        return new TraeItemBrainstormFileCellBinding((FrameLayout) view, frameLayout, imageView, imageView2, linearLayout, frameLayout2, frameLayout3, textView, textView2);
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
