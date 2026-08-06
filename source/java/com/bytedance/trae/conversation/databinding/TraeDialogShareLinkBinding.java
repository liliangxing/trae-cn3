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

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeDialogShareLinkBinding implements ViewBinding {
    public final TextView btnCopied;
    public final TextView btnCopyLink;
    public final LinearLayout btnGenerateContainer;
    public final TextView btnGenerateLink;
    public final TextView btnStopSharing;
    public final ImageView ivLoading;
    public final LinearLayout llGenerating;
    private final LinearLayout rootView;
    public final TextView shareLinkDesc;
    public final LinearLayout successContainer;
    public final TraeTitleBar titleBar;
    public final TextView tvShareUrl;

    private TraeDialogShareLinkBinding(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, TextView textView3, TextView textView4, ImageView imageView, LinearLayout linearLayout3, TextView textView5, LinearLayout linearLayout4, TraeTitleBar traeTitleBar, TextView textView6) {
        this.rootView = linearLayout;
        this.btnCopied = textView;
        this.btnCopyLink = textView2;
        this.btnGenerateContainer = linearLayout2;
        this.btnGenerateLink = textView3;
        this.btnStopSharing = textView4;
        this.ivLoading = imageView;
        this.llGenerating = linearLayout3;
        this.shareLinkDesc = textView5;
        this.successContainer = linearLayout4;
        this.titleBar = traeTitleBar;
        this.tvShareUrl = textView6;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeDialogShareLinkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeDialogShareLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_dialog_share_link, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeDialogShareLinkBinding bind(View view) {
        int i = C0637R.id.btn_copied;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C0637R.id.btn_copy_link;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = C0637R.id.btn_generate_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = C0637R.id.btn_generate_link;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = C0637R.id.btn_stop_sharing;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = C0637R.id.iv_loading;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = C0637R.id.ll_generating;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = C0637R.id.share_link_desc;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = C0637R.id.success_container;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = C0637R.id.title_bar;
                                            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                                            if (traeTitleBar != null) {
                                                i = C0637R.id.tv_share_url;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    return new TraeDialogShareLinkBinding((LinearLayout) view, textView, textView2, linearLayout, textView3, textView4, imageView, linearLayout2, textView5, linearLayout3, traeTitleBar, textView6);
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
