package com.bytedance.iesgurd.request;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.task.HandlerTask;
import com.bytedance.geckox.task.HandlerTimerTaskManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RetryRequestPolicy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/iesgurd/request/RetryRequestPolicy;", "Lcom/bytedance/iesgurd/request/RequestPolicy;", "isRetry", "", "mEnableRetry", "mChannelSortedStr", "", "request", "Lcom/bytedance/iesgurd/request/UpdateRequest;", "(ZZLjava/lang/String;Lcom/bytedance/iesgurd/request/UpdateRequest;)V", "isRetryRequest", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mRequest", "prepareRequest", "", "requestFail", "requestSuccess", "Companion", "RetryTimerTask", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RetryRequestPolicy implements RequestPolicy {
    private static final int GLOBAL_REQUEST_FAIL_INTERVAL = 1800000;
    private final AtomicBoolean isRetryRequest;
    private final String mChannelSortedStr;
    private final boolean mEnableRetry;
    private UpdateRequest mRequest;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int CHECK_UPDATE_RETRY_DELAY = 60000;
    private static final ConcurrentHashMap<String, Long> pendingRetryRequest = new ConcurrentHashMap<>();
    private static final AtomicLong lastFailTime = new AtomicLong(System.currentTimeMillis());

    @Override // com.bytedance.iesgurd.request.RequestPolicy
    public void requestSuccess() {
    }

    public RetryRequestPolicy(boolean z, boolean z2, String str, UpdateRequest updateRequest) {
        Intrinsics.checkParameterIsNotNull(str, "mChannelSortedStr");
        this.mEnableRetry = z2;
        this.mChannelSortedStr = str;
        this.isRetryRequest = new AtomicBoolean(z);
        this.mRequest = updateRequest;
    }

    @Override // com.bytedance.iesgurd.request.RequestPolicy
    public void prepareRequest() throws Exception {
        if (!this.isRetryRequest.get()) {
            try {
                Result.Companion companion = Result.Companion;
                Result.constructor-impl(pendingRetryRequest.remove(this.mChannelSortedStr));
                return;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                return;
            }
        }
        if (this.isRetryRequest.get()) {
            pendingRetryRequest.remove(this.mChannelSortedStr);
        }
    }

    @Override // com.bytedance.iesgurd.request.RequestPolicy
    public void requestFail() {
        if (!this.isRetryRequest.get() && this.mEnableRetry && System.currentTimeMillis() - lastFailTime.get() <= 1800000) {
            RetryTimerTask retryTimerTask = new RetryTimerTask();
            long currentTimeMillis = System.currentTimeMillis();
            retryTimerTask.data = Long.valueOf(currentTimeMillis);
            HandlerTimerTaskManager.inst().schedule(retryTimerTask, CHECK_UPDATE_RETRY_DELAY);
            pendingRetryRequest.put(this.mChannelSortedStr, Long.valueOf(currentTimeMillis));
            GeckoLogger.d(this.mChannelSortedStr + "gecko update request retry hit");
            return;
        }
        if (this.isRetryRequest.get()) {
            lastFailTime.set(System.currentTimeMillis());
        }
    }

    /* compiled from: RetryRequestPolicy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/iesgurd/request/RetryRequestPolicy$RetryTimerTask;", "Lcom/bytedance/geckox/task/HandlerTask;", "", "(Lcom/bytedance/iesgurd/request/RetryRequestPolicy;)V", "execute", "", "taskType", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private final class RetryTimerTask extends HandlerTask<Long> {
        public int taskType() {
            return 1;
        }

        public RetryTimerTask() {
        }

        public void execute() {
            UpdateRequest updateRequest;
            Object obj = this.data;
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            if (RetryRequestPolicy.pendingRetryRequest.contains(Long.valueOf(((Number) obj).longValue())) && (updateRequest = RetryRequestPolicy.this.mRequest) != null) {
                updateRequest.reStart();
            }
        }
    }

    /* compiled from: RetryRequestPolicy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/iesgurd/request/RetryRequestPolicy$Companion;", "", "()V", "CHECK_UPDATE_RETRY_DELAY", "", "getCHECK_UPDATE_RETRY_DELAY", "()I", "setCHECK_UPDATE_RETRY_DELAY", "(I)V", "GLOBAL_REQUEST_FAIL_INTERVAL", "lastFailTime", "Ljava/util/concurrent/atomic/AtomicLong;", "pendingRetryRequest", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "resetForTest", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getCHECK_UPDATE_RETRY_DELAY() {
            return RetryRequestPolicy.CHECK_UPDATE_RETRY_DELAY;
        }

        public final void setCHECK_UPDATE_RETRY_DELAY(int i) {
            RetryRequestPolicy.CHECK_UPDATE_RETRY_DELAY = i;
        }

        public final void resetForTest() {
            HandlerTimerTaskManager.inst().cancel(1);
        }
    }
}
