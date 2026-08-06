package com.bytedance.trae.init.task;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.keva.KevaRepos;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: BytecloudTokenValidator.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0003\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/trae/init/task/BytecloudTokenValidator;", "", "<init>", "()V", "TAG", "", "ERROR_CODE_REAUTH_REQUIRED", "HTTP_UNAUTHORIZED", "", "ONE_DAY_MS", "", "KEY_LAST_CHECK_AT", "UNAUTHORIZED_THROTTLE_MS", "scope", "Lkotlinx/coroutines/CoroutineScope;", "lastUnauthorizedNotifyAt", "Ljava/util/concurrent/atomic/AtomicLong;", "validating", "Ljava/util/concurrent/atomic/AtomicBoolean;", "validateOnColdLaunch", "", "validateOnForegroundIfNeeded", "shouldValidate", "", "doValidate", "handleUnauthorizedSession", "message", "getLastCheckAt", "saveLastCheckAt", ReportConstant.COMMON_TIMESTAMP, "extractHttpStatusCode", "e", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BytecloudTokenValidator {
    private static final String ERROR_CODE_REAUTH_REQUIRED = "20330";
    private static final int HTTP_UNAUTHORIZED = 401;
    private static final String KEY_LAST_CHECK_AT = "bytecloud_token_last_check_at";
    private static final long ONE_DAY_MS = 86400000;
    private static final String TAG = "BytecloudTokenValidator";
    private static final long UNAUTHORIZED_THROTTLE_MS = 2000;
    public static final BytecloudTokenValidator INSTANCE = new BytecloudTokenValidator();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    private static final AtomicLong lastUnauthorizedNotifyAt = new AtomicLong(0);
    private static final AtomicBoolean validating = new AtomicBoolean(false);
    public static final int $stable = 8;

    private BytecloudTokenValidator() {
    }

    public final void validateOnColdLaunch() {
        if (shouldValidate()) {
            doValidate();
        }
    }

    public final void validateOnForegroundIfNeeded() {
        if (shouldValidate()) {
            long lastCheckAt = getLastCheckAt();
            long currentTimeMillis = System.currentTimeMillis();
            if (lastCheckAt > 0) {
                long j = currentTimeMillis - lastCheckAt;
                if (j < 86400000) {
                    FLogger.INSTANCE.i(TAG, "validateOnForeground: skip, last check " + (j / 1000) + "s ago");
                    return;
                }
            }
            doValidate();
        }
    }

    private final boolean shouldValidate() {
        if (AppHost.INSTANCE.isOversea()) {
            return false;
        }
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return (iLoginService != null && iLoginService.isTraeLoggedIn()) && BytecloudAuthManager.INSTANCE.isBytecloudLogin();
    }

    private final void doValidate() {
        if (!validating.compareAndSet(false, true)) {
            FLogger.INSTANCE.i(TAG, "doValidate: already in-flight, skip");
        } else {
            BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new BytecloudTokenValidator$doValidate$1(null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUnauthorizedSession(String message) {
        if (shouldValidate()) {
            long currentTimeMillis = System.currentTimeMillis();
            AtomicLong atomicLong = lastUnauthorizedNotifyAt;
            long j = atomicLong.get();
            if (currentTimeMillis - j >= 2000 && atomicLong.compareAndSet(j, currentTimeMillis)) {
                FLogger.INSTANCE.w(TAG, "handleUnauthorizedSession: bytecloud token invalid, forcing logout, msg=" + message);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.trae.init.task.BytecloudTokenValidator$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        BytecloudTokenValidator.handleUnauthorizedSession$lambda$0();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleUnauthorizedSession$lambda$0() {
        CustomToast.showLong(AppHost.INSTANCE.getApplication(), 2131690880);
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService != null) {
            iLoginService.logout(true, (IAccountCallback) null, "bytecloud_rt_expired");
        }
    }

    private final long getLastCheckAt() {
        return KevaRepos.INSTANCE.getDefaultRepo().getLong(KEY_LAST_CHECK_AT, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveLastCheckAt(long timestamp) {
        KevaRepos.INSTANCE.getDefaultRepo().storeLong(KEY_LAST_CHECK_AT, timestamp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int extractHttpStatusCode(Throwable e) {
        while (e != null) {
            if (e instanceof CronetIOException) {
                return ((CronetIOException) e).getStatusCode();
            }
            if (e instanceof HttpResponseException) {
                return ((HttpResponseException) e).getStatusCode();
            }
            e = e.getCause();
        }
        return -1;
    }
}
