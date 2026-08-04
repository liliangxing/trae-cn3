# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
.field public final synthetic f$1:Lcom/bytedance/trae/im/model/FileDiffInfo;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
.field public final synthetic f$3:Ljava/util/List;
.field public final synthetic f$4:Landroid/content/Context;
.field public final synthetic f$5:I


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.im.model.FileDiffInfo  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  java.util.List  android.content.Context  int)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/im/model/FileDiffInfo;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;->f$3 Ljava/util/List;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;->f$4 Landroid/content/Context;
    iput v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;->f$5 I
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/im/model/FileDiffInfo;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;->f$3 Ljava/util/List;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;->f$4 Landroid/content/Context;
    iget v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;->f$5 I
    move-object v6, v8
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->$r8$lambda$tjnhMWVgMN7RKyWl9fBIdDBnutY(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/im/model/FileDiffInfo; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Ljava/util/List; Landroid/content/Context; I Landroid/view/View;)V
    return-void 
.end method
