package com.bytedance.android.monitorV2.event;

import com.bytedance.android.monitorV2.checker.EventChecker;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.executor.HybridMonitorSingleExecutor;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.listener.IHybridEventListener;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.util.Utilities;
import com.bytedance.applog.server.Api;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: HybridEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001:\u0004_`abB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00030NJ\b\u0010O\u001a\u00020$H\u0002J\u0006\u0010P\u001a\u00020QJ\u0006\u0010R\u001a\u00020QJ\u000e\u0010S\u001a\u00020Q2\u0006\u0010T\u001a\u00020UJ\u0006\u0010V\u001a\u00020QJ\u0006\u0010W\u001a\u00020QJ\u0018\u0010X\u001a\u00020Q2\u0006\u0010Y\u001a\u00020\u00032\b\u0010Z\u001a\u0004\u0018\u00010\u0001J\u0016\u0010[\u001a\u00020$2\u0006\u0010\\\u001a\u00020$2\u0006\u0010]\u001a\u00020UJ\b\u0010^\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\u0004R*\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\u0004R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010&\"\u0004\b=\u0010(R\u001a\u0010>\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR(\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001d\"\u0004\bF\u0010\u001fR\u001a\u0010G\u001a\u00020HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006c"}, d2 = {"Lcom/bytedance/android/monitorV2/event/HybridEvent;", "", "eventType", "", "(Ljava/lang/String;)V", "bid", "getBid", "()Ljava/lang/String;", "setBid", "bidSource", "getBidSource", "setBidSource", "containerBase", "Lcom/bytedance/android/monitorV2/entity/ContainerBase;", "getContainerBase", "()Lcom/bytedance/android/monitorV2/entity/ContainerBase;", "setContainerBase", "(Lcom/bytedance/android/monitorV2/entity/ContainerBase;)V", "eventId", "Ljava/util/UUID;", "getEventId", "()Ljava/util/UUID;", "eventId$delegate", "Lkotlin/Lazy;", "getEventType", "setEventType", "extra", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "fullLinkId", "getFullLinkId", "setFullLinkId", "hitSample", "", "getHitSample", "()Z", "setHitSample", "(Z)V", "jsBase", "Lorg/json/JSONObject;", "getJsBase", "()Lorg/json/JSONObject;", "setJsBase", "(Lorg/json/JSONObject;)V", "listener", "Lcom/bytedance/android/monitorV2/listener/IHybridEventListener;", "getListener", "()Lcom/bytedance/android/monitorV2/listener/IHybridEventListener;", "setListener", "(Lcom/bytedance/android/monitorV2/listener/IHybridEventListener;)V", "nativeBase", "Lcom/bytedance/android/monitorV2/entity/NativeCommon;", "getNativeBase", "()Lcom/bytedance/android/monitorV2/entity/NativeCommon;", "setNativeBase", "(Lcom/bytedance/android/monitorV2/entity/NativeCommon;)V", "preSample", "getPreSample", "setPreSample", "state", "Lcom/bytedance/android/monitorV2/event/HybridEvent$State;", "getState", "()Lcom/bytedance/android/monitorV2/event/HybridEvent$State;", "setState", "(Lcom/bytedance/android/monitorV2/event/HybridEvent$State;)V", "tags", "getTags", "setTags", "transferTarget", "Lcom/bytedance/android/monitorV2/event/HybridEvent$TransferTarget;", "getTransferTarget", "()Lcom/bytedance/android/monitorV2/event/HybridEvent$TransferTarget;", "setTransferTarget", "(Lcom/bytedance/android/monitorV2/event/HybridEvent$TransferTarget;)V", "getUriRegexInputList", "", "isEventStreamEnable", "onEventCreated", "", "onEventSampled", "onEventTerminated", "msg", "Lcom/bytedance/android/monitorV2/event/HybridEvent$TerminateType;", "onEventUpdated", "onEventUploaded", "putExtra", Api.KEY_ENCRYPT_RESP_KEY, "value", "terminateIf", "condition", "reason", "toString", "EventPhase", "State", "TerminateType", "TransferTarget", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class HybridEvent {
    private String bid;
    private String bidSource;
    private ContainerBase containerBase;

    /* renamed from: eventId$delegate, reason: from kotlin metadata */
    private final Lazy eventId;
    private String eventType;
    private Map<String, Object> extra;
    private String fullLinkId;
    private boolean hitSample;
    private JSONObject jsBase;
    private IHybridEventListener listener;
    private NativeCommon nativeBase;
    private boolean preSample;
    private State state;
    private Map<String, Object> tags;
    private TransferTarget transferTarget;

    /* compiled from: HybridEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/monitorV2/event/HybridEvent$EventPhase;", "", "(Ljava/lang/String;I)V", "EVENT_CREATE", "EVENT_TERMINATED", "SAMPLE_THROW", "EVENT_UPLOAD", "EVENT_UPDATED", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum EventPhase {
        EVENT_CREATE,
        EVENT_TERMINATED,
        SAMPLE_THROW,
        EVENT_UPLOAD,
        EVENT_UPDATED
    }

    /* compiled from: HybridEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/monitorV2/event/HybridEvent$TerminateType;", "", "(Ljava/lang/String;I)V", "SWITCH_OFF", "PARAM_EXCEPTION", "CATCH_EXCEPTION", "EVENT_REPEATED", "INVALID_CASE", "HOST_VIEW_DESTROYED", "BLOCK_LIST", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum TerminateType {
        SWITCH_OFF,
        PARAM_EXCEPTION,
        CATCH_EXCEPTION,
        EVENT_REPEATED,
        INVALID_CASE,
        HOST_VIEW_DESTROYED,
        BLOCK_LIST
    }

    /* compiled from: HybridEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/monitorV2/event/HybridEvent$TransferTarget;", "", "(Ljava/lang/String;I)V", "Slardar", "Tea", "Both", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum TransferTarget {
        Slardar,
        Tea,
        Both
    }

    public HybridEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "eventType");
        this.eventType = str;
        this.eventId = LazyKt.lazy(new Function0<UUID>() { // from class: com.bytedance.android.monitorV2.event.HybridEvent$eventId$2
            public final UUID invoke() {
                return UUID.randomUUID();
            }
        });
        this.state = new State();
        this.tags = new LinkedHashMap();
        this.nativeBase = new NativeCommon();
        this.transferTarget = TransferTarget.Slardar;
        String str2 = BidInfo.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(str2, "DEFAULT");
        this.bid = str2;
        this.bidSource = "default_bid";
        this.listener = EventChecker.INSTANCE.createEventListener();
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final void setEventType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eventType = str;
    }

    public final UUID getEventId() {
        Object value = this.eventId.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-eventId>(...)");
        return (UUID) value;
    }

    public final String getFullLinkId() {
        return this.fullLinkId;
    }

    public final void setFullLinkId(String str) {
        this.fullLinkId = str;
    }

    public final State getState() {
        return this.state;
    }

    public final void setState(State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.state = state;
    }

    public final Map<String, Object> getTags() {
        return this.tags;
    }

    public final void setTags(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.tags = map;
    }

    public final NativeCommon getNativeBase() {
        return this.nativeBase;
    }

    public final void setNativeBase(NativeCommon nativeCommon) {
        Intrinsics.checkNotNullParameter(nativeCommon, "<set-?>");
        this.nativeBase = nativeCommon;
    }

    public final JSONObject getJsBase() {
        return this.jsBase;
    }

    public final void setJsBase(JSONObject jSONObject) {
        this.jsBase = jSONObject;
    }

    public final ContainerBase getContainerBase() {
        return this.containerBase;
    }

    public final void setContainerBase(ContainerBase containerBase) {
        this.containerBase = containerBase;
    }

    public final TransferTarget getTransferTarget() {
        return this.transferTarget;
    }

    public final void setTransferTarget(TransferTarget transferTarget) {
        Intrinsics.checkNotNullParameter(transferTarget, "<set-?>");
        this.transferTarget = transferTarget;
    }

    public final boolean getHitSample() {
        return this.hitSample;
    }

    public final void setHitSample(boolean z) {
        this.hitSample = z;
    }

    public final boolean getPreSample() {
        return this.preSample;
    }

    public final void setPreSample(boolean z) {
        this.preSample = z;
    }

    public final String getBid() {
        return this.bid;
    }

    public final void setBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    public final String getBidSource() {
        return this.bidSource;
    }

    public final void setBidSource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bidSource = str;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final void setExtra(Map<String, Object> map) {
        this.extra = map;
    }

    public final IHybridEventListener getListener() {
        return this.listener;
    }

    public final void setListener(IHybridEventListener iHybridEventListener) {
        Intrinsics.checkNotNullParameter(iHybridEventListener, "<set-?>");
        this.listener = iHybridEventListener;
    }

    public final boolean terminateIf(boolean condition, TerminateType reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (condition) {
            MonitorLog.m31w("HBMonitorSDK_V2", "Event terminated, type = " + reason.name());
            onEventTerminated(reason);
        }
        return condition;
    }

    public final void putExtra(String key, Object value) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        try {
            Result.Companion companion = Result.Companion;
            if (this.extra == null) {
                this.extra = new LinkedHashMap();
            }
            Map<String, Object> map = this.extra;
            Intrinsics.checkNotNull(map);
            map.put(key, value);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            ExceptionUtil.handleException(th2);
        }
    }

    private final boolean isEventStreamEnable() {
        return Switches.eventStream.isEnabled();
    }

    public final void onEventCreated() {
        if (isEventStreamEnable()) {
            HybridMonitorSingleExecutor.INSTANCE.execute(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.event.HybridEvent$onEventCreated$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m329invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m329invoke() {
                    HybridEvent.this.getListener().onEventCreated(HybridEvent.this);
                }
            });
        }
    }

    public final void onEventTerminated(TerminateType msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.state.setTerminateType(msg);
        if (isEventStreamEnable()) {
            HybridMonitorSingleExecutor.INSTANCE.execute(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.event.HybridEvent$onEventTerminated$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m331invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m331invoke() {
                    HybridEvent.this.getListener().onEventTerminated(HybridEvent.this);
                }
            });
        }
    }

    public final void onEventSampled() {
        if (isEventStreamEnable()) {
            HybridMonitorSingleExecutor.INSTANCE.execute(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.event.HybridEvent$onEventSampled$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m330invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m330invoke() {
                    HybridEvent.this.getListener().onEventSampled(HybridEvent.this);
                }
            });
        }
    }

    public final void onEventUploaded() {
        if (isEventStreamEnable()) {
            HybridMonitorSingleExecutor.INSTANCE.execute(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.event.HybridEvent$onEventUploaded$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m333invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m333invoke() {
                    HybridEvent.this.getListener().onEventUploaded(HybridEvent.this);
                }
            });
        }
    }

    public final void onEventUpdated() {
        if (isEventStreamEnable()) {
            HybridMonitorSingleExecutor.INSTANCE.execute(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.event.HybridEvent$onEventUpdated$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m332invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m332invoke() {
                    Utilities utilities = Utilities.INSTANCE;
                    HybridEvent hybridEvent = HybridEvent.this;
                    try {
                        hybridEvent.getListener().onEventUpdated(hybridEvent);
                    } catch (Throwable th) {
                        ExceptionUtil.handleException(th);
                    }
                }
            });
        }
    }

    public final List<String> getUriRegexInputList() {
        ContainerBase containerBase = this.containerBase;
        String safeOptStr = JsonUtils.safeOptStr(containerBase != null ? containerBase.toJsonObject() : null, "schema");
        String str = "";
        if (this instanceof CommonEvent) {
            if (this.nativeBase.url != null) {
                str = this.nativeBase.url;
            }
        } else if (this instanceof CustomEvent) {
            CustomEvent customEvent = (CustomEvent) this;
            if (customEvent.getCustomInfo().getUrl() != null) {
                str = customEvent.getCustomInfo().getUrl();
            }
        }
        return CollectionsKt.arrayListOf(new String[]{str, safeOptStr});
    }

    public String toString() {
        return "HybridEvent(eventType='" + this.eventType + "', eventId=" + getEventId() + ", state=" + this.state + ')';
    }

    /* compiled from: HybridEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/monitorV2/event/HybridEvent$State;", "", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "eventPhase", "Lcom/bytedance/android/monitorV2/event/HybridEvent$EventPhase;", "getEventPhase", "()Lcom/bytedance/android/monitorV2/event/HybridEvent$EventPhase;", "setEventPhase", "(Lcom/bytedance/android/monitorV2/event/HybridEvent$EventPhase;)V", "terminateType", "Lcom/bytedance/android/monitorV2/event/HybridEvent$TerminateType;", "getTerminateType", "()Lcom/bytedance/android/monitorV2/event/HybridEvent$TerminateType;", "setTerminateType", "(Lcom/bytedance/android/monitorV2/event/HybridEvent$TerminateType;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class State {
        private String description;
        private EventPhase eventPhase;
        private TerminateType terminateType;

        public final EventPhase getEventPhase() {
            return this.eventPhase;
        }

        public final void setEventPhase(EventPhase eventPhase) {
            this.eventPhase = eventPhase;
        }

        public final TerminateType getTerminateType() {
            return this.terminateType;
        }

        public final void setTerminateType(TerminateType terminateType) {
            this.terminateType = terminateType;
        }

        public final String getDescription() {
            return this.description;
        }

        public final void setDescription(String str) {
            this.description = str;
        }
    }
}
