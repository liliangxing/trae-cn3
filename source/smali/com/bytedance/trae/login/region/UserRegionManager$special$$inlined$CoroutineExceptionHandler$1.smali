# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/region/UserRegionManager$special$$inlined$CoroutineExceptionHandler$1;
.super Lkotlin/coroutines/AbstractCoroutineContextElement;
.source "CoroutineExceptionHandler.kt"

.implements Lkotlinx/coroutines/CoroutineExceptionHandler;


.method public constructor <init>(kotlinx.coroutines.CoroutineExceptionHandler$Key)void
    .registers 2
    # ins_size=2
    check-cast v1, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-direct v0, v1, Lkotlin/coroutines/AbstractCoroutineContextElement;-><init>(Lkotlin/coroutines/CoroutineContext$Key;)V
    return-void 
.end method

.method public handleException(kotlin.coroutines.CoroutineContext  java.lang.Throwable)void
    .registers 5
    # ins_size=3
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Uncaught exception in region scope: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v0, "UserRegionManager"
    invoke-virtual v3, v0, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
