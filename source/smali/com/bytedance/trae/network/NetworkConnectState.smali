# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/network/NetworkConnectState;
.super Ljava/lang/Enum;
.source "NetworkConnectState.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/network/NetworkConnectState;
.field public static final enum CONNECTED:Lcom/bytedance/trae/network/NetworkConnectState;
.field public static final enum CONNECTING:Lcom/bytedance/trae/network/NetworkConnectState;
.field public static final Companion:Lcom/bytedance/trae/network/NetworkConnectState$Companion;
.field public static final enum DISCONNECTED:Lcom/bytedance/trae/network/NetworkConnectState;
.field private final value:I


.method private static final synthetic $values()com.bytedance.trae.network.NetworkConnectState[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/network/NetworkConnectState;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/network/NetworkConnectState;->DISCONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/network/NetworkConnectState;->CONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/network/NetworkConnectState;->CONNECTING Lcom/bytedance/trae/network/NetworkConnectState;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/NetworkConnectState;
    const-string v1, "DISCONNECTED"
    const/4 v2, 0
    invoke-direct v0, v1, v2, v2, Lcom/bytedance/trae/network/NetworkConnectState;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->DISCONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    new-instance v0, Lcom/bytedance/trae/network/NetworkConnectState;
    const-string v1, "CONNECTED"
    const/4 v2, 1
    invoke-direct v0, v1, v2, v2, Lcom/bytedance/trae/network/NetworkConnectState;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->CONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    new-instance v0, Lcom/bytedance/trae/network/NetworkConnectState;
    const-string v1, "CONNECTING"
    const/4 v2, 2
    invoke-direct v0, v1, v2, v2, Lcom/bytedance/trae/network/NetworkConnectState;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->CONNECTING Lcom/bytedance/trae/network/NetworkConnectState;
    invoke-static Lcom/bytedance/trae/network/NetworkConnectState;->$values()[Lcom/bytedance/trae/network/NetworkConnectState;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->$VALUES [Lcom/bytedance/trae/network/NetworkConnectState;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->$ENTRIES Lkotlin/enums/EnumEntries;
    new-instance v0, Lcom/bytedance/trae/network/NetworkConnectState$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/network/NetworkConnectState$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->Companion Lcom/bytedance/trae/network/NetworkConnectState$Companion;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput v3, v0, Lcom/bytedance/trae/network/NetworkConnectState;->value I
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.network.NetworkConnectState
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/network/NetworkConnectState;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/NetworkConnectState;
    return-object v1
.end method

.method public static values()com.bytedance.trae.network.NetworkConnectState[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->$VALUES [Lcom/bytedance/trae/network/NetworkConnectState;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/network/NetworkConnectState;
    return-object v0
.end method

.method public final getValue()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/NetworkConnectState;->value I
    return v0
.end method
