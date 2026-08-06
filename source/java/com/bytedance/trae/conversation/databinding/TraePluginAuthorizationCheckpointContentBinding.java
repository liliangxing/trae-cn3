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
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraePluginAuthorizationCheckpointContentBinding implements ViewBinding {
    public final TextView btnPluginAuthDesktopCancel;
    public final TextView btnPluginAuthorizationAuthorize;
    public final TextView btnPluginAuthorizationCancel;
    public final ImageView ivPluginAuthLinkIcon;
    public final ImageView ivPluginAuthProviderIcon;
    public final ImageView ivPluginAuthQrcodeProviderIcon;
    public final ImageView ivPluginAuthTraeIcon;
    public final ImageView ivPluginAuthorizationQrcode;
    public final ImageView ivPluginAuthorizationSuccessIcon;
    public final LinearLayout layoutPluginAuthorizationActions;
    public final LinearLayout layoutPluginAuthorizationDesktopRedirect;
    public final LinearLayout layoutPluginAuthorizationQrcode;
    public final LinearLayout layoutPluginAuthorizationSuccess;
    public final ProgressBar pbPluginAuthorizationLoading;
    public final ProgressBar pbPluginAuthorizationQrcodeLoading;
    private final LinearLayout rootView;
    public final TextView tvPluginAuthDesktopFooter;
    public final TextView tvPluginAuthDesktopMessage;
    public final TextView tvPluginAuthorizationBody;
    public final TextView tvPluginAuthorizationQrcodeDesc;
    public final TextView tvPluginAuthorizationQrcodeFooter;
    public final TextView tvPluginAuthorizationQrcodeStatus;
    public final TextView tvPluginAuthorizationSuccessLabel;
    public final TextView tvPluginAuthorizationSuccessName;

    private TraePluginAuthorizationCheckpointContentBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, ProgressBar progressBar, ProgressBar progressBar2, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = linearLayout;
        this.btnPluginAuthDesktopCancel = textView;
        this.btnPluginAuthorizationAuthorize = textView2;
        this.btnPluginAuthorizationCancel = textView3;
        this.ivPluginAuthLinkIcon = imageView;
        this.ivPluginAuthProviderIcon = imageView2;
        this.ivPluginAuthQrcodeProviderIcon = imageView3;
        this.ivPluginAuthTraeIcon = imageView4;
        this.ivPluginAuthorizationQrcode = imageView5;
        this.ivPluginAuthorizationSuccessIcon = imageView6;
        this.layoutPluginAuthorizationActions = linearLayout2;
        this.layoutPluginAuthorizationDesktopRedirect = linearLayout3;
        this.layoutPluginAuthorizationQrcode = linearLayout4;
        this.layoutPluginAuthorizationSuccess = linearLayout5;
        this.pbPluginAuthorizationLoading = progressBar;
        this.pbPluginAuthorizationQrcodeLoading = progressBar2;
        this.tvPluginAuthDesktopFooter = textView4;
        this.tvPluginAuthDesktopMessage = textView5;
        this.tvPluginAuthorizationBody = textView6;
        this.tvPluginAuthorizationQrcodeDesc = textView7;
        this.tvPluginAuthorizationQrcodeFooter = textView8;
        this.tvPluginAuthorizationQrcodeStatus = textView9;
        this.tvPluginAuthorizationSuccessLabel = textView10;
        this.tvPluginAuthorizationSuccessName = textView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraePluginAuthorizationCheckpointContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraePluginAuthorizationCheckpointContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_plugin_authorization_checkpoint_content, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraePluginAuthorizationCheckpointContentBinding bind(View view) {
        int i = R.id.btn_plugin_auth_desktop_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btn_plugin_authorization_authorize;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.btn_plugin_authorization_cancel;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.iv_plugin_auth_link_icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.iv_plugin_auth_provider_icon;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.iv_plugin_auth_qrcode_provider_icon;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.iv_plugin_auth_trae_icon;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView4 != null) {
                                    i = R.id.iv_plugin_authorization_qrcode;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView5 != null) {
                                        i = R.id.iv_plugin_authorization_success_icon;
                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView6 != null) {
                                            i = R.id.layout_plugin_authorization_actions;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout != null) {
                                                i = R.id.layout_plugin_authorization_desktop_redirect;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout2 != null) {
                                                    i = R.id.layout_plugin_authorization_qrcode;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout3 != null) {
                                                        i = R.id.layout_plugin_authorization_success;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout4 != null) {
                                                            i = R.id.pb_plugin_authorization_loading;
                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                            if (progressBar != null) {
                                                                i = R.id.pb_plugin_authorization_qrcode_loading;
                                                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                if (progressBar2 != null) {
                                                                    i = R.id.tv_plugin_auth_desktop_footer;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tv_plugin_auth_desktop_message;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView5 != null) {
                                                                            i = R.id.tv_plugin_authorization_body;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView6 != null) {
                                                                                i = R.id.tv_plugin_authorization_qrcode_desc;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.tv_plugin_authorization_qrcode_footer;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.tv_plugin_authorization_qrcode_status;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.tv_plugin_authorization_success_label;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.tv_plugin_authorization_success_name;
                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView11 != null) {
                                                                                                    return new TraePluginAuthorizationCheckpointContentBinding((LinearLayout) view, textView, textView2, textView3, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, linearLayout, linearLayout2, linearLayout3, linearLayout4, progressBar, progressBar2, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
