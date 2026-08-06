package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;
import com.bytedance.trae.conversation.brainstorm.widget.VoiceWaveformView;

/* loaded from: classes5.dex */
public final class TraeLayoutParticipantCardBinding implements ViewBinding {
    public final View avatarGlow;
    public final View cardBg;
    public final View dotsBg;
    public final ImageView ivAvatar;
    private final View rootView;
    public final TextView tvStatus;
    public final VoiceWaveformView waveformView;

    private TraeLayoutParticipantCardBinding(View view, View view2, View view3, View view4, ImageView imageView, TextView textView, VoiceWaveformView voiceWaveformView) {
        this.rootView = view;
        this.avatarGlow = view2;
        this.cardBg = view3;
        this.dotsBg = view4;
        this.ivAvatar = imageView;
        this.tvStatus = textView;
        this.waveformView = voiceWaveformView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static TraeLayoutParticipantCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.trae_layout_participant_card, viewGroup);
        return bind(viewGroup);
    }

    public static TraeLayoutParticipantCardBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.avatar_glow;
        View findChildViewById3 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.card_bg))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.dots_bg))) != null) {
            i = R.id.iv_avatar;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.tv_status;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.waveform_view;
                    VoiceWaveformView voiceWaveformView = (VoiceWaveformView) ViewBindings.findChildViewById(view, i);
                    if (voiceWaveformView != null) {
                        return new TraeLayoutParticipantCardBinding(view, findChildViewById3, findChildViewById, findChildViewById2, imageView, textView, voiceWaveformView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
