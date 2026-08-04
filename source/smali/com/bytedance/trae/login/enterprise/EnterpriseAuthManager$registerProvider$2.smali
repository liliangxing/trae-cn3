# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final synthetic Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$registerProvider$2;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "EnterpriseAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;
.implements Lkotlin/coroutines/jvm/internal/SuspendFunction;


.method constructor <init>(java.lang.Object)void
    .registers 9
    # ins_size=2
    const/4 v1, 2
    const-class v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;
    const-string/jumbo v4, refreshEnterpriseUserInfo
    const-string/jumbo v5, refreshEnterpriseUserInfo(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    const/4 v6, 0
    move-object v0, v7
    move-object v2, v8
    invoke-direct/range v0 ... v6, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/String;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$registerProvider$2;->invoke(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$registerProvider$2;->receiver Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->access$refreshEnterpriseUserInfo(Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method
