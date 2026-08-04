# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    check-cast v2, Lcom/bytedance/trae/conversation/network/ProjectItem;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->$r8$lambda$MOa-qsdpS1DMnUo3gTQM6G5NN6I(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet; Lcom/bytedance/trae/conversation/network/ProjectItem;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
