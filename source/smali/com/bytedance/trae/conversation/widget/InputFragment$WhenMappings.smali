# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;
.super Ljava/lang/Object;
.source "InputFragment.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I
.field public static final synthetic $EnumSwitchMapping$1:[I
.field public static final synthetic $EnumSwitchMapping$2:[I
.field public static final synthetic $EnumSwitchMapping$3:[I
.field public static final synthetic $EnumSwitchMapping$4:[I
.field public static final synthetic $EnumSwitchMapping$5:[I
.field public static final synthetic $EnumSwitchMapping$6:[I
.field public static final synthetic $EnumSwitchMapping$7:[I


.method static constructor <clinit>()void
    .registers 7
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->values()[Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->Normal Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->ordinal()I
    move-result v2
    aput v1, v0, v2
    const/4 v2, 2
    sget-object v3, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->HOLD Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->ordinal()I
    move-result v3
    aput v2, v0, v3
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-static Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->values()[Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->SKILLS Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->ordinal()I
    move-result v3
    aput v1, v0, v3
    sget-object v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->PLUGINS Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->ordinal()I
    move-result v3
    aput v2, v0, v3
    const/4 v3, 3
    sget-object v4, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->PHOTO Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->ordinal()I
    move-result v4
    aput v3, v0, v4
    const/4 v4, 4
    sget-object v5, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->FILES Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->ordinal()I
    move-result v5
    aput v4, v0, v5
    const/4 v5, 5
    sget-object v6, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->CAMERA Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->ordinal()I
    move-result v6
    aput v5, v0, v6
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-static Lcom/bytedance/trae/conversation/skill/SkillEntryAction;->values()[Lcom/bytedance/trae/conversation/skill/SkillEntryAction;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v6, Lcom/bytedance/trae/conversation/skill/SkillEntryAction;->OPEN_SKILLS Lcom/bytedance/trae/conversation/skill/SkillEntryAction;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/skill/SkillEntryAction;->ordinal()I
    move-result v6
    aput v1, v0, v6
    sget-object v6, Lcom/bytedance/trae/conversation/skill/SkillEntryAction;->OPEN_IDE_PROJECT_PICKER Lcom/bytedance/trae/conversation/skill/SkillEntryAction;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/skill/SkillEntryAction;->ordinal()I
    move-result v6
    aput v2, v0, v6
    sget-object v6, Lcom/bytedance/trae/conversation/skill/SkillEntryAction;->CHECK_HISTORICAL_IDE_PROJECT Lcom/bytedance/trae/conversation/skill/SkillEntryAction;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/skill/SkillEntryAction;->ordinal()I
    move-result v6
    aput v3, v0, v6
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$2 [I
    invoke-static Lcom/bytedance/trae/im/service/CliType;->values()[Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v6, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v6
    aput v1, v0, v6
    sget-object v6, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v6
    aput v2, v0, v6
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$3 [I
    invoke-static Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;->values()[Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v6, Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;->WORKSPACE_CLOSED Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;->ordinal()I
    move-result v6
    aput v1, v0, v6
    sget-object v6, Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;->DEVICE_OFFLINE Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;->ordinal()I
    move-result v6
    aput v2, v0, v6
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$4 [I
    invoke-static Lcom/bytedance/trae/conversation/widget/ChatMode;->values()[Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v6, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/ChatMode;->ordinal()I
    move-result v6
    aput v1, v0, v6
    sget-object v6, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/ChatMode;->ordinal()I
    move-result v6
    aput v2, v0, v6
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$5 [I
    invoke-static Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->values()[Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v6, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->KEEP Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->ordinal()I
    move-result v6
    aput v1, v0, v6
    sget-object v6, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->HIDE Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->ordinal()I
    move-result v6
    aput v2, v0, v6
    sget-object v6, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->REFRESH Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->ordinal()I
    move-result v6
    aput v3, v0, v6
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$6 [I
    invoke-static Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->values()[Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v6, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Empty Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->ordinal()I
    move-result v6
    aput v1, v0, v6
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Input Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->ordinal()I
    move-result v1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sending Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->ordinal()I
    move-result v1
    aput v3, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sended Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->ordinal()I
    move-result v1
    aput v4, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Stopped Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->ordinal()I
    move-result v1
    aput v5, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$7 [I
    return-void 
    :try_start_0x8
    :try_start_0x11
    :try_start_0x22
    :try_start_0x2a
    :try_start_0x33
    :try_start_0x3c
    :try_start_0x45
    :try_start_0x56
    :try_start_0x5e
    :try_start_0x66
    :try_start_0x77
    :try_start_0x7f
    :try_start_0x90
    :try_start_0x98
    :try_start_0xa9
    :try_start_0xb1
    :try_start_0xc2
    :try_start_0xca
    :try_start_0xd2
    :try_start_0xe3
    :try_start_0xeb
    :try_start_0xf3
    :try_start_0xfb
    :try_start_0x103
.end method
