package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.home.R;

/* loaded from: classes5.dex */
public final class DialogTaskFilterBinding implements ViewBinding {
    public final LinearLayout itemAll;
    public final LinearLayout itemCloud;
    public final ImageView ivCheckAll;
    public final ImageView ivCheckCloud;
    public final LinearLayout llDeviceContainer;
    private final LinearLayout rootView;

    private DialogTaskFilterBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView, ImageView imageView2, LinearLayout linearLayout4) {
        this.rootView = linearLayout;
        this.itemAll = linearLayout2;
        this.itemCloud = linearLayout3;
        this.ivCheckAll = imageView;
        this.ivCheckCloud = imageView2;
        this.llDeviceContainer = linearLayout4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogTaskFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogTaskFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_task_filter, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogTaskFilterBinding bind(View view) {
        int i = R.id.item_all;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.item_cloud;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.iv_check_all;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.iv_check_cloud;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.ll_device_container;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null) {
                            return new DialogTaskFilterBinding((LinearLayout) view, linearLayout, linearLayout2, imageView, imageView2, linearLayout3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
