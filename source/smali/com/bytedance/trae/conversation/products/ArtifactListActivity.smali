# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "ArtifactListActivity.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/products/ArtifactListActivity$Companion;
.field private static final EXTRA_CHAT_SESSION_ID:Ljava/lang/String;
.field private static final EXTRA_CLI_TYPE:Ljava/lang/String;
.field private static final EXTRA_CONVERSATION_ID:Ljava/lang/String;
.field private static final EXTRA_TURN_ID:Ljava/lang/String;
.field private adapter:Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;
.field private layoutError:Landroid/widget/LinearLayout;
.field private progressBar:Landroid/widget/ProgressBar;
.field private recyclerView:Landroidx/recyclerview/widget/RecyclerView;
.field private tvEmpty:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$4WO9qmnG4JQGxzBPIxNDEFGp6ok(com.bytedance.trae.conversation.products.ArtifactListActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->onCreate$lambda$0(Lcom/bytedance/trae/conversation/products/ArtifactListActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$L1XQFsKb5pugxTvgxbDPCb9L4D4(com.bytedance.trae.conversation.products.ArtifactListActivity  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.products.ArtifactItem)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->onCreate$lambda$1(Lcom/bytedance/trae/conversation/products/ArtifactListActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/products/ArtifactItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$vAPXfCdclo34awLFS9Rmpxs3kCA(com.bytedance.trae.conversation.products.ArtifactListActivity  java.lang.String  java.lang.String  java.lang.String  java.lang.String  android.view.View)void
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->onCreate$lambda$2(Lcom/bytedance/trae/conversation/products/ArtifactListActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->Companion Lcom/bytedance/trae/conversation/products/ArtifactListActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getIconForFileName(com.bytedance.trae.conversation.products.ArtifactListActivity  java.lang.String)int
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->getIconForFileName(Ljava/lang/String;)I
    move-result v0
    return v0
.end method

.method public static final synthetic access$showContent(com.bytedance.trae.conversation.products.ArtifactListActivity  java.util.List)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->showContent(Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$showError(com.bytedance.trae.conversation.products.ArtifactListActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->showError()V
    return-void 
.end method

.method public static com_bytedance_trae_conversation_products_ArtifactListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.products.ArtifactListActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->com_bytedance_trae_conversation_products_ArtifactListActivity__onStop$___twin___()V
    invoke-static Lcom/bytedance/sysoptimizer/EnterTransitionCrashOptimizer;->getContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewTreeObserver;->dispatchOnPreDraw()Z
    return-void 
    :try_start_0xb
.end method

.method private final getIconForFileName(java.lang.String)int
    .registers 4
    # ins_size=2
    const/16 v0, 46
    const-string v1, ""
    invoke-static v3, v0, v1, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v3, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Ljava/lang/String;->hashCode()I
    move-result v0
    sparse-switch v0, +000016ch
    goto/16 +166h
    const-string/jumbo v0, xlsx
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +0d8h
    goto/16 +15bh
    const-string v0, "pptx"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +078h
    goto/16 +151h
    const-string v0, "json"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +147h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_json I
    goto/16 +145h
    const-string v0, "jpeg"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +0a8h
    goto/16 +139h
    const-string v0, "java"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +121h
    goto/16 +12fh
    const-string v0, "html"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +117h
    goto/16 +125h
    const-string v0, "docx"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +0a6h
    goto/16 +11bh
    const-string/jumbo v0, zip
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +110h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_zip I
    goto/16 +10eh
    const-string/jumbo v0, xls
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +07eh
    goto/16 +101h
    const-string/jumbo v0, wav
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +057h
    goto/16 +0f6h
    const-string/jumbo v0, txt
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +0ebh
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_txt I
    goto/16 +0e9h
    const-string v0, "ppt"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +0ddh
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_ppt I
    goto/16 +0dbh
    const-string v0, "png"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +03eh
    goto/16 +0cfh
    const-string v0, "pdf"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +0c5h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_pdf I
    goto/16 +0c3h
    const-string v0, "mov"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +063h
    goto/16 +0b7h
    const-string v0, "mp4"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +059h
    goto/16 +0adh
    const-string v0, "mp3"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +0a3h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_vedio I
    goto/16 +0a1h
    const-string v0, "jpg"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +095h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_png I
    goto/16 +093h
    const-string v0, "elx"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +087h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_excel I
    goto/16 +085h
    const-string v0, "doc"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +079h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_doc I
    goto/16 +077h
    const-string v0, "css"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +05dh
    goto/16 +06bh
    const-string v0, "cpp"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +053h
    goto/16 +061h
    const-string v0, "avi"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +57h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_vedio I
    goto +56h
    const-string/jumbo v0, ts
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +03ch
    goto +4ah
    const-string v0, "py"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +033h
    goto +41h
    const-string v0, "md"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +38h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_markdown I
    goto +37h
    const-string v0, "kt"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +01eh
    goto +2ch
    const-string v0, "js"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +015h
    goto +23h
    const-string v0, "go"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +00ch
    goto +1ah
    const-string v0, "c"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +11h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_code I
    goto +10h
    const-string/jumbo v0, skills
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +4h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_skill I
    goto +3h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_custom I
    return v3
    sparse-switch-payload -35ad7fbe 63 ce8 d49 d69 d97 e09 e7f 17ad4 181a3 18203 18538 188b1 19be1 1a6f0 1a6f1 1a714 1b0f2 1b229 1b274 1c270 1caec 1cfff 1d721 2f2240 3107ab 31aa22 31e068 31ece8 349c84 383059
.end method

.method private final loadArtifactList(java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 16
    # ins_size=5
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-nez v0, +008h
    const-string v0, "recyclerView"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->layoutError Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "layoutError"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->tvEmpty Landroid/widget/TextView;
    if-nez v0, +009h
    const-string/jumbo v0, tvEmpty
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, v2, Landroid/widget/TextView;->setVisibility(I)V
    move-object v0, v11
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;
    const/4 v10, 0
    move-object v4, v0
    move-object v5, v12
    move-object v6, v15
    move-object v7, v11
    move-object v8, v13
    move-object v9, v14
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/products/ArtifactListActivity; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final onCreate$lambda$0(com.bytedance.trae.conversation.products.ArtifactListActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->finish()V
    return-void 
.end method

.method private static final onCreate$lambda$1(com.bytedance.trae.conversation.products.ArtifactListActivity  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.products.ArtifactItem)kotlin.Unit
    .registers 19
    # ins_size=6
    const-string v0, "item"
    move-object/from16 v1, v18
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;
    move-object v2, v13
    check-cast v2, Landroid/content/Context;
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/products/ArtifactItem;->getPath()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    const-wide/16 v9, 0
    const/16 v11, 160
    const/4 v12, 0
    move-object v1, v0
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v8, v17
    invoke-static/range v1 ... v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;->start$default(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J I Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onCreate$lambda$2(com.bytedance.trae.conversation.products.ArtifactListActivity  java.lang.String  java.lang.String  java.lang.String  java.lang.String  android.view.View)void
    .registers 6
    # ins_size=6
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->loadArtifactList(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final showContent(java.util.List)void
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->layoutError Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "layoutError"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-interface v7, Ljava/util/List;->isEmpty()Z
    move-result v0
    const-string/jumbo v3, tvEmpty
    const-string v4, "recyclerView"
    const/4 v5, 0
    if-eqz v0, +01ah
    iget-object v7, v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-nez v7, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v1
    invoke-virtual v7, v2, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->tvEmpty Landroid/widget/TextView;
    if-nez v7, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v7
    invoke-virtual v1, v5, Landroid/widget/TextView;->setVisibility(I)V
    goto +25h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v5, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->tvEmpty Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->adapter Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;
    if-nez v0, +008h
    const-string v0, "adapter"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, v7, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;->submitList(Ljava/util/List;)V
    return-void 
.end method

.method private final showError()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-nez v0, +008h
    const-string v0, "recyclerView"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->tvEmpty Landroid/widget/TextView;
    if-nez v0, +009h
    const-string/jumbo v0, tvEmpty
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->layoutError Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "layoutError"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    const/4 v0, 0
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    return-void 
.end method

.method public com_bytedance_trae_conversation_products_ArtifactListActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 14
    # ins_size=2
    invoke-super v12, v13, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v13, Lcom/bytedance/trae/conversation/R$layout;->trae_activity_artifact_list I
    invoke-virtual v12, v13, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->setContentView(I)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->getIntent()Landroid/content/Intent;
    move-result-object v13
    const-string v0, "extra_chat_session_id"
    invoke-virtual v13, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    const-string v0, ""
    if-nez v13, +003h
    move-object v13, v0
    invoke-virtual v12, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v2, "extra_turn_id"
    invoke-virtual v1, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v7, v0
    goto +2h
    move-object v7, v1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v2, "extra_cli_type"
    invoke-virtual v1, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v8, v0
    goto +2h
    move-object v8, v1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v2, "extra_conversation_id"
    invoke-virtual v1, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v0, v1
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->findViewById(I)Landroid/view/View;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda0;
    invoke-direct v2, v12, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactListActivity;)V
    invoke-virtual v1, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->findViewById(I)Landroid/view/View;
    move-result-object v1
    const-string v9, "findViewById(...)"
    invoke-static v1, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/widget/ProgressBar;
    iput-object v1, v12, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->progressBar Landroid/widget/ProgressBar;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_error I
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/widget/LinearLayout;
    iput-object v1, v12, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->layoutError Landroid/widget/LinearLayout;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_empty I
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/widget/TextView;
    iput-object v1, v12, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->tvEmpty Landroid/widget/TextView;
    new-instance v10, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;
    new-instance v11, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda1;
    move-object v1, v11
    move-object v2, v12
    move-object v3, v13
    move-object v4, v7
    move-object v5, v8
    move-object v6, v0
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactListActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v10, v11, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;-><init>(Lkotlin/jvm/functions/Function1;)V
    iput-object v10, v12, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->adapter Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->rv_artifact_list I
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v1, v12, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    const-string v2, "recyclerView"
    const/4 v3, 0
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    new-instance v4, Landroidx/recyclerview/widget/LinearLayoutManager;
    move-object v5, v12
    check-cast v5, Landroid/content/Context;
    invoke-direct v4, v5, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v4, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v1, v4, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v1, v12, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v2, v12, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->adapter Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;
    if-nez v2, +008h
    const-string v2, "adapter"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v2
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v1, v3, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_retry I
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->findViewById(I)Landroid/view/View;
    move-result-object v9
    new-instance v10, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda2;
    move-object v1, v10
    move-object v2, v12
    move-object v3, v8
    move-object v4, v13
    move-object v5, v7
    move-object v6, v0
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactListActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v9, v10, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v12, v8, v13, v7, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->loadArtifactList(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->com_bytedance_trae_conversation_products_ArtifactListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/products/ArtifactListActivity;)V
    return-void 
.end method
