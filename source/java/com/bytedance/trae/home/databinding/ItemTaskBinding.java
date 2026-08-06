package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.home.R;

/* loaded from: classes5.dex */
public final class ItemTaskBinding implements ViewBinding {
    public final LinearLayout btnDelete;
    public final LinearLayout btnPin;
    public final LinearLayout btnRename;
    public final FrameLayout flIconContainer;
    public final ImageView ivEmojiIcon;
    public final ImageView ivPin;
    public final ImageView ivProductIcon;
    public final ImageView ivSourceIcon;
    public final LinearLayout layoutContent;
    public final LinearLayout layoutSwipeActions;
    public final LinearLayout llInfoLeft;
    public final ProgressBar pbLoading;
    private final FrameLayout rootView;
    public final TextView tvDot1;
    public final TextView tvLocation;
    public final TextView tvPin;
    public final TextView tvTime;
    public final TextView tvTitle;
    public final View vBadge;

    private ItemTaskBinding(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.rootView = frameLayout;
        this.btnDelete = linearLayout;
        this.btnPin = linearLayout2;
        this.btnRename = linearLayout3;
        this.flIconContainer = frameLayout2;
        this.ivEmojiIcon = imageView;
        this.ivPin = imageView2;
        this.ivProductIcon = imageView3;
        this.ivSourceIcon = imageView4;
        this.layoutContent = linearLayout4;
        this.layoutSwipeActions = linearLayout5;
        this.llInfoLeft = linearLayout6;
        this.pbLoading = progressBar;
        this.tvDot1 = textView;
        this.tvLocation = textView2;
        this.tvPin = textView3;
        this.tvTime = textView4;
        this.tvTitle = textView5;
        this.vBadge = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemTaskBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_task, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemTaskBinding bind(View view) {
        View findChildViewById;
        int i = R.id.btn_delete;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.btn_pin;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.btn_rename;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout3 != null) {
                    i = R.id.fl_icon_container;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = R.id.iv_emoji_icon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.iv_pin;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.iv_product_icon;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.iv_source_icon;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView4 != null) {
                                        i = R.id.layout_content;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout4 != null) {
                                            i = R.id.layout_swipe_actions;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout5 != null) {
                                                i = R.id.ll_info_left;
                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout6 != null) {
                                                    i = R.id.pb_loading;
                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                    if (progressBar != null) {
                                                        i = R.id.tv_dot1;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView != null) {
                                                            i = R.id.tv_location;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView2 != null) {
                                                                i = R.id.tv_pin;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView3 != null) {
                                                                    i = R.id.tv_time;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tv_title;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView5 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_badge))) != null) {
                                                                            return new ItemTaskBinding((FrameLayout) view, linearLayout, linearLayout2, linearLayout3, frameLayout, imageView, imageView2, imageView3, imageView4, linearLayout4, linearLayout5, linearLayout6, progressBar, textView, textView2, textView3, textView4, textView5, findChildViewById);
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
