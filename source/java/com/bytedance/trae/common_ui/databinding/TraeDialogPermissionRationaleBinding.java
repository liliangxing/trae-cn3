package com.bytedance.trae.common_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common_ui.R;

/* loaded from: classes5.dex */
public final class TraeDialogPermissionRationaleBinding implements ViewBinding {
    public final TextView btnAllow;
    public final TextView btnDeny;
    public final TextView btnDenyPermanent;
    public final ImageView ivIcon;
    private final LinearLayout rootView;
    public final TextView tvMessage;
    public final TextView tvTitle;

    private TraeDialogPermissionRationaleBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btnAllow = textView;
        this.btnDeny = textView2;
        this.btnDenyPermanent = textView3;
        this.ivIcon = imageView;
        this.tvMessage = textView4;
        this.tvTitle = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeDialogPermissionRationaleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeDialogPermissionRationaleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_dialog_permission_rationale, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeDialogPermissionRationaleBinding bind(View view) {
        int i = R.id.btn_allow;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btn_deny;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.btn_deny_permanent;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.iv_icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.tv_message;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.tv_title;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                return new TraeDialogPermissionRationaleBinding((LinearLayout) view, textView, textView2, textView3, imageView, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
