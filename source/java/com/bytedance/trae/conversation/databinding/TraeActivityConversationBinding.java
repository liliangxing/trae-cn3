package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.widget.VoiceRecordingOverlay;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeActivityConversationBinding implements ViewBinding {
    public final SimpleDraweeView btnOperationIcon;
    public final Button btnRetryLoad;
    public final FragmentContainerView checkpointOverlayContainer;
    public final FragmentContainerView detailFragmentContainer;
    public final ConstraintLayout fragmentContainer;
    public final FragmentContainerView inputFragmentContainer;
    public final LinearLayout layoutLoadError;
    private final ConstraintLayout rootView;
    public final TraeTitleBar titleBar;
    public final View titleBarMark;
    public final VoiceRecordingOverlay voiceRecordingOverlay;
    public final FragmentContainerView welcomeFragmentContainer;

    private TraeActivityConversationBinding(ConstraintLayout constraintLayout, SimpleDraweeView simpleDraweeView, Button button, FragmentContainerView fragmentContainerView, FragmentContainerView fragmentContainerView2, ConstraintLayout constraintLayout2, FragmentContainerView fragmentContainerView3, LinearLayout linearLayout, TraeTitleBar traeTitleBar, View view, VoiceRecordingOverlay voiceRecordingOverlay, FragmentContainerView fragmentContainerView4) {
        this.rootView = constraintLayout;
        this.btnOperationIcon = simpleDraweeView;
        this.btnRetryLoad = button;
        this.checkpointOverlayContainer = fragmentContainerView;
        this.detailFragmentContainer = fragmentContainerView2;
        this.fragmentContainer = constraintLayout2;
        this.inputFragmentContainer = fragmentContainerView3;
        this.layoutLoadError = linearLayout;
        this.titleBar = traeTitleBar;
        this.titleBarMark = view;
        this.voiceRecordingOverlay = voiceRecordingOverlay;
        this.welcomeFragmentContainer = fragmentContainerView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TraeActivityConversationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityConversationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_activity_conversation, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityConversationBinding bind(View view) {
        FragmentContainerView findChildViewById;
        FragmentContainerView findChildViewById2;
        ConstraintLayout findChildViewById3;
        FragmentContainerView findChildViewById4;
        View findChildViewById5;
        FragmentContainerView findChildViewById6;
        int i = C0637R.id.btn_operation_icon;
        SimpleDraweeView findChildViewById7 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById7 != null) {
            i = C0637R.id.btn_retry_load;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.checkpoint_overlay_container))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0637R.id.detail_fragment_container))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = C0637R.id.fragment_container))) != null && (findChildViewById4 = ViewBindings.findChildViewById(view, (i = C0637R.id.input_fragment_container))) != null) {
                i = C0637R.id.layout_load_error;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = C0637R.id.title_bar;
                    TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                    if (traeTitleBar != null && (findChildViewById5 = ViewBindings.findChildViewById(view, (i = C0637R.id.title_bar_mark))) != null) {
                        i = C0637R.id.voice_recording_overlay;
                        VoiceRecordingOverlay voiceRecordingOverlay = (VoiceRecordingOverlay) ViewBindings.findChildViewById(view, i);
                        if (voiceRecordingOverlay != null && (findChildViewById6 = ViewBindings.findChildViewById(view, (i = C0637R.id.welcome_fragment_container))) != null) {
                            return new TraeActivityConversationBinding((ConstraintLayout) view, findChildViewById7, button, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, linearLayout, traeTitleBar, findChildViewById5, voiceRecordingOverlay, findChildViewById6);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
