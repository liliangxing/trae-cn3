# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lkotlin/jvm/internal/Ref$ObjectRef;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;


.method public synthetic constructor <init>(kotlin.jvm.internal.Ref$ObjectRef  com.bytedance.trae.conversation.git.BranchSelectBottomSheet)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    check-cast v3, Lcom/bytedance/trae/conversation/git/BranchItem;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->$r8$lambda$KNLSLGQZue8SIlMEwAlY_tj4Xbo(Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Lcom/bytedance/trae/conversation/git/BranchItem;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
