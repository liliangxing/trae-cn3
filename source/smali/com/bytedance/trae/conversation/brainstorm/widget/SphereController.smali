# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
.super Ljava/lang/Object;
.source "SphereController.kt"

.field private pageLoaded:Z
.field private final pendingActions:Ljava/util/List;
.field private performanceLevel:I
.field private sphereRatio:Ljava/lang/Float;
.field private final webView:Landroid/webkit/WebView;


.method public static synthetic $r8$lambda$8JqbNUoGNXjHHLG74jCFINdYFrg(com.bytedance.trae.conversation.brainstorm.widget.SphereController  int)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->intro$lambda$1(Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$q9WofLb_sp88qSGYRYmqose7fRk(com.bytedance.trae.conversation.brainstorm.widget.SphereController  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->setState$lambda$2(Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$w03ao2qeiJgpHxfjpSGfNZp73lY(com.bytedance.trae.conversation.brainstorm.widget.SphereController)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->start$lambda$0(Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>(android.webkit.WebView)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, webView
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->webView Landroid/webkit/WebView;
    const/4 v2, 3
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->performanceLevel I
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->pendingActions Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$getPendingActions$p(com.bytedance.trae.conversation.brainstorm.widget.SphereController)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->pendingActions Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$setPageLoaded$p(com.bytedance.trae.conversation.brainstorm.widget.SphereController  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->pageLoaded Z
    return-void 
.end method

.method private final applySphereRatioIfNeeded()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->sphereRatio Ljava/lang/Float;
    if-eqz v0, +020h
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->floatValue()F
    move-result v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "SphereAPI.setSphereRatio("
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->js(Ljava/lang/String;)V
    return-void 
.end method

.method private final escapeJsString(java.lang.String)java.lang.String
    .registers 14
    # ins_size=2
    const-string v1, "\"
    const-string v2, "\\"
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v13
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const-string v7, "'"
    const-string v8, "\'"
    const/4 v9, 0
    const/4 v10, 4
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    return-object v13
.end method

.method public static synthetic intro$default(com.bytedance.trae.conversation.brainstorm.widget.SphereController  int  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    const/16 v1, 500
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->intro(I)V
    return-void 
.end method

.method private static final intro$lambda$1(com.bytedance.trae.conversation.brainstorm.widget.SphereController  int)kotlin.Unit
    .registers 5
    # ins_size=2
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->applySphereRatioIfNeeded()V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SphereAPI.setPerformanceLevel("
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->performanceLevel I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->js(Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "SphereAPI.intro("
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->js(Ljava/lang/String;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private final js(java.lang.String)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->webView Landroid/webkit/WebView;
    const/4 v1, 0
    invoke-virtual v0, v3, v1, Landroid/webkit/WebView;->evaluateJavascript(Ljava/lang/String; Landroid/webkit/ValueCallback;)V
    return-void 
.end method

.method public static synthetic outro$default(com.bytedance.trae.conversation.brainstorm.widget.SphereController  int  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    const/16 v1, 600
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->outro(I)V
    return-void 
.end method

.method private final runWhenReady(kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=2
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->pageLoaded Z
    if-eqz v0, +006h
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +8h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->pendingActions Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method private static final setState$lambda$2(com.bytedance.trae.conversation.brainstorm.widget.SphereController  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SphereAPI.setState('"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->escapeJsString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v0, "')"
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->js(Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final start$lambda$0(com.bytedance.trae.conversation.brainstorm.widget.SphereController)kotlin.Unit
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->applySphereRatioIfNeeded()V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SphereAPI.setPerformanceLevel("
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->performanceLevel I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->js(Ljava/lang/String;)V
    const-string v0, "SphereAPI.start()"
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->js(Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method public final destroy()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->webView Landroid/webkit/WebView;
    invoke-virtual v0, Landroid/webkit/WebView;->destroy()V
    return-void 
.end method

.method public final getPerformanceLevel()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->performanceLevel I
    return v0
.end method

.method public final getSphereRatio()java.lang.Float
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->sphereRatio Ljava/lang/Float;
    return-object v0
.end method

.method public final init()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->webView Landroid/webkit/WebView;
    invoke-virtual v0, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v0
    const/4 v1, 1
    invoke-virtual v0, v1, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->webView Landroid/webkit/WebView;
    invoke-virtual v0, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v0
    invoke-virtual v0, v1, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->webView Landroid/webkit/WebView;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/webkit/WebView;->setBackgroundColor(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->webView Landroid/webkit/WebView;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$init$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$init$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;)V
    check-cast v1, Landroid/webkit/WebViewClient;
    invoke-virtual v0, v1, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->webView Landroid/webkit/WebView;
    const-string v1, "file:///android_asset/brainstorm/hollow_sphere.html"
    invoke-virtual v0, v1, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V
    return-void 
.end method

.method public final intro(int)void
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController; I)V
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->runWhenReady(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public final outro(int)void
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SphereAPI.outro("
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v0, 41
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->js(Ljava/lang/String;)V
    return-void 
.end method

.method public final setPerformanceLevel(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->performanceLevel I
    return-void 
.end method

.method public final setSphereRatio(java.lang.Float)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->sphereRatio Ljava/lang/Float;
    return-void 
.end method

.method public final setState(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, state
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$$ExternalSyntheticLambda1;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController; Ljava/lang/String;)V
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->runWhenReady(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public final setTaskRunning(boolean)void
    .registers 2
    # ins_size=2
    if-eqz v1, +005h
    const-string v1, "processing"
    goto +3h
    const-string v1, "idle"
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->setState(Ljava/lang/String;)V
    return-void 
.end method

.method public final start()void
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$$ExternalSyntheticLambda2;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;)V
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->runWhenReady(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public final stop()void
    .registers 2
    # ins_size=1
    const-string v0, "SphereAPI.stop()"
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->js(Ljava/lang/String;)V
    return-void 
.end method
