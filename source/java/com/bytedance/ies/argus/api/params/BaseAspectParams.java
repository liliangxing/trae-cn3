package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.BaseStrategyParams;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: BaseAspectParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u000f\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0007R\u001d\u0010\u0005\u001a\u0004\u0018\u00018\u00008VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "REWRITE_PAYLOAD", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "Lcom/bytedance/ies/argus/strategy/BaseStrategyParams;", "()V", "rewritePayload", "getRewritePayload", "()Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "rewritePayload$delegate", "Lkotlin/Lazy;", "initRewritePayload", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public class BaseAspectParams<REWRITE_PAYLOAD extends BaseRewritePayload> extends BaseStrategyParams {

    /* renamed from: rewritePayload$delegate, reason: from kotlin metadata */
    private final Lazy rewritePayload = LazyKt.lazy(new Function0<REWRITE_PAYLOAD>(this) { // from class: com.bytedance.ies.argus.api.params.BaseAspectParams$rewritePayload$2
        final /* synthetic */ BaseAspectParams<REWRITE_PAYLOAD> this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TREWRITE_PAYLOAD; */
        @Override // kotlin.jvm.functions.Function0
        public final BaseRewritePayload invoke() {
            return this.this$0.initRewritePayload();
        }
    });

    public REWRITE_PAYLOAD initRewritePayload() {
        return null;
    }

    public REWRITE_PAYLOAD getRewritePayload() {
        return (REWRITE_PAYLOAD) this.rewritePayload.getValue();
    }
}
