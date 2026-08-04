# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
.super Ljava/lang/Enum;
.source "AccountUtils.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
.field public static final enum ELEVEN:Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
.field public static final enum TEN:Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;


.method private static final synthetic $values()com.bytedance.trae.login.AccountUtils$MobileTotalLength[]
    .registers 3
    # ins_size=0
    const/4 v0, 2
    new-array v0, v0, [Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;->TEN Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;->ELEVEN Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
    const-string v1, "TEN"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;->TEN Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
    new-instance v0, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
    const-string v1, "ELEVEN"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;->ELEVEN Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
    invoke-static Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;->$values()[Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;->$VALUES [Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.login.AccountUtils$MobileTotalLength
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
    return-object v1
.end method

.method public static values()com.bytedance.trae.login.AccountUtils$MobileTotalLength[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;->$VALUES [Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;
    return-object v0
.end method
