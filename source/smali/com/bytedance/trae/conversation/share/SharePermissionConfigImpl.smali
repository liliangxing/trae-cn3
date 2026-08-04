# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl;
.super Ljava/lang/Object;
.source "SharePermissionConfigImpl.kt"

.implements Lcom/bytedance/ug/sdk/share/api/depend/ISharePermissionConfig;


.method public static synthetic $r8$lambda$2FTUulgr824zgbZY8nK0CSn4qdI(com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback  boolean)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl;->requestPermissions$lambda$1$lambda$0(Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback; Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$NVaNPqUJWqjMCPAGtM8u9kHWqsk(com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl;->requestPermissions$lambda$2(Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$nECfV18HGaZbQEB16TAboKKenw4(android.app.Activity  java.lang.String[]  com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl;->requestPermissions$lambda$1(Landroid/app/Activity; [Ljava/lang/String; Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final requestPermissions$lambda$1(android.app.Activity  java.lang.String[]  com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback)kotlin.Unit
    .registers 5
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/products/PermissionService;->INSTANCE Lcom/bytedance/trae/conversation/products/PermissionService;
    check-cast v2, Landroidx/fragment/app/FragmentActivity;
    invoke-static v3, Lkotlin/collections/ArraysKt;->toList([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    new-instance v1, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda0;
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;)V
    invoke-virtual v0, v2, v3, v1, Lcom/bytedance/trae/conversation/products/PermissionService;->permission(Landroidx/fragment/app/FragmentActivity; Ljava/util/List; Lkotlin/jvm/functions/Function1;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final requestPermissions$lambda$1$lambda$0(com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback  boolean)kotlin.Unit
    .registers 2
    # ins_size=2
    if-eqz v1, +006h
    invoke-interface v0, Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;->onGranted()V
    goto +6h
    const-string v1, ""
    invoke-interface v0, v1, Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;->onDenied(Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final requestPermissions$lambda$2(com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, ""
    invoke-interface v1, v0, Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;->onDenied(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public hasPermission(android.content.Context  java.lang.String)boolean
    .registers 4
    # ins_size=3
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "permission"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method public requestPermissions(android.app.Activity  java.lang.String[]  com.bytedance.ug.sdk.share.api.entity.ShareContent  com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback)void
    .registers 14
    # ins_size=5
    const-string v0, "activity"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "permissions"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, shareContent
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v12, "callback"
    invoke-static v13, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v12, v10, Landroidx/fragment/app/FragmentActivity;
    if-eqz v12, +01eh
    sget-object v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->Companion Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
    move-object v1, v10
    check-cast v1, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_permission_file I
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_storage_title I
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_storage_message I
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_allow I
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_deny I
    new-instance v7, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda1;
    invoke-direct v7, v10, v11, v13, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda1;-><init>(Landroid/app/Activity; [Ljava/lang/String; Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;)V
    new-instance v8, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda2;
    invoke-direct v8, v13, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;)V
    invoke-virtual/range v0 ... v8, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForPermission(Landroid/content/Context; I I I I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    return-void 
.end method
