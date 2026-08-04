# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClientKt;
.super Ljava/lang/Object;
.source "AndroidKmpRawHttpClient.kt"


.method public static final synthetic access$httpStatusCodeOrNull(java.lang.Throwable)java.lang.Integer
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClientKt;->httpStatusCodeOrNull(Ljava/lang/Throwable;)Ljava/lang/Integer;
    move-result-object v0
    return-object v0
.end method

.method private static final httpStatusCodeOrNull(java.lang.Throwable)java.lang.Integer
    .registers 2
    # ins_size=1
    if-eqz v1, +02ah
    instance-of v0, v1, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;
    if-eqz v0, +00ah
    move-object v0, v1
    check-cast v0, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;
    invoke-virtual v0, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;->getStatusCode()I
    move-result v0
    goto +eh
    instance-of v0, v1, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;
    if-eqz v0, +00ah
    move-object v0, v1
    check-cast v0, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;
    invoke-virtual v0, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;->getStatusCode()I
    move-result v0
    goto +2h
    const/4 v0, -1
    if-lez v0, +007h
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    return-object v1
    invoke-virtual v1, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;
    move-result-object v0
    if-eq v0, v1, +004h
    move-object v1, v0
    goto -29h
    const/4 v1, 0
    return-object v1
.end method
