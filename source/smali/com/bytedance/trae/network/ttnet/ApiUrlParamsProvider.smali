# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;
.super Ljava/lang/Object;
.source "ApiUrlParamsProvider.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;
    invoke-direct v0, Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;->INSTANCE Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final convert2OldISOCodes(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    invoke-virtual v2, Ljava/lang/String;->toLowerCase()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "iw"
    if-ne v2, v0, +005h
    const-string v2, "he"
    goto +fh
    const-string v0, "ji"
    if-ne v2, v0, +006h
    const-string/jumbo v2, yi
    goto +7h
    const-string v0, "in"
    if-ne v2, v0, +004h
    const-string v2, "id"
    return-object v2
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
    invoke-direct v1, Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;->isTraditionalChinese()Z
    move-result v0
    if-eqz v0, +005h
    const-string/jumbo v2, zh-Hant
    return-object v2
.end method

.method private final getRomInfo()java.lang.String
    .registers 5
    # ins_size=1
    const-string/jumbo v0, toString(...)
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-static Lcom/ss/android/common/util/ToolUtils;->isMiui()Z
    move-result v2
    if-eqz v2, +008h
    const-string v2, "MIUI-"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto +30h
    invoke-static Lcom/ss/android/common/util/ToolUtils;->isFlyme()Z
    move-result v2
    if-eqz v2, +008h
    const-string v2, "FLYME-"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto +24h
    invoke-static Lcom/ss/android/common/util/ToolUtils;->getEmuiInfo()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Lcom/ss/android/deviceregister/utils/RomUtils;->isHwOrHonor(Ljava/lang/String;)Z
    move-result v3
    if-eqz v3, +007h
    const-string v3, "EMUI-"
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v3
    if-nez v3, +00bh
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "-"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v2, Landroid/os/Build$VERSION;->INCREMENTAL Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v1, Ljava/lang/StringBuilder;->length()I
    move-result v2
    if-lez v2, +00ah
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v1
    :try_start_0x8
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
    invoke-virtual v0, Ljava/util/Locale;->getCountry()Ljava/lang/String;
    move-result-object v0
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
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
    if-nez v1, +019h
    const-string v1, "HK"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +012h
    goto +fh
    invoke-virtual v1, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00bh
    const-string v0, "Hant"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    move v4, v5
    return v4
.end method

.method public final getCommonQueryParams(int)java.util.HashMap
    .registers 8
    # ins_size=2
    new-instance v7, Ljava/util/HashMap;
    invoke-direct v7, Ljava/util/HashMap;-><init>()V
    sget-object v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-virtual v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->getAppLocale()Ljava/util/Locale;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-virtual v1, Lcom/bytedance/trae/utils/AppLocaleUtils;->getCarrierRegion()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, region
    invoke-virtual v0, Ljava/util/Locale;->getCountry()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v7, v2, v3, Ljava/util/HashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-virtual v2, Lcom/bytedance/trae/utils/AppLocaleUtils;->getSysLocale()Ljava/util/Locale;
    move-result-object v2
    invoke-virtual v2, Ljava/util/Locale;->getCountry()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, sys_region
    invoke-virtual v7, v3, v2, Ljava/util/HashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;->INSTANCE Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;
    invoke-virtual v0, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v3
    const-string v4, "getLanguage(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;->getLanguageForCommonParameters(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    const-string v5, "lang"
    invoke-virtual v7, v5, v3, Ljava/util/HashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v1, +007h
    const-string v3, "carrier_region"
    invoke-virtual v7, v3, v1, Ljava/util/HashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-virtual v1, Lcom/bytedance/trae/utils/AppLocaleUtils;->getTimeZone()Ljava/util/TimeZone;
    move-result-object v1
    invoke-virtual v1, Ljava/util/TimeZone;->getID()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v3, tz_name
    invoke-virtual v7, v3, v1, Ljava/util/HashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v0, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;->getLanguageForCommonParameters(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/bdinstall/Level;->L1 Lcom/bytedance/bdinstall/Level;
    const-string v2, "language"
    invoke-static v2, v0, v1, Lcom/ss/android/common/applog/NetUtil;->addCustomParamsWithLevel(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/bdinstall/Level;)V
    return-object v7
.end method

.method public final getLanguageForCommonParameters(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "language"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;->convert2OldISOCodes(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;->convert2StarlingLanguage(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method
