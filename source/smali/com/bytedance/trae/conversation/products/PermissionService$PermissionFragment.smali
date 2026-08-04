# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;
.super Landroidx/fragment/app/Fragment;
.source "PermissionService.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment$Companion;
.field private callback:Lkotlin/jvm/functions/Function1;
.field private launched:Z
.field private final launcher:Landroidx/activity/result/ActivityResultLauncher;
.field private permissions:Ljava/util/List;


.method public static synthetic $r8$lambda$KYwCTvPcGqre7T4TqtzOcMgwTYo(com.bytedance.trae.conversation.products.PermissionService$PermissionFragment  java.util.Map)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->launcher$lambda$1(Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment; Ljava/util/Map;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->Companion Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Landroidx/fragment/app/Fragment;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->permissions Ljava/util/List;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v1, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment$$ExternalSyntheticLambda0;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;)V
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    const-string v1, "registerForActivityResult(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->launcher Landroidx/activity/result/ActivityResultLauncher;
    return-void 
.end method

.method public static final synthetic access$setCallback$p(com.bytedance.trae.conversation.products.PermissionService$PermissionFragment  kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->callback Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public static final synthetic access$setPermissions$p(com.bytedance.trae.conversation.products.PermissionService$PermissionFragment  java.util.List)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->permissions Ljava/util/List;
    return-void 
.end method

.method private static final launcher$lambda$1(com.bytedance.trae.conversation.products.PermissionService$PermissionFragment  java.util.Map)void
    .registers 4
    # ins_size=2
    invoke-interface v3, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    instance-of v0, v3, Ljava/util/Collection;
    const/4 v1, 1
    if-eqz v0, +00ch
    move-object v0, v3
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +18h
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00fh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    if-nez v0, -010h
    const/4 v1, 0
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->callback Lkotlin/jvm/functions/Function1;
    if-eqz v3, +009h
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-interface v3, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    const/4 v3, 0
    iput-object v3, v2, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->callback Lkotlin/jvm/functions/Function1;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    invoke-virtual v3, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v3
    check-cast v2, Landroidx/fragment/app/Fragment;
    invoke-virtual v3, v2, Landroidx/fragment/app/FragmentTransaction;->remove(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v2
    invoke-virtual v2, Landroidx/fragment/app/FragmentTransaction;->commitAllowingStateLoss()I
    return-void 
.end method

.method public onResume()void
    .registers 4
    # ins_size=1
    invoke-super v3, Landroidx/fragment/app/Fragment;->onResume()V
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->launched Z
    if-nez v0, +020h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->permissions Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    const/4 v1, 1
    xor-int/2addr v0, v1
    if-eqz v0, +014h
    iput-boolean v1, v3, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->launched Z
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->launcher Landroidx/activity/result/ActivityResultLauncher;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->permissions Ljava/util/List;
    check-cast v1, Ljava/util/Collection;
    const/4 v2, 0
    new-array v2, v2, [Ljava/lang/String;
    invoke-interface v1, v2, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    return-void 
.end method
