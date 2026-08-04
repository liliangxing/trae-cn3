# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/service/ApplogServiceImpl$addApplogIdCallback$1;
.super Ljava/lang/Object;
.source "ApplogServiceImpl.kt"

.implements Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;

.field final synthetic $callback:Lcom/bytedance/trae/platform/api/IApplogIdCallback;


.method constructor <init>(com.bytedance.trae.platform.api.IApplogIdCallback)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/service/ApplogServiceImpl$addApplogIdCallback$1;->$callback Lcom/bytedance/trae/platform/api/IApplogIdCallback;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onGetId(java.lang.String  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=4
    const-string v0, "did"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "iid"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, ssid
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/service/ApplogServiceImpl$addApplogIdCallback$1;->$callback Lcom/bytedance/trae/platform/api/IApplogIdCallback;
    invoke-interface v0, v2, v3, v4, Lcom/bytedance/trae/platform/api/IApplogIdCallback;->onGetId(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/service/ApplogServiceImpl$addApplogIdCallback$1;->$callback Lcom/bytedance/trae/platform/api/IApplogIdCallback;
    invoke-interface v2, Lcom/bytedance/trae/platform/api/IApplogIdCallback;->onlyOnce()Z
    move-result v2
    if-eqz v2, +00ah
    sget-object v2, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    invoke-virtual v2, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->removeDidListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    return-void 
.end method
