# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "PluginConnectorOAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $appContext:Landroid/content/Context;
.field final synthetic $authorizeUrl:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  android.content.Context  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;->$authorizeUrl Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;->$appContext Landroid/content/Context;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;->$authorizeUrl Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;->$appContext Landroid/content/Context;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;-><init>(Ljava/lang/String; Landroid/content/Context; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;->label I
    if-nez v0, +01fh
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v3, Landroid/content/Intent;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;->$authorizeUrl Ljava/lang/String;
    invoke-static v0, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v0
    const-string v1, "android.intent.action.VIEW"
    invoke-direct v3, v1, v0, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    const/high16 v0, 268435456
    invoke-virtual v3, v0, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;->$appContext Landroid/content/Context;
    invoke-virtual v0, v3, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
