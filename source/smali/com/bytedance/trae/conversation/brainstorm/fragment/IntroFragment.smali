# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;
.super Landroidx/fragment/app/Fragment;
.source "IntroFragment.kt"

.field private introWaveform:Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;
.field private sphereController:Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
.field private viewModel:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;


.method public static synthetic $r8$lambda$98KS8k8hnhFiFPh82PPOYU9ZZnU(android.view.View  com.bytedance.trae.conversation.brainstorm.fragment.IntroFragment  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->setupStartButton$lambda$2(Landroid/view/View; Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$9IXXLIlNjATy81WI7sxKXPorJ8g(com.bytedance.trae.conversation.brainstorm.fragment.IntroFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->setupTopBar$lambda$0(Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$HdgJ4gbHgbbs5L4aw1XMABnznZc(android.view.View  androidx.core.view.WindowInsetsCompat)androidx.core.view.WindowInsetsCompat
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->setupWindowInsets$lambda$1(Landroid/view/View; Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/Fragment;-><init>()V
    return-void 
.end method

.method private final setupSphereWebView(android.view.View)void
    .registers 5
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->webview_sphere I
    invoke-virtual v4, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    const-string v1, "findViewById(...)"
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/webkit/WebView;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;-><init>(Landroid/webkit/WebView;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->init()V
    const/4 v4, 1
    const/4 v1, 0
    const/4 v2, 0
    invoke-static v0, v2, v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->intro$default(Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController; I I Ljava/lang/Object;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->sphereController Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    return-void 
.end method

.method private final setupStartButton(android.view.View)void
    .registers 4
    # ins_size=2
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_start I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment$$ExternalSyntheticLambda0;-><init>(Landroid/view/View; Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupStartButton$lambda$2(android.view.View  com.bytedance.trae.conversation.brainstorm.fragment.IntroFragment  android.view.View)void
    .registers 10
    # ins_size=3
    const-string v9, "null cannot be cast to non-null type android.view.ViewGroup"
    invoke-static v7, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Landroid/view/ViewGroup;
    sget-object v9, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->INTRO_START_CLICK Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    invoke-virtual v9, v7, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;->checkAndToast(Landroid/view/ViewGroup; Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;)Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    move-result-object v7
    const-string/jumbo v9, viewModel
    const/4 v0, 0
    if-nez v7, +00fh
    iget-object v7, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v7, +006h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v7
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startBrainstorm()V
    goto +4ch
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$MicPermissionDenied;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$MicPermissionDenied;
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +026h
    iget-object v7, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v7, +007h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    goto +2h
    move-object v1, v7
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptSignal$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I I Ljava/lang/Object;)Z
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v7
    instance-of v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    if-eqz v8, +005h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    if-eqz v0, +025h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->requestVoicePermissions()V
    goto +20h
    iget-object v8, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v8, +007h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    goto +2h
    move-object v1, v8
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->HEALTH_CHECK_BLOCKED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    invoke-virtual v7, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v3
    const-string v7, "getSimpleName(...)"
    invoke-static v3, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptSignal$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I I Ljava/lang/Object;)Z
    return-void 
.end method

.method private final setupTitle(android.view.View)void
    .registers 9
    # ins_size=2
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-virtual v8, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    check-cast v8, Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_intro_title I
    invoke-virtual v7, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v1, 63
    invoke-static v0, v1, Landroid/text/Html;->fromHtml(Ljava/lang/String; I)Landroid/text/Spanned;
    move-result-object v0
    new-instance v1, Landroid/text/SpannableString;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-direct v1, v0, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;
    move-result-object v0
    const-string v2, "fonts/feature_deck_regular_italic.ttf"
    invoke-static v0, v2, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager; Ljava/lang/String;)Landroid/graphics/Typeface;
    move-result-object v0
    invoke-virtual v1, Landroid/text/SpannableString;->length()I
    move-result v2
    const-class v3, Landroid/text/style/StyleSpan;
    const/4 v4, 0
    invoke-virtual v1, v4, v2, v3, Landroid/text/SpannableString;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v2
    check-cast v2, [Landroid/text/style/StyleSpan;
    invoke-static v2, Lkotlin/jvm/internal/ArrayIteratorKt;->iterator([Ljava/lang/Object;)Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +02ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Landroid/text/style/StyleSpan;
    invoke-virtual v3, Landroid/text/style/StyleSpan;->getStyle()I
    move-result v4
    const/4 v5, 2
    if-ne v4, v5, -011h
    invoke-virtual v1, v3, Landroid/text/SpannableString;->getSpanStart(Ljava/lang/Object;)I
    move-result v4
    invoke-virtual v1, v3, Landroid/text/SpannableString;->getSpanEnd(Ljava/lang/Object;)I
    move-result v5
    invoke-virtual v1, v3, Landroid/text/SpannableString;->getSpanFlags(Ljava/lang/Object;)I
    move-result v6
    invoke-virtual v1, v3, Landroid/text/SpannableString;->removeSpan(Ljava/lang/Object;)V
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/CustomTypefaceSpan;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/CustomTypefaceSpan;-><init>(Landroid/graphics/Typeface;)V
    invoke-virtual v1, v3, v4, v5, v6, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object; I I I)V
    goto -2dh
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v8, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method private final setupTopBar(android.view.View)void
    .registers 3
    # ins_size=2
    sget v0, Lcom/bytedance/trae/conversation/R$id;->top_bar I
    invoke-virtual v2, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;->INTRO Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->setMode(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment$$ExternalSyntheticLambda1;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->setOnBackClick(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final setupTopBar$lambda$0(com.bytedance.trae.conversation.brainstorm.fragment.IntroFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->finish()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final setupWindowInsets(android.view.View)void
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment$$ExternalSyntheticLambda2;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment$$ExternalSyntheticLambda2;-><init>()V
    invoke-static v2, v0, Landroidx/core/view/ViewCompat;->setOnApplyWindowInsetsListener(Landroid/view/View; Landroidx/core/view/OnApplyWindowInsetsListener;)V
    return-void 
.end method

.method private static final setupWindowInsets$lambda$1(android.view.View  androidx.core.view.WindowInsetsCompat)androidx.core.view.WindowInsetsCompat
    .registers 6
    # ins_size=2
    const-string/jumbo v0, v
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "insets"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Landroidx/core/view/WindowInsetsCompat$Type;->systemBars()I
    move-result v0
    invoke-virtual v5, v0, Landroidx/core/view/WindowInsetsCompat;->getInsets(I)Landroidx/core/graphics/Insets;
    move-result-object v0
    const-string v1, "getInsets(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget v1, v0, Landroidx/core/graphics/Insets;->top I
    iget v0, v0, Landroidx/core/graphics/Insets;->bottom I
    invoke-virtual v4, Landroid/view/View;->getPaddingLeft()I
    move-result v2
    invoke-virtual v4, Landroid/view/View;->getPaddingRight()I
    move-result v3
    invoke-virtual v4, v2, v1, v3, v0, Landroid/view/View;->setPadding(I I I I)V
    return-object v5
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_fragment_brainstorm_intro I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 3
    # ins_size=1
    invoke-super v2, Landroidx/fragment/app/Fragment;->onDestroyView()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->introWaveform Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->stopAnimating()V
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->introWaveform Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->sphereController Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    if-eqz v1, +005h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->destroy()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->sphereController Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v2, v3, v4, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    new-instance v4, Landroidx/lifecycle/ViewModelProvider;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const-string/jumbo v1, requireActivity(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v4, v0, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-virtual v4, v0, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->setupTopBar(Landroid/view/View;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->setupWindowInsets(Landroid/view/View;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->setupTitle(Landroid/view/View;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->setupStartButton(Landroid/view/View;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;->setupSphereWebView(Landroid/view/View;)V
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;
    check-cast v3, Landroid/view/ViewGroup;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->INTRO_ENTERED Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    invoke-virtual v4, v3, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;->checkAndToast(Landroid/view/ViewGroup; Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;)Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    return-void 
.end method
