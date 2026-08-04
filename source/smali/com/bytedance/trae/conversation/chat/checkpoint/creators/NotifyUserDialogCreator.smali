# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator;
.super Ljava/lang/Object;
.source "NotifyUserDialogCreator.kt"

.implements Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;

.field private fileClickListener:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$UmuopMKFGZyQnFR7JUveNe50tRo(com.bytedance.trae.conversation.chat.checkpoint.creators.NotifyUserDialogCreator  java.lang.String  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator;->createContentView$lambda$12$lambda$8$lambda$7(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final createContentView$lambda$12$lambda$8$lambda$7(com.bytedance.trae.conversation.chat.checkpoint.creators.NotifyUserDialogCreator  java.lang.String  android.view.View)void
    .registers 3
    # ins_size=3
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator;->fileClickListener Lkotlin/jvm/functions/Function1;
    if-eqz v0, +005h
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final getFileIconRes(java.lang.String)int
    .registers 5
    # ins_size=2
    const/4 v0, 0
    const/4 v1, 2
    const/16 v2, 47
    invoke-static v4, v2, v0, v1, v0, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const/16 v1, 46
    const-string v2, ""
    invoke-static v0, v1, v2, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v1
    const/16 v2, 3479
    if-eq v1, v2, +01fh
    const v2, 107969
    if-eq v1, v2, +011h
    const v2, 246938863
    if-eq v1, v2, +003h
    goto +1bh
    const-string v1, "markdown"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +014h
    goto +19h
    const-string v1, "mdx"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +012h
    goto +9h
    const-string v1, "md"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +009h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/FileIconHelper;
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->getFileIconRes(Ljava/lang/String;)I
    move-result v4
    goto +3h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_notify_markdown_file I
    return v4
.end method

.method public bindActions(android.view.View  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->bindActions(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Landroid/view/View; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public bindActions(android.view.View  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->bindActions(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Landroid/view/View; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public createContentView(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ConfirmInfo)android.view.View
    .registers 20
    # ins_size=4
    move-object/from16 v0, v16
    move-object/from16 v1, v17
    move-object/from16 v2, v18
    const-string v3, "context"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, toolCallInfo
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator;->getCHECK_POINT_TAG()Ljava/lang/String;
    move-result-object v4
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "[NotifyUserDialogCreator] createContentView: toolCallInfo="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v17, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->density F
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v2
    const/4 v4, 0
    if-eqz v2, +019h
    const-string v5, "explanation"
    invoke-virtual v2, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +011h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v5, v4
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v4
    if-eqz v2, +019h
    const-string v6, "message"
    invoke-virtual v2, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    if-eqz v6, +011h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    move-object v6, v4
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v4
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/List;
    if-eqz v2, +03fh
    const-string v8, "file_paths"
    invoke-virtual v2, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +037h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v8
    if-eqz v8, +003h
    goto +2h
    move-object v2, v4
    if-eqz v2, +02dh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v2
    if-eqz v2, +027h
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +01bh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/google/gson/JsonElement;
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v9
    if-eqz v9, -010h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v8
    const-string v9, "getAsString(...)"
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v7, v8, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -1eh
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v8, 1
    invoke-virtual v2, v8, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v10, -1
    const/4 v11, -2
    invoke-direct v9, v10, v11, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v9, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    if-nez v5, +003h
    move-object v5, v6
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 0
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-nez v9, +003h
    goto +3h
    move v9, v6
    goto +2h
    move v9, v8
    const/16 v12, 20
    const/4 v13, 2
    if-nez v9, +02dh
    new-instance v9, Landroid/widget/TextView;
    invoke-direct v9, v1, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v9, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v1, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v9, v5, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v5, 1097859072
    invoke-virtual v9, v13, v5, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v9, v6, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    int-to-float v5, v12
    mul-float/2addr v5, v3
    float-to-int v5, v5
    invoke-static v9, v5, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    check-cast v9, Landroid/view/View;
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v5, v10, v11, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v9, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    move-object v5, v7
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    xor-int/2addr v5, v8
    if-eqz v5, +0d6h
    new-instance v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;
    invoke-direct v5, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;-><init>(Landroid/content/Context;)V
    const/16 v9, 12
    int-to-float v9, v9
    mul-float/2addr v9, v3
    float-to-int v9, v9
    invoke-virtual v5, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->setHorizontalGap(I)V
    invoke-virtual v5, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->setVerticalGap(I)V
    check-cast v7, Ljava/lang/Iterable;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v14
    if-eqz v14, +0a8h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v14
    check-cast v14, Ljava/lang/String;
    new-instance v15, Landroid/widget/LinearLayout;
    invoke-direct v15, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    sget v10, Lcom/bytedance/trae/conversation/R$id;->notify_file_chip I
    invoke-virtual v15, v10, Landroid/widget/LinearLayout;->setId(I)V
    invoke-virtual v15, v6, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v10, 16
    invoke-virtual v15, v10, Landroid/widget/LinearLayout;->setGravity(I)V
    invoke-virtual v15, v8, Landroid/widget/LinearLayout;->setClickable(Z)V
    invoke-virtual v15, v8, Landroid/widget/LinearLayout;->setFocusable(Z)V
    const/16 v11, 8
    int-to-float v11, v11
    mul-float/2addr v11, v3
    float-to-int v11, v11
    const/4 v8, 4
    int-to-float v8, v8
    mul-float/2addr v8, v3
    float-to-int v8, v8
    invoke-virtual v15, v11, v8, v11, v8, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    sget v11, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_notify_file_chip I
    invoke-static v1, v11, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v11
    invoke-virtual v15, v11, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v11, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$$ExternalSyntheticLambda0;
    invoke-direct v11, v0, v14, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator; Ljava/lang/String;)V
    invoke-virtual v15, v11, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    int-to-float v10, v10
    mul-float/2addr v10, v3
    float-to-int v10, v10
    new-instance v11, Landroid/widget/ImageView;
    invoke-direct v11, v1, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    invoke-direct v0, v14, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator;->getFileIconRes(Ljava/lang/String;)I
    move-result v12
    invoke-virtual v11, v12, Landroid/widget/ImageView;->setImageResource(I)V
    new-instance v12, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v12, v10, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v12, v8, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v12, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v11, v12, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v11, Landroid/view/View;
    invoke-virtual v15, v11, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    const/16 v8, 47
    invoke-static v14, v8, v4, v13, v4, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v8
    new-instance v10, Landroid/widget/TextView;
    invoke-direct v10, v1, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v10, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v1, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v10, v8, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v8, 1096810496
    invoke-virtual v10, v13, v8, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v10, v6, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    const/16 v8, 20
    int-to-float v11, v8
    mul-float/2addr v11, v3
    float-to-int v11, v11
    invoke-static v10, v11, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    const/4 v11, 1
    invoke-virtual v10, v11, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v12, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v10, v12, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    check-cast v10, Landroid/view/View;
    new-instance v12, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v14, -2
    invoke-direct v12, v14, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v12, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v15, v10, v12, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v15, Landroid/view/View;
    invoke-virtual v5, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->addView(Landroid/view/View;)V
    move v12, v8
    move v8, v11
    move v11, v14
    const/4 v10, -1
    goto/16 -0aah
    move v14, v11
    check-cast v5, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -1
    invoke-direct v1, v3, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v9, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v5, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v2, Landroid/view/View;
    return-object v2
.end method

.method public getCHECK_POINT_TAG()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getCHECK_POINT_TAG(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getContentTopMarginDp()int
    .registers 2
    # ins_size=1
    const/16 v0, 12
    return v0
.end method

.method public getContentTopMarginRes()int
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getContentTopMarginRes(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
    return v0
.end method

.method public getHeaderLabel(android.content.Context)java.lang.String
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getHeaderLabel(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Landroid/content/Context;)Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method public getPrimaryButtonBackgroundRes()int
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getPrimaryButtonBackgroundRes(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
    return v0
.end method

.method public getPrimaryButtonText(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_confirm I
    invoke-virtual v2, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v0, "getString(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public getSecondaryButtonText(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_skip I
    invoke-virtual v2, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v0, "getString(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public getTitle(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 4
    # ins_size=3
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_notify_user_title I
    invoke-virtual v2, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v3, "getString(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public getTitleLetterSpacing()float
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getTitleLetterSpacing(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)F
    move-result v0
    return v0
.end method

.method public getTitleTextColorRes()int
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getTitleTextColorRes(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
    return v0
.end method

.method public hideDefaultButtons()boolean
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->hideDefaultButtons(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)Z
    move-result v0
    return v0
.end method

.method public setFileClickListener(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator;->fileClickListener Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public setResolvedDisplayName(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->setResolvedDisplayName(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Ljava/lang/String;)V
    return-void 
.end method

.method public showCloseButton()boolean
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->showCloseButton(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)Z
    move-result v0
    return v0
.end method
