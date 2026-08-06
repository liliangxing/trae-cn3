package com.bytedance.trae.network.util;

import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: SpringNetwokStrategyManager.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000eJ\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;", "", "<init>", "()V", "TAG", "", "MIN_DURATION_MILLIS", "", "MAX_DURATION_MILLIS", "FEED_SHOW_TIMEOUT_MS", "isEnabled", "", "durationMillis", "currentStrategy", "Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "countdownJob", "Lkotlinx/coroutines/Job;", "hasStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasStopped", "isStrategyEnabled", "", "enable", "runDuration", "startAppState", "strategy", "stopAppState", "safeResetToDefaultState", "executeStartTNC", "sceneName", "cancelCurrentJob", ISignalReportConstants.KEY_REASON, "SpringNetworkStrategy", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SpringNetworkStrategyManager {
    private static final long FEED_SHOW_TIMEOUT_MS = 30000;
    private static final long MIN_DURATION_MILLIS = -1;
    private static final String TAG = "SpringNetStrategy";
    private static Job countdownJob;
    private static SpringNetworkStrategy currentStrategy;
    private static boolean isEnabled;
    public static final SpringNetworkStrategyManager INSTANCE = new SpringNetworkStrategyManager();
    private static final long MAX_DURATION_MILLIS = TimeUnit.MINUTES.toMillis(5);
    private static long durationMillis = -1;
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    private static final AtomicBoolean hasStarted = new AtomicBoolean(false);
    private static final AtomicBoolean hasStopped = new AtomicBoolean(false);

    /* compiled from: SpringNetwokStrategyManager.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpringNetworkStrategy.values().length];
            try {
                iArr[SpringNetworkStrategy.CUSTOMER_SECOND_STRATEGY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SpringNetworkStrategyManager() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SpringNetwokStrategyManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;", "", "sceneName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSceneName", "()Ljava/lang/String;", "CUSTOMER_SECOND_STRATEGY", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class SpringNetworkStrategy {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SpringNetworkStrategy[] $VALUES;
        public static final SpringNetworkStrategy CUSTOMER_SECOND_STRATEGY = new SpringNetworkStrategy("CUSTOMER_SECOND_STRATEGY", 0, "delay_customer_second_strategy");
        private final String sceneName;

        private static final /* synthetic */ SpringNetworkStrategy[] $values() {
            return new SpringNetworkStrategy[]{CUSTOMER_SECOND_STRATEGY};
        }

        public static EnumEntries<SpringNetworkStrategy> getEntries() {
            return $ENTRIES;
        }

        private SpringNetworkStrategy(String str, int i, String str2) {
            this.sceneName = str2;
        }

        public final String getSceneName() {
            return this.sceneName;
        }

        static {
            SpringNetworkStrategy[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static SpringNetworkStrategy valueOf(String str) {
            return (SpringNetworkStrategy) Enum.valueOf(SpringNetworkStrategy.class, str);
        }

        public static SpringNetworkStrategy[] values() {
            return (SpringNetworkStrategy[]) $VALUES.clone();
        }
    }

    public final synchronized void isStrategyEnabled(boolean enable, long runDuration) {
        isEnabled = enable;
        durationMillis = RangesKt.coerceIn(runDuration, -1L, MAX_DURATION_MILLIS);
        TTNetInit.setStateDelayNewStrategyEnabled(enable);
    }

    public final synchronized void startAppState(SpringNetworkStrategy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        if (isEnabled) {
            if (!(strategy.getSceneName().length() == 0)) {
                if (hasStarted.compareAndSet(false, true)) {
                    cancelCurrentJob("Starting new strategy: " + strategy.getSceneName());
                    currentStrategy = strategy;
                    long j = durationMillis;
                    executeStartTNC(strategy.getSceneName());
                    countdownJob = BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new SpringNetworkStrategyManager$startAppState$1(j, strategy, null), 3, (Object) null);
                }
            }
        }
    }

    public final synchronized void stopAppState(SpringNetworkStrategy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        if (isEnabled) {
            if (WhenMappings.$EnumSwitchMapping$0[strategy.ordinal()] != 1) {
                throw new NoWhenBranchMatchedException();
            }
            if (currentStrategy == strategy) {
                cancelCurrentJob("Stop called manually (Immediate Reset)");
                BuildersKt.launch$default(scope, Dispatchers.getIO(), (CoroutineStart) null, new SpringNetworkStrategyManager$stopAppState$1(null), 2, (Object) null);
                currentStrategy = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void safeResetToDefaultState() {
        if (hasStopped.compareAndSet(false, true)) {
            try {
                TTHttpCallPriorityControl.getInstance().resetToDefaultState();
            } catch (Exception unused) {
            }
        }
    }

    private final void executeStartTNC(String sceneName) {
        try {
            TTHttpCallPriorityControl.getInstance().startAppStateFromTNC(sceneName);
        } catch (Exception unused) {
        }
    }

    private final void cancelCurrentJob(String reason) {
        Job job;
        Job job2 = countdownJob;
        boolean z = false;
        if (job2 != null && job2.isActive()) {
            z = true;
        }
        if (z && (job = countdownJob) != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        countdownJob = null;
    }
}
