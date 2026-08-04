# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/impl/IPushServiceImpl$callback$1;
.super Ljava/lang/Object;
.source "IPushServiceImpl.kt"

.implements Lcom/bytedance/push/interfaze/IRequestNotificationPermissionCallback;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onPermissionDenied()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "IPushServiceImpl"
    const-string v2, "Notification permission denied"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->INSTANCE Lcom/bytedance/trae/push/impl/PushHelper;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/push/impl/PushHelper;->setLastRequestNotificationPermissionTimestamp(J)V
    return-void 
.end method

.method public onPermissionGranted()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "IPushServiceImpl"
    const-string v2, "Notification permission granted"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
