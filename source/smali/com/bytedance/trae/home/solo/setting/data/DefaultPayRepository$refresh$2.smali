# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "PayRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;


.method constructor <init>(com.bytedance.trae.home.solo.setting.data.DefaultPayRepository  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;->label I
    const/4 v2, 1
    if-eqz v1, +012h
    if-ne v1, v2, +008h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2eh
    move-exception v4
    goto +33h
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;->L$0 Ljava/lang/Object;
    check-cast v4, Lkotlinx/coroutines/CoroutineScope;
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;
    invoke-static v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->access$getHostInfo$p(Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;)Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v4
    invoke-interface v4, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isPublicCloud()Z
    move-result v4
    if-nez v4, +005h
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    iput v2, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;->label I
    invoke-static v4, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->access$fetchPayStatus(Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +bh
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;
    if-nez v4, +005h
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->getEffectiveUserPayIdentityStr()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +00ch
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, ""
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +004h
    const-string v1, "Free"
    check-cast v1, Ljava/lang/String;
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;
    invoke-static v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->access$get_payIdentity$p(Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/PayIdentity;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayIdentity;-><init>(Ljava/lang/String;)V
    invoke-interface v4, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    :try_start_0xb
    :try_start_0x31
.end method
