# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/LanguageUtil;
.super Ljava/lang/Object;
.source "LanguageUtil.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/utils/LanguageUtil;
.field private static final currentSysLanguage:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/utils/LanguageUtil;
    invoke-direct v0, Lcom/bytedance/trae/utils/LanguageUtil;-><init>()V
    sput-object v0, Lcom/bytedance/trae/utils/LanguageUtil;->INSTANCE Lcom/bytedance/trae/utils/LanguageUtil;
    sget-object v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-virtual v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->getSysLocale()Ljava/util/Locale;
    move-result-object v0
    invoke-virtual v0, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v0
    const-string v1, "getLanguage(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/LanguageUtil;->currentSysLanguage Ljava/lang/String;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final convert2OldISOCodes()java.lang.String
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/LanguageUtil;->currentSysLanguage Ljava/lang/String;
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v1
    const-string v2, "getDefault(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v0, Lcom/bytedance/trae/utils/LanguageUtil;->convert2OldISOCodes(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final convert2OldISOCodes(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v0
    const-string v1, "getDefault(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "iw"
    if-ne v3, v0, +005h
    const-string v3, "he"
    goto +fh
    const-string v0, "ji"
    if-ne v3, v0, +006h
    const-string/jumbo v3, yi
    goto +7h
    const-string v0, "in"
    if-ne v3, v0, +004h
    const-string v3, "id"
    return-object v3
.end method

.method private final convert2StarlingLanguage(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    const-string/jumbo v0, th
    if-ne v2, v0, +006h
    const-string/jumbo v2, th-TH
    goto +11h
    const-string v0, "ms"
    if-ne v2, v0, +005h
    const-string v2, "ms-MY"
    goto +ah
    invoke-direct v1, Lcom/bytedance/trae/utils/LanguageUtil;->isTraditionalChinese()Z
    move-result v0
    if-eqz v0, +005h
    const-string/jumbo v2, zh-Hant
    return-object v2
.end method

.method private final isTraditionalChinese()boolean
    .registers 8
    # ins_size=1
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v0
    invoke-virtual v0, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, Ljava/util/Locale;->getScript()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, Ljava/util/Locale;->getCountry()Ljava/lang/String;
    move-result-object v0
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    const/4 v4, 1
    const/4 v5, 0
    if-nez v3, +004h
    move v3, v4
    goto +2h
    move v3, v5
    const-string/jumbo v6, zh
    if-eqz v3, +019h
    invoke-virtual v1, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +022h
    const-string v1, "TW"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +01bh
    const-string v1, "HK"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +012h
    goto +11h
    invoke-virtual v1, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00bh
    const-string v0, "Hant"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move v4, v5
    return v4
.end method

.method public final getLanguageForCommonParameters()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/utils/LanguageUtil;->convert2OldISOCodes()Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v0, Lcom/bytedance/trae/utils/LanguageUtil;->convert2StarlingLanguage(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getLanguageForCommonParameters(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "language"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/utils/LanguageUtil;->convert2OldISOCodes(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/utils/LanguageUtil;->convert2StarlingLanguage(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method
