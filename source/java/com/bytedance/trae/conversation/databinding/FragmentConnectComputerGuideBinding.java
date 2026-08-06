package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentConnectComputerGuideBinding implements ViewBinding {
    public final LinearLayout btnShare;
    public final SimpleDraweeView ivConnectGuideImage;
    public final ImageView ivStep1Status;
    public final ImageView ivStep2Status;
    private final LinearLayout rootView;
    public final MaterialCardView step1Card;
    public final MaterialCardView step2Card;
    public final TraeTitleBar titleBar;
    public final TextView traeUrl;
    public final TextView tvStep1;
    public final TextView tvStep1Status;
    public final TextView tvStep2;
    public final TextView tvStep2Status;

    private FragmentConnectComputerGuideBinding(LinearLayout linearLayout, LinearLayout linearLayout2, SimpleDraweeView simpleDraweeView, ImageView imageView, ImageView imageView2, MaterialCardView materialCardView, MaterialCardView materialCardView2, TraeTitleBar traeTitleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btnShare = linearLayout2;
        this.ivConnectGuideImage = simpleDraweeView;
        this.ivStep1Status = imageView;
        this.ivStep2Status = imageView2;
        this.step1Card = materialCardView;
        this.step2Card = materialCardView2;
        this.titleBar = traeTitleBar;
        this.traeUrl = textView;
        this.tvStep1 = textView2;
        this.tvStep1Status = textView3;
        this.tvStep2 = textView4;
        this.tvStep2Status = textView5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentConnectComputerGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentConnectComputerGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.fragment_connect_computer_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentConnectComputerGuideBinding bind(View view) {
        SimpleDraweeView findChildViewById;
        MaterialCardView findChildViewById2;
        MaterialCardView findChildViewById3;
        int i = C0637R.id.btn_share;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.iv_connect_guide_image))) != null) {
            i = C0637R.id.iv_step1_status;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C0637R.id.iv_step2_status;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0637R.id.step1_card))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = C0637R.id.step2_card))) != null) {
                    i = C0637R.id.title_bar;
                    TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                    if (traeTitleBar != null) {
                        i = C0637R.id.trae_url;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = C0637R.id.tv_step1;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = C0637R.id.tv_step1_status;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = C0637R.id.tv_step2;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = C0637R.id.tv_step2_status;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            return new FragmentConnectComputerGuideBinding((LinearLayout) view, linearLayout, findChildViewById, imageView, imageView2, findChildViewById2, findChildViewById3, traeTitleBar, textView, textView2, textView3, textView4, textView5);
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
