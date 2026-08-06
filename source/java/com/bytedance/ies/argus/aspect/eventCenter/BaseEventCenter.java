package com.bytedance.ies.argus.aspect.eventCenter;

import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.ies.argus.api.interfaces.service.IArgusWebSecureService;
import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.base.ArgusMonitor;
import com.bytedance.ies.argus.base.ArgusReportPlatform;
import com.bytedance.ies.argus.base.ArgusServiceManager;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusMonitorKeyName;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.IArgusAspect;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: BaseEventCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 (2\u00020\u0001:\u0002()B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\rJG\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001e0\u001c\"\u000e\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u001e0\u001f\"\n\b\u0001\u0010\u001e*\u0004\u0018\u00010 2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010!\u001a\u0002H\u001dH\u0000¢\u0006\u0004\b\"\u0010#J0\u0010$\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00122\u000e\b\u0004\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00170'H\u0086\bø\u0001\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0014\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter;", "", "depend", "Lcom/bytedance/ies/argus/aspect/eventCenter/IEventCenterDepend;", "(Lcom/bytedance/ies/argus/aspect/eventCenter/IEventCenterDepend;)V", "aspectAsyncScope", "Lkotlinx/coroutines/CoroutineScope;", "getAspectAsyncScope", "()Lkotlinx/coroutines/CoroutineScope;", "aspectAsyncScope$delegate", "Lkotlin/Lazy;", "awaitEventJobs", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ies/argus/bean/IArgusAspect;", "Lkotlinx/coroutines/Deferred;", "getDepend", "()Lcom/bytedance/ies/argus/aspect/eventCenter/IEventCenterDepend;", "finishEvent", "", "reportScope", "getReportScope", "reportScope$delegate", "awaitEvent", "", "aspect", "destroy", "hasTriggerEvent", "initContext", "Lcom/bytedance/ies/argus/bean/AspectContext;", "PARAMS", "REWRITE_PAYLOAD", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "params", "initContext$anniex_release", "(Lcom/bytedance/ies/argus/bean/IArgusAspect;Lcom/bytedance/ies/argus/api/params/BaseAspectParams;)Lcom/bytedance/ies/argus/bean/AspectContext;", "triggerAsyncEvent", "saveEvent", "block", "Lkotlin/Function0;", "Companion", "VerifyHandler", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class BaseEventCenter {
    public static final String TAG = "BaseEventCenter";

    /* renamed from: aspectAsyncScope$delegate, reason: from kotlin metadata */
    private final Lazy aspectAsyncScope;
    private final ConcurrentHashMap<IArgusAspect, Deferred<?>> awaitEventJobs;
    private final IEventCenterDepend depend;
    private final ConcurrentHashMap<IArgusAspect, Boolean> finishEvent;

    /* renamed from: reportScope$delegate, reason: from kotlin metadata */
    private final Lazy reportScope;

    public BaseEventCenter(IEventCenterDepend iEventCenterDepend) {
        Intrinsics.checkNotNullParameter(iEventCenterDepend, "depend");
        this.depend = iEventCenterDepend;
        this.aspectAsyncScope = LazyKt.lazy(new Function0<CoroutineScope>() { // from class: com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter$aspectAsyncScope$2
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
            }
        });
        this.reportScope = LazyKt.lazy(new Function0<CoroutineScope>() { // from class: com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter$reportScope$2
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
            }
        });
        this.awaitEventJobs = new ConcurrentHashMap<>();
        this.finishEvent = new ConcurrentHashMap<>();
    }

    public final IEventCenterDepend getDepend() {
        return this.depend;
    }

    public final CoroutineScope getAspectAsyncScope() {
        return (CoroutineScope) this.aspectAsyncScope.getValue();
    }

    public final CoroutineScope getReportScope() {
        return (CoroutineScope) this.reportScope.getValue();
    }

    public final boolean hasTriggerEvent(IArgusAspect aspect) {
        Intrinsics.checkNotNullParameter(aspect, "aspect");
        return Intrinsics.areEqual(this.finishEvent.get(aspect), true) || this.awaitEventJobs.get(aspect) != null;
    }

    public final void awaitEvent(IArgusAspect aspect) {
        Intrinsics.checkNotNullParameter(aspect, "aspect");
        Deferred<?> deferred = this.awaitEventJobs.get(aspect);
        if (deferred == null || !CommonUtils.INSTANCE.safelyAwait(deferred)) {
            return;
        }
        ArgusLog.i$default(ArgusLog.INSTANCE, TAG, aspect + " await time out, give up execute", null, 4, null);
        ArgusMonitor argusMonitor = ArgusMonitor.INSTANCE;
        JSONObject jSONObject = new JSONObject();
        JSONUtilsKt.safelyPut(jSONObject, "event", "aspect_await_timeout");
        JSONUtilsKt.safelyPut(jSONObject, ArgusMonitorKeyName.SEC_EVENT_TYPE, aspect.getStringValue());
        JSONUtilsKt.safelyPut(jSONObject, "msg", "await time out, give up execute");
        argusMonitor.asyncReportInnerError(jSONObject);
    }

    public final Deferred<?> triggerAsyncEvent(IArgusAspect aspect, boolean saveEvent, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(aspect, "aspect");
        Intrinsics.checkNotNullParameter(block, "block");
        Deferred<?> async$default = BuildersKt.async$default(getAspectAsyncScope(), (CoroutineContext) null, (CoroutineStart) null, new BaseEventCenter$triggerAsyncEvent$job$1(block, saveEvent, this, aspect, null), 3, (Object) null);
        if (saveEvent) {
            this.awaitEventJobs.put(aspect, async$default);
        }
        return async$default;
    }

    /* compiled from: BaseEventCenter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\n\b\u0001\u0010\u0003*\u0004\u0018\u00010\u00042\u00020\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJS\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b2B\b\u0004\u0010\u001f\u001a<\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000R\u00020!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001b\u0012\u0004\u0012\u00020\"0 H\u0082\bJ\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000R\u00020!J\u0016\u0010$\u001a\u00020\"2\f\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017H\u0002J\u001c\u0010&\u001a\u00020\"2\u000e\b\u0004\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\"0'H\u0086\bø\u0001\u0000J\u0012\u0010&\u001a\u00020\"2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030\u0017JS\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b2B\b\u0004\u0010\u001f\u001a<\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000R\u00020!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001b\u0012\u0004\u0012\u00020\"0 H\u0082\bJ\u001c\u0010*\u001a\u00020\"2\u000e\b\u0004\u0010+\u001a\b\u0012\u0004\u0012\u00020\"0'H\u0086\bø\u0001\u0000J\"\u0010,\u001a\u00020\"2\u0014\b\u0004\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\"0.H\u0086\bø\u0001\u0000J\u001e\u00100\u001a\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000R\u00020!2\u0006\u00101\u001a\u000202J\"\u00103\u001a\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000R\u00020!2\n\u00104\u001a\u0006\u0012\u0002\b\u000305J`\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b2\b\b\u0002\u00107\u001a\u00020\u00192B\b\u0004\u0010\u001f\u001a<\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000R\u00020!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001b\u0012\u0004\u0012\u00020\"0 H\u0086\bø\u0001\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\b\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0018\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00068"}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter$VerifyHandler;", "PARAMS", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "REWRITE_PAYLOAD", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "", "aspect", "Lcom/bytedance/ies/argus/bean/IArgusAspect;", "params", "(Lcom/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter;Lcom/bytedance/ies/argus/bean/IArgusAspect;Lcom/bytedance/ies/argus/api/params/BaseAspectParams;)V", "context", "Lcom/bytedance/ies/argus/bean/AspectContext;", "getContext", "()Lcom/bytedance/ies/argus/bean/AspectContext;", "metric", "", "", "", "getMetric", "()Ljava/util/Map;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "reportAwaitTask", "", "Lkotlinx/coroutines/Deferred;", "saveEvent", "", "verifyResult", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "getVerifyResult", "()Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "asyncVerify", "block", "Lkotlin/Function3;", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter;", "", "enableSaveEvent", "executeReportTask", "asyncJob", "setAsyncReportAwaitTask", "Lkotlin/Function0;", "task", "syncVerify", "triggerInnerCalculate", "innerBlock", "triggerWebExternCalculate", "externBlock", "Lkotlin/Function1;", "Lcom/bytedance/ies/argus/api/interfaces/service/IArgusWebSecureService;", "updateDefaultReportPlatform", "type", "Lcom/bytedance/ies/argus/base/ArgusReportPlatform;", "updateViewContext", "viewContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseViewContext;", SettingsManager.VERIFY_SERVICE, "forceUseAsync", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final class VerifyHandler<PARAMS extends BaseAspectParams<REWRITE_PAYLOAD>, REWRITE_PAYLOAD extends BaseRewritePayload> {
        private final IArgusAspect aspect;
        private final AspectContext<PARAMS, REWRITE_PAYLOAD> context;
        private final Map<String, long[]> metric;
        private final PARAMS params;
        private List<Deferred<?>> reportAwaitTask;
        private boolean saveEvent;
        final /* synthetic */ BaseEventCenter this$0;

        public VerifyHandler(BaseEventCenter baseEventCenter, IArgusAspect iArgusAspect, PARAMS params) {
            Intrinsics.checkNotNullParameter(iArgusAspect, "aspect");
            Intrinsics.checkNotNullParameter(params, "params");
            this.this$0 = baseEventCenter;
            this.aspect = iArgusAspect;
            this.params = params;
            this.context = baseEventCenter.initContext$anniex_release(iArgusAspect, params);
            this.metric = new LinkedHashMap();
            this.reportAwaitTask = new ArrayList();
        }

        public final AspectContext<PARAMS, REWRITE_PAYLOAD> getContext() {
            return this.context;
        }

        public final AspectVerifyResult<REWRITE_PAYLOAD> getVerifyResult() {
            return this.context.getVerifyResult();
        }

        public final Map<String, long[]> getMetric() {
            return this.metric;
        }

        public final VerifyHandler<PARAMS, REWRITE_PAYLOAD> enableSaveEvent() {
            this.saveEvent = true;
            return this;
        }

        public final VerifyHandler<PARAMS, REWRITE_PAYLOAD> updateDefaultReportPlatform(ArgusReportPlatform type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.context.getReportParams().setReportPlatform(type);
            return this;
        }

        public final VerifyHandler<PARAMS, REWRITE_PAYLOAD> updateViewContext(BaseViewContext<?> viewContext) {
            Intrinsics.checkNotNullParameter(viewContext, "viewContext");
            this.context.setViewContext$anniex_release(viewContext);
            return this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
        
            if ((r1 != null ? kotlin.jvm.internal.Intrinsics.areEqual(r1.getAsync(), false) : false) == false) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ AspectVerifyResult verify$default(VerifyHandler verifyHandler, boolean z, Function3 function3, int i, Object obj) {
            boolean z2 = true;
            boolean z3 = (i & 1) != 0 ? false : z;
            Intrinsics.checkNotNullParameter(function3, "block");
            if (z3) {
                AspectConfigItem aspectConfig = verifyHandler.getContext().getAspectConfig();
            }
            z2 = false;
            verifyHandler.getContext().setUseAsync(z2);
            if (z2) {
                verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
                BaseEventCenter baseEventCenter = verifyHandler.this$0;
                IArgusAspect iArgusAspect = verifyHandler.aspect;
                boolean z4 = verifyHandler.saveEvent;
                Deferred async$default = BuildersKt.async$default(baseEventCenter.getAspectAsyncScope(), (CoroutineContext) null, (CoroutineStart) null, new C1160xa9e3eb0e(z4, baseEventCenter, iArgusAspect, null, verifyHandler, function3), 3, (Object) null);
                if (z4) {
                    baseEventCenter.awaitEventJobs.put(iArgusAspect, async$default);
                }
                verifyHandler.executeReportTask(async$default);
                verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
                return AspectVerifyResult.onPass$default(verifyHandler.getVerifyResult(), ArgusCommonVerifyReason.ASYNC_PASS_FIRST, null, null, 6, null);
            }
            verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
            function3.invoke(verifyHandler, verifyHandler.getContext(), verifyHandler.getVerifyResult());
            verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
            verifyHandler.executeReportTask(null);
            return verifyHandler.getVerifyResult();
        }

        public final AspectVerifyResult<REWRITE_PAYLOAD> verify(boolean forceUseAsync, Function3<? super VerifyHandler<PARAMS, REWRITE_PAYLOAD>, ? super AspectContext<PARAMS, REWRITE_PAYLOAD>, ? super AspectVerifyResult<REWRITE_PAYLOAD>, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            boolean z = false;
            if (forceUseAsync) {
                AspectConfigItem aspectConfig = getContext().getAspectConfig();
                if (!(aspectConfig != null ? Intrinsics.areEqual(aspectConfig.getAsync(), false) : false)) {
                    z = true;
                }
            }
            getContext().setUseAsync(z);
            if (z) {
                getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
                BaseEventCenter baseEventCenter = this.this$0;
                IArgusAspect iArgusAspect = this.aspect;
                boolean z2 = this.saveEvent;
                Deferred async$default = BuildersKt.async$default(baseEventCenter.getAspectAsyncScope(), (CoroutineContext) null, (CoroutineStart) null, new C1160xa9e3eb0e(z2, baseEventCenter, iArgusAspect, null, this, block), 3, (Object) null);
                if (z2) {
                    baseEventCenter.awaitEventJobs.put(iArgusAspect, async$default);
                }
                executeReportTask(async$default);
                getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
                return AspectVerifyResult.onPass$default(getVerifyResult(), ArgusCommonVerifyReason.ASYNC_PASS_FIRST, null, null, 6, null);
            }
            getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
            block.invoke(this, getContext(), getVerifyResult());
            getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
            executeReportTask(null);
            return getVerifyResult();
        }

        private final AspectVerifyResult<REWRITE_PAYLOAD> syncVerify(Function3<? super VerifyHandler<PARAMS, REWRITE_PAYLOAD>, ? super AspectContext<PARAMS, REWRITE_PAYLOAD>, ? super AspectVerifyResult<REWRITE_PAYLOAD>, Unit> block) {
            getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
            block.invoke(this, getContext(), getVerifyResult());
            getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
            executeReportTask(null);
            return getVerifyResult();
        }

        private final AspectVerifyResult<REWRITE_PAYLOAD> asyncVerify(Function3<? super VerifyHandler<PARAMS, REWRITE_PAYLOAD>, ? super AspectContext<PARAMS, REWRITE_PAYLOAD>, ? super AspectVerifyResult<REWRITE_PAYLOAD>, Unit> block) {
            getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
            BaseEventCenter baseEventCenter = this.this$0;
            IArgusAspect iArgusAspect = this.aspect;
            boolean z = this.saveEvent;
            Deferred async$default = BuildersKt.async$default(baseEventCenter.getAspectAsyncScope(), (CoroutineContext) null, (CoroutineStart) null, new C1160xa9e3eb0e(z, baseEventCenter, iArgusAspect, null, this, block), 3, (Object) null);
            if (z) {
                baseEventCenter.awaitEventJobs.put(iArgusAspect, async$default);
            }
            executeReportTask(async$default);
            getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
            return AspectVerifyResult.onPass$default(getVerifyResult(), ArgusCommonVerifyReason.ASYNC_PASS_FIRST, null, null, 6, null);
        }

        public final void triggerInnerCalculate(Function0<Unit> innerBlock) {
            Intrinsics.checkNotNullParameter(innerBlock, "innerBlock");
            getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, "");
            innerBlock.invoke();
            getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, "");
        }

        public final void triggerWebExternCalculate(Function1<? super IArgusWebSecureService, Unit> externBlock) {
            Intrinsics.checkNotNullParameter(externBlock, "externBlock");
            Iterator<IArgusWebSecureService> it = ArgusServiceManager.INSTANCE.getInstance().getWebServiceList().iterator();
            while (it.hasNext()) {
                IArgusWebSecureService next = it.next();
                String serviceName = next.serviceName();
                getContext().recordCost(AspectContext.Companion.TraceType.SERVICE_VERIFY, AspectContext.Companion.TraceStage.START, serviceName);
                Intrinsics.checkNotNullExpressionValue(next, "service");
                externBlock.invoke(next);
                AspectContext.recordVerifyResult$default(getContext(), serviceName, getVerifyResult().toString(), null, 4, null);
                getContext().recordCost(AspectContext.Companion.TraceType.SERVICE_VERIFY, AspectContext.Companion.TraceStage.END, serviceName);
                if (getVerifyResult().isBlock()) {
                    return;
                }
            }
        }

        public final void setAsyncReportAwaitTask(Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.reportAwaitTask.add(BuildersKt.async$default(this.this$0.getReportScope(), (CoroutineContext) null, (CoroutineStart) null, new BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1(block, null), 3, (Object) null));
        }

        public final void setAsyncReportAwaitTask(Deferred<?> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.reportAwaitTask.add(task);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void executeReportTask(Deferred<?> asyncJob) {
            if (asyncJob != null) {
                this.reportAwaitTask.add(asyncJob);
            }
            if (!this.reportAwaitTask.isEmpty()) {
                BuildersKt.launch$default(this.this$0.getReportScope(), (CoroutineContext) null, (CoroutineStart) null, new BaseEventCenter$VerifyHandler$executeReportTask$2(this, null), 3, (Object) null);
            } else {
                ArgusMonitor.INSTANCE.asyncReportAspect(this.context);
            }
        }
    }

    public final void destroy() {
        CoroutineScopeKt.cancel$default(getAspectAsyncScope(), (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.cancel$default(getReportScope(), (CancellationException) null, 1, (Object) null);
    }

    public final <PARAMS extends BaseAspectParams<REWRITE_PAYLOAD>, REWRITE_PAYLOAD extends BaseRewritePayload> AspectContext<PARAMS, REWRITE_PAYLOAD> initContext$anniex_release(IArgusAspect aspect, PARAMS params) {
        Intrinsics.checkNotNullParameter(aspect, "aspect");
        Intrinsics.checkNotNullParameter(params, "params");
        AspectContext<PARAMS, REWRITE_PAYLOAD> aspectContext = new AspectContext<>(aspect, params);
        aspectContext.setContainerContext$anniex_release(this.depend.getThis$0());
        return aspectContext;
    }
}
