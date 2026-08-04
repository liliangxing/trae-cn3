# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/ICancelNotifyApi;
.super Ljava/lang/Object;
.source "ICancelNotifyApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/ICancelNotifyApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/ICancelNotifyApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/ICancelNotifyApi$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/ICancelNotifyApi;->Companion Lcom/bytedance/trae/im/service/ICancelNotifyApi$Companion;
    return-void 
.end method

.method public abstract cancelNotify(com.bytedance.trae.im.service.CancelNotifyRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
