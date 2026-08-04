# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "BrowserActionDetailCardCreator.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$Companion;
.field public static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$OOi28Ow7g25c7OVOozlBnH2I1RE(com.bytedance.trae.conversation.chat.toolcall.cards.detail.BrowserActionDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;->createBrowserActionCard$lambda$2(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$vRvqp5Lma8aJa_fwc1k3KRSdMK4(com.bytedance.trae.conversation.chat.toolcall.cards.detail.BrowserActionDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;->createBrowserActionCard$lambda$1(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final buildActionRow(android.content.Context  float  com.bytedance.trae.conversation.chat.toolcall.cards.detail.BrowserActionDetailCardCreator$BrowserAction)android.view.View
    .registers 14
    # ins_size=4
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v11, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v2, 24
    int-to-float v2, v2
    mul-float/2addr v2, v12
    float-to-int v2, v2
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setMinimumHeight(I)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -1
    const/4 v4, -2
    invoke-direct v2, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v11, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;->getAction()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v11, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v2, v3, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v3, 2
    const/high16 v5, 1095761920
    invoke-virtual v2, v3, v5, Landroid/widget/TextView;->setTextSize(I F)V
    const/4 v6, 1
    invoke-virtual v2, v6, Landroid/widget/TextView;->setMaxLines(I)V
    check-cast v2, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;->getTarget()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +05fh
    const/4 v2, 6
    int-to-float v2, v2
    mul-float/2addr v2, v12
    float-to-int v2, v2
    const/4 v7, 4
    int-to-float v7, v7
    mul-float/2addr v7, v12
    float-to-int v7, v7
    int-to-float v8, v3
    mul-float/2addr v8, v12
    float-to-int v8, v8
    new-instance v9, Landroid/widget/TextView;
    invoke-direct v9, v11, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;->getTarget()Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-virtual v9, v13, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v13, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v11, v13, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v13
    invoke-virtual v9, v13, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v9, v3, v5, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v9, v6, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v13, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v9, v13, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v9, v7, v8, v7, v8, Landroid/widget/TextView;->setPadding(I I I I)V
    new-instance v13, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v13, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v11, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v11
    invoke-virtual v13, v11, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v11, 30
    int-to-float v11, v11
    mul-float/2addr v11, v12
    invoke-virtual v13, v11, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    check-cast v13, Landroid/graphics/drawable/Drawable;
    invoke-virtual v9, v13, Landroid/widget/TextView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    check-cast v9, Landroid/view/View;
    new-instance v11, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v12, 1065353216
    invoke-direct v11, v1, v4, v12, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    invoke-virtual v11, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v9, v11, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private final buildActionsListView(android.content.Context  java.util.List)android.view.View
    .registers 9
    # ins_size=3
    invoke-virtual v7, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 1
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    const/4 v2, 0
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +029h
    add-int/lit8 v3, v2, 1
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;
    invoke-direct v6, v7, v0, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;->buildActionRow(Landroid/content/Context; F Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;)Landroid/view/View;
    move-result-object v4
    if-lez v2, +016h
    invoke-virtual v4, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v2
    instance-of v5, v2, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v5, +005h
    check-cast v2, Landroid/widget/LinearLayout$LayoutParams;
    goto +2h
    const/4 v2, 0
    if-eqz v2, +008h
    const/4 v5, 4
    int-to-float v5, v5
    mul-float/2addr v5, v0
    float-to-int v5, v5
    iput v5, v2, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move v2, v3
    goto -2ch
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final collectBrowserActions(com.bytedance.trae.im.model.ParsedToolCallInfo)java.util.List
    .registers 13
    # ins_size=2
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +020h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v1
    if-eqz v1, +01ah
    const-string/jumbo v3, steps
    invoke-virtual v1, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +011h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v1, v2
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v1
    goto +2h
    move-object v1, v2
    const/4 v3, 0
    if-eqz v1, +05dh
    invoke-virtual v1, Lcom/google/gson/JsonArray;->size()I
    move-result v12
    if-ge v3, v12, +056h
    invoke-virtual v1, v3, Lcom/google/gson/JsonArray;->get(I)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +04dh
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v4, v2
    if-eqz v4, +043h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-nez v4, +003h
    goto +3bh
    const-string v5, "action"
    invoke-virtual v4, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +034h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v5, v2
    if-eqz v5, +02ah
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    goto +22h
    const-string/jumbo v6, target
    invoke-virtual v4, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +011h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v4, v2
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v2
    new-instance v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;
    invoke-direct v6, v5, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    add-int/lit8 v3, v3, 1
    goto -55h
    return-object v0
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00ch
    const-string v4, "browser_"
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v1, v4, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v1
    move-object v4, v1
    goto +2h
    move-object v4, v2
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v12
    if-eqz v12, +138h
    if-eqz v4, +136h
    const-string/jumbo v1, url
    invoke-virtual v12, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +011h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v1, v2
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    const-string/jumbo v5, selector
    invoke-virtual v12, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +015h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v5, v2
    if-eqz v5, +00bh
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    goto +3h
    move-object v12, v5
    goto +19h
    const-string v5, "element"
    invoke-virtual v12, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v12
    if-eqz v12, +011h
    invoke-virtual v12, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v12, v2
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    goto -18h
    move-object v12, v2
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    const-string v6, "navigate"
    check-cast v6, Ljava/lang/CharSequence;
    const/4 v10, 1
    invoke-static v5, v6, v10, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v6
    if-nez v6, +0d1h
    const-string v6, "goto"
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v5, v6, v10, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v6
    if-eqz v6, +004h
    goto/16 +0c5h
    const-string/jumbo v6, snapshot
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v5, v6, v10, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v6
    if-nez v6, +0afh
    const-string/jumbo v6, screenshot
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v5, v6, v10, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v6
    if-eqz v6, +004h
    goto/16 +0a2h
    const-string v2, "get_attribute"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v5, v2, v10, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v2
    if-nez v2, +08dh
    const-string v2, "getAttribute"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v5, v2, v10, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v2
    if-eqz v2, +004h
    goto/16 +081h
    const-string v2, "click"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v5, v2, v10, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v2
    if-eqz v2, +00eh
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;
    const-string v2, "Clicked"
    invoke-direct v1, v2, v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto/16 +08bh
    const-string/jumbo v2, type
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v5, v2, v10, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v2
    if-nez v2, +055h
    const-string v2, "input"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v5, v2, v10, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v2
    if-eqz v2, +003h
    goto +49h
    const-string v5, "_"
    const-string v6, " "
    const/4 v7, 0
    const/4 v8, 4
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    move v4, v10
    goto +2h
    move v4, v3
    if-eqz v4, +025h
    invoke-virtual v2, v3, Ljava/lang/String;->charAt(I)C
    move-result v3
    invoke-static v3, Ljava/lang/Character;->toUpperCase(C)C
    move-result v3
    invoke-virtual v2, v10, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v4, substring(...)
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;
    if-nez v1, +003h
    move-object v1, v12
    invoke-direct v3, v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +2ch
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;
    const-string v2, "Typed in"
    invoke-direct v1, v2, v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +21h
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;
    const-string v2, "Getting attribute from"
    invoke-direct v1, v2, v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +16h
    new-instance v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;
    const-string v1, "Captured snapshot"
    invoke-direct v12, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, v12, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +bh
    new-instance v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;
    const-string v2, "Navigated to"
    invoke-direct v12, v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, v12, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-object v0
.end method

.method private final createBrowserActionCard(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 25
    # ins_size=4
    move-object/from16 v0, v21
    move-object/from16 v1, v22
    invoke-virtual/range v23, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +004h
    move v2, v4
    goto +2h
    move v2, v3
    sget-object v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v23, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v6
    const/4 v7, 0
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v7
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v16
    if-eqz v24, +012h
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v5
    if-eqz v5, +00ch
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v5
    if-ne v5, v4, +006h
    move-object/from16 v5, v23
    move v6, v4
    goto +4h
    move-object/from16 v5, v23
    move v6, v3
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;->collectBrowserActions(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/util/List;
    move-result-object v5
    const-string v8, "getString(...)"
    if-eqz v6, +01dh
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_waiting_takeover I
    invoke-virtual v1, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->browser_use I
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v1, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v14, v1
    move-object v12, v2
    move v10, v3
    move/from16 v17, v4
    move-object v15, v7
    goto +5ch
    const-string v6, ""
    if-nez v2, +022h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_using I
    invoke-virtual v1, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->browser_use I
    move-object v3, v5
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    xor-int/2addr v3, v4
    if-eqz v3, +008h
    new-instance v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$$ExternalSyntheticLambda0;
    invoke-direct v3, v0, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator; Ljava/util/List;)V
    move-object v7, v3
    move-object v12, v1
    move v10, v2
    move/from16 v17, v4
    goto +1ah
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v9
    aget v2, v2, v9
    if-ne v2, v4, +013h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_failed I
    invoke-virtual v1, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->browser_use I
    move-object v12, v1
    move v10, v2
    move/from16 v17, v3
    move-object v14, v6
    goto -40h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_used I
    invoke-virtual v1, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->browser_use I
    move-object v8, v5
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v8
    xor-int/2addr v4, v8
    if-eqz v4, -019h
    new-instance v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$$ExternalSyntheticLambda1;
    invoke-direct v4, v0, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator; Ljava/util/List;)V
    move-object v7, v4
    goto -21h
    const/4 v11, 0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v9, ""
    const/4 v13, 0
    const/16 v18, 0
    const/16 v19, 528
    const/16 v20, 0
    move-object v8, v1
    invoke-direct/range v8 ... v20, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method private static final createBrowserActionCard$lambda$1(com.bytedance.trae.conversation.chat.toolcall.cards.detail.BrowserActionDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;->buildActionsListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final createBrowserActionCard$lambda$2(com.bytedance.trae.conversation.chat.toolcall.cards.detail.BrowserActionDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;->buildActionsListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private final createHandOverCard(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 23
    # ins_size=3
    move-object/from16 v0, v21
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v1
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v5
    const/4 v6, 0
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v6
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v15
    const-string v4, "getString(...)"
    if-nez v1, +012h
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_user_taking_over I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v1, v20
    move-object v11, v0
    move/from16 v16, v2
    move-object v12, v6
    goto +32h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->FAILED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-eq v15, v1, +00ch
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->SKIPPED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-eq v15, v1, +008h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v15, v1, +003h
    goto +2h
    move v2, v3
    if-eqz v2, +00eh
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_user_declined I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v1, v20
    goto +12h
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_user_takeover I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v1, v20
    move-object/from16 v2, v22
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;->extractDuration(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v6
    move-object v11, v0
    move/from16 v16, v3
    goto -32h
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v8, ""
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->user_remove I
    const/4 v10, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v17, 0
    const/16 v18, 612
    const/16 v19, 0
    move-object v7, v0
    invoke-direct/range v7 ... v19, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method private final createWaitingInteractionCard(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 20
    # ins_size=4
    move-object/from16 v0, v17
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v11
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v19, +010h
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v3
    if-eqz v3, +00ah
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v3
    if-ne v3, v1, +004h
    move v3, v1
    goto +2h
    move v3, v2
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->browser_use I
    const-string v5, "getString(...)"
    if-eqz v3, +016h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_waiting_takeover I
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v0, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    move-object v9, v0
    move v12, v1
    move-object v7, v2
    move v5, v4
    goto +28h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v4
    aget v3, v3, v4
    const-string v4, ""
    if-ne v3, v1, +00eh
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_failed I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->browser_use I
    goto +ch
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_used I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->browser_use I
    move-object v7, v0
    move v5, v1
    move v12, v2
    move-object v9, v4
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v4, ""
    const/4 v6, 0
    const/4 v8, 0
    const/4 v10, 0
    const/4 v13, 0
    const/16 v14, 596
    const/4 v15, 0
    move-object v3, v0
    invoke-direct/range v3 ... v15, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method private final extractDuration(com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 6
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v5
    const/4 v0, 0
    if-eqz v5, +071h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v5
    if-nez v5, +004h
    goto/16 +069h
    const-string v1, "duration"
    invoke-virtual v5, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +011h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v0
    if-eqz v1, +003h
    return-object v1
    const-string v1, "duration_seconds"
    invoke-virtual v5, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +015h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v5, v0
    if-eqz v5, +00bh
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsLong()J
    move-result-wide v1
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v5
    goto +2h
    move-object v5, v0
    if-eqz v5, +030h
    invoke-virtual v5, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    const/16 v2, 60
    int-to-long v2, v2
    div-long/2addr v0, v2
    const-wide/16 v2, 0
    cmp-long v2, v0, v2
    if-lez v2, +00eh
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v5, v0, v1, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, " minutes"
    goto +ch
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, " seconds"
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    return-object v5
    return-object v0
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 8
    # ins_size=4
    const-string v0, "context"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +019h
    const-string/jumbo v3, url
    invoke-virtual v1, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +010h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v1, v2
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    const-string v1, "BrowserHandOver"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +007h
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;->createHandOverCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v5
    goto +12h
    const-string v1, "BrowserWaitingForUserInteraction"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +007h
    invoke-direct v4, v5, v6, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;->createWaitingInteractionCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v5
    goto +5h
    invoke-direct v4, v5, v6, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;->createBrowserActionCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v1, "[BrowserActionCard] onCreateDetail: name="
    invoke-direct v7, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v0, ", result="
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v0, ", url="
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v0, "AgentTool"
    invoke-virtual v6, v0, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-object v5
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 13
    # ins_size=5
    const-string v0, "context"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "card"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v1
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v5
    const/4 v6, 0
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v6
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v4
    const-string v5, "BrowserHandOver"
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    const-string v7, "getString(...)"
    if-eqz v5, +054h
    if-nez v1, +015h
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_user_taking_over I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v10, v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +37h
    sget-object v12, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->FAILED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-eq v4, v12, +00ch
    sget-object v12, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->SKIPPED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-eq v4, v12, +008h
    sget-object v12, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v4, v12, +003h
    goto +2h
    move v2, v3
    if-eqz v2, +012h
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_user_declined I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v10, v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    goto +14h
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_user_takeover I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-direct v8, v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;->extractDuration(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v9
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    invoke-virtual v10, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->user_remove I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    goto/16 +09ch
    const-string v5, "BrowserWaitingForUserInteraction"
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +04ah
    if-eqz v12, +010h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v12
    if-eqz v12, +00ah
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v12
    if-ne v12, v2, +004h
    move v12, v2
    goto +2h
    move v12, v3
    if-nez v1, +01fh
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_waiting_takeover I
    invoke-virtual v9, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    if-eqz v12, +009h
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v6
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +13h
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_user_taking_over I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v10, v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v10, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->user_remove I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    goto +4bh
    if-nez v1, +017h
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_using I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->browser_use I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +34h
    sget-object v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v1
    aget v12, v12, v1
    if-ne v12, v2, +017h
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_failed I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->browser_use I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v10, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +15h
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_browser_used I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->browser_use I
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v10, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v10, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v12, "[BrowserActionCard] onUpdateCard: name="
    invoke-direct v10, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v12, ", status="
    invoke-virtual v10, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v12, ", url="
    invoke-virtual v10, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v11
    if-eqz v11, +019h
    const-string/jumbo v12, url
    invoke-virtual v11, v12, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v11
    if-eqz v11, +010h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v12
    if-eqz v12, +003h
    goto +2h
    move-object v11, v6
    if-eqz v11, +006h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v10, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    const-string v11, "AgentTool"
    invoke-virtual v9, v11, v10, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
