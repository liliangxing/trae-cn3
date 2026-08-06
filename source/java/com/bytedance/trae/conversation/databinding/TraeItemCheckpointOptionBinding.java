package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeItemCheckpointOptionBinding implements ViewBinding {
    public final FrameLayout checkboxContainer;
    public final ImageView ivCheck;
    public final ImageView ivOptionSingleCheck;
    public final LinearLayout optionRoot;
    private final LinearLayout rootView;
    public final View subtitleBottomFade;
    public final View subtitleTopFade;
    public final FrameLayout subtitleViewport;
    public final LinearLayout textContainer;
    public final TextView tvOptionIndex;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private TraeItemCheckpointOptionBinding(LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, View view, View view2, FrameLayout frameLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.checkboxContainer = frameLayout;
        this.ivCheck = imageView;
        this.ivOptionSingleCheck = imageView2;
        this.optionRoot = linearLayout2;
        this.subtitleBottomFade = view;
        this.subtitleTopFade = view2;
        this.subtitleViewport = frameLayout2;
        this.textContainer = linearLayout3;
        this.tvOptionIndex = textView;
        this.tvSubtitle = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemCheckpointOptionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemCheckpointOptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_item_checkpoint_option, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemCheckpointOptionBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.checkbox_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.iv_check;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_option_single_check;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.option_root;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.subtitle_bottom_fade))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.subtitle_top_fade))) != null) {
                        i = R.id.subtitle_viewport;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout2 != null) {
                            i = R.id.text_container;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.tv_option_index;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tv_subtitle;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.tv_title;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            return new TraeItemCheckpointOptionBinding((LinearLayout) view, frameLayout, imageView, imageView2, linearLayout, findChildViewById, findChildViewById2, frameLayout2, linearLayout2, textView, textView2, textView3);
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
