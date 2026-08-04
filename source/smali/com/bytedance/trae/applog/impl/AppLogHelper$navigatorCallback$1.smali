# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/AppLogHelper$navigatorCallback$1;
.super Ljava/lang/Object;
.source "AppLogHelper.kt"

.implements Lcom/bytedance/applog/collector/NavigatorCallback;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onPause(java.lang.String  org.json.JSONObject)void
    .registers 5
    # ins_size=3
    const-string v0, "flatParams"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/applog/impl/AppLogHelper;->access$getNavigatorCallbackList$p()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/applog/collector/NavigatorCallback;
    invoke-interface v1, v3, v4, Lcom/bytedance/applog/collector/NavigatorCallback;->onPause(Ljava/lang/String; Lorg/json/JSONObject;)V
    goto -fh
    return-void 
.end method

.method public onResume(java.lang.String  org.json.JSONObject)void
    .registers 5
    # ins_size=3
    const-string v0, "flatParams"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/applog/impl/AppLogHelper;->access$getNavigatorCallbackList$p()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/applog/collector/NavigatorCallback;
    invoke-interface v1, v3, v4, Lcom/bytedance/applog/collector/NavigatorCallback;->onResume(Ljava/lang/String; Lorg/json/JSONObject;)V
    goto -fh
    return-void 
.end method
