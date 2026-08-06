package com.bytedance.iesgurd.settings;

import android.content.Context;
import com.bytedance.geckox.gson.GsonUtil;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.geckox.settings.model.SettingsLocal;
import com.bytedance.geckox.utils.SPManager;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.pia.core.metrics.ErrorType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalSettingsStoreManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/iesgurd/settings/GlobalSettingsStoreManager;", "", "()V", "context", "Landroid/content/Context;", ErrorType.SETTINGS, "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings;", "getSettings", "()Lcom/bytedance/geckox/settings/model/GlobalConfigSettings;", "settingsLocal", "Lcom/bytedance/geckox/settings/model/SettingsLocal;", "getSettingsLocal", "()Lcom/bytedance/geckox/settings/model/SettingsLocal;", "deleteSettings", "", "putSettings", "configSettings", "putSettingsExtra", "extra", "Lcom/bytedance/iesgurd/settings/SettingsExtra;", "putSettingsLocal", "local", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GlobalSettingsStoreManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String GECKO_SETTINGS = "gecko_settings";
    public static final String GECKO_SETTINGS_EXTRA = "gecko_settings_extra";
    public static final String GECKO_SETTINGS_LOCAL = "gecko_settings_local";
    private Context context = GlobalManager.INSTANCE.getContext();

    public final void putSettings(GlobalConfigSettings configSettings) {
        Intrinsics.checkParameterIsNotNull(configSettings, "configSettings");
        GeckoLogger.d("settings cache stored");
        SPManager.inst().putString(this.context, GECKO_SETTINGS, GsonUtil.Companion.inst().gson().toJson(configSettings));
    }

    public final void putSettingsLocal(SettingsLocal local) {
        Intrinsics.checkParameterIsNotNull(local, "local");
        GeckoLogger.d("settings local cache stored: " + local.getAppVersion());
        SPManager.inst().putString(this.context, GECKO_SETTINGS_LOCAL, GsonUtil.Companion.inst().gson().toJson(local));
    }

    public final GlobalConfigSettings getSettings() {
        String string = SPManager.inst().getString(this.context, GECKO_SETTINGS, (String) null);
        if (string == null) {
            return null;
        }
        try {
            return (GlobalConfigSettings) GsonUtil.Companion.inst().gson().fromJson(string, GlobalConfigSettings.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final SettingsLocal getSettingsLocal() {
        String string = SPManager.inst().getString(this.context, GECKO_SETTINGS_LOCAL, (String) null);
        if (string == null) {
            return null;
        }
        try {
            return (SettingsLocal) GsonUtil.Companion.inst().gson().fromJson(string, SettingsLocal.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void putSettingsExtra(SettingsExtra extra) {
        GeckoLogger.d("settings extra cache stored");
        if (extra == null) {
            return;
        }
        SPManager.inst().putString(this.context, GECKO_SETTINGS_EXTRA, GsonUtil.Companion.inst().gson().toJson(extra));
    }

    public final void deleteSettings() {
        GeckoLogger.d("settings cache deleted");
        SPManager.inst().delete(this.context, GECKO_SETTINGS);
    }

    /* compiled from: GlobalSettingsStoreManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/iesgurd/settings/GlobalSettingsStoreManager$Companion;", "", "()V", "GECKO_SETTINGS", "", "GECKO_SETTINGS_EXTRA", "GECKO_SETTINGS_LOCAL", "settingsExtra", "Lcom/bytedance/iesgurd/settings/SettingsExtra;", "getSettingsExtra", "()Lcom/bytedance/iesgurd/settings/SettingsExtra;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SettingsExtra getSettingsExtra() {
            String string;
            Context context = GlobalManager.INSTANCE.getContext();
            if (context == null || (string = SPManager.inst().getString(context, GlobalSettingsStoreManager.GECKO_SETTINGS_EXTRA, (String) null)) == null) {
                return null;
            }
            try {
                return (SettingsExtra) GsonUtil.Companion.inst().gson().fromJson(string, SettingsExtra.class);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
