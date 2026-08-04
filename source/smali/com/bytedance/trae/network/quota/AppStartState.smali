# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/network/quota/AppStartState;
.super Ljava/lang/Enum;
.source "AppStartState.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/network/quota/AppStartState;
.field public static final enum ColdStart:Lcom/bytedance/trae/network/quota/AppStartState;
.field public static final enum HotStart:Lcom/bytedance/trae/network/quota/AppStartState;
.field public static final enum NormalStart:Lcom/bytedance/trae/network/quota/AppStartState;
.field public static final enum WarmStart:Lcom/bytedance/trae/network/quota/AppStartState;
.field private final value:I


.method private static final synthetic $values()com.bytedance.trae.network.quota.AppStartState[]
    .registers 3
    # ins_size=0
    const/4 v0, 4
    new-array v0, v0, [Lcom/bytedance/trae/network/quota/AppStartState;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/network/quota/AppStartState;->NormalStart Lcom/bytedance/trae/network/quota/AppStartState;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/network/quota/AppStartState;->ColdStart Lcom/bytedance/trae/network/quota/AppStartState;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/network/quota/AppStartState;->HotStart Lcom/bytedance/trae/network/quota/AppStartState;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/network/quota/AppStartState;->WarmStart Lcom/bytedance/trae/network/quota/AppStartState;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/quota/AppStartState;
    const/4 v1, -1
    const-string v2, "NormalStart"
    const/4 v3, 0
    invoke-direct v0, v2, v3, v1, Lcom/bytedance/trae/network/quota/AppStartState;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/quota/AppStartState;->NormalStart Lcom/bytedance/trae/network/quota/AppStartState;
    new-instance v0, Lcom/bytedance/trae/network/quota/AppStartState;
    const-string v1, "ColdStart"
    const/4 v2, 1
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/network/quota/AppStartState;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/quota/AppStartState;->ColdStart Lcom/bytedance/trae/network/quota/AppStartState;
    new-instance v0, Lcom/bytedance/trae/network/quota/AppStartState;
    const-string v1, "HotStart"
    const/4 v3, 2
    invoke-direct v0, v1, v3, v2, Lcom/bytedance/trae/network/quota/AppStartState;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/quota/AppStartState;->HotStart Lcom/bytedance/trae/network/quota/AppStartState;
    new-instance v0, Lcom/bytedance/trae/network/quota/AppStartState;
    const-string v1, "WarmStart"
    const/4 v2, 3
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/network/quota/AppStartState;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/network/quota/AppStartState;->WarmStart Lcom/bytedance/trae/network/quota/AppStartState;
    invoke-static Lcom/bytedance/trae/network/quota/AppStartState;->$values()[Lcom/bytedance/trae/network/quota/AppStartState;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/quota/AppStartState;->$VALUES [Lcom/bytedance/trae/network/quota/AppStartState;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/quota/AppStartState;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput v3, v0, Lcom/bytedance/trae/network/quota/AppStartState;->value I
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/quota/AppStartState;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.network.quota.AppStartState
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/network/quota/AppStartState;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/quota/AppStartState;
    return-object v1
.end method

.method public static values()com.bytedance.trae.network.quota.AppStartState[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/quota/AppStartState;->$VALUES [Lcom/bytedance/trae/network/quota/AppStartState;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/network/quota/AppStartState;
    return-object v0
.end method

.method public final getValue()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/quota/AppStartState;->value I
    return v0
.end method
