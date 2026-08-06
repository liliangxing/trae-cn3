package com.bytedance.trae.conversation.network;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: CustomActivityRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/network/GeneralActivityResponse;", "Lcom/bytedance/trae/conversation/network/IGeneralActivityApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.network.CustomActivityRepository$fetchActivities$result$1", f = "CustomActivityRepository.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class CustomActivityRepository$fetchActivities$result$1 extends SuspendLambda implements Function2<IGeneralActivityApi, Continuation<? super GeneralActivityResponse>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomActivityRepository$fetchActivities$result$1(Continuation<? super CustomActivityRepository$fetchActivities$result$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> customActivityRepository$fetchActivities$result$1 = new CustomActivityRepository$fetchActivities$result$1(continuation);
        customActivityRepository$fetchActivities$result$1.L$0 = obj;
        return customActivityRepository$fetchActivities$result$1;
    }

    public final Object invoke(IGeneralActivityApi iGeneralActivityApi, Continuation<? super GeneralActivityResponse> continuation) {
        return create(iGeneralActivityApi, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((IGeneralActivityApi) this.L$0).getGeneralActivities(new MobileActivityRequest(0, 1, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
