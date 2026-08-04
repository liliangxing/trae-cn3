# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "EditFileDetailCardCreator.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$Companion;
.field public static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$2CIcLPkL-ydwwU0nCPGnVJrVbRA(com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;->onUpdateCard$lambda$4(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$3zdUj8rVaG9ABAY6mx0HgUuOMM0(com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;->onCreateDetail$lambda$1(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$LezPi5ws1g9fN-Q9ZtlSovcz5gs(com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;->onCreateDetail$lambda$2(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final buildFileItemRow(android.content.Context  float  com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator$EditFileItem)android.view.View
    .registers 13
    # ins_size=4
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v10, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v1, 16
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v2, 24
    int-to-float v2, v2
    mul-float/2addr v2, v11
    float-to-int v2, v2
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setMinimumHeight(I)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -1
    const/4 v4, -2
    invoke-direct v2, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    int-to-float v1, v1
    mul-float/2addr v1, v11
    float-to-int v1, v1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/FileIconHelper;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->getFilePath()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->getFileIconRes(Ljava/lang/String;)I
    move-result v2
    new-instance v3, Landroid/widget/ImageView;
    invoke-direct v3, v10, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, v2, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v2, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v3, v2, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v3, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v1, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v10, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->getDisplayName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v10, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v2, 1095761920
    const/4 v3, 2
    invoke-virtual v1, v3, v2, Landroid/widget/TextView;->setTextSize(I F)V
    const/4 v2, 1
    invoke-virtual v1, v2, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v5, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v1, v5, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v5, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v6, 4
    int-to-float v6, v6
    mul-float/2addr v6, v11
    float-to-int v6, v6
    invoke-virtual v5, v6, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v5, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->getAdditions()I
    move-result v1
    const/4 v5, 6
    const/high16 v6, 1093664768
    if-lez v1, +043h
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v10, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "+"
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->getAdditions()I
    move-result v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v1, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const-string v7, "#34A853"
    invoke-static v7, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v7
    invoke-virtual v1, v7, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v1, v3, v6, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v1, v2, Landroid/widget/TextView;->setMaxLines(I)V
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    int-to-float v8, v5
    mul-float/2addr v8, v11
    float-to-int v8, v8
    invoke-virtual v7, v8, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v7, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->getDeletions()I
    move-result v1
    if-lez v1, +043h
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v10, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v7, "-"
    invoke-direct v10, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->getDeletions()I
    move-result v12
    invoke-virtual v10, v12, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    invoke-virtual v1, v10, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const-string v10, "#EA4335"
    invoke-static v10, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v10
    invoke-virtual v1, v10, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v1, v3, v6, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v1, v2, Landroid/widget/TextView;->setMaxLines(I)V
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v10, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    int-to-float v12, v5
    mul-float/2addr v12, v11
    float-to-int v11, v12
    invoke-virtual v10, v11, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v10, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
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
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;
    invoke-direct v3, v4, v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;->buildFileItemRow(Landroid/content/Context; F Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;)Landroid/view/View;
    move-result-object v2
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -13h
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final collectFileItems(com.bytedance.trae.im.model.ParsedToolCallInfo)java.util.List
    .registers 13
    # ins_size=2
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +01ah
    const-string v2, "file_path"
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
    if-nez v0, +020h
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-eqz v0, +019h
    const-string v2, "path"
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
    if-nez v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v12
    return-object v12
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v2
    goto +2h
    move-object v2, v1
    if-eqz v2, +019h
    const-string v3, "changes"
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v1
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v2
    goto +2h
    move-object v2, v1
    const/4 v3, 0
    if-eqz v2, +07ah
    invoke-virtual v2, Lcom/google/gson/JsonArray;->size()I
    move-result v4
    if-lez v4, +074h
    invoke-virtual v2, Lcom/google/gson/JsonArray;->size()I
    move-result v12
    move v4, v3
    move v5, v4
    move v6, v5
    if-ge v4, v12, +067h
    invoke-virtual v2, v4, Lcom/google/gson/JsonArray;->get(I)Lcom/google/gson/JsonElement;
    move-result-object v7
    if-eqz v7, +05eh
    invoke-virtual v7, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v8
    if-eqz v8, +003h
    goto +2h
    move-object v7, v1
    if-eqz v7, +054h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v7
    if-nez v7, +003h
    goto +4ch
    const-string v8, "diff_info"
    invoke-virtual v7, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v7
    if-eqz v7, +045h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v8
    if-eqz v8, +003h
    goto +2h
    move-object v7, v1
    if-eqz v7, +03bh
    invoke-virtual v7, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v7
    if-nez v7, +003h
    goto +33h
    const-string v8, "insert_line_count"
    invoke-virtual v7, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    if-eqz v8, +011h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v9
    if-eqz v9, +003h
    goto +2h
    move-object v8, v1
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v8
    goto +2h
    move v8, v3
    add-int/2addr v5, v8
    const-string v8, "delete_line_count"
    invoke-virtual v7, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v7
    if-eqz v7, +011h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v8
    if-eqz v8, +003h
    goto +2h
    move-object v7, v1
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v7
    goto +2h
    move v7, v3
    add-int/2addr v6, v7
    add-int/lit8 v4, v4, 1
    goto -66h
    move v3, v5
    move v12, v6
    goto/16 +07ch
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +019h
    const-string v4, "old_str"
    invoke-virtual v2, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v2, v1
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v1
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-eqz v4, +019h
    const-string v5, "new_str"
    invoke-virtual v4, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +011h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v4, v1
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v1
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v12
    if-eqz v12, +019h
    const-string v5, "content"
    invoke-virtual v12, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v12
    if-eqz v12, +011h
    invoke-virtual v12, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v12, v1
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v12
    goto +2h
    move-object v12, v1
    if-nez v2, +011h
    if-eqz v4, +003h
    goto +dh
    if-eqz v12, +00ah
    invoke-direct v11, v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;->lineCount(Ljava/lang/String;)I
    move-result v12
    move v10, v3
    move v3, v12
    move v12, v10
    goto +12h
    move v12, v3
    goto +10h
    if-eqz v2, +007h
    invoke-direct v11, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;->lineCount(Ljava/lang/String;)I
    move-result v12
    goto +2h
    move v12, v3
    if-eqz v4, +007h
    invoke-direct v11, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;->lineCount(Ljava/lang/String;)I
    move-result v2
    move v3, v2
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;
    const/16 v4, 47
    const/4 v5, 2
    invoke-static v0, v4, v1, v5, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    invoke-direct v2, v0, v1, v3, v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;-><init>(Ljava/lang/String; Ljava/lang/String; I I)V
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v12
    return-object v12
    :try_start_0xac
.end method

.method private final lineCount(java.lang.String)int
    .registers 7
    # ins_size=2
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 0
    const/4 v2, 1
    if-nez v0, +004h
    move v0, v2
    goto +2h
    move v0, v1
    if-eqz v0, +003h
    return v1
    invoke-virtual v6, Ljava/lang/String;->length()I
    move-result v0
    if-ge v1, v0, +00fh
    invoke-virtual v6, v1, Ljava/lang/String;->charAt(I)C
    move-result v3
    const/16 v4, 10
    if-ne v3, v4, +004h
    add-int/lit8 v2, v2, 1
    add-int/lit8 v1, v1, 1
    goto -eh
    return v2
.end method

.method private static final onCreateDetail$lambda$1(com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;->buildFileListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onCreateDetail$lambda$2(com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;->buildFileListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onUpdateCard$lambda$4(com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;->buildFileListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
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
    invoke-virtual/range v25, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v3, +010h
    check-cast v3, Ljava/lang/CharSequence;
    const-string v6, "create"
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v3, v6, v4, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v3
    if-ne v3, v4, +004h
    move v3, v4
    goto +2h
    move v3, v5
    invoke-virtual/range v25, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v6
    if-eqz v6, +004h
    move v6, v4
    goto +2h
    move v6, v5
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
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;->collectFileItems(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/util/List;
    move-result-object v8
    const-string v10, "getString(...)"
    if-eqz v3, +052h
    invoke-static v8, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->getDisplayName()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v9
    if-nez v6, +017h
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_creating I
    invoke-virtual v1, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/conversation/R$drawable;->text_edit I
    move-object v14, v1
    move-object v15, v3
    move/from16 v19, v4
    move v13, v5
    move v12, v6
    move-object/from16 v17, v9
    goto/16 +0bfh
    sget-object v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v11
    aget v6, v6, v11
    if-ne v6, v4, +011h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_failed_create I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    goto/16 +061h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_created I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->text_edit I
    move-object v14, v1
    move-object v15, v3
    move v12, v4
    move v13, v5
    move/from16 v19, v13
    goto -2eh
    if-nez v6, +028h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_editing I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->text_edit I
    move-object v6, v8
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    xor-int/2addr v6, v4
    if-eqz v6, +008h
    new-instance v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$$ExternalSyntheticLambda1;
    invoke-direct v6, v0, v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator; Ljava/util/List;)V
    goto +2h
    move-object v6, v9
    move-object v14, v1
    move v12, v3
    move/from16 v19, v4
    move v13, v5
    move-object/from16 v17, v6
    move-object v15, v9
    goto/16 +06ch
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v6
    aget v3, v3, v6
    if-ne v3, v4, +025h
    invoke-static v8, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->getDisplayName()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v9
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_failed_edit I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    move-object v14, v1
    move-object v15, v3
    move v12, v4
    move/from16 v19, v5
    move v13, v6
    goto/16 -082h
    invoke-interface v8, Ljava/util/List;->size()I
    move-result v3
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_edited I
    invoke-virtual v1, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-lez v3, +015h
    invoke-virtual/range v24, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v10, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_edit_file_count I
    new-array v11, v4, [Ljava/lang/Object;
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    aput-object v12, v11, v5
    invoke-virtual v1, v10, v3, v11, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v9
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->text_edit I
    move-object v10, v8
    check-cast v10, Ljava/util/Collection;
    invoke-interface v10, Ljava/util/Collection;->isEmpty()Z
    move-result v10
    xor-int/2addr v4, v10
    if-eqz v4, +008h
    new-instance v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$$ExternalSyntheticLambda2;
    invoke-direct v4, v0, v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator; Ljava/util/List;)V
    move-object v9, v4
    move-object v15, v1
    move v12, v3
    move v13, v5
    move/from16 v19, v13
    move-object v14, v6
    goto/16 -0bfh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[EditFileCard] onCreateDetail: name="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v25, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", status="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", files="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-interface v8, Ljava/util/List;->size()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
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
    .registers 13
    # ins_size=5
    const-string v12, "context"
    invoke-static v9, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v12, "card"
    invoke-static v10, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v12, toolCallInfo
    invoke-static v11, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v12
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v12, +01fh
    move-object v2, v12
    check-cast v2, Ljava/lang/CharSequence;
    const-string v3, "create"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v2, v3, v0, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v2
    if-nez v2, +00dh
    const-string v2, "Write"
    invoke-static v12, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, +003h
    goto +3h
    move v12, v1
    goto +2h
    move v12, v0
    if-ne v12, v0, +004h
    move v12, v0
    goto +2h
    move v12, v1
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v2
    if-eqz v2, +004h
    move v2, v0
    goto +2h
    move v2, v1
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v4
    const/4 v5, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v3
    invoke-direct v8, v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;->collectFileItems(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/util/List;
    move-result-object v4
    const-string v6, "getString(...)"
    if-eqz v12, +070h
    invoke-static v4, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;
    if-eqz v12, +006h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->getDisplayName()Ljava/lang/String;
    move-result-object v5
    if-nez v2, +01eh
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_creating I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v10, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->text_edit I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto/16 +0ddh
    sget-object v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v2
    aget v12, v12, v2
    if-ne v12, v0, +020h
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_failed_create I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v10, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto/16 +0b5h
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_created I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v10, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->text_edit I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto/16 +099h
    if-nez v2, +01eh
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_editing I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v10, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->text_edit I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto/16 +07bh
    sget-object v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v2
    aget v12, v12, v2
    if-ne v12, v0, +02bh
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_failed_edit I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-static v4, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;
    if-eqz v9, +006h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->getDisplayName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v10, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +47h
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v12
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_edited I
    invoke-virtual v9, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    if-lez v12, +015h
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    sget v2, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_edit_file_count I
    new-array v6, v0, [Ljava/lang/Object;
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    aput-object v7, v6, v1
    invoke-virtual v9, v2, v12, v6, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v5
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->text_edit I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    move-object v9, v4
    check-cast v9, Ljava/util/Collection;
    invoke-interface v9, Ljava/util/Collection;->isEmpty()Z
    move-result v9
    xor-int/2addr v9, v0
    if-eqz v9, +007h
    new-instance v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$$ExternalSyntheticLambda0;
    invoke-direct v5, v8, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator; Ljava/util/List;)V
    invoke-virtual v10, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setContentView(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v10, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v12, "[EditFileCard] onUpdateCard: name="
    invoke-direct v10, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", status="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", files="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v11
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    const-string v11, "AgentTool"
    invoke-virtual v9, v11, v10, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
