# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "ShareLinkBottomSheet.kt"

.field private static final AUTO_DISMISS_DELAY_MS:J
.field public static final Companion:Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;
.field public static final TAG:Ljava/lang/String;
.field private artifactPath:Ljava/lang/String;
.field private final autoDismissHandler:Landroid/os/Handler;
.field private chatSessionId:Ljava/lang/String;
.field private conversationId:Ljava/lang/String;
.field private initialShareId:Ljava/lang/String;
.field private initialShareUrl:Ljava/lang/String;
.field private isLocal:Z
.field private messageId:Ljava/lang/String;
.field private onShareStateChangedListener:Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;
.field private final revertCopyStateRunnable:Ljava/lang/Runnable;
.field private shareId:Ljava/lang/String;
.field private shareSessionId:Ljava/lang/String;
.field private shareUrl:Ljava/lang/String;


.method public static synthetic $r8$lambda$5p7YEvQ6uGper3_SA22FdsMVDLk(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.widget.TextView  android.view.View  android.view.View  android.view.View  android.view.View  android.view.View)void
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->onViewCreated$lambda$4(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$L67TEij-JvxxqduMVTlC-B2rv48(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.view.View  android.view.View  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->onViewCreated$lambda$5(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$pLLWaWCHsY9qh3ek0BID33H6rB4(com.bytedance.trae.conversation.products.ShareLinkBottomSheet)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->revertCopyStateRunnable$lambda$0(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$rWwlvtXGkPD32KhldjPD7sYVMd8(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->onViewCreated$lambda$2(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$uDXjC9qtYtPVY_NQ-188CcXpfH0(android.view.View  android.view.View  android.widget.ImageView  com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.view.View  android.view.View  android.widget.TextView  android.view.View)void
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->onViewCreated$lambda$3(Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$wsJkVydS3KiGI_d4yfHQo6DcOs8(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->onCreateDialog$lambda$1(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->Companion Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    const-string v0, ""
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->chatSessionId Ljava/lang/String;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->artifactPath Ljava/lang/String;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->conversationId Ljava/lang/String;
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->autoDismissHandler Landroid/os/Handler;
    new-instance v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$$ExternalSyntheticLambda5;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->revertCopyStateRunnable Ljava/lang/Runnable;
    return-void 
.end method

.method public static final synthetic access$copyToClipboard(com.bytedance.trae.conversation.products.ShareLinkBottomSheet)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->copyToClipboard()V
    return-void 
.end method

.method public static final synthetic access$getConversationId$p(com.bytedance.trae.conversation.products.ShareLinkBottomSheet)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getShareId$p(com.bytedance.trae.conversation.products.ShareLinkBottomSheet)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$isLocal$p(com.bytedance.trae.conversation.products.ShareLinkBottomSheet)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->isLocal Z
    return v0
.end method

.method public static final synthetic access$requestLocalShareLink(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.view.View  android.view.View  android.widget.ImageView  android.widget.TextView  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->requestLocalShareLink(Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/TextView; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$requestRemoteShareLink(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.view.View  android.view.View  android.widget.ImageView  android.widget.TextView  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->requestRemoteShareLink(Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/TextView; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$setArtifactPath$p(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->artifactPath Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setChatSessionId$p(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->chatSessionId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setConversationId$p(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->conversationId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setInitialShareId$p(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->initialShareId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setInitialShareUrl$p(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->initialShareUrl Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setLocal$p(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->isLocal Z
    return-void 
.end method

.method public static final synthetic access$setMessageId$p(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->messageId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setShareId$p(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setShareSessionId$p(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareSessionId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setShareUrl$p(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareUrl Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$showSuccess(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.view.View  android.view.View  android.widget.ImageView  android.widget.TextView)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->showSuccess(Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/TextView;)V
    return-void 
.end method

.method public static final synthetic access$trackShareShow(com.bytedance.trae.conversation.products.ShareLinkBottomSheet)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->trackShareShow()V
    return-void 
.end method

.method public static final synthetic access$trackShareShowSuccess(com.bytedance.trae.conversation.products.ShareLinkBottomSheet)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->trackShareShowSuccess()V
    return-void 
.end method

.method private final copyToClipboard()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareUrl Ljava/lang/String;
    if-nez v0, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->getContext()Landroid/content/Context;
    move-result-object v1
    if-nez v1, +003h
    return-void 
    const-string v2, "clipboard"
    invoke-virtual v1, v2, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v1
    instance-of v2, v1, Landroid/content/ClipboardManager;
    if-eqz v2, +005h
    check-cast v1, Landroid/content/ClipboardManager;
    goto +2h
    const/4 v1, 0
    if-eqz v1, +010h
    const-string/jumbo v2, share_link
    check-cast v2, Ljava/lang/CharSequence;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v2, v0, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Landroid/content/ClipData;
    move-result-object v0
    invoke-virtual v1, v0, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V
    return-void 
.end method

.method private static final onCreateDialog$lambda$1(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->isAdded()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    instance-of v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    if-eqz v0, +005h
    check-cast v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    goto +2h
    const/4 v1, 0
    if-nez v1, +003h
    return-void 
    sget v0, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v1, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    const v1, 17170445
    invoke-virtual v0, v1, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v0
    const/4 v1, 3
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    return-void 
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->dismiss()V
    return-void 
.end method

.method private static final onViewCreated$lambda$3(android.view.View  android.view.View  android.widget.ImageView  com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.view.View  android.view.View  android.widget.TextView  android.view.View)void
    .registers 8
    # ins_size=8
    const/16 v7, 8
    invoke-virtual v0, v7, Landroid/view/View;->setVisibility(I)V
    const/4 v0, 0
    invoke-virtual v1, v0, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v2, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;
    move-result-object v0
    instance-of v1, v0, Landroid/graphics/drawable/Animatable;
    if-eqz v1, +005h
    check-cast v0, Landroid/graphics/drawable/Animatable;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +005h
    invoke-interface v0, Landroid/graphics/drawable/Animatable;->start()V
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v3, v4, v5, v2, v6, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->requestShareLink(Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/TextView;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.widget.TextView  android.view.View  android.view.View  android.view.View  android.view.View  android.view.View)void
    .registers 15
    # ins_size=7
    invoke-direct v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->trackShareStop()V
    iget-boolean v14, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->isLocal Z
    const/4 v0, 0
    if-nez v14, +022h
    iget-object v14, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareSessionId Ljava/lang/String;
    if-eqz v14, +01bh
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;
    invoke-direct v1, v14, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    iput-object v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareSessionId Ljava/lang/String;
    goto +20h
    iget-object v14, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareId Ljava/lang/String;
    if-eqz v14, +01bh
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;
    invoke-direct v1, v8, v14, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    iput-object v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareId Ljava/lang/String;
    iget-object v14, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->autoDismissHandler Landroid/os/Handler;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->revertCopyStateRunnable Ljava/lang/Runnable;
    invoke-virtual v14, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    iput-object v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareUrl Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->onShareStateChangedListener Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;
    if-eqz v8, +005h
    invoke-interface v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;->onShareStopped()V
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_html_artifact_share_link_desc I
    invoke-virtual v9, v8, Landroid/widget/TextView;->setText(I)V
    const/16 v8, 8
    invoke-virtual v10, v8, Landroid/view/View;->setVisibility(I)V
    const/4 v9, 0
    invoke-virtual v11, v9, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v12, v8, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v13, v9, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method private static final onViewCreated$lambda$5(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.view.View  android.view.View  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->copyToClipboard()V
    const/16 v3, 8
    invoke-virtual v1, v3, Landroid/view/View;->setVisibility(I)V
    const/4 v1, 0
    invoke-virtual v2, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->autoDismissHandler Landroid/os/Handler;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->revertCopyStateRunnable Ljava/lang/Runnable;
    invoke-virtual v1, v2, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->autoDismissHandler Landroid/os/Handler;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->revertCopyStateRunnable Ljava/lang/Runnable;
    const-wide/16 v2, 5000
    invoke-virtual v1, v0, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private final requestLocalShareLink(android.view.View  android.view.View  android.widget.ImageView  android.widget.TextView  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=6
    move-object v0, v14
    move-object/from16 v1, v19
    instance-of v2, v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;
    invoke-direct v2, v14, v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->label I
    const/4 v5, 2
    const/4 v6, 1
    if-eqz v4, +030h
    if-eq v4, v6, +011h
    if-ne v4, v5, +007h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +07ah
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v4, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$4 Ljava/lang/Object;
    check-cast v4, Landroid/widget/TextView;
    iget-object v6, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$3 Ljava/lang/Object;
    check-cast v6, Landroid/widget/ImageView;
    iget-object v7, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$2 Ljava/lang/Object;
    check-cast v7, Landroid/view/View;
    iget-object v8, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$1 Ljava/lang/Object;
    check-cast v8, Landroid/view/View;
    iget-object v9, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v12, v4
    move-object v11, v6
    move-object v10, v7
    move-object v7, v9
    move-object v9, v8
    goto +2eh
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/conversation/products/IShareLinkApi;->Companion Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;
    new-instance v4, Lcom/bytedance/trae/conversation/products/LocalShareLinkRequest;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->conversationId Ljava/lang/String;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->artifactPath Ljava/lang/String;
    invoke-direct v4, v7, v8, Lcom/bytedance/trae/conversation/products/LocalShareLinkRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$0 Ljava/lang/Object;
    move-object v7, v15
    iput-object v7, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$1 Ljava/lang/Object;
    move-object/from16 v8, v16
    iput-object v8, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$2 Ljava/lang/Object;
    move-object/from16 v9, v17
    iput-object v9, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$3 Ljava/lang/Object;
    move-object/from16 v10, v18
    iput-object v10, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$4 Ljava/lang/Object;
    iput v6, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->label I
    invoke-virtual v1, v4, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;->createLocalShareLink(Lcom/bytedance/trae/conversation/products/LocalShareLinkRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    move-object v11, v9
    move-object v12, v10
    move-object v9, v7
    move-object v10, v8
    move-object v7, v0
    move-object v8, v1
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$2;
    const/4 v13, 0
    move-object v6, v4
    invoke-direct/range v6 ... v13, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$2;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Lcom/bytedance/trae/network/response/HttpDataResult; Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/TextView; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v6, 0
    iput-object v6, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$0 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$1 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$2 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$3 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->L$4 Ljava/lang/Object;
    iput v5, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestLocalShareLink$1;->label I
    invoke-static v1, v4, v2, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final requestRemoteShareLink(android.view.View  android.view.View  android.widget.ImageView  android.widget.TextView  kotlin.coroutines.Continuation)java.lang.Object
    .registers 22
    # ins_size=6
    move-object/from16 v0, v16
    move-object/from16 v1, v21
    instance-of v2, v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->label I
    const/4 v5, 1
    const/4 v6, 2
    const/4 v7, 0
    if-eqz v4, +030h
    if-eq v4, v5, +011h
    if-ne v4, v6, +007h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +080h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v4, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$4 Ljava/lang/Object;
    check-cast v4, Landroid/widget/TextView;
    iget-object v5, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$3 Ljava/lang/Object;
    check-cast v5, Landroid/widget/ImageView;
    iget-object v8, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$2 Ljava/lang/Object;
    check-cast v8, Landroid/view/View;
    iget-object v9, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$1 Ljava/lang/Object;
    check-cast v9, Landroid/view/View;
    iget-object v10, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v14, v4
    move-object v13, v5
    move-object v12, v8
    move-object v11, v9
    move-object v9, v10
    goto +35h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/conversation/products/IShareLinkApi;->Companion Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;
    new-instance v4, Lcom/bytedance/trae/conversation/products/ShareLinkRequest;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->chatSessionId Ljava/lang/String;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->artifactPath Ljava/lang/String;
    const-string v10, "/"
    invoke-static v9, v10, v7, v6, v7, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    invoke-direct v4, v8, v9, v10, Lcom/bytedance/trae/conversation/products/ShareLinkRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$0 Ljava/lang/Object;
    move-object/from16 v8, v17
    iput-object v8, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$1 Ljava/lang/Object;
    move-object/from16 v9, v18
    iput-object v9, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$2 Ljava/lang/Object;
    move-object/from16 v10, v19
    iput-object v10, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$3 Ljava/lang/Object;
    move-object/from16 v11, v20
    iput-object v11, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$4 Ljava/lang/Object;
    iput v5, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->label I
    invoke-virtual v1, v4, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;->createShareLink(Lcom/bytedance/trae/conversation/products/ShareLinkRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    move-object v12, v9
    move-object v13, v10
    move-object v14, v11
    move-object v9, v0
    move-object v11, v8
    move-object v10, v1
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;
    const/4 v15, 0
    move-object v8, v4
    invoke-direct/range v8 ... v15, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Lcom/bytedance/trae/network/response/HttpDataResult; Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/TextView; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    iput-object v7, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$0 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$1 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$2 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$3 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->L$4 Ljava/lang/Object;
    iput v6, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$1;->label I
    invoke-static v1, v4, v2, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final requestShareLink(android.view.View  android.view.View  android.widget.ImageView  android.widget.TextView)void
    .registers 16
    # ins_size=5
    move-object v0, v11
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;
    const/4 v10, 0
    move-object v4, v0
    move-object v5, v11
    move-object v6, v12
    move-object v7, v13
    move-object v8, v14
    move-object v9, v15
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/TextView; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final revertCopyStateRunnable$lambda$0(com.bytedance.trae.conversation.products.ShareLinkBottomSheet)void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->isAdded()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->getView()Landroid/view/View;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_copy_link I
    invoke-virtual v2, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_copied I
    invoke-virtual v2, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    const/16 v1, 8
    invoke-virtual v2, v1, Landroid/view/View;->setVisibility(I)V
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method private final showSuccess(android.view.View  android.view.View  android.widget.ImageView  android.widget.TextView)void
    .registers 7
    # ins_size=5
    const/16 v0, 8
    invoke-virtual v3, v0, Landroid/view/View;->setVisibility(I)V
    const/4 v3, 0
    invoke-virtual v4, v3, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v5, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;
    move-result-object v4
    instance-of v5, v4, Landroid/graphics/drawable/Animatable;
    const/4 v1, 0
    if-eqz v5, +005h
    check-cast v4, Landroid/graphics/drawable/Animatable;
    goto +2h
    move-object v4, v1
    if-eqz v4, +005h
    invoke-interface v4, Landroid/graphics/drawable/Animatable;->stop()V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareUrl Ljava/lang/String;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v6, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->getView()Landroid/view/View;
    move-result-object v4
    if-eqz v4, +011h
    sget v5, Lcom/bytedance/trae/conversation/R$id;->share_link_desc I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/TextView;
    if-eqz v4, +007h
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_html_artifact_share_link_desc_shared I
    invoke-virtual v4, v5, Landroid/widget/TextView;->setText(I)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->getView()Landroid/view/View;
    move-result-object v4
    if-eqz v4, +009h
    sget v5, Lcom/bytedance/trae/conversation/R$id;->btn_copy_link I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    goto +2h
    move-object v4, v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->getView()Landroid/view/View;
    move-result-object v5
    if-eqz v5, +008h
    sget v6, Lcom/bytedance/trae/conversation/R$id;->btn_copied I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    if-eqz v4, +005h
    invoke-virtual v4, v0, Landroid/view/View;->setVisibility(I)V
    if-eqz v1, +005h
    invoke-virtual v1, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->autoDismissHandler Landroid/os/Handler;
    iget-object v4, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->revertCopyStateRunnable Ljava/lang/Runnable;
    invoke-virtual v3, v4, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->autoDismissHandler Landroid/os/Handler;
    iget-object v4, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->revertCopyStateRunnable Ljava/lang/Runnable;
    const-wide/16 v5, 5000
    invoke-virtual v3, v4, v5, v6, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private final trackShareShow()void
    .registers 5
    # ins_size=1
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "artifact_type"
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->isLocal Z
    if-eqz v2, +005h
    const-string v2, "local"
    goto +3h
    const-string v2, "remote"
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, status
    const-string v2, "fail"
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "artifact_id"
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->messageId Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 95
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->artifactPath Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v2, "icube_artifact_html_share_show"
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x0
.end method

.method private final trackShareShowSuccess()void
    .registers 5
    # ins_size=1
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "artifact_type"
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->isLocal Z
    if-eqz v2, +005h
    const-string v2, "local"
    goto +3h
    const-string v2, "remote"
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, share_url
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareUrl Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, status
    const-string/jumbo v2, success
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->isLocal Z
    const-string/jumbo v2, share_id
    if-eqz v1, +008h
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareId Ljava/lang/String;
    invoke-virtual v0, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto +6h
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareSessionId Ljava/lang/String;
    invoke-virtual v0, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "artifact_id"
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->messageId Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 95
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->artifactPath Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v2, "icube_artifact_html_share_show"
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x0
    :try_start_0x2b
.end method

.method private final trackShareStop()void
    .registers 5
    # ins_size=1
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "artifact_type"
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->isLocal Z
    if-eqz v2, +005h
    const-string v2, "local"
    goto +3h
    const-string v2, "remote"
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, share_url
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareUrl Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->isLocal Z
    const-string/jumbo v2, share_id
    if-eqz v1, +008h
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareId Ljava/lang/String;
    invoke-virtual v0, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto +6h
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareSessionId Ljava/lang/String;
    invoke-virtual v0, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "artifact_id"
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->messageId Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 95
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->artifactPath Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v2, "icube_artifact_html_share_stop_click"
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x0
    :try_start_0x22
.end method

.method public final getOnShareStateChangedListener()com.bytedance.trae.conversation.products.ShareLinkBottomSheet$OnShareStateChangedListener
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->onShareStateChangedListener Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;
    return-object v0
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v2
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    new-instance v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$$ExternalSyntheticLambda4;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v2, Landroid/app/Dialog;
    return-object v2
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_dialog_share_link I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->autoDismissHandler Landroid/os/Handler;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->revertCopyStateRunnable Ljava/lang/Runnable;
    invoke-virtual v0, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    invoke-super v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDestroyView()V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 20
    # ins_size=3
    move-object/from16 v8, v17
    move-object/from16 v0, v18
    const-string/jumbo v1, view
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super/range v17 ... v19, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->btn_generate_container I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v9
    sget v2, Lcom/bytedance/trae/conversation/R$id;->btn_generate_link I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v10
    sget v2, Lcom/bytedance/trae/conversation/R$id;->ll_generating I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v11
    sget v2, Lcom/bytedance/trae/conversation/R$id;->success_container I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    sget v2, Lcom/bytedance/trae/conversation/R$id;->iv_loading I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_share_url I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->btn_stop_sharing I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v13
    sget v2, Lcom/bytedance/trae/conversation/R$id;->btn_copy_link I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v14
    sget v2, Lcom/bytedance/trae/conversation/R$id;->btn_copied I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v15
    sget v2, Lcom/bytedance/trae/conversation/R$id;->share_link_desc I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    move-object v6, v0
    check-cast v6, Landroid/widget/TextView;
    new-instance v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->initialShareUrl Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    const/4 v0, 1
    if-nez v0, +03eh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_html_artifact_share_link_desc_shared I
    invoke-virtual v6, v0, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->initialShareUrl Ljava/lang/String;
    iput-object v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareUrl Ljava/lang/String;
    iget-boolean v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->isLocal Z
    if-eqz v0, +007h
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->initialShareId Ljava/lang/String;
    iput-object v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareId Ljava/lang/String;
    goto +5h
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->initialShareId Ljava/lang/String;
    iput-object v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareSessionId Ljava/lang/String;
    const/16 v0, 8
    invoke-virtual v9, v0, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v11, v0, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v3, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;
    move-result-object v0
    instance-of v2, v0, Landroid/graphics/drawable/Animatable;
    if-eqz v2, +005h
    check-cast v0, Landroid/graphics/drawable/Animatable;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +005h
    invoke-interface v0, Landroid/graphics/drawable/Animatable;->stop()V
    invoke-virtual v12, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->shareUrl Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v7, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->trackShareShowSuccess()V
    new-instance v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$$ExternalSyntheticLambda1;
    move-object v0, v5
    move-object v1, v10
    move-object v2, v11
    move-object/from16 v4, v17
    move-object v8, v5
    move-object v5, v9
    move-object/from16 v16, v6
    move-object v6, v12
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$$ExternalSyntheticLambda1;-><init>(Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView;)V
    invoke-virtual v10, v8, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v7, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$$ExternalSyntheticLambda2;
    move-object v0, v7
    move-object/from16 v1, v17
    move-object/from16 v2, v16
    move-object v3, v12
    move-object v4, v9
    move-object v5, v11
    move-object v6, v10
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    invoke-virtual v13, v7, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$$ExternalSyntheticLambda3;
    invoke-direct v0, v1, v14, v15, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Landroid/view/View; Landroid/view/View;)V
    invoke-virtual v14, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public final setOnShareStateChangedListener(com.bytedance.trae.conversation.products.ShareLinkBottomSheet$OnShareStateChangedListener)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->onShareStateChangedListener Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;
    return-void 
.end method
