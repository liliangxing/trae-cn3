# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
.super Ljava/lang/Enum;
.source "HtmlArtifactRemoteArchiveUrlResolver.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
.field public static final enum INITIALIZING:Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
.field public static final enum READY:Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
.field public static final enum SUBMITTED:Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
.field public static final enum TERMINATED:Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
.field public static final enum TERMINATING:Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
.field public static final enum UNKNOWN:Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
.field private final value:I


.method private static final synthetic $values()com.bytedance.trae.conversation.products.RealtimeSandboxStatus[]
    .registers 3
    # ins_size=0
    const/4 v0, 6
    new-array v0, v0, [Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->UNKNOWN Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->SUBMITTED Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->INITIALIZING Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->READY Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->TERMINATING Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->TERMINATED Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    const-string v1, "UNKNOWN"
    const/4 v2, 0
    invoke-direct v0, v1, v2, v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->UNKNOWN Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    const-string v1, "SUBMITTED"
    const/4 v2, 1
    invoke-direct v0, v1, v2, v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->SUBMITTED Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    const-string v1, "INITIALIZING"
    const/4 v2, 2
    invoke-direct v0, v1, v2, v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->INITIALIZING Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    const-string v1, "READY"
    const/4 v2, 3
    invoke-direct v0, v1, v2, v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->READY Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    const-string v1, "TERMINATING"
    const/4 v2, 4
    invoke-direct v0, v1, v2, v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->TERMINATING Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    const-string v1, "TERMINATED"
    const/4 v2, 5
    invoke-direct v0, v1, v2, v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->TERMINATED Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    invoke-static Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->$values()[Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->$VALUES [Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput v3, v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->value I
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.products.RealtimeSandboxStatus
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.products.RealtimeSandboxStatus[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->$VALUES [Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    return-object v0
.end method

.method public final getValue()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->value I
    return v0
.end method
