# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SiteMessageRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $action:Ljava/lang/String;
.field final synthetic $ids:Ljava/util/List;
.field final synthetic $onFailure:Lkotlin/jvm/functions/Function0;
.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function0;
.field  label:I


.method constructor <init>(java.util.List  java.lang.String  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->$ids Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->$action Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->$onFailure Lkotlin/jvm/functions/Function0;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->$ids Ljava/util/List;
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->$action Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    iget-object v4, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->$onFailure Lkotlin/jvm/functions/Function0;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;-><init>(Ljava/util/List; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2fh
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v13, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;->Companion Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;->createService()Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;
    move-result-object v13
    new-instance v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;
    iget-object v4, v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->$ids Ljava/util/List;
    iget-object v5, v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->$action Ljava/lang/String;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 60
    const/4 v11, 0
    move-object v3, v1
    invoke-direct/range v3 ... v11, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v3, v12
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->label I
    invoke-interface v13, v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;->updateStatus(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    iget-object v13, v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    if-eqz v13, +00dh
    invoke-interface v13, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +8h
    iget-object v13, v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;->$onFailure Lkotlin/jvm/functions/Function0;
    if-eqz v13, +005h
    invoke-interface v13, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
    :try_start_0xb
    :try_start_0x1a
.end method
