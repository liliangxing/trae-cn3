# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda12;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
.field public final synthetic f$1:Landroid/content/Context;
.field public final synthetic f$2:Lcom/bytedance/trae/im/model/ChangedFileData;
.field public final synthetic f$3:Lcom/bytedance/trae/im/service/Conversation;
.field public final synthetic f$4:Ljava/lang/Long;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  android.content.Context  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.service.Conversation  java.lang.Long)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda12;->f$0 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda12;->f$1 Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda12;->f$2 Lcom/bytedance/trae/im/model/ChangedFileData;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda12;->f$3 Lcom/bytedance/trae/im/service/Conversation;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda12;->f$4 Ljava/lang/Long;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda12;->f$0 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda12;->f$1 Landroid/content/Context;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda12;->f$2 Lcom/bytedance/trae/im/model/ChangedFileData;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda12;->f$3 Lcom/bytedance/trae/im/service/Conversation;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda12;->f$4 Ljava/lang/Long;
    move-object v5, v7
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->$r8$lambda$8g7AY2_WxJJpZ52dBVQ23NxI-20(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Landroid/content/Context; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/Long; Landroid/view/View;)V
    return-void 
.end method
