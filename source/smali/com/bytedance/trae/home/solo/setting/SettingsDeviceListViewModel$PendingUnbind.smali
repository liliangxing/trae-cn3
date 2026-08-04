# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;
.super Ljava/lang/Object;
.source "SettingsDeviceListViewModel.kt"

.field private final optimisticItem:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
.field private final originalIndex:I
.field private final requestId:J


.method public constructor <init>(com.bytedance.trae.home.solo.setting.SettingsDeviceItem  int  long)void
    .registers 6
    # ins_size=5
    const-string v0, "optimisticItem"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->optimisticItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    iput v3, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->originalIndex I
    iput-wide v4, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->requestId J
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel$PendingUnbind  com.bytedance.trae.home.solo.setting.SettingsDeviceItem  int  long  int  java.lang.Object)com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel$PendingUnbind
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->optimisticItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->originalIndex I
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    iget-wide v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->requestId J
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->copy(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; I J)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.home.solo.setting.SettingsDeviceItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->optimisticItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    return-object v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->originalIndex I
    return v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->requestId J
    return-wide v0
.end method

.method public final copy(com.bytedance.trae.home.solo.setting.SettingsDeviceItem  int  long)com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel$PendingUnbind
    .registers 6
    # ins_size=5
    const-string v0, "optimisticItem"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; I J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->optimisticItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    iget-object v3, v8, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->optimisticItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->originalIndex I
    iget v3, v8, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->originalIndex I
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->requestId J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->requestId J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getOptimisticItem()com.bytedance.trae.home.solo.setting.SettingsDeviceItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->optimisticItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    return-object v0
.end method

.method public final getOriginalIndex()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->originalIndex I
    return v0
.end method

.method public final getRequestId()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->requestId J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->optimisticItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->originalIndex I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->requestId J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PendingUnbind(optimisticItem="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->optimisticItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", originalIndex="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->originalIndex I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", requestId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->requestId J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
