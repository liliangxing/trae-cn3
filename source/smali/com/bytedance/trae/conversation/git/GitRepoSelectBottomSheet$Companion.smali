# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$Companion;
.super Ljava/lang/Object;
.source "GitRepoSelectBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic newInstance$default(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet$Companion  com.bytedance.trae.conversation.git.GitRepoItem  int  java.lang.Object)com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$Companion;->newInstance(Lcom/bytedance/trae/conversation/git/GitRepoItem;)Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    move-result-object v0
    return-object v0
.end method

.method public final newInstance(com.bytedance.trae.conversation.git.GitRepoItem)com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;-><init>()V
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->setSelectedRepo(Lcom/bytedance/trae/conversation/git/GitRepoItem;)V
    return-object v0
.end method
