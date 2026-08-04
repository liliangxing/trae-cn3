# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1$WhenMappings;
.super Ljava/lang/Object;
.source "BrainstormViewModel.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I
.field public static final synthetic $EnumSwitchMapping$1:[I
.field public static final synthetic $EnumSwitchMapping$2:[I


.method static constructor <clinit>()void
    .registers 6
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->values()[Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->Starting Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->ordinal()I
    move-result v2
    aput v1, v0, v2
    const/4 v2, 2
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->JoiningRoom Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->ordinal()I
    move-result v3
    aput v2, v0, v3
    const/4 v3, 3
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->JoinedRoom Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->ordinal()I
    move-result v4
    aput v3, v0, v4
    const/4 v4, 4
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->Stopped Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->ordinal()I
    move-result v5
    aput v4, v0, v5
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->values()[Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->USER Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->ordinal()I
    move-result v5
    aput v1, v0, v5
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->BOT Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->ordinal()I
    move-result v5
    aput v2, v0, v5
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->values()[Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->API_REQUEST_START Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->ordinal()I
    move-result v5
    aput v1, v0, v5
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->API_REQUEST_END_JOIN_ROOM_START Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->ordinal()I
    move-result v1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->JOIN_ROOM_SUCCESS Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->ordinal()I
    move-result v1
    aput v3, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->BOT_JOINED Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->ordinal()I
    move-result v1
    aput v4, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1$WhenMappings;->$EnumSwitchMapping$2 [I
    return-void 
    :try_start_0x8
    :try_start_0x11
    :try_start_0x1a
    :try_start_0x23
    :try_start_0x34
    :try_start_0x3c
    :try_start_0x4d
    :try_start_0x55
    :try_start_0x5d
    :try_start_0x65
.end method
