package com.bytedance.lynx.service.reporter.performance;

import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.eventreport.LynxEventReporter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: LynxMemoryReportTimer.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016BZ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012K\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\u0010\rJ\b\u0010\u0013\u001a\u00020\fH\u0002J\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000RS\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/lynx/service/reporter/performance/LynxMemoryReportTimer;", "", "instanceId", "", "reportBlock", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "reportIntervalSec", "triggerCount", "survivalDurationSec", "", "(ILkotlin/jvm/functions/Function3;)V", "getInstanceId", "()I", "isRunning", "", "maxInterval", "scheduleNextReport", TraeAuthManager.STAGE_START, "stop", "Companion", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxMemoryReportTimer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<Long> reportIntervalSec$delegate = LazyKt.lazy(new Function0<Long>() { // from class: com.bytedance.lynx.service.reporter.performance.LynxMemoryReportTimer$Companion$reportIntervalSec$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m710invoke() {
            return Long.valueOf(LynxEnv.inst().getMemoryReportIntervalSec());
        }
    });
    private final int instanceId;
    private volatile boolean isRunning;
    private final long maxInterval;
    private final Function3<Long, Integer, Long, Unit> reportBlock;
    private long survivalDurationSec;
    private int triggerCount;

    /* JADX WARN: Multi-variable type inference failed */
    public LynxMemoryReportTimer(int i, Function3<? super Long, ? super Integer, ? super Long, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "reportBlock");
        this.instanceId = i;
        this.reportBlock = function3;
        this.maxInterval = 7200L;
    }

    public final int getInstanceId() {
        return this.instanceId;
    }

    private final void scheduleNextReport() {
        if (this.isRunning) {
            final Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = (this.triggerCount + 1) * INSTANCE.getReportIntervalSec();
            long j = longRef.element;
            long j2 = this.maxInterval;
            if (j > j2) {
                longRef.element = j2;
            }
            LynxEventReporter.delayRunOnReportThread(new Runnable() { // from class: com.bytedance.lynx.service.reporter.performance.LynxMemoryReportTimer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LynxMemoryReportTimer.m709scheduleNextReport$lambda0(LynxMemoryReportTimer.this, longRef);
                }
            }, longRef.element * BytePatchException.ErrorCode.paramsError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scheduleNextReport$lambda-0, reason: not valid java name */
    public static final void m709scheduleNextReport$lambda0(LynxMemoryReportTimer lynxMemoryReportTimer, Ref.LongRef longRef) {
        Intrinsics.checkNotNullParameter(lynxMemoryReportTimer, "this$0");
        Intrinsics.checkNotNullParameter(longRef, "$interval");
        if (lynxMemoryReportTimer.isRunning) {
            lynxMemoryReportTimer.survivalDurationSec += longRef.element;
            lynxMemoryReportTimer.triggerCount++;
            lynxMemoryReportTimer.reportBlock.invoke(Long.valueOf(INSTANCE.getReportIntervalSec()), Integer.valueOf(lynxMemoryReportTimer.triggerCount), Long.valueOf(lynxMemoryReportTimer.survivalDurationSec));
            lynxMemoryReportTimer.scheduleNextReport();
        }
    }

    public final void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.triggerCount = 0;
        this.survivalDurationSec = 0L;
        scheduleNextReport();
    }

    public final void stop() {
        this.isRunning = false;
    }

    /* compiled from: LynxMemoryReportTimer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2K\u0010\r\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/lynx/service/reporter/performance/LynxMemoryReportTimer$Companion;", "", "()V", "reportIntervalSec", "", "getReportIntervalSec", "()J", "reportIntervalSec$delegate", "Lkotlin/Lazy;", "startWithInstanceId", "Lcom/bytedance/lynx/service/reporter/performance/LynxMemoryReportTimer;", "instanceId", "", "reportBlock", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "triggerCount", "survivalDurationSec", "", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getReportIntervalSec() {
            return ((Number) LynxMemoryReportTimer.reportIntervalSec$delegate.getValue()).longValue();
        }

        public final LynxMemoryReportTimer startWithInstanceId(int instanceId, Function3<? super Long, ? super Integer, ? super Long, Unit> reportBlock) {
            Intrinsics.checkNotNullParameter(reportBlock, "reportBlock");
            LynxMemoryReportTimer lynxMemoryReportTimer = new LynxMemoryReportTimer(instanceId, reportBlock);
            lynxMemoryReportTimer.start();
            return lynxMemoryReportTimer;
        }
    }
}
