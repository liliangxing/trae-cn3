# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;
.super Ljava/lang/Object;
.source "SiteMessageApi.kt"

.field public static final Companion:Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;->$$INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;->Companion Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;
    return-void 
.end method

.method public abstract getList(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract getPreferences(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract getUnreadCount(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract updatePreferences(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract updateStatus(com.bytedance.trae.home.solo.sitemessage.SiteMessageUpdateStatusBody  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
