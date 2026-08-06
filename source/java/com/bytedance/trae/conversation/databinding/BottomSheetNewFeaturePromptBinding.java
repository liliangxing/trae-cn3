package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BottomSheetNewFeaturePromptBinding implements ViewBinding {
    public final Space bottomPromptSpacer;
    public final TextView btnConnect;
    public final ImageView ivPromptImage;
    private final ConstraintLayout rootView;
    public final TraeTitleBar titleBar;
    public final Space topPromptSpacer;
    public final TextView tvPromptMessage;
    public final TextView tvPromptTitle;

    private BottomSheetNewFeaturePromptBinding(ConstraintLayout constraintLayout, Space space, TextView textView, ImageView imageView, TraeTitleBar traeTitleBar, Space space2, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.bottomPromptSpacer = space;
        this.btnConnect = textView;
        this.ivPromptImage = imageView;
        this.titleBar = traeTitleBar;
        this.topPromptSpacer = space2;
        this.tvPromptMessage = textView2;
        this.tvPromptTitle = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetNewFeaturePromptBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetNewFeaturePromptBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.bottom_sheet_new_feature_prompt, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BottomSheetNewFeaturePromptBinding bind(View view) {
        int i = C0637R.id.bottom_prompt_spacer;
        Space space = (Space) ViewBindings.findChildViewById(view, i);
        if (space != null) {
            i = C0637R.id.btn_connect;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = C0637R.id.iv_prompt_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = C0637R.id.title_bar;
                    TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                    if (traeTitleBar != null) {
                        i = C0637R.id.top_prompt_spacer;
                        Space space2 = (Space) ViewBindings.findChildViewById(view, i);
                        if (space2 != null) {
                            i = C0637R.id.tv_prompt_message;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = C0637R.id.tv_prompt_title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new BottomSheetNewFeaturePromptBinding((ConstraintLayout) view, space, textView, imageView, traeTitleBar, space2, textView2, textView3);
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
