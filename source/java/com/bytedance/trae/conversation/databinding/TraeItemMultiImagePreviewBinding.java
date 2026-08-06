package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeItemMultiImagePreviewBinding implements ViewBinding {
    public final SimpleDraweeView ivPagerImage;
    private final FrameLayout rootView;

    private TraeItemMultiImagePreviewBinding(FrameLayout frameLayout, SimpleDraweeView simpleDraweeView) {
        this.rootView = frameLayout;
        this.ivPagerImage = simpleDraweeView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemMultiImagePreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemMultiImagePreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_item_multi_image_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemMultiImagePreviewBinding bind(View view) {
        int i = C0637R.id.iv_pager_image;
        SimpleDraweeView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new TraeItemMultiImagePreviewBinding((FrameLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
