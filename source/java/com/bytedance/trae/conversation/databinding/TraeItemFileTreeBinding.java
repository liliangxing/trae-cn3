package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeItemFileTreeBinding implements ViewBinding {
    public final ImageView ivIcon;
    public final ImageView ivIndicator;
    public final LinearLayout llIndent;
    private final LinearLayout rootView;
    public final TextView tvFilename;

    private TraeItemFileTreeBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.ivIcon = imageView;
        this.ivIndicator = imageView2;
        this.llIndent = linearLayout2;
        this.tvFilename = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemFileTreeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemFileTreeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_item_file_tree, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemFileTreeBinding bind(View view) {
        int i = R.id.iv_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_indicator;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.ll_indent;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.tv_filename;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new TraeItemFileTreeBinding((LinearLayout) view, imageView, imageView2, linearLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
