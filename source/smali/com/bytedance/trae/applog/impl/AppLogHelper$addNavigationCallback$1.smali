# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/AppLogHelper$addNavigationCallback$1;
.super Ljava/lang/Object;
.source "AppLogHelper.kt"

.implements Lcom/bytedance/applog/collector/NavigatorCallback;

.field final synthetic $callback:Lcom/bytedance/trae/applog/api/OnNavigateCallback;


.method constructor <init>(com.bytedance.trae.applog.api.OnNavigateCallback)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$addNavigationCallback$1;->$callback Lcom/bytedance/trae/applog/api/OnNavigateCallback;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onPause(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "flatParams"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper$addNavigationCallback$1;->$callback Lcom/bytedance/trae/applog/api/OnNavigateCallback;
    if-nez v2, +004h
    const-string v2, ""
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/applog/api/OnNavigateCallback;->onPause(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public onResume(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "flatParams"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper$addNavigationCallback$1;->$callback Lcom/bytedance/trae/applog/api/OnNavigateCallback;
    if-nez v2, +004h
    const-string v2, ""
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/applog/api/OnNavigateCallback;->onResume(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method
