# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;
.super Ljava/lang/Object;
.source "SkillEntryPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;->INSTANCE Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final actionFor(com.bytedance.trae.conversation.devices.SelectedDeviceItem  boolean)com.bytedance.trae.conversation.skill.SkillEntryAction
    .registers 5
    # ins_size=3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const/4 v0, -1
    goto +9h
    sget-object v1, Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    if-ne v0, v1, +034h
    if-nez v4, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/skill/SkillEntryAction;->CHECK_HISTORICAL_IDE_PROJECT Lcom/bytedance/trae/conversation/skill/SkillEntryAction;
    goto +30h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getProjectId()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v0, 0
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v0
    goto +2h
    move v4, v1
    if-nez v4, +017h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00ah
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move v1, v0
    if-nez v1, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/skill/SkillEntryAction;->OPEN_SKILLS Lcom/bytedance/trae/conversation/skill/SkillEntryAction;
    goto +6h
    sget-object v3, Lcom/bytedance/trae/conversation/skill/SkillEntryAction;->OPEN_IDE_PROJECT_PICKER Lcom/bytedance/trae/conversation/skill/SkillEntryAction;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/skill/SkillEntryAction;->OPEN_SKILLS Lcom/bytedance/trae/conversation/skill/SkillEntryAction;
    return-object v3
.end method

.method public final canOpenCheckedIdeSkills(com.bytedance.trae.conversation.devices.SelectedDeviceItem)boolean
    .registers 5
    # ins_size=2
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    const/4 v2, 0
    if-ne v0, v1, +020h
    sget-object v0, Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;->INSTANCE Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;->isUnavailable(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Z
    move-result v0
    if-nez v0, +018h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v0, 1
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v2
    goto +2h
    move v4, v0
    if-nez v4, +003h
    move v2, v0
    return v2
.end method

.method public final unavailableToastForCheckedIdeSkills(com.bytedance.trae.conversation.devices.SelectedDeviceItem)com.bytedance.trae.conversation.skill.SkillEntryUnavailableToast
    .registers 4
    # ins_size=2
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v1, +00bh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->isProjectAvailable()Z
    move-result v3
    if-nez v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;->WORKSPACE_CLOSED Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;->DEVICE_OFFLINE Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;
    return-object v3
.end method
