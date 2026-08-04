# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;
.super Ljava/lang/Object;
.source "TocCreditsObservation.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;
.field private static final credits4008Gate:Lcom/bytedance/trae/conversation/tracker/Credits4008ObservationGate;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/Credits4008ObservationGate;
    const/16 v1, 512
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/tracker/Credits4008ObservationGate;-><init>(I)V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->credits4008Gate Lcom/bytedance/trae/conversation/tracker/Credits4008ObservationGate;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final report(com.bytedance.trae.conversation.tracker.TocCreditsObservationEvent)void
    .registers 7
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->getCategory()Ljava/util/Map;
    move-result-object v0
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->toJsonObject(Ljava/util/Map;)Lorg/json/JSONObject;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->getChannel()Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;->ordinal()I
    move-result v1
    aget v1, v2, v1
    const/4 v2, 1
    if-eq v1, v2, +02bh
    const/4 v3, 2
    if-ne v1, v3, +022h
    sget-object v1, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->getMetric()Ljava/util/Map;
    move-result-object v6
    invoke-interface v6, Ljava/util/Map;->isEmpty()Z
    move-result v4
    xor-int/2addr v2, v4
    const/4 v4, 0
    if-eqz v2, +003h
    goto +2h
    move-object v6, v4
    if-eqz v6, +007h
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->toJsonObject(Ljava/util/Map;)Lorg/json/JSONObject;
    move-result-object v6
    goto +2h
    move-object v6, v4
    invoke-virtual v1, v3, v0, v6, v4, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    goto +10h
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->getName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v6, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v6
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v6, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
.end method

.method private final toJsonObject(java.util.Map)org.json.JSONObject
    .registers 5
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    invoke-interface v4, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v4
    invoke-interface v4, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +016h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    invoke-virtual v0, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto -19h
    return-object v0
.end method

.method public final trackBillingPopupClick(com.bytedance.trae.conversation.tracker.BillingPopupAction  com.bytedance.trae.conversation.billing.BillingUpgradeUserState  long)void
    .registers 6
    # ins_size=5
    const-string v0, "action"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userState
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;
    invoke-virtual v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->billingPopupClick(Lcom/bytedance/trae/conversation/tracker/BillingPopupAction; Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState; J)Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->report(Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;)V
    return-void 
.end method

.method public final trackBillingPopupShow(com.bytedance.trae.conversation.billing.BillingUpgradeUserState  boolean)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, userState
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/BillingPopupShowSource;->Restored Lcom/bytedance/trae/conversation/tracker/BillingPopupShowSource;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/BillingPopupShowSource;->Normal Lcom/bytedance/trae/conversation/tracker/BillingPopupShowSource;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->billingPopupShow(Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState; Lcom/bytedance/trae/conversation/tracker/BillingPopupShowSource;)Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->report(Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;)V
    return-void 
.end method

.method public final trackBillingSwitchResult(boolean  com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode  long  java.lang.String)void
    .registers 13
    # ins_size=6
    const-string v0, "preparationMode"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;->ordinal()I
    move-result v9
    aget v9, v0, v9
    const/4 v0, 1
    if-eq v9, v0, +00eh
    const/4 v0, 2
    if-ne v9, v0, +005h
    sget-object v9, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->SilentRecovery Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    goto +9h
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
    sget-object v9, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->PromptEligible Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    move-object v3, v9
    move v2, v8
    move-wide v4, v10
    move-object v6, v12
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->billingSwitchResult(Z Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode; J Ljava/lang/String;)Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;
    move-result-object v8
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->report(Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;)V
    return-void 
.end method

.method public final trackCredits4008Hit(java.lang.String  java.lang.String  boolean  com.bytedance.trae.conversation.tracker.Credits4008CodeSource  boolean  java.lang.String  java.lang.String)void
    .registers 14
    # ins_size=8
    const-string/jumbo v0, sessionId
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "codeSource"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->credits4008Gate Lcom/bytedance/trae/conversation/tracker/Credits4008ObservationGate;
    invoke-virtual v0, v7, v8, Lcom/bytedance/trae/conversation/tracker/Credits4008ObservationGate;->tryAcquire(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v7
    if-nez v7, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;
    move v1, v9
    move-object v2, v10
    move v3, v11
    move-object v4, v12
    move-object v5, v13
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->credits4008Hit(Z Lcom/bytedance/trae/conversation/tracker/Credits4008CodeSource; Z Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->report(Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;)V
    return-void 
.end method
