package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.tenant.ContentSecurityMessageProcessResult;
import com.bytedance.trae.im.service.tenant.ContentSecurityMessageProcessor;
import com.bytedance.trae.im.service.tenant.TenantUserConfigResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$sendMessageIternal$2$processResult$1", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ConversationViewModel$sendMessageIternal$2$processResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ContentSecurityMessageProcessResult>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $requestQuery;
    final /* synthetic */ TenantUserConfigResponse $securityConfig;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$sendMessageIternal$2$processResult$1(Ref.ObjectRef<String> objectRef, TenantUserConfigResponse tenantUserConfigResponse, Continuation<? super ConversationViewModel$sendMessageIternal$2$processResult$1> continuation) {
        super(2, continuation);
        this.$requestQuery = objectRef;
        this.$securityConfig = tenantUserConfigResponse;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$sendMessageIternal$2$processResult$1(this.$requestQuery, this.$securityConfig, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ContentSecurityMessageProcessResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return ContentSecurityMessageProcessor.INSTANCE.processQuery((String) this.$requestQuery.element, this.$securityConfig.getSecurityRules());
    }
}
