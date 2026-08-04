# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$imageUploadServiceDelegate$1$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormAttachmentManager.kt"

.implements Lkotlin/jvm/functions/Function1;

.field  label:I


.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 1
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$imageUploadServiceDelegate$1$2;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$imageUploadServiceDelegate$1$2;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$imageUploadServiceDelegate$1$2;->invoke(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$imageUploadServiceDelegate$1$2;->create(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$imageUploadServiceDelegate$1$2;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$imageUploadServiceDelegate$1$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$imageUploadServiceDelegate$1$2;->label I
    if-nez v0, +022h
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v2
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v2, v0, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v2, +00eh
    invoke-interface v2, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v2
    if-eqz v2, +008h
    invoke-virtual v2, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    return-object v2
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v2, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
.end method
