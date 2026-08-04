# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;
.super Ljava/lang/Object;
.source "Models.kt"

.field private final displayName:Ljava/lang/String;
.field private final i18n:Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;
.field private final iconUrl:Ljava/lang/String;
.field private final name:Ljava/lang/String;
.field private final pluginId:Ljava/lang/String;


.method public constructor <init>()void
    .registers 9
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 31
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.network.MarketplacePluginI18n)void
    .registers 7
    # ins_size=6
    const-string v0, "pluginId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->pluginId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->name Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->displayName Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->iconUrl Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->i18n Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.network.MarketplacePluginI18n  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    const-string v4, ""
    and-int/lit8 v10, v9, 2
    const/4 v0, 0
    if-eqz v10, +004h
    move-object v10, v0
    goto +2h
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    move-object v2, v0
    goto +2h
    move-object v2, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +003h
    goto +2h
    move-object v0, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-object v8, v1
    move-object v9, v2
    move-object v10, v0
    invoke-direct/range v5 ... v10, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.MarketplacePluginItem  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.network.MarketplacePluginI18n  int  java.lang.Object)com.bytedance.trae.conversation.network.MarketplacePluginItem
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->pluginId Ljava/lang/String;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->name Ljava/lang/String;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->displayName Ljava/lang/String;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->iconUrl Ljava/lang/String;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->i18n Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-object v8, v0
    move-object v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;)Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;
    move-result-object v3
    return-object v3
.end method

.method public static synthetic localizedDisplayName$default(com.bytedance.trae.conversation.network.MarketplacePluginItem  java.util.Locale  int  java.lang.Object)java.lang.String
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +006h
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->localizedDisplayName(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->pluginId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->iconUrl Ljava/lang/String;
    return-object v0
.end method

.method public final component5()com.bytedance.trae.conversation.network.MarketplacePluginI18n
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->i18n Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.network.MarketplacePluginI18n)com.bytedance.trae.conversation.network.MarketplacePluginItem
    .registers 13
    # ins_size=6
    const-string v0, "pluginId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move-object v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->pluginId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->pluginId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->name Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->displayName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->displayName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->iconUrl Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->iconUrl Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->i18n Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->i18n Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getDisplayName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final getI18n()com.bytedance.trae.conversation.network.MarketplacePluginI18n
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->i18n Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;
    return-object v0
.end method

.method public final getIconUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->iconUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->name Ljava/lang/String;
    return-object v0
.end method

.method public final getPluginId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->pluginId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->pluginId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->name Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->displayName Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->iconUrl Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->i18n Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final localizedDisplayName(java.util.Locale)java.lang.String
    .registers 8
    # ins_size=2
    const-string v0, "locale"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Ljava/util/Locale;->toLanguageTag()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLanguageTag(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v2, "ROOT"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v3
    const-string v4, "getLanguage(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v4, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, v4, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Ljava/util/Locale;->getCountry()Ljava/lang/String;
    move-result-object v7
    const-string v4, "getCountry(...)"
    invoke-static v7, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v4, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, v4, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v1
    invoke-interface v1, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v2, 1
    const/4 v4, 0
    if-lez v0, +004h
    move v0, v2
    goto +2h
    move v0, v4
    if-eqz v0, +044h
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    move v0, v2
    goto +2h
    move v0, v4
    if-eqz v0, +036h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v5, 45
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-interface v1, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v5, 95
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-interface v1, v7, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-interface v1, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    const-string v7, "en"
    invoke-interface v1, v7, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-static v1, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/lang/Iterable;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +039h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->i18n Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;
    if-eqz v3, +02bh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;->getDisplayNames()Ljava/util/Map;
    move-result-object v3
    if-eqz v3, +025h
    invoke-interface v3, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-eqz v0, +01dh
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +011h
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +004h
    move v3, v2
    goto +2h
    move v3, v4
    if-eqz v3, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, -03bh
    goto +2h
    move-object v0, v1
    if-nez v0, +02ah
    iget-object v7, v6, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->displayName Ljava/lang/String;
    if-eqz v7, +01ch
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v7, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v7
    if-eqz v7, +010h
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    goto +2h
    move v2, v4
    if-eqz v2, +003h
    move-object v1, v7
    if-nez v1, +009h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->name Ljava/lang/String;
    if-nez v0, +006h
    const-string v0, ""
    goto +2h
    move-object v0, v1
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "MarketplacePluginItem(pluginId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->pluginId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", name="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->name Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", displayName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->displayName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", iconUrl="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->iconUrl Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", i18n="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->i18n Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
