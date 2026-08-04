# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/AppLogHelper$dataObserver$1;
.super Ljava/lang/Object;
.source "AppLogHelper.kt"

.implements Lcom/bytedance/applog/IDataObserver;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onAbVidsChange(java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public onIdLoaded(java.lang.String  java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=4
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-nez v0, +027h
    invoke-static Lcom/bytedance/trae/applog/impl/AppLogHelper;->access$getMDidListenerCallbackList$p()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +017h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    const-string v2, ""
    if-nez v6, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v6
    if-nez v7, +003h
    goto +2h
    move-object v2, v7
    invoke-interface v1, v5, v3, v2, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;->onGetId(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto -1ah
    sget-object v7, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    const-string v0, "onIdLoaded"
    invoke-static v7, v5, v6, v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->access$updateBdTuringId(Lcom/bytedance/trae/applog/impl/AppLogHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onRemoteAbConfigGet(boolean  org.json.JSONObject)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public onRemoteConfigGet(boolean  org.json.JSONObject)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public onRemoteIdGet(boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=8
    if-eqz v1, +03fh
    move-object v1, v3
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-nez v1, +02eh
    invoke-static Lcom/bytedance/trae/applog/impl/AppLogHelper;->access$getMDidListenerCallbackList$p()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +017h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    const-string v4, ""
    if-nez v5, +004h
    move-object v6, v4
    goto +2h
    move-object v6, v5
    if-nez v7, +003h
    goto +2h
    move-object v4, v7
    invoke-interface v2, v3, v6, v4, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;->onGetId(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto -1ah
    sget-object v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    const-string v2, "onRemoteIdGet"
    invoke-static v1, v3, v5, v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->access$updateBdTuringId(Lcom/bytedance/trae/applog/impl/AppLogHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
