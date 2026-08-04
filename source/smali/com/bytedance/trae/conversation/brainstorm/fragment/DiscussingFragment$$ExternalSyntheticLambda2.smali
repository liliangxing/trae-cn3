# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
.field public final synthetic f$1:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda2;->f$1 Ljava/lang/String;
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda2;->f$1 Ljava/lang/String;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->$r8$lambda$5Y4o41RwF6H3n6u9O1MgE9clFas(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Ljava/lang/String;)V
    return-void 
.end method
