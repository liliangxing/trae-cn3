# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/home/solo/setting/IUserPayStatusApi;
.super Ljava/lang/Object;
.source "UserPayStatusApi.kt"

.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/IUserPayStatusApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/IUserPayStatusApi$Companion;->$$INSTANCE Lcom/bytedance/trae/home/solo/setting/IUserPayStatusApi$Companion;
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/IUserPayStatusApi;->Companion Lcom/bytedance/trae/home/solo/setting/IUserPayStatusApi$Companion;
    return-void 
.end method

.method public abstract getUserPayStatus(kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
