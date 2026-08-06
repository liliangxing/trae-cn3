package com.bytedance.upc.common.settings;

import com.bytedance.upc.common.log.LogUtils;
import com.bytedance.upc.common.storage.SpStorage;
import com.heytap.mcssdk.constant.C0878a;
import com.huawei.hms.push.AttributionReporter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UpcOnlineSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0004J\u0016\u0010 \u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0016J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0016J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0016J\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0016J\u0012\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006'"}, d2 = {"Lcom/bytedance/upc/common/settings/UpcOnlineSettings;", "", "()V", "KEY_UPC_SETTING", "", "STORAGE_TYPE", "UPC_API_HOOK_HELIOS_SETTINGS", "UPC_CLIP_BOARD_ENABLE", "UPC_LAST_REQUEST_PERMISSION_FREQUENCY", "UPC_REQUEST_PERMISSION_FREQUENCY", "UPC_SETTINGS_PRIVACY_REQ_FREQUENCY", "UPC_SETTINGS_PRIVACY_SYNC_FREQUENCY", "mSp", "Lcom/bytedance/upc/common/storage/SpStorage;", "getMSp", "()Lcom/bytedance/upc/common/storage/SpStorage;", "mSp$delegate", "Lkotlin/Lazy;", "getClipBoardEnable", "", "getHeliosConfigData", "getLastReqPermissionFrequency", "", AttributionReporter.SYSTEM_PERMISSION, "getReqPermissionFrequency", "getReqPrivacyFrequency", "getSyncPrivacyFrequency", "setClipBoardEnable", "", "enable", "setHeliosConfigData", "data", "setLastReqPermissionFrequency", "frequency", "setReqPermissionFrequency", "setReqPrivacyFrequency", "setSyncPrivacyFrequency", "updateSetting", "settingData", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UpcOnlineSettings {
    private static final String KEY_UPC_SETTING = "sdk_key_UpcSDK";
    private static final String STORAGE_TYPE = "upc_sdk_settings";
    private static final String UPC_API_HOOK_HELIOS_SETTINGS = "upc_helios_settings";
    private static final String UPC_CLIP_BOARD_ENABLE = "upc_clipboard_enable";
    private static final String UPC_LAST_REQUEST_PERMISSION_FREQUENCY = "upc_last_request_permission_frequency";
    private static final String UPC_REQUEST_PERMISSION_FREQUENCY = "upc_request_permission_frequency";
    private static final String UPC_SETTINGS_PRIVACY_REQ_FREQUENCY = "upc_privacy_req_frequency";
    private static final String UPC_SETTINGS_PRIVACY_SYNC_FREQUENCY = "upc_privacy_sync_frequency";
    public static final UpcOnlineSettings INSTANCE = new UpcOnlineSettings();

    /* renamed from: mSp$delegate, reason: from kotlin metadata */
    private static final Lazy mSp = LazyKt.lazy(new Function0<SpStorage>() { // from class: com.bytedance.upc.common.settings.UpcOnlineSettings$mSp$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SpStorage m2607invoke() {
            return SpStorage.INSTANCE;
        }
    });

    private final SpStorage getMSp() {
        return (SpStorage) mSp.getValue();
    }

    private UpcOnlineSettings() {
    }

    public final long getReqPrivacyFrequency() {
        Long l = getMSp().getLong("upc_sdk_settings", UPC_SETTINGS_PRIVACY_REQ_FREQUENCY, 0L);
        return l != null ? l.longValue() : C0878a.f518d;
    }

    public final void setReqPrivacyFrequency(long frequency) {
        getMSp().setLong("upc_sdk_settings", UPC_SETTINGS_PRIVACY_REQ_FREQUENCY, frequency);
    }

    public final long getSyncPrivacyFrequency() {
        Long l = getMSp().getLong("upc_sdk_settings", UPC_SETTINGS_PRIVACY_SYNC_FREQUENCY, 0L);
        return l != null ? l.longValue() : C0878a.f521g;
    }

    public final void setSyncPrivacyFrequency(long frequency) {
        getMSp().setLong("upc_sdk_settings", UPC_SETTINGS_PRIVACY_SYNC_FREQUENCY, frequency);
    }

    public final long getLastReqPermissionFrequency(String permission) {
        Intrinsics.checkParameterIsNotNull(permission, AttributionReporter.SYSTEM_PERMISSION);
        Long l = getMSp().getLong("upc_sdk_settings", "upc_last_request_permission_frequency_" + permission, 0L);
        if (l != null) {
            return l.longValue();
        }
        return 172800000L;
    }

    public final void setLastReqPermissionFrequency(String permission, long frequency) {
        Intrinsics.checkParameterIsNotNull(permission, AttributionReporter.SYSTEM_PERMISSION);
        getMSp().setLong("upc_sdk_settings", "upc_last_request_permission_frequency_" + permission, frequency);
    }

    public final long getReqPermissionFrequency() {
        Long l = getMSp().getLong("upc_sdk_settings", UPC_REQUEST_PERMISSION_FREQUENCY, 0L);
        if (l != null) {
            return l.longValue();
        }
        return 172800000L;
    }

    public final void setReqPermissionFrequency(long frequency) {
        getMSp().setLong("upc_sdk_settings", UPC_REQUEST_PERMISSION_FREQUENCY, frequency);
    }

    public final void setHeliosConfigData(String data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        getMSp().setString("upc_sdk_settings", UPC_API_HOOK_HELIOS_SETTINGS, data);
    }

    public final String getHeliosConfigData() {
        String string = getMSp().getString("upc_sdk_settings", UPC_API_HOOK_HELIOS_SETTINGS, "");
        return string != null ? string : "";
    }

    public final void setClipBoardEnable(boolean enable) {
        getMSp().setLong("upc_sdk_settings", UPC_CLIP_BOARD_ENABLE, enable ? 0L : -1L);
    }

    public final boolean getClipBoardEnable() {
        Long l = getMSp().getLong("upc_sdk_settings", UPC_CLIP_BOARD_ENABLE, 0L);
        return l != null && l.longValue() == 0;
    }

    @JvmStatic
    public static final void updateSetting(String settingData) {
        try {
            JSONObject jSONObject = new JSONObject(settingData);
            JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("settings").optJSONObject(KEY_UPC_SETTING);
            if (optJSONObject != null) {
                UpcOnlineSettings upcOnlineSettings = INSTANCE;
                upcOnlineSettings.setReqPrivacyFrequency(optJSONObject.optLong(UPC_SETTINGS_PRIVACY_REQ_FREQUENCY));
                upcOnlineSettings.setReqPermissionFrequency(optJSONObject.optLong(UPC_REQUEST_PERMISSION_FREQUENCY));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data").optJSONObject("settings").optJSONObject(UPC_API_HOOK_HELIOS_SETTINGS);
            if (optJSONObject2 != null) {
                UpcOnlineSettings upcOnlineSettings2 = INSTANCE;
                String jSONObject2 = optJSONObject2.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "upcHeliosJson.toString()");
                upcOnlineSettings2.setHeliosConfigData(jSONObject2);
            }
            LogUtils.m9i("upcJson = " + optJSONObject + ", upcHeliosJson = " + optJSONObject2);
        } catch (Throwable unused) {
        }
    }
}
