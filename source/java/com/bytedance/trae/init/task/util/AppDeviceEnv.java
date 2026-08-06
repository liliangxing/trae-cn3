package com.bytedance.trae.init.task.util;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.system.Os;
import android.system.OsConstants;
import com.bytedance.apm.ApmContext;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.init.LaunchBoostExecutor;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* compiled from: AppDeviceEnv.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/init/task/util/AppDeviceEnv;", "", "<init>", "()V", "TAG", "", "UNKNOWN", "UNKNOWN_PAGE_SIZE", "", "EVENT", "KEY_BUILD_ABI", "KEY_CPU_PRIMARY_ABI", "KEY_MEMORY_PAGE_SIZE", "buildAbi", "getBuildAbi", "()Ljava/lang/String;", "buildAbi$delegate", "Lkotlin/Lazy;", "cpuPrimaryAbi", "getCpuPrimaryAbi", "cpuPrimaryAbi$delegate", "memoryPageSize", "getMemoryPageSize", "()J", "memoryPageSize$delegate", "report", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppDeviceEnv {
    private static final String EVENT = "flow_app_device_env";
    private static final String KEY_BUILD_ABI = "build_abi";
    private static final String KEY_CPU_PRIMARY_ABI = "cpu_primary_abi";
    private static final String KEY_MEMORY_PAGE_SIZE = "memory_page_size";
    private static final String TAG = "AppDeviceEnv";
    private static final String UNKNOWN = "unknown";
    private static final long UNKNOWN_PAGE_SIZE = -1;
    public static final AppDeviceEnv INSTANCE = new AppDeviceEnv();

    /* renamed from: buildAbi$delegate, reason: from kotlin metadata */
    private static final Lazy buildAbi = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.init.task.util.AppDeviceEnv$$ExternalSyntheticLambda0
        public final Object invoke() {
            String buildAbi_delegate$lambda$0;
            buildAbi_delegate$lambda$0 = AppDeviceEnv.buildAbi_delegate$lambda$0();
            return buildAbi_delegate$lambda$0;
        }
    });

    /* renamed from: cpuPrimaryAbi$delegate, reason: from kotlin metadata */
    private static final Lazy cpuPrimaryAbi = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.init.task.util.AppDeviceEnv$$ExternalSyntheticLambda1
        public final Object invoke() {
            String cpuPrimaryAbi_delegate$lambda$1;
            cpuPrimaryAbi_delegate$lambda$1 = AppDeviceEnv.cpuPrimaryAbi_delegate$lambda$1();
            return cpuPrimaryAbi_delegate$lambda$1;
        }
    });

    /* renamed from: memoryPageSize$delegate, reason: from kotlin metadata */
    private static final Lazy memoryPageSize = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.init.task.util.AppDeviceEnv$$ExternalSyntheticLambda2
        public final Object invoke() {
            long memoryPageSize_delegate$lambda$2;
            memoryPageSize_delegate$lambda$2 = AppDeviceEnv.memoryPageSize_delegate$lambda$2();
            return Long.valueOf(memoryPageSize_delegate$lambda$2);
        }
    });
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final String buildAbi_delegate$lambda$0() {
        return "";
    }

    private AppDeviceEnv() {
    }

    private final String getBuildAbi() {
        return (String) buildAbi.getValue();
    }

    private final String getCpuPrimaryAbi() {
        return (String) cpuPrimaryAbi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
    
        if (r2 == false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0016 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:3:0x0002, B:5:0x0008, B:12:0x0016, B:14:0x001d), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String cpuPrimaryAbi_delegate$lambda$1() {
        String str;
        String[] strArr;
        boolean z;
        boolean z2;
        try {
            strArr = Build.SUPPORTED_ABIS;
            z = true;
        } catch (Throwable th) {
            FLogger.INSTANCE.e(TAG, "get cpu primary abi failed: " + th.getMessage());
        }
        if (strArr != null) {
            if (!(strArr.length == 0)) {
                z2 = false;
                if (!z2) {
                    str = strArr[0];
                    String str2 = str;
                    if (str2 != null) {
                        if (str2.length() != 0) {
                            z = false;
                        }
                    }
                }
                str = "unknown";
                FLogger.INSTANCE.d(TAG, "report cpu primary abi: " + str);
                return str;
            }
        }
        z2 = true;
        if (!z2) {
        }
        str = "unknown";
        FLogger.INSTANCE.d(TAG, "report cpu primary abi: " + str);
        return str;
    }

    private final long getMemoryPageSize() {
        return ((Number) memoryPageSize.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long memoryPageSize_delegate$lambda$2() {
        try {
            return Os.sysconf(OsConstants._SC_PAGESIZE);
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public final void report() {
        if (ApmContext.isMainProcessSimple()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.trae.init.task.util.AppDeviceEnv$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    AppDeviceEnv.report$lambda$5();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void report$lambda$5() {
        LaunchBoostExecutor.INSTANCE.executors$app_mainlandRelease().submit(new Runnable() { // from class: com.bytedance.trae.init.task.util.AppDeviceEnv$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AppDeviceEnv.report$lambda$5$lambda$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void report$lambda$5$lambda$4() {
        IApplog.Companion companion = IApplog.INSTANCE;
        JSONObject jSONObject = new JSONObject();
        AppDeviceEnv appDeviceEnv = INSTANCE;
        jSONObject.put(KEY_BUILD_ABI, appDeviceEnv.getBuildAbi());
        jSONObject.put(KEY_CPU_PRIMARY_ABI, appDeviceEnv.getCpuPrimaryAbi());
        jSONObject.put(KEY_MEMORY_PAGE_SIZE, appDeviceEnv.getMemoryPageSize());
        Unit unit = Unit.INSTANCE;
        companion.reportEvent(EVENT, jSONObject);
    }
}
