package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class BottomSheetDeviceFlowContainerBinding implements ViewBinding {
    public final FrameLayout deviceFlowContent;
    public final FrameLayout deviceFlowRoot;
    private final FrameLayout rootView;

    private BottomSheetDeviceFlowContainerBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3) {
        this.rootView = frameLayout;
        this.deviceFlowContent = frameLayout2;
        this.deviceFlowRoot = frameLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetDeviceFlowContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetDeviceFlowContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_device_flow_container, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BottomSheetDeviceFlowContainerBinding bind(View view) {
        int i = R.id.device_flow_content;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) view;
            return new BottomSheetDeviceFlowContainerBinding(frameLayout2, frameLayout, frameLayout2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
