# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "PreviewActivity.kt"

.field private adapter:Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
.field private binding:Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
.field private config:Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
.field private items:Ljava/util/List;
.field private maxTotalSize:J
.field private selection:Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
.field private singleMaxSize:J


.method public static synthetic $r8$lambda$-HycLle-T1FyUz2vH14PgSu5zc8(com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity  android.widget.CompoundButton  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->onCreate$lambda$6(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity; Landroid/widget/CompoundButton; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$UjIsfWmb6InzKj3GkmlxLorIEmM(com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->onCreate$lambda$7(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$iiaO2jAbOhFfnjfAMBrsxjHVgAM(com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->onCreate$lambda$5(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$lozFPMWnzBwWhyeCyjSxDKH09i8(android.view.View  androidx.core.view.WindowInsetsCompat)androidx.core.view.WindowInsetsCompat
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->onCreate$lambda$0(Landroid/view/View; Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$okuokIQsQ0ms6DDkug7ZhGUcG48(com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->onCreate$lambda$3(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xywZ9xcPIbKpUxzcEyG_dnjzyCg(android.view.View  androidx.core.view.WindowInsetsCompat)androidx.core.view.WindowInsetsCompat
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->onCreate$lambda$1(Landroid/view/View; Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    const-wide v0, 9223372036854775807
    iput-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->maxTotalSize J
    iput-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->singleMaxSize J
    return-void 
.end method

.method public static final synthetic access$getAdapter$p(com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity)com.bytedance.trae.conversation.mediachoose.ui.PreviewPagerAdapter
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->adapter Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
    return-object v0
.end method

.method public static final synthetic access$updateControls(com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->updateControls()V
    return-void 
.end method

.method public static com_bytedance_trae_conversation_mediachoose_ui_PreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->com_bytedance_trae_conversation_mediachoose_ui_PreviewActivity__onStop$___twin___()V
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

.method private final getCurrentItem()com.bytedance.trae.conversation.mediachoose.model.MediaItem
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "binding"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->pager Landroidx/viewpager2/widget/ViewPager2;
    invoke-virtual v0, Landroidx/viewpager2/widget/ViewPager2;->getCurrentItem()I
    move-result v0
    iget-object v2, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->items Ljava/util/List;
    if-nez v2, +008h
    const-string v2, "items"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v2
    invoke-static v1, v0, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    return-object v0
.end method

.method private static final onCreate$lambda$0(android.view.View  androidx.core.view.WindowInsetsCompat)androidx.core.view.WindowInsetsCompat
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
    iget v0, v0, Landroidx/core/graphics/Insets;->top I
    invoke-virtual v4, Landroid/view/View;->getPaddingLeft()I
    move-result v1
    invoke-virtual v4, Landroid/view/View;->getPaddingRight()I
    move-result v2
    invoke-virtual v4, Landroid/view/View;->getPaddingBottom()I
    move-result v3
    invoke-virtual v4, v1, v0, v2, v3, Landroid/view/View;->setPadding(I I I I)V
    return-object v5
.end method

.method private static final onCreate$lambda$1(android.view.View  androidx.core.view.WindowInsetsCompat)androidx.core.view.WindowInsetsCompat
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
    iget v0, v0, Landroidx/core/graphics/Insets;->bottom I
    invoke-virtual v4, Landroid/view/View;->getPaddingLeft()I
    move-result v1
    invoke-virtual v4, Landroid/view/View;->getPaddingTop()I
    move-result v2
    invoke-virtual v4, Landroid/view/View;->getPaddingRight()I
    move-result v3
    invoke-virtual v4, v1, v2, v3, v0, Landroid/view/View;->setPadding(I I I I)V
    return-object v5
.end method

.method private static final onCreate$lambda$3(com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->returnSelectionAndFinish()V
    return-void 
.end method

.method private static final onCreate$lambda$5(com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity  android.view.View)void
    .registers 11
    # ins_size=2
    invoke-direct v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getCurrentItem()Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-result-object v10
    if-nez v10, +003h
    return-void 
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    const-string/jumbo v1, selection
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v3
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->isSelected(J)Z
    move-result v0
    const/4 v3, 1
    const/4 v4, 0
    if-nez v0, +080h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo()Z
    move-result v0
    if-nez v0, +032h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getSizeBytes()J
    move-result-wide v5
    iget-wide v7, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->singleMaxSize J
    cmp-long v0, v5, v7
    if-lez v0, +028h
    sget v10, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_file_too_large I
    new-array v0, v3, [Ljava/lang/Object;
    iget-wide v1, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->singleMaxSize J
    const/16 v3, 1024
    int-to-long v5, v3
    div-long/2addr v1, v5
    div-long/2addr v1, v5
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    aput-object v1, v0, v4
    invoke-virtual v9, v10, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    const-string v0, "getString(...)"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v9, Landroid/content/Context;
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v9, v10, v4, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v9
    invoke-virtual v9, Landroid/widget/Toast;->show()V
    return-void 
    iget-wide v5, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->maxTotalSize J
    const-wide v7, 9223372036854775807
    cmp-long v0, v5, v7
    if-eqz v0, +03fh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selectedItems()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-wide/16 v5, 0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +00eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getSizeBytes()J
    move-result-wide v7
    add-long/2addr v5, v7
    goto -11h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getSizeBytes()J
    move-result-wide v7
    add-long/2addr v5, v7
    iget-wide v7, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->maxTotalSize J
    cmp-long v0, v5, v7
    if-lez v0, +00eh
    check-cast v9, Landroid/content/Context;
    sget v10, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_total_size_too_large I
    invoke-static v9, v10, v4, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v9
    invoke-virtual v9, Landroid/widget/Toast;->show()V
    return-void 
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->toggle(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    move-result-object v10
    sget-object v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->ReachMax Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    if-ne v10, v0, +02ch
    move-object v10, v9
    check-cast v10, Landroid/content/Context;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_reach_max I
    new-array v1, v3, [Ljava/lang/Object;
    iget-object v3, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v3, +008h
    const-string v3, "config"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getMaxSelectCount()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    aput-object v2, v1, v4
    invoke-virtual v9, v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v10, v9, v4, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v9
    invoke-virtual v9, Landroid/widget/Toast;->show()V
    return-void 
    invoke-direct v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->updateControls()V
    return-void 
.end method

.method private static final onCreate$lambda$6(com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity  android.widget.CompoundButton  boolean)void
    .registers 3
    # ins_size=3
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v0, +009h
    const-string/jumbo v0, selection
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->setKeepOrigin(Z)V
    return-void 
.end method

.method private static final onCreate$lambda$7(com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->sendAndFinish()V
    return-void 
.end method

.method private final returnSelectionAndFinish()void
    .registers 8
    # ins_size=1
    new-instance v0, Landroid/content/Intent;
    invoke-direct v0, Landroid/content/Intent;-><init>()V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    const/4 v2, 0
    const-string/jumbo v3, selection
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selectedItems()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v1, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v4, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +014h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v5
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v4, Ljava/util/List;
    check-cast v4, Ljava/util/Collection;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->toLongArray(Ljava/util/Collection;)[J
    move-result-object v1
    const-string/jumbo v4, trae_media_choose_result_back_selected_ids
    invoke-virtual v0, v4, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; [J)Landroid/content/Intent;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->getKeepOrigin()Z
    move-result v1
    const-string/jumbo v2, trae_media_choose_result_back_keep_origin
    invoke-virtual v0, v2, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v1, 2
    invoke-virtual v7, v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->setResult(I Landroid/content/Intent;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->finish()V
    return-void 
.end method

.method private final sendAndFinish()void
    .registers 11
    # ins_size=1
    iget-object v0, v10, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    const/4 v1, 0
    const-string/jumbo v2, selection
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selectedItems()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v3
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v3, +05ch
    invoke-direct v10, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getCurrentItem()Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-result-object v3
    if-nez v3, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo()Z
    move-result v6
    if-nez v6, +033h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getSizeBytes()J
    move-result-wide v6
    iget-wide v8, v10, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->singleMaxSize J
    cmp-long v6, v6, v8
    if-lez v6, +029h
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_file_too_large I
    new-array v1, v4, [Ljava/lang/Object;
    iget-wide v2, v10, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->singleMaxSize J
    const/16 v4, 1024
    int-to-long v6, v4
    div-long/2addr v2, v6
    div-long/2addr v2, v6
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    aput-object v2, v1, v5
    invoke-virtual v10, v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v1, v10
    check-cast v1, Landroid/content/Context;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v1, v0, v5, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
    iget-object v6, v10, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v6, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v1
    invoke-virtual v6, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->toggle(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selectedItems()Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/util/Collection;
    invoke-interface v0, v3, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    move-object v3, v0
    check-cast v3, Ljava/lang/Iterable;
    instance-of v6, v3, Ljava/util/Collection;
    if-eqz v6, +00dh
    move-object v6, v3
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    if-eqz v6, +004h
    move v4, v5
    goto +17h
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, -00ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo()Z
    move-result v6
    if-eqz v6, -010h
    new-instance v3, Landroid/content/Intent;
    invoke-direct v3, Landroid/content/Intent;-><init>()V
    new-instance v5, Ljava/util/ArrayList;
    check-cast v0, Ljava/util/Collection;
    invoke-direct v5, v0, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    const-string/jumbo v0, trae_media_choose_result_selected
    invoke-virtual v3, v0, v5, Landroid/content/Intent;->putParcelableArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    iget-object v0, v10, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->getKeepOrigin()Z
    move-result v0
    const-string/jumbo v1, trae_media_choose_result_keep_origin
    invoke-virtual v3, v1, v0, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    const-string/jumbo v0, trae_media_choose_result_has_video
    invoke-virtual v3, v0, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v0, -1
    invoke-virtual v10, v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->setResult(I Landroid/content/Intent;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->finish()V
    return-void 
.end method

.method private final updateControls()void
    .registers 10
    # ins_size=1
    invoke-direct v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getCurrentItem()Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-result-object v0
    const-string v1, "config"
    const/4 v2, 0
    const-string v3, "binding"
    const/4 v4, 0
    if-nez v0, +03dh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->selectionContainer Landroid/widget/FrameLayout;
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setSelected(Z)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->tvOrder Landroid/widget/TextView;
    const-string v2, ""
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->btnSend Landroid/widget/TextView;
    iget-object v2, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getActionText()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
    iget-object v5, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    const-string/jumbo v6, selection
    if-nez v5, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v4
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v7
    invoke-virtual v5, v7, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->getOrderText(J)Ljava/lang/String;
    move-result-object v0
    iget-object v5, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v5, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v4
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->selectionContainer Landroid/widget/FrameLayout;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v7
    const/4 v8, 1
    if-lez v7, +004h
    move v7, v8
    goto +2h
    move v7, v2
    invoke-virtual v5, v7, Landroid/widget/FrameLayout;->setSelected(Z)V
    iget-object v5, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v5, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v4
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->tvOrder Landroid/widget/TextView;
    invoke-virtual v5, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v0, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selectedCount()I
    move-result v0
    iget-object v5, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v5, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v4
    iget-object v3, v5, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->btnSend Landroid/widget/TextView;
    if-nez v0, +012h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getActionText()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    goto +26h
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_send_with_count I
    const/4 v6, 2
    new-array v6, v6, [Ljava/lang/Object;
    iget-object v7, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v7, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v7
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getActionText()Ljava/lang/String;
    move-result-object v1
    aput-object v1, v6, v2
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    aput-object v0, v6, v8
    invoke-virtual v9, v5, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v3, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public com_bytedance_trae_conversation_mediachoose_ui_PreviewActivity__onStop$___twin___()void
    .registers 2
    # ins_size=1
    invoke-super v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->adapter Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
    if-nez v0, +008h
    const-string v0, "adapter"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->stopCurrentVideo()V
    return-void 
.end method

.method public getDecorViewBackgroundColor()int
    .registers 2
    # ins_size=1
    const/high16 v0, -16777216
    return v0
.end method

.method public onBackPressed()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->returnSelectionAndFinish()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 19
    # ins_size=2
    move-object/from16 v0, v17
    invoke-super/range v17 ... v18, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getLayoutInflater()Landroid/view/LayoutInflater;
    move-result-object v1
    invoke-static v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->inflate(Landroid/view/LayoutInflater;)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    move-result-object v1
    const-string v2, "inflate(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    const-string v2, "binding"
    const/4 v3, 0
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v1
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->setContentView(Landroid/view/View;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->topBar Landroidx/constraintlayout/widget/ConstraintLayout;
    check-cast v1, Landroid/view/View;
    new-instance v4, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$$ExternalSyntheticLambda0;
    invoke-direct v4, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v1, v4, Landroidx/core/view/ViewCompat;->setOnApplyWindowInsetsListener(Landroid/view/View; Landroidx/core/view/OnApplyWindowInsetsListener;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->bottomBar Landroid/widget/LinearLayout;
    check-cast v1, Landroid/view/View;
    new-instance v4, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$$ExternalSyntheticLambda1;
    invoke-direct v4, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v1, v4, Landroidx/core/view/ViewCompat;->setOnApplyWindowInsetsListener(Landroid/view/View; Landroidx/core/view/OnApplyWindowInsetsListener;)V
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string/jumbo v4, trae_media_choose_extra_preview_config
    invoke-virtual v1, v4, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v1, +020h
    new-instance v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_send I
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v12
    const-string v4, "getString(...)"
    invoke-static v12, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 895
    const/16 v16, 0
    move-object v4, v1
    invoke-direct/range v4 ... v16, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;-><init>(I Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; Z Z Z Z Z Ljava/lang/String; I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    new-instance v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    const-string v5, "config"
    if-nez v4, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v3
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;-><init>(Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v4
    const-string/jumbo v6, trae_media_choose_extra_preview_keep_origin
    const/4 v7, 0
    invoke-virtual v4, v6, v7, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String; Z)Z
    move-result v4
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->setKeepOrigin(Z)V
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string/jumbo v4, trae_media_choose_max_total_size
    const-wide v8, 9223372036854775807
    invoke-virtual v1, v4, v8, v9, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v10
    iput-wide v10, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->maxTotalSize J
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string/jumbo v4, trae_media_choose_single_size
    invoke-virtual v1, v4, v8, v9, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v8
    iput-wide v8, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->singleMaxSize J
    sget-object v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;->INSTANCE Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;->getPreviewItemsCache()Ljava/util/List;
    move-result-object v1
    if-nez v1, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->items Ljava/util/List;
    sget-object v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;->INSTANCE Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;->setPreviewItemsCache(Ljava/util/List;)V
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string/jumbo v4, trae_media_choose_extra_preview_index
    invoke-virtual v1, v4, v7, Landroid/content/Intent;->getIntExtra(Ljava/lang/String; I)I
    move-result v1
    iget-object v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->items Ljava/util/List;
    const-string v6, "items"
    if-nez v4, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v3
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    add-int/lit8 v4, v4, -1
    invoke-static v4, v7, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v4
    invoke-static v1, v7, v4, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v1
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v4
    const-string/jumbo v8, trae_media_choose_extra_preview_selected_ids
    invoke-virtual v4, v8, Landroid/content/Intent;->getLongArrayExtra(Ljava/lang/String;)[J
    move-result-object v4
    if-nez v4, +004h
    new-array v4, v7, [J
    invoke-static v4, Lkotlin/collections/ArraysKt;->toSet([J)Ljava/util/Set;
    move-result-object v4
    iget-object v8, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    const-string/jumbo v9, selection
    if-nez v8, +006h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v3
    iget-object v10, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->items Ljava/util/List;
    if-nez v10, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v3
    check-cast v10, Ljava/lang/Iterable;
    new-instance v11, Ljava/util/ArrayList;
    invoke-direct v11, Ljava/util/ArrayList;-><init>()V
    check-cast v11, Ljava/util/Collection;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v12
    if-eqz v12, +01bh
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v12
    move-object v13, v12
    check-cast v13, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v13
    invoke-static v13, v14, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v13
    invoke-interface v4, v13, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, -019h
    invoke-interface v11, v12, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1eh
    check-cast v11, Ljava/util/List;
    invoke-virtual v8, v11, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->setSelected(Ljava/util/List;)V
    new-instance v4, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->items Ljava/util/List;
    if-nez v8, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v3
    invoke-direct v4, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;-><init>(Ljava/util/List;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->adapter Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v3
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->pager Landroidx/viewpager2/widget/ViewPager2;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->adapter Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
    if-nez v6, +008h
    const-string v6, "adapter"
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v3
    check-cast v6, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v4, v6, Landroidx/viewpager2/widget/ViewPager2;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v3
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->pager Landroidx/viewpager2/widget/ViewPager2;
    invoke-virtual v4, v1, v7, Landroidx/viewpager2/widget/ViewPager2;->setCurrentItem(I Z)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->btnBack Landroid/widget/ImageView;
    new-instance v4, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$$ExternalSyntheticLambda2;
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;)V
    invoke-virtual v1, v4, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->selectionContainer Landroid/widget/FrameLayout;
    new-instance v4, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$$ExternalSyntheticLambda3;
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;)V
    invoke-virtual v1, v4, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->cbOrigin Landroid/widget/CheckBox;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v4, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getShowOrigin()Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    const/16 v7, 8
    invoke-virtual v1, v7, Landroid/widget/CheckBox;->setVisibility(I)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->cbOrigin Landroid/widget/CheckBox;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v4, +006h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->getKeepOrigin()Z
    move-result v4
    invoke-virtual v1, v4, Landroid/widget/CheckBox;->setChecked(Z)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->cbOrigin Landroid/widget/CheckBox;
    new-instance v4, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$$ExternalSyntheticLambda4;
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;)V
    invoke-virtual v1, v4, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->btnSend Landroid/widget/TextView;
    new-instance v4, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$$ExternalSyntheticLambda5;
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;)V
    invoke-virtual v1, v4, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v1
    iget-object v1, v3, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->pager Landroidx/viewpager2/widget/ViewPager2;
    new-instance v2, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$onCreate$8;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$onCreate$8;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;)V
    check-cast v2, Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;
    invoke-virtual v1, v2, Landroidx/viewpager2/widget/ViewPager2;->registerOnPageChangeCallback(Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;)V
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->updateControls()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->com_bytedance_trae_conversation_mediachoose_ui_PreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;)V
    return-void 
.end method
