# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
.super Landroidx/fragment/app/Fragment;
.source "MediaChooseFragment.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$Companion;
.field private static final MAX_IMAGE_SIZE_BYTES:J
.field private static final PAGE_SIZE:I
.field private static final PREFETCH_THRESHOLD:I
.field private _binding:Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
.field private adapter:Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
.field private buckets:Ljava/util/List;
.field private final cameraPermissionLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private config:Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
.field private currentBucketId:J
.field private hasMore:Z
.field private loadJob:Lkotlinx/coroutines/Job;
.field private maxTotalSize:J
.field private final mediaItems:Ljava/util/ArrayList;
.field private offset:I
.field private pendingCameraUri:Landroid/net/Uri;
.field private final permissionLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private final previewLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private repository:Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;
.field private selection:Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
.field private singleMaxSize:J
.field private final takePictureLauncher:Landroidx/activity/result/ActivityResultLauncher;


.method public static synthetic $r8$lambda$0HSsKCeqxXVQrUXALZss23h1qYk(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->onCameraItemClick$lambda$28(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$0yTQcC2cTH--sRky-ZIhQ8NYe8U(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.widget.CompoundButton  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->onViewCreated$lambda$12(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Landroid/widget/CompoundButton; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$39mTm9kIXs3H2inmi-KgSLWhvqo(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  java.lang.String[])kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requestPermissionsIfNeeded$lambda$19(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; [Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$6qPh_caO7G2FErDIx7J8JUZs6Ds(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->onViewCreated$lambda$11(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Bb5IeMmlJLnp4gX22IB4zmQdJA0(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->onViewCreated$lambda$14(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$JGeoRI5E433g4nSIy5Dc6pKZvUY(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  com.bytedance.trae.conversation.mediachoose.model.MediaItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->onViewCreated$lambda$16(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$KM9YXA8JjMc5nVQtWm-Zrh5qKRo(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  androidx.activity.result.ActivityResult)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->previewLauncher$lambda$7(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Landroidx/activity/result/ActivityResult;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$QEGmnZo4Zo2quaXr3kgNlt0FHac(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  java.lang.Boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->takePictureLauncher$lambda$4(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$VzQJawYPk8CC5zgc7khhqxFRu1Q(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  java.util.Map)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->permissionLauncher$lambda$1(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Ljava/util/Map;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ZNek5mWOVA2fzWENISJI4jEw0Bw(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requestPermissionsIfNeeded$lambda$20(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$_LevnAgJQqwDb8kuYEH4WVik3Lw(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->onViewCreated$lambda$8(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$c40S8hBMnwmwjX1gZDcqZ4J5Fw4(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->onViewCreated$lambda$13(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ebWVjX3O-8AfPOi0j2L2K6CLvHE(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->onViewCreated$lambda$9(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$j3qdA6irxU8OeUleo7Q3Zuq6ZUw(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->onViewCreated$lambda$15(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$jXIcn_4bGEnJBtE1FuWAp9xa25Y(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  int)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->onViewCreated$lambda$17(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$tO5HVVwoQjXBSv3bWBvJnwvHZ0I(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.view.MenuItem)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->showBucketMenu$lambda$22(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Landroid/view/MenuItem;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$vEWOU_N0JMSeaic2yOdar9sWZ2k(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  java.lang.Boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->cameraPermissionLauncher$lambda$2(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Ljava/lang/Boolean;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->Companion Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Landroidx/fragment/app/Fragment;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->buckets Ljava/util/List;
    const-wide/16 v0, -1
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->currentBucketId J
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->mediaItems Ljava/util/ArrayList;
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->hasMore Z
    const-wide/32 v0, 104857600
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->singleMaxSize J
    const-wide v0, 9223372036854775807
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->maxTotalSize J
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda4;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    const-string v1, "registerForActivityResult(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->permissionLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda5;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->cameraPermissionLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda6;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->takePictureLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda7;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->previewLauncher Landroidx/activity/result/ActivityResultLauncher;
    return-void 
.end method

.method public static final synthetic access$getAdapter$p(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->adapter Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
    return-object v0
.end method

.method public static final synthetic access$getBinding(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)com.bytedance.trae.conversation.databinding.TraeMediaChooseFragmentBinding
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getBuckets$p(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->buckets Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getConfig$p(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)com.bytedance.trae.conversation.mediachoose.model.MediaChooseConfig
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    return-object v0
.end method

.method public static final synthetic access$getCurrentBucketId$p(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->currentBucketId J
    return-wide v0
.end method

.method public static final synthetic access$getMediaItems$p(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)java.util.ArrayList
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->mediaItems Ljava/util/ArrayList;
    return-object v0
.end method

.method public static final synthetic access$getOffset$p(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->offset I
    return v0
.end method

.method public static final synthetic access$getRepository$p(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)com.bytedance.trae.conversation.mediachoose.data.MediaStoreRepository
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->repository Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;
    return-object v0
.end method

.method public static final synthetic access$getSelection$p(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)com.bytedance.trae.conversation.mediachoose.ui.MediaSelection
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    return-object v0
.end method

.method public static final synthetic access$loadNextPageIfNeed(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->loadNextPageIfNeed()V
    return-void 
.end method

.method public static final synthetic access$resetAndReload(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->resetAndReload()V
    return-void 
.end method

.method public static final synthetic access$setBuckets$p(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  java.util.List)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->buckets Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$setCurrentBucketId$p(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->currentBucketId J
    return-void 
.end method

.method public static final synthetic access$setHasMore$p(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->hasMore Z
    return-void 
.end method

.method public static final synthetic access$setOffset$p(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->offset I
    return-void 
.end method

.method private static final cameraPermissionLauncher$lambda$2(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  java.lang.Boolean)void
    .registers 3
    # ins_size=2
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    if-nez v2, +011h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_camera_permission_denied I
    const/4 v0, 0
    invoke-static v1, v2, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    return-void 
    invoke-direct v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->openCamera()V
    return-void 
.end method

.method private final createImageUri()android.net.Uri
    .registers 6
    # ins_size=1
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v0
    new-instance v1, Landroid/content/ContentValues;
    invoke-direct v1, Landroid/content/ContentValues;-><init>()V
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, trae_media_choose_
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    invoke-virtual v2, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ".jpg"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "_display_name"
    invoke-virtual v1, v3, v2, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "mime_type"
    const-string v3, "image/jpeg"
    invoke-virtual v1, v2, v3, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    sget v2, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v3, 29
    if-lt v2, v3, +009h
    const-string v2, "relative_path"
    const-string v3, "Pictures/TraeMediaChoose"
    invoke-virtual v1, v2, v3, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI Landroid/net/Uri;
    invoke-virtual v0, v2, v1, Landroid/content/ContentResolver;->insert(Landroid/net/Uri; Landroid/content/ContentValues;)Landroid/net/Uri;
    move-result-object v0
    return-object v0
.end method

.method private final getBinding()com.bytedance.trae.conversation.databinding.TraeMediaChooseFragmentBinding
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v0
.end method

.method private final isPartialMediaPermissionGranted()boolean
    .registers 6
    # ins_size=1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 34
    const/4 v2, 0
    if-ge v0, v1, +003h
    return v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v0
    const/4 v1, 1
    if-nez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    const-string v4, "android.permission.READ_MEDIA_IMAGES"
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v3
    if-nez v3, +004h
    move v3, v1
    goto +2h
    move v3, v2
    if-eqz v0, +005h
    if-nez v3, +003h
    move v2, v1
    return v2
.end method

.method private final loadNextPageIfNeed()void
    .registers 8
    # ins_size=1
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->hasMore Z
    if-nez v0, +003h
    return-void 
    iget-object v0, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->loadJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-eqz v1, +003h
    return-void 
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->loadJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final onCameraItemClick()void
    .registers 13
    # ins_size=1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "android.permission.CAMERA"
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v0
    if-eqz v0, +025h
    sget-object v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->Companion Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string/jumbo v0, requireContext(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_permission_camera I
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_camera_title I
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_camera_message I
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_allow I
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_deny I
    new-instance v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda0;
    invoke-direct v8, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    const/4 v9, 0
    const/16 v10, 128
    const/4 v11, 0
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForPermission$default(Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion; Landroid/content/Context; I I I I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    return-void 
    invoke-direct v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->openCamera()V
    return-void 
.end method

.method private static final onCameraItemClick$lambda$28(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)kotlin.Unit
    .registers 2
    # ins_size=1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->cameraPermissionLauncher Landroidx/activity/result/ActivityResultLauncher;
    const-string v0, "android.permission.CAMERA"
    invoke-virtual v1, v0, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$11(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.view.View)void
    .registers 5
    # ins_size=2
    new-instance v4, Landroid/content/Intent;
    const-string v0, "android.settings.APPLICATION_DETAILS_SETTINGS"
    invoke-direct v4, v0, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    const-string v2, "package"
    invoke-static v2, v0, v1, Landroid/net/Uri;->fromParts(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v0
    invoke-virtual v4, v0, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$12(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.widget.CompoundButton  boolean)void
    .registers 3
    # ins_size=3
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v0, +009h
    const-string/jumbo v0, selection
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->setKeepOrigin(Z)V
    return-void 
.end method

.method private static final onViewCreated$lambda$13(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.view.View)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v2, +009h
    const-string/jumbo v2, selection
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selectedItems()Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    const/4 v0, 0
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->openPreview(Ljava/util/List; I)V
    return-void 
.end method

.method private static final onViewCreated$lambda$14(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->sendAndFinish()V
    return-void 
.end method

.method private static final onViewCreated$lambda$15(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->onCameraItemClick()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onViewCreated$lambda$16(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  com.bytedance.trae.conversation.mediachoose.model.MediaItem)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->toggleSelection(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$17(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  int)kotlin.Unit
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->adapter Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
    if-nez v0, +008h
    const-string v0, "adapter"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->currentMediaItems()Ljava/util/List;
    move-result-object v0
    const/4 v1, 0
    if-ltz v4, +00ch
    move-object v2, v0
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->size()I
    move-result v2
    if-ge v4, v2, +003h
    const/4 v1, 1
    if-eqz v1, +005h
    invoke-direct v3, v0, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->openPreview(Ljava/util/List; I)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final onViewCreated$lambda$8(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v0
    invoke-virtual v0, Landroidx/activity/OnBackPressedDispatcher;->onBackPressed()V
    return-void 
.end method

.method private static final onViewCreated$lambda$9(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->showBucketMenu()V
    return-void 
.end method

.method private final openCamera()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->createImageUri()Landroid/net/Uri;
    move-result-object v0
    if-nez v0, +014h
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_camera_create_failed I
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
    iput-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->pendingCameraUri Landroid/net/Uri;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->takePictureLauncher Landroidx/activity/result/ActivityResultLauncher;
    invoke-virtual v1, v0, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    return-void 
.end method

.method private final openPreview(java.util.List  int)void
    .registers 6
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;->INSTANCE Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;->setPreviewItemsCache(Ljava/util/List;)V
    new-instance v4, Landroid/content/Intent;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;
    invoke-direct v4, v0, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string/jumbo v0, trae_media_choose_extra_preview_index
    invoke-virtual v4, v0, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; I)Landroid/content/Intent;
    iget-object v5, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    const/4 v0, 0
    if-nez v5, +008h
    const-string v5, "config"
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v0
    check-cast v5, Landroid/os/Parcelable;
    const-string/jumbo v1, trae_media_choose_extra_preview_config
    invoke-virtual v4, v1, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Landroid/os/Parcelable;)Landroid/content/Intent;
    iget-object v5, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    const-string/jumbo v1, selection
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->getKeepOrigin()Z
    move-result v5
    const-string/jumbo v2, trae_media_choose_extra_preview_keep_origin
    invoke-virtual v4, v2, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    iget-object v5, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v5
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selectedItems()Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v5, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v1
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toLongArray(Ljava/util/Collection;)[J
    move-result-object v5
    const-string/jumbo v0, trae_media_choose_extra_preview_selected_ids
    invoke-virtual v4, v0, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; [J)Landroid/content/Intent;
    const-string/jumbo v5, trae_media_choose_max_total_size
    iget-wide v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->maxTotalSize J
    invoke-virtual v4, v5, v0, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    const-string/jumbo v5, trae_media_choose_single_size
    iget-wide v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->singleMaxSize J
    invoke-virtual v4, v5, v0, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    iget-object v5, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->previewLauncher Landroidx/activity/result/ActivityResultLauncher;
    invoke-virtual v5, v4, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final permissionLauncher$lambda$1(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  java.util.Map)void
    .registers 5
    # ins_size=2
    invoke-interface v4, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    instance-of v0, v4, Ljava/util/Collection;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00dh
    move-object v0, v4
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +004h
    move v4, v2
    goto +18h
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, -00ah
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    if-nez v0, -010h
    move v4, v1
    if-eqz v4, +006h
    invoke-direct v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->startLoad()V
    return-void 
    sget v4, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v0, 34
    if-lt v4, v0, +016h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    const-string v0, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"
    invoke-static v4, v0, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v4
    if-nez v4, +003h
    goto +2h
    move v2, v1
    if-eqz v2, +006h
    invoke-direct v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->startLoad()V
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_permission_denied I
    invoke-static v3, v4, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final previewLauncher$lambda$7(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  androidx.activity.result.ActivityResult)void
    .registers 11
    # ins_size=2
    invoke-virtual v10, Landroidx/activity/result/ActivityResult;->getResultCode()I
    move-result v0
    const/4 v1, 0
    const/4 v2, -1
    if-ne v0, v2, +04dh
    invoke-virtual v10, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v10
    if-nez v10, +003h
    return-void 
    const-string/jumbo v0, trae_media_choose_result_selected
    invoke-virtual v10, v0, Landroid/content/Intent;->getParcelableArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;
    move-result-object v3
    check-cast v3, Ljava/util/List;
    if-nez v3, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v3
    const-string/jumbo v4, trae_media_choose_result_keep_origin
    invoke-virtual v10, v4, v1, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String; Z)Z
    move-result v5
    const-string/jumbo v6, trae_media_choose_result_has_video
    invoke-virtual v10, v6, v1, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String; Z)Z
    move-result v10
    invoke-virtual v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    new-instance v7, Landroid/content/Intent;
    invoke-direct v7, Landroid/content/Intent;-><init>()V
    new-instance v8, Ljava/util/ArrayList;
    check-cast v3, Ljava/util/Collection;
    invoke-direct v8, v3, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    invoke-virtual v7, v0, v8, Landroid/content/Intent;->putParcelableArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    invoke-virtual v7, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    invoke-virtual v7, v6, v10, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, v7, Landroidx/fragment/app/FragmentActivity;->setResult(I Landroid/content/Intent;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v9
    invoke-virtual v9, Landroidx/fragment/app/FragmentActivity;->finish()V
    goto/16 +095h
    invoke-virtual v10, Landroidx/activity/result/ActivityResult;->getResultCode()I
    move-result v0
    const/4 v2, 2
    if-ne v0, v2, +08eh
    invoke-virtual v10, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v10
    if-nez v10, +003h
    return-void 
    const-string/jumbo v0, trae_media_choose_result_back_selected_ids
    invoke-virtual v10, v0, Landroid/content/Intent;->getLongArrayExtra(Ljava/lang/String;)[J
    move-result-object v0
    if-eqz v0, +07eh
    invoke-static v0, Lkotlin/collections/ArraysKt;->toSet([J)Ljava/util/Set;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +076h
    const-string/jumbo v2, trae_media_choose_result_back_keep_origin
    invoke-virtual v10, v2, v1, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String; Z)Z
    move-result v10
    iget-object v1, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    const-string/jumbo v2, selection
    const/4 v3, 0
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v4, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->mediaItems Ljava/util/ArrayList;
    check-cast v4, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +01bh
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v7
    invoke-static v7, v8, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v7
    invoke-interface v0, v7, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, -019h
    invoke-interface v5, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1eh
    check-cast v5, Ljava/util/List;
    invoke-virtual v1, v5, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->setSelected(Ljava/util/List;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    invoke-virtual v0, v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->setKeepOrigin(Z)V
    invoke-direct v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->cbOrigin Landroid/widget/CheckBox;
    invoke-virtual v0, v10, Landroid/widget/CheckBox;->setChecked(Z)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->adapter Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
    if-nez v10, +008h
    const-string v10, "adapter"
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v3
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v0
    invoke-virtual v10, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->updateSelection(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;)V
    invoke-direct v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->updateBottomBar()V
    nop 
    return-void 
.end method

.method private final requestPermissionsIfNeeded()void
    .registers 13
    # ins_size=1
    iget-object v0, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v0, +008h
    const-string v0, "config"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getMediaType()Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    move-result-object v0
    invoke-direct v12, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requiredReadPermissions(Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;)[Ljava/lang/String;
    move-result-object v0
    array-length v1, v0
    const/4 v2, 0
    move v3, v2
    if-ge v3, v1, +019h
    aget-object v4, v0, v3
    invoke-virtual v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v5
    invoke-static v5, v4, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v4
    const/4 v5, 1
    if-eqz v4, +004h
    move v4, v5
    goto +2h
    move v4, v2
    if-eqz v4, +004h
    move v2, v5
    goto +4h
    add-int/lit8 v3, v3, 1
    goto -18h
    if-nez v2, +006h
    invoke-direct v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->startLoad()V
    return-void 
    sget-object v3, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->Companion Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    const-string/jumbo v1, requireContext(...)
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v5, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_permission_photo I
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_photo_title I
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_photo_message I
    sget v8, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_allow I
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_deny I
    new-instance v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda8;
    invoke-direct v10, v12, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; [Ljava/lang/String;)V
    new-instance v11, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda9;
    invoke-direct v11, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    invoke-virtual/range v3 ... v11, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForPermission(Landroid/content/Context; I I I I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    return-void 
.end method

.method private static final requestPermissionsIfNeeded$lambda$19(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  java.lang.String[])kotlin.Unit
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->permissionLauncher Landroidx/activity/result/ActivityResultLauncher;
    invoke-virtual v0, v1, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final requestPermissionsIfNeeded$lambda$20(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->finish()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final requiredReadPermissions(com.bytedance.trae.conversation.mediachoose.model.MediaType)java.lang.String[]
    .registers 5
    # ins_size=2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 34
    const-string v2, "android.permission.READ_MEDIA_IMAGES"
    if-lt v0, v1, +02eh
    sget-object v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->ordinal()I
    move-result v4
    aget v4, v0, v4
    const/4 v0, 1
    const-string v1, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"
    if-eq v4, v0, +01ch
    const/4 v0, 2
    if-eq v4, v0, +014h
    const/4 v0, 3
    if-eq v4, v0, +00ch
    const/4 v0, 4
    if-ne v4, v0, +003h
    goto +7h
    new-instance v4, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v4, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v4
    filled-new-array v2, v1, [Ljava/lang/String;
    move-result-object v4
    goto +1ch
    filled-new-array v2, v1, [Ljava/lang/String;
    move-result-object v4
    goto +17h
    filled-new-array v2, v1, [Ljava/lang/String;
    move-result-object v4
    goto +12h
    sget v4, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v0, 33
    if-lt v4, v0, +007h
    filled-new-array v2, [Ljava/lang/String;
    move-result-object v4
    goto +7h
    const-string v4, "android.permission.READ_EXTERNAL_STORAGE"
    filled-new-array v4, [Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method

.method private final resetAndReload()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->mediaItems Ljava/util/ArrayList;
    invoke-virtual v0, Ljava/util/ArrayList;->clear()V
    const/4 v0, 0
    iput v0, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->offset I
    const/4 v0, 1
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->hasMore Z
    iget-object v0, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->adapter Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "adapter"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->mediaItems Ljava/util/ArrayList;
    check-cast v2, Ljava/util/List;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v3, +008h
    const-string v3, "config"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getShowCamera()Z
    move-result v1
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->submit(Ljava/util/List; Z)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->loadNextPageIfNeed()V
    return-void 
.end method

.method private final sendAndFinish()void
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    const/4 v1, 0
    const-string/jumbo v2, selection
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selectedItems()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    move-object v3, v0
    check-cast v3, Ljava/lang/Iterable;
    instance-of v4, v3, Ljava/util/Collection;
    const/4 v5, 0
    if-eqz v4, +00ch
    move-object v4, v3
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +003h
    goto +18h
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +00fh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo()Z
    move-result v4
    if-eqz v4, -010h
    const/4 v5, 1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v3
    new-instance v4, Landroid/content/Intent;
    invoke-direct v4, Landroid/content/Intent;-><init>()V
    new-instance v6, Ljava/util/ArrayList;
    check-cast v0, Ljava/util/Collection;
    invoke-direct v6, v0, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    const-string/jumbo v0, trae_media_choose_result_selected
    invoke-virtual v4, v0, v6, Landroid/content/Intent;->putParcelableArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    iget-object v0, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->getKeepOrigin()Z
    move-result v0
    const-string/jumbo v1, trae_media_choose_result_keep_origin
    invoke-virtual v4, v1, v0, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    const-string/jumbo v0, trae_media_choose_result_has_video
    invoke-virtual v4, v0, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v0, -1
    invoke-virtual v3, v0, v4, Landroidx/fragment/app/FragmentActivity;->setResult(I Landroid/content/Intent;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->finish()V
    return-void 
.end method

.method private final showBucketMenu()void
    .registers 11
    # ins_size=1
    iget-object v0, v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->buckets Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    new-instance v0, Landroid/widget/PopupMenu;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    invoke-direct v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v2
    iget-object v2, v2, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    check-cast v2, Landroid/view/View;
    invoke-direct v0, v1, v2, Landroid/widget/PopupMenu;-><init>(Landroid/content/Context; Landroid/view/View;)V
    iget-object v1, v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->buckets Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    move v3, v2
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +034h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    add-int/lit8 v5, v3, 1
    if-gez v3, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v4, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    invoke-virtual v0, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_bucket_item I
    const/4 v8, 2
    new-array v8, v8, [Ljava/lang/Object;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->getName()Ljava/lang/String;
    move-result-object v9
    aput-object v9, v8, v2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->getCount()I
    move-result v4
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const/4 v9, 1
    aput-object v4, v8, v9
    invoke-virtual v10, v7, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v6, v2, v3, v3, v4, Landroid/view/Menu;->add(I I I Ljava/lang/CharSequence;)Landroid/view/MenuItem;
    move v3, v5
    goto -37h
    new-instance v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda3;
    invoke-direct v1, v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    invoke-virtual v0, v1, Landroid/widget/PopupMenu;->setOnMenuItemClickListener(Landroid/widget/PopupMenu$OnMenuItemClickListener;)V
    invoke-virtual v0, Landroid/widget/PopupMenu;->show()V
    return-void 
.end method

.method private static final showBucketMenu$lambda$22(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  android.view.MenuItem)boolean
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->buckets Ljava/util/List;
    invoke-interface v3, Landroid/view/MenuItem;->getItemId()I
    move-result v3
    invoke-static v0, v3, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    if-nez v3, +004h
    const/4 v2, 0
    return v2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->getId()J
    move-result-wide v0
    iput-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->currentBucketId J
    invoke-direct v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->getName()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(Ljava/lang/CharSequence;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->resetAndReload()V
    const/4 v2, 1
    return v2
.end method

.method private final startLoad()void
    .registers 8
    # ins_size=1
    invoke-direct v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->updatePartialPermissionNotice()V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final takePictureLauncher$lambda$4(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  java.lang.Boolean)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->pendingCameraUri Landroid/net/Uri;
    const/4 v1, 0
    iput-object v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->pendingCameraUri Landroid/net/Uri;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    if-eqz v3, +006h
    invoke-direct v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->resetAndReload()V
    goto +eh
    if-eqz v0, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    invoke-virtual v2, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v2
    invoke-virtual v2, v0, v1, v1, Landroid/content/ContentResolver;->delete(Landroid/net/Uri; Ljava/lang/String; [Ljava/lang/String;)I
    return-void 
.end method

.method private final toggleSelection(com.bytedance.trae.conversation.mediachoose.model.MediaItem)void
    .registers 11
    # ins_size=2
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo()Z
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-nez v0, +038h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getSizeBytes()J
    move-result-wide v3
    iget-wide v5, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->singleMaxSize J
    cmp-long v0, v3, v5
    if-lez v0, +02eh
    invoke-virtual v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v10
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_file_too_large I
    new-array v1, v1, [Ljava/lang/Object;
    iget-wide v3, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->singleMaxSize J
    const/16 v5, 1024
    int-to-long v5, v5
    div-long/2addr v3, v5
    div-long/2addr v3, v5
    invoke-static v3, v4, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    aput-object v3, v1, v2
    invoke-virtual v10, v0, v1, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    const-string v0, "getString(...)"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v0, v10, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v10
    invoke-virtual v10, Landroid/widget/Toast;->show()V
    return-void 
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    const-string/jumbo v3, selection
    const/4 v4, 0
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v5
    invoke-virtual v0, v5, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->isSelected(J)Z
    move-result v0
    if-nez v0, +04ch
    iget-wide v5, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->maxTotalSize J
    const-wide v7, 9223372036854775807
    cmp-long v0, v5, v7
    if-eqz v0, +041h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
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
    iget-wide v7, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->maxTotalSize J
    cmp-long v0, v5, v7
    if-lez v0, +010h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v10
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_total_size_too_large I
    invoke-static v10, v0, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v10
    invoke-virtual v10, Landroid/widget/Toast;->show()V
    return-void 
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v0, v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->toggle(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    move-result-object v10
    sget-object v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->ordinal()I
    move-result v5
    aget v0, v0, v5
    const-string v5, "config"
    if-eq v0, v1, +020h
    const/4 v6, 2
    if-eq v0, v6, +00fh
    const/4 v6, 3
    if-eq v0, v6, +041h
    const/4 v6, 4
    if-ne v0, v6, +003h
    goto +3ch
    new-instance v10, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v10, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v10
    invoke-virtual v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_exclusive_tips I
    invoke-static v0, v6, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    goto +28h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_reach_max I
    new-array v7, v1, [Ljava/lang/Object;
    iget-object v8, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v8, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v4
    invoke-virtual v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getMaxSelectCount()I
    move-result v8
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    aput-object v8, v7, v2
    invoke-virtual v9, v6, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v0, v6, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getMaxSelectCount()I
    move-result v0
    if-ne v0, v1, +011h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getShowSingleSelector()Z
    move-result v0
    if-nez v0, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +00ah
    sget-object v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->Added Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    if-ne v10, v0, +006h
    invoke-direct v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->sendAndFinish()V
    return-void 
    iget-object v10, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->adapter Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
    if-nez v10, +008h
    const-string v10, "adapter"
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v4
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v0
    invoke-virtual v10, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->updateSelection(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;)V
    invoke-direct v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->updateBottomBar()V
    return-void 
.end method

.method private final updateBottomBar()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, selection
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selectedCount()I
    move-result v0
    invoke-direct v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v2
    iget-object v2, v2, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->btnPreview Landroid/widget/TextView;
    const/4 v3, 0
    if-lez v0, +004h
    move v4, v3
    goto +3h
    const/16 v4, 8
    invoke-virtual v2, v4, Landroid/widget/TextView;->setVisibility(I)V
    if-lez v0, +041h
    invoke-direct v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v2
    iget-object v2, v2, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->btnSend Landroid/widget/TextView;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setVisibility(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v2
    iget-object v2, v2, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->btnSend Landroid/widget/TextView;
    const/4 v4, 1
    invoke-virtual v2, v4, Landroid/widget/TextView;->setEnabled(Z)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v2
    iget-object v2, v2, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->btnSend Landroid/widget/TextView;
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_send_with_count I
    const/4 v6, 2
    new-array v6, v6, [Ljava/lang/Object;
    iget-object v7, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v7, +008h
    const-string v7, "config"
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v7
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getActionText()Ljava/lang/String;
    move-result-object v1
    aput-object v1, v6, v3
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    aput-object v0, v6, v4
    invoke-virtual v8, v5, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v2, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +bh
    invoke-direct v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->btnSend Landroid/widget/TextView;
    const/4 v1, 4
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    return-void 
.end method

.method private final updatePartialPermissionNotice()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->partialPermissionNotice Landroid/widget/TextView;
    invoke-direct v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->isPartialMediaPermissionGranted()Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 0
    goto +3h
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    return-void 
.end method

.method public onCreate(android.os.Bundle)void
    .registers 32
    # ins_size=2
    move-object/from16 v0, v30
    invoke-super/range v30 ... v31, Landroidx/fragment/app/Fragment;->onCreate(Landroid/os/Bundle;)V
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_send I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    const-string v2, "getString(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v2
    invoke-virtual v2, Landroidx/fragment/app/FragmentActivity;->getIntent()Landroid/content/Intent;
    move-result-object v2
    const-string/jumbo v3, trae_media_choose_extra_config
    invoke-virtual v2, v3, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v2, +015h
    new-instance v15, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 895
    const/4 v14, 0
    move-object v2, v15
    move-object v10, v1
    invoke-direct/range v2 ... v14, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;-><init>(I Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; Z Z Z Z Z Ljava/lang/String; I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v2
    invoke-virtual v2, Landroidx/fragment/app/FragmentActivity;->getIntent()Landroid/content/Intent;
    move-result-object v2
    const-string/jumbo v3, trae_media_choose_max_count
    const-wide/16 v4, 5
    invoke-virtual v2, v3, v4, v5, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v2
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v4
    invoke-virtual v4, Landroidx/fragment/app/FragmentActivity;->getIntent()Landroid/content/Intent;
    move-result-object v4
    const-string/jumbo v5, trae_media_choose_single_size
    const-wide/32 v6, 104857600
    invoke-virtual v4, v5, v6, v7, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v4
    iput-wide v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->singleMaxSize J
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v4
    invoke-virtual v4, Landroidx/fragment/app/FragmentActivity;->getIntent()Landroid/content/Intent;
    move-result-object v4
    const-string/jumbo v5, trae_media_choose_max_total_size
    const-wide v6, 9223372036854775807
    invoke-virtual v4, v5, v6, v7, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v4
    iput-wide v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->maxTotalSize J
    iget-object v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    const-string v15, "config"
    const/16 v16, 0
    if-nez v4, +008h
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object/from16 v17, v16
    goto +3h
    move-object/from16 v17, v4
    long-to-int v2, v2
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 1022
    const/16 v29, 0
    move/from16 v18, v2
    invoke-static/range v17 ... v29, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->copy$default(Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig; I Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; Z Z Z Z Z Ljava/lang/String; I Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    move-result-object v2
    iput-object v2, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v2, +007h
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object/from16 v2, v16
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getActionText()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    const/16 v17, 1
    const/16 v18, 0
    if-nez v2, +005h
    move/from16 v2, v17
    goto +3h
    move/from16 v2, v18
    if-eqz v2, +01eh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v2, +007h
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object/from16 v2, v16
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 895
    const/4 v14, 0
    move-object v10, v1
    invoke-static/range v2 ... v14, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->copy$default(Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig; I Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; Z Z Z Z Z Ljava/lang/String; I Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    new-instance v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string/jumbo v3, requireContext(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;-><init>(Landroid/content/Context;)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->repository Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;
    new-instance v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v2, +007h
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object/from16 v2, v16
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;-><init>(Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string/jumbo v2, trae_media_choose_extra_initial_selected
    invoke-virtual v1, v2, Landroid/content/Intent;->getParcelableArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/util/Collection;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move/from16 v17, v18
    if-nez v17, +013h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v2, +00ah
    const-string/jumbo v2, selection
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object/from16 v2, v16
    check-cast v1, Ljava/util/List;
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->setSelected(Ljava/util/List;)V
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 4
    # ins_size=4
    const-string v3, "inflater"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    invoke-static v1, v2, v3, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v1
    const-string v2, "getRoot(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method public onDestroyView()void
    .registers 4
    # ins_size=1
    invoke-super v3, Landroidx/fragment/app/Fragment;->onDestroyView()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->loadJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 9
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v6, v7, v8, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v7
    iget-object v7, v7, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda10;
    invoke-direct v8, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    invoke-virtual v7, v8, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v7
    iget-object v7, v7, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda11;
    invoke-direct v8, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda11;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    invoke-virtual v7, v8, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnTitleClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v7
    iget-object v7, v7, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->partialPermissionNotice Landroid/widget/TextView;
    new-instance v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda12;
    invoke-direct v8, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    invoke-virtual v7, v8, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v7
    iget-object v7, v7, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->cbOrigin Landroid/widget/CheckBox;
    iget-object v8, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    const-string v0, "config"
    const/4 v1, 0
    if-nez v8, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getShowOrigin()Z
    move-result v8
    if-eqz v8, +004h
    const/4 v8, 0
    goto +3h
    const/16 v8, 8
    invoke-virtual v7, v8, Landroid/widget/CheckBox;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v7
    iget-object v7, v7, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->cbOrigin Landroid/widget/CheckBox;
    iget-object v8, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    const-string/jumbo v2, selection
    if-nez v8, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->getKeepOrigin()Z
    move-result v8
    invoke-virtual v7, v8, Landroid/widget/CheckBox;->setChecked(Z)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v7
    iget-object v7, v7, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->cbOrigin Landroid/widget/CheckBox;
    new-instance v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda13;
    invoke-direct v8, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda13;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    invoke-virtual v7, v8, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v7
    iget-object v7, v7, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->btnPreview Landroid/widget/TextView;
    new-instance v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda14;
    invoke-direct v8, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda14;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    invoke-virtual v7, v8, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v7
    iget-object v7, v7, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->btnSend Landroid/widget/TextView;
    new-instance v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda15;
    invoke-direct v8, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda15;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    invoke-virtual v7, v8, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
    new-instance v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda16;
    invoke-direct v8, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda16;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    new-instance v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda1;
    invoke-direct v3, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    new-instance v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda2;
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    iget-object v5, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v5, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v1
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getEnablePreview()Z
    move-result v5
    invoke-direct v7, v8, v3, v4, v5, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Z)V
    iput-object v7, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->adapter Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
    new-instance v7, Landroidx/recyclerview/widget/GridLayoutManager;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requireContext()Landroid/content/Context;
    move-result-object v8
    iget-object v3, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    if-nez v3, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getColumnCount()I
    move-result v0
    invoke-direct v7, v8, v0, Landroidx/recyclerview/widget/GridLayoutManager;-><init>(Landroid/content/Context; I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v8
    iget-object v8, v8, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->rv Landroidx/recyclerview/widget/RecyclerView;
    move-object v0, v7
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v8, v0, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v8
    iget-object v8, v8, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->rv Landroidx/recyclerview/widget/RecyclerView;
    iget-object v0, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->adapter Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
    const-string v3, "adapter"
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v8, v0, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v8
    iget-object v8, v8, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->rv Landroidx/recyclerview/widget/RecyclerView;
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$onViewCreated$10;
    invoke-direct v0, v7, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$onViewCreated$10;-><init>(Landroidx/recyclerview/widget/GridLayoutManager; Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
    invoke-virtual v8, v0, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->adapter Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
    if-nez v7, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v1
    iget-object v8, v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    if-nez v8, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v8
    invoke-virtual v7, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->updateSelection(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->updateBottomBar()V
    invoke-direct v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->requestPermissionsIfNeeded()V
    return-void 
.end method
