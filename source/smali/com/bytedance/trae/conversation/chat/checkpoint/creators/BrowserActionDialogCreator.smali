# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator;
.super Ljava/lang/Object;
.source "BrowserActionDialogCreator.kt"

.implements Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;

.field private btnConfirm:Landroid/widget/TextView;
.field private btnSkip:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$S-aWxxPxJJt_PkbK2l7ItCD_x0A(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator;->bindActions$lambda$9(Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$gDdgO_l7TW4t8tNsBcwf4XKERoE(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator;->bindActions$lambda$8(Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final bindActions$lambda$8(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final bindActions$lambda$9(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final createActionButton(android.content.Context  float  java.lang.String)android.widget.TextView
    .registers 6
    # ins_size=4
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v3, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v0, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v3, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v0, v5, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v5, 2
    const/high16 v1, 1097859072
    invoke-virtual v0, v5, v1, Landroid/widget/TextView;->setTextSize(I F)V
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->defaultSemibold()Landroid/graphics/Typeface;
    move-result-object v5
    invoke-virtual v0, v5, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    const/16 v5, 12
    int-to-float v5, v5
    mul-float/2addr v5, v4
    float-to-int v5, v5
    const/16 v1, 16
    int-to-float v1, v1
    mul-float/2addr v1, v4
    float-to-int v1, v1
    invoke-virtual v0, v5, v1, v5, v1, Landroid/widget/TextView;->setPadding(I I I I)V
    new-instance v5, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v5, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v3, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v5, v3, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v3, 10
    int-to-float v3, v3
    mul-float/2addr v3, v4
    invoke-virtual v5, v3, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    check-cast v5, Landroid/graphics/drawable/Drawable;
    invoke-virtual v0, v5, Landroid/widget/TextView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    return-object v0
.end method

.method public bindActions(android.view.View  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 5
    # ins_size=4
    const-string v0, "contentView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "onConfirm"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "onSkip"
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator;->btnConfirm Landroid/widget/TextView;
    if-eqz v2, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v2, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator;->btnSkip Landroid/widget/TextView;
    if-eqz v2, +00ah
    new-instance v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator$$ExternalSyntheticLambda1;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v2, v3, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public bindActions(android.view.View  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->bindActions(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Landroid/view/View; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public createContentView(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ConfirmInfo)android.view.View
    .registers 12
    # ins_size=4
    const-string v11, "context"
    invoke-static v9, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v11, toolCallInfo
    invoke-static v10, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator;->getCHECK_POINT_TAG()Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[BrowserActionDialogCreator] createContentView: toolCallInfo="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v11, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v11
    invoke-virtual v11, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v11
    iget v11, v11, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v0
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v10
    const-string v1, "browser_hand_over"
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    const-string v1, "getString(...)"
    const/4 v2, 0
    if-eqz v0, +01ah
    const-string v3, "reason"
    invoke-virtual v0, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +012h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v3, v2
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +044h
    if-eqz v0, +019h
    const-string v3, "description"
    invoke-virtual v0, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +011h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v3, v2
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v2
    if-nez v3, +028h
    if-eqz v0, +019h
    const-string/jumbo v3, url
    invoke-virtual v0, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +010h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v0, v2
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +00ch
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_browser_fallback_desc I
    invoke-virtual v9, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    move-object v3, v2
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 1
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -1
    const/4 v6, -2
    invoke-direct v4, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Landroid/widget/TextView;
    invoke-direct v4, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v4, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v9, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v4, v3, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v3, 2
    const/high16 v7, 1099431936
    invoke-virtual v4, v3, v7, Landroid/widget/TextView;->setTextSize(I F)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->defaultMedium()Landroid/graphics/Typeface;
    move-result-object v3
    invoke-virtual v4, v3, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    check-cast v4, Landroid/view/View;
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v3, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v4, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/LinearLayout;
    invoke-direct v3, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    if-eqz v10, +005h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_browser_hand_over I
    goto +3h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_browser_confirm I
    invoke-virtual v9, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v8, v9, v11, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator;->createActionButton(Landroid/content/Context; F Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v2
    iput-object v2, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator;->btnConfirm Landroid/widget/TextView;
    check-cast v2, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v4, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v2, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    if-eqz v10, +005h
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_browser_skip_hand_over I
    goto +3h
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_browser_skip I
    invoke-virtual v9, v10, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v8, v9, v11, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator;->createActionButton(Landroid/content/Context; F Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v9
    iput-object v9, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator;->btnSkip Landroid/widget/TextView;
    check-cast v9, Landroid/view/View;
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v10, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v1, 8
    int-to-float v1, v1
    mul-float/2addr v1, v11
    float-to-int v1, v1
    iput v1, v10, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v9, v10, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v3, Landroid/view/View;
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v10, 16
    int-to-float v10, v10
    mul-float/2addr v10, v11
    float-to-int v10, v10
    iput v10, v9, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    return-object v0
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
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_browser_header_label I
    invoke-virtual v2, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v0, "getString(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
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
    const-string v2, ""
    return-object v2
.end method

.method public getSecondaryButtonText(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, ""
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
    const/4 v0, 1
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
    const/4 v0, 1
    return v0
.end method
