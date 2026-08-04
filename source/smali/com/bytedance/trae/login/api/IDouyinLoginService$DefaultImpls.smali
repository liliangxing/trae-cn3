# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/api/IDouyinLoginService$DefaultImpls;
.super Ljava/lang/Object;
.source "IDouyinLoginService.kt"


.method public static authorize(com.bytedance.trae.login.api.IDouyinLoginService  android.app.Activity  com.bytedance.trae.login.api.IAccountCallback  java.lang.String)void
    .registers 4
    # ins_size=4
    const-string v0, "activity"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static bindToAccount(com.bytedance.trae.login.api.IDouyinLoginService  android.app.Activity  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function2)void
    .registers 4
    # ins_size=4
    const-string v0, "activity"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onSuccess
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onFail
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static getDouyinNickname(com.bytedance.trae.login.api.IDouyinLoginService)java.lang.String
    .registers 1
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public static isBound(com.bytedance.trae.login.api.IDouyinLoginService)boolean
    .registers 1
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public static unbind(com.bytedance.trae.login.api.IDouyinLoginService  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function2)void
    .registers 3
    # ins_size=3
    const-string/jumbo v0, onSuccess
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onFail
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
