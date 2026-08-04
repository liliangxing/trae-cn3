# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/widget/InputFragment;
.field public final synthetic f$1:Z
.field public final synthetic f$2:J
.field public final synthetic f$3:J


.method public synthetic constructor <init>(com.bytedance.trae.conversation.widget.InputFragment  boolean  long  long)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda4;->f$1 Z
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda4;->f$2 J
    iput-wide v5, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda4;->f$3 J
    return-void 
.end method

.method public final run()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    iget-boolean v1, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda4;->f$1 Z
    iget-wide v2, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda4;->f$2 J
    iget-wide v4, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda4;->f$3 J
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->$r8$lambda$-SYfsRWa_F9sXLiSnAhZhOsbE1w(Lcom/bytedance/trae/conversation/widget/InputFragment; Z J J)V
    return-void 
.end method
