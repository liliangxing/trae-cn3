# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final synthetic Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider$1;
.super Lkotlin/jvm/internal/MutablePropertyReference0Impl;
.source "AndroidKmpHttpClientFactory.kt"


.method constructor <init>(java.lang.Object)void
    .registers 8
    # ins_size=2
    const-class v2, Lcom/bytedance/trae/network/DebugSettings;
    const-string/jumbo v3, notificationBoe
    const-string v4, "getNotificationBoe()Z"
    const/4 v5, 0
    move-object v0, v6
    move-object v1, v7
    invoke-direct/range v0 ... v5, Lkotlin/jvm/internal/MutablePropertyReference0Impl;-><init>(Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public get()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider$1;->receiver Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v0, Lcom/bytedance/trae/network/DebugSettings;->getNotificationBoe()Z
    move-result v0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
.end method

.method public set(java.lang.Object)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider$1;->receiver Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/network/DebugSettings;
    check-cast v2, Ljava/lang/Boolean;
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    invoke-virtual v0, v2, Lcom/bytedance/trae/network/DebugSettings;->setNotificationBoe(Z)V
    return-void 
.end method
