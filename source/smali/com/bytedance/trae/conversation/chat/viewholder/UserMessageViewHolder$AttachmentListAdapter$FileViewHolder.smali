# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "UserMessageViewHolder.kt"

.field private final ivFileIcon:Landroid/widget/ImageView;
.field private final tvFileExt:Landroid/widget/TextView;
.field private final tvFilename:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$2deJcyUnro3C_GFUvKA57axgBc8(com.bytedance.trae.im.model.MessagePart  com.bytedance.trae.conversation.chat.IMessageListener  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$AttachmentListAdapter$FileViewHolder  java.lang.String  java.lang.String  android.view.View)void
    .registers 10
    # ins_size=10
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;->bind$lambda$2(Lcom/bytedance/trae/im/model/MessagePart; Lcom/bytedance/trae/conversation/chat/IMessageListener; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder; Ljava/lang/String; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.view.View)void
    .registers 4
    # ins_size=2
    const-string v0, "itemView"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_filename I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;->tvFilename Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_file_ext I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;->tvFileExt Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_file_icon I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/ImageView;
    iput-object v3, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;->ivFileIcon Landroid/widget/ImageView;
    return-void 
.end method

.method private static final bind$lambda$2(com.bytedance.trae.im.model.MessagePart  com.bytedance.trae.conversation.chat.IMessageListener  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$AttachmentListAdapter$FileViewHolder  java.lang.String  java.lang.String  android.view.View)void
    .registers 20
    # ins_size=10
    invoke-static v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->previewChatSessionIdFromData(Lcom/bytedance/trae/im/model/MessagePart;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +014h
    if-eqz v11, +00dh
    invoke-interface v11, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    move-object v6, v0
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +03bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "open attachment without chatSessionId: uri="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v3, v12
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", fileName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    move-object v4, v13
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", conversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    move-object v5, v14
    invoke-virtual v1, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    move-object v9, v15
    invoke-virtual v1, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "UserMessageAttachment"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +5h
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v9, v15
    sget-object v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/InputPreviewActivity$Companion;
    move-object/from16 v0, v16
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    const-string v0, "getContext(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object/from16 v7, v17
    move-object/from16 v8, v18
    move-object v9, v15
    invoke-virtual/range v1 ... v9, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final bind(com.bytedance.trae.im.model.MessagePart  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.IMessageListener)void
    .registers 20
    # ins_size=7
    move-object v10, v13
    const-string v0, "part"
    move-object v1, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    move-object v5, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    move-object/from16 v8, v16
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    move-object/from16 v9, v17
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    move-object/from16 v6, v18
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-eqz v0, +01ah
    const-string v2, "filename"
    invoke-virtual v0, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +012h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, "File"
    move-object v4, v0
    invoke-static v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->previewOidIdFromData(Lcom/bytedance/trae/im/model/MessagePart;)Ljava/lang/String;
    move-result-object v3
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;->tvFilename Landroid/widget/TextView;
    move-object v2, v4
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/16 v0, 46
    const-string v2, ""
    invoke-static v4, v0, v2, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    sget-object v2, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v2, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v2, toUpperCase(...)
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;->tvFileExt Landroid/widget/TextView;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +004h
    const/4 v7, 1
    goto +2h
    const/4 v7, 0
    if-eqz v7, +004h
    const-string v0, "FILE"
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v2, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;->ivFileIcon Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_conversation_pdf I
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;->itemView Landroid/view/View;
    new-instance v12, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;
    move-object v0, v12
    move-object v1, v14
    move-object/from16 v2, v19
    move-object v5, v15
    move-object/from16 v6, v18
    move-object v7, v13
    move-object/from16 v8, v16
    move-object/from16 v9, v17
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/im/model/MessagePart; Lcom/bytedance/trae/conversation/chat/IMessageListener; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v11, v12, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
