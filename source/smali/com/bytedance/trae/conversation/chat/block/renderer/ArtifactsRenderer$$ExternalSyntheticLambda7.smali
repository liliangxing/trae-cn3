# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
.field public final synthetic f$1:Lcom/bytedance/trae/im/model/FileDiffInfo;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
.field public final synthetic f$3:Landroid/content/Context;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.im.model.FileDiffInfo  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.content.Context)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda7;->f$1 Lcom/bytedance/trae/im/model/FileDiffInfo;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda7;->f$2 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda7;->f$3 Landroid/content/Context;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda7;->f$1 Lcom/bytedance/trae/im/model/FileDiffInfo;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda7;->f$2 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda7;->f$3 Landroid/content/Context;
    invoke-static v0, v1, v2, v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->$r8$lambda$4Rfml5VAWt25nOwCf8LG6i4Ha-E(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/im/model/FileDiffInfo; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context; Landroid/view/View;)V
    return-void 
.end method
