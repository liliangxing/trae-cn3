# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/login/api/AccountType;
.super Ljava/lang/Enum;
.source "AccountInfo.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/login/api/AccountType;
.field public static final enum BYTEDANCE:Lcom/bytedance/trae/login/api/AccountType;
.field public static final enum TOB:Lcom/bytedance/trae/login/api/AccountType;
.field public static final enum TOC:Lcom/bytedance/trae/login/api/AccountType;
.field public static final enum UNKNOWN:Lcom/bytedance/trae/login/api/AccountType;
.field private final value:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.login.api.AccountType[]
    .registers 3
    # ins_size=0
    const/4 v0, 4
    new-array v0, v0, [Lcom/bytedance/trae/login/api/AccountType;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/login/api/AccountType;->UNKNOWN Lcom/bytedance/trae/login/api/AccountType;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/login/api/AccountType;->TOC Lcom/bytedance/trae/login/api/AccountType;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/login/api/AccountType;->TOB Lcom/bytedance/trae/login/api/AccountType;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/login/api/AccountType;->BYTEDANCE Lcom/bytedance/trae/login/api/AccountType;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/api/AccountType;
    const/4 v1, 0
    const-string/jumbo v2, unknown
    const-string v3, "UNKNOWN"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/login/api/AccountType;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/login/api/AccountType;->UNKNOWN Lcom/bytedance/trae/login/api/AccountType;
    new-instance v0, Lcom/bytedance/trae/login/api/AccountType;
    const/4 v1, 1
    const-string/jumbo v2, toc
    const-string v3, "TOC"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/login/api/AccountType;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/login/api/AccountType;->TOC Lcom/bytedance/trae/login/api/AccountType;
    new-instance v0, Lcom/bytedance/trae/login/api/AccountType;
    const/4 v1, 2
    const-string/jumbo v2, tob
    const-string v3, "TOB"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/login/api/AccountType;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/login/api/AccountType;->TOB Lcom/bytedance/trae/login/api/AccountType;
    new-instance v0, Lcom/bytedance/trae/login/api/AccountType;
    const/4 v1, 3
    const-string v2, "bytedance"
    const-string v3, "BYTEDANCE"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/login/api/AccountType;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/login/api/AccountType;->BYTEDANCE Lcom/bytedance/trae/login/api/AccountType;
    invoke-static Lcom/bytedance/trae/login/api/AccountType;->$values()[Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/api/AccountType;->$VALUES [Lcom/bytedance/trae/login/api/AccountType;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/api/AccountType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/login/api/AccountType;->value Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/api/AccountType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.login.api.AccountType
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/AccountType;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/AccountType;
    return-object v1
.end method

.method public static values()com.bytedance.trae.login.api.AccountType[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/api/AccountType;->$VALUES [Lcom/bytedance/trae/login/api/AccountType;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/login/api/AccountType;
    return-object v0
.end method

.method public final getValue()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/AccountType;->value Ljava/lang/String;
    return-object v0
.end method
