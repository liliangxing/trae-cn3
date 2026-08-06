package com.bytedance.sdk.xbridge.cn.auth.loader;

import com.bytedance.ies.argus.api.ArgusSecureManager;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider;
import com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PermissionConfigLoaderChain.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B)\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/loader/PermissionConfigLoaderChain;", "Lcom/bytedance/sdk/xbridge/cn/auth/loader/BasePermissionConfigLoader;", "loaderList", "", "permissionConfigProvider", "Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "isLazyParse", "", "(Ljava/util/List;Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;Z)V", "()Z", "loaderName", "", "getLoaderName", "()Ljava/lang/String;", "getPermissionConfigProvider", "()Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "setPermissionConfigProvider", "(Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;)V", "load", "Lorg/json/JSONObject;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PermissionConfigLoaderChain extends BasePermissionConfigLoader {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Class<? extends BasePermissionConfigLoader>> LOCAL_CONFIG_LOAD_CHAIN = CollectionsKt.mutableListOf(new Class[]{LocalPermissionConfigLoader.class, BuiltInPermissionConfigLoader.class});
    private static final List<Class<? extends BasePermissionConfigLoader>> REMOTE_CONFIG_LOAD_CHAIN = CollectionsKt.mutableListOf(new Class[]{RemotePermissionConfigLoader.class, LocalPermissionConfigLoader.class, BuiltInPermissionConfigLoader.class});
    public static final String TAG = "PermissionConfigLoaderChain";
    private final boolean isLazyParse;
    private final List<BasePermissionConfigLoader> loaderList;
    private final String loaderName;
    private IPermissionConfigProvider permissionConfigProvider;

    public /* synthetic */ PermissionConfigLoaderChain(List list, IPermissionConfigProvider iPermissionConfigProvider, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, iPermissionConfigProvider, z);
    }

    /* synthetic */ PermissionConfigLoaderChain(List list, IPermissionConfigProvider iPermissionConfigProvider, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, iPermissionConfigProvider, (i & 4) != 0 ? false : z);
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.loader.BasePermissionConfigLoader
    public IPermissionConfigProvider getPermissionConfigProvider() {
        return this.permissionConfigProvider;
    }

    /* renamed from: isLazyParse, reason: from getter */
    public final boolean getIsLazyParse() {
        return this.isLazyParse;
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.loader.BasePermissionConfigLoader
    public void setPermissionConfigProvider(IPermissionConfigProvider iPermissionConfigProvider) {
        this.permissionConfigProvider = iPermissionConfigProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PermissionConfigLoaderChain(List<? extends BasePermissionConfigLoader> list, IPermissionConfigProvider iPermissionConfigProvider, boolean z) {
        this.loaderList = list;
        this.permissionConfigProvider = iPermissionConfigProvider;
        this.isLazyParse = z;
        this.loaderName = TAG;
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.loader.BasePermissionConfigLoader
    public String getLoaderName() {
        return this.loaderName;
    }

    /* compiled from: PermissionConfigLoaderChain.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rR\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/loader/PermissionConfigLoaderChain$Companion;", "", "()V", "LOCAL_CONFIG_LOAD_CHAIN", "", "Ljava/lang/Class;", "Lcom/bytedance/sdk/xbridge/cn/auth/loader/BasePermissionConfigLoader;", "REMOTE_CONFIG_LOAD_CHAIN", "TAG", "", "createLoaderChain", "Lcom/bytedance/sdk/xbridge/cn/auth/loader/PermissionConfigLoaderChain;", "loadRemoteConfig", "", "permissionConfigProvider", "Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "isLazyParse", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PermissionConfigLoaderChain createLoaderChain(boolean loadRemoteConfig, IPermissionConfigProvider permissionConfigProvider, boolean isLazyParse) {
            Intrinsics.checkNotNullParameter(permissionConfigProvider, "permissionConfigProvider");
            PermissionConfigParser.INSTANCE.setPermissionConfigProvider(permissionConfigProvider);
            List list = loadRemoteConfig ? PermissionConfigLoaderChain.REMOTE_CONFIG_LOAD_CHAIN : PermissionConfigLoaderChain.LOCAL_CONFIG_LOAD_CHAIN;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                BasePermissionConfigLoader basePermissionConfigLoader = (BasePermissionConfigLoader) ((Class) it.next()).newInstance();
                basePermissionConfigLoader.setPermissionConfigProvider(permissionConfigProvider);
                arrayList.add(basePermissionConfigLoader);
            }
            return new PermissionConfigLoaderChain(arrayList, permissionConfigProvider, isLazyParse, null);
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.loader.BasePermissionConfigLoader
    public JSONObject load() {
        String str;
        JSONObject jSONObject;
        try {
            Iterator<BasePermissionConfigLoader> it = this.loaderList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    jSONObject = null;
                    break;
                }
                BasePermissionConfigLoader next = it.next();
                jSONObject = next.load();
                XBridge.log("PermissionConfigLoaderChain: loaderList size:" + this.loaderList.size() + " loader=" + next.getLoaderName() + " resp==null: " + (jSONObject == null));
                if (jSONObject != null) {
                    str = next.getLoaderName();
                    break;
                }
            }
            if (jSONObject != null) {
                PermissionConfigParser.INSTANCE.parse();
                IPermissionConfigProvider permissionConfigProvider = PermissionConfigParser.INSTANCE.getPermissionConfigProvider();
                PermissionConfigV2Parser.INSTANCE.parse(jSONObject, permissionConfigProvider != null ? permissionConfigProvider.provideGeckoAccessKey() : null, this.isLazyParse, str);
                ArgusSecureManager.INSTANCE.onFeConfigUpdated();
            } else {
                XBridge.log("PermissionConfigLoaderChain: finalResp is null");
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("PermissionConfigLoaderChain: load error, e=");
            String message = th.getMessage();
            if (message == null) {
                message = "unknown error";
            }
            XBridge.log(sb.append(message).toString());
        }
        return null;
    }
}
