# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
.super Ljava/lang/Enum;
.source "UserPayStatusApi.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/UserPayIdentity$Companion;
.field public static final enum FREE:Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
.field public static final enum LITE:Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
.field public static final enum PRO:Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
.field public static final enum PRO_PLUS:Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
.field public static final enum TRIAL:Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
.field public static final enum ULTRA:Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
.field private final displayText:Ljava/lang/String;
.field private final value:I


.method private static final synthetic $values()com.bytedance.trae.home.solo.setting.UserPayIdentity[]
    .registers 3
    # ins_size=0
    const/4 v0, 6
    new-array v0, v0, [Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->FREE Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->PRO Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->PRO_PLUS Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->ULTRA Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->TRIAL Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->LITE Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 5
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    const/4 v1, 0
    const-string v2, "Free"
    const-string v3, "FREE"
    invoke-direct v0, v3, v1, v1, v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;-><init>(Ljava/lang/String; I I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->FREE Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    const-string v1, "PRO"
    const/4 v2, 1
    const-string v3, "Pro"
    invoke-direct v0, v1, v2, v2, v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;-><init>(Ljava/lang/String; I I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->PRO Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    const/4 v1, 2
    const-string v2, "Pro+"
    const-string v4, "PRO_PLUS"
    invoke-direct v0, v4, v1, v1, v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;-><init>(Ljava/lang/String; I I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->PRO_PLUS Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    const/4 v1, 3
    const-string v2, "Ultra"
    const-string v4, "ULTRA"
    invoke-direct v0, v4, v1, v1, v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;-><init>(Ljava/lang/String; I I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->ULTRA Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    const-string v1, "TRIAL"
    const/4 v2, 4
    invoke-direct v0, v1, v2, v2, v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;-><init>(Ljava/lang/String; I I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->TRIAL Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    const/4 v1, 5
    const-string v2, "Lite"
    const-string v3, "LITE"
    invoke-direct v0, v3, v1, v1, v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;-><init>(Ljava/lang/String; I I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->LITE Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    invoke-static Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->$values()[Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->$VALUES [Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->$ENTRIES Lkotlin/enums/EnumEntries;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->Companion Lcom/bytedance/trae/home/solo/setting/UserPayIdentity$Companion;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  int  java.lang.String)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->value I
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->displayText Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.home.solo.setting.UserPayIdentity
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    return-object v1
.end method

.method public static values()com.bytedance.trae.home.solo.setting.UserPayIdentity[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->$VALUES [Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    return-object v0
.end method

.method public final getDisplayText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->displayText Ljava/lang/String;
    return-object v0
.end method

.method public final getValue()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->value I
    return v0
.end method
