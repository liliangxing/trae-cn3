# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment$Companion;
.super Ljava/lang/Object;
.source "PermissionService.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment$Companion;-><init>()V
    return-void 
.end method

.method public final newInstance(java.util.List  kotlin.jvm.functions.Function1)com.bytedance.trae.conversation.products.PermissionService$PermissionFragment
    .registers 4
    # ins_size=3
    const-string v0, "permissions"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;-><init>()V
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->access$setPermissions$p(Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment; Ljava/util/List;)V
    invoke-static v0, v3, Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;->access$setCallback$p(Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment; Lkotlin/jvm/functions/Function1;)V
    return-object v0
.end method
