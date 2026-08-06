package com.bytedance.ies.argus.aspect.eventCenter;

import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.strategy.BaseStrategyParams;
import com.bytedance.ies.argus.util.CommonUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseRuntimeContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\b\u0010\u0016\u001a\u00020\u0004H&R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\r\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/BaseRuntimeContext;", "Lcom/bytedance/ies/argus/strategy/BaseStrategyParams;", "()V", "<set-?>", "", "argusBizId", "getArgusBizId", "()Ljava/lang/String;", "argusSceneTag", "getArgusSceneTag", "setArgusSceneTag", "(Ljava/lang/String;)V", "traceId", "getTraceId", "traceId$delegate", "Lkotlin/Lazy;", "updateArgusBizId", "", "id", "updateFrom", "updateArgusSceneTag", Api.COL_TAG, "updateContextLogTag", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseRuntimeContext extends BaseStrategyParams {
    private String argusBizId;
    private String argusSceneTag;

    /* renamed from: traceId$delegate, reason: from kotlin metadata */
    private final Lazy traceId = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.ies.argus.aspect.eventCenter.BaseRuntimeContext$traceId$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        public final String invoke() {
            return CommonUtils.INSTANCE.getObjectId(BaseRuntimeContext.this);
        }
    });

    public abstract String updateContextLogTag();

    public final String getTraceId() {
        return (String) this.traceId.getValue();
    }

    public final String getArgusBizId() {
        return this.argusBizId;
    }

    public final String getArgusSceneTag() {
        return this.argusSceneTag;
    }

    public final void setArgusSceneTag(String str) {
        this.argusSceneTag = str;
    }

    public final void updateArgusBizId(String id, String updateFrom) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(updateFrom, "updateFrom");
        this.argusBizId = id;
        ArgusLog.i$default(ArgusLog.INSTANCE, "RuntimeContext", "set " + updateContextLogTag() + " argus_biz_id=" + id + ", update from: " + updateFrom, null, 4, null);
    }

    public final void updateArgusSceneTag(String tag, String updateFrom) {
        Intrinsics.checkNotNullParameter(tag, Api.COL_TAG);
        Intrinsics.checkNotNullParameter(updateFrom, "updateFrom");
        this.argusSceneTag = tag;
        ArgusLog.i$default(ArgusLog.INSTANCE, "RuntimeContext", "set " + updateContextLogTag() + " argus_scene=" + tag + ", update from: " + updateFrom, null, 4, null);
    }
}
