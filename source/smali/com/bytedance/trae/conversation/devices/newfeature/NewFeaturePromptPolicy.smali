# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;
.super Ljava/lang/Object;
.source "NewFeaturePromptPolicy.kt"

.field private static final CAMPAIGN_ID_PREFIX:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;
.field public static final MIN_LOGIN_AGE_MILLIS:J
.field public static final MIN_PROMPT_INTERVAL_MILLIS:J


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic choosePrompt$default(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptPolicy  com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptState  com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig  long  int  java.lang.Object)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptDecision
    .registers 15
    # ins_size=7
    and-int/lit8 v14, v13, 2
    if-eqz v14, +010h
    new-instance v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const-wide/16 v4, 0
    const/16 v6, 15
    const/4 v7, 0
    move-object v0, v10
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;-><init>(Z I Ljava/util/List; J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    and-int/lit8 v13, v13, 4
    if-eqz v13, +006h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v11
    invoke-virtual v8, v9, v10, v11, v12, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->choosePrompt(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState; Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig; J)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptDecision;
    move-result-object v8
    return-object v8
.end method

.method private final isWithinMinInterval(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptState  com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig  long)boolean
    .registers 11
    # ins_size=5
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->getLastShownAtMillis()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v7, v0, v2
    const/4 v4, 0
    if-gtz v7, +003h
    return v4
    cmp-long v7, v9, v0
    const/4 v5, 1
    if-gez v7, +003h
    return v5
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->getMinIntervalMillis()J
    move-result-wide v7
    invoke-static v7, v8, v2, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v7
    const-wide/32 v2, 86400000
    invoke-static v2, v3, v7, v8, Ljava/lang/Math;->max(J J)J
    move-result-wide v7
    sub-long/2addr v9, v0
    cmp-long v7, v9, v7
    if-gez v7, +003h
    move v4, v5
    return v4
.end method

.method private final passesBaseEligibility(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptState  long)boolean
    .registers 10
    # ins_size=4
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->getHasConversation()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->getFirstLoginObservedAtMillis()J
    move-result-wide v2
    const-wide/16 v4, 0
    cmp-long v7, v2, v4
    if-lez v7, +010h
    cmp-long v7, v8, v2
    if-gez v7, +003h
    goto +ah
    sub-long/2addr v8, v2
    const-wide/32 v2, 86400000
    cmp-long v7, v8, v2
    if-ltz v7, +003h
    const/4 v1, 1
    return v1
.end method

.method public final choosePrompt(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptState  com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig  long)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptDecision
    .registers 10
    # ins_size=5
    const-string/jumbo v0, state
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "config"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->getEnable()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +079h
    invoke-direct v5, v6, v8, v9, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->passesBaseEligibility(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState; J)Z
    move-result v0
    if-eqz v0, +073h
    invoke-direct v5, v6, v7, v8, v9, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->isWithinMinInterval(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState; Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig; J)Z
    move-result v8
    if-eqz v8, +003h
    goto +6bh
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->getPriority()Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/lang/Iterable;
    invoke-static v8, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v9
    if-eqz v9, +008h
    sget-object v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->Companion Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig$Companion;->getDEFAULT_PRIORITY()Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/util/List;
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +03ah
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->getEligibleProductTypes()Ljava/util/Set;
    move-result-object v2
    invoke-interface v2, v0, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    const/4 v3, 0
    if-eqz v2, +025h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->getHighestShownVersions()Ljava/util/Map;
    move-result-object v2
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v2, v0, v4, Ljava/util/Map;->getOrDefault(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->getVersion()I
    move-result v4
    if-ge v2, v4, +00dh
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->getRegisteredProductTypes()Ljava/util/Set;
    move-result-object v2
    invoke-interface v2, v0, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    const/4 v3, 1
    if-eqz v3, -03bh
    goto +2h
    move-object v9, v1
    check-cast v9, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-nez v9, +003h
    return-object v1
    new-instance v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptDecision;
    invoke-direct v6, v9, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptDecision;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    return-object v6
    return-object v1
.end method

.method public final managedCandidate$conversation_mainlandRelease(com.bytedance.trae.conversation.devices.DeviceProductType  com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig)com.bytedance.trae.conversation.prompt.ManagedPromptCandidate
    .registers 7
    # ins_size=3
    const-string v0, "productType"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "config"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    sget-object v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;->MobileIdeGuide Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "mobile_ide_guide_"
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->getVersion()I
    move-result v6
    invoke-direct v0, v1, v5, v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptType; Ljava/lang/String; I)V
    return-object v0
.end method
