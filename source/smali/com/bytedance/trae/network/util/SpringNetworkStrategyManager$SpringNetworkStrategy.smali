# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
.super Ljava/lang/Enum;
.source "SpringNetwokStrategyManager.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
.field public static final enum CUSTOMER_SECOND_STRATEGY:Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
.field private final sceneName:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.network.util.SpringNetworkStrategyManager$SpringNetworkStrategy[]
    .registers 3
    # ins_size=0
    const/4 v0, 1
    new-array v0, v0, [Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->CUSTOMER_SECOND_STRATEGY Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    const/4 v1, 0
    const-string v2, "delay_customer_second_strategy"
    const-string v3, "CUSTOMER_SECOND_STRATEGY"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->CUSTOMER_SECOND_STRATEGY Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    invoke-static Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->$values()[Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->$VALUES [Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->sceneName Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.network.util.SpringNetworkStrategyManager$SpringNetworkStrategy
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    return-object v1
.end method

.method public static values()com.bytedance.trae.network.util.SpringNetworkStrategyManager$SpringNetworkStrategy[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->$VALUES [Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    return-object v0
.end method

.method public final getSceneName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->sceneName Ljava/lang/String;
    return-object v0
.end method
