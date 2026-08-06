package com.bytedance.trae.home.solo.setting;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.billing.BillingUpgradePromptCoordinator;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeTTNet;
import com.bytedance.trae.settings.api.feature.Feature;
import com.bytedance.trae.settings.api.feature.FeatureCapability;
import com.bytedance.trae.settings.api.feature.IFeatureCapabilityService;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DebugSettingsFragment.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "llHistory", "Landroid/widget/LinearLayout;", "tvHistoryLabel", "Landroid/widget/TextView;", "etPpeEnv", "Landroid/widget/EditText;", "etEnvLane", "llCustomHeaders", "etCustomHeaderKey", "etCustomHeaderValue", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupForceTokenRefreshToggle", "setupEnterpriseEnvToggle", "setupAnyWhereDoorToggle", "setupDebugFloatingButtonToggle", "refreshHistory", "updateCurrentDisplay", "tv", "env", "", "updateEnvLaneDisplay", "lane", "refreshCustomHeaders", "setupNotificationBoeToggle", "setupFeatureCapabilitySection", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DebugSettingsFragment extends Fragment {
    private static final String TAG = "DebugSettingsFragment";
    private EditText etCustomHeaderKey;
    private EditText etCustomHeaderValue;
    private EditText etEnvLane;
    private EditText etPpeEnv;
    private LinearLayout llCustomHeaders;
    private LinearLayout llHistory;
    private TextView tvHistoryLabel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_debug_settings, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        AccountInfo accountInfo;
        EditText editText;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((TraeTitleBar) view.findViewById(C0820R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DebugSettingsFragment.onViewCreated$lambda$1(DebugSettingsFragment.this, view2);
            }
        });
        final TextView textView = (TextView) view.findViewById(C0820R.id.tv_ppe_current);
        this.etPpeEnv = (EditText) view.findViewById(C0820R.id.et_ppe_env);
        this.llHistory = (LinearLayout) view.findViewById(C0820R.id.ll_ppe_history);
        this.tvHistoryLabel = (TextView) view.findViewById(C0820R.id.tv_ppe_history_label);
        String ppeEnv = DebugSettings.INSTANCE.getPpeEnv();
        Intrinsics.checkNotNull(textView);
        updateCurrentDisplay(textView, ppeEnv);
        String str = ppeEnv;
        if ((str.length() > 0) && (editText = this.etPpeEnv) != null) {
            editText.setText(str);
        }
        view.findViewById(C0820R.id.btn_save).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DebugSettingsFragment.onViewCreated$lambda$2(DebugSettingsFragment.this, textView, view2);
            }
        });
        view.findViewById(C0820R.id.btn_clear).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DebugSettingsFragment.onViewCreated$lambda$3(DebugSettingsFragment.this, textView, view2);
            }
        });
        refreshHistory();
        final TextView textView2 = (TextView) view.findViewById(C0820R.id.tv_env_lane_current);
        this.etEnvLane = (EditText) view.findViewById(C0820R.id.et_env_lane);
        String envLane = DebugSettings.INSTANCE.getEnvLane();
        Intrinsics.checkNotNull(textView2);
        updateEnvLaneDisplay(textView2, envLane);
        EditText editText2 = this.etEnvLane;
        if (editText2 != null) {
            editText2.setText(envLane);
        }
        view.findViewById(C0820R.id.btn_env_lane_save).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DebugSettingsFragment.onViewCreated$lambda$4(DebugSettingsFragment.this, textView2, view2);
            }
        });
        view.findViewById(C0820R.id.btn_env_lane_reset).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DebugSettingsFragment.onViewCreated$lambda$5(DebugSettingsFragment.this, textView2, view2);
            }
        });
        this.llCustomHeaders = (LinearLayout) view.findViewById(C0820R.id.ll_custom_headers);
        this.etCustomHeaderKey = (EditText) view.findViewById(C0820R.id.et_custom_header_key);
        this.etCustomHeaderValue = (EditText) view.findViewById(C0820R.id.et_custom_header_value);
        view.findViewById(C0820R.id.btn_custom_header_add).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DebugSettingsFragment.onViewCreated$lambda$6(DebugSettingsFragment.this, view2);
            }
        });
        view.findViewById(C0820R.id.btn_custom_header_clear_all).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DebugSettingsFragment.onViewCreated$lambda$7(DebugSettingsFragment.this, view2);
            }
        });
        refreshCustomHeaders();
        final String deviceId = IApplog.INSTANCE.getDeviceId();
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        final String userId = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getUserId();
        if (userId == null) {
            userId = "";
        }
        final String userID = IApplog.INSTANCE.getUserID();
        TextView textView3 = (TextView) view.findViewById(C0820R.id.tv_device_id);
        TextView textView4 = (TextView) view.findViewById(C0820R.id.tv_user_id);
        TextView textView5 = (TextView) view.findViewById(C0820R.id.tv_passport_user_id);
        String str2 = deviceId;
        if (str2.length() == 0) {
            str2 = "-";
        }
        textView3.setText(str2);
        String str3 = userId;
        if (str3.length() == 0) {
            str3 = "-";
        }
        textView4.setText(str3);
        String str4 = userID;
        textView5.setText(str4.length() == 0 ? "-" : str4);
        view.findViewById(C0820R.id.btn_copy_device_info).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DebugSettingsFragment.onViewCreated$lambda$11(deviceId, userId, userID, this, view2);
            }
        });
        view.findViewById(C0820R.id.btn_view_login_devices).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DebugSettingsFragment.onViewCreated$lambda$12(DebugSettingsFragment.this, view2);
            }
        });
        view.findViewById(C0820R.id.btn_clear_billing_upgrade_prompt_cache).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DebugSettingsFragment.onViewCreated$lambda$13(DebugSettingsFragment.this, view2);
            }
        });
        final TextView textView6 = (TextView) view.findViewById(C0820R.id.btn_upload_alog);
        textView6.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DebugSettingsFragment.onViewCreated$lambda$16(textView6, this, view2);
            }
        });
        setupForceTokenRefreshToggle(view);
        CheckBox checkBox = (CheckBox) view.findViewById(C0820R.id.cb_mock_did);
        checkBox.setChecked(DebugSettings.INSTANCE.isDeviceManagerMockDid());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda24
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DebugSettingsFragment.onViewCreated$lambda$17(compoundButton, z);
            }
        });
        setupEnterpriseEnvToggle(view);
        setupAnyWhereDoorToggle(view);
        setupDebugFloatingButtonToggle(view);
        setupNotificationBoeToggle(view);
        setupFeatureCapabilitySection(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(final DebugSettingsFragment debugSettingsFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DebugSettingsFragment.onViewCreated$lambda$1$lambda$0(DebugSettingsFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$lambda$0(DebugSettingsFragment debugSettingsFragment) {
        debugSettingsFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(DebugSettingsFragment debugSettingsFragment, TextView textView, View view) {
        EditText editText = debugSettingsFragment.etPpeEnv;
        String obj = StringsKt.trim(String.valueOf(editText != null ? editText.getText() : null)).toString();
        if (obj.length() > 0) {
            DebugSettings.INSTANCE.setPpeEnv(obj);
            TraeTTNet.INSTANCE.updateHttpEnv(false, "", true, obj);
            Intrinsics.checkNotNull(textView);
            debugSettingsFragment.updateCurrentDisplay(textView, obj);
            debugSettingsFragment.refreshHistory();
            Toast.makeText(debugSettingsFragment.getContext(), C0820R.string.trae_setting_debug_ppe_env_saved, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(DebugSettingsFragment debugSettingsFragment, TextView textView, View view) {
        Editable text;
        DebugSettings.INSTANCE.setPpeEnv("");
        TraeTTNet.INSTANCE.updateHttpEnv(false, "", false, "");
        EditText editText = debugSettingsFragment.etPpeEnv;
        if (editText != null && (text = editText.getText()) != null) {
            text.clear();
        }
        Intrinsics.checkNotNull(textView);
        debugSettingsFragment.updateCurrentDisplay(textView, "");
        Toast.makeText(debugSettingsFragment.getContext(), C0820R.string.trae_setting_debug_ppe_env_cleared, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(DebugSettingsFragment debugSettingsFragment, TextView textView, View view) {
        EditText editText = debugSettingsFragment.etEnvLane;
        String obj = StringsKt.trim(String.valueOf(editText != null ? editText.getText() : null)).toString();
        if (obj.length() > 0) {
            DebugSettings.INSTANCE.setEnvLane(obj);
            Intrinsics.checkNotNull(textView);
            debugSettingsFragment.updateEnvLaneDisplay(textView, obj);
            Toast.makeText(debugSettingsFragment.getContext(), C0820R.string.trae_setting_debug_env_lane_saved, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(DebugSettingsFragment debugSettingsFragment, TextView textView, View view) {
        DebugSettings.INSTANCE.setEnvLane("");
        String envLane = DebugSettings.INSTANCE.getEnvLane();
        EditText editText = debugSettingsFragment.etEnvLane;
        if (editText != null) {
            editText.setText(envLane);
        }
        Intrinsics.checkNotNull(textView);
        debugSettingsFragment.updateEnvLaneDisplay(textView, envLane);
        Toast.makeText(debugSettingsFragment.getContext(), C0820R.string.trae_setting_debug_env_lane_reset, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(DebugSettingsFragment debugSettingsFragment, View view) {
        Editable text;
        Editable text2;
        EditText editText = debugSettingsFragment.etCustomHeaderKey;
        String obj = StringsKt.trim(String.valueOf(editText != null ? editText.getText() : null)).toString();
        EditText editText2 = debugSettingsFragment.etCustomHeaderValue;
        String obj2 = StringsKt.trim(String.valueOf(editText2 != null ? editText2.getText() : null)).toString();
        if (obj.length() == 0) {
            Toast.makeText(debugSettingsFragment.getContext(), C0820R.string.trae_setting_debug_custom_header_empty, 0).show();
            return;
        }
        DebugSettings.INSTANCE.addCustomHeader(obj, obj2);
        EditText editText3 = debugSettingsFragment.etCustomHeaderKey;
        if (editText3 != null && (text2 = editText3.getText()) != null) {
            text2.clear();
        }
        EditText editText4 = debugSettingsFragment.etCustomHeaderValue;
        if (editText4 != null && (text = editText4.getText()) != null) {
            text.clear();
        }
        debugSettingsFragment.refreshCustomHeaders();
        Toast.makeText(debugSettingsFragment.getContext(), C0820R.string.trae_setting_debug_custom_header_added, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(DebugSettingsFragment debugSettingsFragment, View view) {
        DebugSettings.INSTANCE.setCustomHeaders(MapsKt.emptyMap());
        debugSettingsFragment.refreshCustomHeaders();
        Toast.makeText(debugSettingsFragment.getContext(), C0820R.string.trae_setting_debug_custom_header_cleared, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$11(String str, String str2, String str3, DebugSettingsFragment debugSettingsFragment, View view) {
        String str4 = "device_id: " + str + "\nuser_id: " + str2 + "\npassport_uid: " + str3;
        Object systemService = debugSettingsFragment.requireContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("device_info", str4));
        Toast.makeText(debugSettingsFragment.getContext(), C0820R.string.trae_setting_debug_device_info_copied, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$12(DebugSettingsFragment debugSettingsFragment, View view) {
        debugSettingsFragment.getParentFragmentManager().beginTransaction().setCustomAnimations(C0820R.anim.trae_slide_in_right, C0820R.anim.trae_slide_out_left, C0820R.anim.trae_slide_in_left, C0820R.anim.trae_slide_out_right).replace(C0820R.id.settings_fragment_container, DebugLoginDevicesFragment.INSTANCE.newInstance()).addToBackStack((String) null).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$13(DebugSettingsFragment debugSettingsFragment, View view) {
        BillingUpgradePromptCoordinator.INSTANCE.clearCacheForDebug();
        Toast.makeText(debugSettingsFragment.getContext(), C0820R.string.trae_setting_debug_billing_prompt_cache_cleared, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$16(final TextView textView, final DebugSettingsFragment debugSettingsFragment, View view) {
        textView.setText(debugSettingsFragment.getString(C0820R.string.trae_setting_debug_alog_uploading));
        textView.setEnabled(false);
        textView.setAlpha(0.5f);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        FLogger.INSTANCE.uploadALog("feedback", currentTimeMillis - 3600, currentTimeMillis, new Function1() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$16$lambda$15;
                onViewCreated$lambda$16$lambda$15 = DebugSettingsFragment.onViewCreated$lambda$16$lambda$15(textView, debugSettingsFragment, ((Boolean) obj).booleanValue());
                return onViewCreated$lambda$16$lambda$15;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$16$lambda$15(final TextView textView, final DebugSettingsFragment debugSettingsFragment, final boolean z) {
        textView.post(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                DebugSettingsFragment.onViewCreated$lambda$16$lambda$15$lambda$14(textView, debugSettingsFragment, z);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$16$lambda$15$lambda$14(TextView textView, DebugSettingsFragment debugSettingsFragment, boolean z) {
        int i;
        textView.setText(debugSettingsFragment.getString(C0820R.string.trae_setting_debug_alog_upload));
        textView.setEnabled(true);
        textView.setAlpha(1.0f);
        if (z) {
            i = C0820R.string.trae_setting_debug_alog_success;
        } else {
            i = C0820R.string.trae_setting_debug_alog_failed;
        }
        Toast.makeText(debugSettingsFragment.getContext(), i, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$17(CompoundButton compoundButton, boolean z) {
        DebugSettings.INSTANCE.setDeviceManagerMockDid(z);
    }

    private final void setupForceTokenRefreshToggle(View view) {
        final Context context = getContext();
        if (context == null) {
            return;
        }
        int i = (int) (16 * context.getResources().getDisplayMetrics().density);
        int i2 = (int) (12 * context.getResources().getDisplayMetrics().density);
        int i3 = (int) (8 * context.getResources().getDisplayMetrics().density);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = i;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(i);
        linearLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        textView.setText("Force Token Refresh");
        textView.setTextSize(14.0f);
        textView.setPadding(0, i3, i2, i3);
        SwitchCompat switchCompat = new SwitchCompat(context);
        switchCompat.setChecked(DebugSettings.INSTANCE.getForceTokenRefresh());
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda18
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DebugSettingsFragment.setupForceTokenRefreshToggle$lambda$22$lambda$21(context, compoundButton, z);
            }
        });
        linearLayout.addView(textView);
        linearLayout.addView((View) switchCompat);
        View findViewById = view.findViewById(C0820R.id.btn_upload_alog);
        if (findViewById == null) {
            return;
        }
        ViewParent parent = findViewById.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        viewGroup.addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupForceTokenRefreshToggle$lambda$22$lambda$21(Context context, CompoundButton compoundButton, boolean z) {
        DebugSettings.INSTANCE.setForceTokenRefresh(z);
        Toast.makeText(context, z ? "Force refresh ON" : "Force refresh OFF", 0).show();
    }

    private final void setupEnterpriseEnvToggle(View view) {
        final Context context = getContext();
        if (context == null) {
            return;
        }
        int i = (int) (16 * context.getResources().getDisplayMetrics().density);
        int i2 = (int) (8 * context.getResources().getDisplayMetrics().density);
        int i3 = (int) (12 * context.getResources().getDisplayMetrics().density);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = i;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(i);
        linearLayout.setLayoutParams(layoutParams);
        boolean isEnterpriseTestEnv = DebugSettings.INSTANCE.isEnterpriseTestEnv();
        String str = isEnterpriseTestEnv ? "TEST (enterprise.mcdemo.show)" : "ONLINE (console.enterprise.trae.cn)";
        final TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        textView.setText("Enterprise Env: ".concat(str));
        textView.setTextSize(13.0f);
        textView.setPadding(0, i2, i3, i2);
        SwitchCompat switchCompat = new SwitchCompat(context);
        switchCompat.setChecked(isEnterpriseTestEnv);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DebugSettingsFragment.setupEnterpriseEnvToggle$lambda$27$lambda$26(textView, context, compoundButton, z);
            }
        });
        linearLayout.addView(textView);
        linearLayout.addView((View) switchCompat);
        View findViewById = view.findViewById(C0820R.id.btn_upload_alog);
        if (findViewById == null) {
            return;
        }
        ViewParent parent = findViewById.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        viewGroup.addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupEnterpriseEnvToggle$lambda$27$lambda$26(TextView textView, Context context, CompoundButton compoundButton, boolean z) {
        DebugSettings.INSTANCE.setEnterpriseEnv(z ? "TEST" : "ONLINE");
        String str = z ? "TEST" : "ONLINE";
        textView.setText("Enterprise Env: ".concat(z ? "TEST (enterprise.mcdemo.show)" : "ONLINE (console.enterprise.trae.cn)"));
        Toast.makeText(context, "Enterprise env: ".concat(str), 0).show();
    }

    private final void setupAnyWhereDoorToggle(View view) {
        try {
            Class.forName("com.bytedance.trae.home.solo.setting.AnyDoorDebugSettings").getMethod("setupToggle", Fragment.class, View.class).invoke(null, this, view);
        } catch (ClassNotFoundException unused) {
        } catch (Exception e) {
            FLogger.INSTANCE.e(TAG, "AnyDoor debug settings setup failed", e);
        }
    }

    private final void setupDebugFloatingButtonToggle(View view) {
        final Context context = getContext();
        if (context == null) {
            return;
        }
        int i = (int) (16 * context.getResources().getDisplayMetrics().density);
        int i2 = (int) (12 * context.getResources().getDisplayMetrics().density);
        int i3 = (int) (8 * context.getResources().getDisplayMetrics().density);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = i;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(i);
        linearLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        textView.setText("Debug Floating Button");
        textView.setTextSize(14.0f);
        textView.setPadding(0, i3, i2, i3);
        SwitchCompat switchCompat = new SwitchCompat(context);
        switchCompat.setChecked(DebugSettings.INSTANCE.isDebugFloatingButtonEnabled());
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda12
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DebugSettingsFragment.setupDebugFloatingButtonToggle$lambda$32$lambda$31(context, compoundButton, z);
            }
        });
        linearLayout.addView(textView);
        linearLayout.addView((View) switchCompat);
        View findViewById = view.findViewById(C0820R.id.btn_upload_alog);
        if (findViewById == null) {
            return;
        }
        ViewParent parent = findViewById.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        viewGroup.addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDebugFloatingButtonToggle$lambda$32$lambda$31(Context context, CompoundButton compoundButton, boolean z) {
        Method method;
        DebugSettings.INSTANCE.setDebugFloatingButtonEnabled(z);
        try {
            Class<?> cls = Class.forName("com.bytedance.trae.home.solo.setting.DebugFloatingButtonManager");
            if (z) {
                method = cls.getMethod("show", new Class[0]);
            } else {
                method = cls.getMethod("hide", new Class[0]);
            }
            method.invoke(null, new Object[0]);
        } catch (ClassNotFoundException unused) {
        }
        Toast.makeText(context, z ? "Debug floating button ON" : "Debug floating button OFF", 0).show();
    }

    private final void refreshHistory() {
        TextView textView;
        LinearLayout linearLayout = this.llHistory;
        if (linearLayout == null || (textView = this.tvHistoryLabel) == null) {
            return;
        }
        linearLayout.removeAllViews();
        List<String> ppeHistory = DebugSettings.INSTANCE.getPpeHistory();
        if (ppeHistory.isEmpty()) {
            textView.setVisibility(8);
            linearLayout.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        linearLayout.setVisibility(0);
        Context context = getContext();
        if (context == null) {
            return;
        }
        int i = (int) (8 * context.getResources().getDisplayMetrics().density);
        int i2 = (int) (4 * context.getResources().getDisplayMetrics().density);
        int i3 = (int) (12 * context.getResources().getDisplayMetrics().density);
        for (final String str : ppeHistory) {
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = i2;
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setPadding(i, i, i, i);
            linearLayout2.setBackgroundResource(C0820R.drawable.bg_dialog_input);
            TextView textView2 = new TextView(context);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            textView2.setText(str);
            textView2.setTextColor(ContextCompat.getColor(context, C0820R.color.trae_setting_text_primary));
            textView2.setTextSize(14.0f);
            textView2.setSingleLine(true);
            TextView textView3 = new TextView(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMarginStart(i3);
            textView3.setLayoutParams(layoutParams2);
            textView3.setText("✕");
            textView3.setTextColor(ContextCompat.getColor(context, C0820R.color.trae_setting_text_secondary));
            textView3.setTextSize(14.0f);
            textView3.setPadding(i, i2, i, i2);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DebugSettingsFragment.refreshHistory$lambda$40$lambda$38(DebugSettingsFragment.this, str, view);
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DebugSettingsFragment.refreshHistory$lambda$40$lambda$39(str, this, view);
                }
            });
            linearLayout2.addView(textView2);
            linearLayout2.addView(textView3);
            linearLayout.addView(linearLayout2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshHistory$lambda$40$lambda$38(DebugSettingsFragment debugSettingsFragment, String str, View view) {
        EditText editText = debugSettingsFragment.etPpeEnv;
        if (editText != null) {
            editText.setText(str);
        }
        EditText editText2 = debugSettingsFragment.etPpeEnv;
        if (editText2 != null) {
            editText2.setSelection(str.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshHistory$lambda$40$lambda$39(String str, DebugSettingsFragment debugSettingsFragment, View view) {
        DebugSettings.INSTANCE.removePpeHistory(str);
        debugSettingsFragment.refreshHistory();
    }

    private final void updateCurrentDisplay(TextView tv, String env) {
        String str = env;
        if (str.length() == 0) {
            str = getString(C0820R.string.trae_setting_debug_ppe_env_not_set);
        }
        tv.setText(str);
    }

    private final void updateEnvLaneDisplay(TextView tv, String lane) {
        tv.setText(getString(C0820R.string.trae_setting_debug_env_lane_current, new Object[]{lane}));
    }

    private final void refreshCustomHeaders() {
        Context context;
        LinearLayout linearLayout = this.llCustomHeaders;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        Map customHeaders = DebugSettings.INSTANCE.getCustomHeaders();
        if (customHeaders.isEmpty() || (context = getContext()) == null) {
            return;
        }
        int i = (int) (8 * context.getResources().getDisplayMetrics().density);
        int i2 = (int) (4 * context.getResources().getDisplayMetrics().density);
        int i3 = (int) (12 * context.getResources().getDisplayMetrics().density);
        for (Map.Entry entry : customHeaders.entrySet()) {
            final String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = i2;
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setPadding(i, i, i, i);
            linearLayout2.setBackgroundResource(C0820R.drawable.bg_dialog_input);
            TextView textView = new TextView(context);
            textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            textView.setText(str + ": " + str2);
            textView.setTextColor(ContextCompat.getColor(context, C0820R.color.trae_setting_text_primary));
            textView.setTextSize(13.0f);
            textView.setSingleLine(true);
            TextView textView2 = new TextView(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMarginStart(i3);
            textView2.setLayoutParams(layoutParams2);
            textView2.setText("✕");
            textView2.setTextColor(ContextCompat.getColor(context, C0820R.color.trae_setting_text_secondary));
            textView2.setTextSize(14.0f);
            textView2.setPadding(i, i2, i, i2);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DebugSettingsFragment.refreshCustomHeaders$lambda$47$lambda$46(str, this, view);
                }
            });
            linearLayout2.addView(textView);
            linearLayout2.addView(textView2);
            linearLayout.addView(linearLayout2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshCustomHeaders$lambda$47$lambda$46(String str, DebugSettingsFragment debugSettingsFragment, View view) {
        DebugSettings.INSTANCE.removeCustomHeader(str);
        debugSettingsFragment.refreshCustomHeaders();
    }

    private final void setupNotificationBoeToggle(View view) {
        final Context context = getContext();
        if (context == null) {
            return;
        }
        int i = (int) (16 * context.getResources().getDisplayMetrics().density);
        int i2 = (int) (12 * context.getResources().getDisplayMetrics().density);
        int i3 = (int) (8 * context.getResources().getDisplayMetrics().density);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = i;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(i);
        linearLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        textView.setText("Notification BOE");
        textView.setTextSize(14.0f);
        textView.setPadding(0, i3, i2, i3);
        SwitchCompat switchCompat = new SwitchCompat(context);
        switchCompat.setChecked(DebugSettings.INSTANCE.getNotificationBoe());
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda20
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DebugSettingsFragment.setupNotificationBoeToggle$lambda$52$lambda$51(context, compoundButton, z);
            }
        });
        linearLayout.addView(textView);
        linearLayout.addView((View) switchCompat);
        View findViewById = view.findViewById(C0820R.id.btn_upload_alog);
        if (findViewById == null) {
            return;
        }
        ViewParent parent = findViewById.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        viewGroup.addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNotificationBoeToggle$lambda$52$lambda$51(Context context, CompoundButton compoundButton, boolean z) {
        DebugSettings.INSTANCE.setNotificationBoe(z);
        Toast.makeText(context, z ? "Notification BOE ON" : "Notification BOE OFF", 0).show();
    }

    private final void setupFeatureCapabilitySection(View view) {
        IFeatureCapabilityService iFeatureCapabilityService;
        int i;
        final Context context = getContext();
        if (context == null || (iFeatureCapabilityService = (IFeatureCapabilityService) ServiceManager.get().getService(IFeatureCapabilityService.class)) == null) {
            return;
        }
        float f = context.getResources().getDisplayMetrics().density;
        int i2 = 16;
        int i3 = (int) (16 * f);
        int i4 = (int) (12 * f);
        int i5 = (int) (8 * f);
        int i6 = (int) (4 * f);
        int i7 = (int) f;
        View findViewById = view.findViewById(C0820R.id.btn_upload_alog);
        if (findViewById == null) {
            return;
        }
        ViewParent parent = findViewById.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        View view2 = new View(context);
        int i8 = -1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i7);
        layoutParams.topMargin = i3;
        layoutParams.setMarginStart(i3);
        layoutParams.setMarginEnd(i3);
        view2.setLayoutParams(layoutParams);
        view2.setBackgroundColor(ContextCompat.getColor(context, C0820R.color.trae_setting_divider));
        viewGroup.addView(view2);
        TextView textView = new TextView(context);
        int i9 = -2;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = i3;
        layoutParams2.setMarginStart(i3);
        layoutParams2.setMarginEnd(i3);
        textView.setLayoutParams(layoutParams2);
        textView.setText("Feature Capability");
        textView.setTextSize(16.0f);
        textView.setTypeface(null, 1);
        textView.setTextColor(ContextCompat.getColor(context, C0820R.color.trae_setting_text_primary));
        viewGroup.addView(textView);
        TextView textView2 = new TextView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = i6;
        layoutParams3.setMarginStart(i3);
        layoutParams3.setMarginEnd(i3);
        textView2.setLayoutParams(layoutParams3);
        StringBuilder sb = new StringBuilder("Current: ");
        Set enabledFeatures = FeatureCapability.INSTANCE.getEnabledFeatures();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(enabledFeatures, 10));
        Iterator it = enabledFeatures.iterator();
        while (it.hasNext()) {
            arrayList.add(((Feature) it.next()).getKey());
        }
        textView2.setText(sb.append(CollectionsKt.joinToString$default(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).toString());
        float f2 = 12.0f;
        textView2.setTextSize(12.0f);
        textView2.setTextColor(ContextCompat.getColor(context, C0820R.color.trae_setting_text_secondary));
        viewGroup.addView(textView2);
        for (final Feature feature : Feature.getEntries()) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(i2);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i8, i9);
            layoutParams4.topMargin = i5;
            layoutParams4.setMarginStart(i3);
            layoutParams4.setMarginEnd(i3);
            linearLayout.setLayoutParams(layoutParams4);
            boolean isEnabled = FeatureCapability.INSTANCE.isEnabled(feature);
            TextView textView3 = new TextView(context);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(i9, i9);
            layoutParams5.setMarginEnd(i5);
            textView3.setLayoutParams(layoutParams5);
            textView3.setText(isEnabled ? "●" : "○");
            textView3.setTextSize(f2);
            if (isEnabled) {
                i = C0820R.color.trae_setting_pro_badge_bg;
            } else {
                i = C0820R.color.trae_setting_text_secondary;
            }
            textView3.setTextColor(ContextCompat.getColor(context, i));
            TextView textView4 = new TextView(context);
            textView4.setLayoutParams(new LinearLayout.LayoutParams(0, i9, 1.0f));
            textView4.setText(feature.getKey());
            textView4.setTextSize(14.0f);
            textView4.setTextColor(ContextCompat.getColor(context, C0820R.color.trae_setting_text_primary));
            RadioGroup radioGroup = new RadioGroup(context);
            radioGroup.setOrientation(0);
            radioGroup.setLayoutParams(new LinearLayout.LayoutParams(i9, i9));
            final RadioButton radioButton = new RadioButton(context);
            radioButton.setText("Default");
            radioButton.setTextSize(11.0f);
            radioButton.setId(View.generateViewId());
            radioButton.setPadding(i6, 0, i5, 0);
            final RadioButton radioButton2 = new RadioButton(context);
            radioButton2.setText("ON");
            radioButton2.setTextSize(11.0f);
            radioButton2.setId(View.generateViewId());
            radioButton2.setPadding(i6, 0, i5, 0);
            final RadioButton radioButton3 = new RadioButton(context);
            radioButton3.setText("OFF");
            radioButton3.setTextSize(11.0f);
            radioButton3.setId(View.generateViewId());
            radioButton3.setPadding(i6, 0, i6, 0);
            radioGroup.addView(radioButton);
            radioGroup.addView(radioButton2);
            radioGroup.addView(radioButton3);
            radioButton.setChecked(true);
            final IFeatureCapabilityService iFeatureCapabilityService2 = iFeatureCapabilityService;
            final TextView textView5 = textView2;
            ViewGroup viewGroup2 = viewGroup;
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda13
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i10) {
                    DebugSettingsFragment.setupFeatureCapabilitySection$lambda$70(radioButton, iFeatureCapabilityService2, feature, radioButton2, radioButton3, textView5, radioGroup2, i10);
                }
            });
            TextView textView6 = new TextView(context);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams6.setMarginStart(i5);
            textView6.setLayoutParams(layoutParams6);
            textView6.setText("Test");
            textView6.setTextSize(11.0f);
            textView6.setTextColor(ContextCompat.getColor(context, C0820R.color.trae_setting_text_link));
            textView6.setPadding(i5, i6, i5, i6);
            textView6.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    DebugSettingsFragment.setupFeatureCapabilitySection$lambda$73$lambda$72(feature, context, view3);
                }
            });
            linearLayout.addView(textView3);
            linearLayout.addView(textView4);
            linearLayout.addView(radioGroup);
            linearLayout.addView(textView6);
            viewGroup2.addView(linearLayout);
            i9 = -2;
            f2 = 12.0f;
            i3 = i3;
            iFeatureCapabilityService = iFeatureCapabilityService;
            textView2 = textView5;
            i4 = i4;
            i2 = 16;
            i8 = -1;
            viewGroup = viewGroup2;
        }
        final IFeatureCapabilityService iFeatureCapabilityService3 = iFeatureCapabilityService;
        final TextView textView7 = textView2;
        int i10 = i3;
        int i11 = i4;
        ViewGroup viewGroup3 = viewGroup;
        int i12 = i9;
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, i12);
        layoutParams7.topMargin = i11;
        layoutParams7.setMarginStart(i10);
        layoutParams7.setMarginEnd(i10);
        linearLayout2.setLayoutParams(layoutParams7);
        TextView textView8 = new TextView(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(i12, i12);
        layoutParams8.setMarginEnd(i11);
        textView8.setLayoutParams(layoutParams8);
        textView8.setText("Get All Enabled");
        textView8.setTextSize(14.0f);
        textView8.setTextColor(ContextCompat.getColor(context, C0820R.color.trae_setting_text_link));
        textView8.setPadding(0, i5, i5, i5);
        textView8.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DebugSettingsFragment.setupFeatureCapabilitySection$lambda$80$lambda$79(context, view3);
            }
        });
        TextView textView9 = new TextView(context);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(i12, i12);
        layoutParams9.setMarginEnd(i11);
        textView9.setLayoutParams(layoutParams9);
        textView9.setText("Refresh");
        textView9.setTextSize(14.0f);
        textView9.setTextColor(ContextCompat.getColor(context, C0820R.color.trae_setting_text_link));
        textView9.setPadding(0, i5, i5, i5);
        textView9.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DebugSettingsFragment.setupFeatureCapabilitySection$lambda$83$lambda$82(context, textView7, view3);
            }
        });
        TextView textView10 = new TextView(context);
        textView10.setLayoutParams(new LinearLayout.LayoutParams(i12, i12));
        textView10.setText("Reset All");
        textView10.setTextSize(14.0f);
        textView10.setTextColor(ContextCompat.getColor(context, C0820R.color.trae_setting_text_link));
        textView10.setPadding(0, i5, 0, i5);
        textView10.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DebugSettingsFragment.setupFeatureCapabilitySection$lambda$85$lambda$84(iFeatureCapabilityService3, context, textView7, view3);
            }
        });
        linearLayout2.addView(textView8);
        linearLayout2.addView(textView9);
        linearLayout2.addView(textView10);
        viewGroup3.addView(linearLayout2);
    }

    private static final void setupFeatureCapabilitySection$refreshCurrentStatus(TextView textView) {
        StringBuilder sb = new StringBuilder("Current: ");
        Set enabledFeatures = FeatureCapability.INSTANCE.getEnabledFeatures();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(enabledFeatures, 10));
        Iterator it = enabledFeatures.iterator();
        while (it.hasNext()) {
            arrayList.add(((Feature) it.next()).getKey());
        }
        textView.setText(sb.append(CollectionsKt.joinToString$default(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFeatureCapabilitySection$lambda$70(RadioButton radioButton, IFeatureCapabilityService iFeatureCapabilityService, Feature feature, RadioButton radioButton2, RadioButton radioButton3, TextView textView, RadioGroup radioGroup, int i) {
        if (i == radioButton.getId()) {
            iFeatureCapabilityService.setDebugOverride(feature, (Boolean) null);
        } else if (i == radioButton2.getId()) {
            iFeatureCapabilityService.setDebugOverride(feature, true);
        } else if (i == radioButton3.getId()) {
            iFeatureCapabilityService.setDebugOverride(feature, false);
        }
        setupFeatureCapabilitySection$refreshCurrentStatus(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFeatureCapabilitySection$lambda$73$lambda$72(Feature feature, Context context, View view) {
        boolean isEnabled = FeatureCapability.INSTANCE.isEnabled(feature);
        String str = feature.getKey() + " isEnabled = " + isEnabled;
        FLogger.INSTANCE.i(TAG, "FeatureCapability.isEnabled(" + feature.getKey() + ") = " + isEnabled);
        new AlertDialog.Builder(context).setTitle("Feature Test").setMessage(str).setPositiveButton("OK", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFeatureCapabilitySection$lambda$80$lambda$79(Context context, View view) {
        String joinToString$default = CollectionsKt.joinToString$default(FeatureCapability.INSTANCE.getEnabledFeatures(), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.home.solo.setting.DebugSettingsFragment$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                CharSequence charSequence;
                charSequence = DebugSettingsFragment.setupFeatureCapabilitySection$lambda$80$lambda$79$lambda$77((Feature) obj);
                return charSequence;
            }
        }, 30, (Object) null);
        FLogger.INSTANCE.i(TAG, "getEnabledFeatures: " + joinToString$default);
        AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle("Enabled Features");
        String str = joinToString$default;
        if (str.length() == 0) {
            str = "(none)";
        }
        title.setMessage(str).setPositiveButton("OK", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence setupFeatureCapabilitySection$lambda$80$lambda$79$lambda$77(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "it");
        return feature.getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFeatureCapabilitySection$lambda$83$lambda$82(Context context, TextView textView, View view) {
        FeatureCapability.INSTANCE.refresh();
        FLogger.INSTANCE.i(TAG, "FeatureCapability.refresh() called");
        setupFeatureCapabilitySection$refreshCurrentStatus(textView);
        Toast.makeText(context, "Feature config refreshed", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFeatureCapabilitySection$lambda$85$lambda$84(IFeatureCapabilityService iFeatureCapabilityService, Context context, TextView textView, View view) {
        Iterator it = Feature.getEntries().iterator();
        while (it.hasNext()) {
            iFeatureCapabilityService.setDebugOverride((Feature) it.next(), (Boolean) null);
        }
        setupFeatureCapabilitySection$refreshCurrentStatus(textView);
        Toast.makeText(context, "All feature overrides cleared", 0).show();
    }

    /* compiled from: DebugSettingsFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DebugSettingsFragment newInstance() {
            return new DebugSettingsFragment();
        }
    }
}
