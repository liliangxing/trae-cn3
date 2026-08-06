package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentDebugSettingsBinding implements ViewBinding {
    public final TextView btnClear;
    public final TextView btnClearBillingUpgradePromptCache;
    public final TextView btnCopyDeviceInfo;
    public final TextView btnCustomHeaderAdd;
    public final TextView btnCustomHeaderClearAll;
    public final TextView btnEnvLaneReset;
    public final TextView btnEnvLaneSave;
    public final TextView btnSave;
    public final TextView btnUploadAlog;
    public final TextView btnViewLoginDevices;
    public final CheckBox cbMockDid;
    public final EditText etCustomHeaderKey;
    public final EditText etCustomHeaderValue;
    public final EditText etEnvLane;
    public final EditText etPpeEnv;
    public final LinearLayout llCustomHeaders;
    public final LinearLayout llPpeHistory;
    private final LinearLayout rootView;
    public final TraeTitleBar titleBar;
    public final TextView tvDeviceId;
    public final TextView tvEnvLaneCurrent;
    public final TextView tvPassportUserId;
    public final TextView tvPpeCurrent;
    public final TextView tvPpeHistoryLabel;
    public final TextView tvUserId;

    private FragmentDebugSettingsBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, CheckBox checkBox, EditText editText, EditText editText2, EditText editText3, EditText editText4, LinearLayout linearLayout2, LinearLayout linearLayout3, TraeTitleBar traeTitleBar, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16) {
        this.rootView = linearLayout;
        this.btnClear = textView;
        this.btnClearBillingUpgradePromptCache = textView2;
        this.btnCopyDeviceInfo = textView3;
        this.btnCustomHeaderAdd = textView4;
        this.btnCustomHeaderClearAll = textView5;
        this.btnEnvLaneReset = textView6;
        this.btnEnvLaneSave = textView7;
        this.btnSave = textView8;
        this.btnUploadAlog = textView9;
        this.btnViewLoginDevices = textView10;
        this.cbMockDid = checkBox;
        this.etCustomHeaderKey = editText;
        this.etCustomHeaderValue = editText2;
        this.etEnvLane = editText3;
        this.etPpeEnv = editText4;
        this.llCustomHeaders = linearLayout2;
        this.llPpeHistory = linearLayout3;
        this.titleBar = traeTitleBar;
        this.tvDeviceId = textView11;
        this.tvEnvLaneCurrent = textView12;
        this.tvPassportUserId = textView13;
        this.tvPpeCurrent = textView14;
        this.tvPpeHistoryLabel = textView15;
        this.tvUserId = textView16;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDebugSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDebugSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_debug_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentDebugSettingsBinding bind(View view) {
        int i = C0820R.id.btn_clear;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C0820R.id.btn_clear_billing_upgrade_prompt_cache;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = C0820R.id.btn_copy_device_info;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = C0820R.id.btn_custom_header_add;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = C0820R.id.btn_custom_header_clear_all;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView5 != null) {
                            i = C0820R.id.btn_env_lane_reset;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView6 != null) {
                                i = C0820R.id.btn_env_lane_save;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView7 != null) {
                                    i = C0820R.id.btn_save;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView8 != null) {
                                        i = C0820R.id.btn_upload_alog;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView9 != null) {
                                            i = C0820R.id.btn_view_login_devices;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView10 != null) {
                                                i = C0820R.id.cb_mock_did;
                                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                                                if (checkBox != null) {
                                                    i = C0820R.id.et_custom_header_key;
                                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                    if (editText != null) {
                                                        i = C0820R.id.et_custom_header_value;
                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                                        if (editText2 != null) {
                                                            i = C0820R.id.et_env_lane;
                                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                                            if (editText3 != null) {
                                                                i = C0820R.id.et_ppe_env;
                                                                EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                if (editText4 != null) {
                                                                    i = C0820R.id.ll_custom_headers;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout != null) {
                                                                        i = C0820R.id.ll_ppe_history;
                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout2 != null) {
                                                                            i = C0820R.id.title_bar;
                                                                            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                                                                            if (traeTitleBar != null) {
                                                                                i = C0820R.id.tv_device_id;
                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView11 != null) {
                                                                                    i = C0820R.id.tv_env_lane_current;
                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView12 != null) {
                                                                                        i = C0820R.id.tv_passport_user_id;
                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView13 != null) {
                                                                                            i = C0820R.id.tv_ppe_current;
                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView14 != null) {
                                                                                                i = C0820R.id.tv_ppe_history_label;
                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView15 != null) {
                                                                                                    i = C0820R.id.tv_user_id;
                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView16 != null) {
                                                                                                        return new FragmentDebugSettingsBinding((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, checkBox, editText, editText2, editText3, editText4, linearLayout, linearLayout2, traeTitleBar, textView11, textView12, textView13, textView14, textView15, textView16);
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
