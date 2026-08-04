# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;
.super Ljava/lang/Object;
.source "BrainstormPermissionHelper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;
.field private static final TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$EATXHH5xfllxvYwwXOXcAYsw_YY(androidx.activity.result.ActivityResultLauncher  java.util.List)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;->requestPermissions$lambda$1(Landroidx/activity/result/ActivityResultLauncher; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$sBt2XTRXBgwdpN_-P-ddpiSM0V0()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;->requestPermissions$lambda$0()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic requestPermissions$default(com.bytedance.trae.conversation.brainstorm.BrainstormPermissionHelper  android.content.Context  androidx.activity.result.ActivityResultLauncher  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +007h
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper$$ExternalSyntheticLambda1;
    invoke-direct v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper$$ExternalSyntheticLambda1;-><init>()V
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;->requestPermissions(Landroid/content/Context; Landroidx/activity/result/ActivityResultLauncher; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final requestPermissions$lambda$0()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final requestPermissions$lambda$1(androidx.activity.result.ActivityResultLauncher  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=2
    check-cast v2, Ljava/util/Collection;
    const/4 v0, 0
    new-array v0, v0, [Ljava/lang/String;
    invoke-interface v2, v0, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;
    move-result-object v2
    invoke-virtual v1, v2, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final getUngrantedPermissions(android.content.Context)java.util.List
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    const-string v1, "android.permission.RECORD_AUDIO"
    invoke-static v3, v1, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v3
    if-eqz v3, +005h
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-object v0
.end method

.method public final requestPermissions(android.content.Context  androidx.activity.result.ActivityResultLauncher  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 15
    # ins_size=5
    const-string v0, "context"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "launcher"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onAllGranted"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onDeny"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;->getUngrantedPermissions(Landroid/content/Context;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v1
    const-string v2, "BrainstormPermission"
    if-eqz v1, +00ch
    const-string/jumbo v11, requestPermissions: all permissions already granted
    invoke-static v2, v11, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    invoke-interface v13, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    new-instance v13, Ljava/lang/StringBuilder;
    const-string/jumbo v1, requestPermissions: need to request 
    invoke-direct v13, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-static v2, v13, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    const-string v13, "android.permission.RECORD_AUDIO"
    invoke-interface v0, v13, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, +019h
    sget-object v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->Companion Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
    sget v3, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_permission_microphone I
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_microphone_title I
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_microphone_message I
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_allow I
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_deny I
    new-instance v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper$$ExternalSyntheticLambda0;
    invoke-direct v8, v12, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper$$ExternalSyntheticLambda0;-><init>(Landroidx/activity/result/ActivityResultLauncher; Ljava/util/List;)V
    move-object v2, v11
    move-object v9, v14
    invoke-virtual/range v1 ... v9, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForPermission(Landroid/content/Context; I I I I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    goto +dh
    check-cast v0, Ljava/util/Collection;
    const/4 v11, 0
    new-array v11, v11, [Ljava/lang/String;
    invoke-interface v0, v11, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;
    move-result-object v11
    invoke-virtual v12, v11, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    return-void 
.end method
