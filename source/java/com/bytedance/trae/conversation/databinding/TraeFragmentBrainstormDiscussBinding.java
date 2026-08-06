package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.widget.AiSubtitleView;
import com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar;
import com.bytedance.trae.conversation.brainstorm.widget.ShimmerTextView;
import com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeFragmentBrainstormDiscussBinding implements ViewBinding {
    public final FrameLayout aiDisplaySwitcher;
    public final FrameLayout aiSubtitleContainer;
    public final LinearLayout bottomBar;
    public final Button btnAttach;
    public final Button btnConfirm;
    public final Button btnMic;
    public final ImageView btnScrollToBottom;
    public final ConstraintLayout chatModeContainer;
    public final FrameLayout contentSwitcher;
    public final ConstraintLayout footerContainer;
    public final Guideline guidelineSphereTop;
    public final VoiceStatusWaveIconView mainWaveform;
    private final FrameLayout rootView;
    public final AiSubtitleView rvAiSubtitle;
    public final RecyclerView rvSubtitle;
    public final View subtitleBg;
    public final FrameLayout subtitleModeContainer;
    public final View subtitleTopGradient;
    public final LinearLayout testFrame;
    public final BrainstormTopBar topBar;
    public final TextView tvAiStatus;
    public final ShimmerTextView tvBottomStatus;
    public final TextView tvGeneratedByAi;
    public final ShimmerTextView tvSubtitleEmptyHint;
    public final WebView webviewSphere;

    private TraeFragmentBrainstormDiscussBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, LinearLayout linearLayout, Button button, Button button2, Button button3, ImageView imageView, ConstraintLayout constraintLayout, FrameLayout frameLayout4, ConstraintLayout constraintLayout2, Guideline guideline, VoiceStatusWaveIconView voiceStatusWaveIconView, AiSubtitleView aiSubtitleView, RecyclerView recyclerView, View view, FrameLayout frameLayout5, View view2, LinearLayout linearLayout2, BrainstormTopBar brainstormTopBar, TextView textView, ShimmerTextView shimmerTextView, TextView textView2, ShimmerTextView shimmerTextView2, WebView webView) {
        this.rootView = frameLayout;
        this.aiDisplaySwitcher = frameLayout2;
        this.aiSubtitleContainer = frameLayout3;
        this.bottomBar = linearLayout;
        this.btnAttach = button;
        this.btnConfirm = button2;
        this.btnMic = button3;
        this.btnScrollToBottom = imageView;
        this.chatModeContainer = constraintLayout;
        this.contentSwitcher = frameLayout4;
        this.footerContainer = constraintLayout2;
        this.guidelineSphereTop = guideline;
        this.mainWaveform = voiceStatusWaveIconView;
        this.rvAiSubtitle = aiSubtitleView;
        this.rvSubtitle = recyclerView;
        this.subtitleBg = view;
        this.subtitleModeContainer = frameLayout5;
        this.subtitleTopGradient = view2;
        this.testFrame = linearLayout2;
        this.topBar = brainstormTopBar;
        this.tvAiStatus = textView;
        this.tvBottomStatus = shimmerTextView;
        this.tvGeneratedByAi = textView2;
        this.tvSubtitleEmptyHint = shimmerTextView2;
        this.webviewSphere = webView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeFragmentBrainstormDiscussBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentBrainstormDiscussBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_fragment_brainstorm_discuss, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentBrainstormDiscussBinding bind(View view) {
        ConstraintLayout findChildViewById;
        ConstraintLayout findChildViewById2;
        Guideline findChildViewById3;
        RecyclerView findChildViewById4;
        View findChildViewById5;
        View findChildViewById6;
        int i = C0637R.id.ai_display_switcher;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C0637R.id.ai_subtitle_container;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout2 != null) {
                i = C0637R.id.bottom_bar;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = C0637R.id.btn_attach;
                    Button button = (Button) ViewBindings.findChildViewById(view, i);
                    if (button != null) {
                        i = C0637R.id.btn_confirm;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button2 != null) {
                            i = C0637R.id.btn_mic;
                            Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                            if (button3 != null) {
                                i = C0637R.id.btn_scroll_to_bottom;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.chat_mode_container))) != null) {
                                    i = C0637R.id.content_switcher;
                                    FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                    if (frameLayout3 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0637R.id.footer_container))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = C0637R.id.guideline_sphere_top))) != null) {
                                        i = C0637R.id.main_waveform;
                                        VoiceStatusWaveIconView voiceStatusWaveIconView = (VoiceStatusWaveIconView) ViewBindings.findChildViewById(view, i);
                                        if (voiceStatusWaveIconView != null) {
                                            i = C0637R.id.rv_ai_subtitle;
                                            AiSubtitleView aiSubtitleView = (AiSubtitleView) ViewBindings.findChildViewById(view, i);
                                            if (aiSubtitleView != null && (findChildViewById4 = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_subtitle))) != null && (findChildViewById5 = ViewBindings.findChildViewById(view, (i = C0637R.id.subtitle_bg))) != null) {
                                                i = C0637R.id.subtitle_mode_container;
                                                FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                if (frameLayout4 != null && (findChildViewById6 = ViewBindings.findChildViewById(view, (i = C0637R.id.subtitle_top_gradient))) != null) {
                                                    i = C0637R.id.test_frame;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout2 != null) {
                                                        i = C0637R.id.top_bar;
                                                        BrainstormTopBar brainstormTopBar = (BrainstormTopBar) ViewBindings.findChildViewById(view, i);
                                                        if (brainstormTopBar != null) {
                                                            i = C0637R.id.tv_ai_status;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView != null) {
                                                                i = C0637R.id.tv_bottom_status;
                                                                ShimmerTextView shimmerTextView = (ShimmerTextView) ViewBindings.findChildViewById(view, i);
                                                                if (shimmerTextView != null) {
                                                                    i = C0637R.id.tv_generated_by_ai;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView2 != null) {
                                                                        i = C0637R.id.tv_subtitle_empty_hint;
                                                                        ShimmerTextView shimmerTextView2 = (ShimmerTextView) ViewBindings.findChildViewById(view, i);
                                                                        if (shimmerTextView2 != null) {
                                                                            i = C0637R.id.webview_sphere;
                                                                            WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
                                                                            if (webView != null) {
                                                                                return new TraeFragmentBrainstormDiscussBinding((FrameLayout) view, frameLayout, frameLayout2, linearLayout, button, button2, button3, imageView, findChildViewById, frameLayout3, findChildViewById2, findChildViewById3, voiceStatusWaveIconView, aiSubtitleView, findChildViewById4, findChildViewById5, frameLayout4, findChildViewById6, linearLayout2, brainstormTopBar, textView, shimmerTextView, textView2, shimmerTextView2, webView);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
