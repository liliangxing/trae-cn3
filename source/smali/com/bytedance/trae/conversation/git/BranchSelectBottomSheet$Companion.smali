# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$Companion;
.super Ljava/lang/Object;
.source "BranchSelectBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic newInstance$default(com.bytedance.trae.conversation.git.BranchSelectBottomSheet$Companion  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.git.BranchSelectBottomSheet
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$Companion;->newInstance(Ljava/lang/String;)Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    move-result-object v0
    return-object v0
.end method

.method public final newInstance(java.lang.String)com.bytedance.trae.conversation.git.BranchSelectBottomSheet
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;-><init>()V
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$setSelectedBranchId$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Ljava/lang/String;)V
    return-object v0
.end method
