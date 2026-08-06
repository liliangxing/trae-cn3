package com.bytedance.trae.conversation.ideproject;

import com.bytedance.trae.conversation.network.IGetProjectApi;
import com.bytedance.trae.conversation.network.ListProjectsData;
import com.bytedance.trae.conversation.network.RemoteResponse;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: IDEProjectBottomSheet.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/network/RemoteResponse;", "Lcom/bytedance/trae/conversation/network/ListProjectsData;", "Lcom/bytedance/trae/conversation/network/IGetProjectApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet$fetchProjects$1$result$1", f = "IDEProjectBottomSheet.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class IDEProjectBottomSheet$fetchProjects$1$result$1 extends SuspendLambda implements Function2<IGetProjectApi, Continuation<? super RemoteResponse<ListProjectsData>>, Object> {
    final /* synthetic */ String $cliId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IDEProjectBottomSheet$fetchProjects$1$result$1(String str, Continuation<? super IDEProjectBottomSheet$fetchProjects$1$result$1> continuation) {
        super(2, continuation);
        this.$cliId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iDEProjectBottomSheet$fetchProjects$1$result$1 = new IDEProjectBottomSheet$fetchProjects$1$result$1(this.$cliId, continuation);
        iDEProjectBottomSheet$fetchProjects$1$result$1.L$0 = obj;
        return iDEProjectBottomSheet$fetchProjects$1$result$1;
    }

    public final Object invoke(IGetProjectApi iGetProjectApi, Continuation<? super RemoteResponse<ListProjectsData>> continuation) {
        return create(iGetProjectApi, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((IGetProjectApi) this.L$0).listProjects(MapsKt.mapOf(TuplesKt.to("cli_id", this.$cliId)), (Continuation) this);
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
