# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/devices/DirectoryNode;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    check-cast v3, Ljava/lang/Boolean;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->$r8$lambda$W8RzMKdvNiSLHeFVQVgq_vAomQA(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lcom/bytedance/trae/conversation/devices/DirectoryNode; Z)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
