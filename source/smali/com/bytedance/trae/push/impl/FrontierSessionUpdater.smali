# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/impl/FrontierSessionUpdater;
.super Ljava/lang/Object;
.source "FrontierSessionUpdater.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/push/impl/FrontierSessionUpdater;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/push/impl/FrontierSessionUpdater;
    invoke-direct v0, Lcom/bytedance/trae/push/impl/FrontierSessionUpdater;-><init>()V
    sput-object v0, Lcom/bytedance/trae/push/impl/FrontierSessionUpdater;->INSTANCE Lcom/bytedance/trae/push/impl/FrontierSessionUpdater;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final notifySessionIdChanged()void
    .registers 6
    # ins_size=1
    const-string v0, "FrontierSessionUpdater"
    const-string/jumbo v1, notifySessionIdChanged sessionId=
    sget-object v2, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getSessionId()Ljava/lang/String;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    check-cast v3, Landroid/content/Context;
    invoke-static v3, Lcom/bytedance/push/frontier/FrontierPush;->getIns(Landroid/content/Context;)Lcom/bytedance/push/frontier/FrontierPush;
    move-result-object v3
    if-eqz v3, +005h
    invoke-virtual v3, v2, Lcom/bytedance/push/frontier/FrontierPush;->updateSessionId(Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +1bh
    move-exception v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, notifySessionIdChanged error: 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x5
.end method
