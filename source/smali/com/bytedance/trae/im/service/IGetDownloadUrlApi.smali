# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;
.super Ljava/lang/Object;
.source "IGetDownloadUrlApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;->Companion Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
    return-void 
.end method

.method public abstract getDownloadUrl(com.bytedance.trae.im.service.GetDownloadUrlRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract getDownloadUrlRaw(com.bytedance.trae.im.service.GetDownloadUrlRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
