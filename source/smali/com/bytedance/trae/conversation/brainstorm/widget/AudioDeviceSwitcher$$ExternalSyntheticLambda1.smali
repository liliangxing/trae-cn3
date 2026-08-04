# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.brainstorm.widget.AudioDeviceSwitcher  com.bytedance.trae.conversation.brainstorm.model.AudioDevice)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->$r8$lambda$RhPuXd0b2ZQ6v71ODFUhIJEFrUA(Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Landroid/view/View;)V
    return-void 
.end method
