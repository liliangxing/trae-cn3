# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroidx/core/widget/NestedScrollView;
.field public final synthetic f$1:I


.method public synthetic constructor <init>(androidx.core.widget.NestedScrollView  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$$ExternalSyntheticLambda1;->f$0 Landroidx/core/widget/NestedScrollView;
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$$ExternalSyntheticLambda1;->f$1 I
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$$ExternalSyntheticLambda1;->f$0 Landroidx/core/widget/NestedScrollView;
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$$ExternalSyntheticLambda1;->f$1 I
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;->$r8$lambda$F6zI-aRegRK7buzNL2sJgc46jBc(Landroidx/core/widget/NestedScrollView; I)V
    return-void 
.end method
