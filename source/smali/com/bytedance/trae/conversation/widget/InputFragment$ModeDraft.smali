# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;
.super Ljava/lang/Object;
.source "InputFragment.kt"

.field private final attachments:Ljava/util/List;
.field private final currentDevice:Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
.field private final currentSkill:Lcom/bytedance/trae/conversation/widget/SkillItem;
.field private final editable:Ljava/lang/CharSequence;


.method public constructor <init>(java.lang.CharSequence  com.bytedance.trae.conversation.widget.SkillItem  java.util.List  com.bytedance.trae.conversation.devices.SelectedDeviceItem)void
    .registers 6
    # ins_size=5
    const-string v0, "editable"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "attachments"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->editable Ljava/lang/CharSequence;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentSkill Lcom/bytedance/trae/conversation/widget/SkillItem;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->attachments Ljava/util/List;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.widget.InputFragment$ModeDraft  java.lang.CharSequence  com.bytedance.trae.conversation.widget.SkillItem  java.util.List  com.bytedance.trae.conversation.devices.SelectedDeviceItem  int  java.lang.Object)com.bytedance.trae.conversation.widget.InputFragment$ModeDraft
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->editable Ljava/lang/CharSequence;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentSkill Lcom/bytedance/trae/conversation/widget/SkillItem;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->attachments Ljava/util/List;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->copy(Ljava/lang/CharSequence; Lcom/bytedance/trae/conversation/widget/SkillItem; Ljava/util/List; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.CharSequence
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->editable Ljava/lang/CharSequence;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.widget.SkillItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentSkill Lcom/bytedance/trae/conversation/widget/SkillItem;
    return-object v0
.end method

.method public final component3()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->attachments Ljava/util/List;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.conversation.devices.SelectedDeviceItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    return-object v0
.end method

.method public final copy(java.lang.CharSequence  com.bytedance.trae.conversation.widget.SkillItem  java.util.List  com.bytedance.trae.conversation.devices.SelectedDeviceItem)com.bytedance.trae.conversation.widget.InputFragment$ModeDraft
    .registers 6
    # ins_size=5
    const-string v0, "editable"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "attachments"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;-><init>(Ljava/lang/CharSequence; Lcom/bytedance/trae/conversation/widget/SkillItem; Ljava/util/List; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->editable Ljava/lang/CharSequence;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->editable Ljava/lang/CharSequence;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentSkill Lcom/bytedance/trae/conversation/widget/SkillItem;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentSkill Lcom/bytedance/trae/conversation/widget/SkillItem;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->attachments Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->attachments Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAttachments()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->attachments Ljava/util/List;
    return-object v0
.end method

.method public final getCurrentDevice()com.bytedance.trae.conversation.devices.SelectedDeviceItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    return-object v0
.end method

.method public final getCurrentSkill()com.bytedance.trae.conversation.widget.SkillItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentSkill Lcom/bytedance/trae/conversation/widget/SkillItem;
    return-object v0
.end method

.method public final getEditable()java.lang.CharSequence
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->editable Ljava/lang/CharSequence;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->editable Ljava/lang/CharSequence;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentSkill Lcom/bytedance/trae/conversation/widget/SkillItem;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/SkillItem;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->attachments Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ModeDraft(editable="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->editable Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", currentSkill="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentSkill Lcom/bytedance/trae/conversation/widget/SkillItem;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", attachments="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->attachments Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", currentDevice="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
