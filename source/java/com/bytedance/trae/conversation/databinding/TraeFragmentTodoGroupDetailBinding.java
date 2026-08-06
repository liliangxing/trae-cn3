package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeFragmentTodoGroupDetailBinding implements ViewBinding {
    public final LinearLayout llContent;
    private final NestedScrollView rootView;
    public final TextView tvTodoTitle;

    private TraeFragmentTodoGroupDetailBinding(NestedScrollView nestedScrollView, LinearLayout linearLayout, TextView textView) {
        this.rootView = nestedScrollView;
        this.llContent = linearLayout;
        this.tvTodoTitle = textView;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static TraeFragmentTodoGroupDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentTodoGroupDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_fragment_todo_group_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentTodoGroupDetailBinding bind(View view) {
        int i = C0637R.id.ll_content;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0637R.id.tv_todo_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new TraeFragmentTodoGroupDetailBinding((NestedScrollView) view, linearLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
