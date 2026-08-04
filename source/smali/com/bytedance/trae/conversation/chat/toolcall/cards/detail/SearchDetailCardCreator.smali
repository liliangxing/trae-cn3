# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "SearchDetailCardCreator.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$Companion;
.field private static final MAX_FILE_ITEMS:I
.field public static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$6ZJWIq8xEH3PNlsjBBPCm2qY3B8(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->onCreateDetail$lambda$1(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$L8uoS65mmPft_DAhRg9ez_ogct8(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator  android.content.Context)android.view.View
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->onUpdateCard$lambda$2(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$M2nWaDD0VNCxSXXIrZsKmoWZvas(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->onUpdateCard$lambda$3(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$hmtPxND1KO0UXQbmw-fftekWCyk(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator  android.content.Context)android.view.View
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->onCreateDetail$lambda$0(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final buildFileItemRow(android.content.Context  float  com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator$SearchFileItem)android.view.View
    .registers 12
    # ins_size=4
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v1, 16
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v2, 24
    int-to-float v2, v2
    mul-float/2addr v2, v10
    float-to-int v2, v2
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setMinimumHeight(I)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -1
    const/4 v4, -2
    invoke-direct v2, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    int-to-float v1, v1
    mul-float/2addr v1, v10
    float-to-int v1, v1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/FileIconHelper;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;->getFilePath()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->getFileIconRes(Ljava/lang/String;)I
    move-result v2
    new-instance v3, Landroid/widget/ImageView;
    invoke-direct v3, v9, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, v2, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v2, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v3, v2, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v3, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v1, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;->getDisplayName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v9, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v2, 2
    const/high16 v3, 1095761920
    invoke-virtual v1, v2, v3, Landroid/widget/TextView;->setTextSize(I F)V
    const/4 v5, 1
    invoke-virtual v1, v5, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v6, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v1, v6, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v7, 8
    int-to-float v7, v7
    mul-float/2addr v7, v10
    float-to-int v7, v7
    invoke-virtual v6, v7, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v6, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;->getStartLine()Ljava/lang/Integer;
    move-result-object v1
    if-eqz v1, +06dh
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;->getEndLine()Ljava/lang/Integer;
    move-result-object v1
    if-eqz v1, +067h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;->getStartLine()Ljava/lang/Integer;
    move-result-object v1
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;->getEndLine()Ljava/lang/Integer;
    move-result-object v6
    invoke-static v1, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00bh
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;->getStartLine()Ljava/lang/Integer;
    move-result-object v11
    invoke-static v11, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    goto +20h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;->getStartLine()Ljava/lang/Integer;
    move-result-object v6
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v6, 45
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;->getEndLine()Ljava/lang/Integer;
    move-result-object v11
    invoke-virtual v1, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v11, Ljava/lang/CharSequence;
    invoke-virtual v1, v11, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v11, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v9, v11, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    invoke-virtual v1, v9, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v1, v2, v3, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v1, v5, Landroid/widget/TextView;->setMaxLines(I)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v11, 4
    int-to-float v11, v11
    mul-float/2addr v11, v10
    float-to-int v10, v11
    invoke-virtual v9, v10, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v9, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private final buildFileListView(android.content.Context  java.util.List)android.view.View
    .registers 8
    # ins_size=3
    invoke-virtual v6, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v6, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 1
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/4 v2, 4
    int-to-float v2, v2
    mul-float/2addr v2, v0
    float-to-int v2, v2
    const/16 v3, 16
    int-to-float v3, v3
    mul-float/2addr v3, v0
    float-to-int v3, v3
    const/4 v4, 0
    invoke-virtual v1, v4, v2, v4, v3, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    invoke-interface v7, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;
    invoke-direct v5, v6, v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->buildFileItemRow(Landroid/content/Context; F Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;)Landroid/view/View;
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
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_search_no_matches I
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
    const/4 v4, 4
    int-to-float v4, v4
    mul-float/2addr v4, v0
    float-to-int v4, v4
    const/16 v2, 16
    int-to-float v2, v2
    mul-float/2addr v2, v0
    float-to-int v0, v2
    const/4 v2, 0
    invoke-virtual v1, v2, v4, v2, v0, Landroid/widget/TextView;->setPadding(I I I I)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final collectFileItems(com.google.gson.JsonObject)java.util.List
    .registers 20
    # ins_size=2
    move-object/from16 v0, v19
    if-nez v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    const-string v2, "files"
    invoke-virtual v0, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v2, v3
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v2
    goto +2h
    move-object v2, v3
    const-string v4, "file_path"
    const/4 v5, 2
    const/16 v6, 47
    const/16 v7, 10
    const-string v8, "iterator(...)"
    if-eqz v2, +10dh
    invoke-virtual v2, Lcom/google/gson/JsonArray;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-static v2, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +100h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/google/gson/JsonElement;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v10
    if-ge v10, v7, +0f4h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v10
    if-eqz v10, +01dh
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v12
    new-instance v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v12, v6, v3, v5, v3, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 12
    const/16 v17, 0
    move-object v11, v9
    invoke-direct/range v11 ... v17, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v9, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -32h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v10
    if-eqz v10, -037h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v9
    const-string v10, "filePath"
    invoke-virtual v9, v10, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v10
    if-eqz v10, +012h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v11
    if-eqz v11, +003h
    goto +2h
    move-object v10, v3
    if-eqz v10, +008h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v10
    if-nez v10, +036h
    invoke-virtual v9, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v10
    if-eqz v10, +011h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v11
    if-eqz v11, +003h
    goto +2h
    move-object v10, v3
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v10
    goto +2h
    move-object v10, v3
    if-nez v10, +01eh
    const-string v10, "absPath"
    invoke-virtual v9, v10, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v10
    if-eqz v10, +011h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v11
    if-eqz v11, +003h
    goto +2h
    move-object v10, v3
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v10
    goto +2h
    move-object v10, v3
    if-nez v10, +004h
    goto/16 -087h
    const-string v11, "name"
    invoke-virtual v9, v11, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v11
    if-eqz v11, +012h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v12
    if-eqz v12, +003h
    goto +2h
    move-object v11, v3
    if-eqz v11, +008h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +006h
    invoke-static v10, v6, v3, v5, v3, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    const-string v12, "range"
    invoke-virtual v9, v12, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, +011h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v12
    if-eqz v12, +003h
    goto +2h
    move-object v9, v3
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v9
    goto +2h
    move-object v9, v3
    if-eqz v9, +01eh
    const-string/jumbo v12, startLineNumber
    invoke-virtual v9, v12, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v12
    if-eqz v12, +015h
    invoke-virtual v12, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v13
    if-eqz v13, +003h
    goto +2h
    move-object v12, v3
    if-eqz v12, +00bh
    invoke-virtual v12, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v12
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    goto +2h
    move-object v12, v3
    if-eqz v9, +01dh
    const-string v13, "endLineNumber"
    invoke-virtual v9, v13, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, +015h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v13
    if-eqz v13, +003h
    goto +2h
    move-object v9, v3
    if-eqz v9, +00bh
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v9
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    goto +2h
    move-object v9, v3
    new-instance v13, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;
    invoke-direct v13, v10, v11, v12, v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer;)V
    invoke-interface v1, v13, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto/16 -102h
    const-string/jumbo v2, results
    invoke-virtual v0, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v3
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v0
    goto +2h
    move-object v0, v3
    if-eqz v0, +0cdh
    invoke-virtual v0, Lcom/google/gson/JsonArray;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-static v0, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +0c0h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/google/gson/JsonElement;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v9
    if-ge v9, v7, +0b4h
    if-eqz v2, -012h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v9
    if-eqz v9, +003h
    goto +2h
    move-object v2, v3
    if-eqz v2, -01ch
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-nez v2, +003h
    goto -24h
    invoke-virtual v2, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, -029h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v10
    if-eqz v10, +003h
    goto +2h
    move-object v9, v3
    if-eqz v9, -033h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +003h
    goto -3bh
    invoke-static v11, v6, v3, v5, v3, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v12
    const-string v9, "lines"
    invoke-virtual v2, v9, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v9
    if-eqz v9, +003h
    goto +2h
    move-object v2, v3
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v2
    goto +2h
    move-object v2, v3
    if-eqz v2, +05bh
    invoke-virtual v2, Lcom/google/gson/JsonArray;->size()I
    move-result v9
    if-lez v9, +055h
    invoke-virtual v2, Lcom/google/gson/JsonArray;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-static v2, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, -06bh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/google/gson/JsonElement;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v10
    if-ge v10, v7, -077h
    if-eqz v9, -012h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v10
    if-eqz v10, +003h
    goto +2h
    move-object v9, v3
    if-eqz v9, -01ch
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v9
    if-nez v9, +003h
    goto -24h
    const-string v10, "line_number"
    invoke-virtual v9, v10, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, -02bh
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v10
    if-eqz v10, +003h
    goto +2h
    move-object v9, v3
    if-eqz v9, -035h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v9
    new-instance v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-direct v10, v11, v12, v13, v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer;)V
    invoke-interface v1, v10, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -4bh
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 12
    const/16 v16, 0
    move-object v10, v2
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto/16 -0c2h
    return-object v1
.end method

.method private final extractKeywords(com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +01ah
    const-string v2, "pattern"
    invoke-virtual v0, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +012h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +044h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-eqz v0, +019h
    const-string v2, "query"
    invoke-virtual v0, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-nez v0, +024h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-eqz v4, +018h
    const-string v0, "information_request"
    invoke-virtual v4, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +010h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v4, v1
    if-eqz v4, +006h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +005h
    const-string v0, ""
    goto +2h
    move-object v0, v1
    return-object v0
.end method

.method private static final onCreateDetail$lambda$0(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator  android.content.Context)android.view.View
    .registers 3
    # ins_size=2
    const-string v0, "ctx"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->buildNoMatchesView(Landroid/content/Context;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onCreateDetail$lambda$1(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->buildFileListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onUpdateCard$lambda$2(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator  android.content.Context)android.view.View
    .registers 3
    # ins_size=2
    const-string v0, "ctx"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->buildNoMatchesView(Landroid/content/Context;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onUpdateCard$lambda$3(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->buildFileListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 27
    # ins_size=4
    move-object/from16 v0, v23
    move-object/from16 v1, v24
    move-object/from16 v2, v25
    const-string v3, "context"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, toolCallInfo
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->extractKeywords(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v4
    const/16 v5, 40
    if-le v4, v5, +019h
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v3, v5, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v4, 8230
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v25, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v4
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v4, +004h
    move v4, v5
    goto +2h
    move v4, v6
    sget-object v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v25, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v8
    const/4 v9, 0
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v9
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v7
    invoke-virtual/range v25, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v8
    goto +2h
    move-object v8, v9
    move-object v10, v3
    check-cast v10, Ljava/lang/CharSequence;
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-lez v10, +004h
    move v10, v5
    goto +2h
    move v10, v6
    if-eqz v10, +019h
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v11, "'"
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const/16 v11, 39
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    move-object v15, v10
    goto +2h
    move-object v15, v9
    const-string v10, "getString(...)"
    if-nez v4, +016h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_searching_codebase I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_search I
    move-object v14, v1
    move v12, v4
    move/from16 v19, v5
    move v13, v6
    move-object/from16 v17, v9
    goto/16 +078h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v11
    aget v4, v4, v11
    if-ne v4, v5, +015h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_search_failed_codebase I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    move-object v14, v1
    move v12, v4
    move v13, v5
    move/from16 v19, v6
    goto -20h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_search I
    invoke-direct v0, v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->collectFileItems(Lcom/google/gson/JsonObject;)Ljava/util/List;
    move-result-object v11
    invoke-interface v11, Ljava/util/List;->isEmpty()Z
    move-result v12
    if-eqz v12, +026h
    const-string v12, "match_occurrences"
    if-eqz v8, +00ah
    invoke-virtual v8, v12, Lcom/google/gson/JsonObject;->has(Ljava/lang/String;)Z
    move-result v13
    if-nez v13, +004h
    move v13, v5
    goto +2h
    move v13, v6
    if-nez v13, +015h
    if-eqz v8, +010h
    invoke-virtual v8, v12, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    if-eqz v8, +00ah
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v8
    if-nez v8, +004h
    move v8, v5
    goto +2h
    move v8, v6
    if-eqz v8, +004h
    move v8, v5
    goto +2h
    move v8, v6
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_searched_codebase I
    invoke-virtual v1, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v8, +009h
    new-instance v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$$ExternalSyntheticLambda0;
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;)V
    move-object v9, v5
    goto +11h
    move-object v8, v11
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v8
    xor-int/2addr v5, v8
    if-eqz v5, +008h
    new-instance v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$$ExternalSyntheticLambda1;
    invoke-direct v5, v0, v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator; Ljava/util/List;)V
    goto -11h
    move-object v14, v1
    move v12, v4
    move v13, v6
    move/from16 v19, v13
    goto -79h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "[SearchCard] onCreateDetail: name="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v25, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", status="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", keywords="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "AgentTool"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v11, ""
    const/16 v16, 0
    const/16 v20, 0
    const/16 v21, 544
    const/16 v22, 0
    move-object v10, v1
    move-object/from16 v18, v7
    invoke-direct/range v10 ... v22, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 12
    # ins_size=5
    const-string v11, "context"
    invoke-static v8, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v11, "card"
    invoke-static v9, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v11, toolCallInfo
    invoke-static v10, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v7, v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->extractKeywords(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/String;->length()I
    move-result v0
    const/16 v1, 40
    if-le v0, v1, +019h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v11, v1, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v11
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const/16 v0, 8230
    invoke-virtual v11, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v4
    const/4 v5, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v3
    move-object v4, v11
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    move v4, v1
    goto +2h
    move v4, v2
    if-eqz v4, +018h
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v6, "'"
    invoke-direct v4, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v6, 39
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v9, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    const-string v4, "getString(...)"
    if-nez v0, +01bh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_searching_codebase I
    invoke-virtual v8, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_search I
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v9, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v9, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto/16 +091h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v6
    aget v0, v0, v6
    if-ne v0, v1, +01dh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_search_failed_codebase I
    invoke-virtual v8, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v9, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto/16 +06ch
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_searched_codebase I
    invoke-virtual v8, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_search I
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v9, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v9, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v8
    goto +2h
    move-object v8, v5
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->collectFileItems(Lcom/google/gson/JsonObject;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v4
    if-eqz v4, +025h
    const-string v4, "match_occurrences"
    if-eqz v8, +00ah
    invoke-virtual v8, v4, Lcom/google/gson/JsonObject;->has(Ljava/lang/String;)Z
    move-result v6
    if-nez v6, +004h
    move v6, v1
    goto +2h
    move v6, v2
    if-nez v6, +015h
    if-eqz v8, +010h
    invoke-virtual v8, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    if-eqz v8, +00ah
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v8
    if-nez v8, +004h
    move v8, v1
    goto +2h
    move v8, v2
    if-eqz v8, +003h
    move v2, v1
    if-eqz v2, +008h
    new-instance v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$$ExternalSyntheticLambda2;
    invoke-direct v5, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;)V
    goto +10h
    move-object v8, v0
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v8
    xor-int/2addr v8, v1
    if-eqz v8, +007h
    new-instance v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$$ExternalSyntheticLambda3;
    invoke-direct v5, v7, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator; Ljava/util/List;)V
    invoke-virtual v9, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setContentView(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v9, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v0, "[SearchCard] onUpdateCard: name="
    invoke-direct v9, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, ", status="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, ", keywords="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    const-string v10, "AgentTool"
    invoke-virtual v8, v10, v9, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
