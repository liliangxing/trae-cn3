# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $requestQuery:Lkotlin/jvm/internal/Ref$ObjectRef;
.field final synthetic $securityConfig:Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
.field  label:I


.method constructor <init>(kotlin.jvm.internal.Ref$ObjectRef  com.bytedance.trae.im.service.tenant.TenantUserConfigResponse  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;->$requestQuery Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;->$securityConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;->$requestQuery Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;->$securityConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;-><init>(Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;->label I
    if-nez v0, +018h
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;->$requestQuery Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v0, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;->$securityConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getSecurityRules()Ljava/util/List;
    move-result-object v1
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;->processQuery(Ljava/lang/String; Ljava/util/List;)Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;
    move-result-object v3
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
