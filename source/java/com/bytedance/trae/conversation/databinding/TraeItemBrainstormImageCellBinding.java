package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeItemBrainstormImageCellBinding implements ViewBinding {
    public final FrameLayout cardImageCell;
    public final ImageView ivCellClose;
    public final SimpleDraweeView ivCellPreview;
    public final FrameLayout overlayCellFailed;
    public final FrameLayout overlayCellLoading;
    private final FrameLayout rootView;

    private TraeItemBrainstormImageCellBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, SimpleDraweeView simpleDraweeView, FrameLayout frameLayout3, FrameLayout frameLayout4) {
        this.rootView = frameLayout;
        this.cardImageCell = frameLayout2;
        this.ivCellClose = imageView;
        this.ivCellPreview = simpleDraweeView;
        this.overlayCellFailed = frameLayout3;
        this.overlayCellLoading = frameLayout4;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemBrainstormImageCellBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemBrainstormImageCellBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_item_brainstorm_image_cell, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemBrainstormImageCellBinding bind(View view) {
        SimpleDraweeView findChildViewById;
        int i = C0637R.id.card_image_cell;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C0637R.id.iv_cell_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.iv_cell_preview))) != null) {
                i = C0637R.id.overlay_cell_failed;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout2 != null) {
                    i = C0637R.id.overlay_cell_loading;
                    FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout3 != null) {
                        return new TraeItemBrainstormImageCellBinding((FrameLayout) view, frameLayout, imageView, findChildViewById, frameLayout2, frameLayout3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
