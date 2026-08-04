# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/api/IApmTrace$DefaultImpls;
.super Ljava/lang/Object;
.source "IApmTrace.kt"


.method public static synthetic reportApmEvent$default(com.bytedance.trae.apm.api.IApmTrace  java.lang.String  org.json.JSONObject  org.json.JSONObject  org.json.JSONObject  int  java.lang.Object)void
    .registers 8
    # ins_size=7
    if-nez v7, +011h
    and-int/lit8 v7, v6, 4
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-interface v1, v2, v3, v4, v5, Lcom/bytedance/trae/apm/api/IApmTrace;->reportApmEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
    new-instance v1, Ljava/lang/UnsupportedOperationException;
    const-string v2, "Super calls with default arguments not supported in this target, function: reportApmEvent"
    invoke-direct v1, v2, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v1
.end method
