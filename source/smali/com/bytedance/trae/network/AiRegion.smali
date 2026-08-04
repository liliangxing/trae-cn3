# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/network/AiRegion;
.super Ljava/lang/Enum;
.source "HostResolver.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/network/AiRegion;
.field public static final enum CN:Lcom/bytedance/trae/network/AiRegion;
.field public static final Companion:Lcom/bytedance/trae/network/AiRegion$Companion;
.field public static final enum SG:Lcom/bytedance/trae/network/AiRegion;
.field public static final enum US:Lcom/bytedance/trae/network/AiRegion;


.method private static final synthetic $values()com.bytedance.trae.network.AiRegion[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/network/AiRegion;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/network/AiRegion;->CN Lcom/bytedance/trae/network/AiRegion;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/network/AiRegion;->SG Lcom/bytedance/trae/network/AiRegion;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/network/AiRegion;->US Lcom/bytedance/trae/network/AiRegion;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/AiRegion;
    const-string v1, "CN"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/AiRegion;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/AiRegion;->CN Lcom/bytedance/trae/network/AiRegion;
    new-instance v0, Lcom/bytedance/trae/network/AiRegion;
    const-string v1, "SG"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/AiRegion;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/AiRegion;->SG Lcom/bytedance/trae/network/AiRegion;
    new-instance v0, Lcom/bytedance/trae/network/AiRegion;
    const-string v1, "US"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/AiRegion;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/AiRegion;->US Lcom/bytedance/trae/network/AiRegion;
    invoke-static Lcom/bytedance/trae/network/AiRegion;->$values()[Lcom/bytedance/trae/network/AiRegion;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/AiRegion;->$VALUES [Lcom/bytedance/trae/network/AiRegion;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/AiRegion;->$ENTRIES Lkotlin/enums/EnumEntries;
    new-instance v0, Lcom/bytedance/trae/network/AiRegion$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/network/AiRegion$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/network/AiRegion;->Companion Lcom/bytedance/trae/network/AiRegion$Companion;
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
    sget-object v0, Lcom/bytedance/trae/network/AiRegion;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.network.AiRegion
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/network/AiRegion;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/AiRegion;
    return-object v1
.end method

.method public static values()com.bytedance.trae.network.AiRegion[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/AiRegion;->$VALUES [Lcom/bytedance/trae/network/AiRegion;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/network/AiRegion;
    return-object v0
.end method
