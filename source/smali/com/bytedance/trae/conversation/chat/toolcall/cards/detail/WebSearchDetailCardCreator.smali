# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "WebSearchDetailCardCreator.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$Companion;
.field private static final MAX_RESULTS:I
.field private static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$-hQXwZlTlK-W5FhlPJGh4YP-KaA(com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator  android.content.Context)android.view.View
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->onUpdateCard$lambda$5(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$2ot2MEPB11WSVtY7DgXPypPiMGA(com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->onUpdateCard$lambda$4(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$VmF0J5aDrl8yaxaEg2plc6j5FsE(com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator  android.content.Context)android.view.View
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->onCreateDetail$lambda$2(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$mpJdbaO6ESQShiIJRdAfMNGN-vg(com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator  android.content.Context  com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator$WebSearchResult  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->buildResultItemRow$lambda$16$lambda$15(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$p1Ly-8j5dMXMupVfXFo59cKY2Ik(com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->onCreateDetail$lambda$1(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final buildEmptyView(android.content.Context)android.view.View
    .registers 5
    # ins_size=2
    invoke-virtual v4, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v4, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_web_search_no_matches I
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

.method private final buildResultItemRow(android.content.Context  float  int  com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator$WebSearchResult)android.view.View
    .registers 15
    # ins_size=5
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v11, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v3, 24
    int-to-float v3, v3
    mul-float/2addr v3, v12
    float-to-int v3, v3
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setMinimumHeight(I)V
    const/4 v3, 4
    int-to-float v3, v3
    mul-float/2addr v3, v12
    float-to-int v3, v3
    invoke-virtual v0, v1, v3, v1, v3, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;->getLink()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 1
    if-eqz v4, +010h
    invoke-virtual v0, v5, Landroid/widget/LinearLayout;->setClickable(Z)V
    invoke-virtual v0, v5, Landroid/widget/LinearLayout;->setFocusable(Z)V
    new-instance v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda4;
    invoke-direct v4, v10, v11, v14, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;)V
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v4, Landroid/widget/TextView;
    invoke-direct v4, v11, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-static v13, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-virtual v4, v13, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const-string v13, "JetBrains Mono"
    invoke-static v13, v1, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v13
    invoke-virtual v4, v13, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    sget v13, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v11, v13, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v13
    invoke-virtual v4, v13, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v13, 2
    const/high16 v6, 1095761920
    invoke-virtual v4, v13, v6, Landroid/widget/TextView;->setTextSize(I F)V
    const/16 v7, 12
    int-to-float v7, v7
    mul-float/2addr v7, v12
    float-to-int v7, v7
    invoke-virtual v4, v7, Landroid/widget/TextView;->setMinWidth(I)V
    check-cast v4, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v8, -2
    invoke-direct v7, v8, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v4, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Landroid/widget/LinearLayout;
    invoke-direct v4, v11, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v4, v5, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v7, 17
    invoke-virtual v4, v7, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    int-to-float v2, v2
    mul-float/2addr v2, v12
    float-to-int v2, v2
    invoke-direct v7, v2, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v7, v3, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v7, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const/16 v2, 13
    int-to-float v2, v2
    mul-float/2addr v2, v12
    float-to-int v2, v2
    new-instance v3, Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-direct v3, v11, Lcom/facebook/drawee/view/SimpleDraweeView;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, Lcom/facebook/drawee/view/SimpleDraweeView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    move-result-object v7
    check-cast v7, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_web I
    invoke-virtual v7, v9, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setPlaceholderImage(I)V
    move-object v7, v3
    check-cast v7, Landroid/view/View;
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v2, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v7, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v4, Landroid/view/View;
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;->getFavicon()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v1
    goto +2h
    move v2, v5
    if-nez v2, +00dh
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;->getFavicon()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    invoke-virtual v3, v2, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v11, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;->getTitle()Ljava/lang/String;
    move-result-object v14
    check-cast v14, Ljava/lang/CharSequence;
    invoke-virtual v2, v14, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v14, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v11, v14, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v11
    invoke-virtual v2, v11, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v2, v13, v6, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v2, v5, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v11, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v2, v11, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    new-instance v11, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v13, 1065353216
    invoke-direct v11, v1, v8, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/16 v13, 8
    int-to-float v13, v13
    mul-float/2addr v13, v12
    float-to-int v12, v13
    invoke-virtual v11, v12, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v11, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v2, Landroid/view/View;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private static final buildResultItemRow$lambda$16$lambda$15(com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator  android.content.Context  com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator$WebSearchResult  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;->getLink()Ljava/lang/String;
    move-result-object v2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->openUrl(Landroid/content/Context; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v2, tool_name
    const-string v3, "WebSearch"
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string/jumbo v2, tool_call_click
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method private final buildResultList(android.content.Context  java.util.List)android.view.View
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
    check-cast v7, Ljava/lang/Iterable;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    const/4 v3, 0
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +011h
    add-int/2addr v3, v2
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;
    invoke-direct v5, v6, v0, v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->buildResultItemRow(Landroid/content/Context; F I Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;)Landroid/view/View;
    move-result-object v4
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -14h
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final extractResults(com.bytedance.trae.im.model.ParsedToolCallInfo)java.util.List
    .registers 9
    # ins_size=2
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v8
    if-eqz v8, +0cbh
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v8
    if-nez v8, +004h
    goto/16 +0c3h
    const-string/jumbo v0, results
    invoke-virtual v8, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +012h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v0
    if-nez v0, +022h
    const-string v0, "references"
    invoke-virtual v8, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    if-eqz v8, +012h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v8, v1
    if-eqz v8, +008h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v8
    move-object v0, v8
    goto +2h
    move-object v0, v1
    if-nez v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v8
    return-object v8
    new-instance v8, Ljava/util/ArrayList;
    invoke-direct v8, Ljava/util/ArrayList;-><init>()V
    check-cast v8, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v2, 0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +074h
    add-int/lit8 v3, v2, 1
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/google/gson/JsonElement;
    const/4 v5, 5
    if-ge v2, v5, +069h
    if-eqz v4, +065h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v4, v1
    if-eqz v4, +05bh
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-nez v2, +003h
    goto +53h
    const-string/jumbo v4, title
    invoke-virtual v2, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +04bh
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v4, v1
    if-eqz v4, +041h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    goto +39h
    const-string v5, "link"
    invoke-virtual v2, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +011h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v5, v1
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v1
    const-string v6, "favicon"
    invoke-virtual v2, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v2, v1
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v1
    new-instance v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;
    invoke-direct v6, v4, v5, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v8, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    move v2, v3
    goto -77h
    return-object v8
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v8
    return-object v8
.end method

.method private static final onCreateDetail$lambda$1(com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->buildResultList(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onCreateDetail$lambda$2(com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator  android.content.Context)android.view.View
    .registers 3
    # ins_size=2
    const-string v0, "ctx"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->buildEmptyView(Landroid/content/Context;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onUpdateCard$lambda$4(com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->buildResultList(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onUpdateCard$lambda$5(com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator  android.content.Context)android.view.View
    .registers 3
    # ins_size=2
    const-string v0, "ctx"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->buildEmptyView(Landroid/content/Context;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private final openUrl(android.content.Context  java.lang.String)void
    .registers 5
    # ins_size=3
    new-instance v0, Landroid/content/Intent;
    const-string v1, "android.intent.action.VIEW"
    invoke-static v4, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v4
    invoke-direct v0, v1, v4, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    const/high16 v4, 268435456
    invoke-virtual v0, v4, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v3, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
    :try_start_0x0
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 22
    # ins_size=4
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    move-object/from16 v2, v20
    const-string v3, "context"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, toolCallInfo
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v3
    const/4 v4, 0
    if-eqz v3, +01ah
    const-string v5, "query"
    invoke-virtual v3, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +012h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v3, v4
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +005h
    const-string/jumbo v3, …
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v5
    const/16 v6, 40
    if-le v5, v6, +019h
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v3, v6, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v5, 8230
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    move-object v10, v3
    invoke-virtual/range v20, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v3, +004h
    move v3, v5
    goto +2h
    move v3, v6
    sget-object v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v20, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v4
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v13
    const-string v7, "getString(...)"
    if-nez v3, +013h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_web_searching I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_web I
    move-object v9, v1
    move v7, v3
    move-object v12, v4
    move v14, v5
    move v8, v6
    goto +48h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v8
    aget v3, v3, v8
    if-ne v3, v5, +015h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_web_search_failed I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    move-object v9, v1
    move v7, v3
    move-object v12, v4
    move v8, v5
    move v14, v6
    goto +2bh
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->extractResults(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/util/List;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_web_searched I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_web I
    move-object v7, v3
    check-cast v7, Ljava/util/Collection;
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    xor-int/2addr v5, v7
    if-eqz v5, +009h
    new-instance v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda2;
    invoke-direct v5, v0, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator; Ljava/util/List;)V
    move-object v3, v5
    goto +6h
    new-instance v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda3;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;)V
    move-object v9, v1
    move-object v12, v3
    move v7, v4
    move v8, v6
    move v14, v8
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[WebSearchCard] onCreateDetail: name="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", status="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", query="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "AgentTool"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v6, ""
    const/4 v11, 0
    const/4 v15, 0
    const/16 v16, 544
    const/16 v17, 0
    move-object v5, v1
    invoke-direct/range v5 ... v17, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 11
    # ins_size=5
    const-string v10, "context"
    invoke-static v7, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v10, "card"
    invoke-static v8, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v10, toolCallInfo
    invoke-static v9, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v10
    const/4 v0, 0
    if-eqz v10, +01ah
    const-string v1, "query"
    invoke-virtual v10, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v10
    if-eqz v10, +012h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v10, v0
    if-eqz v10, +008h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v10
    if-nez v10, +005h
    const-string/jumbo v10, …
    invoke-virtual v10, Ljava/lang/String;->length()I
    move-result v1
    const/16 v2, 40
    if-le v1, v2, +019h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v10, v2, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v10
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const/16 v1, 8230
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v1
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v5
    if-eqz v5, +006h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v0
    invoke-virtual v8, v10, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    const-string v4, "getString(...)"
    if-nez v1, +01ah
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_web_searching I
    invoke-virtual v7, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_web I
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v8, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v8, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +58h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v5
    aget v1, v1, v5
    if-ne v1, v2, +01ch
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_web_search_failed I
    invoke-virtual v7, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v8, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +34h
    invoke-direct v6, v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->extractResults(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/util/List;
    move-result-object v1
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_web_searched I
    invoke-virtual v7, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_web I
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v8, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v8, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    move-object v7, v1
    check-cast v7, Ljava/util/Collection;
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    xor-int/2addr v7, v2
    if-eqz v7, +008h
    new-instance v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda0;
    invoke-direct v7, v6, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator; Ljava/util/List;)V
    goto +6h
    new-instance v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda1;
    invoke-direct v7, v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;)V
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setContentView(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v1, "[WebSearchCard] onUpdateCard: name="
    invoke-direct v8, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", status="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", query="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    const-string v9, "AgentTool"
    invoke-virtual v7, v9, v8, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
