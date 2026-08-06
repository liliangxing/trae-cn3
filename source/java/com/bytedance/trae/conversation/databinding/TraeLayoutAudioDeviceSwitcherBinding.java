package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeLayoutAudioDeviceSwitcherBinding implements ViewBinding {
    public final LinearLayout deviceListContainer;
    private final LinearLayout rootView;
    public final TraeTitleBar titleBar;

    private TraeLayoutAudioDeviceSwitcherBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TraeTitleBar traeTitleBar) {
        this.rootView = linearLayout;
        this.deviceListContainer = linearLayout2;
        this.titleBar = traeTitleBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeLayoutAudioDeviceSwitcherBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeLayoutAudioDeviceSwitcherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_layout_audio_device_switcher, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeLayoutAudioDeviceSwitcherBinding bind(View view) {
        int i = C0637R.id.device_list_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0637R.id.title_bar;
            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
            if (traeTitleBar != null) {
                return new TraeLayoutAudioDeviceSwitcherBinding((LinearLayout) view, linearLayout, traeTitleBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
