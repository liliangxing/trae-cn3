package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CliMutationResponse;
import com.bytedance.trae.im.service.IListClisService;
import com.bytedance.trae.im.service.RenameCliRequest;
import com.bytedance.trae.network.response.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: CliListRepository.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/CliMutationResponse;", "Lcom/bytedance/trae/im/service/IListClisService;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.DefaultCliListService$renameCli$2", f = "CliListRepository.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class DefaultCliListService$renameCli$2 extends SuspendLambda implements Function2<IListClisService, Continuation<? super BizResponse<CliMutationResponse>>, Object> {
    final /* synthetic */ String $cliId;
    final /* synthetic */ String $name;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultCliListService$renameCli$2(String str, String str2, Continuation<? super DefaultCliListService$renameCli$2> continuation) {
        super(2, continuation);
        this.$cliId = str;
        this.$name = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> defaultCliListService$renameCli$2 = new DefaultCliListService$renameCli$2(this.$cliId, this.$name, continuation);
        defaultCliListService$renameCli$2.L$0 = obj;
        return defaultCliListService$renameCli$2;
    }

    public final Object invoke(IListClisService iListClisService, Continuation<? super BizResponse<CliMutationResponse>> continuation) {
        return create(iListClisService, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((IListClisService) this.L$0).renameCli(new RenameCliRequest(this.$cliId, this.$name), (Continuation) this);
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
