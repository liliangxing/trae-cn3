# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/PermissionService;
.super Ljava/lang/Object;
.source "PermissionService.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/products/PermissionService;
.field private static final TAG_PERMISSION_FRAGMENT:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/PermissionService;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/PermissionService;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/PermissionService;->INSTANCE Lcom/bytedance/trae/conversation/products/PermissionService;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final permission(androidx.fragment.app.FragmentActivity  java.util.List  kotlin.jvm.functions.Function1)void
    .registers 7
    # ins_size=4
    const-string v0, "activity"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "permissions"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v4
    const-string v0, "getSupportFragmentManager(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "PermissionServiceFragment"
    invoke-virtual v4, v0, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v1
    instance-of v2, v1, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;
    if-eqz v2, +005h
    check-cast v1, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;
    goto +2h
    const/4 v1, 0
    if-eqz v1, +00fh
    invoke-virtual v4, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v2
    check-cast v1, Landroidx/fragment/app/Fragment;
    invoke-virtual v2, v1, Landroidx/fragment/app/FragmentTransaction;->remove(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentTransaction;->commitNowAllowingStateLoss()V
    sget-object v1, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->Companion Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment$Companion;
    invoke-virtual v1, v5, v6, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment$Companion;->newInstance(Ljava/util/List; Lkotlin/jvm/functions/Function1;)Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;
    move-result-object v5
    invoke-virtual v4, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v4
    check-cast v5, Landroidx/fragment/app/Fragment;
    invoke-virtual v4, v5, v0, Landroidx/fragment/app/FragmentTransaction;->add(Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v4
    invoke-virtual v4, Landroidx/fragment/app/FragmentTransaction;->commitNowAllowingStateLoss()V
    return-void 
.end method
