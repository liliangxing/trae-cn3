# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;
.super Ljava/lang/Object;
.source "Models.kt"

.field private final consumptionRate:Ljava/math/BigDecimal;
.field private final memberDiscount:Ljava/math/BigDecimal;
.field private final rate:Ljava/math/BigDecimal;


.method public constructor <init>()void
    .registers 7
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 7
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;-><init>(Ljava/math/BigDecimal; Ljava/math/BigDecimal; Ljava/math/BigDecimal; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.math.BigDecimal  java.math.BigDecimal  java.math.BigDecimal)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->rate Ljava/math/BigDecimal;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->memberDiscount Ljava/math/BigDecimal;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->consumptionRate Ljava/math/BigDecimal;
    return-void 
.end method

.method public synthetic constructor <init>(java.math.BigDecimal  java.math.BigDecimal  java.math.BigDecimal  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 1
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v2, v0
    and-int/lit8 v6, v5, 2
    if-eqz v6, +003h
    move-object v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;-><init>(Ljava/math/BigDecimal; Ljava/math/BigDecimal; Ljava/math/BigDecimal;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.ModelFeatureDiscountData  java.math.BigDecimal  java.math.BigDecimal  java.math.BigDecimal  int  java.lang.Object)com.bytedance.trae.conversation.network.ModelFeatureDiscountData
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->rate Ljava/math/BigDecimal;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->memberDiscount Ljava/math/BigDecimal;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->consumptionRate Ljava/math/BigDecimal;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->copy(Ljava/math/BigDecimal; Ljava/math/BigDecimal; Ljava/math/BigDecimal;)Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.math.BigDecimal
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->rate Ljava/math/BigDecimal;
    return-object v0
.end method

.method public final component2()java.math.BigDecimal
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->memberDiscount Ljava/math/BigDecimal;
    return-object v0
.end method

.method public final component3()java.math.BigDecimal
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->consumptionRate Ljava/math/BigDecimal;
    return-object v0
.end method

.method public final copy(java.math.BigDecimal  java.math.BigDecimal  java.math.BigDecimal)com.bytedance.trae.conversation.network.ModelFeatureDiscountData
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;-><init>(Ljava/math/BigDecimal; Ljava/math/BigDecimal; Ljava/math/BigDecimal;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->rate Ljava/math/BigDecimal;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->rate Ljava/math/BigDecimal;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->memberDiscount Ljava/math/BigDecimal;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->memberDiscount Ljava/math/BigDecimal;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->consumptionRate Ljava/math/BigDecimal;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->consumptionRate Ljava/math/BigDecimal;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getConsumptionRate()java.math.BigDecimal
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->consumptionRate Ljava/math/BigDecimal;
    return-object v0
.end method

.method public final getMemberDiscount()java.math.BigDecimal
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->memberDiscount Ljava/math/BigDecimal;
    return-object v0
.end method

.method public final getRate()java.math.BigDecimal
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->rate Ljava/math/BigDecimal;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->rate Ljava/math/BigDecimal;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/math/BigDecimal;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->memberDiscount Ljava/math/BigDecimal;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/math/BigDecimal;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->consumptionRate Ljava/math/BigDecimal;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/math/BigDecimal;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ModelFeatureDiscountData(rate="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->rate Ljava/math/BigDecimal;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", memberDiscount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->memberDiscount Ljava/math/BigDecimal;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", consumptionRate="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->consumptionRate Ljava/math/BigDecimal;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
