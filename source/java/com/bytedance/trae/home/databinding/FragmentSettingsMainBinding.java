package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.home.C0820R;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentSettingsMainBinding implements ViewBinding {
    public final LinearLayout btnAbout;
    public final LinearLayout btnAccount;
    public final FrameLayout btnClose;
    public final LinearLayout btnConnectors;
    public final LinearLayout btnDebug;
    public final LinearLayout btnDeviceManagement;
    public final TextView btnEditProfile;
    public final LinearLayout btnLanguage;
    public final LinearLayout btnLogout;
    public final LinearLayout btnMessages;
    public final LinearLayout btnNotification;
    public final LinearLayout btnPrivacyPermission;
    public final LinearLayout btnSubscribe;
    public final LinearLayout btnTheme;
    public final LinearLayout btnUpdate;
    public final LinearLayout btnUsage;
    public final View dividerConnectors;
    public final View dividerTheme;
    public final View dividerUpdateAbout;
    public final LinearLayout groupAccountMessages;
    public final ImageView imgCnIdentity;
    public final SimpleDraweeView ivAvatar;
    public final ImageView ivBytecloudBadge;
    private final LinearLayout rootView;
    public final LinearLayout rowPoints;
    public final Toolbar toolbar;
    public final TextView tvCnFreeBadge;
    public final TextView tvCnTierBadge;
    public final TextView tvDebugPpeValue;
    public final TextView tvEmail;
    public final TextView tvIcpFiling;
    public final TextView tvLanguageValue;
    public final TextView tvMessageBadge;
    public final TextView tvModelFiling;
    public final TextView tvModelName;
    public final TextView tvName;
    public final TextView tvPointsBalance;
    public final TextView tvProBadge;
    public final TextView tvThemeValue;

    private FragmentSettingsMainBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, FrameLayout frameLayout, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, TextView textView, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, LinearLayout linearLayout12, LinearLayout linearLayout13, LinearLayout linearLayout14, LinearLayout linearLayout15, View view, View view2, View view3, LinearLayout linearLayout16, ImageView imageView, SimpleDraweeView simpleDraweeView, ImageView imageView2, LinearLayout linearLayout17, Toolbar toolbar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        this.rootView = linearLayout;
        this.btnAbout = linearLayout2;
        this.btnAccount = linearLayout3;
        this.btnClose = frameLayout;
        this.btnConnectors = linearLayout4;
        this.btnDebug = linearLayout5;
        this.btnDeviceManagement = linearLayout6;
        this.btnEditProfile = textView;
        this.btnLanguage = linearLayout7;
        this.btnLogout = linearLayout8;
        this.btnMessages = linearLayout9;
        this.btnNotification = linearLayout10;
        this.btnPrivacyPermission = linearLayout11;
        this.btnSubscribe = linearLayout12;
        this.btnTheme = linearLayout13;
        this.btnUpdate = linearLayout14;
        this.btnUsage = linearLayout15;
        this.dividerConnectors = view;
        this.dividerTheme = view2;
        this.dividerUpdateAbout = view3;
        this.groupAccountMessages = linearLayout16;
        this.imgCnIdentity = imageView;
        this.ivAvatar = simpleDraweeView;
        this.ivBytecloudBadge = imageView2;
        this.rowPoints = linearLayout17;
        this.toolbar = toolbar;
        this.tvCnFreeBadge = textView2;
        this.tvCnTierBadge = textView3;
        this.tvDebugPpeValue = textView4;
        this.tvEmail = textView5;
        this.tvIcpFiling = textView6;
        this.tvLanguageValue = textView7;
        this.tvMessageBadge = textView8;
        this.tvModelFiling = textView9;
        this.tvModelName = textView10;
        this.tvName = textView11;
        this.tvPointsBalance = textView12;
        this.tvProBadge = textView13;
        this.tvThemeValue = textView14;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSettingsMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSettingsMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_settings_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSettingsMainBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        SimpleDraweeView findChildViewById4;
        Toolbar findChildViewById5;
        int i = C0820R.id.btn_about;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0820R.id.btn_account;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = C0820R.id.btn_close;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = C0820R.id.btn_connectors;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout3 != null) {
                        i = C0820R.id.btn_debug;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout4 != null) {
                            i = C0820R.id.btn_device_management;
                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout5 != null) {
                                i = C0820R.id.btn_edit_profile;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = C0820R.id.btn_language;
                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout6 != null) {
                                        i = C0820R.id.btn_logout;
                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout7 != null) {
                                            i = C0820R.id.btn_messages;
                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout8 != null) {
                                                i = C0820R.id.btn_notification;
                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout9 != null) {
                                                    i = C0820R.id.btn_privacy_permission;
                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout10 != null) {
                                                        i = C0820R.id.btn_subscribe;
                                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout11 != null) {
                                                            i = C0820R.id.btn_theme;
                                                            LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout12 != null) {
                                                                i = C0820R.id.btn_update;
                                                                LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout13 != null) {
                                                                    i = C0820R.id.btn_usage;
                                                                    LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout14 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.divider_connectors))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0820R.id.divider_theme))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = C0820R.id.divider_update_about))) != null) {
                                                                        i = C0820R.id.group_account_messages;
                                                                        LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout15 != null) {
                                                                            i = C0820R.id.img_cn_identity;
                                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView != null && (findChildViewById4 = ViewBindings.findChildViewById(view, (i = C0820R.id.iv_avatar))) != null) {
                                                                                i = C0820R.id.iv_bytecloud_badge;
                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView2 != null) {
                                                                                    i = C0820R.id.row_points;
                                                                                    LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout16 != null && (findChildViewById5 = ViewBindings.findChildViewById(view, (i = C0820R.id.toolbar))) != null) {
                                                                                        i = C0820R.id.tv_cn_free_badge;
                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView2 != null) {
                                                                                            i = C0820R.id.tv_cn_tier_badge;
                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView3 != null) {
                                                                                                i = C0820R.id.tv_debug_ppe_value;
                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView4 != null) {
                                                                                                    i = C0820R.id.tv_email;
                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView5 != null) {
                                                                                                        i = C0820R.id.tv_icp_filing;
                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView6 != null) {
                                                                                                            i = C0820R.id.tv_language_value;
                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView7 != null) {
                                                                                                                i = C0820R.id.tv_message_badge;
                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView8 != null) {
                                                                                                                    i = C0820R.id.tv_model_filing;
                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView9 != null) {
                                                                                                                        i = C0820R.id.tv_model_name;
                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView10 != null) {
                                                                                                                            i = C0820R.id.tv_name;
                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView11 != null) {
                                                                                                                                i = C0820R.id.tv_points_balance;
                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView12 != null) {
                                                                                                                                    i = C0820R.id.tv_pro_badge;
                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView13 != null) {
                                                                                                                                        i = C0820R.id.tv_theme_value;
                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView14 != null) {
                                                                                                                                            return new FragmentSettingsMainBinding((LinearLayout) view, linearLayout, linearLayout2, frameLayout, linearLayout3, linearLayout4, linearLayout5, textView, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, linearLayout12, linearLayout13, linearLayout14, findChildViewById, findChildViewById2, findChildViewById3, linearLayout15, imageView, findChildViewById4, imageView2, linearLayout16, findChildViewById5, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
