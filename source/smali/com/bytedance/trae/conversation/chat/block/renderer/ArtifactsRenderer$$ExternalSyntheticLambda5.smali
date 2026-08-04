# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
.field public final synthetic f$1:Landroid/content/Context;
.field public final synthetic f$2:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  android.content.Context  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda5;->f$1 Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda5;->f$2 Ljava/lang/String;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda5;->f$1 Landroid/content/Context;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda5;->f$2 Ljava/lang/String;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->$r8$lambda$eyGGVi_441i4CVtUg-uhKKTqKuU(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Landroid/content/Context; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method
