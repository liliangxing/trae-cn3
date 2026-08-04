# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/impl/PushEventManager;
.super Ljava/lang/Object;
.source "PushEventManager.kt"

.field private static final BADGE_NUMBER_ERROR:I
.field private static final EVENT_NOTIFICATION_ARRIVE:Ljava/lang/String;
.field private static final EVENT_NOTIFICATION_CLICK:Ljava/lang/String;
.field private static final EVENT_PUSH:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/push/impl/PushEventManager;
.field private static final TAG:Ljava/lang/String;
.field private static final VALUE_IS_PUSH_FALSE:I
.field private static final VALUE_IS_PUSH_TRUE:I
.field private static final VALUE_PUSH_CONTENT_TYPE_DEFAULT:Ljava/lang/String;
.field private static final VALUE_PUSH_CONTENT_TYPE_OTHER:Ljava/lang/String;
.field private static final VALUE_PUSH_GROUP_ID_DEFAULT:Ljava/lang/String;
.field private static final VALUE_PUSH_RULE_ID_DEFAULT:J
.field private static final appBackgroundListener:Lcom/bytedance/trae/push/impl/PushEventManager$appBackgroundListener$1;
.field private static currentPushOpenUrl:Ljava/lang/String;
.field private static isPush:Z
.field private static isPushInt:I
.field private static pushContentType:Ljava/lang/String;


.method public static synthetic $r8$lambda$ZRLeiP0c49GNY91ti4OJsH3tqcg()java.lang.Object
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/push/impl/PushEventManager;->_init_$lambda$0()Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$odJrhvlRZh04cvzKHvZaHECGwzk()java.lang.Object
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/push/impl/PushEventManager;->_init_$lambda$1()Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/push/impl/PushEventManager;
    invoke-direct v0, Lcom/bytedance/trae/push/impl/PushEventManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/push/impl/PushEventManager;->INSTANCE Lcom/bytedance/trae/push/impl/PushEventManager;
    const-string v1, "default"
    sput-object v1, Lcom/bytedance/trae/push/impl/PushEventManager;->pushContentType Ljava/lang/String;
    const-string v2, ""
    sput-object v2, Lcom/bytedance/trae/push/impl/PushEventManager;->currentPushOpenUrl Ljava/lang/String;
    new-instance v2, Lcom/bytedance/trae/push/impl/PushEventManager$appBackgroundListener$1;
    invoke-direct v2, Lcom/bytedance/trae/push/impl/PushEventManager$appBackgroundListener$1;-><init>()V
    sput-object v2, Lcom/bytedance/trae/push/impl/PushEventManager;->appBackgroundListener Lcom/bytedance/trae/push/impl/PushEventManager$appBackgroundListener$1;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v3
    check-cast v2, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;
    invoke-interface v3, v2, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->addAppBackGroundListener(Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;)V
    const/4 v2, 0
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/push/impl/PushEventManager;->setOrUpdateIsPushCommonParams(I Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lcom/bytedance/trae/push/impl/PushEventManager$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/push/impl/PushEventManager$$ExternalSyntheticLambda0;-><init>()V
    const-string v2, "is_push"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->addEventCommonParams(Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lcom/bytedance/trae/push/impl/PushEventManager$$ExternalSyntheticLambda1;
    invoke-direct v1, Lcom/bytedance/trae/push/impl/PushEventManager$$ExternalSyntheticLambda1;-><init>()V
    const-string/jumbo v2, push_content_type
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->addEventCommonParams(Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final _init_$lambda$0()java.lang.Object
    .registers 1
    # ins_size=0
    sget v0, Lcom/bytedance/trae/push/impl/PushEventManager;->isPushInt I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    return-object v0
.end method

.method private static final _init_$lambda$1()java.lang.Object
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/push/impl/PushEventManager;->pushContentType Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$isPush$p()boolean
    .registers 1
    # ins_size=0
    sget-boolean v0, Lcom/bytedance/trae/push/impl/PushEventManager;->isPush Z
    return v0
.end method

.method public static final synthetic access$reportAppLaunchStatus(com.bytedance.trae.push.impl.PushEventManager  android.content.Context)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/push/impl/PushEventManager;->reportAppLaunchStatus(Landroid/content/Context;)V
    return-void 
.end method

.method public static final synthetic access$reportPushMonitorEvent(com.bytedance.trae.push.impl.PushEventManager  java.lang.String  org.json.JSONObject)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/push/impl/PushEventManager;->reportPushMonitorEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static final synthetic access$setPush$p(boolean)void
    .registers 1
    # ins_size=1
    sput-boolean v0, Lcom/bytedance/trae/push/impl/PushEventManager;->isPush Z
    return-void 
.end method

.method private final buildNotificationParams(com.bytedance.push.PushBody)org.json.JSONObject
    .registers 7
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    sget-object v1, Lcom/bytedance/trae/push/impl/PushEventManager;->INSTANCE Lcom/bytedance/trae/push/impl/PushEventManager;
    const/4 v2, 0
    if-eqz v6, +005h
    iget-object v3, v6, Lcom/bytedance/push/PushBody;->extra Ljava/lang/String;
    goto +2h
    move-object v3, v2
    if-eqz v6, +005h
    iget-object v4, v6, Lcom/bytedance/push/PushBody;->open_url Ljava/lang/String;
    goto +2h
    move-object v4, v2
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/push/impl/PushEventManager;->getPushContentType(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v4, type
    invoke-virtual v0, v4, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v6, +005h
    iget-object v3, v6, Lcom/bytedance/push/PushBody;->open_url Ljava/lang/String;
    goto +2h
    move-object v3, v2
    invoke-direct v1, v3, Lcom/bytedance/trae/push/impl/PushEventManager;->getTargetPage(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v4, target_page
    invoke-virtual v0, v4, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v6, +005h
    iget-object v3, v6, Lcom/bytedance/push/PushBody;->extra Ljava/lang/String;
    goto +2h
    move-object v3, v2
    if-eqz v6, +004h
    iget-object v2, v6, Lcom/bytedance/push/PushBody;->open_url Ljava/lang/String;
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/push/impl/PushEventManager;->getTaskId(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    move-object v1, v6
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-nez v1, +008h
    const-string/jumbo v1, task_id
    invoke-virtual v0, v1, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    return-object v0
.end method

.method private final getPushContentType(java.lang.String  java.lang.String)java.lang.String
    .registers 8
    # ins_size=3
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    const/4 v3, 0
    if-eqz v0, +003h
    goto +25h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/push/impl/PushEventManager;
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, v6, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    goto +ch
    move-exception v6
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v6, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v3, v6
    check-cast v3, Lorg/json/JSONObject;
    const-string/jumbo v6, push_content_type
    const-string v0, ""
    if-eqz v3, +008h
    invoke-virtual v3, v6, v0, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    move-object v3, v0
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +004h
    move v4, v2
    goto +2h
    move v4, v1
    if-eqz v4, +03ah
    move-object v4, v7
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move v4, v1
    goto +2h
    move v4, v2
    if-nez v4, +029h
    invoke-static v7, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v7
    invoke-virtual v7, v6, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v6
    move-object v6, v3
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +004h
    move v6, v2
    goto +2h
    move v6, v1
    if-eqz v6, +00eh
    const-string/jumbo v6, sec_type
    invoke-virtual v7, v6, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    goto +2h
    move-object v0, v6
    move-object v3, v0
    move-object v6, v3
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    move v1, v2
    if-eqz v1, +005h
    const-string/jumbo v3, other
    return-object v3
    :try_start_0x15
.end method

.method private final getTargetPage(java.lang.String)java.lang.String
    .registers 8
    # ins_size=2
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    const/4 v0, 1
    const-string/jumbo v2, task_list
    if-eqz v0, +003h
    return-object v2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/push/impl/PushEventManager;
    invoke-static v7, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    goto +ch
    move-exception v7
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    const/4 v3, 0
    if-eqz v0, +003h
    move-object v7, v3
    check-cast v7, Landroid/net/Uri;
    if-nez v7, +003h
    return-object v2
    invoke-virtual v7, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00ah
    invoke-virtual v7, Landroid/net/Uri;->getPath()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    check-cast v0, Ljava/lang/CharSequence;
    const-string v7, "conversation"
    check-cast v7, Ljava/lang/CharSequence;
    const/4 v4, 2
    invoke-static v0, v7, v1, v4, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v7
    const-string/jumbo v5, task_detail
    if-nez v7, +01ah
    move-object v7, v5
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v0, v7, v1, v4, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +003h
    goto +fh
    const-string/jumbo v7, settings
    move-object v5, v7
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v0, v5, v1, v4, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    move-object v2, v7
    goto +2h
    move-object v2, v5
    return-object v2
    :try_start_0x16
.end method

.method private final getTaskId(java.lang.String  java.lang.String)java.lang.String
    .registers 8
    # ins_size=3
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    const-string/jumbo v3, task_id
    const/4 v4, 0
    if-nez v0, +040h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/push/impl/PushEventManager;
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, v6, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    goto +ch
    move-exception v6
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v6, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    move-object v6, v4
    check-cast v6, Lorg/json/JSONObject;
    const-string v0, ""
    if-eqz v6, +00ah
    invoke-virtual v6, v3, v0, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    goto +2h
    move-object v0, v6
    move-object v6, v0
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +004h
    move v6, v2
    goto +2h
    move v6, v1
    if-eqz v6, +003h
    return-object v0
    move-object v6, v7
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +008h
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    move v1, v2
    if-nez v1, +02ah
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/push/impl/PushEventManager;
    invoke-static v7, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    goto +ch
    move-exception v6
    sget-object v7, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v6, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +003h
    move-object v6, v4
    check-cast v6, Landroid/net/Uri;
    if-eqz v6, +006h
    invoke-virtual v6, v3, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    return-object v4
    :try_start_0x17
    :try_start_0x63
.end method

.method private final reportAppLaunchStatus(android.content.Context)void
    .registers 9
    # ins_size=2
    sget-object v0, Lkotlinx/coroutines/GlobalScope;->INSTANCE Lkotlinx/coroutines/GlobalScope;
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/push/impl/PushEventManager$reportAppLaunchStatus$1;
    const/4 v4, 0
    invoke-direct v0, v8, v4, Lcom/bytedance/trae/push/impl/PushEventManager$reportAppLaunchStatus$1;-><init>(Landroid/content/Context; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final reportNotificationClick(com.bytedance.push.PushBody)void
    .registers 4
    # ins_size=2
    invoke-direct v2, v3, Lcom/bytedance/trae/push/impl/PushEventManager;->buildNotificationParams(Lcom/bytedance/push/PushBody;)Lorg/json/JSONObject;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_notification_click"
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    const-string/jumbo v0, notification_click
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/push/impl/PushEventManager;->reportPushMonitorEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method private final reportPushClickDetail(com.bytedance.push.PushBody  int)void
    .registers 11
    # ins_size=3
    if-nez v9, +003h
    return-void 
    iget-object v0, v9, Lcom/bytedance/push/PushBody;->extra Ljava/lang/String;
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    const/4 v4, 0
    const-string v5, ""
    if-nez v1, +045h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v8
    check-cast v1, Lcom/bytedance/trae/push/impl/PushEventManager;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, v0, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v4, v0
    check-cast v4, Lorg/json/JSONObject;
    if-eqz v4, +00bh
    const-string/jumbo v0, push_content_fir_type
    invoke-virtual v4, v0, v5, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    move-object v0, v5
    if-eqz v4, +00eh
    const-string/jumbo v1, push_content_sec_type
    invoke-virtual v4, v1, v5, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +3h
    move-object v4, v1
    goto +2h
    move-object v4, v5
    move-object v7, v4
    move-object v4, v0
    move-object v0, v7
    goto +2h
    move-object v0, v4
    iget-object v1, v9, Lcom/bytedance/push/PushBody;->open_url Ljava/lang/String;
    move-object v6, v1
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00bh
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    goto +3h
    move v6, v2
    goto +2h
    move v6, v3
    if-nez v6, +03dh
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    move-object v6, v4
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00bh
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    goto +3h
    move v6, v2
    goto +2h
    move v6, v3
    if-eqz v6, +00bh
    const-string v4, "fir_type"
    invoke-virtual v1, v4, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    move-object v4, v5
    move-object v6, v0
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00bh
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    goto +3h
    move v6, v2
    goto +2h
    move v6, v3
    if-eqz v6, +00eh
    const-string/jumbo v0, sec_type
    invoke-virtual v1, v0, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v5, v0
    move-object v0, v5
    iget v1, v9, Lcom/bytedance/push/PushBody;->imageType I
    if-eqz v1, +014h
    iget-object v1, v9, Lcom/bytedance/push/PushBody;->imageUrl Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +008h
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    move v2, v3
    if-nez v2, +005h
    const-string v1, "content_pic"
    goto +3h
    const-string v1, "content"
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v3, rule_id
    iget-wide v5, v9, Lcom/bytedance/push/PushBody;->id J
    invoke-virtual v2, v3, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v3, "group_id"
    iget-object v5, v9, Lcom/bytedance/push/PushBody;->groupId Ljava/lang/String;
    invoke-virtual v2, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "click_position"
    const-string/jumbo v5, notify
    invoke-virtual v2, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, push_type
    const-string/jumbo v5, remote_push
    invoke-virtual v2, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, sender
    invoke-virtual v2, v3, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v10, title
    iget-object v3, v9, Lcom/bytedance/push/PushBody;->title Ljava/lang/String;
    invoke-virtual v2, v10, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v10, right_image_url
    iget-object v3, v9, Lcom/bytedance/push/PushBody;->imageUrl Ljava/lang/String;
    invoke-virtual v2, v10, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v10, push_show_type
    iget v9, v9, Lcom/bytedance/push/PushBody;->pushShowType I
    invoke-virtual v2, v10, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v9, push_content_firtype
    invoke-virtual v2, v9, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v9, push_content_sectype
    invoke-virtual v2, v9, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v9, push_style
    invoke-virtual v2, v9, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v9, push_content_type
    sget-object v10, Lcom/bytedance/trae/push/impl/PushEventManager;->pushContentType Ljava/lang/String;
    invoke-virtual v2, v9, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v9, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string/jumbo v10, push_click_detail
    invoke-virtual v9, v10, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    const-string v9, "click"
    invoke-direct v8, v9, v2, Lcom/bytedance/trae/push/impl/PushEventManager;->reportPushMonitorEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x1b
.end method

.method private final reportPushMonitorEvent(java.lang.String  org.json.JSONObject)void
    .registers 5
    # ins_size=3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/push/impl/PushEventManager;
    new-instance v0, Lorg/json/JSONObject;
    invoke-virtual v4, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v0, v4, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string v4, "action"
    invoke-virtual v0, v4, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string/jumbo v4, push_event
    const/4 v1, 0
    invoke-virtual v3, v4, v0, v1, v1, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v3
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
.end method

.method private final reportPushNotificationStatus(android.content.Context)void
    .registers 9
    # ins_size=2
    sget-object v0, Lkotlinx/coroutines/GlobalScope;->INSTANCE Lkotlinx/coroutines/GlobalScope;
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/push/impl/PushEventManager$reportPushNotificationStatus$1;
    const/4 v4, 0
    invoke-direct v0, v8, v4, Lcom/bytedance/trae/push/impl/PushEventManager$reportPushNotificationStatus$1;-><init>(Landroid/content/Context; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static synthetic setOrUpdateIsPushCommonParams$default(com.bytedance.trae.push.impl.PushEventManager  int  java.lang.String  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +003h
    const/4 v1, 0
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    const-string v2, "default"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/push/impl/PushEventManager;->setOrUpdateIsPushCommonParams(I Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic trackPushProcess$default(com.bytedance.trae.push.impl.PushEventManager  com.bytedance.trae.push.impl.PushTrackerType  java.util.Map  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/push/impl/PushEventManager;->trackPushProcess(Lcom/bytedance/trae/push/impl/PushTrackerType; Ljava/util/Map;)V
    return-void 
.end method

.method public final getPushContentType()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/push/impl/PushEventManager;->pushContentType Ljava/lang/String;
    return-object v0
.end method

.method public final onChannelRegisterResult(boolean  int)void
    .registers 5
    # ins_size=3
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "is_success"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v3, type
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string/jumbo v4, rd_push_register_result
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    const-string/jumbo v3, register_result
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/push/impl/PushEventManager;->reportPushMonitorEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final onPushArrive(com.bytedance.push.PushBody)void
    .registers 4
    # ins_size=2
    invoke-direct v2, v3, Lcom/bytedance/trae/push/impl/PushEventManager;->buildNotificationParams(Lcom/bytedance/push/PushBody;)Lorg/json/JSONObject;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_notification_arrive"
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    const-string/jumbo v0, notification_arrive
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/push/impl/PushEventManager;->reportPushMonitorEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final onPushClick(com.bytedance.push.PushBody  int)void
    .registers 6
    # ins_size=3
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/push/impl/PushEventManager;->isPush Z
    const/4 v1, 0
    if-eqz v4, +005h
    iget-object v2, v4, Lcom/bytedance/push/PushBody;->extra Ljava/lang/String;
    goto +2h
    move-object v2, v1
    if-eqz v4, +004h
    iget-object v1, v4, Lcom/bytedance/push/PushBody;->open_url Ljava/lang/String;
    invoke-direct v3, v2, v1, Lcom/bytedance/trae/push/impl/PushEventManager;->getPushContentType(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/push/impl/PushEventManager;->setOrUpdateIsPushCommonParams(I Ljava/lang/String;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/push/impl/PushEventManager;->reportNotificationClick(Lcom/bytedance/push/PushBody;)V
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/push/impl/PushEventManager;->reportPushClickDetail(Lcom/bytedance/push/PushBody; I)V
    return-void 
.end method

.method public final reportPushEventWhenColdStart()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    invoke-direct v1, v0, Lcom/bytedance/trae/push/impl/PushEventManager;->reportPushNotificationStatus(Landroid/content/Context;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    invoke-direct v1, v0, Lcom/bytedance/trae/push/impl/PushEventManager;->reportAppLaunchStatus(Landroid/content/Context;)V
    return-void 
.end method

.method public final setOrUpdateIsPushCommonParams(int  java.lang.String)void
    .registers 10
    # ins_size=3
    const-string/jumbo v0, pushContentType
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v9, Lcom/bytedance/trae/push/impl/PushEventManager;->pushContentType Ljava/lang/String;
    sput v8, Lcom/bytedance/trae/push/impl/PushEventManager;->isPushInt I
    sget-object v0, Lkotlinx/coroutines/GlobalScope;->INSTANCE Lkotlinx/coroutines/GlobalScope;
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getDefault()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;
    const/4 v4, 0
    invoke-direct v0, v8, v9, v4, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;-><init>(I Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final trackPushProcess(com.bytedance.trae.push.impl.PushTrackerType  java.util.Map)void
    .registers 15
    # ins_size=3
    const-string v0, "eventType"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "extraParams"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "absolute_schema"
    sget-object v2, Lcom/bytedance/trae/push/impl/PushEventManager;->currentPushOpenUrl Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v1, Lcom/bytedance/trae/push/impl/PushEventManager;->currentPushOpenUrl Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +059h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v1, Lcom/bytedance/trae/push/impl/PushEventManager;->currentPushOpenUrl Ljava/lang/String;
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    const-string/jumbo v2, schema_path
    invoke-virtual v1, Landroid/net/Uri;->getPath()Ljava/lang/String;
    move-result-object v3
    const-string v4, ""
    if-nez v3, +003h
    move-object v3, v4
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, schema_host
    invoke-virtual v1, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +2h
    move-object v4, v3
    invoke-virtual v0, v2, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, Landroid/net/Uri;->getQueryParameterNames()Ljava/util/Set;
    move-result-object v1
    const-string v2, "getQueryParameterNames(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v3, v1
    check-cast v3, Ljava/lang/Iterable;
    const-string v1, ","
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 62
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, schema_queries
    invoke-virtual v0, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-interface v14, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v14
    invoke-interface v14, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v14
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +016h
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    invoke-virtual v0, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto -19h
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, trackPushProcess: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/push/impl/PushTrackerType;->getEventName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", params="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "PushEventManager"
    invoke-virtual v14, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v14, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v13, Lcom/bytedance/trae/push/impl/PushTrackerType;->getEventName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v14, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-virtual v13, Lcom/bytedance/trae/push/impl/PushTrackerType;->getActionName()Ljava/lang/String;
    move-result-object v13
    invoke-direct v12, v13, v0, Lcom/bytedance/trae/push/impl/PushEventManager;->reportPushMonitorEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x25
    :try_start_0x39
.end method

.method public final updateCurrentPushOpenUrl(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, openUrl
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/push/impl/PushEventManager;->currentPushOpenUrl Ljava/lang/String;
    return-void 
.end method
