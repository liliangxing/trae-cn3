# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda14;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/im/model/FileDiffInfo;
.field public final synthetic f$1:Landroid/content/Context;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
.field public final synthetic f$3:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;


.method public synthetic constructor <init>(com.bytedance.trae.im.model.FileDiffInfo  android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda14;->f$0 Lcom/bytedance/trae/im/model/FileDiffInfo;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda14;->f$1 Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda14;->f$2 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda14;->f$3 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda14;->f$0 Lcom/bytedance/trae/im/model/FileDiffInfo;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda14;->f$1 Landroid/content/Context;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda14;->f$2 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda14;->f$3 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    invoke-static v0, v1, v2, v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->$r8$lambda$j4km-_fd8J7HJOZocwSgjEluhJY(Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Landroid/view/View;)V
    return-void 
.end method
