# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
.super Ljava/lang/Object;
.source "ModelPricingPolicy.kt"

.field private final consumptionRate:Ljava/math/BigDecimal;
.field private final discountTag:Lcom/bytedance/trae/conversation/network/ModelDiscountTag;


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;-><init>(Ljava/math/BigDecimal; Lcom/bytedance/trae/conversation/network/ModelDiscountTag; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.math.BigDecimal  com.bytedance.trae.conversation.network.ModelDiscountTag)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->consumptionRate Ljava/math/BigDecimal;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->discountTag Lcom/bytedance/trae/conversation/network/ModelDiscountTag;
    return-void 
.end method

.method public synthetic constructor <init>(java.math.BigDecimal  com.bytedance.trae.conversation.network.ModelDiscountTag  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move-object v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move-object v3, v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;-><init>(Ljava/math/BigDecimal; Lcom/bytedance/trae/conversation/network/ModelDiscountTag;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.ModelPricingPresentation  java.math.BigDecimal  com.bytedance.trae.conversation.network.ModelDiscountTag  int  java.lang.Object)com.bytedance.trae.conversation.network.ModelPricingPresentation
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->consumptionRate Ljava/math/BigDecimal;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->discountTag Lcom/bytedance/trae/conversation/network/ModelDiscountTag;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->copy(Ljava/math/BigDecimal; Lcom/bytedance/trae/conversation/network/ModelDiscountTag;)Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.math.BigDecimal
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->consumptionRate Ljava/math/BigDecimal;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.network.ModelDiscountTag
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->discountTag Lcom/bytedance/trae/conversation/network/ModelDiscountTag;
    return-object v0
.end method

.method public final copy(java.math.BigDecimal  com.bytedance.trae.conversation.network.ModelDiscountTag)com.bytedance.trae.conversation.network.ModelPricingPresentation
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;-><init>(Ljava/math/BigDecimal; Lcom/bytedance/trae/conversation/network/ModelDiscountTag;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->consumptionRate Ljava/math/BigDecimal;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->consumptionRate Ljava/math/BigDecimal;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->discountTag Lcom/bytedance/trae/conversation/network/ModelDiscountTag;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->discountTag Lcom/bytedance/trae/conversation/network/ModelDiscountTag;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getConsumptionRate()java.math.BigDecimal
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->consumptionRate Ljava/math/BigDecimal;
    return-object v0
.end method

.method public final getDiscountTag()com.bytedance.trae.conversation.network.ModelDiscountTag
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->discountTag Lcom/bytedance/trae/conversation/network/ModelDiscountTag;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->consumptionRate Ljava/math/BigDecimal;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/math/BigDecimal;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->discountTag Lcom/bytedance/trae/conversation/network/ModelDiscountTag;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ModelPricingPresentation(consumptionRate="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->consumptionRate Ljava/math/BigDecimal;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", discountTag="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->discountTag Lcom/bytedance/trae/conversation/network/ModelDiscountTag;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
