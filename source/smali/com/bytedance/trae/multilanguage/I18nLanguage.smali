# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/multilanguage/I18nLanguage;
.super Ljava/lang/Enum;
.source "I18nTextProvider.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/multilanguage/I18nLanguage;
.field public static final Companion:Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;
.field public static final enum EN:Lcom/bytedance/trae/multilanguage/I18nLanguage;
.field public static final enum JA:Lcom/bytedance/trae/multilanguage/I18nLanguage;
.field public static final enum ZH:Lcom/bytedance/trae/multilanguage/I18nLanguage;
.field private final code:Ljava/lang/String;
.field private final locale:Ljava/util/Locale;


.method private static final synthetic $values()com.bytedance.trae.multilanguage.I18nLanguage[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/multilanguage/I18nLanguage;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/multilanguage/I18nLanguage;->EN Lcom/bytedance/trae/multilanguage/I18nLanguage;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/multilanguage/I18nLanguage;->ZH Lcom/bytedance/trae/multilanguage/I18nLanguage;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/multilanguage/I18nLanguage;->JA Lcom/bytedance/trae/multilanguage/I18nLanguage;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 5
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;
    sget-object v1, Ljava/util/Locale;->ENGLISH Ljava/util/Locale;
    const-string v2, "ENGLISH"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "EN"
    const/4 v3, 0
    const-string v4, "en"
    invoke-direct v0, v2, v3, v4, v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;-><init>(Ljava/lang/String; I Ljava/lang/String; Ljava/util/Locale;)V
    sput-object v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;->EN Lcom/bytedance/trae/multilanguage/I18nLanguage;
    new-instance v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;
    sget-object v1, Ljava/util/Locale;->SIMPLIFIED_CHINESE Ljava/util/Locale;
    const-string v2, "SIMPLIFIED_CHINESE"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "ZH"
    const/4 v3, 1
    const-string/jumbo v4, zh
    invoke-direct v0, v2, v3, v4, v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;-><init>(Ljava/lang/String; I Ljava/lang/String; Ljava/util/Locale;)V
    sput-object v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;->ZH Lcom/bytedance/trae/multilanguage/I18nLanguage;
    new-instance v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;
    sget-object v1, Ljava/util/Locale;->JAPANESE Ljava/util/Locale;
    const-string v2, "JAPANESE"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "JA"
    const/4 v3, 2
    const-string v4, "ja"
    invoke-direct v0, v2, v3, v4, v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;-><init>(Ljava/lang/String; I Ljava/lang/String; Ljava/util/Locale;)V
    sput-object v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;->JA Lcom/bytedance/trae/multilanguage/I18nLanguage;
    invoke-static Lcom/bytedance/trae/multilanguage/I18nLanguage;->$values()[Lcom/bytedance/trae/multilanguage/I18nLanguage;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;->$VALUES [Lcom/bytedance/trae/multilanguage/I18nLanguage;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;->$ENTRIES Lkotlin/enums/EnumEntries;
    new-instance v0, Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;->Companion Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String  java.util.Locale)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;->code Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;->locale Ljava/util/Locale;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.multilanguage.I18nLanguage
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;
    return-object v1
.end method

.method public static values()com.bytedance.trae.multilanguage.I18nLanguage[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;->$VALUES [Lcom/bytedance/trae/multilanguage/I18nLanguage;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/multilanguage/I18nLanguage;
    return-object v0
.end method

.method public final getCode()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;->code Ljava/lang/String;
    return-object v0
.end method

.method public final getLocale()java.util.Locale
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;->locale Ljava/util/Locale;
    return-object v0
.end method
