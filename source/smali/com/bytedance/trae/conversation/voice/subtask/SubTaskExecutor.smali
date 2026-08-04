# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
.super Ljava/lang/Enum;
.source "SubTaskProtocol.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
.field public static final enum ClientProxy:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
.field public static final Companion:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;
.field public static final enum ServerClosedLoop:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;


.method private static final synthetic $values()com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor[]
    .registers 3
    # ins_size=0
    const/4 v0, 2
    new-array v0, v0, [Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ServerClosedLoop Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    const-string v1, "ClientProxy"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    const-string v1, "ServerClosedLoop"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ServerClosedLoop Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->$values()[Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->$VALUES [Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->$ENTRIES Lkotlin/enums/EnumEntries;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->Companion Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;
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
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->$VALUES [Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    return-object v0
.end method
