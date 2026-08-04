# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;
.super Landroidx/fragment/app/Fragment;
.source "AndroidKmpMediaLibraryHandler.kt"

.field public static final Companion:Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion;
.field private static final REQUEST_CODE:I
.field private static final TAG:Ljava/lang/String;
.field private continuation:Lkotlinx/coroutines/CancellableContinuation;


.method public static synthetic $r8$lambda$MvpVnefwwaoryWYaMqZSCatjMXs(com.bytedance.trae.kmp.host.KmpMediaLibraryPermissionFragment  kotlinx.coroutines.CancellableContinuation  java.lang.Throwable)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;->requestPermission$lambda$1(Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment; Lkotlinx/coroutines/CancellableContinuation; Ljava/lang/Throwable;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;->Companion Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/Fragment;-><init>()V
    return-void 
.end method

.method private static final requestPermission$lambda$1(com.bytedance.trae.kmp.host.KmpMediaLibraryPermissionFragment  kotlinx.coroutines.CancellableContinuation  java.lang.Throwable)kotlin.Unit
    .registers 3
    # ins_size=3
    iget-object v2, v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;->continuation Lkotlinx/coroutines/CancellableContinuation;
    if-ne v2, v1, +005h
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;->continuation Lkotlinx/coroutines/CancellableContinuation;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public onRequestPermissionsResult(int  java.lang.String[]  int[])void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, permissions
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "grantResults"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, v4, Landroidx/fragment/app/Fragment;->onRequestPermissionsResult(I [Ljava/lang/String; [I)V
    const/16 v3, 4107
    if-eq v2, v3, +003h
    return-void 
    iget-object v2, v1, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;->continuation Lkotlinx/coroutines/CancellableContinuation;
    if-eqz v2, +02ah
    const/4 v3, 0
    iput-object v3, v1, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;->continuation Lkotlinx/coroutines/CancellableContinuation;
    invoke-interface v2, Lkotlinx/coroutines/CancellableContinuation;->isActive()Z
    move-result v3
    if-eqz v3, +021h
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-static v4, Lkotlin/collections/ArraysKt;->firstOrNull([I)Ljava/lang/Integer;
    move-result-object v3
    if-nez v3, +003h
    goto +9h
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v3
    if-nez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-interface v2, v3, Lkotlin/coroutines/Continuation;->resumeWith(Ljava/lang/Object;)V
    return-void 
.end method

.method public final requestPermission(kotlinx.coroutines.CancellableContinuation)void
    .registers 3
    # ins_size=2
    const-string v0, "continuation"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;->continuation Lkotlinx/coroutines/CancellableContinuation;
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +018h
    iput-object v2, v1, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;->continuation Lkotlinx/coroutines/CancellableContinuation;
    new-instance v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment; Lkotlinx/coroutines/CancellableContinuation;)V
    invoke-interface v2, v0, Lkotlinx/coroutines/CancellableContinuation;->invokeOnCancellation(Lkotlin/jvm/functions/Function1;)V
    const-string v2, "android.permission.WRITE_EXTERNAL_STORAGE"
    filled-new-array v2, [Ljava/lang/String;
    move-result-object v2
    const/16 v0, 4107
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;->requestPermissions([Ljava/lang/String; I)V
    return-void 
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v0, "Storage permission request is already running"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
.end method
