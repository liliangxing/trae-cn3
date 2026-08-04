# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/devices/DirectoryEvent;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryEvent)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/devices/DirectoryEvent;
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/devices/DirectoryEvent;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1;->$r8$lambda$y7MABKKgxtZCXM_O25ryIjr6vLc(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lcom/bytedance/trae/conversation/devices/DirectoryEvent;)V
    return-void 
.end method
