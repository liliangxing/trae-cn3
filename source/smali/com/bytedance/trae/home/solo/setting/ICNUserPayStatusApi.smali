# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi;
.super Ljava/lang/Object;
.source "CNUserPagStatusApi.kt"

.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi$Companion;->$$INSTANCE Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi$Companion;
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi;->Companion Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi$Companion;
    return-void 
.end method

.method public abstract getUserPayStatusRaw(com.bytedance.trae.home.solo.setting.GetIdeUserPayStatusRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
