# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/network/TransportMode;
.super Ljava/lang/Enum;
.source "HubNetConnection.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/network/TransportMode;
.field public static final enum CONNECTING:Lcom/bytedance/trae/network/TransportMode;
.field public static final enum HTTP_FALLBACK:Lcom/bytedance/trae/network/TransportMode;
.field public static final enum IDLE:Lcom/bytedance/trae/network/TransportMode;
.field public static final enum SHUTDOWN:Lcom/bytedance/trae/network/TransportMode;
.field public static final enum SSE:Lcom/bytedance/trae/network/TransportMode;
.field public static final enum WEBSOCKET:Lcom/bytedance/trae/network/TransportMode;


.method private static final synthetic $values()com.bytedance.trae.network.TransportMode[]
    .registers 3
    # ins_size=0
    const/4 v0, 6
    new-array v0, v0, [Lcom/bytedance/trae/network/TransportMode;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/network/TransportMode;->IDLE Lcom/bytedance/trae/network/TransportMode;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/network/TransportMode;->CONNECTING Lcom/bytedance/trae/network/TransportMode;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/network/TransportMode;->WEBSOCKET Lcom/bytedance/trae/network/TransportMode;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/network/TransportMode;->SSE Lcom/bytedance/trae/network/TransportMode;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/network/TransportMode;->SHUTDOWN Lcom/bytedance/trae/network/TransportMode;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/TransportMode;
    const-string v1, "IDLE"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/TransportMode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/TransportMode;->IDLE Lcom/bytedance/trae/network/TransportMode;
    new-instance v0, Lcom/bytedance/trae/network/TransportMode;
    const-string v1, "CONNECTING"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/TransportMode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/TransportMode;->CONNECTING Lcom/bytedance/trae/network/TransportMode;
    new-instance v0, Lcom/bytedance/trae/network/TransportMode;
    const-string v1, "WEBSOCKET"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/TransportMode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/TransportMode;->WEBSOCKET Lcom/bytedance/trae/network/TransportMode;
    new-instance v0, Lcom/bytedance/trae/network/TransportMode;
    const-string v1, "SSE"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/TransportMode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/TransportMode;->SSE Lcom/bytedance/trae/network/TransportMode;
    new-instance v0, Lcom/bytedance/trae/network/TransportMode;
    const-string v1, "HTTP_FALLBACK"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/TransportMode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    new-instance v0, Lcom/bytedance/trae/network/TransportMode;
    const-string v1, "SHUTDOWN"
    const/4 v2, 5
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/TransportMode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/TransportMode;->SHUTDOWN Lcom/bytedance/trae/network/TransportMode;
    invoke-static Lcom/bytedance/trae/network/TransportMode;->$values()[Lcom/bytedance/trae/network/TransportMode;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/TransportMode;->$VALUES [Lcom/bytedance/trae/network/TransportMode;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/TransportMode;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/network/TransportMode;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.network.TransportMode
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/network/TransportMode;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/TransportMode;
    return-object v1
.end method

.method public static values()com.bytedance.trae.network.TransportMode[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/TransportMode;->$VALUES [Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/network/TransportMode;
    return-object v0
.end method
