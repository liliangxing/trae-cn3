# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper;
.super Ljava/lang/Object;
.source "BytecloudLoginHelper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper;
    invoke-direct v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final checkBytedanceNetwork(androidx.lifecycle.LifecycleOwner  com.bytedance.trae.login.bytecloud.BytecloudLoginHelper$NetworkCheckCallback)void
    .registers 8
    # ins_size=2
    const-string v0, "lifecycleOwner"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v6, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v6
    move-object v0, v6
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v6, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkBytedanceNetwork$1;
    const/4 v3, 0
    invoke-direct v6, v7, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkBytedanceNetwork$1;-><init>(Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$NetworkCheckCallback; Lkotlin/coroutines/Continuation;)V
    move-object v3, v6
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static final checkIntranetRealTime(androidx.lifecycle.LifecycleOwner  com.bytedance.trae.login.bytecloud.BytecloudLoginHelper$NetworkCheckCallback)void
    .registers 8
    # ins_size=2
    const-string v0, "lifecycleOwner"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v6, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v6
    move-object v0, v6
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v6, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;
    const/4 v3, 0
    invoke-direct v6, v7, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;-><init>(Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$NetworkCheckCallback; Lkotlin/coroutines/Continuation;)V
    move-object v3, v6
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
