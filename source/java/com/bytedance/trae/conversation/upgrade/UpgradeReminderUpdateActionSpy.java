package com.bytedance.trae.conversation.upgrade;

import android.os.Bundle;
import com.bytedance.trae.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* compiled from: UpgradeReminderUpdateActionSpy.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\fH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUpdateActionSpy;", "", "<init>", "()V", "INSTRUMENTATION_CLASS", "", "BACKEND_MODE_ARGUMENT", "RUN_ID_ARGUMENT", "E2E_PREF", "KEY_UPDATE_CALLED", "KEY_UPDATE_AUTO_CHECK", "record", "", "autoCheck", "isE2ERunnerInstrumentationRun", "instrumentationArgumentsOrNull", "Landroid/os/Bundle;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UpgradeReminderUpdateActionSpy {
    private static final String BACKEND_MODE_ARGUMENT = "backendMode";
    private static final String E2E_PREF = "upgrade_reminder_e2e";
    public static final UpgradeReminderUpdateActionSpy INSTANCE = new UpgradeReminderUpdateActionSpy();
    private static final String INSTRUMENTATION_CLASS = "androidx.test.platform.app.InstrumentationRegistry";
    private static final String KEY_UPDATE_AUTO_CHECK = "update_auto_check";
    private static final String KEY_UPDATE_CALLED = "update_called";
    private static final String RUN_ID_ARGUMENT = "runId";

    private UpgradeReminderUpdateActionSpy() {
    }

    public final boolean record(boolean autoCheck) {
        if (!AppHost.INSTANCE.isDebug() || !isE2ERunnerInstrumentationRun()) {
            return false;
        }
        AppHost.INSTANCE.getApplication().getSharedPreferences(E2E_PREF, 0).edit().putBoolean(KEY_UPDATE_CALLED, true).putBoolean(KEY_UPDATE_AUTO_CHECK, autoCheck).apply();
        return true;
    }

    private final boolean isE2ERunnerInstrumentationRun() {
        Bundle instrumentationArgumentsOrNull = instrumentationArgumentsOrNull();
        if (instrumentationArgumentsOrNull == null) {
            return false;
        }
        String string = instrumentationArgumentsOrNull.getString(BACKEND_MODE_ARGUMENT);
        if (string == null || StringsKt.isBlank(string)) {
            return false;
        }
        String string2 = instrumentationArgumentsOrNull.getString(RUN_ID_ARGUMENT);
        return !(string2 == null || StringsKt.isBlank(string2));
    }

    private final Bundle instrumentationArgumentsOrNull() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            UpgradeReminderUpdateActionSpy upgradeReminderUpdateActionSpy = this;
            Object invoke = Class.forName(INSTRUMENTATION_CLASS).getMethod("getArguments", new Class[0]).invoke(null, new Object[0]);
            obj = Result.constructor-impl(invoke instanceof Bundle ? (Bundle) invoke : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Bundle) (Result.isFailure-impl(obj) ? null : obj);
    }
}
