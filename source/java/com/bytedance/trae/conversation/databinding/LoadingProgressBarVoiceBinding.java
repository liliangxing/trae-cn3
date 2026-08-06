package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class LoadingProgressBarVoiceBinding implements ViewBinding {
    public final FrameLayout loadingRoot;
    private final FrameLayout rootView;

    private LoadingProgressBarVoiceBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.loadingRoot = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LoadingProgressBarVoiceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LoadingProgressBarVoiceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.loading_progress_bar_voice, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LoadingProgressBarVoiceBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new LoadingProgressBarVoiceBinding(frameLayout, frameLayout);
    }
}
