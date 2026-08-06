package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeItemTaskLocationAddBinding implements ViewBinding {
    private final LinearLayout rootView;

    private TraeItemTaskLocationAddBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemTaskLocationAddBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemTaskLocationAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_item_task_location_add, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemTaskLocationAddBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new TraeItemTaskLocationAddBinding((LinearLayout) view);
    }
}
