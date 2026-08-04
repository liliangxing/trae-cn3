# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;
.super Ljava/lang/Object;
.source "TocCreditsObservation.kt"

.field private static final EVENT_BILLING_POPUP_CLICK:Ljava/lang/String;
.field private static final EVENT_BILLING_POPUP_SHOW:Ljava/lang/String;
.field private static final EVENT_BILLING_SWITCH_RESULT:Ljava/lang/String;
.field private static final EVENT_CREDITS_4008_HIT:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final orStableUnknown(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    if-eqz v2, +011h
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    goto +2h
    const/4 v2, 0
    if-nez v2, +005h
    const-string/jumbo v2, unknown
    return-object v2
.end method

.method private final toInt(boolean)int
    .registers 2
    # ins_size=2
    return v1
.end method

.method private final trackValue(com.bytedance.trae.conversation.billing.BillingUpgradeUserState)java.lang.String
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +014h
    const/4 v0, 2
    if-eq v2, v0, +00eh
    const/4 v0, 3
    if-ne v2, v0, +005h
    const-string v2, "express"
    goto +ch
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    const-string v2, "has_fast_requests"
    goto +3h
    const-string v2, "no_fast_requests"
    return-object v2
.end method

.method public final billingPopupClick(com.bytedance.trae.conversation.tracker.BillingPopupAction  com.bytedance.trae.conversation.billing.BillingUpgradeUserState  long)com.bytedance.trae.conversation.tracker.TocCreditsObservationEvent
    .registers 14
    # ins_size=5
    const-string v0, "action"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, userState
    invoke-static v11, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;->Tea Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    const-string/jumbo v4, toc_billing_upgrade_popup_click
    const/4 v2, 4
    new-array v2, v2, [Lkotlin/Pair;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->getValue$conversation_mainlandRelease()Ljava/lang/String;
    move-result-object v10
    invoke-static v0, v10, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v10
    const/4 v0, 0
    aput-object v10, v2, v0
    const-string/jumbo v10, user_state
    invoke-direct v9, v11, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->trackValue(Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;)Ljava/lang/String;
    move-result-object v11
    invoke-static v10, v11, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v10
    const/4 v11, 1
    aput-object v10, v2, v11
    const-string v10, "conversion_version"
    const/4 v11, 2
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-static v10, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v10
    aput-object v10, v2, v11
    const-wide/16 v10, 0
    invoke-static v12, v13, v10, v11, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v10
    invoke-static v10, v11, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v10
    const-string/jumbo v11, stay_duration_ms
    invoke-static v11, v10, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v10
    const/4 v11, 3
    aput-object v10, v2, v11
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v5
    const/4 v6, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object v2, v1
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;-><init>(Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method public final billingPopupShow(com.bytedance.trae.conversation.billing.BillingUpgradeUserState  com.bytedance.trae.conversation.tracker.BillingPopupShowSource)com.bytedance.trae.conversation.tracker.TocCreditsObservationEvent
    .registers 11
    # ins_size=3
    const-string/jumbo v0, userState
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, showSource
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;->Tea Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    const-string/jumbo v3, toc_billing_upgrade_popup_show
    const/4 v1, 3
    new-array v1, v1, [Lkotlin/Pair;
    const-string/jumbo v4, user_state
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->trackValue(Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;)Ljava/lang/String;
    move-result-object v9
    invoke-static v4, v9, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v9
    const/4 v4, 0
    aput-object v9, v1, v4
    const/4 v9, 2
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "conversion_version"
    invoke-static v5, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    const-string/jumbo v4, show_source
    invoke-virtual v10, Lcom/bytedance/trae/conversation/tracker/BillingPopupShowSource;->getValue()Ljava/lang/String;
    move-result-object v10
    invoke-static v4, v10, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v10
    aput-object v10, v1, v9
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v1, v0
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;-><init>(Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method public final billingSwitchResult(boolean  com.bytedance.trae.conversation.tracker.BillingSwitchPreparationMode  long  java.lang.String)com.bytedance.trae.conversation.tracker.TocCreditsObservationEvent
    .registers 9
    # ins_size=6
    const-string v0, "preparationMode"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;->Slardar Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    invoke-static Lkotlin/collections/MapsKt;->createMapBuilder()Ljava/util/Map;
    move-result-object v1
    if-eqz v4, +006h
    const-string/jumbo v4, success
    goto +3h
    const-string v4, "failure"
    const-string/jumbo v2, result
    invoke-interface v1, v2, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v4, "preparation_mode"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-interface v1, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v8, +016h
    move-object v4, v8
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/lit8 v4, v4, 1
    if-eqz v4, +003h
    goto +2h
    const/4 v8, 0
    if-eqz v8, +007h
    const-string v4, "error_code"
    invoke-interface v1, v4, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v1, Lkotlin/collections/MapsKt;->build(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v4
    const-wide/16 v1, 0
    invoke-static v6, v7, v1, v2, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v5
    const-string v6, "duration_ms"
    invoke-static v6, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    invoke-static v5, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v5
    new-instance v6, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;
    const-string/jumbo v7, toc_billing_switch_result
    invoke-direct v6, v0, v7, v4, v5, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;-><init>(Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map;)V
    return-object v6
.end method

.method public final credits4008Hit(boolean  com.bytedance.trae.conversation.tracker.Credits4008CodeSource  boolean  java.lang.String  java.lang.String)com.bytedance.trae.conversation.tracker.TocCreditsObservationEvent
    .registers 14
    # ins_size=6
    const-string v0, "codeSource"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;->Slardar Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    const-string/jumbo v3, toc_credits_4008_hit
    const/4 v1, 6
    new-array v1, v1, [Lkotlin/Pair;
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->toInt(Z)I
    move-result v4
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "credits_feature_enabled"
    invoke-static v5, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 0
    aput-object v4, v1, v5
    const-string v4, "code_source"
    invoke-virtual v10, Lcom/bytedance/trae/conversation/tracker/Credits4008CodeSource;->getValue$conversation_mainlandRelease()Ljava/lang/String;
    move-result-object v10
    invoke-static v4, v10, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v10
    const/4 v4, 1
    aput-object v10, v1, v4
    if-eqz v9, +005h
    const-string v9, "credits_exhausted"
    goto +3h
    const-string v9, "legacy_usage_limit"
    const-string/jumbo v10, render_variant
    invoke-static v10, v9, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v9
    const/4 v10, 2
    aput-object v9, v1, v10
    invoke-direct v8, v11, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->toInt(Z)I
    move-result v9
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    const-string v10, "is_history"
    invoke-static v10, v9, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v9
    const/4 v10, 3
    aput-object v9, v1, v10
    const-string v9, "cli_type"
    invoke-direct v8, v12, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->orStableUnknown(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    invoke-static v9, v10, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v9
    const/4 v10, 4
    aput-object v9, v1, v10
    const-string v9, "chat_mode"
    invoke-direct v8, v13, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;->orStableUnknown(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    invoke-static v9, v10, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v9
    const/4 v10, 5
    aput-object v9, v1, v10
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v1, v0
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;-><init>(Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method
