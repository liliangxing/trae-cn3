# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$Companion;
.super Ljava/lang/Object;
.source "FileTreeBottomSheetFragment.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic newInstance$default(com.bytedance.trae.conversation.chat.block.renderer.FileTreeBottomSheetFragment$Companion  java.util.List  kotlin.jvm.functions.Function1  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.renderer.FileTreeBottomSheetFragment
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$Companion;->newInstance(Ljava/util/List; Lkotlin/jvm/functions/Function1;)Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;
    move-result-object v0
    return-object v0
.end method

.method public final newInstance(java.util.List  kotlin.jvm.functions.Function1)com.bytedance.trae.conversation.chat.block.renderer.FileTreeBottomSheetFragment
    .registers 4
    # ins_size=3
    const-string v0, "diffFiles"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->access$setPendingDiffFiles$cp(Ljava/util/List;)V
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;-><init>()V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->setOnFileClick(Lkotlin/jvm/functions/Function1;)V
    return-object v2
.end method
