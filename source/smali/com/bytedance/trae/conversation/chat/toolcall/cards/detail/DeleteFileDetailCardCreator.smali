# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "DeleteFileDetailCardCreator.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$Companion;
.field public static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$8LImhU7rddijimq2W0jnbtQuu0k(com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->onCreateDetail$lambda$2(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$LlOkdsiKfYaN4rSdG9fbNzzEKQs(com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->onUpdateCard$lambda$3(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$hKVQ-m2MVjZl1L-ATrnGUHAQvHM(com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->onCreateDetail$lambda$0(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$iUvzb6X7jCzMvq7kYEwvyE_sSEQ(com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->onCreateDetail$lambda$1(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$yBlWlsImvpFDlZWXPEUBuUkUYcQ(com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->onUpdateCard$lambda$4(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final buildFileItemRow(android.content.Context  float  com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator$DeleteFileItem)android.view.View
    .registers 9
    # ins_size=4
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v6, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v1, 16
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v2, 24
    int-to-float v2, v2
    mul-float/2addr v2, v7
    float-to-int v2, v2
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setMinimumHeight(I)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -1
    const/4 v4, -2
    invoke-direct v2, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    int-to-float v1, v1
    mul-float/2addr v1, v7
    float-to-int v1, v1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/FileIconHelper;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;->getFilePath()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->getFileIconRes(Ljava/lang/String;)I
    move-result v2
    new-instance v3, Landroid/widget/ImageView;
    invoke-direct v3, v6, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, v2, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v2, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v3, v2, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v3, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v1, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v6, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;->getDisplayName()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v1, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v6, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v1, v6, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v6, 2
    const/high16 v8, 1095761920
    invoke-virtual v1, v6, v8, Landroid/widget/TextView;->setTextSize(I F)V
    const/4 v6, 1
    invoke-virtual v1, v6, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v6, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v1, v6, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v8, 4
    int-to-float v8, v8
    mul-float/2addr v8, v7
    float-to-int v7, v8
    invoke-virtual v6, v7, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v6, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private final buildFileListView(android.content.Context  java.util.List)android.view.View
    .registers 6
    # ins_size=3
    invoke-virtual v4, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v4, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 1
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-interface v5, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;
    invoke-direct v3, v4, v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->buildFileItemRow(Landroid/content/Context; F Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;)Landroid/view/View;
    move-result-object v2
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -13h
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final collectFileItems(com.bytedance.trae.im.model.ParsedToolCallInfo)java.util.List
    .registers 11
    # ins_size=2
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v10
    if-nez v10, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v10
    return-object v10
    const-string v0, "file_paths"
    invoke-virtual v10, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v0
    goto +2h
    move-object v0, v1
    const/4 v2, 2
    const/16 v3, 47
    if-eqz v0, +03eh
    invoke-virtual v0, Lcom/google/gson/JsonArray;->size()I
    move-result v4
    if-lez v4, +038h
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v10
    invoke-virtual v0, Lcom/google/gson/JsonArray;->size()I
    move-result v4
    const/4 v5, 0
    if-ge v5, v4, +028h
    invoke-virtual v0, v5, Lcom/google/gson/JsonArray;->get(I)Lcom/google/gson/JsonElement;
    move-result-object v6
    if-eqz v6, +01fh
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    move-object v6, v1
    if-eqz v6, +015h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    goto +dh
    new-instance v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;
    invoke-static v6, v3, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v8
    invoke-direct v7, v6, v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v10, v7, Ljava/util/List;->add(Ljava/lang/Object;)Z
    add-int/lit8 v5, v5, 1
    goto -27h
    invoke-static v10, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v10
    return-object v10
    const-string v0, "file_path"
    invoke-virtual v10, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +012h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +022h
    const-string v0, "path"
    invoke-virtual v10, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v10
    if-eqz v10, +012h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v10, v1
    if-eqz v10, +008h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v10
    move-object v0, v10
    goto +2h
    move-object v0, v1
    if-nez v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v10
    return-object v10
    new-instance v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;
    invoke-static v0, v3, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    invoke-direct v10, v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v10, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    return-object v10
.end method

.method private static final onCreateDetail$lambda$0(com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->buildFileListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onCreateDetail$lambda$1(com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->buildFileListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onCreateDetail$lambda$2(com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->buildFileListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onUpdateCard$lambda$3(com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->buildFileListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onUpdateCard$lambda$4(com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->buildFileListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 26
    # ins_size=4
    move-object/from16 v0, v22
    move-object/from16 v1, v23
    move-object/from16 v2, v24
    const-string v3, "context"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, toolCallInfo
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v3, +004h
    move v3, v4
    goto +2h
    move v3, v5
    sget-object v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v7
    const/4 v8, 0
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v8
    invoke-virtual v6, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v6
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->collectFileItems(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/util/List;
    move-result-object v7
    sget-object v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v6, v9, +017h
    if-eqz v25, +010h
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v9
    if-eqz v9, +00ah
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v9
    if-ne v9, v4, +004h
    move v9, v4
    goto +2h
    move v9, v5
    if-eqz v9, +004h
    move v9, v4
    goto +2h
    move v9, v5
    const-string v10, ""
    const-string v11, "getString(...)"
    if-eqz v3, +0a4h
    if-eqz v9, +004h
    goto/16 +0a0h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v9
    aget v3, v3, v9
    if-eq v3, v4, +071h
    const/4 v9, 2
    if-eq v3, v9, +02fh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_delete I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->trash I
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_canceled I
    invoke-virtual v1, v10, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    move-object v10, v7
    check-cast v10, Ljava/util/Collection;
    invoke-interface v10, Ljava/util/Collection;->isEmpty()Z
    move-result v10
    xor-int/2addr v4, v10
    if-eqz v4, +008h
    new-instance v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$$ExternalSyntheticLambda2;
    invoke-direct v4, v0, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator; Ljava/util/List;)V
    goto +2h
    move-object v4, v8
    move-object v15, v1
    move-object v13, v3
    move-object/from16 v16, v4
    move v12, v5
    move/from16 v18, v12
    move-object v14, v8
    move v11, v9
    goto/16 +0adh
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v3
    sget v9, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_deleted I
    invoke-virtual v1, v9, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-lez v3, +015h
    invoke-virtual/range v23, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v11, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_delete_file_count I
    new-array v12, v4, [Ljava/lang/Object;
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    aput-object v13, v12, v5
    invoke-virtual v1, v11, v3, v12, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v8
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->trash I
    move-object v11, v7
    check-cast v11, Ljava/util/Collection;
    invoke-interface v11, Ljava/util/Collection;->isEmpty()Z
    move-result v11
    xor-int/2addr v4, v11
    if-eqz v4, +008h
    new-instance v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$$ExternalSyntheticLambda1;
    invoke-direct v4, v0, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator; Ljava/util/List;)V
    goto +2h
    move-object v4, v8
    move-object v14, v1
    move v11, v3
    move-object/from16 v16, v4
    move v12, v5
    move/from16 v18, v12
    move-object v13, v9
    goto +24h
    invoke-static v7, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;->getDisplayName()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v8
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_failed_delete I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    move-object v13, v1
    move-object v14, v3
    move v11, v4
    move/from16 v18, v5
    move-object/from16 v16, v8
    move v12, v9
    move-object v15, v10
    goto +48h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_deleting I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v11
    if-lez v11, +015h
    invoke-virtual/range v23, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v12
    sget v13, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_delete_file_count I
    new-array v14, v4, [Ljava/lang/Object;
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v15
    aput-object v15, v14, v5
    invoke-virtual v12, v13, v11, v14, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v8
    if-eqz v9, +008h
    sget v9, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v1, v9, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v10
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trash I
    move-object v9, v7
    check-cast v9, Ljava/util/Collection;
    invoke-interface v9, Ljava/util/Collection;->isEmpty()Z
    move-result v9
    xor-int/2addr v9, v4
    if-eqz v9, +008h
    new-instance v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$$ExternalSyntheticLambda0;
    invoke-direct v9, v0, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator; Ljava/util/List;)V
    goto +2h
    move-object v9, v8
    move-object v13, v3
    move/from16 v18, v4
    move v12, v5
    move-object/from16 v16, v9
    move-object v15, v10
    move-object v14, v11
    move v11, v1
    invoke-static v7, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;->getFilePath()Ljava/lang/String;
    move-result-object v8
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[DeleteFileCard] onCreateDetail: name="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", status="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", filePath="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "AgentTool"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v10, ""
    const/16 v19, 0
    const/16 v20, 512
    const/16 v21, 0
    move-object v9, v1
    move-object/from16 v17, v6
    invoke-direct/range v9 ... v21, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 15
    # ins_size=5
    const-string v0, "context"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "card"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v4
    const/4 v5, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v3
    invoke-direct v10, v13, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;->collectFileItems(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/util/List;
    move-result-object v4
    sget-object v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v3, v6, +017h
    if-eqz v14, +010h
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v14
    if-eqz v14, +00ah
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v14
    if-ne v14, v1, +004h
    move v14, v1
    goto +2h
    move v14, v2
    if-eqz v14, +004h
    move v14, v1
    goto +2h
    move v14, v2
    const-string v6, "getString(...)"
    if-eqz v0, +0cch
    if-eqz v14, +004h
    goto/16 +0c8h
    sget-object v14, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v0
    aget v14, v14, v0
    if-eq v14, v1, +090h
    const/4 v0, 2
    if-eq v14, v0, +040h
    sget-object v14, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    invoke-virtual v12, v14, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    sget v14, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_delete I
    invoke-virtual v11, v14, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v14
    invoke-static v14, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v12, v14, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v12, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v14, Lcom/bytedance/trae/conversation/R$drawable;->trash I
    invoke-virtual v12, v14, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v12, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v12, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    sget v14, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_canceled I
    invoke-virtual v11, v14, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v11
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    move-object v11, v4
    check-cast v11, Ljava/util/Collection;
    invoke-interface v11, Ljava/util/Collection;->isEmpty()Z
    move-result v11
    xor-int/2addr v11, v1
    if-eqz v11, +008h
    new-instance v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$$ExternalSyntheticLambda4;
    invoke-direct v11, v10, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator; Ljava/util/List;)V
    goto +2h
    move-object v11, v5
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setContentView(Lkotlin/jvm/functions/Function1;)V
    goto/16 +0beh
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v14
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_deleted I
    invoke-virtual v11, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v12, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    if-lez v14, +015h
    invoke-virtual v11, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v11
    sget v0, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_delete_file_count I
    new-array v6, v1, [Ljava/lang/Object;
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    aput-object v7, v6, v2
    invoke-virtual v11, v0, v14, v6, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v5
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v11, Lcom/bytedance/trae/conversation/R$drawable;->trash I
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v12, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v12, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v12, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    move-object v11, v4
    check-cast v11, Ljava/util/Collection;
    invoke-interface v11, Ljava/util/Collection;->isEmpty()Z
    move-result v11
    xor-int/2addr v11, v1
    if-eqz v11, +008h
    new-instance v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$$ExternalSyntheticLambda3;
    invoke-direct v11, v10, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator; Ljava/util/List;)V
    goto +2h
    move-object v11, v5
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setContentView(Lkotlin/jvm/functions/Function1;)V
    goto/16 +071h
    sget v14, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_failed_delete I
    invoke-virtual v11, v14, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-static v4, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;->getDisplayName()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v5
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v11, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    sget v11, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v12, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v12, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    goto +42h
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v0
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_deleting I
    invoke-virtual v11, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v12, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    if-lez v0, +015h
    invoke-virtual v11, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_delete_file_count I
    new-array v8, v1, [Ljava/lang/Object;
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    aput-object v9, v8, v2
    invoke-virtual v6, v7, v0, v8, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v5
    invoke-virtual v12, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    if-eqz v14, +009h
    sget v14, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v11, v14, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v5
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    sget v11, Lcom/bytedance/trae/conversation/R$drawable;->trash I
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v12, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v12, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v12, Ljava/lang/StringBuilder;
    const-string v14, "[DeleteFileCard] onUpdateCard: name="
    invoke-direct v12, v14, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v13, ", status="
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v13, ", filePath="
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-static v4, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;
    if-eqz v13, +006h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;->getFilePath()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v12, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    const-string v13, "AgentTool"
    invoke-virtual v11, v13, v12, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
