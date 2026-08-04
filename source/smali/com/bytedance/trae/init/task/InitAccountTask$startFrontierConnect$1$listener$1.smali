# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitAccountTask$startFrontierConnect$1$listener$1;
.super Ljava/lang/Object;
.source "InitAccountTask.kt"

.implements Lcom/bytedance/trae/network/HubConnectionListener;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onRegisterSuccess()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/IChangeLanguageApi;->Companion Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;
    const/4 v1, 0
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;->syncLanguage$default(Lcom/bytedance/trae/network/IChangeLanguageApi$Companion; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method
