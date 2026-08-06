package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentAccountBinding implements ViewBinding {
    public final LinearLayout btnDeleteAccount;
    public final TextView btnDouyinAction;
    public final TextView btnPhoneAction;
    public final LinearLayout cardDeleteAccount;
    public final LinearLayout cardLoginMethods;
    public final View dividerPhone;
    private final LinearLayout rootView;
    public final LinearLayout rowDouyin;
    public final LinearLayout rowPhone;
    public final SwitchCompat switchPrivacyMode;
    public final TraeTitleBar titleBar;
    public final TextView tvDouyinSubtitle;
    public final TextView tvPhoneSubtitle;
    public final TextView tvPrivacyDesc;
    public final TextView tvPrivacyDetails;

    private FragmentAccountBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, LinearLayout linearLayout3, LinearLayout linearLayout4, View view, LinearLayout linearLayout5, LinearLayout linearLayout6, SwitchCompat switchCompat, TraeTitleBar traeTitleBar, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.btnDeleteAccount = linearLayout2;
        this.btnDouyinAction = textView;
        this.btnPhoneAction = textView2;
        this.cardDeleteAccount = linearLayout3;
        this.cardLoginMethods = linearLayout4;
        this.dividerPhone = view;
        this.rowDouyin = linearLayout5;
        this.rowPhone = linearLayout6;
        this.switchPrivacyMode = switchCompat;
        this.titleBar = traeTitleBar;
        this.tvDouyinSubtitle = textView3;
        this.tvPhoneSubtitle = textView4;
        this.tvPrivacyDesc = textView5;
        this.tvPrivacyDetails = textView6;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_account, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAccountBinding bind(View view) {
        View findChildViewById;
        SwitchCompat findChildViewById2;
        int i = C0820R.id.btn_delete_account;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0820R.id.btn_douyin_action;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = C0820R.id.btn_phone_action;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = C0820R.id.card_delete_account;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = C0820R.id.card_login_methods;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.divider_phone))) != null) {
                            i = C0820R.id.row_douyin;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout4 != null) {
                                i = C0820R.id.row_phone;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout5 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0820R.id.switch_privacy_mode))) != null) {
                                    i = C0820R.id.title_bar;
                                    TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                                    if (traeTitleBar != null) {
                                        i = C0820R.id.tv_douyin_subtitle;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = C0820R.id.tv_phone_subtitle;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = C0820R.id.tv_privacy_desc;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = C0820R.id.tv_privacy_details;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        return new FragmentAccountBinding((LinearLayout) view, linearLayout, textView, textView2, linearLayout2, linearLayout3, findChildViewById, linearLayout4, linearLayout5, findChildViewById2, traeTitleBar, textView3, textView4, textView5, textView6);
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
