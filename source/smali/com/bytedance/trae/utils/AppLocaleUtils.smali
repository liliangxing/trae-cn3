# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/AppLocaleUtils;
.super Ljava/lang/Object;
.source "AppLocaleUtils.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/utils/AppLocaleUtils;
.field private static carrierRegion:Ljava/lang/String;
.field private static final isMIUIBuild:Z


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-direct v0, Lcom/bytedance/trae/utils/AppLocaleUtils;-><init>()V
    sput-object v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    sget-object v0, Landroid/os/Build;->BRAND Ljava/lang/String;
    const-string v1, "Xiaomi"
    const/4 v2, 1
    invoke-static v0, v1, v2, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    sput-boolean v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->isMIUIBuild Z
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getLocaleFromMIUIIBuild()java.util.Locale
    .registers 5
    # ins_size=1
    const-string v0, "miui.os.Build"
    invoke-static v0, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    move-result-object v0
    const-string v1, "getRegion"
    const/4 v2, 0
    new-array v3, v2, [Ljava/lang/Class;
    invoke-virtual v0, v1, v3, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v0
    const-string v1, "getDeclaredMethod(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-array v1, v2, [Ljava/lang/Object;
    const/4 v2, 0
    invoke-virtual v0, v2, v1, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    const-string/jumbo v1, null cannot be cast to non-null type kotlin.String
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/String;
    goto +9h
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v0
    invoke-virtual v0, Ljava/util/Locale;->getCountry()Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/util/Locale;
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v2
    invoke-virtual v2, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v2, v0, Ljava/util/Locale;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v1
    :try_start_0x0
.end method

.method public final getAppLocale()java.util.Locale
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    invoke-virtual v0, Lcom/bytedance/trae/utils/LocaleManager;->getAppLocale()Ljava/util/Locale;
    move-result-object v0
    return-object v0
.end method

.method public final getCarrierRegion()java.lang.String
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->carrierRegion Ljava/lang/String;
    if-nez v0, +036h
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/utils/AppLocaleUtils;
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    const-string/jumbo v2, phone
    invoke-virtual v1, v2, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v1
    instance-of v2, v1, Landroid/telephony/TelephonyManager;
    if-eqz v2, +005h
    check-cast v1, Landroid/telephony/TelephonyManager;
    goto +2h
    move-object v1, v0
    if-eqz v1, +019h
    invoke-virtual v1, Landroid/telephony/TelephonyManager;->getSimCountryIso()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +013h
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +008h
    move-object v0, v1
    goto +5h
    move-exception v1
    invoke-virtual v1, Ljava/lang/Throwable;->printStackTrace()V
    sput-object v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->carrierRegion Ljava/lang/String;
    return-object v0
    :try_start_0x8
.end method

.method public final getSysLocale()java.util.Locale
    .registers 3
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->isMIUIBuild Z
    if-eqz v0, +007h
    invoke-direct v2, Lcom/bytedance/trae/utils/AppLocaleUtils;->getLocaleFromMIUIIBuild()Ljava/util/Locale;
    move-result-object v0
    goto +25h
    invoke-static Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Configuration;->getLocales()Landroid/os/LocaleList;
    move-result-object v0
    const-string v1, "getLocales(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Landroid/os/LocaleList;->isEmpty()Z
    move-result v1
    if-eqz v1, +007h
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v0
    goto +6h
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/os/LocaleList;->get(I)Ljava/util/Locale;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v0
.end method

.method public final getTimeZone()java.util.TimeZone
    .registers 3
    # ins_size=1
    invoke-static Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;
    move-result-object v0
    invoke-virtual v0, Ljava/util/Calendar;->getTimeZone()Ljava/util/TimeZone;
    move-result-object v0
    const-string v1, "getTimeZone(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method
