package com.bytedance.forest.model;

import android.content.Context;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoClientManager;
import com.bytedance.geckox.clean.cache.CacheConfig;
import com.bytedance.geckox.net.INetWork;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 62\u00020\u0001:\u00016BA\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fBI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\u0010\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u000204H\u0002J\u000e\u00105\u001a\u00020\u00142\u0006\u00103\u001a\u000204R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\"\"\u0004\b#\u0010$R$\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0010¨\u00067"}, d2 = {"Lcom/bytedance/forest/model/GeckoConfig;", "", "accessKey", "", "offlineDir", "appId", "", "appVersion", "did", "region", "isRelativePath", "", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "loopCheck", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "appFileDir", "Ljava/io/File;", "getAppId", "()J", "getAppVersion", "businessVersion", "getBusinessVersion", "setBusinessVersion", "cacheConfig", "Lcom/bytedance/geckox/clean/cache/CacheConfig;", "getCacheConfig", "()Lcom/bytedance/geckox/clean/cache/CacheConfig;", "setCacheConfig", "(Lcom/bytedance/geckox/clean/cache/CacheConfig;)V", "getDid", "()Z", "setRelativePath", "(Z)V", "loopCheck$annotations", "()V", "getLoopCheck", "setLoopCheck", "networkImpl", "Lcom/bytedance/geckox/net/INetWork;", "getNetworkImpl", "()Lcom/bytedance/geckox/net/INetWork;", "setNetworkImpl", "(Lcom/bytedance/geckox/net/INetWork;)V", "getOfflineDir", "setOfflineDir", "getRegion", "getGeckoXOfflineRootDirFileWithoutAccessKey", "context", "Landroid/content/Context;", "getRootDir", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy configByRegistry$delegate = LazyKt.lazy(new Function0<Map<String, GeckoConfig>>() { // from class: com.bytedance.forest.model.GeckoConfig$Companion$configByRegistry$2
        public final Map<String, GeckoConfig> invoke() {
            return new LinkedHashMap();
        }
    });
    private String accessKey;
    private File appFileDir;
    private final long appId;
    private final String appVersion;
    private String businessVersion;
    private CacheConfig cacheConfig;
    private final String did;
    private boolean isRelativePath;
    private boolean loopCheck;
    private INetWork networkImpl;
    private String offlineDir;
    private final String region;

    @Deprecated(message = "loopCheck has no effect")
    public static /* synthetic */ void loopCheck$annotations() {
    }

    public GeckoConfig(String str, String str2, long j, String str3, String str4, String str5, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "accessKey");
        Intrinsics.checkParameterIsNotNull(str2, "offlineDir");
        Intrinsics.checkParameterIsNotNull(str3, "appVersion");
        Intrinsics.checkParameterIsNotNull(str4, "did");
        Intrinsics.checkParameterIsNotNull(str5, "region");
        this.accessKey = str;
        this.offlineDir = str2;
        this.appId = j;
        this.appVersion = str3;
        this.did = str4;
        this.region = str5;
        this.isRelativePath = z;
        this.loopCheck = z2;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final void setAccessKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.accessKey = str;
    }

    public final String getOfflineDir() {
        return this.offlineDir;
    }

    public final void setOfflineDir(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.offlineDir = str;
    }

    public final long getAppId() {
        return this.appId;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getDid() {
        return this.did;
    }

    public final String getRegion() {
        return this.region;
    }

    /* renamed from: isRelativePath, reason: from getter */
    public final boolean getIsRelativePath() {
        return this.isRelativePath;
    }

    public final void setRelativePath(boolean z) {
        this.isRelativePath = z;
    }

    public /* synthetic */ GeckoConfig(String str, String str2, long j, String str3, String str4, String str5, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, str3, str4, str5, (i & 64) != 0 ? true : z, (i & 128) != 0 ? false : z2);
    }

    public final boolean getLoopCheck() {
        return this.loopCheck;
    }

    public final void setLoopCheck(boolean z) {
        this.loopCheck = z;
    }

    /* compiled from: ForestConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\rR'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/forest/model/GeckoConfig$Companion;", "", "()V", "configByRegistry", "", "", "Lcom/bytedance/forest/model/GeckoConfig;", "getConfigByRegistry", "()Ljava/util/Map;", "configByRegistry$delegate", "Lkotlin/Lazy;", "fromGeckoRegistry", "ak", "fromGeckoRegistry$forest_release", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private final Map<String, GeckoConfig> getConfigByRegistry() {
            Lazy lazy = GeckoConfig.configByRegistry$delegate;
            Companion companion = GeckoConfig.INSTANCE;
            return (Map) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GeckoConfig fromGeckoRegistry$forest_release(String ak) {
            Intrinsics.checkParameterIsNotNull(ak, "ak");
            GeckoConfig geckoConfig = getConfigByRegistry().get(ak);
            if (geckoConfig != null) {
                return geckoConfig;
            }
            GeckoClient geckoClientFromRegister = GeckoClientManager.INSTANCE.getGeckoClientFromRegister(ak);
            if (geckoClientFromRegister == null) {
                return null;
            }
            com.bytedance.geckox.GeckoConfig config = geckoClientFromRegister.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config, "configRegistry");
            String accessKey = config.getAccessKey();
            String str = accessKey != null ? accessKey : "";
            File resRootDir = config.getResRootDir();
            Intrinsics.checkExpressionValueIsNotNull(resRootDir, "configRegistry.resRootDir");
            String absolutePath = resRootDir.getAbsolutePath();
            String str2 = absolutePath != null ? absolutePath : "";
            long appId = config.getAppId();
            String appVersion = config.getAppVersion();
            String str3 = appVersion != null ? appVersion : "";
            String deviceId = config.getDeviceId();
            String str4 = deviceId != null ? deviceId : "";
            String region = config.getRegion();
            if (region == null) {
                region = "";
            }
            GeckoConfig geckoConfig2 = new GeckoConfig(str, str2, appId, str3, str4, region, false);
            GeckoConfig.INSTANCE.getConfigByRegistry().put(ak, geckoConfig2);
            return geckoConfig2;
        }
    }

    public /* synthetic */ GeckoConfig(String str, String str2, long j, String str3, String str4, String str5, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, str3, str4, str5, (i & 64) != 0 ? true : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GeckoConfig(String str, String str2, long j, String str3, String str4, String str5, boolean z) {
        this(str, str2, j, str3, str4, str5, z, false);
        Intrinsics.checkParameterIsNotNull(str, "accessKey");
        Intrinsics.checkParameterIsNotNull(str2, "offlineDir");
        Intrinsics.checkParameterIsNotNull(str3, "appVersion");
        Intrinsics.checkParameterIsNotNull(str4, "did");
        Intrinsics.checkParameterIsNotNull(str5, "region");
    }

    public final INetWork getNetworkImpl() {
        return this.networkImpl;
    }

    public final void setNetworkImpl(INetWork iNetWork) {
        this.networkImpl = iNetWork;
    }

    public final CacheConfig getCacheConfig() {
        return this.cacheConfig;
    }

    public final void setCacheConfig(CacheConfig cacheConfig) {
        this.cacheConfig = cacheConfig;
    }

    public final String getBusinessVersion() {
        return this.businessVersion;
    }

    public final void setBusinessVersion(String str) {
        this.businessVersion = str;
    }

    public final File getRootDir(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return getGeckoXOfflineRootDirFileWithoutAccessKey(context);
    }

    private final File getGeckoXOfflineRootDirFileWithoutAccessKey(Context context) {
        if (!this.isRelativePath) {
            return new File(this.offlineDir);
        }
        if (this.appFileDir == null) {
            this.appFileDir = context.getFilesDir();
        }
        try {
            File file = new File(this.appFileDir, this.offlineDir);
            if (file.exists()) {
                return file;
            }
            file.mkdirs();
            return file;
        } catch (Exception unused) {
            return new File(this.offlineDir);
        }
    }
}
