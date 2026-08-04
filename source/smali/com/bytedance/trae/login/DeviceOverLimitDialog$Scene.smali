# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
.super Ljava/lang/Enum;
.source "DeviceOverLimitDialog.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
.field public static final enum EXCHANGE:Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
.field public static final enum LOGIN:Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
.field public static final enum REBIND:Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;


.method private static final synthetic $values()com.bytedance.trae.login.DeviceOverLimitDialog$Scene[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->LOGIN Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->REBIND Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->EXCHANGE Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    const-string v1, "LOGIN"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->LOGIN Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    new-instance v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    const-string v1, "REBIND"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->REBIND Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    new-instance v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    const-string v1, "EXCHANGE"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->EXCHANGE Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    invoke-static Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->$values()[Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->$VALUES [Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.login.DeviceOverLimitDialog$Scene
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    return-object v1
.end method

.method public static values()com.bytedance.trae.login.DeviceOverLimitDialog$Scene[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->$VALUES [Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    return-object v0
.end method
