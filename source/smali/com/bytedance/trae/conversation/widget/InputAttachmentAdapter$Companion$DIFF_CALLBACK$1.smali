# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$Companion$DIFF_CALLBACK$1;
.super Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
.source "InputAttachmentAdapter.kt"


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;-><init>()V
    return-void 
.end method

.method public areContentsTheSame(com.bytedance.trae.conversation.widget.AttachmentItem  com.bytedance.trae.conversation.widget.AttachmentItem)boolean
    .registers 5
    # ins_size=3
    const-string v0, "oldItem"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newItem"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v1
    if-ne v0, v1, +020h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getFileName()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getFileName()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +012h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadError()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadError()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    return v3
.end method

.method public bridge synthetic areContentsTheSame(java.lang.Object  java.lang.Object)boolean
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    check-cast v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$Companion$DIFF_CALLBACK$1;->areContentsTheSame(Lcom/bytedance/trae/conversation/widget/AttachmentItem; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Z
    move-result v1
    return v1
.end method

.method public areItemsTheSame(com.bytedance.trae.conversation.widget.AttachmentItem  com.bytedance.trae.conversation.widget.AttachmentItem)boolean
    .registers 4
    # ins_size=3
    const-string v0, "oldItem"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newItem"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method public bridge synthetic areItemsTheSame(java.lang.Object  java.lang.Object)boolean
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    check-cast v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$Companion$DIFF_CALLBACK$1;->areItemsTheSame(Lcom/bytedance/trae/conversation/widget/AttachmentItem; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Z
    move-result v1
    return v1
.end method

.method public getChangePayload(com.bytedance.trae.conversation.widget.AttachmentItem  com.bytedance.trae.conversation.widget.AttachmentItem)java.lang.Object
    .registers 4
    # ins_size=3
    const-string v0, "oldItem"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newItem"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v3
    if-eq v2, v3, +008h
    const/4 v2, 1
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    return-object v2
    const/4 v2, 0
    return-object v2
.end method

.method public bridge synthetic getChangePayload(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    check-cast v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$Companion$DIFF_CALLBACK$1;->getChangePayload(Lcom/bytedance/trae/conversation/widget/AttachmentItem; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
