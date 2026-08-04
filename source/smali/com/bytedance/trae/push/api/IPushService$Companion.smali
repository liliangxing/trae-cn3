# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/api/IPushService$Companion;
.super Ljava/lang/Object;
.source "IPushService.kt"

.implements Lcom/bytedance/trae/push/api/IPushService;

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/push/api/IPushService$Companion;
.field private static final inst$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$DcfMvzQu_r2uN7kqMbZ9JijCV9k()com.bytedance.trae.push.api.IPushService
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/push/api/IPushService$Companion;->inst_delegate$lambda$0()Lcom/bytedance/trae/push/api/IPushService;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/push/api/IPushService$Companion;
    invoke-direct v0, Lcom/bytedance/trae/push/api/IPushService$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/push/api/IPushService$Companion;->$$INSTANCE Lcom/bytedance/trae/push/api/IPushService$Companion;
    new-instance v0, Lcom/bytedance/trae/push/api/IPushService$Companion$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/push/api/IPushService$Companion$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/push/api/IPushService$Companion;->inst$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getInst()com.bytedance.trae.push.api.IPushService
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/push/api/IPushService$Companion;->inst$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/push/api/IPushService;
    return-object v0
.end method

.method private static final inst_delegate$lambda$0()com.bytedance.trae.push.api.IPushService
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/push/api/IPushService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/push/api/IPushService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/push/api/IPushService;
    goto +2h
    const/4 v0, 0
    return-object v0
    :try_start_0x0
.end method

.method public applyRedBadgeCount(int)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/push/api/IPushService$Companion;->getInst()Lcom/bytedance/trae/push/api/IPushService;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/push/api/IPushService;->applyRedBadgeCount(I)V
    return-void 
.end method

.method public asyncStartPush()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/push/api/IPushService$Companion;->getInst()Lcom/bytedance/trae/push/api/IPushService;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/push/api/IPushService;->asyncStartPush()V
    return-void 
.end method

.method public getPushActivityClazz()java.lang.Class
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/push/api/IPushService$Companion;->getInst()Lcom/bytedance/trae/push/api/IPushService;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/push/api/IPushService;->getPushActivityClazz()Ljava/lang/Class;
    move-result-object v0
    if-nez v0, +004h
    const-class v0, Landroid/app/Activity;
    return-object v0
.end method

.method public getPushContentType()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/push/api/IPushService$Companion;->getInst()Lcom/bytedance/trae/push/api/IPushService;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/push/api/IPushService;->getPushContentType()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public initAndStart()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/push/api/IPushService$Companion;->getInst()Lcom/bytedance/trae/push/api/IPushService;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/push/api/IPushService;->initAndStart()V
    return-void 
.end method

.method public isNotificationPermissionGranted()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/push/api/IPushService$Companion;->getInst()Lcom/bytedance/trae/push/api/IPushService;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/push/api/IPushService;->isNotificationPermissionGranted()Z
    move-result v0
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public onPushClick(java.lang.String  int)void
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/push/api/IPushService$Companion;->getInst()Lcom/bytedance/trae/push/api/IPushService;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/push/api/IPushService;->onPushClick(Ljava/lang/String; I)V
    return-void 
.end method

.method public openSystemNotificationSetting()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/push/api/IPushService$Companion;->getInst()Lcom/bytedance/trae/push/api/IPushService;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/push/api/IPushService;->openSystemNotificationSetting()V
    return-void 
.end method

.method public requestNotificationPermission()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/push/api/IPushService$Companion;->getInst()Lcom/bytedance/trae/push/api/IPushService;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/push/api/IPushService;->requestNotificationPermission()V
    return-void 
.end method

.method public showNotification(android.content.Context  android.content.Intent  com.bytedance.trae.push.api.TraeNotificationBody)boolean
    .registers 5
    # ins_size=4
    invoke-direct v1, Lcom/bytedance/trae/push/api/IPushService$Companion;->getInst()Lcom/bytedance/trae/push/api/IPushService;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, v2, v3, v4, Lcom/bytedance/trae/push/api/IPushService;->showNotification(Landroid/content/Context; Landroid/content/Intent; Lcom/bytedance/trae/push/api/TraeNotificationBody;)Z
    move-result v2
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method public trackClickPush(android.content.Context  java.lang.String  boolean  org.json.JSONObject)void
    .registers 6
    # ins_size=5
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "extra"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/push/api/IPushService$Companion;->getInst()Lcom/bytedance/trae/push/api/IPushService;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, v4, v5, Lcom/bytedance/trae/push/api/IPushService;->trackClickPush(Landroid/content/Context; Ljava/lang/String; Z Lorg/json/JSONObject;)V
    return-void 
.end method
