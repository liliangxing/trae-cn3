# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputAttachmentListModelKt;
.super Ljava/lang/Object;
.source "InputAttachmentListModel.kt"


.method public static final synthetic access$toAttachmentItem(com.bytedance.trae.conversation.mediachoose.model.MediaItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModelKt;->toAttachmentItem(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$toMediaItem(com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.mediachoose.model.MediaItem
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModelKt;->toMediaItem(Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-result-object v0
    return-object v0
.end method

.method private static final toAttachmentItem(com.bytedance.trae.conversation.mediachoose.model.MediaItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 19
    # ins_size=1
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v3
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getUri()Landroid/net/Uri;
    move-result-object v6
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getMimeType()Ljava/lang/String;
    move-result-object v7
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getSizeBytes()J
    move-result-wide v8
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v1
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getFileName()Ljava/lang/String;
    move-result-object v5
    new-instance v17, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-object/from16 v0, v17
    const/4 v10, 1
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 1920
    const/16 v16, 0
    invoke-direct/range v0 ... v16, Lcom/bytedance/trae/conversation/widget/AttachmentItem;-><init>(J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v17
.end method

.method private static final toMediaItem(com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.mediachoose.model.MediaItem
    .registers 18
    # ins_size=1
    new-instance v16, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getBucketId()J
    move-result-wide v1
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v3
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getMimeType()Ljava/lang/String;
    move-result-object v4
    const-wide/16 v5, 0
    const-wide/16 v7, 0
    const-string v9, ""
    const/4 v10, 0
    const/4 v11, 0
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getSizeBytes()J
    move-result-wide v12
    const/4 v14, 0
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getFileName()Ljava/lang/String;
    move-result-object v15
    move-object/from16 v0, v16
    invoke-direct/range v0 ... v15, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;-><init>(J Landroid/net/Uri; Ljava/lang/String; J J Ljava/lang/String; I I J Z Ljava/lang/String;)V
    return-object v16
.end method
