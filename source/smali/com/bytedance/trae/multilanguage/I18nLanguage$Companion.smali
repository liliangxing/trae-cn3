# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;
.super Ljava/lang/Object;
.source "I18nTextProvider.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;-><init>()V
    return-void 
.end method

.method public final fromCode(java.lang.String)com.bytedance.trae.multilanguage.I18nLanguage
    .registers 5
    # ins_size=2
    const/4 v0, 0
    if-eqz v4, +024h
    const/16 v1, 45
    const/4 v2, 2
    invoke-static v4, v1, v0, v2, v0, Lkotlin/text/StringsKt;->substringBefore$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +01bh
    const/16 v1, 95
    invoke-static v4, v1, v0, v2, v0, Lkotlin/text/StringsKt;->substringBefore$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +013h
    sget-object v0, Ljava/util/Locale;->US Ljava/util/Locale;
    const-string v1, "US"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v4, toLowerCase(...)
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/multilanguage/I18nLanguage;->ZH Lcom/bytedance/trae/multilanguage/I18nLanguage;
    invoke-virtual v4, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getCode()Ljava/lang/String;
    move-result-object v4
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    sget-object v4, Lcom/bytedance/trae/multilanguage/I18nLanguage;->ZH Lcom/bytedance/trae/multilanguage/I18nLanguage;
    goto +12h
    sget-object v4, Lcom/bytedance/trae/multilanguage/I18nLanguage;->JA Lcom/bytedance/trae/multilanguage/I18nLanguage;
    invoke-virtual v4, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getCode()Ljava/lang/String;
    move-result-object v4
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    sget-object v4, Lcom/bytedance/trae/multilanguage/I18nLanguage;->JA Lcom/bytedance/trae/multilanguage/I18nLanguage;
    goto +3h
    sget-object v4, Lcom/bytedance/trae/multilanguage/I18nLanguage;->EN Lcom/bytedance/trae/multilanguage/I18nLanguage;
    return-object v4
.end method

.method public final fromLocale(java.util.Locale)com.bytedance.trae.multilanguage.I18nLanguage
    .registers 3
    # ins_size=2
    const-string v0, "locale"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;->fromCode(Ljava/lang/String;)Lcom/bytedance/trae/multilanguage/I18nLanguage;
    move-result-object v2
    return-object v2
.end method
