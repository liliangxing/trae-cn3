# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final enum Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
.super Ljava/lang/Enum;
.source "SettingsMainFragment.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
.field public static final enum TeamFlagship:Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
.field public static final enum TeamFlagshipV2:Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
.field public static final enum TeamGroup:Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
.field public static final enum TeamGroupV2:Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
.field private final value:I


.method private static final synthetic $values()com.bytedance.trae.home.solo.setting.SaaSProductType[]
    .registers 3
    # ins_size=0
    const/4 v0, 4
    new-array v0, v0, [Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->TeamGroup Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->TeamGroupV2 Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->TeamFlagship Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->TeamFlagshipV2 Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    const/4 v1, 0
    const/16 v2, 220
    const-string v3, "TeamGroup"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->TeamGroup Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    const/4 v1, 1
    const/16 v2, 221
    const-string v3, "TeamGroupV2"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->TeamGroupV2 Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    const/4 v1, 2
    const/16 v2, 230
    const-string v3, "TeamFlagship"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->TeamFlagship Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    const/4 v1, 3
    const/16 v2, 231
    const-string v3, "TeamFlagshipV2"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->TeamFlagshipV2 Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    invoke-static Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->$values()[Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->$VALUES [Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->value I
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.home.solo.setting.SaaSProductType
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    return-object v1
.end method

.method public static values()com.bytedance.trae.home.solo.setting.SaaSProductType[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->$VALUES [Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/home/solo/setting/SaaSProductType;
    return-object v0
.end method

.method public final getValue()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/SaaSProductType;->value I
    return v0
.end method
