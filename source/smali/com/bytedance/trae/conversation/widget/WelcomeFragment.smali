# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/WelcomeFragment;
.super Landroidx/fragment/app/Fragment;
.source "WelcomeFragment.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/widget/WelcomeFragment$Companion;
.field public static final TAG:Ljava/lang/String;
.field private _binding:Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;
.field private currentMode:Lcom/bytedance/trae/conversation/widget/ChatMode;
.field private final gestureDetector$delegate:Lkotlin/Lazy;
.field private onModeSwipe:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$DJ3QVNqoCxKrFz2-YHNRaZzBa2o(com.bytedance.trae.conversation.widget.WelcomeFragment)android.view.GestureDetector
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->gestureDetector_delegate$lambda$0(Lcom/bytedance/trae/conversation/widget/WelcomeFragment;)Landroid/view/GestureDetector;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$SY3Y4hgoeUxaY6jn88slzjItY64(com.bytedance.trae.conversation.widget.WelcomeFragment  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->onViewCreated$lambda$1(Lcom/bytedance/trae/conversation/widget/WelcomeFragment; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->Companion Lcom/bytedance/trae/conversation/widget/WelcomeFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/fragment/app/Fragment;-><init>()V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$$ExternalSyntheticLambda1;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/widget/WelcomeFragment;)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->gestureDetector$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public static final synthetic access$getCurrentMode$p(com.bytedance.trae.conversation.widget.WelcomeFragment)com.bytedance.trae.conversation.widget.ChatMode
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-object v0
.end method

.method private static final gestureDetector_delegate$lambda$0(com.bytedance.trae.conversation.widget.WelcomeFragment)android.view.GestureDetector
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;
    move-result-object v0
    new-instance v1, Landroid/view/GestureDetector;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$gestureDetector$2$1;
    invoke-direct v3, v0, v4, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$gestureDetector$2$1;-><init>(Landroid/view/ViewConfiguration; Lcom/bytedance/trae/conversation/widget/WelcomeFragment;)V
    check-cast v3, Landroid/view/GestureDetector$OnGestureListener;
    invoke-direct v1, v2, v3, Landroid/view/GestureDetector;-><init>(Landroid/content/Context; Landroid/view/GestureDetector$OnGestureListener;)V
    return-object v1
.end method

.method private final getBinding()com.bytedance.trae.conversation.databinding.TraeFragmentWelcomeBinding
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v0
.end method

.method private final getGestureDetector()android.view.GestureDetector
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->gestureDetector$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/view/GestureDetector;
    return-object v0
.end method

.method private final getUserName()java.lang.String
    .registers 4
    # ins_size=1
    const/4 v0, 0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +00ch
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v1
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getScreenName()Ljava/lang/String;
    move-result-object v0
    return-object v0
    :try_start_0x1
.end method

.method private static final onViewCreated$lambda$1(com.bytedance.trae.conversation.widget.WelcomeFragment  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->getGestureDetector()Landroid/view/GestureDetector;
    move-result-object v0
    invoke-virtual v0, v2, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z
    const/4 v0, 0
    return v0
.end method

.method private final updateGreetingText()void
    .registers 6
    # ins_size=1
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->getUserName()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +008h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->solo_welcome_greeting_default_name I
    invoke-virtual v5, v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v4, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->ordinal()I
    move-result v1
    aget v1, v4, v1
    if-eq v1, v3, +00eh
    const/4 v4, 2
    if-ne v1, v4, +005h
    sget v1, Lcom/bytedance/trae/conversation/R$string;->solo_welcome_greeting I
    goto +9h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    sget v1, Lcom/bytedance/trae/conversation/R$string;->solo_welcome_greeting_code I
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;->tvWelcomeTitle Landroid/widget/TextView;
    new-array v3, v3, [Ljava/lang/Object;
    aput-object v0, v3, v2
    invoke-virtual v5, v1, v3, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v4, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final getOnModeSwipe()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->onModeSwipe Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 4
    # ins_size=4
    const-string v3, "inflater"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    invoke-static v1, v2, v3, Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;->getRoot()Landroid/widget/ScrollView;
    move-result-object v1
    const-string v2, "getRoot(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method public onDestroyView()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/fragment/app/Fragment;->onDestroyView()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;->getRoot()Landroid/widget/ScrollView;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$$ExternalSyntheticLambda0;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/widget/WelcomeFragment;)V
    invoke-virtual v2, v3, Landroid/widget/ScrollView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->updateGreetingText()V
    return-void 
.end method

.method public final setMode(com.bytedance.trae.conversation.widget.ChatMode)void
    .registers 3
    # ins_size=2
    const-string v0, "mode"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;
    if-eqz v2, +005h
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->updateGreetingText()V
    return-void 
.end method

.method public final setOnModeSwipe(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->onModeSwipe Lkotlin/jvm/functions/Function1;
    return-void 
.end method
