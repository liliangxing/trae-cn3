# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;
.super Ljava/lang/Object;
.source "Models.kt"

.field private final rate:Ljava/math/BigDecimal;


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;-><init>(Ljava/math/BigDecimal; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.math.BigDecimal)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;->rate Ljava/math/BigDecimal;
    return-void 
.end method

.method public synthetic constructor <init>(java.math.BigDecimal  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;-><init>(Ljava/math/BigDecimal;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.ModelFeatureConsumptionRateData  java.math.BigDecimal  int  java.lang.Object)com.bytedance.trae.conversation.network.ModelFeatureConsumptionRateData
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;->rate Ljava/math/BigDecimal;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;->copy(Ljava/math/BigDecimal;)Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.math.BigDecimal
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;->rate Ljava/math/BigDecimal;
    return-object v0
.end method

.method public final copy(java.math.BigDecimal)com.bytedance.trae.conversation.network.ModelFeatureConsumptionRateData
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;-><init>(Ljava/math/BigDecimal;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;->rate Ljava/math/BigDecimal;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;->rate Ljava/math/BigDecimal;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getRate()java.math.BigDecimal
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;->rate Ljava/math/BigDecimal;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;->rate Ljava/math/BigDecimal;
    if-nez v0, +004h
    const/4 v0, 0
    goto +5h
    invoke-virtual v0, Ljava/math/BigDecimal;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ModelFeatureConsumptionRateData(rate="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;->rate Ljava/math/BigDecimal;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
