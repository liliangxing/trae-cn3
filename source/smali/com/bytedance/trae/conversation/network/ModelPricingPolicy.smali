# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;
.super Ljava/lang/Object;
.source "ModelPricingPolicy.kt"

.field private static final BUSINESS_EXCLUSIVE_DISCOUNT:Ljava/lang/String;
.field private static final BUSINESS_MEMBER_DISCOUNT:Ljava/lang/String;
.field private static final CN_CREDITS_EXCLUSIVE_DISCOUNT:Ljava/lang/String;
.field private static final CN_CREDITS_SUBSIDY:Ljava/lang/String;
.field private static final DISPLAY_SCALE:I
.field private static final EXCLUSIVE_DISCOUNT:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;
.field private static final MAX_DISCOUNT_PERCENT:Ljava/math/BigDecimal;
.field private static final MEMBER_DISCOUNT:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;
    new-instance v0, Ljava/math/BigDecimal;
    const-string v1, "100"
    invoke-direct v0, v1, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->MAX_DISCOUNT_PERCENT Ljava/math/BigDecimal;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final formatDecimal(java.math.BigDecimal)java.lang.String
    .registers 3
    # ins_size=2
    invoke-virtual v2, Ljava/math/BigDecimal;->stripTrailingZeros()Ljava/math/BigDecimal;
    move-result-object v2
    invoke-virtual v2, Ljava/math/BigDecimal;->toPlainString()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, toPlainString(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method private final resolveConsumptionRate(com.bytedance.trae.conversation.network.ModelFeatures)java.math.BigDecimal
    .registers 7
    # ins_size=2
    const/4 v0, 0
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ModelFeatures;->getConsumptionRate()Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;
    move-result-object v1
    goto +2h
    move-object v1, v0
    const/4 v2, 0
    if-eqz v1, +00ah
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;->getEnable()Z
    move-result v3
    const/4 v4, 1
    if-ne v3, v4, +003h
    move v2, v4
    if-eqz v2, +011h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;->getData()Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;
    move-result-object v6
    if-eqz v6, +006h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;->getRate()Ljava/math/BigDecimal;
    move-result-object v0
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->validRateOrNull(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    move-result-object v6
    return-object v6
    if-eqz v6, +023h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ModelFeatures;->getDiscount()Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;
    move-result-object v1
    if-eqz v1, +01dh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;->getEnable()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    if-eqz v1, +013h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;->getData()Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;
    move-result-object v1
    if-eqz v1, +00dh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->getConsumptionRate()Ljava/math/BigDecimal;
    move-result-object v2
    if-nez v2, +008h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->getRate()Ljava/math/BigDecimal;
    move-result-object v2
    goto +2h
    move-object v2, v0
    if-eqz v2, +007h
    invoke-direct v5, v2, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->validRateOrNull(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    move-result-object v6
    return-object v6
    if-eqz v6, +01ch
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ModelFeatures;->getCost()Lcom/bytedance/trae/conversation/network/ModelFeatureCost;
    move-result-object v6
    if-eqz v6, +016h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ModelFeatureCost;->getEnable()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v6, v0
    if-eqz v6, +00ch
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ModelFeatureCost;->getData()Lcom/bytedance/trae/conversation/network/ModelFeatureCostData;
    move-result-object v6
    if-eqz v6, +006h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ModelFeatureCostData;->getManualUsage()Ljava/math/BigDecimal;
    move-result-object v0
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->validRateOrNull(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    move-result-object v6
    return-object v6
.end method

.method private final resolveDiscountTag(com.bytedance.trae.conversation.network.ModelFeatureDiscount)com.bytedance.trae.conversation.network.ModelDiscountTag
    .registers 7
    # ins_size=2
    const/4 v0, 0
    const/4 v1, 1
    if-eqz v6, +00ah
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;->getEnable()Z
    move-result v2
    if-ne v2, v1, +004h
    move v2, v1
    goto +2h
    move v2, v0
    const/4 v3, 0
    if-nez v2, +003h
    return-object v3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;->getSubKey()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +01bh
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +00fh
    sget-object v4, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v2, v4, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v4, toLowerCase(...)
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    move-object v2, v3
    if-eqz v2, +092h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v4
    sparse-switch v4, +000008dh
    goto/16 +089h
    const-string v4, "member_discount"
    invoke-virtual v2, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00eh
    goto/16 +07fh
    const-string v4, "business_member_discount"
    invoke-virtual v2, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +075h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;->getData()Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;
    move-result-object v6
    if-eqz v6, +043h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;->getMemberDiscount()Ljava/math/BigDecimal;
    move-result-object v6
    if-eqz v6, +03dh
    sget-object v2, Ljava/math/BigDecimal;->ZERO Ljava/math/BigDecimal;
    invoke-virtual v6, v2, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I
    move-result v2
    if-ltz v2, +00bh
    sget-object v2, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->MAX_DISCOUNT_PERCENT Ljava/math/BigDecimal;
    invoke-virtual v6, v2, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I
    move-result v2
    if-gtz v2, +003h
    move v0, v1
    if-eqz v0, +003h
    goto +2h
    move-object v6, v3
    if-eqz v6, +026h
    new-instance v3, Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Member;
    sget-object v0, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;
    invoke-virtual v6, v1, Ljava/math/BigDecimal;->movePointLeft(I)Ljava/math/BigDecimal;
    move-result-object v1
    const-string v2, "movePointLeft(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->formatDecimal(Ljava/math/BigDecimal;)Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->MAX_DISCOUNT_PERCENT Ljava/math/BigDecimal;
    invoke-virtual v2, v6, Ljava/math/BigDecimal;->subtract(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    move-result-object v6
    const-string/jumbo v2, subtract(...)
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->formatDecimal(Ljava/math/BigDecimal;)Ljava/lang/String;
    move-result-object v6
    invoke-direct v3, v1, v6, Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Member;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/conversation/network/ModelDiscountTag;
    goto +2ah
    const-string v6, "cn_credits_subsidy"
    invoke-virtual v2, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +01eh
    goto +21h
    const-string v6, "exclusive_discount"
    invoke-virtual v2, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +015h
    goto +18h
    const-string v6, "cn_credits_exclusive_discount"
    invoke-virtual v2, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +00ch
    goto +fh
    const-string v6, "business_exclusive_discount"
    invoke-virtual v2, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +003h
    goto +6h
    sget-object v6, Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Exclusive;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Exclusive;
    move-object v3, v6
    check-cast v3, Lcom/bytedance/trae/conversation/network/ModelDiscountTag;
    return-object v3
    sparse-switch-payload -5b48975f 17bc41db 204f79c2 4d4dc932 6022fec7 7b546946
.end method

.method private final validRateOrNull(java.math.BigDecimal)java.math.BigDecimal
    .registers 4
    # ins_size=2
    const/4 v0, 0
    if-eqz v3, +00eh
    invoke-virtual v3, Ljava/math/BigDecimal;->signum()I
    move-result v1
    if-ltz v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    return-object v3
.end method

.method public final formatRateNumber(java.math.BigDecimal)java.lang.String
    .registers 4
    # ins_size=2
    const-string v0, "rate"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 2
    sget-object v1, Ljava/math/RoundingMode;->HALF_UP Ljava/math/RoundingMode;
    invoke-virtual v3, v0, v1, Ljava/math/BigDecimal;->setScale(I Ljava/math/RoundingMode;)Ljava/math/BigDecimal;
    move-result-object v3
    invoke-virtual v3, Ljava/math/BigDecimal;->toPlainString()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, toPlainString(...)
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method public final resolve(com.bytedance.trae.conversation.network.ModelFeatures)com.bytedance.trae.conversation.network.ModelPricingPresentation
    .registers 4
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->resolveConsumptionRate(Lcom/bytedance/trae/conversation/network/ModelFeatures;)Ljava/math/BigDecimal;
    move-result-object v1
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/ModelFeatures;->getDiscount()Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->resolveDiscountTag(Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;)Lcom/bytedance/trae/conversation/network/ModelDiscountTag;
    move-result-object v3
    invoke-direct v0, v1, v3, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;-><init>(Ljava/math/BigDecimal; Lcom/bytedance/trae/conversation/network/ModelDiscountTag;)V
    return-object v0
.end method
