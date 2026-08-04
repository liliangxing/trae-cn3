# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
.super Ljava/lang/Enum;
.source "PlanItemGrouper.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
.field public static final enum CANCELED:Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
.field public static final enum FAILED:Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
.field public static final enum PENDING:Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
.field public static final enum RUNNING:Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
.field public static final enum SKIPPED:Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
.field public static final enum SUCCESS:Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
.field public static final enum WAITING_CONFIRM:Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
.field public static final enum WAITING_CONFIRM_REDLIST:Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;


.method private static final synthetic $values()com.bytedance.trae.conversation.chat.grouping.PlanItemExecutionStatus[]
    .registers 3
    # ins_size=0
    const/16 v0, 8
    new-array v0, v0, [Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->SUCCESS Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->FAILED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->SKIPPED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->WAITING_CONFIRM Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->WAITING_CONFIRM_REDLIST Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    aput-object v2, v0, v1
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    const-string v1, "PENDING"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    const-string v1, "RUNNING"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    const-string v1, "SUCCESS"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->SUCCESS Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    const-string v1, "FAILED"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->FAILED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    const-string v1, "SKIPPED"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->SKIPPED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    const-string v1, "WAITING_CONFIRM"
    const/4 v2, 5
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->WAITING_CONFIRM Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    const-string v1, "WAITING_CONFIRM_REDLIST"
    const/4 v2, 6
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->WAITING_CONFIRM_REDLIST Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    const-string v1, "CANCELED"
    const/4 v2, 7
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->$values()[Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->$VALUES [Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.chat.grouping.PlanItemExecutionStatus
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.chat.grouping.PlanItemExecutionStatus[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->$VALUES [Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    return-object v0
.end method
