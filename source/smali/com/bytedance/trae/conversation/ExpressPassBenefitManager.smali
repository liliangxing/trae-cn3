# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
.super Ljava/lang/Object;
.source "ExpressPassBenefitManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
.field public static final KEY_EXPRESS_PASS_BENEFIT_CLOSE_TIME:Ljava/lang/String;
.field public static final KEY_EXPRESS_PASS_ENABLED:Ljava/lang/String;
.field public static final KEY_EXPRESS_PASS_ENABLE_FROM_AGENT:Ljava/lang/String;
.field public static final KEY_EXPRESS_PASS_SWITCH_TIPS:Ljava/lang/String;
.field private static final benefitSwitchListeners:Ljava/util/List;
.field private static bridge isFetching:Z
.field private static isInited:Z
.field private static final remainingChangedListeners:Ljava/util/List;
.field private static final scope:Lkotlinx/coroutines/CoroutineScope;
.field private static final streamingMessageListener:Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;


.method public static synthetic $r8$lambda$E36BFZJeReTzj-32QLCIt6i2LeY(com.bytedance.trae.im.model.ParsedChatMessage  boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->streamingMessageListener$lambda$1(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-direct v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sput-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->benefitSwitchListeners Ljava/util/List;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sput-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->remainingChangedListeners Ljava/util/List;
    const/4 v0, 0
    const/4 v1, 1
    invoke-static v0, v1, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->scope Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$$ExternalSyntheticLambda0;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->streamingMessageListener Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getRemainingChangedListeners$p()java.util.List
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->remainingChangedListeners Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$setFetching$p(boolean)void
    .registers 1
    # ins_size=1
    sput-boolean v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->isFetching Z
    return-void 
.end method

.method private static final streamingMessageListener$lambda$1(com.bytedance.trae.im.model.ParsedChatMessage  boolean)void
    .registers 3
    # ins_size=2
    const-string v0, "message"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v2, +007h
    sget-object v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->fetchUserPayIdentity()V
    return-void 
.end method

.method public final addBenefitSwitchListener(com.bytedance.trae.conversation.ExpressPassBenefitManager$OnBenefitSwitchListener)void
    .registers 4
    # ins_size=2
    const-string v0, "listener"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->benefitSwitchListeners Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +005h
    invoke-interface v0, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addRemainingChangedListener(com.bytedance.trae.conversation.ExpressPassBenefitManager$OnRemainingChangedListener)void
    .registers 4
    # ins_size=2
    const-string v0, "listener"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->remainingChangedListeners Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +005h
    invoke-interface v0, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final fetchUserPayIdentity()void
    .registers 8
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->shouldSkipTocCommercialFeatures()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-boolean v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->isFetching Z
    if-eqz v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$fetchUserPayIdentity$1;
    const/4 v4, 0
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$fetchUserPayIdentity$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final getKeva()com.bytedance.keva.Keva
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method public final getNotifyCount()long
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;->getSettings()Lcom/bytedance/trae/conversation/settings/BusinessSettings;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/settings/BusinessSettings;->getFastPassNotifyCount()J
    move-result-wide v0
    return-wide v0
.end method

.method public final getNotifyInterval()long
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;->getSettings()Lcom/bytedance/trae/conversation/settings/BusinessSettings;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/settings/BusinessSettings;->getFastPassNotifyInterval()J
    move-result-wide v0
    const/16 v2, 60
    int-to-long v2, v2
    mul-long/2addr v0, v2
    mul-long/2addr v0, v2
    const/16 v2, 1000
    int-to-long v2, v2
    mul-long/2addr v0, v2
    return-wide v0
.end method

.method public final init()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->shouldSkipTocCommercialFeatures()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-boolean v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->isInited Z
    if-nez v0, +00ch
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->isInited Z
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    sget-object v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->streamingMessageListener Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/IMService;->addStreamingMessageListener(Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;)V
    return-void 
.end method

.method public final isAutoUseExpress()boolean
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return v1
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->shouldSkipTocCommercialFeatures()Z
    move-result v0
    if-eqz v0, +003h
    return v1
    invoke-static Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->getUserUsageQuotaData()Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;->getInfinite()Z
    move-result v2
    if-nez v2, +016h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;->getTotal()J
    move-result-wide v2
    const-wide/16 v4, 0
    cmp-long v2, v2, v4
    if-lez v2, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;->getRemaining()J
    move-result-wide v2
    cmp-long v0, v2, v4
    if-lez v0, +003h
    goto +2h
    return v1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->isOpenAutoUseExpressPass()Z
    move-result v0
    return v0
.end method

.method public final isOpenAutoUseExpressPass()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    if-eqz v0, +004h
    const/4 v0, 0
    return v0
    sget-object v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "express_pass_enabled"
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    return v0
.end method

.method public final notifyBenefitEnable()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->benefitSwitchListeners Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnBenefitSwitchListener;
    const/4 v2, 1
    invoke-interface v1, v2, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnBenefitSwitchListener;->onBenefitSwitched(Z)V
    goto -10h
    return-void 
.end method

.method public final removeBenefitSwitchListener(com.bytedance.trae.conversation.ExpressPassBenefitManager$OnBenefitSwitchListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->benefitSwitchListeners Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final removeRemainingChangedListener(com.bytedance.trae.conversation.ExpressPassBenefitManager$OnRemainingChangedListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->remainingChangedListeners Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final saveAutoUseExpressPass(boolean)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "express_pass_enabled"
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    return-void 
.end method
