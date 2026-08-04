# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
.super Ljava/lang/Enum;
.source "FeatureCapabilityScope.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
.field public static final enum SSO:Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
.field public static final enum TOB:Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
.field public static final enum TOC:Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
.field private final remoteKey:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.settings.impl.feature.FeatureCapabilityScope[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->TOC Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->SSO Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->TOB Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    const/4 v1, 0
    const-string/jumbo v2, toc
    const-string v3, "TOC"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->TOC Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    new-instance v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    const/4 v1, 1
    const-string/jumbo v2, sso
    const-string v3, "SSO"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->SSO Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    new-instance v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    const/4 v1, 2
    const-string/jumbo v2, tob
    const-string v3, "TOB"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->TOB Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    invoke-static Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->$values()[Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->$VALUES [Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->remoteKey Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.settings.impl.feature.FeatureCapabilityScope
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    return-object v1
.end method

.method public static values()com.bytedance.trae.settings.impl.feature.FeatureCapabilityScope[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->$VALUES [Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    return-object v0
.end method

.method public final getRemoteKey()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->remoteKey Ljava/lang/String;
    return-object v0
.end method
