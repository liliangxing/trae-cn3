# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;
.super Ljava/lang/Object;
.source "UpgradeReminderSettings.kt"

.field private final enabled:Z
.field private final recommendedHighest:J


.method public constructor <init>(boolean  long)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->enabled Z
    iput-wide v2, v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->recommendedHighest J
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.upgrade.UpgradeReminderConfig  boolean  long  int  java.lang.Object)com.bytedance.trae.conversation.upgrade.UpgradeReminderConfig
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->enabled Z
    and-int/lit8 v4, v4, 2
    if-eqz v4, +004h
    iget-wide v2, v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->recommendedHighest J
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->copy(Z J)Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->enabled Z
    return v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->recommendedHighest J
    return-wide v0
.end method

.method public final copy(boolean  long)com.bytedance.trae.conversation.upgrade.UpgradeReminderConfig
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;-><init>(Z J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->enabled Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->enabled Z
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->recommendedHighest J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->recommendedHighest J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getEnabled()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->enabled Z
    return v0
.end method

.method public final getRecommendedHighest()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->recommendedHighest J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->enabled Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->recommendedHighest J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "UpgradeReminderConfig(enabled="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->enabled Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", recommendedHighest="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->recommendedHighest J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
