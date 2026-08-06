package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.mediachoose.widget.SquareFrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeMediaChooseItemMediaBinding implements ViewBinding {
    public final SimpleDraweeView ivThumb;
    private final SquareFrameLayout rootView;
    public final FrameLayout selectionContainer;
    public final TextView tvDuration;
    public final TextView tvOrder;
    public final View vMask;

    private TraeMediaChooseItemMediaBinding(SquareFrameLayout squareFrameLayout, SimpleDraweeView simpleDraweeView, FrameLayout frameLayout, TextView textView, TextView textView2, View view) {
        this.rootView = squareFrameLayout;
        this.ivThumb = simpleDraweeView;
        this.selectionContainer = frameLayout;
        this.tvDuration = textView;
        this.tvOrder = textView2;
        this.vMask = view;
    }

    public SquareFrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeMediaChooseItemMediaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeMediaChooseItemMediaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_media_choose_item_media, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeMediaChooseItemMediaBinding bind(View view) {
        View findChildViewById;
        int i = C0637R.id.iv_thumb;
        SimpleDraweeView findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = C0637R.id.selection_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = C0637R.id.tv_duration;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C0637R.id.tv_order;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.v_mask))) != null) {
                        return new TraeMediaChooseItemMediaBinding((SquareFrameLayout) view, findChildViewById2, frameLayout, textView, textView2, findChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
