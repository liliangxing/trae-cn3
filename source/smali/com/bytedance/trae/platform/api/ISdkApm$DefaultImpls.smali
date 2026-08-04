# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/platform/api/ISdkApm$DefaultImpls;
.super Ljava/lang/Object;
.source "ISdkApm.kt"


.method public static monitorEventForSlardar(com.bytedance.trae.platform.api.ISdkApm  java.lang.String  org.json.JSONObject  org.json.JSONObject  org.json.JSONObject)void
    .registers 5
    # ins_size=5
    const-string v0, "event"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
