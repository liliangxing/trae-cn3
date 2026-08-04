# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
.super Ljava/lang/Object;
.source "ManagedPromptLedger.kt"

.field private final lastShownAtMillis:J
.field private final lastShownCampaignKey:Ljava/lang/String;
.field private final pendingBilling:Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
.field private final shownVersions:Ljava/util/Map;


.method public constructor <init>()void
    .registers 9
    # ins_size=1
    const-wide/16 v1, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 15
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;-><init>(J Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(long  java.lang.String  java.util.Map  com.bytedance.trae.conversation.prompt.PendingBillingPromptRecord)void
    .registers 7
    # ins_size=6
    const-string/jumbo v0, shownVersions
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-wide v2, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownAtMillis J
    iput-object v4, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownCampaignKey Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->shownVersions Ljava/util/Map;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->pendingBilling Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    return-void 
.end method

.method public synthetic constructor <init>(long  java.lang.String  java.util.Map  com.bytedance.trae.conversation.prompt.PendingBillingPromptRecord  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 1
    if-eqz v13, +004h
    const-wide/16 v7, 0
    move-wide v1, v7
    and-int/lit8 v7, v12, 2
    const/4 v8, 0
    if-eqz v7, +004h
    move-object v3, v8
    goto +2h
    move-object v3, v9
    and-int/lit8 v7, v12, 4
    if-eqz v7, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v10
    move-object v4, v10
    and-int/lit8 v7, v12, 8
    if-eqz v7, +004h
    move-object v5, v8
    goto +2h
    move-object v5, v11
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;-><init>(J Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.prompt.ManagedPromptLedgerState  long  java.lang.String  java.util.Map  com.bytedance.trae.conversation.prompt.PendingBillingPromptRecord  int  java.lang.Object)com.bytedance.trae.conversation.prompt.ManagedPromptLedgerState
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 1
    if-eqz v13, +004h
    iget-wide v7, v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownAtMillis J
    move-wide v1, v7
    and-int/lit8 v7, v12, 2
    if-eqz v7, +004h
    iget-object v9, v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownCampaignKey Ljava/lang/String;
    move-object v3, v9
    and-int/lit8 v7, v12, 4
    if-eqz v7, +004h
    iget-object v10, v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->shownVersions Ljava/util/Map;
    move-object v4, v10
    and-int/lit8 v7, v12, 8
    if-eqz v7, +004h
    iget-object v11, v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->pendingBilling Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    move-object v5, v11
    move-object v0, v6
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->copy(J Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v6
    return-object v6
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownAtMillis J
    return-wide v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownCampaignKey Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->shownVersions Ljava/util/Map;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.conversation.prompt.PendingBillingPromptRecord
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->pendingBilling Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    return-object v0
.end method

.method public final copy(long  java.lang.String  java.util.Map  com.bytedance.trae.conversation.prompt.PendingBillingPromptRecord)com.bytedance.trae.conversation.prompt.ManagedPromptLedgerState
    .registers 13
    # ins_size=6
    const-string/jumbo v0, shownVersions
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-object v1, v0
    move-wide v2, v8
    move-object v4, v10
    move-object v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;-><init>(J Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownAtMillis J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownAtMillis J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownCampaignKey Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownCampaignKey Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->shownVersions Ljava/util/Map;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->shownVersions Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->pendingBilling Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->pendingBilling Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getLastShownAtMillis()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownAtMillis J
    return-wide v0
.end method

.method public final getLastShownCampaignKey()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownCampaignKey Ljava/lang/String;
    return-object v0
.end method

.method public final getPendingBilling()com.bytedance.trae.conversation.prompt.PendingBillingPromptRecord
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->pendingBilling Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    return-object v0
.end method

.method public final getShownVersions()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->shownVersions Ljava/util/Map;
    return-object v0
.end method

.method public final hasShownAtLeast(com.bytedance.trae.conversation.prompt.ManagedPromptCandidate)boolean
    .registers 4
    # ins_size=2
    const-string v0, "candidate"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->shownVersions Ljava/util/Map;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->getCampaignId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Integer;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    goto +2h
    move v0, v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->getCampaignVersion()I
    move-result v3
    if-lt v0, v3, +003h
    const/4 v1, 1
    return v1
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownAtMillis J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownCampaignKey Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->shownVersions Ljava/util/Map;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->pendingBilling Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ManagedPromptLedgerState(lastShownAtMillis="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownAtMillis J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", lastShownCampaignKey="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->lastShownCampaignKey Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", shownVersions="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->shownVersions Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", pendingBilling="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->pendingBilling Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
