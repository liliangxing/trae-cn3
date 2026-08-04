# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/impl/IPushServiceImpl;
.super Ljava/lang/Object;
.source "IPushServiceImpl.kt"

.implements Lcom/bytedance/trae/push/api/IPushService;

.field public static final Companion:Lcom/bytedance/trae/push/impl/IPushServiceImpl$Companion;
.field private static final REQUEST_PERMISSION_INTERVAL:J
.field private static final TAG:Ljava/lang/String;
.field private final callback:Lcom/bytedance/trae/push/impl/IPushServiceImpl$callback$1;


.method public static synthetic $r8$lambda$0XrP9ovrrZ5v7Caz52i4MubHNYs(com.bytedance.trae.push.impl.IPushServiceImpl  com.bytedance.trae.login.api.AccountStatus  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->initAndStart$lambda$0(Lcom/bytedance/trae/push/impl/IPushServiceImpl; Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$7vA2X1GDWbQxzqF5agO5asphF64()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/push/impl/IPushServiceImpl;->showNotificationPermissionDialog$lambda$2()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Fdt4SeZSYque4UB2oaHQHN7lUJo()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/push/impl/IPushServiceImpl;->showNotificationPermissionDialog$lambda$3()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$oUolijNOKbx0l4K-2q4Sn1tzvDw(com.bytedance.trae.push.impl.IPushServiceImpl)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->showNotificationPermissionDialog$lambda$1(Lcom/bytedance/trae/push/impl/IPushServiceImpl;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/push/impl/IPushServiceImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/push/impl/IPushServiceImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->Companion Lcom/bytedance/trae/push/impl/IPushServiceImpl$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/bytedance/trae/push/impl/IPushServiceImpl$callback$1;
    invoke-direct v0, Lcom/bytedance/trae/push/impl/IPushServiceImpl$callback$1;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->callback Lcom/bytedance/trae/push/impl/IPushServiceImpl$callback$1;
    return-void 
.end method

.method public static final synthetic access$tryStartPush(com.bytedance.trae.push.impl.IPushServiceImpl)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->tryStartPush()V
    return-void 
.end method

.method private final getBDPushConfigurationHost()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +005h
    const-string v0, "https://ug-normal.trae.ai"
    goto +3h
    const-string v0, "https://api.trae.cn"
    return-object v0
.end method

.method private static final initAndStart$lambda$0(com.bytedance.trae.push.impl.IPushServiceImpl  com.bytedance.trae.login.api.AccountStatus  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, status
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "<unused var>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/push/impl/IPushServiceImpl$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/login/api/AccountStatus;->ordinal()I
    move-result v2
    aget v2, v3, v2
    const/4 v3, 1
    if-eq v2, v3, +00ah
    const/4 v3, 2
    if-eq v2, v3, +003h
    goto +bh
    invoke-direct v1, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->notifySessionIdChanged()V
    goto +7h
    invoke-direct v1, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->tryStartPush()V
    invoke-direct v1, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->notifySessionIdChanged()V
    return-void 
.end method

.method private final notifySessionIdChanged()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/push/impl/FrontierSessionUpdater;->INSTANCE Lcom/bytedance/trae/push/impl/FrontierSessionUpdater;
    invoke-virtual v0, Lcom/bytedance/trae/push/impl/FrontierSessionUpdater;->notifySessionIdChanged()V
    return-void 
.end method

.method private final requestNotificationPermissionIfNeededAfterAndroid13()void
    .registers 9
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, requestNotificationPermissionIfNeededAfterAndroid13 called, isPushInit=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v2
    if-eqz v2, +00bh
    invoke-interface v2, Lcom/bytedance/push/interfaze/IPushService;->isPushInit()Z
    move-result v2
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", notificationEnabled="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/push/impl/PushHelper;->INSTANCE Lcom/bytedance/trae/push/impl/PushHelper;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    check-cast v3, Landroid/content/Context;
    invoke-virtual v2, v3, Lcom/bytedance/trae/push/impl/PushHelper;->isNotificationEnabled(Landroid/content/Context;)Z
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", permanentlyDenied="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/push/impl/PushHelper;->INSTANCE Lcom/bytedance/trae/push/impl/PushHelper;
    invoke-virtual v2, Lcom/bytedance/trae/push/impl/PushHelper;->isNotificationPermissionPermanentlyDenied()Z
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "IPushServiceImpl"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lcom/bytedance/push/interfaze/IPushService;->isPushInit()Z
    move-result v0
    const/4 v3, 1
    if-ne v0, v3, +003h
    move v1, v3
    if-nez v1, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->INSTANCE Lcom/bytedance/trae/push/impl/PushHelper;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-virtual v0, v1, Lcom/bytedance/trae/push/impl/PushHelper;->isNotificationEnabled(Landroid/content/Context;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->INSTANCE Lcom/bytedance/trae/push/impl/PushHelper;
    invoke-virtual v0, Lcom/bytedance/trae/push/impl/PushHelper;->isNotificationPermissionPermanentlyDenied()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->INSTANCE Lcom/bytedance/trae/push/impl/PushHelper;
    invoke-virtual v0, Lcom/bytedance/trae/push/impl/PushHelper;->getLastRequestNotificationPermissionTimestamp()J
    move-result-wide v0
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string/jumbo v7, requestNotificationPermission interval check: elapsed=
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sub-long/2addr v3, v0
    invoke-virtual v6, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", required=172800000"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v2, v6, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const-wide/16 v5, 0
    cmp-long v0, v0, v5
    if-lez v0, +00ah
    const-wide/32 v0, 172800000
    cmp-long v0, v3, v0
    if-gtz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "Try request Notification Permission After Android13"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v8, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->showNotificationPermissionDialog()V
    goto +1bh
    move-exception v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, requestNotificationPermissionIfNeededAfterAndroid13 e : 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0xaf
.end method

.method private final showNotificationPermissionDialog()void
    .registers 13
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->Companion Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
    move-object v2, v0
    check-cast v2, Landroid/content/Context;
    sget v3, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_permission_notification I
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_notification_title I
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_notification_message I
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_allow I
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_deny I
    sget v8, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_deny_permanently I
    new-instance v9, Lcom/bytedance/trae/push/impl/IPushServiceImpl$$ExternalSyntheticLambda1;
    invoke-direct v9, v12, Lcom/bytedance/trae/push/impl/IPushServiceImpl$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/push/impl/IPushServiceImpl;)V
    new-instance v10, Lcom/bytedance/trae/push/impl/IPushServiceImpl$$ExternalSyntheticLambda2;
    invoke-direct v10, Lcom/bytedance/trae/push/impl/IPushServiceImpl$$ExternalSyntheticLambda2;-><init>()V
    new-instance v11, Lcom/bytedance/trae/push/impl/IPushServiceImpl$$ExternalSyntheticLambda3;
    invoke-direct v11, Lcom/bytedance/trae/push/impl/IPushServiceImpl$$ExternalSyntheticLambda3;-><init>()V
    invoke-virtual/range v1 ... v11, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForNotification(Landroid/content/Context; I I I I I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    return-void 
.end method

.method private static final showNotificationPermissionDialog$lambda$1(com.bytedance.trae.push.impl.IPushServiceImpl)kotlin.Unit
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->INSTANCE Lcom/bytedance/trae/push/impl/PushHelper;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/push/impl/PushHelper;->setLastRequestNotificationPermissionTimestamp(J)V
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v0
    if-eqz v0, +009h
    iget-object v3, v3, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->callback Lcom/bytedance/trae/push/impl/IPushServiceImpl$callback$1;
    check-cast v3, Lcom/bytedance/push/interfaze/IRequestNotificationPermissionCallback;
    invoke-interface v0, v3, Lcom/bytedance/push/interfaze/IPushService;->requestNotificationPermission(Lcom/bytedance/push/interfaze/IRequestNotificationPermissionCallback;)Z
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final showNotificationPermissionDialog$lambda$2()kotlin.Unit
    .registers 3
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->INSTANCE Lcom/bytedance/trae/push/impl/PushHelper;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/push/impl/PushHelper;->setLastRequestNotificationPermissionTimestamp(J)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final showNotificationPermissionDialog$lambda$3()kotlin.Unit
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->INSTANCE Lcom/bytedance/trae/push/impl/PushHelper;
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/trae/push/impl/PushHelper;->setNotificationPermissionPermanentlyDenied(Z)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final tryStartPush()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getInstallId()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getSsid()Ljava/lang/String;
    move-result-object v2
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +00fh
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v3
    invoke-interface v3, v0, v1, v2, Lcom/bytedance/push/interfaze/IPushService;->start(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/push/impl/PushEventManager;->INSTANCE Lcom/bytedance/trae/push/impl/PushEventManager;
    invoke-virtual v0, Lcom/bytedance/trae/push/impl/PushEventManager;->reportPushEventWhenColdStart()V
    return-void 
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lcom/bytedance/trae/push/impl/IPushServiceImpl$tryStartPush$1;
    invoke-direct v1, Lcom/bytedance/trae/push/impl/IPushServiceImpl$tryStartPush$1;-><init>()V
    check-cast v1, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->addGetAppLogIdListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    return-void 
.end method

.method public applyRedBadgeCount(int)void
    .registers 4
    # ins_size=2
    invoke-static Lcom/bytedance/android/service/manager/PushServiceManager;->get()Lcom/bytedance/android/service/manager/PushServiceManager;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/android/service/manager/PushServiceManager;->getIRedBadgeExternalService()Lcom/bytedance/android/service/manager/redbadge/IRedBadgeExternalService;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-interface v0, v1, v3, Lcom/bytedance/android/service/manager/redbadge/IRedBadgeExternalService;->applyCount(Landroid/content/Context; I)Z
    return-void 
.end method

.method public asyncStartPush()void
    .registers 8
    # ins_size=1
    sget-object v0, Lkotlinx/coroutines/GlobalScope;->INSTANCE Lkotlinx/coroutines/GlobalScope;
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/push/impl/IPushServiceImpl$asyncStartPush$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/push/impl/IPushServiceImpl$asyncStartPush$1;-><init>(Lcom/bytedance/trae/push/impl/IPushServiceImpl; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public getPushActivityClazz()java.lang.Class
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/push/notification/PushActivity;
    return-object v0
.end method

.method public getPushContentType()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/push/impl/PushEventManager;->INSTANCE Lcom/bytedance/trae/push/impl/PushEventManager;
    invoke-virtual v0, Lcom/bytedance/trae/push/impl/PushEventManager;->getPushContentType()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getSupportService()com.bytedance.push.interfaze.ISupport
    .registers 3
    # ins_size=1
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/push/interfaze/IPushService;->getSupportService()Lcom/bytedance/push/interfaze/ISupport;
    move-result-object v0
    const-string v1, "getSupportService(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public initAndStart()void
    .registers 5
    # ins_size=1
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-interface v0, v1, Lcom/bytedance/push/interfaze/IPushService;->onAttachBaseContext(Landroid/app/Application;)V
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v0
    new-instance v1, Lcom/bytedance/push/BDPushConfiguration;
    invoke-direct v4, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->getBDPushConfigurationHost()Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/push/BDPushConfiguration;-><init>(Ljava/lang/String;)V
    check-cast v1, Lcom/bytedance/push/configuration/AbsBDPushConfiguration;
    invoke-interface v0, v1, Lcom/bytedance/push/interfaze/IPushService;->initOnApplication(Lcom/bytedance/push/configuration/AbsBDPushConfiguration;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    invoke-static v0, Lcom/bytedance/trae/utils/AppUtils;->isMainProcess(Landroid/content/Context;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->isTraeLoggedIn()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-eqz v1, +005h
    invoke-direct v4, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->tryStartPush()V
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00ch
    new-instance v1, Lcom/bytedance/trae/push/impl/IPushServiceImpl$$ExternalSyntheticLambda0;
    invoke-direct v1, v4, Lcom/bytedance/trae/push/impl/IPushServiceImpl$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/push/impl/IPushServiceImpl;)V
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v0, v1, v3, v2, v3, Lcom/bytedance/trae/login/api/ILoginService$DefaultImpls;->registerAccountStatusChangeListener$default(Lcom/bytedance/trae/login/api/ILoginService; Lcom/bytedance/trae/login/api/IAccountStatusListener; Ljava/lang/Boolean; I Ljava/lang/Object;)V
    return-void 
.end method

.method public isNotificationPermissionGranted()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->INSTANCE Lcom/bytedance/trae/push/impl/PushHelper;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-virtual v0, v1, Lcom/bytedance/trae/push/impl/PushHelper;->isNotificationEnabled(Landroid/content/Context;)Z
    move-result v0
    return v0
.end method

.method public onPushClick(java.lang.String  int)void
    .registers 5
    # ins_size=3
    if-nez v3, +003h
    return-void 
    new-instance v0, Lcom/bytedance/push/PushBody;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, v3, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    invoke-direct v0, v1, Lcom/bytedance/push/PushBody;-><init>(Lorg/json/JSONObject;)V
    sget-object v3, Lcom/bytedance/trae/push/impl/PushEventManager;->INSTANCE Lcom/bytedance/trae/push/impl/PushEventManager;
    invoke-virtual v3, v0, v4, Lcom/bytedance/trae/push/impl/PushEventManager;->onPushClick(Lcom/bytedance/push/PushBody; I)V
    return-void 
.end method

.method public openSystemNotificationSetting()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->INSTANCE Lcom/bytedance/trae/push/impl/PushHelper;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-virtual v0, v1, Lcom/bytedance/trae/push/impl/PushHelper;->openSysPushSettingPage(Landroid/content/Context;)V
    return-void 
.end method

.method public final requestHwNotificationPermission(java.lang.String  com.bytedance.common.push.interfaze.RequestResultCallback)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, scene
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v0
    invoke-interface v0, v2, v3, Lcom/bytedance/push/interfaze/IPushService;->requestHwNotificationPermission(Ljava/lang/String; Lcom/bytedance/common/push/interfaze/RequestResultCallback;)V
    return-void 
.end method

.method public final requestMiRemoveVoipNotification(android.content.Context)boolean
    .registers 3
    # ins_size=2
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v0
    invoke-interface v0, v2, Lcom/bytedance/push/interfaze/IPushService;->requestMiRemoveVoipNotification(Landroid/content/Context;)Z
    move-result v2
    return v2
.end method

.method public requestNotificationPermission()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, requestNotificationPermission called, SDK_INT=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget v2, Landroid/os/Build$VERSION;->SDK_INT I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "IPushServiceImpl"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 33
    if-lt v0, v1, +006h
    invoke-direct v3, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->requestNotificationPermissionIfNeededAfterAndroid13()V
    return-void 
    invoke-static Lcom/bytedance/common/utility/DeviceUtils;->isOppo()Z
    move-result v0
    if-eqz v0, +009h
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    if-ge v0, v1, +005h
    invoke-virtual v3, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->requestOpNotificationPermission()V
    return-void 
.end method

.method public final requestNotificationPermission(com.bytedance.push.interfaze.IRequestNotificationPermissionCallback)boolean
    .registers 3
    # ins_size=2
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v0
    invoke-interface v0, v2, Lcom/bytedance/push/interfaze/IPushService;->requestNotificationPermission(Lcom/bytedance/push/interfaze/IRequestNotificationPermissionCallback;)Z
    move-result v2
    return v2
.end method

.method public final requestOpNotificationPermission()void
    .registers 8
    # ins_size=1
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lcom/bytedance/push/interfaze/IPushService;->isPushInit()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-eqz v1, +01dh
    sget-object v0, Lkotlinx/coroutines/GlobalScope;->INSTANCE Lkotlinx/coroutines/GlobalScope;
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/push/impl/IPushServiceImpl$requestOpNotificationPermission$1;
    const/4 v4, 0
    invoke-direct v0, v4, Lcom/bytedance/trae/push/impl/IPushServiceImpl$requestOpNotificationPermission$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public showNotification(android.content.Context  android.content.Intent  com.bytedance.trae.push.api.TraeNotificationBody)boolean
    .registers 4
    # ins_size=4
    if-eqz v3, +007h
    invoke-static v3, Lcom/bytedance/trae/push/impl/PushUtilsKt;->transToNotificationBody(Lcom/bytedance/trae/push/api/TraeNotificationBody;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->showNotificationInternal(Landroid/content/Context; Landroid/content/Intent; Lcom/bytedance/android/service/manager/push/notification/NotificationBody;)Z
    move-result v1
    return v1
.end method

.method public final showNotificationInternal(android.content.Context  android.content.Intent  com.bytedance.android.service.manager.push.notification.NotificationBody)boolean
    .registers 5
    # ins_size=4
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v0
    invoke-interface v0, v2, v3, v4, Lcom/bytedance/push/interfaze/IPushService;->showNotification(Landroid/content/Context; Landroid/content/Intent; Lcom/bytedance/android/service/manager/push/notification/NotificationBody;)Z
    move-result v2
    return v2
.end method

.method public trackClickPush(android.content.Context  java.lang.String  boolean  org.json.JSONObject)void
    .registers 7
    # ins_size=5
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "extra"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v4, +003h
    return-void 
    new-instance v0, Lcom/bytedance/push/PushBody;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, v4, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    invoke-direct v0, v1, Lcom/bytedance/push/PushBody;-><init>(Lorg/json/JSONObject;)V
    iget-object v4, v0, Lcom/bytedance/push/PushBody;->eventExtra Lorg/json/JSONObject;
    if-eqz v4, +008h
    const-string/jumbo v1, ttpush_event_extra
    invoke-virtual v6, v1, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v4
    invoke-interface v4, v3, v0, v5, v6, Lcom/bytedance/push/interfaze/IPushService;->trackClickPush(Landroid/content/Context; Lcom/bytedance/push/PushBody; Z Lorg/json/JSONObject;)V
    return-void 
.end method
