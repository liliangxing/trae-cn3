# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
.super Ljava/lang/Enum;
.source "SettingsUiState.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
.field public static final enum BusinessLicense:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
.field public static final enum Community:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
.field public static final enum Contact:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
.field public static final enum Help:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
.field public static final enum IcpFiling:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
.field public static final enum OpenSource:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
.field public static final enum PermissionUsage:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
.field public static final enum PersonalInfoList:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
.field public static final enum Privacy:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
.field public static final enum ShareList:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
.field public static final enum Terms:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;


.method private static final synthetic $values()com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItemKey[]
    .registers 3
    # ins_size=0
    const/16 v0, 11
    new-array v0, v0, [Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Terms Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Privacy Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->OpenSource Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Help Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Community Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Contact Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->PersonalInfoList Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    aput-object v2, v0, v1
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ShareList Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    aput-object v2, v0, v1
    const/16 v1, 8
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->BusinessLicense Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    aput-object v2, v0, v1
    const/16 v1, 9
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->IcpFiling Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    aput-object v2, v0, v1
    const/16 v1, 10
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->PermissionUsage Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    const-string v1, "Terms"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Terms Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    const-string v1, "Privacy"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Privacy Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    const-string v1, "OpenSource"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->OpenSource Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    const-string v1, "Help"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Help Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    const-string v1, "Community"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Community Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    const-string v1, "Contact"
    const/4 v2, 5
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Contact Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    const-string v1, "PersonalInfoList"
    const/4 v2, 6
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->PersonalInfoList Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    const-string v1, "ShareList"
    const/4 v2, 7
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ShareList Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    const-string v1, "BusinessLicense"
    const/16 v2, 8
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->BusinessLicense Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    const-string v1, "IcpFiling"
    const/16 v2, 9
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->IcpFiling Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    const-string v1, "PermissionUsage"
    const/16 v2, 10
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->PermissionUsage Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-static Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->$values()[Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->$VALUES [Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItemKey
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    return-object v1
.end method

.method public static values()com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItemKey[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->$VALUES [Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    return-object v0
.end method
