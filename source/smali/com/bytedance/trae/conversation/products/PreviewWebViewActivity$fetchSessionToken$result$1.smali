# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "PreviewWebViewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatSessionId:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;->$chatSessionId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;->$chatSessionId Ljava/lang/String;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.im.service.IChatSessionAuthApi  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/im/service/IChatSessionAuthApi;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;->invoke(Lcom/bytedance/trae/im/service/IChatSessionAuthApi; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +22h
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;->L$0 Ljava/lang/Object;
    move-object v3, v10
    check-cast v3, Lcom/bytedance/trae/im/service/IChatSessionAuthApi;
    iget-object v4, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;->$chatSessionId Ljava/lang/String;
    const/4 v5, 0
    move-object v6, v9
    check-cast v6, Lkotlin/coroutines/Continuation;
    const/4 v7, 2
    const/4 v8, 0
    iput v2, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;->label I
    invoke-static/range v3 ... v8, Lcom/bytedance/trae/im/service/IChatSessionAuthApi$DefaultImpls;->issueSessionToken$default(Lcom/bytedance/trae/im/service/IChatSessionAuthApi; Ljava/lang/String; Lcom/bytedance/trae/im/service/IssueSessionTokenRequest; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    return-object v10
.end method
