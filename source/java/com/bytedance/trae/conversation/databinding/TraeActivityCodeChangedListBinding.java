package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeActivityCodeChangedListBinding implements ViewBinding {
    public final ImageView btnBack;
    private final LinearLayout rootView;
    public final RecyclerView rvCodeChangedList;
    public final TextView tvTitle;

    private TraeActivityCodeChangedListBinding(LinearLayout linearLayout, ImageView imageView, RecyclerView recyclerView, TextView textView) {
        this.rootView = linearLayout;
        this.btnBack = imageView;
        this.rvCodeChangedList = recyclerView;
        this.tvTitle = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeActivityCodeChangedListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityCodeChangedListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_activity_code_changed_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityCodeChangedListBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_code_changed_list))) != null) {
            i = C0637R.id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new TraeActivityCodeChangedListBinding((LinearLayout) view, imageView, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
