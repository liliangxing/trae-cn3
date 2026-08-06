package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeItemRevertFileBinding implements ViewBinding {
    public final View indicator;
    private final LinearLayout rootView;
    public final TextView tvFileAction;
    public final TextView tvFilePath;

    private TraeItemRevertFileBinding(LinearLayout linearLayout, View view, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.indicator = view;
        this.tvFileAction = textView;
        this.tvFilePath = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemRevertFileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemRevertFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_item_revert_file, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemRevertFileBinding bind(View view) {
        int i = R.id.indicator;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.tv_file_action;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_file_path;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new TraeItemRevertFileBinding((LinearLayout) view, findChildViewById, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
