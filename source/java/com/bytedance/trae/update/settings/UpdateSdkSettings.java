package com.bytedance.trae.update.settings;

import com.bytedance.news.common.settings.SettingsManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: UpdateSdkSettings.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0010R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/update/settings/UpdateSdkSettings;", "", "<init>", "()V", "updateSettings", "Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;", "getUpdateSettings", "()Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;", "updateSettings$delegate", "Lkotlin/Lazy;", "getUpdateFormalConfig", "Lcom/google/gson/JsonObject;", "getDialogShowInterval", "", "defValue", "getSdkUpdateEnable", "", "getManualUpdateEnable", "bits-impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UpdateSdkSettings {
    public static final UpdateSdkSettings INSTANCE = new UpdateSdkSettings();

    /* renamed from: updateSettings$delegate, reason: from kotlin metadata */
    private static final Lazy updateSettings = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.update.settings.UpdateSdkSettings$$ExternalSyntheticLambda0
        public final Object invoke() {
            IUpdateSdkSettings updateSettings_delegate$lambda$0;
            updateSettings_delegate$lambda$0 = UpdateSdkSettings.updateSettings_delegate$lambda$0();
            return updateSettings_delegate$lambda$0;
        }
    });

    private UpdateSdkSettings() {
    }

    private final IUpdateSdkSettings getUpdateSettings() {
        return (IUpdateSdkSettings) updateSettings.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IUpdateSdkSettings updateSettings_delegate$lambda$0() {
        try {
            return (IUpdateSdkSettings) SettingsManager.obtain(IUpdateSdkSettings.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public final JsonObject getUpdateFormalConfig() {
        IUpdateSdkSettings updateSettings2 = getUpdateSettings();
        JsonObject updateSdkConfig = updateSettings2 != null ? updateSettings2.getUpdateSdkConfig() : null;
        if (updateSdkConfig != null) {
            return updateSdkConfig.getAsJsonObject("formal_update_config");
        }
        return null;
    }

    public final long getDialogShowInterval(long defValue) {
        JsonElement jsonElement;
        JsonPrimitive asJsonPrimitive;
        IUpdateSdkSettings updateSettings2 = getUpdateSettings();
        JsonObject updateSdkConfig = updateSettings2 != null ? updateSettings2.getUpdateSdkConfig() : null;
        return (updateSdkConfig == null || (jsonElement = updateSdkConfig.get("dialog_show_interval")) == null || (asJsonPrimitive = jsonElement.getAsJsonPrimitive()) == null) ? defValue : asJsonPrimitive.getAsLong();
    }

    public final boolean getSdkUpdateEnable(boolean defValue) {
        JsonElement jsonElement;
        JsonPrimitive asJsonPrimitive;
        IUpdateSdkSettings updateSettings2 = getUpdateSettings();
        JsonObject updateSdkConfig = updateSettings2 != null ? updateSettings2.getUpdateSdkConfig() : null;
        return (updateSdkConfig == null || (jsonElement = updateSdkConfig.get("sdk_update_enable")) == null || (asJsonPrimitive = jsonElement.getAsJsonPrimitive()) == null) ? defValue : asJsonPrimitive.getAsBoolean();
    }

    public final boolean getManualUpdateEnable(boolean defValue) {
        JsonElement jsonElement;
        JsonPrimitive asJsonPrimitive;
        IUpdateSdkSettings updateSettings2 = getUpdateSettings();
        JsonObject updateSdkConfig = updateSettings2 != null ? updateSettings2.getUpdateSdkConfig() : null;
        return (updateSdkConfig == null || (jsonElement = updateSdkConfig.get("manual_update_enable")) == null || (asJsonPrimitive = jsonElement.getAsJsonPrimitive()) == null) ? defValue : asJsonPrimitive.getAsBoolean();
    }
}
