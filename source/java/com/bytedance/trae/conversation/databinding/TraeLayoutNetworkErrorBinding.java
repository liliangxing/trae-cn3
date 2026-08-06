package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeLayoutNetworkErrorBinding implements ViewBinding {
    public final Button btnRetry;
    public final FrameLayout layoutNetworkError;
    private final FrameLayout rootView;

    private TraeLayoutNetworkErrorBinding(FrameLayout frameLayout, Button button, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.btnRetry = button;
        this.layoutNetworkError = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeLayoutNetworkErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeLayoutNetworkErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_layout_network_error, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeLayoutNetworkErrorBinding bind(View view) {
        int i = R.id.btn_retry;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new TraeLayoutNetworkErrorBinding(frameLayout, button, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
