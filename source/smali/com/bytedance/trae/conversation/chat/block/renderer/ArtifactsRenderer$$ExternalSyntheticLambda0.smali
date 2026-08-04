# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
.field public final synthetic f$1:Landroid/content/Context;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
.field public final synthetic f$3:Lcom/bytedance/trae/im/model/MergeChangedFilesData;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  com.bytedance.trae.im.model.MergeChangedFilesData)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda0;->f$1 Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda0;->f$1 Landroid/content/Context;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    invoke-static v0, v1, v2, v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->$r8$lambda$uqFQAh60aiJYYIV1Q20BIcPTlFk(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Lcom/bytedance/trae/im/model/MergeChangedFilesData; Landroid/view/View;)V
    return-void 
.end method
