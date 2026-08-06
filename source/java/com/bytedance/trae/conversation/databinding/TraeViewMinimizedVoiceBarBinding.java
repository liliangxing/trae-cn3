package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeViewMinimizedVoiceBarBinding implements ViewBinding {
    public final AppCompatImageButton btnMaximize;
    public final VoiceStatusWaveIconView ivChatIcon;
    private final View rootView;
    public final TextView tvTimer;
    public final TextView tvTitle;

    private TraeViewMinimizedVoiceBarBinding(View view, AppCompatImageButton appCompatImageButton, VoiceStatusWaveIconView voiceStatusWaveIconView, TextView textView, TextView textView2) {
        this.rootView = view;
        this.btnMaximize = appCompatImageButton;
        this.ivChatIcon = voiceStatusWaveIconView;
        this.tvTimer = textView;
        this.tvTitle = textView2;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static TraeViewMinimizedVoiceBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(C0637R.layout.trae_view_minimized_voice_bar, viewGroup);
        return bind(viewGroup);
    }

    public static TraeViewMinimizedVoiceBarBinding bind(View view) {
        int i = C0637R.id.btn_maximize;
        AppCompatImageButton findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = C0637R.id.iv_chat_icon;
            VoiceStatusWaveIconView voiceStatusWaveIconView = (VoiceStatusWaveIconView) ViewBindings.findChildViewById(view, i);
            if (voiceStatusWaveIconView != null) {
                i = C0637R.id.tv_timer;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C0637R.id.tv_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new TraeViewMinimizedVoiceBarBinding(view, findChildViewById, voiceStatusWaveIconView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
