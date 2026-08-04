# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer;
.super Ljava/lang/Object;
.source "ReferencesRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field public static final BLOCK_TAG:Ljava/lang/String;
.field private static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer$Companion;


.method public static synthetic $r8$lambda$3AqNWKS2yU4qZ2PQkdZtGvlXfGI(android.widget.LinearLayout  android.widget.TextView  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer;->render$lambda$9(Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final createRefItem(android.content.Context  java.lang.String  java.lang.String  float)android.view.View
    .registers 9
    # ins_size=5
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v5, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    const/4 v2, 2
    int-to-float v3, v2
    mul-float/2addr v3, v8
    float-to-int v3, v3
    invoke-virtual v0, v1, v3, v1, v3, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v5, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v1, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v6, 1094713344
    invoke-virtual v1, v2, v6, Landroid/widget/TextView;->setTextSize(I F)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v5, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v1, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v5, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v1, v5, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v1, v2, v6, Landroid/widget/TextView;->setTextSize(I F)V
    const/4 v5, 1
    invoke-virtual v1, v5, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v5, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v1, v5, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    check-cast v1, Landroid/view/View;
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v6, -2
    invoke-direct v5, v6, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v6, 4
    int-to-float v6, v6
    mul-float/2addr v6, v8
    float-to-int v6, v6
    invoke-virtual v5, v6, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private static final render$lambda$9(android.widget.LinearLayout  android.widget.TextView  android.view.View)void
    .registers 5
    # ins_size=3
    invoke-virtual v2, Landroid/widget/LinearLayout;->getVisibility()I
    move-result v4
    const/4 v0, 0
    const/16 v1, 8
    if-ne v4, v1, +00bh
    invoke-virtual v2, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->chevron_fold I
    invoke-virtual v3, v0, v0, v2, v0, Landroid/widget/TextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(I I I I)V
    goto +9h
    invoke-virtual v2, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->chevron_unfold I
    invoke-virtual v3, v0, v0, v2, v0, Landroid/widget/TextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(I I I I)V
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$References)android.view.View
    .registers 27
    # ins_size=3
    move-object/from16 v0, v24
    move-object/from16 v1, v25
    const-string v2, "context"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "block"
    move-object/from16 v3, v26
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->getCodeReferences()Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->getSearchReferences()Lcom/bytedance/trae/im/model/SearchReferenceData;
    move-result-object v4
    const/4 v5, 0
    if-eqz v4, +00dh
    invoke-virtual v4, Lcom/bytedance/trae/im/model/SearchReferenceData;->getReferences()Ljava/util/List;
    move-result-object v4
    if-eqz v4, +007h
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    goto +2h
    move v4, v5
    add-int/2addr v2, v4
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->getDocReferences()Lcom/bytedance/trae/im/model/DocReferencesData;
    move-result-object v4
    if-eqz v4, +00dh
    invoke-virtual v4, Lcom/bytedance/trae/im/model/DocReferencesData;->getDocuments()Ljava/util/List;
    move-result-object v4
    if-eqz v4, +007h
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    goto +2h
    move v4, v5
    add-int/2addr v2, v4
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "[ReferencesRenderer] render: references="
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v6, "AgentBlock"
    invoke-virtual v4, v6, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v25, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->density F
    new-instance v4, Landroid/widget/LinearLayout;
    invoke-direct v4, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v6, 1
    invoke-virtual v4, v6, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v8, -1
    const/4 v9, -2
    invoke-direct v7, v8, v9, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v8, 4
    int-to-float v8, v8
    mul-float/2addr v8, v2
    float-to-int v8, v8
    iput v8, v7, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    iput v8, v7, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v7, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->getCodeReferences()Ljava/util/List;
    move-result-object v7
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v7
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->getSearchReferences()Lcom/bytedance/trae/im/model/SearchReferenceData;
    move-result-object v10
    if-eqz v10, +00dh
    invoke-virtual v10, Lcom/bytedance/trae/im/model/SearchReferenceData;->getReferences()Ljava/util/List;
    move-result-object v10
    if-eqz v10, +007h
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v10
    goto +2h
    move v10, v5
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->getDocReferences()Lcom/bytedance/trae/im/model/DocReferencesData;
    move-result-object v11
    if-eqz v11, +00dh
    invoke-virtual v11, Lcom/bytedance/trae/im/model/DocReferencesData;->getDocuments()Ljava/util/List;
    move-result-object v11
    if-eqz v11, +007h
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v11
    goto +2h
    move v11, v5
    add-int v12, v7, v10
    add-int/2addr v12, v11
    new-instance v13, Ljava/util/ArrayList;
    invoke-direct v13, Ljava/util/ArrayList;-><init>()V
    check-cast v13, Ljava/util/List;
    const-string v14, "getString(...)"
    if-lez v10, +00eh
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_chat_ref_searched_web I
    invoke-virtual v1, v10, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v13, v10, Ljava/util/List;->add(Ljava/lang/Object;)Z
    if-lez v7, +016h
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_chat_ref_read_files I
    new-array v15, v6, [Ljava/lang/Object;
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    aput-object v7, v15, v5
    invoke-virtual v1, v10, v15, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v13, v7, Ljava/util/List;->add(Ljava/lang/Object;)Z
    if-lez v11, +016h
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_chat_ref_docs I
    new-array v10, v6, [Ljava/lang/Object;
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    aput-object v11, v10, v5
    invoke-virtual v1, v7, v10, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v13, v7, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-interface v13, Ljava/util/List;->isEmpty()Z
    move-result v7
    if-eqz v7, +011h
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_chat_ref_count I
    new-array v10, v6, [Ljava/lang/Object;
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    aput-object v11, v10, v5
    invoke-virtual v1, v7, v10, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    goto +1ch
    move-object v15, v13
    check-cast v15, Ljava/lang/Iterable;
    const-string v7, ", "
    move-object/from16 v16, v7
    check-cast v16, Ljava/lang/CharSequence;
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 62
    const/16 v23, 0
    invoke-static/range v15 ... v23, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    new-instance v10, Landroid/widget/LinearLayout;
    invoke-direct v10, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v10, v5, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v11, 16
    invoke-virtual v10, v11, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v11, 8
    int-to-float v12, v11
    mul-float/2addr v12, v2
    float-to-int v12, v12
    const/4 v13, 6
    int-to-float v13, v13
    mul-float/2addr v13, v2
    float-to-int v15, v13
    invoke-virtual v10, v12, v15, v12, v15, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v15, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v15, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v11, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v1, v11, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v11
    invoke-virtual v15, v11, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    invoke-virtual v15, v13, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    check-cast v15, Landroid/graphics/drawable/Drawable;
    invoke-virtual v10, v15, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    move-object v11, v10
    check-cast v11, Landroid/view/View;
    invoke-virtual v4, v11, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v11, Landroid/widget/TextView;
    invoke-direct v11, v1, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v11, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v1, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    invoke-virtual v11, v7, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v7, 1095761920
    const/4 v13, 2
    invoke-virtual v11, v13, v7, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v11, v8, Landroid/widget/TextView;->setCompoundDrawablePadding(I)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->chevron_unfold I
    invoke-virtual v11, v5, v5, v7, v5, Landroid/widget/TextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(I I I I)V
    move-object v7, v11
    check-cast v7, Landroid/view/View;
    new-instance v15, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v13, 1065353216
    invoke-direct v15, v5, v9, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v15, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v7, v15, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v7, Landroid/widget/LinearLayout;
    invoke-direct v7, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v7, v6, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v6, 8
    invoke-virtual v7, v6, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-virtual v7, v12, v8, v12, v5, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    move-object v5, v7
    check-cast v5, Landroid/view/View;
    invoke-virtual v4, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->getCodeReferences()Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +037h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/model/Reference;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/Reference;->getFileName()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +01fh
    invoke-virtual v6, Lcom/bytedance/trae/im/model/Reference;->getUri()Ljava/lang/String;
    move-result-object v6
    const/4 v8, 0
    if-eqz v6, +00bh
    const/16 v9, 47
    const/4 v12, 2
    invoke-static v6, v9, v8, v12, v8, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    move-object v8, v6
    goto +2h
    const/4 v12, 2
    if-nez v8, +00dh
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_ref_file I
    invoke-virtual v1, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    const/4 v12, 2
    const-string/jumbo v6, 📄
    invoke-direct v0, v1, v6, v8, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer;->createRefItem(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; F)Landroid/view/View;
    move-result-object v6
    invoke-virtual v7, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -3ah
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->getSearchReferences()Lcom/bytedance/trae/im/model/SearchReferenceData;
    move-result-object v5
    if-eqz v5, +03ah
    invoke-virtual v5, Lcom/bytedance/trae/im/model/SearchReferenceData;->getReferences()Ljava/util/List;
    move-result-object v5
    if-eqz v5, +034h
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +028h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/model/SearchReference;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/SearchReference;->getTitle()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +011h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/SearchReference;->getLink()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +00bh
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_ref_web_result I
    invoke-virtual v1, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v6, 🌐
    invoke-direct v0, v1, v6, v8, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer;->createRefItem(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; F)Landroid/view/View;
    move-result-object v6
    invoke-virtual v7, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -2bh
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->getDocReferences()Lcom/bytedance/trae/im/model/DocReferencesData;
    move-result-object v3
    if-eqz v3, +03ah
    invoke-virtual v3, Lcom/bytedance/trae/im/model/DocReferencesData;->getDocuments()Ljava/util/List;
    move-result-object v3
    if-eqz v3, +034h
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +028h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/model/DocReference;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/DocReference;->getTitle()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +011h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/DocReference;->getLink()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +00bh
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_chat_ref_document I
    invoke-virtual v1, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v5, 📑
    invoke-direct v0, v1, v5, v6, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer;->createRefItem(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; F)Landroid/view/View;
    move-result-object v5
    invoke-virtual v7, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -2bh
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer$$ExternalSyntheticLambda0;
    invoke-direct v1, v7, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer$$ExternalSyntheticLambda0;-><init>(Landroid/widget/LinearLayout; Landroid/widget/TextView;)V
    invoke-virtual v10, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v4, Landroid/view/View;
    return-object v4
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$References)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer$DefaultImpls;->update(Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;)V
    return-void 
.end method
