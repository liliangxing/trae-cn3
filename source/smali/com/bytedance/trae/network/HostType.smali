# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/network/HostType;
.super Ljava/lang/Enum;
.source "HostResolver.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/network/HostType;
.field public static final enum AI:Lcom/bytedance/trae/network/HostType;
.field public static final enum COMMUNITY:Lcom/bytedance/trae/network/HostType;
.field public static final enum DOCS:Lcom/bytedance/trae/network/HostType;
.field public static final enum IMAGEX:Lcom/bytedance/trae/network/HostType;
.field public static final enum LOGIN:Lcom/bytedance/trae/network/HostType;
.field public static final enum MARKETPLACE:Lcom/bytedance/trae/network/HostType;
.field public static final enum MSSDK:Lcom/bytedance/trae/network/HostType;
.field public static final enum NOTIFICATION:Lcom/bytedance/trae/network/HostType;
.field public static final enum ONLINE:Lcom/bytedance/trae/network/HostType;
.field public static final enum PASSPORT:Lcom/bytedance/trae/network/HostType;
.field public static final enum PLUGIN_WEB:Lcom/bytedance/trae/network/HostType;
.field public static final enum PRAISE:Lcom/bytedance/trae/network/HostType;
.field public static final enum REMOTE:Lcom/bytedance/trae/network/HostType;
.field public static final enum SETTINGS:Lcom/bytedance/trae/network/HostType;
.field public static final enum WEBSITE:Lcom/bytedance/trae/network/HostType;


.method private static final synthetic $values()com.bytedance.trae.network.HostType[]
    .registers 3
    # ins_size=0
    const/16 v0, 15
    new-array v0, v0, [Lcom/bytedance/trae/network/HostType;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/network/HostType;->ONLINE Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/network/HostType;->LOGIN Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/network/HostType;->REMOTE Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/network/HostType;->IMAGEX Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/network/HostType;->MSSDK Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/network/HostType;->PASSPORT Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/network/HostType;->SETTINGS Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/16 v1, 8
    sget-object v2, Lcom/bytedance/trae/network/HostType;->PRAISE Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/16 v1, 9
    sget-object v2, Lcom/bytedance/trae/network/HostType;->NOTIFICATION Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/16 v1, 10
    sget-object v2, Lcom/bytedance/trae/network/HostType;->MARKETPLACE Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/16 v1, 11
    sget-object v2, Lcom/bytedance/trae/network/HostType;->WEBSITE Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/16 v1, 12
    sget-object v2, Lcom/bytedance/trae/network/HostType;->DOCS Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/16 v1, 13
    sget-object v2, Lcom/bytedance/trae/network/HostType;->COMMUNITY Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    const/16 v1, 14
    sget-object v2, Lcom/bytedance/trae/network/HostType;->PLUGIN_WEB Lcom/bytedance/trae/network/HostType;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "ONLINE"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->ONLINE Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "LOGIN"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->LOGIN Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "AI"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "REMOTE"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->REMOTE Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "IMAGEX"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->IMAGEX Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "MSSDK"
    const/4 v2, 5
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->MSSDK Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "PASSPORT"
    const/4 v2, 6
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->PASSPORT Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "SETTINGS"
    const/4 v2, 7
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->SETTINGS Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "PRAISE"
    const/16 v2, 8
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->PRAISE Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "NOTIFICATION"
    const/16 v2, 9
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->NOTIFICATION Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "MARKETPLACE"
    const/16 v2, 10
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->MARKETPLACE Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "WEBSITE"
    const/16 v2, 11
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->WEBSITE Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "DOCS"
    const/16 v2, 12
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->DOCS Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "COMMUNITY"
    const/16 v2, 13
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->COMMUNITY Lcom/bytedance/trae/network/HostType;
    new-instance v0, Lcom/bytedance/trae/network/HostType;
    const-string v1, "PLUGIN_WEB"
    const/16 v2, 14
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/network/HostType;->PLUGIN_WEB Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostType;->$values()[Lcom/bytedance/trae/network/HostType;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/HostType;->$VALUES [Lcom/bytedance/trae/network/HostType;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/HostType;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/network/HostType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.network.HostType
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/network/HostType;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/HostType;
    return-object v1
.end method

.method public static values()com.bytedance.trae.network.HostType[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HostType;->$VALUES [Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/network/HostType;
    return-object v0
.end method
