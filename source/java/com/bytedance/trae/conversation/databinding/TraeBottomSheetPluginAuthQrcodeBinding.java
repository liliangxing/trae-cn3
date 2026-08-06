package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.widget.ShimmerTextView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeBottomSheetPluginAuthQrcodeBinding implements ViewBinding {
    public final TextView btnDesktopCancel;
    public final ImageView ivDesktopProviderIcon;
    public final ImageView ivProviderIcon;
    public final ImageView ivQrcode;
    public final LinearLayout layoutDesktopContent;
    public final LinearLayout layoutQrIconRow;
    public final LinearLayout layoutQrcodeContent;
    public final ProgressBar pbQrcodeLoading;
    private final LinearLayout rootView;
    public final TraeTitleBar titleBar;
    public final TextView tvDesc;
    public final TextView tvDesktopMessage;
    public final ShimmerTextView tvDesktopShimmer;
    public final TextView tvFooter;
    public final ShimmerTextView tvQrShimmer;
    public final TextView tvStatus;

    private TraeBottomSheetPluginAuthQrcodeBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ProgressBar progressBar, TraeTitleBar traeTitleBar, TextView textView2, TextView textView3, ShimmerTextView shimmerTextView, TextView textView4, ShimmerTextView shimmerTextView2, TextView textView5) {
        this.rootView = linearLayout;
        this.btnDesktopCancel = textView;
        this.ivDesktopProviderIcon = imageView;
        this.ivProviderIcon = imageView2;
        this.ivQrcode = imageView3;
        this.layoutDesktopContent = linearLayout2;
        this.layoutQrIconRow = linearLayout3;
        this.layoutQrcodeContent = linearLayout4;
        this.pbQrcodeLoading = progressBar;
        this.titleBar = traeTitleBar;
        this.tvDesc = textView2;
        this.tvDesktopMessage = textView3;
        this.tvDesktopShimmer = shimmerTextView;
        this.tvFooter = textView4;
        this.tvQrShimmer = shimmerTextView2;
        this.tvStatus = textView5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeBottomSheetPluginAuthQrcodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeBottomSheetPluginAuthQrcodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_bottom_sheet_plugin_auth_qrcode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeBottomSheetPluginAuthQrcodeBinding bind(View view) {
        int i = C0637R.id.btn_desktop_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C0637R.id.iv_desktop_provider_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C0637R.id.iv_provider_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = C0637R.id.iv_qrcode;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = C0637R.id.layout_desktop_content;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = C0637R.id.layout_qr_icon_row;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = C0637R.id.layout_qrcode_content;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout3 != null) {
                                    i = C0637R.id.pb_qrcode_loading;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                    if (progressBar != null) {
                                        i = C0637R.id.title_bar;
                                        TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                                        if (traeTitleBar != null) {
                                            i = C0637R.id.tv_desc;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = C0637R.id.tv_desktop_message;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = C0637R.id.tv_desktop_shimmer;
                                                    ShimmerTextView shimmerTextView = (ShimmerTextView) ViewBindings.findChildViewById(view, i);
                                                    if (shimmerTextView != null) {
                                                        i = C0637R.id.tv_footer;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = C0637R.id.tv_qr_shimmer;
                                                            ShimmerTextView shimmerTextView2 = (ShimmerTextView) ViewBindings.findChildViewById(view, i);
                                                            if (shimmerTextView2 != null) {
                                                                i = C0637R.id.tv_status;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    return new TraeBottomSheetPluginAuthQrcodeBinding((LinearLayout) view, textView, imageView, imageView2, imageView3, linearLayout, linearLayout2, linearLayout3, progressBar, traeTitleBar, textView2, textView3, shimmerTextView, textView4, shimmerTextView2, textView5);
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
