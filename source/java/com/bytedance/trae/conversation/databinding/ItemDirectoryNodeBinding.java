package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ItemDirectoryNodeBinding implements ViewBinding {
    public final View divider;
    public final ImageView ivArrow;
    public final ImageView ivIcon;
    public final ProgressBar progressLoading;
    public final RadioButton rbSelect;
    private final ConstraintLayout rootView;
    public final TextView tvName;
    public final View viewIndent;

    private ItemDirectoryNodeBinding(ConstraintLayout constraintLayout, View view, ImageView imageView, ImageView imageView2, ProgressBar progressBar, RadioButton radioButton, TextView textView, View view2) {
        this.rootView = constraintLayout;
        this.divider = view;
        this.ivArrow = imageView;
        this.ivIcon = imageView2;
        this.progressLoading = progressBar;
        this.rbSelect = radioButton;
        this.tvName = textView;
        this.viewIndent = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemDirectoryNodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemDirectoryNodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.item_directory_node, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemDirectoryNodeBinding bind(View view) {
        View findChildViewById;
        int i = C0637R.id.divider;
        View findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = C0637R.id.iv_arrow;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C0637R.id.iv_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = C0637R.id.progress_loading;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                    if (progressBar != null) {
                        i = C0637R.id.rb_select;
                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                        if (radioButton != null) {
                            i = C0637R.id.tv_name;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.view_indent))) != null) {
                                return new ItemDirectoryNodeBinding((ConstraintLayout) view, findChildViewById2, imageView, imageView2, progressBar, radioButton, textView, findChildViewById);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
