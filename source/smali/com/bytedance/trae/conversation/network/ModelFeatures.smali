# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ModelFeatures;
.super Ljava/lang/Object;
.source "Models.kt"

.field private final access:Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;
.field private final consumptionRate:Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;
.field private final cost:Lcom/bytedance/trae/conversation/network/ModelFeatureCost;
.field private final discount:Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;


.method public constructor <init>()void
    .registers 8
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 15
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/network/ModelFeatures;-><init>(Lcom/bytedance/trae/conversation/network/ModelFeatureAccess; Lcom/bytedance/trae/conversation/network/ModelFeatureCost; Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate; Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.network.ModelFeatureAccess  com.bytedance.trae.conversation.network.ModelFeatureCost  com.bytedance.trae.conversation.network.ModelFeatureConsumptionRate  com.bytedance.trae.conversation.network.ModelFeatureDiscount)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/ModelFeatures;->access Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/network/ModelFeatures;->cost Lcom/bytedance/trae/conversation/network/ModelFeatureCost;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/network/ModelFeatures;->consumptionRate Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/network/ModelFeatures;->discount Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.network.ModelFeatureAccess  com.bytedance.trae.conversation.network.ModelFeatureCost  com.bytedance.trae.conversation.network.ModelFeatureConsumptionRate  com.bytedance.trae.conversation.network.ModelFeatureDiscount  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v2, v0
    and-int/lit8 v7, v6, 2
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/network/ModelFeatures;-><init>(Lcom/bytedance/trae/conversation/network/ModelFeatureAccess; Lcom/bytedance/trae/conversation/network/ModelFeatureCost; Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate; Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.ModelFeatures  com.bytedance.trae.conversation.network.ModelFeatureAccess  com.bytedance.trae.conversation.network.ModelFeatureCost  com.bytedance.trae.conversation.network.ModelFeatureConsumptionRate  com.bytedance.trae.conversation.network.ModelFeatureDiscount  int  java.lang.Object)com.bytedance.trae.conversation.network.ModelFeatures
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/ModelFeatures;->access Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/ModelFeatures;->cost Lcom/bytedance/trae/conversation/network/ModelFeatureCost;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/network/ModelFeatures;->consumptionRate Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/network/ModelFeatures;->discount Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/ModelFeatures;->copy(Lcom/bytedance/trae/conversation/network/ModelFeatureAccess; Lcom/bytedance/trae/conversation/network/ModelFeatureCost; Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate; Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;)Lcom/bytedance/trae/conversation/network/ModelFeatures;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.network.ModelFeatureAccess
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatures;->access Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.network.ModelFeatureCost
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatures;->cost Lcom/bytedance/trae/conversation/network/ModelFeatureCost;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.conversation.network.ModelFeatureConsumptionRate
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatures;->consumptionRate Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.conversation.network.ModelFeatureDiscount
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatures;->discount Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.network.ModelFeatureAccess  com.bytedance.trae.conversation.network.ModelFeatureCost  com.bytedance.trae.conversation.network.ModelFeatureConsumptionRate  com.bytedance.trae.conversation.network.ModelFeatureDiscount)com.bytedance.trae.conversation.network.ModelFeatures
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/conversation/network/ModelFeatures;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/network/ModelFeatures;-><init>(Lcom/bytedance/trae/conversation/network/ModelFeatureAccess; Lcom/bytedance/trae/conversation/network/ModelFeatureCost; Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate; Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/network/ModelFeatures;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/network/ModelFeatures;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ModelFeatures;->access Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/ModelFeatures;->access Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ModelFeatures;->cost Lcom/bytedance/trae/conversation/network/ModelFeatureCost;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/ModelFeatures;->cost Lcom/bytedance/trae/conversation/network/ModelFeatureCost;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ModelFeatures;->consumptionRate Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/ModelFeatures;->consumptionRate Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ModelFeatures;->discount Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/network/ModelFeatures;->discount Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAccess()com.bytedance.trae.conversation.network.ModelFeatureAccess
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatures;->access Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;
    return-object v0
.end method

.method public final getConsumptionRate()com.bytedance.trae.conversation.network.ModelFeatureConsumptionRate
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatures;->consumptionRate Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;
    return-object v0
.end method

.method public final getCost()com.bytedance.trae.conversation.network.ModelFeatureCost
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatures;->cost Lcom/bytedance/trae/conversation/network/ModelFeatureCost;
    return-object v0
.end method

.method public final getDiscount()com.bytedance.trae.conversation.network.ModelFeatureDiscount
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatures;->discount Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/network/ModelFeatures;->access Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/ModelFeatures;->cost Lcom/bytedance/trae/conversation/network/ModelFeatureCost;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ModelFeatureCost;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/ModelFeatures;->consumptionRate Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/ModelFeatures;->discount Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ModelFeatures(access="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ModelFeatures;->access Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", cost="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ModelFeatures;->cost Lcom/bytedance/trae/conversation/network/ModelFeatureCost;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", consumptionRate="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ModelFeatures;->consumptionRate Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", discount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ModelFeatures;->discount Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
