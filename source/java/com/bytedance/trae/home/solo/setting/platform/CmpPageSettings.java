package com.bytedance.trae.home.solo.setting.platform;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.trae.network.E2ENetworkOverrides;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* compiled from: CmpPageSettings.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;", "", "<init>", "()V", "TAG", "", "SETTINGS_ENTRY_KEY", "DEVICE_MANAGEMENT_KEY", "isSettingsEntryEnabled", "", "isDeviceManagementEnabled", "readBoolean", "key", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CmpPageSettings {
    public static final int $stable = 0;
    private static final String DEVICE_MANAGEMENT_KEY = "device_management";
    public static final CmpPageSettings INSTANCE = new CmpPageSettings();
    private static final String SETTINGS_ENTRY_KEY = "settings_entry";
    private static final String TAG = "CmpPageSettings";

    private CmpPageSettings() {
    }

    public final boolean isSettingsEntryEnabled() {
        Boolean cmpSettingsEntryEnabledOverrideOrNull = E2ENetworkOverrides.INSTANCE.cmpSettingsEntryEnabledOverrideOrNull();
        return cmpSettingsEntryEnabledOverrideOrNull != null ? cmpSettingsEntryEnabledOverrideOrNull.booleanValue() : readBoolean(SETTINGS_ENTRY_KEY);
    }

    public final boolean isDeviceManagementEnabled() {
        Boolean cmpDeviceManagementEnabledOverrideOrNull = E2ENetworkOverrides.INSTANCE.cmpDeviceManagementEnabledOverrideOrNull();
        return cmpDeviceManagementEnabledOverrideOrNull != null ? cmpDeviceManagementEnabledOverrideOrNull.booleanValue() : readBoolean("device_management");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean readBoolean(String key) {
        Object obj;
        Object obj2;
        Throwable th;
        JsonElement jsonElement;
        boolean z;
        try {
            Result.Companion companion = Result.Companion;
            CmpPageSettings cmpPageSettings = this;
            IHomeCmpPageSettings iHomeCmpPageSettings = (IHomeCmpPageSettings) SettingsManager.obtain(IHomeCmpPageSettings.class);
            obj = Result.constructor-impl(iHomeCmpPageSettings != null ? iHomeCmpPageSettings.getEnableCmpPages() : null);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            FLogger.INSTANCE.e(TAG, "obtain cmp page settings failed", th3);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        JsonObject jsonObject = (JsonObject) obj;
        if (jsonObject == null) {
            return false;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            CmpPageSettings cmpPageSettings2 = this;
            jsonElement = jsonObject.get(key);
        } catch (Throwable th4) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th4));
        }
        if (jsonElement != null) {
            JsonElement jsonElement2 = jsonElement.isJsonPrimitive() ? jsonElement : null;
            if (jsonElement2 != null) {
                boolean asBoolean = jsonElement2.getAsBoolean();
                z = true;
                if (asBoolean) {
                    obj2 = Result.constructor-impl(Boolean.valueOf(z));
                    th = Result.exceptionOrNull-impl(obj2);
                    if (th != null) {
                        FLogger.INSTANCE.e(TAG, "parse cmp page settings failed: " + jsonObject, th);
                    }
                    if (Result.isFailure-impl(obj2)) {
                        obj2 = false;
                    }
                    return ((Boolean) obj2).booleanValue();
                }
            }
        }
        z = false;
        obj2 = Result.constructor-impl(Boolean.valueOf(z));
        th = Result.exceptionOrNull-impl(obj2);
        if (th != null) {
        }
        if (Result.isFailure-impl(obj2)) {
        }
        return ((Boolean) obj2).booleanValue();
    }
}
