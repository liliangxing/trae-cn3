package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;
import com.bytedance.trae.conversation.brainstorm.widget.ThinkingDotsView;

/* loaded from: classes5.dex */
public final class TraeItemBrainstormThinkingDotsBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ThinkingDotsView thinkingDots;

    private TraeItemBrainstormThinkingDotsBinding(LinearLayout linearLayout, ThinkingDotsView thinkingDotsView) {
        this.rootView = linearLayout;
        this.thinkingDots = thinkingDotsView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemBrainstormThinkingDotsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemBrainstormThinkingDotsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_item_brainstorm_thinking_dots, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemBrainstormThinkingDotsBinding bind(View view) {
        int i = R.id.thinking_dots;
        ThinkingDotsView thinkingDotsView = (ThinkingDotsView) ViewBindings.findChildViewById(view, i);
        if (thinkingDotsView != null) {
            return new TraeItemBrainstormThinkingDotsBinding((LinearLayout) view, thinkingDotsView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
