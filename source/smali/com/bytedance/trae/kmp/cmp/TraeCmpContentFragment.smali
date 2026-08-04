# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public abstract Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;
.super Landroidx/fragment/app/Fragment;
.source "TraeCmpContentFragment.kt"

.field public static final $stable:I
.field private final composeViewId:I
.field private final leftAction:Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.field private final rightAction:Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;


.method public static synthetic $r8$lambda$avDUCd1-5YhelTu95dCFPnsCCKQ(com.bytedance.trae.kmp.cmp.TraeCmpContentFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->onViewCreated$lambda$2$lambda$1(Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$hkcpCHbGOcFYIRZxTTlUMDYvGpM(com.bytedance.trae.kmp.cmp.TraeCmpContentFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->onViewCreated$lambda$2$lambda$0(Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/fragment/app/Fragment;-><init>()V
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->BACK Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    iput-object v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->leftAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    iput-object v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->rightAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    const/4 v0, -1
    iput v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->composeViewId I
    return-void 
.end method

.method private static final onViewCreated$lambda$2$lambda$0(com.bytedance.trae.kmp.cmp.TraeCmpContentFragment  android.view.View)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->getLeftAction()Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    move-result-object v2
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->BACK Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    if-ne v2, v0, +005h
    invoke-virtual v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->onBackAction()V
    return-void 
.end method

.method private static final onViewCreated$lambda$2$lambda$1(com.bytedance.trae.kmp.cmp.TraeCmpContentFragment  android.view.View)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->getRightAction()Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    move-result-object v2
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->CLOSE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    if-ne v2, v0, +005h
    invoke-virtual v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->onCloseAction()V
    return-void 
.end method

.method protected abstract RenderCmpContent(androidx.compose.runtime.Composer  int)void
    # abstract or native
.end method

.method protected getComposeViewId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->composeViewId I
    return v0
.end method

.method protected getLeftAction()com.bytedance.trae.common.widget.TraeTitleBar$Action
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->leftAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    return-object v0
.end method

.method protected getRightAction()com.bytedance.trae.common.widget.TraeTitleBar$Action
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->rightAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    return-object v0
.end method

.method protected abstract getTitleBarMode()com.bytedance.trae.common.widget.TraeTitleBar$Mode
    # abstract or native
.end method

.method protected abstract getTitleResId()int
    # abstract or native
.end method

.method protected onBackAction()void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method protected onCloseAction()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method protected onCmpViewCreated(android.view.View  android.os.Bundle)void
    .registers 3
    # ins_size=3
    const-string/jumbo v2, view
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public final onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/kmp/base/R$layout;->trae_fragment_cmp_content I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    const-string v3, "inflate(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public final onViewCreated(android.view.View  android.os.Bundle)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v5, v6, v7, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v0, Lcom/bytedance/trae/kmp/base/R$id;->trae_cmp_title_bar I
    invoke-virtual v6, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v5, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->getTitleBarMode()Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    move-result-object v1
    const/4 v2, 2
    const/4 v3, 0
    const/4 v4, 0
    invoke-static v0, v1, v4, v2, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setMode$default(Lcom/bytedance/trae/common/widget/TraeTitleBar; Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode; Z I Ljava/lang/Object;)V
    invoke-virtual v5, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->getTitleResId()I
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(I)V
    invoke-virtual v5, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->getLeftAction()Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setLeftAction(Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;)V
    invoke-virtual v5, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->getRightAction()Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightAction(Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;)V
    new-instance v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$$ExternalSyntheticLambda0;
    invoke-direct v1, v5, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$$ExternalSyntheticLambda1;
    invoke-direct v1, v5, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/kmp/base/R$id;->trae_cmp_content I
    invoke-virtual v6, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroidx/compose/ui/platform/ComposeView;
    invoke-virtual v5, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->getComposeViewId()I
    move-result v1
    const/4 v2, -1
    if-eq v1, v2, +009h
    invoke-virtual v5, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->getComposeViewId()I
    move-result v1
    invoke-virtual v0, v1, Landroidx/compose/ui/platform/ComposeView;->setId(I)V
    invoke-virtual v0, v4, Landroidx/compose/ui/platform/ComposeView;->setSaveFromParentEnabled(Z)V
    sget v1, Landroidx/compose/ui/R$id;->compose_view_saveable_id_tag I
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v5, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 95
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-static Landroid/os/SystemClock;->elapsedRealtimeNanos()J
    move-result-wide v3
    invoke-virtual v2, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroidx/compose/ui/platform/ComposeView;->setTag(I Ljava/lang/Object;)V
    sget-object v1, Landroidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed;->INSTANCE Landroidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed;
    check-cast v1, Landroidx/compose/ui/platform/ViewCompositionStrategy;
    invoke-virtual v0, v1, Landroidx/compose/ui/platform/ComposeView;->setViewCompositionStrategy(Landroidx/compose/ui/platform/ViewCompositionStrategy;)V
    new-instance v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$onViewCreated$2$1;
    invoke-direct v1, v5, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$onViewCreated$2$1;-><init>(Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;)V
    const v2, -1909781802
    const/4 v3, 1
    invoke-static v2, v3, v1, Landroidx/compose/runtime/internal/ComposableLambdaKt;->composableLambdaInstance(I Z Ljava/lang/Object;)Landroidx/compose/runtime/internal/ComposableLambda;
    move-result-object v1
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-virtual v0, v1, Landroidx/compose/ui/platform/ComposeView;->setContent(Lkotlin/jvm/functions/Function2;)V
    invoke-virtual v5, v6, v7, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->onCmpViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    return-void 
.end method
