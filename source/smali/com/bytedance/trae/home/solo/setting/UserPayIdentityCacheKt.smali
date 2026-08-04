# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCacheKt;
.super Ljava/lang/Object;
.source "UserPayIdentityCache.kt"


.method public static final selectCachedCNPayStatusForRequest(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.setting.CNUserPayStatusData)com.bytedance.trae.home.solo.setting.CNUserPayStatusData
    .registers 6
    # ins_size=4
    const-string/jumbo v0, requestUserId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00ah
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +2h
    return-object v5
    return-object v1
.end method

.method public static final toCreditsBalance(com.bytedance.trae.home.solo.setting.UserEntStatusResponse)com.bytedance.trae.conversation.CreditsBalance
    .registers 19
    # ins_size=1
    const-string v0, "<this>"
    move-object/from16 v1, v18
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->getUserEntitlementPackList()Ljava/util/List;
    move-result-object v0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +00dh
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    move v1, v3
    goto +34h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, -00ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;->getEntitlementBaseInfo()Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;
    move-result-object v4
    if-eqz v4, +01bh
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->getQuota()Lcom/bytedance/trae/home/solo/setting/EntQuota;
    move-result-object v4
    if-eqz v4, +015h
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->getCreditsLimit()Ljava/lang/Long;
    move-result-object v4
    if-nez v4, +003h
    goto +dh
    invoke-virtual v4, Ljava/lang/Long;->longValue()J
    move-result-wide v4
    const-wide/16 v6, -1
    cmp-long v4, v4, v6
    if-nez v4, +004h
    move v4, v2
    goto +2h
    move v4, v3
    if-eqz v4, -02ch
    move v1, v2
    if-eqz v1, +016h
    new-instance v0, Lcom/bytedance/trae/conversation/CreditsBalance;
    const-wide v5, 9223372036854775807
    const-wide/16 v7, 0
    const-wide v9, 9223372036854775807
    const/4 v11, 1
    move-object v4, v0
    invoke-direct/range v4 ... v11, Lcom/bytedance/trae/conversation/CreditsBalance;-><init>(J J J Z)V
    return-object v0
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    const-wide/16 v5, 0
    if-eqz v4, +02eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v7, v4
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;->getEntitlementBaseInfo()Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;
    move-result-object v7
    if-eqz v7, +013h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->getQuota()Lcom/bytedance/trae/home/solo/setting/EntQuota;
    move-result-object v7
    if-eqz v7, +00dh
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/EntQuota;->getCreditsLimit()Ljava/lang/Long;
    move-result-object v7
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Long;->longValue()J
    move-result-wide v7
    goto +2h
    move-wide v7, v5
    cmp-long v5, v7, v5
    if-lez v5, +004h
    move v5, v2
    goto +2h
    move v5, v3
    if-eqz v5, -02eh
    invoke-interface v1, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -33h
    check-cast v1, Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v0
    const/4 v4, 0
    if-eqz v0, +003h
    return-object v4
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v1
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    move-wide v7, v5
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +025h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;->getEntitlementBaseInfo()Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;
    move-result-object v9
    if-eqz v9, +013h
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->getQuota()Lcom/bytedance/trae/home/solo/setting/EntQuota;
    move-result-object v9
    if-eqz v9, +00dh
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/EntQuota;->getCreditsLimit()Ljava/lang/Long;
    move-result-object v9
    if-eqz v9, +007h
    invoke-virtual v9, Ljava/lang/Long;->longValue()J
    move-result-wide v9
    goto +2h
    move-wide v9, v5
    invoke-static v7, v8, v9, v10, Ljava/lang/Math;->addExact(J J)J
    move-result-wide v7
    goto -28h
    invoke-static v7, v8, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v7, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +003h
    move-object v0, v4
    check-cast v0, Ljava/lang/Long;
    if-eqz v0, +090h
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v8
    sget-object v0, Ljava/math/BigDecimal;->ZERO Ljava/math/BigDecimal;
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +03dh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;->getUsage()Lcom/bytedance/trae/home/solo/setting/EntUsage;
    move-result-object v7
    const-wide/16 v10, 0
    if-eqz v7, +00dh
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/EntUsage;->getCreditsAmount()Ljava/lang/Double;
    move-result-object v7
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Double;->doubleValue()D
    move-result-wide v12
    goto +2h
    move-wide v12, v10
    invoke-static v12, v13, Ljava/lang/Math;->abs(D)D
    move-result-wide v14
    const-wide v16, 9218868437227405311
    cmpg-double v7, v14, v16
    if-gtz v7, +004h
    move v7, v2
    goto +2h
    move v7, v3
    if-eqz v7, +010h
    cmpg-double v7, v12, v10
    if-gez v7, +003h
    goto +ah
    invoke-static v12, v13, Ljava/math/BigDecimal;->valueOf(D)Ljava/math/BigDecimal;
    move-result-object v7
    invoke-virtual v0, v7, Ljava/math/BigDecimal;->add(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    move-result-object v0
    goto -3fh
    return-object v4
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v1, Ljava/math/RoundingMode;->HALF_UP Ljava/math/RoundingMode;
    invoke-virtual v0, v3, v1, Ljava/math/BigDecimal;->setScale(I Ljava/math/RoundingMode;)Ljava/math/BigDecimal;
    move-result-object v0
    invoke-virtual v0, Ljava/math/BigDecimal;->longValueExact()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v0, v4
    check-cast v0, Ljava/lang/Long;
    if-eqz v0, +018h
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v10
    new-instance v0, Lcom/bytedance/trae/conversation/CreditsBalance;
    sub-long v1, v8, v10
    invoke-static v1, v2, v5, v6, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v12
    const/4 v14, 0
    const/16 v15, 8
    const/16 v16, 0
    move-object v7, v0
    invoke-direct/range v7 ... v16, Lcom/bytedance/trae/conversation/CreditsBalance;-><init>(J J J Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    return-object v4
    :try_start_0xb6
    :try_start_0x155
.end method

.method public static final toFastRequestUsageQuota(com.bytedance.trae.home.solo.setting.UserEntStatusResponse)com.bytedance.trae.home.solo.setting.UsageQuotaData
    .registers 11
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->getUserEntitlementPackList()Ljava/util/List;
    move-result-object v10
    if-nez v10, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v10
    check-cast v10, Ljava/lang/Iterable;
    instance-of v0, v10, Ljava/util/Collection;
    const/4 v1, 0
    if-eqz v0, +00ch
    move-object v0, v10
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +35h
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +02ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;->getEntitlementBaseInfo()Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;
    move-result-object v2
    const/4 v3, 1
    if-eqz v2, +01bh
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->getQuota()Lcom/bytedance/trae/home/solo/setting/EntQuota;
    move-result-object v2
    if-eqz v2, +015h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/EntQuota;->getPremiumModelFastRequestLimit()Ljava/lang/Long;
    move-result-object v2
    if-nez v2, +003h
    goto +dh
    invoke-virtual v2, Ljava/lang/Long;->longValue()J
    move-result-wide v4
    const-wide/16 v6, -1
    cmp-long v2, v4, v6
    if-nez v2, +004h
    move v2, v3
    goto +2h
    move v2, v1
    if-eqz v2, -02dh
    move v1, v3
    if-eqz v1, +011h
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    const-wide/16 v3, 0
    const-wide v5, 9223372036854775807
    const/4 v7, 1
    move-object v2, v10
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;-><init>(J J Z)V
    return-object v10
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-wide/16 v1, 0
    move-wide v6, v1
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +022h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;->getEntitlementBaseInfo()Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;
    move-result-object v3
    if-eqz v3, +013h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->getQuota()Lcom/bytedance/trae/home/solo/setting/EntQuota;
    move-result-object v3
    if-eqz v3, +00dh
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->getPremiumModelFastRequestLimit()Ljava/lang/Long;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v3
    goto +2h
    move-wide v3, v1
    add-long/2addr v6, v3
    goto -25h
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    move-wide v3, v1
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +01dh
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;->getUsage()Lcom/bytedance/trae/home/solo/setting/EntUsage;
    move-result-object v0
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->getPremiumModelFastAmount()Ljava/lang/Double;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Ljava/lang/Double;->doubleValue()D
    move-result-wide v8
    double-to-long v8, v8
    goto +2h
    move-wide v8, v1
    add-long/2addr v3, v8
    goto -20h
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    sub-long v3, v6, v3
    invoke-static v3, v4, v1, v2, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v4
    const/4 v8, 0
    move-object v3, v10
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;-><init>(J J Z)V
    return-object v10
.end method
