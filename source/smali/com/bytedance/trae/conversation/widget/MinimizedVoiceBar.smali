# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
.super Landroidx/constraintlayout/widget/ConstraintLayout;
.source "MinimizedVoiceBar.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$Companion;
.field private static final MAX_CLIP_PARENT_DEPTH:I
.field private final btnMaximize:Landroid/widget/ImageView;
.field private collectJobs:Ljava/util/List;
.field private onMaximizeClick:Lkotlin/jvm/functions/Function0;
.field private final tvTimer:Landroid/widget/TextView;
.field private final tvTitle:Landroid/widget/TextView;
.field private final waveIcon:Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;


.method public static synthetic $r8$lambda$QF0kucmKjY5HAAPMpxgbWAdRwKg(com.bytedance.trae.conversation.widget.MinimizedVoiceBar  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->_init_$lambda$1(Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$eKYUV6ncc3abEZK6ThAHc_KUT4g(com.bytedance.trae.conversation.widget.MinimizedVoiceBar  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->_init_$lambda$0(Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->Companion Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$Companion;
    return-void 
.end method

.method public constructor <init>(android.content.Context)void
    .registers 9
    # ins_size=2
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet)void
    .registers 10
    # ins_size=3
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 9
    # ins_size=4
    const-string v0, "context"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, v6, v7, v8, Landroidx/constraintlayout/widget/ConstraintLayout;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/List;
    iput-object v7, v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->collectJobs Ljava/util/List;
    invoke-static v6, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v7
    sget v8, Lcom/bytedance/trae/conversation/R$layout;->trae_view_minimized_voice_bar I
    move-object v0, v5
    check-cast v0, Landroid/view/ViewGroup;
    const/4 v1, 1
    invoke-virtual v7, v8, v0, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_minimized_voice_bar I
    invoke-static v6, v7, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v7
    invoke-virtual v5, v7, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v7
    if-nez v7, +014h
    new-instance v7, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v0, Lcom/bytedance/trae/conversation/R$dimen;->trae_minimized_voice_bar_height I
    invoke-virtual v8, v0, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    const/4 v0, -1
    invoke-direct v7, v0, v8, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v7, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->getResources()Landroid/content/res/Resources;
    move-result-object v7
    sget v8, Lcom/bytedance/trae/conversation/R$dimen;->trae_minimized_voice_bar_height I
    invoke-virtual v7, v8, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v7
    invoke-virtual v5, v7, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setMinHeight(I)V
    sget v7, Lcom/bytedance/trae/conversation/R$id;->iv_chat_icon I
    invoke-virtual v5, v7, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->findViewById(I)Landroid/view/View;
    move-result-object v7
    const-string v8, "findViewById(...)"
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    iput-object v7, v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->waveIcon Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-virtual v5, v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->tvTitle Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_timer I
    invoke-virtual v5, v2, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/TextView;
    iput-object v2, v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->tvTimer Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->btn_maximize I
    invoke-virtual v5, v3, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/ImageView;
    iput-object v3, v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->btnMaximize Landroid/widget/ImageView;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_body_body_base_strong_line_height_dp I
    invoke-virtual v8, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    invoke-static v0, v8, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v0, Lcom/bytedance/trae/common_ui/R$dimen;->trae_footnote_footnote_line_height_dp I
    invoke-virtual v8, v0, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    invoke-static v2, v8, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_default I
    invoke-static v6, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->setWaveColor(I)V
    sget-object v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$State;->Slow Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$State;
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->setState(Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$State;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->updateWaveAnimationForMicState()V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->getResources()Landroid/content/res/Resources;
    move-result-object v7
    sget v8, Lcom/bytedance/trae/conversation/R$dimen;->trae_minimized_voice_bar_corner_radius I
    invoke-virtual v7, v8, Landroid/content/res/Resources;->getDimension(I)F
    move-result v7
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v0, Lcom/bytedance/trae/conversation/R$dimen;->trae_minimized_voice_bar_elevation I
    invoke-virtual v8, v0, Landroid/content/res/Resources;->getDimension(I)F
    move-result v8
    invoke-virtual v5, v8, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setElevation(F)V
    sget v8, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v0, 28
    if-lt v8, v0, +014h
    sget v8, Lcom/bytedance/trae/conversation/R$color;->trae_minimized_voice_shadow_ambient I
    invoke-static v6, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v5, v8, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setOutlineAmbientShadowColor(I)V
    sget v8, Lcom/bytedance/trae/conversation/R$color;->trae_minimized_voice_shadow_spot I
    invoke-static v6, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setOutlineSpotShadowColor(I)V
    new-instance v6, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$1;
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$1;-><init>(F)V
    check-cast v6, Landroid/view/ViewOutlineProvider;
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    invoke-virtual v5, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setClipToOutline(Z)V
    invoke-virtual v5, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setClipChildren(Z)V
    invoke-virtual v5, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setClipToPadding(Z)V
    new-instance v6, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$$ExternalSyntheticLambda0;
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;)V
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v6, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$$ExternalSyntheticLambda1;
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;)V
    invoke-virtual v3, v6, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  android.util.AttributeSet  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, 0
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private static final _init_$lambda$0(com.bytedance.trae.conversation.widget.MinimizedVoiceBar  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->onMaximizeClick Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final _init_$lambda$1(com.bytedance.trae.conversation.widget.MinimizedVoiceBar  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->onMaximizeClick Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public static final synthetic access$formatTimer(com.bytedance.trae.conversation.widget.MinimizedVoiceBar  long)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->formatTimer(J)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getTvTimer$p(com.bytedance.trae.conversation.widget.MinimizedVoiceBar)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->tvTimer Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getWaveIcon$p(com.bytedance.trae.conversation.widget.MinimizedVoiceBar)com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->waveIcon Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    return-object v0
.end method

.method private final formatTimer(long)java.lang.String
    .registers 6
    # ins_size=3
    const/16 v0, 1000
    int-to-long v0, v0
    div-long/2addr v4, v0
    long-to-int v4, v4
    div-int/lit8 v5, v4, 60
    rem-int/lit8 v4, v4, 60
    sget-object v0, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    const/4 v0, 2
    new-array v1, v0, [Ljava/lang/Object;
    const/4 v2, 0
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    aput-object v5, v1, v2
    const/4 v5, 1
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    aput-object v4, v1, v5
    invoke-static v1, v0, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v4
    const-string v5, "%02d:%02d"
    invoke-static v5, v4, Ljava/lang/String;->format(Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const-string v5, "format(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
.end method

.method private final updateAncestorClipPolicy()void
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    const/4 v1, 0
    move v2, v1
    instance-of v3, v0, Landroid/view/ViewGroup;
    if-eqz v3, +014h
    const/4 v3, 4
    if-ge v2, v3, +011h
    check-cast v0, Landroid/view/ViewGroup;
    invoke-virtual v0, v1, Landroid/view/ViewGroup;->setClipChildren(Z)V
    invoke-virtual v0, v1, Landroid/view/ViewGroup;->setClipToPadding(Z)V
    invoke-virtual v0, Landroid/view/ViewGroup;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    add-int/lit8 v2, v2, 1
    goto -15h
    return-void 
.end method

.method private final updateWaveAnimationForMicState()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->isMicMuted()Z
    move-result v0
    if-eqz v0, +008h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->waveIcon Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->stopAnimating()V
    goto +6h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->waveIcon Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->startAnimating()V
    return-void 
.end method

.method public final bindHolder(androidx.lifecycle.LifecycleOwner)void
    .registers 11
    # ins_size=2
    const-string v0, "lifecycleOwner"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->unbind()V
    invoke-direct v9, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->updateAncestorClipPolicy()V
    invoke-direct v9, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->updateWaveAnimationForMicState()V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->collectJobs Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-static v10, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$1;
    const/4 v8, 0
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$1;-><init>(Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    iget-object v0, v9, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->collectJobs Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-static v10, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v10
    move-object v1, v10
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    new-instance v10, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2;
    invoke-direct v10, v9, v8, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2;-><init>(Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar; Lkotlin/coroutines/Continuation;)V
    move-object v4, v10
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v10
    invoke-interface v0, v10, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final getOnMaximizeClick()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->onMaximizeClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method protected onAttachedToWindow()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroidx/constraintlayout/widget/ConstraintLayout;->onAttachedToWindow()V
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->updateAncestorClipPolicy()V
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->updateWaveAnimationForMicState()V
    return-void 
.end method

.method protected onDetachedFromWindow()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/constraintlayout/widget/ConstraintLayout;->onDetachedFromWindow()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->waveIcon Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->stopAnimating()V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->unbind()V
    return-void 
.end method

.method public final setOnMaximizeClick(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->onMaximizeClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final unbind()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->collectJobs Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlinx/coroutines/Job;
    const/4 v2, 1
    const/4 v3, 0
    invoke-static v1, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    goto -11h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->collectJobs Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->clear()V
    return-void 
.end method
