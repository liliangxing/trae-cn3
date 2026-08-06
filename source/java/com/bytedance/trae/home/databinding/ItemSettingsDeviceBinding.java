package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.home.R;

/* loaded from: classes5.dex */
public final class ItemSettingsDeviceBinding implements ViewBinding {
    public final LinearLayout btnDelete;
    public final LinearLayout btnRename;
    public final ImageView ivDeviceIcon;
    public final LinearLayout layoutContent;
    public final FrameLayout layoutDeviceIconContainer;
    public final LinearLayout layoutSwipeActions;
    public final LinearLayout llProductType;
    private final FrameLayout rootView;
    public final TextView tvDeviceName;
    public final TextView tvDeviceStatus;
    public final TextView tvProductType;

    private ItemSettingsDeviceBinding(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, LinearLayout linearLayout3, FrameLayout frameLayout2, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.btnDelete = linearLayout;
        this.btnRename = linearLayout2;
        this.ivDeviceIcon = imageView;
        this.layoutContent = linearLayout3;
        this.layoutDeviceIconContainer = frameLayout2;
        this.layoutSwipeActions = linearLayout4;
        this.llProductType = linearLayout5;
        this.tvDeviceName = textView;
        this.tvDeviceStatus = textView2;
        this.tvProductType = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemSettingsDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemSettingsDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_settings_device, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemSettingsDeviceBinding bind(View view) {
        int i = R.id.btn_delete;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.btn_rename;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.iv_device_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.layout_content;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout3 != null) {
                        i = R.id.layout_device_icon_container;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            i = R.id.layout_swipe_actions;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout4 != null) {
                                i = R.id.ll_product_type;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout5 != null) {
                                    i = R.id.tv_device_name;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.tv_device_status;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.tv_product_type;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                return new ItemSettingsDeviceBinding((FrameLayout) view, linearLayout, linearLayout2, imageView, linearLayout3, frameLayout, linearLayout4, linearLayout5, textView, textView2, textView3);
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
