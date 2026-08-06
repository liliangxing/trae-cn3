package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;
import com.bytedance.trae.conversation.mediachoose.widget.SquareFrameLayout;

/* loaded from: classes5.dex */
public final class TraeMediaChooseItemCameraBinding implements ViewBinding {
    public final ImageView ivCamera;
    private final SquareFrameLayout rootView;

    private TraeMediaChooseItemCameraBinding(SquareFrameLayout squareFrameLayout, ImageView imageView) {
        this.rootView = squareFrameLayout;
        this.ivCamera = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SquareFrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeMediaChooseItemCameraBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeMediaChooseItemCameraBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_media_choose_item_camera, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeMediaChooseItemCameraBinding bind(View view) {
        int i = R.id.iv_camera;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            return new TraeMediaChooseItemCameraBinding((SquareFrameLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
