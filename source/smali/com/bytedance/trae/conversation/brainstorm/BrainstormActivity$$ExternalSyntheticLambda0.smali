# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroidx/activity/result/ActivityResultCallback;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.brainstorm.BrainstormActivity)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    return-void 
.end method

.method public final onActivityResult(java.lang.Object)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    check-cast v2, Ljava/util/Map;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->$r8$lambda$JLkdE7-RrGMdseVIcp4h9r7NvN0(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity; Ljava/util/Map;)V
    return-void 
.end method
