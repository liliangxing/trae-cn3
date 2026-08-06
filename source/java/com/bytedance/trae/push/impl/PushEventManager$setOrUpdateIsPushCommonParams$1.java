package com.bytedance.trae.push.impl;

import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.push.api.PushConst;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PushEventManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.push.impl.PushEventManager$setOrUpdateIsPushCommonParams$1", f = "PushEventManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class PushEventManager$setOrUpdateIsPushCommonParams$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $isPush;
    final /* synthetic */ String $pushContentType;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushEventManager$setOrUpdateIsPushCommonParams$1(int i, String str, Continuation<? super PushEventManager$setOrUpdateIsPushCommonParams$1> continuation) {
        super(2, continuation);
        this.$isPush = i;
        this.$pushContentType = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushEventManager$setOrUpdateIsPushCommonParams$1(this.$isPush, this.$pushContentType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        IApplog.Companion.setHeaderInfo(PushConst.KEY_PARAM_IS_PUSH, Boxing.boxInt(this.$isPush));
        IApplog.Companion.setHeaderInfo(PushConst.KEY_PARAM_PUSH_CONTENT_TYPE, this.$pushContentType);
        return Unit.INSTANCE;
    }
}
