package com.bytedance.trae.home.privacy;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.keva.Keva;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.AppUtils;
import java.io.File;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: PrivacyManager.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u0011J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0015J\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/trae/home/privacy/PrivacyManager;", "", "<init>", "()V", "TAG", "", "FLAG_FILE_NAME", "KEVA_REPO_NAME", "KEVA_MARK", "currentProcessName", "mainProcessName", "privacyProcessName", "flagFile", "Ljava/io/File;", "keva", "Lcom/bytedance/keva/Keva;", "isPrivacyProcess", "", "init", "", TraceStatsConsts.STATS_BASE_MODULE, "Landroid/content/Context;", "notifyAgree", "result", "notifyStartEventDelay", "checkAgreed", "markAgreed", "updateIsFirstStartMark", "value", "isFirstInstallStarting", "exitProcess", "reason", "registerReceiver", "context", "sendKillMySelfBroadcast", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PrivacyManager {
    private static final String FLAG_FILE_NAME = "privacy_agreed";
    private static final String KEVA_MARK = "first_start";
    private static final String KEVA_REPO_NAME = "trae_privacy";
    public static final String TAG = "PrivacyManager";
    private static String currentProcessName;
    private static File flagFile;
    private static Keva keva;
    private static String mainProcessName;
    private static String privacyProcessName;
    public static final PrivacyManager INSTANCE = new PrivacyManager();
    public static final int $stable = 8;

    private PrivacyManager() {
    }

    public final boolean isPrivacyProcess() {
        String str = currentProcessName;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentProcessName");
            str = null;
        }
        String str3 = privacyProcessName;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyProcessName");
        } else {
            str2 = str3;
        }
        return Intrinsics.areEqual(str, str2);
    }

    public final void init(final Context base) {
        Intrinsics.checkNotNullParameter(base, "base");
        String currentProcessName2 = AppUtils.getCurrentProcessName();
        Intrinsics.checkNotNullExpressionValue(currentProcessName2, "getCurrentProcessName(...)");
        currentProcessName = currentProcessName2;
        StringBuilder sb = new StringBuilder();
        String str = currentProcessName;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentProcessName");
            str = null;
        }
        Log.i(TAG, sb.append(str).append(" init").toString());
        String packageName = base.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        mainProcessName = packageName;
        privacyProcessName = base.getPackageName() + ":privacy";
        flagFile = new File(base.getFilesDir(), FLAG_FILE_NAME);
        Keva repo = Keva.getRepo(KEVA_REPO_NAME);
        Intrinsics.checkNotNullExpressionValue(repo, "getRepo(...)");
        keva = repo;
        String str3 = currentProcessName;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentProcessName");
            str3 = null;
        }
        String str4 = privacyProcessName;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyProcessName");
        } else {
            str2 = str4;
        }
        if (Intrinsics.areEqual(str3, str2)) {
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.bytedance.trae.home.privacy.PrivacyManager$$ExternalSyntheticLambda0
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread, Throwable th) {
                    PrivacyManager.init$lambda$0(base, thread, th);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(Context context, Thread thread, Throwable th) {
        PrivacyManager privacyManager = INSTANCE;
        privacyManager.sendKillMySelfBroadcast(context);
        privacyManager.exitProcess("Uncaught exception e: " + th.getMessage());
    }

    public final void notifyAgree(boolean result) {
        Log.i(TAG, "click and Notify notifyAgreeResult = [" + result + AbstractJsonLexerKt.END_LIST);
        if (result) {
            markAgreed();
        }
    }

    public final boolean notifyStartEventDelay() {
        return !checkAgreed();
    }

    public final boolean checkAgreed() {
        if (AppHost.INSTANCE.getSupportCloudTest()) {
            return true;
        }
        File file = flagFile;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flagFile");
            file = null;
        }
        return file.exists();
    }

    private final void markAgreed() {
        File file = flagFile;
        File file2 = null;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flagFile");
            file = null;
        }
        if (file.exists()) {
            return;
        }
        File file3 = flagFile;
        if (file3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flagFile");
        } else {
            file2 = file3;
        }
        file2.createNewFile();
    }

    public final void updateIsFirstStartMark(boolean value) {
        if (checkAgreed()) {
            Keva keva2 = keva;
            if (keva2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keva");
                keva2 = null;
            }
            keva2.storeBoolean(KEVA_MARK, value);
        }
    }

    public final boolean isFirstInstallStarting() {
        Keva keva2 = keva;
        if (keva2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keva");
            keva2 = null;
        }
        return keva2.getBoolean(KEVA_MARK, false);
    }

    public final void exitProcess(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        StringBuilder sb = new StringBuilder();
        String str = currentProcessName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentProcessName");
            str = null;
        }
        Log.e(TAG, sb.append(str).append(" exitProcess reason[").append(reason).append(AbstractJsonLexerKt.END_LIST).toString());
        Process.killProcess(Process.myPid());
    }

    public final void registerReceiver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        KillMySelfBroadcastReceiver.INSTANCE.registerReceiver(context);
    }

    public final void sendKillMySelfBroadcast(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        KillMySelfBroadcastReceiver.INSTANCE.sendBroadcast(context);
    }
}
