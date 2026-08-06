package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.trae.home.R;

/* loaded from: classes5.dex */
public final class PopupMessageDeleteBinding implements ViewBinding {
    private final LinearLayout rootView;

    private PopupMessageDeleteBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PopupMessageDeleteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PopupMessageDeleteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.popup_message_delete, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PopupMessageDeleteBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new PopupMessageDeleteBinding((LinearLayout) view);
    }
}
