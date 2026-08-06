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
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentEditProfileBinding implements ViewBinding {
    public final FrameLayout btnEditAvatar;
    public final LinearLayout btnEditName;
    public final View dividerEmail;
    public final ImageView imgAvatarEditIndicator;
    public final SimpleDraweeView ivAvatar;
    private final LinearLayout rootView;
    public final LinearLayout rowEmail;
    public final TraeTitleBar titleBar;
    public final TextView tvAccountLabel;
    public final TextView tvEmailValue;
    public final TextView tvNameValue;

    private FragmentEditProfileBinding(LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, View view, ImageView imageView, SimpleDraweeView simpleDraweeView, LinearLayout linearLayout3, TraeTitleBar traeTitleBar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnEditAvatar = frameLayout;
        this.btnEditName = linearLayout2;
        this.dividerEmail = view;
        this.imgAvatarEditIndicator = imageView;
        this.ivAvatar = simpleDraweeView;
        this.rowEmail = linearLayout3;
        this.titleBar = traeTitleBar;
        this.tvAccountLabel = textView;
        this.tvEmailValue = textView2;
        this.tvNameValue = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEditProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEditProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_edit_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentEditProfileBinding bind(View view) {
        View findChildViewById;
        SimpleDraweeView findChildViewById2;
        int i = C0820R.id.btn_edit_avatar;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C0820R.id.btn_edit_name;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.divider_email))) != null) {
                i = C0820R.id.img_avatar_edit_indicator;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0820R.id.iv_avatar))) != null) {
                    i = C0820R.id.row_email;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = C0820R.id.title_bar;
                        TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                        if (traeTitleBar != null) {
                            i = C0820R.id.tv_account_label;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = C0820R.id.tv_email_value;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = C0820R.id.tv_name_value;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        return new FragmentEditProfileBinding((LinearLayout) view, frameLayout, linearLayout, findChildViewById, imageView, findChildViewById2, linearLayout2, traeTitleBar, textView, textView2, textView3);
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
