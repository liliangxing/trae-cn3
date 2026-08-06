package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CliListSource;
import com.bytedance.trae.im.service.IListClisService;
import com.bytedance.trae.im.service.ListClisResponse;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/ListClisResponse;", "Lcom/bytedance/trae/im/service/IListClisService;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.DefaultCliListService$listClis$2", f = "CliListRepository.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class DefaultCliListService$listClis$2 extends SuspendLambda implements Function2<IListClisService, Continuation<? super BizResponse<ListClisResponse>>, Object> {
    final /* synthetic */ CliListSource $source;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultCliListService$listClis$2(CliListSource cliListSource, Continuation<? super DefaultCliListService$listClis$2> continuation) {
        super(2, continuation);
        this.$source = cliListSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> defaultCliListService$listClis$2 = new DefaultCliListService$listClis$2(this.$source, continuation);
        defaultCliListService$listClis$2.L$0 = obj;
        return defaultCliListService$listClis$2;
    }

    public final Object invoke(IListClisService iListClisService, Continuation<? super BizResponse<ListClisResponse>> continuation) {
        return create(iListClisService, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = IListClisService.DefaultImpls.listClis$default((IListClisService) this.L$0, this.$source.getValue(), 0, 0, (Continuation) this, 6, null);
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
