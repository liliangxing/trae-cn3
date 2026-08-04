# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/LocaleManager;
.super Ljava/lang/Object;
.source "LocaleManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/utils/LocaleManager;
.field private static final KEY_LANGUAGE:Ljava/lang/String;
.field public static final LANGUAGE_EN:Ljava/lang/String;
.field public static final LANGUAGE_JA:Ljava/lang/String;
.field public static final LANGUAGE_ZH:Ljava/lang/String;
.field private static final REPO_NAME:Ljava/lang/String;
.field private static final SUPPORTED_LANGUAGES:Ljava/util/Set;
.field private static final VALUE_NOT_SET:Ljava/lang/String;
.field private static bridge currentLanguage:Ljava/lang/String;
.field private static final keva$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$OfH5gQ3-lDq4jZYX2rq8oxzJ_Jk()com.bytedance.keva.Keva
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/utils/LocaleManager;->keva_delegate$lambda$0()Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/utils/LocaleManager;
    invoke-direct v0, Lcom/bytedance/trae/utils/LocaleManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    const-string v0, "en"
    const-string v1, "ja"
    const-string/jumbo v2, zh
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/utils/LocaleManager;->SUPPORTED_LANGUAGES Ljava/util/Set;
    new-instance v0, Lcom/bytedance/trae/utils/LocaleManager$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/utils/LocaleManager$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/utils/LocaleManager;->keva$delegate Lkotlin/Lazy;
    const-string v0, ""
    sput-object v0, Lcom/bytedance/trae/utils/LocaleManager;->currentLanguage Ljava/lang/String;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getDefaultCountry(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    invoke-virtual v4, Ljava/lang/String;->hashCode()I
    move-result v0
    const/16 v1, 3241
    const-string v2, "US"
    if-eq v0, v1, +023h
    const/16 v1, 3383
    if-eq v0, v1, +013h
    const/16 v1, 3886
    if-eq v0, v1, +003h
    goto +1fh
    const-string/jumbo v0, zh
    invoke-virtual v4, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +017h
    const-string v2, "CN"
    goto +13h
    const-string v0, "ja"
    invoke-virtual v4, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    goto +ah
    const-string v2, "JP"
    goto +7h
    const-string v0, "en"
    invoke-virtual v4, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    return-object v2
.end method

.method private final getKeva()com.bytedance.keva.Keva
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->keva$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getValue(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/keva/Keva;
    return-object v0
.end method

.method private static final keva_delegate$lambda$0()com.bytedance.keva.Keva
    .registers 2
    # ins_size=0
    const-string/jumbo v0, trae_locale
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String; I)Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method public final getAppLocale()java.util.Locale
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-virtual v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->getSysLocale()Ljava/util/Locale;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/utils/LocaleManager;->currentLanguage Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +021h
    invoke-virtual v0, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/utils/LocaleManager;->currentLanguage Ljava/lang/String;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +007h
    invoke-virtual v0, Ljava/util/Locale;->getCountry()Ljava/lang/String;
    move-result-object v0
    goto +7h
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->currentLanguage Ljava/lang/String;
    invoke-direct v3, v0, Lcom/bytedance/trae/utils/LocaleManager;->getDefaultCountry(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/util/Locale;
    sget-object v2, Lcom/bytedance/trae/utils/LocaleManager;->currentLanguage Ljava/lang/String;
    invoke-direct v1, v2, v0, Ljava/util/Locale;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v1
    sget-object v1, Lcom/bytedance/trae/utils/LocaleManager;->SUPPORTED_LANGUAGES Ljava/util/Set;
    invoke-virtual v0, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v0
    new-instance v1, Ljava/util/Locale;
    const-string v2, "en"
    invoke-virtual v0, Ljava/util/Locale;->getCountry()Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v2, v0, Ljava/util/Locale;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v1
.end method

.method public final getCurrentLanguage()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->currentLanguage Ljava/lang/String;
    return-object v0
.end method

.method public final getEffectiveLanguage()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->currentLanguage Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +011h
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    invoke-virtual v0, Lcom/bytedance/trae/utils/LocaleManager;->getAppLocale()Ljava/util/Locale;
    move-result-object v0
    invoke-virtual v0, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v0
    const-string v1, "getLanguage(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/String;
    return-object v0
.end method

.method public final hasUserSelected()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->currentLanguage Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final init()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/utils/LocaleManager;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "app_language"
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    sput-object v2, Lcom/bytedance/trae/utils/LocaleManager;->currentLanguage Ljava/lang/String;
    return-void 
.end method

.method public final setLanguage(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "language"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v3, Lcom/bytedance/trae/utils/LocaleManager;->currentLanguage Ljava/lang/String;
    invoke-direct v2, Lcom/bytedance/trae/utils/LocaleManager;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "app_language"
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final wrapContext(android.content.Context)android.content.Context
    .registers 7
    # ins_size=2
    const-string v0, "base"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/utils/LocaleManager;->getAppLocale()Ljava/util/Locale;
    move-result-object v0
    invoke-static v0, Ljava/util/Locale;->setDefault(Ljava/util/Locale;)V
    new-instance v1, Landroid/content/res/Configuration;
    invoke-virtual v6, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;
    move-result-object v2
    invoke-direct v1, v2, Landroid/content/res/Configuration;-><init>(Landroid/content/res/Configuration;)V
    invoke-virtual v1, v0, Landroid/content/res/Configuration;->setLocale(Ljava/util/Locale;)V
    new-instance v2, Landroid/os/LocaleList;
    const/4 v3, 1
    new-array v3, v3, [Ljava/util/Locale;
    const/4 v4, 0
    aput-object v0, v3, v4
    invoke-direct v2, v3, Landroid/os/LocaleList;-><init>([Ljava/util/Locale;)V
    invoke-static v2, Landroid/os/LocaleList;->setDefault(Landroid/os/LocaleList;)V
    invoke-virtual v1, v2, Landroid/content/res/Configuration;->setLocales(Landroid/os/LocaleList;)V
    invoke-virtual v6, v1, Landroid/content/Context;->createConfigurationContext(Landroid/content/res/Configuration;)Landroid/content/Context;
    move-result-object v6
    const-string v0, "createConfigurationContext(...)"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v6
.end method
