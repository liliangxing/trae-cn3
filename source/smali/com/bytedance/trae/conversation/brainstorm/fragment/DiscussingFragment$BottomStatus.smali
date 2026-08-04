# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final enum Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
.super Ljava/lang/Enum;
.source "DiscussingFragment.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
.field public static final enum Answering:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
.field public static final enum Listening:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
.field public static final enum Prompt:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
.field public static final enum TaskDone:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
.field public static final enum TaskRunning:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
.field public static final enum TaskRunningLong:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
.field public static final enum Thinking:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;


.method private static final synthetic $values()com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$BottomStatus[]
    .registers 3
    # ins_size=0
    const/4 v0, 7
    new-array v0, v0, [Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Prompt Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Listening Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Thinking Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Answering Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskRunning Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskRunningLong Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskDone Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    const-string v1, "Prompt"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Prompt Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    const-string v1, "Listening"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Listening Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    const-string v1, "Thinking"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Thinking Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    const-string v1, "Answering"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Answering Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    const-string v1, "TaskRunning"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskRunning Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    const-string v1, "TaskRunningLong"
    const/4 v2, 5
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskRunningLong Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    const-string v1, "TaskDone"
    const/4 v2, 6
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskDone Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->$values()[Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->$VALUES [Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$BottomStatus
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$BottomStatus[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->$VALUES [Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    return-object v0
.end method
