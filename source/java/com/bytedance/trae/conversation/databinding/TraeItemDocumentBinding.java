package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeItemDocumentBinding implements ViewBinding {
    public final View divider;
    public final ImageView ivExpand;
    public final ImageView ivIcon;
    public final RadioButton rbSelect;
    private final ConstraintLayout rootView;
    public final TextView tvName;

    private TraeItemDocumentBinding(ConstraintLayout constraintLayout, View view, ImageView imageView, ImageView imageView2, RadioButton radioButton, TextView textView) {
        this.rootView = constraintLayout;
        this.divider = view;
        this.ivExpand = imageView;
        this.ivIcon = imageView2;
        this.rbSelect = radioButton;
        this.tvName = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemDocumentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemDocumentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_item_document, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemDocumentBinding bind(View view) {
        int i = C0637R.id.divider;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = C0637R.id.iv_expand;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C0637R.id.iv_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = C0637R.id.rb_select;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                    if (radioButton != null) {
                        i = C0637R.id.tv_name;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new TraeItemDocumentBinding((ConstraintLayout) view, findChildViewById, imageView, imageView2, radioButton, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
