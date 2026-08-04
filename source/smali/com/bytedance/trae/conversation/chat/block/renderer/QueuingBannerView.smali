# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
.super Landroid/widget/LinearLayout;
.source "QueuingBannerView.kt"

.field private final actionView:Landroid/view/View;
.field private final backgroundDrawable:Landroid/graphics/drawable/GradientDrawable;
.field private final iconView:Landroid/widget/ImageView;
.field private isToAppLog:Z
.field private final messageView:Landroid/widget/TextView;
.field public queryItem:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
.field private final titleView:Landroid/widget/TextView;
.field private usePayLoadingView:Landroid/view/View;


.method public static synthetic $r8$lambda$GEQZ7iveK_r_vhToUDAxaraY9TM(com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->showLoading$lambda$18(Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$MGW90zOHDporFWJTVpWH-RtKXt4(com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->_init_$lambda$7(Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context)void
    .registers 10
    # ins_size=2
    const-string v0, "context"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v8, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v0, 1
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->setOrientation(I)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    const/16 v2, 16
    int-to-float v3, v2
    mul-float/2addr v3, v1
    float-to-int v3, v3
    const/16 v4, 12
    int-to-float v4, v4
    mul-float/2addr v4, v1
    float-to-int v5, v4
    invoke-virtual v8, v3, v5, v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->setPadding(I I I I)V
    new-instance v3, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v3, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-virtual v3, v4, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    int-to-float v4, v0
    mul-float/2addr v4, v1
    float-to-int v4, v4
    const/4 v5, 0
    invoke-virtual v3, v4, v5, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    iput-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->backgroundDrawable Landroid/graphics/drawable/GradientDrawable;
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v8, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v3, Landroid/widget/LinearLayout;
    invoke-direct v3, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, v5, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v3, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v2, Landroid/widget/ImageView;
    invoke-direct v2, v9, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget-object v4, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v2, v4, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    iput-object v2, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->iconView Landroid/widget/ImageView;
    const/16 v4, 20
    int-to-float v4, v4
    mul-float/2addr v4, v1
    float-to-int v4, v4
    check-cast v2, Landroid/view/View;
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v2, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    const/high16 v4, 1096810496
    const/4 v6, 2
    invoke-virtual v2, v6, v4, Landroid/widget/TextView;->setTextSize(I F)V
    sget-object v4, Landroid/graphics/Typeface;->DEFAULT Landroid/graphics/Typeface;
    invoke-static v4, v0, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface; I)Landroid/graphics/Typeface;
    move-result-object v0
    invoke-virtual v2, v0, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v9, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v2, v0, Landroid/widget/TextView;->setTextColor(I)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v4, 1065353216
    const/4 v7, -2
    invoke-direct v0, v5, v7, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v4, 4
    int-to-float v4, v4
    mul-float/2addr v4, v1
    float-to-int v4, v4
    invoke-virtual v0, v4, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v0, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iput-object v2, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->titleView Landroid/widget/TextView;
    check-cast v2, Landroid/view/View;
    invoke-virtual v3, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v3, Landroid/view/View;
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v2, -1
    invoke-direct v0, v2, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    const/high16 v3, 1095761920
    invoke-virtual v0, v6, v3, Landroid/widget/TextView;->setTextSize(I F)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v9, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    invoke-virtual v0, v9, Landroid/widget/TextView;->setTextColor(I)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v2, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v4, v9, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v9, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iput-object v0, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->messageView Landroid/widget/TextView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->addView(Landroid/view/View;)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->createActionButton()Landroid/view/View;
    move-result-object v9
    iput-object v9, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->actionView Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$$ExternalSyntheticLambda1;
    invoke-direct v0, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;)V
    invoke-virtual v9, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v0, v7, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v2, 8
    int-to-float v2, v2
    mul-float/2addr v2, v1
    float-to-int v1, v2
    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    const v1, 8388613
    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private static final _init_$lambda$7(com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->useFastRequest()V
    return-void 
.end method

.method public static final synthetic access$hideLoading(com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->hideLoading()V
    return-void 
.end method

.method private final buildDisplayText(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing)java.lang.String
    .registers 9
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;
    sget-object v1, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;->shouldUseFastRequestPresentation(Z)Z
    move-result v0
    if-nez v0, +007h
    invoke-direct v6, v7, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->buildOrdinaryQueueText(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)Ljava/lang/String;
    move-result-object v7
    return-object v7
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getFastRequestEvent()Lcom/bytedance/trae/im/service/FastRequestEvent;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00fh
    invoke-virtual v0, Lcom/bytedance/trae/im/service/FastRequestEvent;->getRefunded()Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    goto +2h
    move v0, v2
    const-string v3, "getResources(...)"
    if-eqz v0, +042h
    invoke-static Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->getUserPayIdentity()I
    move-result v7
    const/16 v0, 100
    if-ne v7, v0, +01eh
    sget-object v7, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_queue_refund_999 I
    new-array v1, v1, [Ljava/lang/Object;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getPosition()I
    move-result v8
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    aput-object v8, v1, v2
    invoke-virtual v7, v0, v3, v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    goto +1ch
    sget-object v7, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_queue_refund I
    new-array v1, v1, [Ljava/lang/Object;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getPosition()I
    move-result v8
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    aput-object v8, v1, v2
    invoke-virtual v7, v0, v3, v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    return-object v7
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getFastRequestEvent()Lcom/bytedance/trae/im/service/FastRequestEvent;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/FastRequestEvent;->getType()Ljava/lang/Integer;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    sget-object v4, Lcom/bytedance/trae/im/service/FastRequestEventType;->HasQuotaCanUse Lcom/bytedance/trae/im/service/FastRequestEventType;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/FastRequestEventType;->getValue()I
    move-result v4
    if-nez v0, +003h
    goto +23h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    if-ne v0, v4, +01eh
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_queue_canuse I
    new-array v1, v1, [Ljava/lang/Object;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getPosition()I
    move-result v5
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    aput-object v5, v1, v2
    invoke-virtual v0, v4, v3, v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    return-object v7
    invoke-direct v6, v7, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->buildOrdinaryQueueText(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)Ljava/lang/String;
    move-result-object v7
    return-object v7
    :try_start_0x6d
.end method

.method private final buildOrdinaryQueueText(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing)java.lang.String
    .registers 6
    # ins_size=3
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getMessage()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 1
    if-eqz v0, +011h
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v2, v1
    if-eqz v2, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    return-object v0
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_chat_queue_alert_body I
    new-array v1, v1, [Ljava/lang/Object;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getPosition()I
    move-result v5
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const/4 v2, 0
    aput-object v5, v1, v2
    invoke-virtual v4, v0, v1, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const-string v5, "getString(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
.end method

.method private final buildTitleText(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing)java.lang.String
    .registers 4
    # ins_size=3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getNoticeTitle()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +011h
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    goto +2h
    const/4 v3, 0
    if-nez v3, +00dh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_queue_alert_title I
    invoke-virtual v2, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v2, "getString(...)"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method private final createActionButton()android.view.View
    .registers 11
    # ins_size=1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    sget-object v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    const-string v3, "getResources(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_queue_canuse_button I
    const/4 v4, 0
    new-array v5, v4, [Ljava/lang/Object;
    invoke-virtual v1, v2, v3, v5, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-direct v2, v3, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v3, 17
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v4, 12
    int-to-float v4, v4
    mul-float/2addr v4, v0
    float-to-int v4, v4
    invoke-virtual v2, v4, v4, v4, v4, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v5, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v5, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-virtual v2, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_secondary I
    invoke-static v6, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v5, v6, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v6, 8
    int-to-float v6, v6
    mul-float/2addr v6, v0
    invoke-virtual v5, v6, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    const/4 v6, 1
    int-to-float v7, v6
    mul-float/2addr v7, v0
    float-to-int v7, v7
    invoke-virtual v2, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v8
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l2 I
    invoke-static v8, v9, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v5, v7, v8, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    check-cast v5, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v5, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v2, v6, Landroid/widget/LinearLayout;->setClickable(Z)V
    invoke-virtual v2, v6, Landroid/widget/LinearLayout;->setFocusable(Z)V
    new-instance v5, Landroid/widget/ImageView;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v7
    invoke-direct v5, v7, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_use_express_pass I
    invoke-virtual v5, v7, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v7, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v5, v7, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v5, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v5, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Landroid/widget/TextView;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v5
    invoke-direct v4, v5, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v4, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v4, v3, Landroid/widget/TextView;->setGravity(I)V
    const/4 v1, 2
    const/high16 v3, 1095761920
    invoke-virtual v4, v1, v3, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v4, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v1, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v4, v1, Landroid/widget/TextView;->setTextColor(I)V
    sget-object v1, Landroid/graphics/Typeface;->DEFAULT Landroid/graphics/Typeface;
    invoke-static v1, v6, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface; I)Landroid/graphics/Typeface;
    move-result-object v1
    invoke-virtual v4, v1, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v4, v6, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v1, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v4, v1, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -2
    invoke-direct v1, v3, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v3, 4
    int-to-float v3, v3
    mul-float/2addr v3, v0
    float-to-int v0, v3
    invoke-virtual v1, v0, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v1, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v4, Landroid/view/View;
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v2, Landroid/view/View;
    return-object v2
.end method

.method private final hideLoading()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->usePayLoadingView Landroid/view/View;
    if-nez v0, +003h
    return-void 
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v1
    instance-of v2, v1, Landroid/app/Activity;
    const/4 v3, 0
    if-eqz v2, +005h
    check-cast v1, Landroid/app/Activity;
    goto +2h
    move-object v1, v3
    if-nez v1, +003h
    return-void 
    invoke-virtual v1, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    instance-of v2, v1, Landroid/view/ViewGroup;
    if-eqz v2, +005h
    check-cast v1, Landroid/view/ViewGroup;
    goto +2h
    move-object v1, v3
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    iput-object v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->usePayLoadingView Landroid/view/View;
    return-void 
    :try_start_0x0
.end method

.method private final showLoading()void
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final showLoading$lambda$18(com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView)void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->usePayLoadingView Landroid/view/View;
    if-eqz v0, +003h
    return-void 
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v0
    instance-of v1, v0, Landroid/app/Activity;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Landroid/app/Activity;
    goto +2h
    move-object v0, v2
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v0
    invoke-virtual v0, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v0
    instance-of v1, v0, Landroid/view/ViewGroup;
    if-eqz v1, +005h
    move-object v2, v0
    check-cast v2, Landroid/view/ViewGroup;
    if-nez v2, +003h
    return-void 
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$layout;->loading_progress_bar_voice I
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v0
    invoke-virtual v2, v0, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    iput-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->usePayLoadingView Landroid/view/View;
    return-void 
    :try_start_0x0
.end method

.method private final useFastRequest()void
    .registers 14
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    if-eqz v0, +00ah
    iget-object v0, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->actionView Landroid/view/View;
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    return-void 
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getQueryItem()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getOriginMessage()Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getOriginMessage()Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContent()Ljava/lang/Object;
    move-result-object v1
    instance-of v2, v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    const/4 v4, 0
    if-eqz v2, +005h
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    goto +2h
    move-object v1, v4
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v4
    const-string v1, ""
    if-nez v4, +003h
    move-object v4, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getQueueId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getOriginMessage()Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-direct v13, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->showLoading()V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    const/4 v1, 0
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;
    const/4 v8, 0
    move-object v2, v10
    move-object v7, v13
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/jvm/functions/Function2;
    const/4 v11, 3
    const/4 v12, 0
    move-object v7, v0
    move-object v8, v1
    invoke-static/range v7 ... v12, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final getQueryItem()com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->queryItem Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    if-eqz v0, +003h
    return-object v0
    const-string v0, "queryItem"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    return-object v0
.end method

.method public final render(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing)void
    .registers 11
    # ins_size=2
    const-string v0, "query"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->setQueryItem(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_status_info_surface_l1 I
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_status_primary_surface_l2 I
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_status_info_default I
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->info_filled_blue I
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v5
    const-string v6, "getContext(...)"
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v9, v5, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->buildDisplayText(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)Ljava/lang/String;
    move-result-object v5
    iget-object v7, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->backgroundDrawable Landroid/graphics/drawable/GradientDrawable;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v8
    invoke-static v8, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v7, v1, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->backgroundDrawable Landroid/graphics/drawable/GradientDrawable;
    const/4 v7, 1
    int-to-float v8, v7
    mul-float/2addr v8, v0
    float-to-int v0, v8
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v8
    invoke-static v8, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v1, v0, v2, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->iconView Landroid/widget/ImageView;
    invoke-virtual v0, v4, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->iconView Landroid/widget/ImageView;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-static v1, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setColorFilter(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->titleView Landroid/widget/TextView;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-static v1, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v9, v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->buildTitleText(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v7
    goto +2h
    move v0, v1
    const/16 v2, 8
    if-eqz v0, +008h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->messageView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    goto +bh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->messageView Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->messageView Landroid/widget/TextView;
    invoke-virtual v0, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getFastRequestEvent()Lcom/bytedance/trae/im/service/FastRequestEvent;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/FastRequestEvent;->getType()Ljava/lang/Integer;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    sget-object v4, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v4
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;->shouldShowFastRequestAction(Ljava/lang/Integer; Z)Z
    move-result v0
    if-eqz v0, +045h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->actionView Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-boolean v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->isToAppLog Z
    if-nez v0, +041h
    iput-boolean v7, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->isToAppLog Z
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getOriginMessage()Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 95
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getRequestUUid()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    const-string/jumbo v2, unique_id
    invoke-virtual v1, v2, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v10, "im_queue_banner_occur"
    invoke-virtual v0, v10, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +6h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->actionView Landroid/view/View;
    invoke-virtual v10, v2, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method public final setQueryItem(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->queryItem Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    return-void 
.end method

.method public final updateQueue(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing)void
    .registers 6
    # ins_size=2
    const-string v0, "query"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->setQueryItem(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->titleView Landroid/widget/TextView;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v1
    const-string v2, "getContext(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->buildTitleText(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->buildDisplayText(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 0
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    move v1, v2
    const/16 v3, 8
    if-eqz v1, +008h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->messageView Landroid/widget/TextView;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setVisibility(I)V
    goto +bh
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->messageView Landroid/widget/TextView;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->messageView Landroid/widget/TextView;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getFastRequestEvent()Lcom/bytedance/trae/im/service/FastRequestEvent;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/FastRequestEvent;->getType()Ljava/lang/Integer;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    sget-object v1, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v1
    invoke-virtual v0, v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;->shouldShowFastRequestAction(Ljava/lang/Integer; Z)Z
    move-result v5
    if-eqz v5, +008h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->actionView Landroid/view/View;
    invoke-virtual v5, v2, Landroid/view/View;->setVisibility(I)V
    goto +6h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->actionView Landroid/view/View;
    invoke-virtual v5, v3, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method public final updateTitle(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, title
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->titleView Landroid/widget/TextView;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method
