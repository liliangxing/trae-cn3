# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/AppLogHelper$doWhenIdsReady$1;
.super Ljava/lang/Object;
.source "AppLogHelper.kt"

.implements Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;

.field final synthetic $action:Lkotlin/jvm/functions/Function2;


.method constructor <init>(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$doWhenIdsReady$1;->$action Lkotlin/jvm/functions/Function2;
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
    sget-object v4, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    const-string v0, "onGetId"
    invoke-static v4, v2, v3, v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->access$updateBdTuringId(Lcom/bytedance/trae/applog/impl/AppLogHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper$doWhenIdsReady$1;->$action Lkotlin/jvm/functions/Function2;
    invoke-interface v4, v2, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    invoke-virtual v2, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->removeDidListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    return-void 
.end method
