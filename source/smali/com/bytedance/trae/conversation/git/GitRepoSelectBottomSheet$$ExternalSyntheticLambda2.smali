# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;


.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda2;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda2;->f$0 Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    check-cast v3, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->$r8$lambda$T83PMu2UzArDqaIydrWDwr_kCvI(Ljava/lang/String; Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Lcom/bytedance/trae/conversation/git/GitRepoItem;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
