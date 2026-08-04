# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
.super Ljava/lang/Enum;
.source "AgentContentBlock.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
.field public static final enum COMMAND_RUNNING:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
.field public static final enum FAILED:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
.field public static final enum GENERATING_CODE:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
.field public static final enum PENDING:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
.field public static final enum SUCCESS:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
.field public static final enum THINKING:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;


.method private static final synthetic $values()com.bytedance.trae.conversation.chat.block.AgentContentBlock$TailStatus[]
    .registers 3
    # ins_size=0
    const/4 v0, 6
    new-array v0, v0, [Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->THINKING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->PENDING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->GENERATING_CODE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->COMMAND_RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->SUCCESS Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->FAILED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    const-string v1, "THINKING"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->THINKING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    const-string v1, "PENDING"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->PENDING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    const-string v1, "GENERATING_CODE"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->GENERATING_CODE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    const-string v1, "COMMAND_RUNNING"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->COMMAND_RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    const-string v1, "SUCCESS"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->SUCCESS Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    const-string v1, "FAILED"
    const/4 v2, 5
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->FAILED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    invoke-static Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->$values()[Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->$VALUES [Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.chat.block.AgentContentBlock$TailStatus
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.chat.block.AgentContentBlock$TailStatus[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->$VALUES [Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    return-object v0
.end method
