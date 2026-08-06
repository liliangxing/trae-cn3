package com.bytedance.ies.argus.bean;

import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.BaseStrategyParams;
import com.bytedance.ies.argus.util.ArgusGsonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AspectVerifyResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 T*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003:\u0002TUB\u001b\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u0003J\"\u0010E\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00142\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030 J8\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00101\u001a\u00020&2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0016\b\u0002\u0010G\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020B\u0018\u00010HJ1\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00101\u001a\u00020&2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010KJ1\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00101\u001a\u00020&2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010KJE\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00101\u001a\u00020&2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u001b2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020B0H¢\u0006\u0002\u0010NJ1\u0010O\u001a\u00020B2\u0006\u0010\n\u001a\u00020\t2\u0006\u00101\u001a\u00020&2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010+\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010PJ\u000e\u0010Q\u001a\u00020R2\u0006\u0010\n\u001a\u00020\tJ\b\u0010S\u001a\u00020\u0014H\u0016R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\r@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R<\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u00132\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0013@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fRT\u0010!\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030 0\u00132\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030 0\u0013@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R \u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010-\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b-\u0010\u001dR\u0011\u0010.\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b.\u0010\u001dR\u0011\u0010/\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b/\u0010\u001dR\u0011\u00100\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b0\u0010\u001dR$\u00101\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0014@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u0002062\u0006\u0010\b\u001a\u000206@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140%X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010=\u001a\u0004\u0018\u00018\u00002\b\u0010\b\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "REWRITE_PAYLOAD", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "", "initRewritePayload", "verifyMode", "Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "(Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;Lcom/bytedance/ies/argus/bean/ArgusSwitch;)V", "<set-?>", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "action", "getAction", "()Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "", "cost", "getCost", "()J", "setCost$anniex_release", "(J)V", "", "", "extra", "getExtra", "()Ljava/util/Map;", "setExtra$anniex_release", "(Ljava/util/Map;)V", "hasSetRealResult", "", "getHasSetRealResult$anniex_release", "()Z", "setHasSetRealResult$anniex_release", "(Z)V", "", "info", "getInfo", "setInfo$anniex_release", "innerErrorCodeTrace", "", "Lcom/bytedance/ies/argus/bean/IArgusVerifyReason;", "getInnerErrorCodeTrace$anniex_release", "()Ljava/util/List;", "setInnerErrorCodeTrace$anniex_release", "(Ljava/util/List;)V", "interrupt", "getInterrupt", "isBlock", "isPass", "isReasonCodeUnset", "isRewrite", "reason", "getReason", "()Ljava/lang/String;", "setReason$anniex_release", "(Ljava/lang/String;)V", "", "reasonCode", "getReasonCode", "()I", "setReasonCode$anniex_release", "(I)V", "reasonTrace", "rewritePayload", "getRewritePayload", "()Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "addExtra", "", Api.KEY_ENCRYPT_RESP_KEY, "value", "addInfo", "onBlock", "rewrite", "Lkotlin/Function1;", "onError", "isInterrupt", "(Lcom/bytedance/ies/argus/bean/IArgusVerifyReason;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "onPass", "onRewrite", "(Lcom/bytedance/ies/argus/bean/IArgusVerifyReason;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "setResult", "(Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;Lcom/bytedance/ies/argus/bean/IArgusVerifyReason;Ljava/lang/String;Ljava/lang/Boolean;)V", "toMonitorObject", "Lorg/json/JSONObject;", "toString", "Companion", "TTMDataHandler", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class AspectVerifyResult<REWRITE_PAYLOAD extends BaseRewritePayload> {
    public static final String TAG = "AspectVerifyResult";
    private ArgusVerifyAction action;
    private long cost;
    private Map<String, Object> extra;
    private boolean hasSetRealResult;
    private Map<String, Map<String, Object>> info;
    private List<IArgusVerifyReason> innerErrorCodeTrace;
    private boolean interrupt;
    private String reason;
    private int reasonCode;
    private final List<String> reasonTrace;
    private REWRITE_PAYLOAD rewritePayload;
    private final ArgusSwitch verifyMode;

    /* JADX WARN: Multi-variable type inference failed */
    public AspectVerifyResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public AspectVerifyResult(REWRITE_PAYLOAD rewrite_payload, ArgusSwitch argusSwitch) {
        Intrinsics.checkNotNullParameter(argusSwitch, "verifyMode");
        this.verifyMode = argusSwitch;
        this.action = ArgusVerifyAction.PASS;
        this.rewritePayload = rewrite_payload;
        this.reason = ArgusCommonVerifyReason.UN_SET.getStrValue();
        this.reasonCode = ArgusCommonVerifyReason.UN_SET.getCode();
        this.info = new LinkedHashMap();
        this.extra = new LinkedHashMap();
        this.cost = -1L;
        this.reasonTrace = new ArrayList();
        this.innerErrorCodeTrace = new ArrayList();
    }

    public /* synthetic */ AspectVerifyResult(BaseRewritePayload baseRewritePayload, ArgusSwitch argusSwitch, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : baseRewritePayload, (i & 2) != 0 ? new ArgusSwitch(2) : argusSwitch);
    }

    public final ArgusVerifyAction getAction() {
        return this.action;
    }

    public final REWRITE_PAYLOAD getRewritePayload() {
        return this.rewritePayload;
    }

    public final boolean getInterrupt() {
        return this.interrupt;
    }

    public final String getReason() {
        return this.reason;
    }

    public final void setReason$anniex_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reason = str;
    }

    public final int getReasonCode() {
        return this.reasonCode;
    }

    public final void setReasonCode$anniex_release(int i) {
        this.reasonCode = i;
    }

    public final Map<String, Map<String, Object>> getInfo() {
        return this.info;
    }

    public final void setInfo$anniex_release(Map<String, Map<String, Object>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.info = map;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final void setExtra$anniex_release(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extra = map;
    }

    public final long getCost() {
        return this.cost;
    }

    public final void setCost$anniex_release(long j) {
        this.cost = j;
    }

    public final boolean isPass() {
        return this.action == ArgusVerifyAction.PASS;
    }

    public final boolean isRewrite() {
        return this.action == ArgusVerifyAction.REWRITE;
    }

    public final boolean isBlock() {
        return this.action == ArgusVerifyAction.BLOCK;
    }

    public final boolean isReasonCodeUnset() {
        return this.reasonCode == ArgusCommonVerifyReason.UN_SET.getCode();
    }

    public final List<IArgusVerifyReason> getInnerErrorCodeTrace$anniex_release() {
        return this.innerErrorCodeTrace;
    }

    public final void setInnerErrorCodeTrace$anniex_release(List<IArgusVerifyReason> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.innerErrorCodeTrace = list;
    }

    /* renamed from: getHasSetRealResult$anniex_release, reason: from getter */
    public final boolean getHasSetRealResult() {
        return this.hasSetRealResult;
    }

    public final void setHasSetRealResult$anniex_release(boolean z) {
        this.hasSetRealResult = z;
    }

    public final void addInfo(String key, Map<String, ? extends Object> value) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        this.info.put(key, value);
    }

    public final void addExtra(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        this.extra.put(key, value);
    }

    public static /* synthetic */ AspectVerifyResult onPass$default(AspectVerifyResult aspectVerifyResult, IArgusVerifyReason iArgusVerifyReason, String str, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        return aspectVerifyResult.onPass(iArgusVerifyReason, str, bool);
    }

    public final AspectVerifyResult<REWRITE_PAYLOAD> onPass(IArgusVerifyReason reason, String extra, Boolean isInterrupt) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        setResult(ArgusVerifyAction.PASS, reason, extra, isInterrupt);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AspectVerifyResult onBlock$default(AspectVerifyResult aspectVerifyResult, IArgusVerifyReason iArgusVerifyReason, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return aspectVerifyResult.onBlock(iArgusVerifyReason, str, function1);
    }

    public final AspectVerifyResult<REWRITE_PAYLOAD> onBlock(IArgusVerifyReason reason, String extra, Function1<? super REWRITE_PAYLOAD, Unit> rewrite) {
        REWRITE_PAYLOAD rewrite_payload;
        Intrinsics.checkNotNullParameter(reason, "reason");
        setResult(ArgusVerifyAction.BLOCK, reason, extra, true);
        if (rewrite != null && (rewrite_payload = this.rewritePayload) != null) {
            rewrite.invoke(rewrite_payload);
        }
        return this;
    }

    public static /* synthetic */ AspectVerifyResult onRewrite$default(AspectVerifyResult aspectVerifyResult, IArgusVerifyReason iArgusVerifyReason, String str, Boolean bool, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        return aspectVerifyResult.onRewrite(iArgusVerifyReason, str, bool, function1);
    }

    public final AspectVerifyResult<REWRITE_PAYLOAD> onRewrite(IArgusVerifyReason reason, String extra, Boolean isInterrupt, Function1<? super REWRITE_PAYLOAD, Unit> rewrite) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(rewrite, "rewrite");
        setResult(ArgusVerifyAction.REWRITE, reason, extra, isInterrupt);
        REWRITE_PAYLOAD rewrite_payload = this.rewritePayload;
        if (rewrite_payload != null) {
            rewrite.invoke(rewrite_payload);
        }
        return this;
    }

    public static /* synthetic */ AspectVerifyResult onError$default(AspectVerifyResult aspectVerifyResult, IArgusVerifyReason iArgusVerifyReason, String str, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        return aspectVerifyResult.onError(iArgusVerifyReason, str, bool);
    }

    public final AspectVerifyResult<REWRITE_PAYLOAD> onError(IArgusVerifyReason reason, String extra, Boolean isInterrupt) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.reasonTrace.add(extra != null ? reason.getStrValue() + ": " + extra : reason.getStrValue());
        this.innerErrorCodeTrace.add(reason);
        if (isInterrupt != null) {
            this.interrupt = isInterrupt.booleanValue();
        }
        return this;
    }

    private final void setResult(ArgusVerifyAction action, IArgusVerifyReason reason, String extra, Boolean interrupt) {
        String strValue = extra != null ? reason.getStrValue() + ": " + extra : reason.getStrValue();
        this.reasonTrace.add(strValue);
        if (interrupt != null) {
            this.interrupt = interrupt.booleanValue();
        }
        this.action = action;
        this.reason = strValue;
        this.reasonCode = reason.getCode();
        this.hasSetRealResult = true;
    }

    /* compiled from: AspectVerifyResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/argus/bean/AspectVerifyResult$TTMDataHandler;", "Lcom/bytedance/ies/argus/strategy/BaseStrategyParams;", "ruleName", "", "(Lcom/bytedance/ies/argus/bean/AspectVerifyResult;Ljava/lang/String;)V", "getRuleName", "()Ljava/lang/String;", "ttmGetValue", "", Api.KEY_ENCRYPT_RESP_KEY, "ttmSetValue", "", "value", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final class TTMDataHandler extends BaseStrategyParams {
        private final String ruleName;
        final /* synthetic */ AspectVerifyResult<REWRITE_PAYLOAD> this$0;

        public TTMDataHandler(AspectVerifyResult aspectVerifyResult, String str) {
            Intrinsics.checkNotNullParameter(str, "ruleName");
            this.this$0 = aspectVerifyResult;
            this.ruleName = str;
        }

        public final String getRuleName() {
            return this.ruleName;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0012. Please report as an issue. */
        @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
        public boolean ttmSetValue(String key, Object value) {
            REWRITE_PAYLOAD rewritePayload;
            Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
            Intrinsics.checkNotNullParameter(value, "value");
            boolean z = false;
            switch (key.hashCode()) {
                case -1422950858:
                    if (key.equals("action")) {
                        if (Intrinsics.areEqual(value, ArgusVerifyAction.PASS.getStrValue())) {
                            ((AspectVerifyResult) this.this$0).action = ArgusVerifyAction.PASS;
                            return true;
                        }
                        if (Intrinsics.areEqual(value, ArgusVerifyAction.REWRITE.getStrValue())) {
                            ((AspectVerifyResult) this.this$0).action = ArgusVerifyAction.REWRITE;
                            return true;
                        }
                        if (Intrinsics.areEqual(value, ArgusVerifyAction.BLOCK.getStrValue())) {
                            ((AspectVerifyResult) this.this$0).action = ArgusVerifyAction.BLOCK;
                            return true;
                        }
                    }
                    return z;
                case -934964668:
                    if (key.equals("reason")) {
                        String str = value instanceof String ? (String) value : null;
                        if (str != null) {
                            this.this$0.setReason$anniex_release(str);
                            return true;
                        }
                    }
                    return z;
                case 3237038:
                    if (key.equals("info")) {
                        HashMap hashMap = value instanceof HashMap ? (HashMap) value : null;
                        if (hashMap != null) {
                            this.this$0.addInfo(this.ruleName, hashMap);
                            return true;
                        }
                    }
                    return z;
                case 556642914:
                    if (key.equals("rewritePayload")) {
                        HashMap hashMap2 = value instanceof HashMap ? (HashMap) value : null;
                        if (hashMap2 != null && (rewritePayload = this.this$0.getRewritePayload()) != null) {
                            for (Map.Entry entry : hashMap2.entrySet()) {
                                Object key2 = entry.getKey();
                                Object value2 = entry.getValue();
                                if ((key2 instanceof String ? (String) key2 : null) != null && value2 != null) {
                                    Intrinsics.checkNotNullExpressionValue(key2, "k");
                                    z = rewritePayload.setValue((String) key2, value2);
                                }
                            }
                        }
                    }
                    return z;
                case 722137681:
                    if (key.equals("reasonCode")) {
                        Integer num = value instanceof Integer ? (Integer) value : null;
                        if (num != null) {
                            this.this$0.setReasonCode$anniex_release(num.intValue());
                            return true;
                        }
                    }
                    return z;
                default:
                    return z;
            }
        }

        @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
        public Object ttmGetValue(String key) {
            Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
            int hashCode = key.hashCode();
            if (hashCode != -1422950858) {
                if (hashCode != 3237038) {
                    if (hashCode == 556642914 && key.equals("rewritePayload")) {
                        REWRITE_PAYLOAD rewritePayload = this.this$0.getRewritePayload();
                        if (rewritePayload != null) {
                            return rewritePayload.getInnerData$anniex_release();
                        }
                        return null;
                    }
                } else if (key.equals("info")) {
                    return this.this$0.getInfo();
                }
            } else if (key.equals("action")) {
                return this.this$0.getAction().getStrValue();
            }
            return Unit.INSTANCE;
        }
    }

    public final JSONObject toMonitorObject(ArgusVerifyAction action) {
        List list;
        Intrinsics.checkNotNullParameter(action, "action");
        Map map = MapsKt.toMap(this.extra);
        JSONObject jSONObject = new JSONObject();
        JSONUtilsKt.safelyPut(jSONObject, "action", action.getStrValue());
        JSONUtilsKt.safelyPut(jSONObject, "reason_code", Integer.valueOf(this.reasonCode));
        JSONUtilsKt.safelyPut(jSONObject, "reason", this.reason);
        List<String> list2 = this.reasonTrace;
        if (!(list2.size() > 1)) {
            list2 = null;
        }
        JSONUtilsKt.safelyPut(jSONObject, "reason_trace", (list2 == null || (list = CollectionsKt.toList(list2)) == null) ? null : CollectionsKt.joinToString$default(list, ">", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        Map map2 = MapsKt.toMap(this.info);
        if (!(!map2.isEmpty())) {
            map2 = null;
        }
        JSONUtilsKt.safelyPut(jSONObject, "info", map2 != null ? ArgusGsonUtils.INSTANCE.safeToJSONObject$anniex_release(map2) : null);
        REWRITE_PAYLOAD rewrite_payload = this.rewritePayload;
        JSONUtilsKt.safelyPut(jSONObject, "rewrite_payload", rewrite_payload != null ? rewrite_payload.toString() : null);
        for (Map.Entry entry : map.entrySet()) {
            JSONUtilsKt.safelyPut(jSONObject, (String) entry.getKey(), ArgusGsonUtils.INSTANCE.safeToString$anniex_release(entry.getValue()));
        }
        return jSONObject;
    }

    public String toString() {
        REWRITE_PAYLOAD rewrite_payload = this.rewritePayload;
        if (rewrite_payload != null) {
            JSONObject monitorObject = rewrite_payload.toMonitorObject(this.action);
            if (monitorObject != null) {
                rewrite_payload = monitorObject;
            }
        } else {
            rewrite_payload = null;
        }
        return "action=" + this.action.getStrValue() + ",payload=" + rewrite_payload + ",reason=" + this.reason;
    }
}
