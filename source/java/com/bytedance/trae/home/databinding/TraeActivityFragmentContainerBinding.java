package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.trae.home.R;

/* loaded from: classes5.dex */
public final class TraeActivityFragmentContainerBinding implements ViewBinding {
    public final FrameLayout fragmentContainer;
    private final FrameLayout rootView;

    private TraeActivityFragmentContainerBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.fragmentContainer = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeActivityFragmentContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityFragmentContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_activity_fragment_container, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityFragmentContainerBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new TraeActivityFragmentContainerBinding(frameLayout, frameLayout);
    }
}
