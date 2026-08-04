# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/applog/api/IApplog;
.super Ljava/lang/Object;
.source "IApplog.kt"

.field public static final Companion:Lcom/bytedance/trae/applog/api/IApplog$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->$$INSTANCE Lcom/bytedance/trae/applog/api/IApplog$Companion;
    sput-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    return-void 
.end method

.method public abstract addEventCommonParams(java.lang.String  kotlin.jvm.functions.Function0)void
    # abstract or native
.end method

.method public abstract addGetAppLogIdListener(com.bytedance.trae.applog.api.OnGetAppLogIdListener)void
    # abstract or native
.end method

.method public abstract addLaunchObserver(com.bytedance.trae.applog.api.OnLaunchCallback)void
    # abstract or native
.end method

.method public abstract addNavigatorCallback(com.bytedance.trae.applog.api.OnNavigateCallback)void
    # abstract or native
.end method

.method public abstract doWhenIdsReady(kotlin.jvm.functions.Function2)void
    # abstract or native
.end method

.method public abstract flush()void
    # abstract or native
.end method

.method public abstract getAbSdkVersion()java.lang.String
    # abstract or native
.end method

.method public abstract getClientDid()java.lang.String
    # abstract or native
.end method

.method public abstract getDeviceId()java.lang.String
    # abstract or native
.end method

.method public abstract getInstallId()java.lang.String
    # abstract or native
.end method

.method public abstract getNetworkClient()java.lang.Object
    # abstract or native
.end method

.method public abstract getOpenUDid()java.lang.String
    # abstract or native
.end method

.method public abstract getSessionId()java.lang.String
    # abstract or native
.end method

.method public abstract getSsid()java.lang.String
    # abstract or native
.end method

.method public abstract getUriConfig(boolean)java.lang.Object
    # abstract or native
.end method

.method public abstract getUserID()java.lang.String
    # abstract or native
.end method

.method public abstract getUserUniqueID()java.lang.String
    # abstract or native
.end method

.method public abstract isAutoNewUserMode(android.content.Context)boolean
    # abstract or native
.end method

.method public abstract isNormalNewUserMode(android.content.Context)boolean
    # abstract or native
.end method

.method public abstract onAccountTypeChanged(java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    # abstract or native
.end method

.method public abstract onBgSessionTaskPause()void
    # abstract or native
.end method

.method public abstract onBgSessionTaskResume()void
    # abstract or native
.end method

.method public abstract onMiscEvent(java.lang.String  org.json.JSONObject)void
    # abstract or native
.end method

.method public abstract openETVerify()void
    # abstract or native
.end method

.method public abstract putCommonParams(java.util.Map)void
    # abstract or native
.end method

.method public abstract putEventCommonParams(java.lang.String  java.lang.Object)void
    # abstract or native
.end method

.method public abstract removeDidListener(com.bytedance.trae.applog.api.OnGetAppLogIdListener)void
    # abstract or native
.end method

.method public abstract removeHeaderInfo(java.lang.String)void
    # abstract or native
.end method

.method public abstract reportEvent(java.lang.String)void
    # abstract or native
.end method

.method public abstract reportEvent(java.lang.String  android.os.Bundle)void
    # abstract or native
.end method

.method public abstract reportEvent(java.lang.String  org.json.JSONObject)void
    # abstract or native
.end method

.method public abstract setBDAccountCallback(android.util.Pair)void
    # abstract or native
.end method

.method public abstract setBDAccountCallbackProvider(kotlin.jvm.functions.Function0)void
    # abstract or native
.end method

.method public abstract setExternalAbVersionFromAbTest(java.lang.String)void
    # abstract or native
.end method

.method public abstract setExternalAbVersionFromSettings(java.lang.String)void
    # abstract or native
.end method

.method public abstract setHeaderInfo(java.lang.String  java.lang.Object)void
    # abstract or native
.end method

.method public abstract setNewUserMode(android.content.Context  boolean  boolean)boolean
    # abstract or native
.end method

.method public abstract setSwitchToBdtracker(boolean)void
    # abstract or native
.end method
