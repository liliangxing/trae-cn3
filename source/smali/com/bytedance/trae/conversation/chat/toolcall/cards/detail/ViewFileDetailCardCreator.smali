# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "ViewFileDetailCardCreator.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$Companion;
.field public static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$IhOUVR-N_Lb40flObedGMLax5bE(com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->onCreateDetail$lambda$0(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$L8cfvOn3ckBr2oPM5n-y-AZ7VoE(com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->onCreateDetail$lambda$1(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$c2rPd7XHuCrNVQ-Q_juW43oyThw(com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator  android.content.Context)android.view.View
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->onUpdateCard$lambda$4(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$nwXU7OAn_z3fP0cGb1vUVk1lWDE(com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator  android.content.Context)android.view.View
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->onCreateDetail$lambda$2(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$o2DcjGSte6vA-1204j3fjt_NwN4(com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->onUpdateCard$lambda$3(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final buildFileItemRow(android.content.Context  float  com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator$FileItem)android.view.View
    .registers 11
    # ins_size=4
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v8, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v3, 24
    int-to-float v3, v3
    mul-float/2addr v3, v9
    float-to-int v3, v3
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setMinimumHeight(I)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -1
    const/4 v5, -2
    invoke-direct v3, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    int-to-float v2, v2
    mul-float/2addr v2, v9
    float-to-int v2, v2
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;->isFolder()Z
    move-result v3
    const/4 v4, 1
    if-eqz v3, +00ah
    sget-object v3, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/FileIconHelper;
    const/4 v6, 0
    invoke-static v3, v1, v4, v6, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->getFolderIconRes$default(Lcom/bytedance/trae/conversation/chat/FileIconHelper; Z I Ljava/lang/Object;)I
    move-result v1
    goto +bh
    sget-object v1, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/FileIconHelper;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;->getFilePath()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->getFileIconRes(Ljava/lang/String;)I
    move-result v1
    new-instance v3, Landroid/widget/ImageView;
    invoke-direct v3, v8, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, v1, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v1, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v3, v1, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v3, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v1, v2, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v8, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;->getDisplayName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v8, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v2, 1095761920
    const/4 v3, 2
    invoke-virtual v1, v3, v2, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v1, v4, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v2, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v6, 4
    int-to-float v6, v6
    mul-float/2addr v6, v9
    float-to-int v9, v6
    invoke-virtual v2, v9, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;->getOffset()Ljava/lang/Integer;
    move-result-object v1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;->getLimit()Ljava/lang/Integer;
    move-result-object v10
    invoke-direct v7, v1, v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->formatLineRange(Ljava/lang/Integer; Ljava/lang/Integer;)Ljava/lang/String;
    move-result-object v10
    if-eqz v10, +02fh
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v8, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v10, Ljava/lang/CharSequence;
    invoke-virtual v1, v10, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v10, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v8, v10, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v1, v8, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v8, 1093664768
    invoke-virtual v1, v3, v8, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v1, v4, Landroid/widget/TextView;->setMaxLines(I)V
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v8, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v8, v9, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v8, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
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
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;
    invoke-direct v3, v4, v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->buildFileItemRow(Landroid/content/Context; F Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;)Landroid/view/View;
    move-result-object v2
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -13h
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final buildNoMatchesView(android.content.Context)android.view.View
    .registers 5
    # ins_size=2
    invoke-virtual v4, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v4, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_no_matches I
    invoke-virtual v4, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v4, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-virtual v1, v4, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v4, 2
    const/high16 v2, 1095761920
    invoke-virtual v1, v4, v2, Landroid/widget/TextView;->setTextSize(I F)V
    const/4 v4, 1
    invoke-virtual v1, v4, Landroid/widget/TextView;->setMaxLines(I)V
    const/16 v4, 24
    int-to-float v4, v4
    mul-float/2addr v4, v0
    float-to-int v4, v4
    invoke-virtual v1, v4, Landroid/widget/TextView;->setMinimumHeight(I)V
    const/16 v4, 16
    invoke-virtual v1, v4, Landroid/widget/TextView;->setGravity(I)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final collectFileItems(com.bytedance.trae.im.model.ParsedToolCallInfo  boolean)java.util.List
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    const/16 v1, 47
    const-string v2, "limit"
    const-string v3, "offset"
    const-string v4, "file_path"
    const/4 v5, 2
    const/4 v6, 0
    if-eqz v19, +09ah
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v7
    if-eqz v7, +009h
    const-string v8, "files"
    invoke-virtual v7, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v7
    goto +2h
    move-object v7, v6
    if-eqz v7, +085h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v8
    if-eqz v8, +07fh
    invoke-virtual v7, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v7
    const-string v8, "getAsJsonArray(...)"
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Ljava/lang/Iterable;
    new-instance v8, Ljava/util/ArrayList;
    invoke-direct v8, Ljava/util/ArrayList;-><init>()V
    check-cast v8, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +060h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/google/gson/JsonElement;
    if-eqz v9, +051h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v10
    if-eqz v10, +003h
    goto +2h
    move-object v9, v6
    if-eqz v9, +047h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v9
    if-nez v9, +003h
    goto +3fh
    invoke-virtual v9, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v10
    if-eqz v10, +03ah
    invoke-virtual v10, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v11
    if-eqz v11, +003h
    goto +2h
    move-object v10, v6
    if-eqz v10, +030h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v12
    if-nez v12, +003h
    goto +28h
    invoke-virtual v9, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v10
    if-eqz v10, +008h
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->safeAsInt(Lcom/google/gson/JsonElement;)Ljava/lang/Integer;
    move-result-object v10
    move-object v14, v10
    goto +2h
    move-object v14, v6
    invoke-virtual v9, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, +008h
    invoke-direct v0, v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->safeAsInt(Lcom/google/gson/JsonElement;)Ljava/lang/Integer;
    move-result-object v9
    move-object v15, v9
    goto +2h
    move-object v15, v6
    new-instance v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;
    invoke-static v12, v1, v6, v5, v6, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    const/16 v16, 0
    move-object v11, v9
    invoke-direct/range v11 ... v16, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Z)V
    goto +2h
    move-object v9, v6
    if-eqz v9, -05eh
    invoke-interface v8, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -63h
    check-cast v8, Ljava/util/List;
    return-object v8
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    return-object v1
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v7
    if-eqz v7, +018h
    invoke-virtual v7, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +012h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    move-object v4, v6
    if-eqz v4, +008h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +042h
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-eqz v4, +019h
    const-string v7, "path"
    invoke-virtual v4, v7, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +011h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    move-object v4, v6
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v6
    if-nez v4, +022h
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-eqz v4, +01ah
    const-string/jumbo v7, search_directory
    invoke-virtual v4, v7, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +011h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    move-object v4, v6
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    goto +3h
    move-object v8, v6
    goto +2h
    move-object v8, v4
    if-nez v8, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    return-object v1
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-eqz v4, +00eh
    invoke-virtual v4, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +008h
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->safeAsInt(Lcom/google/gson/JsonElement;)Ljava/lang/Integer;
    move-result-object v3
    move-object v10, v3
    goto +2h
    move-object v10, v6
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v3
    if-eqz v3, +00eh
    invoke-virtual v3, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +008h
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->safeAsInt(Lcom/google/gson/JsonElement;)Ljava/lang/Integer;
    move-result-object v2
    move-object v11, v2
    goto +2h
    move-object v11, v6
    const-string v2, "/"
    const/4 v3, 0
    invoke-static v8, v2, v3, v5, v6, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +011h
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    const-string v4, "LS"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v12, v3
    goto +3h
    const/4 v2, 1
    move v12, v2
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;
    if-eqz v12, +004h
    move-object v9, v8
    goto +6h
    invoke-static v8, v1, v6, v5, v6, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    move-object v9, v1
    move-object v7, v2
    invoke-direct/range v7 ... v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Z)V
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    return-object v1
.end method

.method private final formatLineRange(java.lang.Integer  java.lang.Integer)java.lang.String
    .registers 5
    # ins_size=3
    if-nez v3, +004h
    const/4 v3, 0
    return-object v3
    const/16 v0, 45
    if-eqz v4, +027h
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v1
    if-lez v1, +021h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v3
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v4
    add-int/2addr v3, v4
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    goto +12h
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private static final onCreateDetail$lambda$0(com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->buildFileListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onCreateDetail$lambda$1(com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->buildFileListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onCreateDetail$lambda$2(com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator  android.content.Context)android.view.View
    .registers 3
    # ins_size=2
    const-string v0, "ctx"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->buildNoMatchesView(Landroid/content/Context;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onUpdateCard$lambda$3(com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->buildFileListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onUpdateCard$lambda$4(com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator  android.content.Context)android.view.View
    .registers 3
    # ins_size=2
    const-string v0, "ctx"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->buildNoMatchesView(Landroid/content/Context;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private final safeAsInt(com.google.gson.JsonElement)java.lang.Integer
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    return-object v1
    :try_start_0x8
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
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v7
    const-string/jumbo v9, view_files
    invoke-static v7, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    invoke-direct v0, v2, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->collectFileItems(Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Z)Ljava/util/List;
    move-result-object v7
    const-string v9, "getString(...)"
    if-nez v3, +034h
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v3
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_reading_files I
    new-array v11, v4, [Ljava/lang/Object;
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    aput-object v3, v11, v5
    invoke-virtual v1, v10, v11, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->glasses_read I
    move-object v9, v7
    check-cast v9, Ljava/util/Collection;
    invoke-interface v9, Ljava/util/Collection;->isEmpty()Z
    move-result v9
    xor-int/2addr v9, v4
    if-eqz v9, +008h
    new-instance v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda0;
    invoke-direct v9, v0, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator; Ljava/util/List;)V
    goto +2h
    move-object v9, v8
    move-object v13, v1
    move v11, v3
    move/from16 v18, v4
    move v12, v5
    move-object v14, v8
    move-object/from16 v16, v9
    goto/16 +06ah
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v10
    aget v3, v3, v10
    if-ne v3, v4, +026h
    invoke-static v7, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;->getDisplayName()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v8
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_failed_read I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    move-object v13, v1
    move-object v14, v3
    move v11, v4
    move/from16 v18, v5
    move-object/from16 v16, v8
    move v12, v9
    goto +3bh
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v3
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_read_done I
    invoke-virtual v1, v10, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-lez v3, +015h
    invoke-virtual/range v23, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v9, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_read_file_count I
    new-array v4, v4, [Ljava/lang/Object;
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    aput-object v11, v4, v5
    invoke-virtual v1, v9, v3, v4, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v8
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->glasses_read I
    if-lez v3, +008h
    new-instance v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda1;
    invoke-direct v3, v0, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator; Ljava/util/List;)V
    goto +6h
    new-instance v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda2;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;)V
    move-object v14, v1
    move-object/from16 v16, v3
    move v11, v4
    move v12, v5
    move/from16 v18, v12
    move-object v13, v10
    invoke-static v7, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;->getFilePath()Ljava/lang/String;
    move-result-object v8
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[ViewFileCard] onCreateDetail: name="
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
    const/4 v15, 0
    const/16 v19, 0
    const/16 v20, 544
    const/16 v21, 0
    move-object v9, v1
    move-object/from16 v17, v6
    invoke-direct/range v9 ... v21, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 13
    # ins_size=5
    const-string v12, "context"
    invoke-static v9, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v12, "card"
    invoke-static v10, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v12, toolCallInfo
    invoke-static v11, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v12
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v12, +004h
    move v12, v0
    goto +2h
    move v12, v1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    const/4 v4, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v4
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v2
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v5, view_files
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    invoke-direct v8, v11, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->collectFileItems(Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Z)Ljava/util/List;
    move-result-object v3
    const-string v5, "getString(...)"
    if-nez v12, +02ah
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v12
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_reading_files I
    new-array v7, v0, [Ljava/lang/Object;
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    aput-object v12, v7, v1
    invoke-virtual v9, v6, v7, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v10, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->glasses_read I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto/16 +07bh
    sget-object v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v6
    aget v12, v12, v6
    if-ne v12, v0, +02dh
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_failed_read I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-static v3, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;->getDisplayName()Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v4
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +45h
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v12
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_read_done I
    invoke-virtual v9, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    if-lez v12, +015h
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    sget v5, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_read_file_count I
    new-array v0, v0, [Ljava/lang/Object;
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v0, v1
    invoke-virtual v9, v5, v12, v0, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v4
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->glasses_read I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    if-lez v12, +008h
    new-instance v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda3;
    invoke-direct v9, v8, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator; Ljava/util/List;)V
    goto +6h
    new-instance v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda4;
    invoke-direct v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setContentView(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v12, "[ViewFileCard] onUpdateCard: name="
    invoke-direct v10, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", status="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", filePath="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-static v3, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;
    if-eqz v11, +006h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;->getFilePath()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v10, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    const-string v11, "AgentTool"
    invoke-virtual v9, v11, v10, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
