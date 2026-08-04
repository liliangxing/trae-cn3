# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
.super Ljava/lang/Object;
.source "PermissionRationaleDialog.kt"


.method public static synthetic $r8$lambda$AyXHPWASgekaNa7igHzv61AYOhU()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForPermission$lambda$0()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$XU6Y0K2u9PO9llnFtEAhlEB_5h0(android.content.Context)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showDeniedGoSettings$lambda$4(Landroid/content/Context;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$mk6HfSNZe72oEXhcmPtdYfzedv8()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForNotification$lambda$2()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$tRcZLzLhAQHfvEIvPv2kY2lEbxM()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForNotification$lambda$1()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$vckSPME2Dx_BFKFDjs1h7AWzMs0()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showDeniedGoSettings$lambda$5()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic showDeniedGoSettings$default(com.bytedance.trae.common.widget.PermissionRationaleDialog$Companion  android.content.Context  int  int  int  int  int  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  int  java.lang.Object)com.bytedance.trae.common.widget.PermissionRationaleDialog
    .registers 22
    # ins_size=11
    move/from16 v0, v20
    and-int/lit8 v1, v0, 64
    if-eqz v1, +00ah
    new-instance v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion$$ExternalSyntheticLambda1;
    move-object v3, v12
    invoke-direct v1, v12, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion$$ExternalSyntheticLambda1;-><init>(Landroid/content/Context;)V
    move-object v9, v1
    goto +4h
    move-object v3, v12
    move-object/from16 v9, v18
    and-int/lit16 v0, v0, 128
    if-eqz v0, +009h
    new-instance v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion$$ExternalSyntheticLambda2;
    invoke-direct v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion$$ExternalSyntheticLambda2;-><init>()V
    move-object v10, v0
    goto +3h
    move-object/from16 v10, v19
    move-object v2, v11
    move-object v3, v12
    move v4, v13
    move v5, v14
    move v6, v15
    move/from16 v7, v16
    move/from16 v8, v17
    invoke-virtual/range v2 ... v10, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showDeniedGoSettings(Landroid/content/Context; I I I I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    move-result-object v0
    return-object v0
.end method

.method private static final showDeniedGoSettings$lambda$4(android.content.Context)kotlin.Unit
    .registers 5
    # ins_size=1
    new-instance v0, Landroid/content/Intent;
    const-string v1, "android.settings.APPLICATION_DETAILS_SETTINGS"
    invoke-direct v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    const-string v1, "package"
    invoke-virtual v4, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    invoke-static v1, v2, v3, Landroid/net/Uri;->fromParts(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    const/high16 v1, 268435456
    invoke-virtual v0, v1, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v4, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    :try_start_0x0
.end method

.method private static final showDeniedGoSettings$lambda$5()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static synthetic showForNotification$default(com.bytedance.trae.common.widget.PermissionRationaleDialog$Companion  android.content.Context  int  int  int  int  int  int  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  int  java.lang.Object)com.bytedance.trae.common.widget.PermissionRationaleDialog
    .registers 26
    # ins_size=13
    move/from16 v0, v24
    and-int/lit16 v1, v0, 256
    if-eqz v1, +009h
    new-instance v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion$$ExternalSyntheticLambda3;
    invoke-direct v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion$$ExternalSyntheticLambda3;-><init>()V
    move-object v11, v1
    goto +3h
    move-object/from16 v11, v22
    and-int/lit16 v0, v0, 512
    if-eqz v0, +009h
    new-instance v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion$$ExternalSyntheticLambda4;
    invoke-direct v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion$$ExternalSyntheticLambda4;-><init>()V
    move-object v12, v0
    goto +3h
    move-object/from16 v12, v23
    move-object v2, v13
    move-object v3, v14
    move v4, v15
    move/from16 v5, v16
    move/from16 v6, v17
    move/from16 v7, v18
    move/from16 v8, v19
    move/from16 v9, v20
    move-object/from16 v10, v21
    invoke-virtual/range v2 ... v12, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForNotification(Landroid/content/Context; I I I I I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    move-result-object v0
    return-object v0
.end method

.method private static final showForNotification$lambda$1()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final showForNotification$lambda$2()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static synthetic showForPermission$default(com.bytedance.trae.common.widget.PermissionRationaleDialog$Companion  android.content.Context  int  int  int  int  int  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  int  java.lang.Object)com.bytedance.trae.common.widget.PermissionRationaleDialog
    .registers 21
    # ins_size=11
    move/from16 v0, v19
    and-int/lit16 v0, v0, 128
    if-eqz v0, +009h
    new-instance v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion$$ExternalSyntheticLambda0;-><init>()V
    move-object v9, v0
    goto +3h
    move-object/from16 v9, v18
    move-object v1, v10
    move-object v2, v11
    move v3, v12
    move v4, v13
    move v5, v14
    move v6, v15
    move/from16 v7, v16
    move-object/from16 v8, v17
    invoke-virtual/range v1 ... v9, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForPermission(Landroid/content/Context; I I I I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    move-result-object v0
    return-object v0
.end method

.method private static final showForPermission$lambda$0()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final showDeniedGoSettings(android.content.Context  int  int  int  int  int  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)com.bytedance.trae.common.widget.PermissionRationaleDialog
    .registers 24
    # ins_size=9
    move-object/from16 v0, v16
    const-string v1, "context"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onGoSettings"
    move-object/from16 v9, v22
    invoke-static v9, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onLater"
    move-object/from16 v10, v23
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    new-instance v14, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    move/from16 v2, v18
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v2, "getString(...)"
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v3, v19
    invoke-virtual v0, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v3, v20
    invoke-virtual v0, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v3, v21
    invoke-virtual v0, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v8, 0
    const/4 v11, 0
    const/16 v12, 288
    const/4 v13, 0
    move-object v2, v14
    move/from16 v3, v17
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;-><init>(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v1, v0, v14, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;-><init>(Landroid/content/Context; Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;)V
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->show()V
    return-object v1
.end method

.method public final showForNotification(android.content.Context  int  int  int  int  int  int  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)com.bytedance.trae.common.widget.PermissionRationaleDialog
    .registers 24
    # ins_size=11
    move-object v0, v14
    const-string v1, "context"
    invoke-static v14, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onAllow"
    move-object/from16 v9, v21
    invoke-static v9, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onDeny"
    move-object/from16 v10, v22
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onDenyPermanent"
    move-object/from16 v11, v23
    invoke-static v11, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    new-instance v12, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    move/from16 v2, v16
    invoke-virtual v14, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v2, "getString(...)"
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v3, v17
    invoke-virtual v14, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v3, v18
    invoke-virtual v14, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v3, v19
    invoke-virtual v14, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v2, v20
    invoke-virtual v14, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    move-object v2, v12
    move v3, v15
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;-><init>(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    invoke-direct v1, v14, v12, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;-><init>(Landroid/content/Context; Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;)V
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->show()V
    return-object v1
.end method

.method public final showForPermission(android.content.Context  int  int  int  int  int  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)com.bytedance.trae.common.widget.PermissionRationaleDialog
    .registers 24
    # ins_size=9
    move-object/from16 v0, v16
    const-string v1, "context"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onAllow"
    move-object/from16 v9, v22
    invoke-static v9, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onDeny"
    move-object/from16 v10, v23
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    new-instance v14, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    move/from16 v2, v18
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v2, "getString(...)"
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v3, v19
    invoke-virtual v0, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v3, v20
    invoke-virtual v0, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v3, v21
    invoke-virtual v0, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v8, 0
    const/4 v11, 0
    const/16 v12, 288
    const/4 v13, 0
    move-object v2, v14
    move/from16 v3, v17
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;-><init>(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v1, v0, v14, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;-><init>(Landroid/content/Context; Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;)V
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->show()V
    return-object v1
.end method
