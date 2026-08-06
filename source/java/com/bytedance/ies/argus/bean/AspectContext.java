package com.bytedance.ies.argus.bean;

import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.aspect.eventCenter.BaseViewContext;
import com.bytedance.ies.argus.aspect.eventCenter.ContainerContext;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.base.ArgusReportParams;
import com.bytedance.ies.argus.base.ArgusReportPlatform;
import com.bytedance.ies.argus.repository.AspectConfigInfo;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.GlobalStrategyManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AspectContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 W*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\n\b\u0001\u0010\u0003*\u0004\u0018\u00010\u00042\u00020\u0005:\u0002VWB\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\n\u0010J\u001a\u0004\u0018\u00010\u0015H\u0002J \u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010\u000bJ \u0010R\u001a\u00020L2\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020\u000b2\b\b\u0002\u0010U\u001a\u00020>R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R#\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0.0-¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R#\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0.0-¢\u0006\b\n\u0000\u001a\u0004\b2\u00100R\u0014\u00103\u001a\u000204X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020>8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00010&8F¢\u0006\u0006\u001a\u0004\bB\u0010CR \u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010EX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006X"}, d2 = {"Lcom/bytedance/ies/argus/bean/AspectContext;", "PARAMS", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "REWRITE_PAYLOAD", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "", "callingAspect", "Lcom/bytedance/ies/argus/bean/IArgusAspect;", "callerParams", "(Lcom/bytedance/ies/argus/bean/IArgusAspect;Lcom/bytedance/ies/argus/api/params/BaseAspectParams;)V", "argusBizId", "", "getArgusBizId", "()Ljava/lang/String;", "argusSceneTag", "getArgusSceneTag", "aspectConfig", "Lcom/bytedance/ies/argus/bean/AspectConfigItem;", "getAspectConfig", "()Lcom/bytedance/ies/argus/bean/AspectConfigItem;", "aspectConfigInfo", "Lcom/bytedance/ies/argus/repository/AspectConfigInfo;", "getAspectConfigInfo$anniex_release", "()Lcom/bytedance/ies/argus/repository/AspectConfigInfo;", "aspectConfigInfo$delegate", "Lkotlin/Lazy;", "getCallerParams", "()Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "getCallingAspect", "()Lcom/bytedance/ies/argus/bean/IArgusAspect;", "containerContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/ContainerContext;", "getContainerContext$anniex_release", "()Lcom/bytedance/ies/argus/aspect/eventCenter/ContainerContext;", "setContainerContext$anniex_release", "(Lcom/bytedance/ies/argus/aspect/eventCenter/ContainerContext;)V", "innerVerifyResult", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "metric", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getMetric", "()Ljava/util/concurrent/ConcurrentHashMap;", "realVerifyResultRecord", "", "Lkotlin/Pair;", "getRealVerifyResultRecord", "()Ljava/util/List;", "reportOnlyVerifyResultRecord", "getReportOnlyVerifyResultRecord", "reportParams", "Lcom/bytedance/ies/argus/base/ArgusReportParams;", "getReportParams$anniex_release", "()Lcom/bytedance/ies/argus/base/ArgusReportParams;", "useAsync", "", "getUseAsync", "()Z", "setUseAsync", "(Z)V", "verifyMode", "Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "getVerifyMode", "()Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "verifyResult", "getVerifyResult", "()Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "viewContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseViewContext;", "getViewContext$anniex_release", "()Lcom/bytedance/ies/argus/aspect/eventCenter/BaseViewContext;", "setViewContext$anniex_release", "(Lcom/bytedance/ies/argus/aspect/eventCenter/BaseViewContext;)V", "initAspectConfig", "recordCost", "", MonitorConstant.STAGE, "Lcom/bytedance/ies/argus/bean/AspectContext$Companion$TraceType;", "stageType", "Lcom/bytedance/ies/argus/bean/AspectContext$Companion$TraceStage;", Api.KEY_ENCRYPT_RESP_KEY, "recordVerifyResult", "strategyKey", "result", "mode", "CalculateContext", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AspectContext<PARAMS extends BaseAspectParams<REWRITE_PAYLOAD>, REWRITE_PAYLOAD extends BaseRewritePayload> {
    public static final String TAG = "AspectContext";

    /* renamed from: aspectConfigInfo$delegate, reason: from kotlin metadata */
    private final Lazy aspectConfigInfo;
    private final PARAMS callerParams;
    private final IArgusAspect callingAspect;
    private ContainerContext containerContext;
    private AspectVerifyResult<REWRITE_PAYLOAD> innerVerifyResult;
    private final ConcurrentHashMap<String, long[]> metric;
    private final List<Pair<String, String>> realVerifyResultRecord;
    private final List<Pair<String, String>> reportOnlyVerifyResultRecord;
    private final ArgusReportParams reportParams;
    private boolean useAsync;
    private BaseViewContext<?> viewContext;

    /* compiled from: AspectContext.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Companion.TraceType.values().length];
            try {
                iArr[Companion.TraceType.INNER_ASPECT_VERIFY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.TraceType.ASPECT_VERIFY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AspectContext(IArgusAspect iArgusAspect, PARAMS params) {
        Intrinsics.checkNotNullParameter(iArgusAspect, "callingAspect");
        Intrinsics.checkNotNullParameter(params, "callerParams");
        this.callingAspect = iArgusAspect;
        this.callerParams = params;
        this.aspectConfigInfo = LazyKt.lazy(new Function0<AspectConfigInfo>(this) { // from class: com.bytedance.ies.argus.bean.AspectContext$aspectConfigInfo$2
            final /* synthetic */ AspectContext<PARAMS, REWRITE_PAYLOAD> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AspectConfigInfo m611invoke() {
                AspectConfigInfo initAspectConfig;
                initAspectConfig = this.this$0.initAspectConfig();
                return initAspectConfig;
            }
        });
        ArgusSwitch argusSwitch = null;
        this.innerVerifyResult = new AspectVerifyResult<>(params.getRewritePayload(), argusSwitch, 2, argusSwitch);
        this.metric = new ConcurrentHashMap<>();
        this.realVerifyResultRecord = new ArrayList();
        this.reportOnlyVerifyResultRecord = new ArrayList();
        recordCost(Companion.TraceType.ASPECT_VERIFY, Companion.TraceStage.START, null);
        this.reportParams = new ArgusReportParams(false, false, null, null, 15, null);
    }

    public final IArgusAspect getCallingAspect() {
        return this.callingAspect;
    }

    public final PARAMS getCallerParams() {
        return this.callerParams;
    }

    /* renamed from: getContainerContext$anniex_release, reason: from getter */
    public final ContainerContext getContainerContext() {
        return this.containerContext;
    }

    public final void setContainerContext$anniex_release(ContainerContext containerContext) {
        this.containerContext = containerContext;
    }

    public final String getArgusBizId() {
        String argusBizId;
        BaseViewContext<?> baseViewContext = this.viewContext;
        if (baseViewContext != null && (argusBizId = baseViewContext.getArgusBizId()) != null) {
            return argusBizId;
        }
        ContainerContext containerContext = this.containerContext;
        String argusBizId2 = containerContext != null ? containerContext.getArgusBizId() : null;
        return argusBizId2 == null ? "host" : argusBizId2;
    }

    public final String getArgusSceneTag() {
        String argusSceneTag;
        BaseViewContext<?> baseViewContext = this.viewContext;
        if (baseViewContext != null && (argusSceneTag = baseViewContext.getArgusSceneTag()) != null) {
            return argusSceneTag;
        }
        ContainerContext containerContext = this.containerContext;
        if (containerContext != null) {
            return containerContext.getArgusSceneTag();
        }
        return null;
    }

    public final AspectConfigInfo getAspectConfigInfo$anniex_release() {
        return (AspectConfigInfo) this.aspectConfigInfo.getValue();
    }

    public final AspectConfigItem getAspectConfig() {
        AspectConfigInfo aspectConfigInfo$anniex_release = getAspectConfigInfo$anniex_release();
        if (aspectConfigInfo$anniex_release != null) {
            return aspectConfigInfo$anniex_release.getConfig();
        }
        return null;
    }

    private final ArgusSwitch getVerifyMode() {
        AspectConfigItem aspectConfig = getAspectConfig();
        return new ArgusSwitch(aspectConfig != null ? Integer.valueOf(aspectConfig.getSwitch()) : null);
    }

    public final boolean getUseAsync() {
        return this.useAsync;
    }

    public final void setUseAsync(boolean z) {
        this.useAsync = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AspectVerifyResult<REWRITE_PAYLOAD> getVerifyResult() {
        int i = 3;
        BaseRewritePayload baseRewritePayload = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        if (getAspectConfig() == null) {
            return AspectVerifyResult.onPass$default(new AspectVerifyResult(baseRewritePayload, objArr8 == true ? 1 : 0, i, objArr7 == true ? 1 : 0), ArgusCommonVerifyReason.ASPECT_CONFIG_IS_NULL, null, null, 6, null);
        }
        if (getVerifyMode().getUseResult()) {
            return this.innerVerifyResult;
        }
        if (getVerifyMode().getIsReportOnly()) {
            return AspectVerifyResult.onPass$default(new AspectVerifyResult(objArr6 == true ? 1 : 0, objArr5 == true ? 1 : 0, i, objArr4 == true ? 1 : 0), ArgusCommonVerifyReason.ASPECT_IS_REPORT_ONLY, null, null, 6, null);
        }
        return AspectVerifyResult.onPass$default(new AspectVerifyResult(objArr3 == true ? 1 : 0, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0), ArgusCommonVerifyReason.ASPECT_IS_OFF, null, null, 6, null);
    }

    public final BaseViewContext<?> getViewContext$anniex_release() {
        return this.viewContext;
    }

    public final void setViewContext$anniex_release(BaseViewContext<?> baseViewContext) {
        this.viewContext = baseViewContext;
    }

    public final ConcurrentHashMap<String, long[]> getMetric() {
        return this.metric;
    }

    public final List<Pair<String, String>> getRealVerifyResultRecord() {
        return this.realVerifyResultRecord;
    }

    public final List<Pair<String, String>> getReportOnlyVerifyResultRecord() {
        return this.reportOnlyVerifyResultRecord;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AspectConfigInfo initAspectConfig() {
        return GlobalStrategyManager.INSTANCE.getAspectConfig(getArgusBizId(), this.callingAspect);
    }

    public static /* synthetic */ void recordVerifyResult$default(AspectContext aspectContext, String str, String str2, ArgusSwitch argusSwitch, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordVerifyResult");
        }
        if ((i & 4) != 0) {
            argusSwitch = new ArgusSwitch(2);
        }
        aspectContext.recordVerifyResult(str, str2, argusSwitch);
    }

    public final void recordVerifyResult(String strategyKey, String result, ArgusSwitch mode) {
        List<Pair<String, String>> list;
        Intrinsics.checkNotNullParameter(strategyKey, "strategyKey");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (mode.getUseResult()) {
            list = this.realVerifyResultRecord;
        } else {
            list = this.reportOnlyVerifyResultRecord;
        }
        Pair pair = (Pair) CollectionsKt.lastOrNull(list);
        if (pair == null || !Intrinsics.areEqual(pair.getSecond(), result)) {
            list.add(new Pair<>(strategyKey, result));
        }
    }

    /* compiled from: AspectContext.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\u001d2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(JG\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00062$\b\u0004\u0010-\u001a\u001e\u0012\u0014\u0012\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010/\u0012\u0004\u0012\u00020&0.H\u0080\bø\u0001\u0000¢\u0006\u0002\b0R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00061"}, d2 = {"Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "", "mode", "Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "(Lcom/bytedance/ies/argus/bean/AspectContext;Lcom/bytedance/ies/argus/bean/ArgusSwitch;)V", "argusId", "", "getArgusId", "()Ljava/lang/String;", "argusSceneTag", "getArgusSceneTag", "callerParams", "getCallerParams", "()Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "callingAspect", "Lcom/bytedance/ies/argus/bean/IArgusAspect;", "getCallingAspect", "()Lcom/bytedance/ies/argus/bean/IArgusAspect;", "containerContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/ContainerContext;", "getContainerContext", "()Lcom/bytedance/ies/argus/aspect/eventCenter/ContainerContext;", "getMode", "()Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "reportParams", "Lcom/bytedance/ies/argus/base/ArgusReportParams;", "getReportParams", "()Lcom/bytedance/ies/argus/base/ArgusReportParams;", "verifyResult", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "getVerifyResult", "()Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "viewContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseViewContext;", "getViewContext", "()Lcom/bytedance/ies/argus/aspect/eventCenter/BaseViewContext;", "initVerifyResult", "setReportPlatform", "", "reportPlatform", "Lcom/bytedance/ies/argus/base/ArgusReportPlatform;", TraceStatsConsts.STATS_KEY_TRACE, MonitorConstant.STAGE, "Lcom/bytedance/ies/argus/bean/AspectContext$Companion$TraceType;", Api.KEY_ENCRYPT_RESP_KEY, "block", "Lkotlin/Function1;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "trace$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final class CalculateContext {
        private final ArgusSwitch mode;
        final /* synthetic */ AspectContext<PARAMS, REWRITE_PAYLOAD> this$0;
        private final AspectVerifyResult<REWRITE_PAYLOAD> verifyResult;

        public CalculateContext(AspectContext aspectContext, ArgusSwitch argusSwitch) {
            Intrinsics.checkNotNullParameter(argusSwitch, "mode");
            this.this$0 = aspectContext;
            this.mode = argusSwitch;
            this.verifyResult = initVerifyResult(argusSwitch);
        }

        public final ArgusSwitch getMode() {
            return this.mode;
        }

        public final AspectVerifyResult<REWRITE_PAYLOAD> getVerifyResult() {
            return this.verifyResult;
        }

        public final IArgusAspect getCallingAspect() {
            return this.this$0.getCallingAspect();
        }

        public final PARAMS getCallerParams() {
            return this.this$0.getCallerParams();
        }

        public final ContainerContext getContainerContext() {
            return this.this$0.getContainerContext();
        }

        public final BaseViewContext<?> getViewContext() {
            return this.this$0.getViewContext$anniex_release();
        }

        public final String getArgusId() {
            return this.this$0.getArgusBizId();
        }

        public final String getArgusSceneTag() {
            return this.this$0.getArgusSceneTag();
        }

        public final ArgusReportParams getReportParams() {
            return this.this$0.getReportParams();
        }

        private final AspectVerifyResult<REWRITE_PAYLOAD> initVerifyResult(ArgusSwitch mode) {
            if (mode.getUseResult()) {
                return ((AspectContext) this.this$0).innerVerifyResult;
            }
            ArgusSwitch argusSwitch = null;
            return new AspectVerifyResult<>(getCallerParams().initRewritePayload(), argusSwitch, 2, argusSwitch);
        }

        public final void trace$anniex_release(Companion.TraceType stage, String key, Function1<? super AspectContext<PARAMS, REWRITE_PAYLOAD>.CalculateContext, Unit> block) {
            Intrinsics.checkNotNullParameter(stage, MonitorConstant.STAGE);
            Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
            Intrinsics.checkNotNullParameter(block, "block");
            this.this$0.recordCost(stage, Companion.TraceStage.START, key);
            try {
                try {
                    block.invoke(this);
                    this.this$0.recordVerifyResult(key, getVerifyResult().toString(), getMode());
                    if (getVerifyResult().isPass() && getVerifyResult().isReasonCodeUnset()) {
                        AspectVerifyResult.onPass$default(getVerifyResult(), ArgusCommonVerifyReason.PASS_STRATEGY_CALCULATE, "strategyKey=" + key, null, 4, null);
                    }
                    InlineMarker.finallyStart(1);
                } catch (Exception e) {
                    ArgusLog.e$default(ArgusLog.INSTANCE, AspectContext.TAG, "trace ", null, e, 4, null);
                    AspectVerifyResult.onError$default(getVerifyResult(), ArgusCommonVerifyReason.TRY_CATCH_ERROR, e.toString(), null, 4, null);
                    InlineMarker.finallyStart(1);
                }
                this.this$0.recordCost(stage, Companion.TraceStage.END, key);
                InlineMarker.finallyEnd(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                this.this$0.recordCost(stage, Companion.TraceStage.END, key);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }

        public final void setReportPlatform(ArgusReportPlatform reportPlatform) {
            Intrinsics.checkNotNullParameter(reportPlatform, "reportPlatform");
            this.this$0.getReportParams().setReportPlatform(reportPlatform);
        }
    }

    /* renamed from: getReportParams$anniex_release, reason: from getter */
    public final ArgusReportParams getReportParams() {
        return this.reportParams;
    }

    public final void recordCost(Companion.TraceType stage, Companion.TraceStage stageType, String key) {
        Intrinsics.checkNotNullParameter(stage, MonitorConstant.STAGE);
        Intrinsics.checkNotNullParameter(stageType, "stageType");
        String metricPrefix = stage.getMetricPrefix();
        int i = WhenMappings.$EnumSwitchMapping$0[stage.ordinal()];
        if (i != 1 && i != 2) {
            metricPrefix = metricPrefix + '_' + key;
        }
        if (this.metric.get(metricPrefix) == null) {
            ConcurrentHashMap<String, long[]> concurrentHashMap = this.metric;
            long[] jArr = new long[2];
            for (int i2 = 0; i2 < 2; i2++) {
                jArr[i2] = -1;
            }
            concurrentHashMap.put(metricPrefix, jArr);
        }
        if (stageType == Companion.TraceStage.START) {
            long[] jArr2 = this.metric.get(metricPrefix);
            if (jArr2 != null) {
                jArr2[0] = System.currentTimeMillis();
                return;
            }
            return;
        }
        long[] jArr3 = this.metric.get(metricPrefix);
        if (jArr3 != null) {
            jArr3[1] = System.currentTimeMillis();
        }
    }
}
