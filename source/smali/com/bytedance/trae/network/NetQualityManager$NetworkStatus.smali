# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.super Ljava/lang/Enum;
.source "NetQualityManager.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field public static final enum DISCONNECTED:Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field public static final enum EXCELLENT_4G:Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field public static final enum FAKE:Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field public static final enum GOOD_2G:Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field public static final enum GOOD_4G:Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field public static final enum NET_DEFAULT:Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field public static final enum NORMAL_3G:Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field public static final enum NORMAL_4G:Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field public static final enum POOR_2G:Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field public static final enum POOR_4G:Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field public static final enum UNKNOWN:Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field private final value:I


.method private static final synthetic $values()com.bytedance.trae.network.NetQualityManager$NetworkStatus[]
    .registers 3
    # ins_size=0
    const/16 v0, 11
    new-array v0, v0, [Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->FAKE Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->UNKNOWN Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->DISCONNECTED Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->POOR_2G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->GOOD_2G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->NORMAL_3G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->POOR_4G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    aput-object v2, v0, v1
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->NORMAL_4G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    aput-object v2, v0, v1
    const/16 v1, 8
    sget-object v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->GOOD_4G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    aput-object v2, v0, v1
    const/16 v1, 9
    sget-object v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->EXCELLENT_4G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    aput-object v2, v0, v1
    const/16 v1, 10
    sget-object v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->NET_DEFAULT Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    const/4 v1, -1
    const-string v2, "FAKE"
    const/4 v3, 0
    invoke-direct v0, v2, v3, v1, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->FAKE Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    new-instance v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    const-string v1, "UNKNOWN"
    const/4 v2, 1
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->UNKNOWN Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    new-instance v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    const-string v1, "DISCONNECTED"
    const/4 v3, 2
    invoke-direct v0, v1, v3, v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->DISCONNECTED Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    new-instance v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    const-string v1, "POOR_2G"
    const/4 v2, 3
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->POOR_2G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    new-instance v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    const-string v1, "GOOD_2G"
    const/4 v3, 4
    invoke-direct v0, v1, v3, v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->GOOD_2G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    new-instance v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    const-string v1, "NORMAL_3G"
    const/4 v2, 5
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->NORMAL_3G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    new-instance v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    const-string v1, "POOR_4G"
    const/4 v3, 6
    invoke-direct v0, v1, v3, v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->POOR_4G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    new-instance v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    const-string v1, "NORMAL_4G"
    const/4 v2, 7
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->NORMAL_4G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    new-instance v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    const-string v1, "GOOD_4G"
    const/16 v3, 8
    invoke-direct v0, v1, v3, v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->GOOD_4G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    new-instance v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    const-string v1, "EXCELLENT_4G"
    const/16 v2, 9
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->EXCELLENT_4G Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    new-instance v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    const/16 v1, 10
    const/16 v2, -10000
    const-string v3, "NET_DEFAULT"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->NET_DEFAULT Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    invoke-static Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->$values()[Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->$VALUES [Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput v3, v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->value I
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.network.NetQualityManager$NetworkStatus
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    return-object v1
.end method

.method public static values()com.bytedance.trae.network.NetQualityManager$NetworkStatus[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->$VALUES [Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    return-object v0
.end method

.method public final getValue()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->value I
    return v0
.end method
