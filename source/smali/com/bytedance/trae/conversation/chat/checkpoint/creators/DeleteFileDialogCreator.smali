# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/DeleteFileDialogCreator;
.super Ljava/lang/Object;
.source "DeleteFileDialogCreator.kt"

.implements Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
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
    move-object/from16 v0, v17
    const-string v1, "context"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, toolCallInfo
    move-object/from16 v2, v18
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v17, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v2
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/List;
    const/4 v4, 0
    if-eqz v2, +03fh
    const-string v5, "file_paths"
    invoke-virtual v2, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +037h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v5, v4
    if-eqz v5, +02dh
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v5
    if-eqz v5, +027h
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +01bh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/google/gson/JsonElement;
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, -010h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    const-string v7, "getAsString(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v3, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -1eh
    invoke-interface v3, Ljava/util/List;->isEmpty()Z
    move-result v5
    if-eqz v5, +01fh
    if-eqz v2, +01dh
    const-string v5, "file_path"
    invoke-virtual v2, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +015h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v2, v4
    if-eqz v2, +00bh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +005h
    invoke-interface v3, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v5, 1
    invoke-virtual v2, v5, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v7, -1
    const/4 v8, -2
    invoke-direct v6, v7, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v6, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v6, Landroid/widget/LinearLayout;
    invoke-direct v6, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v9, 0
    invoke-virtual v6, v9, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v10, 16
    invoke-virtual v6, v10, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v11, 20
    int-to-float v11, v11
    mul-float/2addr v11, v1
    float-to-int v11, v11
    new-instance v12, Landroid/widget/ImageView;
    invoke-direct v12, v0, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v13, Lcom/bytedance/trae/conversation/R$drawable;->ic_file_warning I
    invoke-virtual v12, v13, Landroid/widget/ImageView;->setImageResource(I)V
    new-instance v13, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v13, v11, v11, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v11, 4
    int-to-float v11, v11
    mul-float/2addr v11, v1
    float-to-int v11, v11
    invoke-virtual v13, v11, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v13, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v13, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v12, Landroid/view/View;
    invoke-virtual v6, v12, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v11, Landroid/widget/TextView;
    invoke-direct v11, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_delete_file_title I
    invoke-virtual v0, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v12
    check-cast v12, Ljava/lang/CharSequence;
    invoke-virtual v11, v12, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v12, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v0, v12, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v12
    invoke-virtual v11, v12, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v12, 1099431936
    const/4 v13, 2
    invoke-virtual v11, v13, v12, Landroid/widget/TextView;->setTextSize(I F)V
    sget-object v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->defaultMedium()Landroid/graphics/Typeface;
    move-result-object v12
    invoke-virtual v11, v12, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    check-cast v11, Landroid/view/View;
    new-instance v12, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v12, v8, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v12, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v11, v12, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v6, Landroid/view/View;
    new-instance v11, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v11, v7, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v6, v11, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v6, Landroid/widget/LinearLayout;
    invoke-direct v6, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v6, v5, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v11, 8
    int-to-float v11, v11
    mul-float/2addr v11, v1
    float-to-int v11, v11
    invoke-virtual v6, v11, v11, v11, v11, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v12, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v12, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v14, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v0, v14, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v14
    invoke-virtual v12, v14, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v14, 10
    int-to-float v14, v14
    mul-float/2addr v14, v1
    invoke-virtual v12, v14, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    check-cast v12, Landroid/graphics/drawable/Drawable;
    invoke-virtual v6, v12, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    move v12, v9
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v14
    if-eqz v14, +0f1h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v14
    add-int/lit8 v15, v12, 1
    if-gez v12, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v14, Ljava/lang/String;
    if-lez v12, +011h
    new-instance v12, Landroid/view/View;
    invoke-direct v12, v0, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v8, v7, v11, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v12, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v8, Landroid/widget/LinearLayout;
    invoke-direct v8, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v8, v9, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v8, v10, Landroid/widget/LinearLayout;->setGravity(I)V
    int-to-float v12, v10
    mul-float/2addr v12, v1
    float-to-int v12, v12
    new-instance v10, Landroid/widget/ImageView;
    invoke-direct v10, v0, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget-object v7, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/FileIconHelper;
    invoke-virtual v7, v14, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->getFileIconRes(Ljava/lang/String;)I
    move-result v7
    invoke-virtual v10, v7, Landroid/widget/ImageView;->setImageResource(I)V
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v12, v12, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v12, 6
    int-to-float v12, v12
    mul-float/2addr v12, v1
    float-to-int v12, v12
    invoke-virtual v7, v12, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v7, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v10, Landroid/view/View;
    invoke-virtual v8, v10, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    const/16 v7, 47
    invoke-static v14, v7, v4, v13, v4, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    const-string v4, ""
    invoke-static v14, v7, v4, Lkotlin/text/StringsKt;->substringBeforeLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    new-instance v7, Landroid/widget/TextView;
    invoke-direct v7, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v10, Ljava/lang/CharSequence;
    invoke-virtual v7, v10, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v10, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v0, v10, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v10
    invoke-virtual v7, v10, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v10, 1097859072
    invoke-virtual v7, v13, v10, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v7, v5, Landroid/widget/TextView;->setMaxLines(I)V
    check-cast v7, Landroid/view/View;
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v14, -2
    invoke-direct v10, v14, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v7, v10, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-lez v7, +004h
    move v7, v5
    goto +2h
    move v7, v9
    if-eqz v7, +02eh
    new-instance v7, Landroid/widget/TextView;
    invoke-direct v7, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v7, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v0, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-virtual v7, v4, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v4, 1095761920
    invoke-virtual v7, v13, v4, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v7, v5, Landroid/widget/TextView;->setMaxLines(I)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v10, -2
    invoke-direct v4, v10, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v4, v12, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v4, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v7, Landroid/view/View;
    invoke-virtual v8, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    const/16 v4, 24
    int-to-float v4, v4
    mul-float/2addr v4, v1
    float-to-int v4, v4
    new-instance v7, Landroid/widget/HorizontalScrollView;
    invoke-direct v7, v0, Landroid/widget/HorizontalScrollView;-><init>(Landroid/content/Context;)V
    invoke-virtual v7, v9, Landroid/widget/HorizontalScrollView;->setHorizontalScrollBarEnabled(Z)V
    invoke-virtual v7, v13, Landroid/widget/HorizontalScrollView;->setOverScrollMode(I)V
    check-cast v8, Landroid/view/View;
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v12, -2
    invoke-direct v10, v12, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v8, v10, Landroid/widget/HorizontalScrollView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v7, Landroid/view/View;
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v10, -1
    invoke-direct v8, v10, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v7, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    move v7, v10
    move v8, v12
    move v12, v15
    const/4 v4, 0
    const/16 v10, 16
    goto/16 -0f3h
    move v10, v7
    move v12, v8
    check-cast v6, Landroid/view/View;
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v0, v10, v12, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v3, 16
    int-to-float v3, v3
    mul-float/2addr v3, v1
    float-to-int v1, v3
    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v6, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
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
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getContentTopMarginDp(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
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
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_checkpoint_btn_danger I
    return v0
.end method

.method public getPrimaryButtonText(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_delete I
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
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_deny I
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
    const-string/jumbo v2, toolCallInfo
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, ""
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
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->setFileClickListener(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Lkotlin/jvm/functions/Function1;)V
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
