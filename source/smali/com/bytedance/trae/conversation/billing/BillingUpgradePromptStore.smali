# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
.super Ljava/lang/Object;
.source "BillingUpgradePromptStore.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
.field private static final REPO_NAME:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    invoke-direct v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final repo()com.bytedance.keva.Keva
    .registers 3
    # ins_size=1
    const-string/jumbo v0, trae_billing_upgrade_prompt
    invoke-static v0, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "getRepo(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public final clearAll()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->repo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/keva/Keva;->clear()V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->clearAllForDebug()V
    return-void 
.end method

.method public final clearPending(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, userId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    const/4 v1, 2
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->clearPendingBilling(Ljava/lang/String; I)V
    return-void 
.end method

.method public final hasShown(java.lang.String)boolean
    .registers 5
    # ins_size=2
    const-string/jumbo v0, userId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->repo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->shownKey(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    if-nez v0, +014h
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->snapshot(Ljava/lang/String;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->getManagedCandidate$conversation_mainlandRelease()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v0
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->hasShownAtLeast(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;)Z
    move-result v4
    if-eqz v4, +003h
    const/4 v2, 1
    return v2
.end method

.method public final loadPending(java.lang.String)com.bytedance.trae.conversation.billing.BillingUpgradePromptData
    .registers 5
    # ins_size=2
    const-string/jumbo v0, userId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->snapshot(Ljava/lang/String;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getPendingBilling()Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    move-result-object v4
    const/4 v0, 0
    if-eqz v4, +040h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;->getCampaignVersion()I
    move-result v1
    const/4 v2, 2
    if-ne v1, v2, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +2h
    move-object v4, v0
    if-eqz v4, +030h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;->getPayload()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v4, v0
    check-cast v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    if-nez v4, +003h
    return-object v0
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;)V
    return-object v0
    :try_start_0x23
.end method

.method public final markShown(java.lang.String)void
    .registers 10
    # ins_size=2
    const-string/jumbo v0, userId
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->getManagedCandidate$conversation_mainlandRelease()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v3
    const-wide/16 v4, 0
    const/4 v6, 4
    const/4 v7, 0
    move-object v2, v9
    invoke-static/range v1 ... v7, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->recordShown$default(Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore; Ljava/lang/String; Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate; J I Ljava/lang/Object;)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->repo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
    invoke-virtual v1, v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->shownKey(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    const/4 v1, 1
    invoke-virtual v0, v9, v1, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    return-void 
.end method

.method public final savePending(java.lang.String  com.bytedance.trae.conversation.billing.BillingUpgradePromptData)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, userId
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "promptData"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    new-instance v1, Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;->getUserState()Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;->name()Ljava/lang/String;
    move-result-object v7
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    const/4 v4, 2
    invoke-direct v1, v4, v7, v2, v3, Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;-><init>(I Ljava/lang/String; J)V
    invoke-virtual v0, v6, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->savePendingBilling(Ljava/lang/String; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;)V
    return-void 
.end method
