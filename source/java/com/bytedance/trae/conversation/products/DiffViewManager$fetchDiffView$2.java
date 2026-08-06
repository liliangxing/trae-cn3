package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.DiffViewResponse;
import com.bytedance.trae.im.service.IDiffViewApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: DiffViewManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/im/service/DiffViewResponse;", "Lcom/bytedance/trae/im/service/IDiffViewApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.DiffViewManager$fetchDiffView$2", f = "DiffViewManager.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class DiffViewManager$fetchDiffView$2 extends SuspendLambda implements Function2<IDiffViewApi, Continuation<? super DiffViewResponse>, Object> {
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ Ref.ObjectRef<String> $fileName;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiffViewManager$fetchDiffView$2(Ref.ObjectRef<String> objectRef, String str, Continuation<? super DiffViewManager$fetchDiffView$2> continuation) {
        super(2, continuation);
        this.$fileName = objectRef;
        this.$chatSessionId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> diffViewManager$fetchDiffView$2 = new DiffViewManager$fetchDiffView$2(this.$fileName, this.$chatSessionId, continuation);
        diffViewManager$fetchDiffView$2.L$0 = obj;
        return diffViewManager$fetchDiffView$2;
    }

    public final Object invoke(IDiffViewApi iDiffViewApi, Continuation<? super DiffViewResponse> continuation) {
        return create(iDiffViewApi, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((IDiffViewApi) this.L$0).getDiffView((String) this.$fileName.element, this.$chatSessionId, (Continuation) this);
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
