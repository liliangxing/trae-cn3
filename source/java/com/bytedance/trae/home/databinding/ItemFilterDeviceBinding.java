package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.home.R;

/* loaded from: classes5.dex */
public final class ItemFilterDeviceBinding implements ViewBinding {
    public final LinearLayout itemDevice;
    public final ImageView ivCheckDevice;
    public final ImageView ivDeviceIcon;
    public final LinearLayout llProductTag;
    private final LinearLayout rootView;
    public final TextView tvDeviceName;
    public final TextView tvProductType;

    private ItemFilterDeviceBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout3, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.itemDevice = linearLayout2;
        this.ivCheckDevice = imageView;
        this.ivDeviceIcon = imageView2;
        this.llProductTag = linearLayout3;
        this.tvDeviceName = textView;
        this.tvProductType = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemFilterDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemFilterDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_filter_device, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemFilterDeviceBinding bind(View view) {
        int i = R.id.item_device;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.iv_check_device;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_device_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.ll_product_tag;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.tv_device_name;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_product_type;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new ItemFilterDeviceBinding((LinearLayout) view, linearLayout, imageView, imageView2, linearLayout2, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
