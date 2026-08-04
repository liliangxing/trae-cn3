# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$WhenMappings;
.super Ljava/lang/Object;
.source "DiscussingFragment.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I
.field public static final synthetic $EnumSwitchMapping$1:[I
.field public static final synthetic $EnumSwitchMapping$2:[I
.field public static final synthetic $EnumSwitchMapping$3:[I


.method static constructor <clinit>()void
    .registers 7
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->values()[Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->CAMERA Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->ordinal()I
    move-result v2
    aput v1, v0, v2
    const/4 v2, 2
    sget-object v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->PHOTO Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->ordinal()I
    move-result v3
    aput v2, v0, v3
    const/4 v3, 3
    sget-object v4, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->FILES Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->ordinal()I
    move-result v4
    aput v3, v0, v4
    const/4 v4, 4
    sget-object v5, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->SKILLS Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->ordinal()I
    move-result v5
    aput v4, v0, v5
    const/4 v5, 5
    sget-object v6, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->PLUGINS Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->ordinal()I
    move-result v6
    aput v5, v0, v6
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->values()[Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->Speaker Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->ordinal()I
    move-result v6
    aput v1, v0, v6
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->Earpiece Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->ordinal()I
    move-result v6
    aput v2, v0, v6
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->values()[Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Prompt Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->ordinal()I
    move-result v6
    aput v1, v0, v6
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Listening Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->ordinal()I
    move-result v6
    aput v2, v0, v6
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Thinking Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->ordinal()I
    move-result v6
    aput v3, v0, v6
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Answering Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->ordinal()I
    move-result v6
    aput v4, v0, v6
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskRunning Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->ordinal()I
    move-result v4
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskRunningLong Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->ordinal()I
    move-result v4
    const/4 v5, 6
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskDone Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->ordinal()I
    move-result v4
    const/4 v5, 7
    aput v5, v0, v4
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$WhenMappings;->$EnumSwitchMapping$2 [I
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->values()[Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->HIDDEN Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->ordinal()I
    move-result v4
    aput v1, v0, v4
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->STATUS Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->ordinal()I
    move-result v1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->SUBTITLE Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->ordinal()I
    move-result v1
    aput v3, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$WhenMappings;->$EnumSwitchMapping$3 [I
    return-void 
    :try_start_0x8
    :try_start_0x11
    :try_start_0x1a
    :try_start_0x23
    :try_start_0x2c
    :try_start_0x3d
    :try_start_0x45
    :try_start_0x56
    :try_start_0x5e
    :try_start_0x66
    :try_start_0x6e
    :try_start_0x76
    :try_start_0x7e
    :try_start_0x87
    :try_start_0x99
    :try_start_0xa1
    :try_start_0xa9
.end method
