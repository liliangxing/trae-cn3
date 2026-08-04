# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi;
.super Ljava/lang/Object;
.source "CNBillingVersionApi.kt"

.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;->$$INSTANCE Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi;->Companion Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;
    return-void 
.end method

.method public abstract switchCnBillingVersionRaw(com.bytedance.trae.home.solo.setting.SwitchCnBillingVersionRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
