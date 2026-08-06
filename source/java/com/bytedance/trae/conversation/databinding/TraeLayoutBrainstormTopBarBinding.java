package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeLayoutBrainstormTopBarBinding implements ViewBinding {
    public final LinearLayout actionPill;
    public final ImageView btnLeft;
    public final ImageView btnMinimize;
    public final ImageView btnSubtitleToggle;
    private final View rootView;
    public final Space spacePillGap;
    public final LinearLayout timerContainer;
    public final TextView tvTimeoutChip;
    public final TextView tvTimer;

    private TraeLayoutBrainstormTopBarBinding(View view, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, Space space, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = view;
        this.actionPill = linearLayout;
        this.btnLeft = imageView;
        this.btnMinimize = imageView2;
        this.btnSubtitleToggle = imageView3;
        this.spacePillGap = space;
        this.timerContainer = linearLayout2;
        this.tvTimeoutChip = textView;
        this.tvTimer = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static TraeLayoutBrainstormTopBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.trae_layout_brainstorm_top_bar, viewGroup);
        return bind(viewGroup);
    }

    public static TraeLayoutBrainstormTopBarBinding bind(View view) {
        int i = R.id.action_pill;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.btn_left;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.btn_minimize;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.btn_subtitle_toggle;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.space_pill_gap;
                        Space space = (Space) ViewBindings.findChildViewById(view, i);
                        if (space != null) {
                            i = R.id.timer_container;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.tv_timeout_chip;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tv_timer;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        return new TraeLayoutBrainstormTopBarBinding(view, linearLayout, imageView, imageView2, imageView3, space, linearLayout2, textView, textView2);
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
