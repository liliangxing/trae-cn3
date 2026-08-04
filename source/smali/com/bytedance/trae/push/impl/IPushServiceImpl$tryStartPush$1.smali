# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/impl/IPushServiceImpl$tryStartPush$1;
.super Ljava/lang/Object;
.source "IPushServiceImpl.kt"

.implements Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onGetId(java.lang.String  java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=4
    const-string v0, "did"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "iid"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, ssid
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->removeDidListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v0
    invoke-interface v0, v3, v4, v5, Lcom/bytedance/push/interfaze/IPushService;->start(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/push/impl/PushEventManager;->INSTANCE Lcom/bytedance/trae/push/impl/PushEventManager;
    invoke-virtual v3, Lcom/bytedance/trae/push/impl/PushEventManager;->reportPushEventWhenColdStart()V
    return-void 
.end method
