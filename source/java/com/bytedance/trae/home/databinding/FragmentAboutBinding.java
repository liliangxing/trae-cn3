package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentAboutBinding implements ViewBinding {
    public final LinearLayout btnBusinessLicense;
    public final LinearLayout btnCommunity;
    public final LinearLayout btnContact;
    public final LinearLayout btnHelp;
    public final LinearLayout btnIcpFiling;
    public final LinearLayout btnOpensource;
    public final LinearLayout btnPermissionUsage;
    public final LinearLayout btnPersonalInfoList;
    public final LinearLayout btnPrivacy;
    public final LinearLayout btnShareList;
    public final LinearLayout btnTerms;
    public final View dividerCommunity;
    public final View dividerIcp;
    public final View dividerLicense;
    public final View dividerPermission;
    public final View dividerPersonalInfo;
    public final View dividerShareList;
    private final LinearLayout rootView;
    public final TraeTitleBar titleBar;
    public final TextView tvVersion;

    private FragmentAboutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, LinearLayout linearLayout12, View view, View view2, View view3, View view4, View view5, View view6, TraeTitleBar traeTitleBar, TextView textView) {
        this.rootView = linearLayout;
        this.btnBusinessLicense = linearLayout2;
        this.btnCommunity = linearLayout3;
        this.btnContact = linearLayout4;
        this.btnHelp = linearLayout5;
        this.btnIcpFiling = linearLayout6;
        this.btnOpensource = linearLayout7;
        this.btnPermissionUsage = linearLayout8;
        this.btnPersonalInfoList = linearLayout9;
        this.btnPrivacy = linearLayout10;
        this.btnShareList = linearLayout11;
        this.btnTerms = linearLayout12;
        this.dividerCommunity = view;
        this.dividerIcp = view2;
        this.dividerLicense = view3;
        this.dividerPermission = view4;
        this.dividerPersonalInfo = view5;
        this.dividerShareList = view6;
        this.titleBar = traeTitleBar;
        this.tvVersion = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAboutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_about, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAboutBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        View findChildViewById5;
        View findChildViewById6;
        int i = C0820R.id.btn_business_license;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0820R.id.btn_community;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = C0820R.id.btn_contact;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout3 != null) {
                    i = C0820R.id.btn_help;
                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout4 != null) {
                        i = C0820R.id.btn_icp_filing;
                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout5 != null) {
                            i = C0820R.id.btn_opensource;
                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout6 != null) {
                                i = C0820R.id.btn_permission_usage;
                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout7 != null) {
                                    i = C0820R.id.btn_personal_info_list;
                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout8 != null) {
                                        i = C0820R.id.btn_privacy;
                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout9 != null) {
                                            i = C0820R.id.btn_share_list;
                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout10 != null) {
                                                i = C0820R.id.btn_terms;
                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout11 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.divider_community))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0820R.id.divider_icp))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = C0820R.id.divider_license))) != null && (findChildViewById4 = ViewBindings.findChildViewById(view, (i = C0820R.id.divider_permission))) != null && (findChildViewById5 = ViewBindings.findChildViewById(view, (i = C0820R.id.divider_personal_info))) != null && (findChildViewById6 = ViewBindings.findChildViewById(view, (i = C0820R.id.divider_share_list))) != null) {
                                                    i = C0820R.id.title_bar;
                                                    TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                                                    if (traeTitleBar != null) {
                                                        i = C0820R.id.tv_version;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView != null) {
                                                            return new FragmentAboutBinding((LinearLayout) view, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, traeTitleBar, textView);
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
