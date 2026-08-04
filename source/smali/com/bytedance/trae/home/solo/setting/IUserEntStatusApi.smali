# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi;
.super Ljava/lang/Object;
.source "UserEntStatusApi.kt"

.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;->$$INSTANCE Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi;->Companion Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;
    return-void 
.end method

.method public abstract getUserEntUsageRaw(com.bytedance.trae.home.solo.setting.UserEntUsageRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
