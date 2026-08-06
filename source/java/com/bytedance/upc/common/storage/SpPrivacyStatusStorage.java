package com.bytedance.upc.common.storage;

import android.util.Log;
import com.bytedance.upc.common.log.LogUtils;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import com.lynx.animax.monitor.AnimaXMonitorUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: SpPrivacyStatusStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0004H\u0002J'\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0004J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0004J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\nJ\u0016\u0010\u0016\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/upc/common/storage/SpPrivacyStatusStorage;", "", "()V", "KEY_PRIVACY_DID_SETTINGS_DATA", "", "KEY_PRIVACY_UID_SETTINGS_DATA", "clearPrivacyStatus", "", "dimensions", "getLong", "", "type", "key", AnimaXMonitorUtil.TRIGGER_DEFAULT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "getPrivacySettingsData", "getString", "savePrivacySettingsData", "data", "setLong", "", CustomDataTagHandler.VALUE_ATTRIBUTE, "setString", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class SpPrivacyStatusStorage {
    public static final SpPrivacyStatusStorage INSTANCE = new SpPrivacyStatusStorage();
    private static final String KEY_PRIVACY_DID_SETTINGS_DATA = "upc_privacy_did_setting_data";
    private static final String KEY_PRIVACY_UID_SETTINGS_DATA = "upc_privacy_uid_setting_data";

    private final String dimensions() {
        return KEY_PRIVACY_DID_SETTINGS_DATA;
    }

    private SpPrivacyStatusStorage() {
    }

    public final void savePrivacySettingsData(String data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        SpStorage.INSTANCE.setString(SpStorage.STORAGE_PRIVACY, dimensions(), data);
    }

    public final String getPrivacySettingsData() {
        String string = SpStorage.INSTANCE.getString(SpStorage.STORAGE_PRIVACY, dimensions(), null);
        return string != null ? string : "";
    }

    public final String getString(String key, String r7) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        try {
            if (!Intrinsics.areEqual(key, "key_upc_privacy_agreement_status") && !Intrinsics.areEqual(key, "key_upc_privacy_teen_mode_status")) {
                String string = SpStorage.INSTANCE.getString(SpStorage.STORAGE_PRIVACY, dimensions(), "{}");
                return new JSONObject(string != null ? string : "{}").optString(key);
            }
            return SpStorage.INSTANCE.getString(SpStorage.STORAGE_SETTINGS, key, r7);
        } catch (Throwable th) {
            LogUtils.m7e(Log.getStackTraceString(th));
            return r7;
        }
    }

    public final boolean setString(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, CustomDataTagHandler.VALUE_ATTRIBUTE);
        try {
            if (!Intrinsics.areEqual(key, "key_upc_privacy_agreement_status") && !Intrinsics.areEqual(key, "key_upc_privacy_teen_mode_status")) {
                String string = SpStorage.INSTANCE.getString(SpStorage.STORAGE_PRIVACY, dimensions(), "{}");
                JSONObject jSONObject = new JSONObject(string != null ? string : "{}");
                jSONObject.put(key, value);
                SpStorage spStorage = SpStorage.INSTANCE;
                String dimensions = dimensions();
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "dataJson.toString()");
                return spStorage.setString(SpStorage.STORAGE_PRIVACY, dimensions, jSONObject2);
            }
            return SpStorage.INSTANCE.setString(SpStorage.STORAGE_SETTINGS, key, value);
        } catch (Throwable th) {
            LogUtils.m7e(Log.getStackTraceString(th));
            return false;
        }
    }

    public final Long getLong(String type, String key, Long r7) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(key, "key");
        try {
            String string = SpStorage.INSTANCE.getString(SpStorage.STORAGE_PRIVACY, dimensions(), "{}");
            return Long.valueOf(new JSONObject(string != null ? string : "{}").optLong(key));
        } catch (Throwable th) {
            LogUtils.m7e(Log.getStackTraceString(th));
            return r7;
        }
    }

    public final boolean setLong(String type, String key, long value) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(key, "key");
        try {
            String string = SpStorage.INSTANCE.getString(SpStorage.STORAGE_PRIVACY, dimensions(), "{}");
            JSONObject jSONObject = new JSONObject(string != null ? string : "{}");
            jSONObject.put(key, value);
            SpStorage spStorage = SpStorage.INSTANCE;
            String dimensions = dimensions();
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "dataJson.toString()");
            return spStorage.setString(SpStorage.STORAGE_PRIVACY, dimensions, jSONObject2);
        } catch (Throwable th) {
            LogUtils.m7e(Log.getStackTraceString(th));
            return false;
        }
    }

    public final void clearPrivacyStatus() {
        SpStorage.INSTANCE.clear(SpStorage.STORAGE_PRIVACY);
    }
}
