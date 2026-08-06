package com.bytedance.trae.anniex;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsAppGetAppInfoMethodIDL.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u000b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoParamModel;", "Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "Companion", "AppGetAppInfoParamModel", "AppGetAppInfoResultModel", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsAppGetAppInfoMethodIDL extends XCoreIDLBridgeMethod<AppGetAppInfoParamModel, AppGetAppInfoResultModel> {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "40930"));

    @XBridgeMethodName(name = "app.getAppInfo", params = {""}, results = {Constant.KEY_AID, "user_id", "device_id", "statusBarHeight", OnekeyLoginConstants.NET_TYPE, Constant.KEY_APP_VERSION2, Constant.KEY_OS_VERSION, Constant.KEY_DEVICE_MODEL, "install_id", "open_udid", "innerAppName", "carrier", "device_platform", "appVersonCode", Constant.KEY_CHANNEL, "appName", Constant.KEY_DEVICE_TYPE, "versionCode"})
    private final String name = "app.getAppInfo";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PUBLIC)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PUBLIC;

    /* compiled from: AbsAppGetAppInfoMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface AppGetAppInfoParamModel extends XBaseParamModel {
    }

    /* compiled from: AbsAppGetAppInfoMethodIDL.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0004\n\u0002\b0\bg\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u000f8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR(\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR(\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR(\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR(\u0010!\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR(\u0010$\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR(\u0010'\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR(\u0010*\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR(\u0010-\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR(\u00100\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR(\u00103\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR(\u00106\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR(\u00109\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR(\u0010<\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\b¨\u0006?"}, d2 = {"Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "value", "", Constant.KEY_AID, "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "user_id", "getUser_id", "setUser_id", "device_id", "getDevice_id", "setDevice_id", "", "statusBarHeight", "getStatusBarHeight", "()Ljava/lang/Number;", "setStatusBarHeight", "(Ljava/lang/Number;)V", OnekeyLoginConstants.NET_TYPE, "getNetType", "setNetType", Constant.KEY_APP_VERSION2, "getAppVersion", "setAppVersion", Constant.KEY_OS_VERSION, "getOs_version", "setOs_version", Constant.KEY_DEVICE_MODEL, "getDevice_model", "setDevice_model", "install_id", "getInstall_id", "setInstall_id", "open_udid", "getOpen_udid", "setOpen_udid", "innerAppName", "getInnerAppName", "setInnerAppName", "carrier", "getCarrier", "setCarrier", "device_platform", "getDevice_platform", "setDevice_platform", "appVersonCode", "getAppVersonCode", "setAppVersonCode", Constant.KEY_CHANNEL, "getChannel", "setChannel", "appName", "getAppName", "setAppName", Constant.KEY_DEVICE_TYPE, "getDevice_type", "setDevice_type", "versionCode", "getVersionCode", "setVersionCode", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface AppGetAppInfoResultModel extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = Constant.KEY_AID, required = true)
        String getAid();

        @XBridgeParamField(isGetter = true, keyPath = "appName", required = true)
        String getAppName();

        @XBridgeParamField(isGetter = true, keyPath = Constant.KEY_APP_VERSION2, required = true)
        String getAppVersion();

        @XBridgeParamField(isGetter = true, keyPath = "appVersonCode", required = true)
        String getAppVersonCode();

        @XBridgeParamField(isGetter = true, keyPath = "carrier", required = true)
        String getCarrier();

        @XBridgeParamField(isGetter = true, keyPath = Constant.KEY_CHANNEL, required = true)
        String getChannel();

        @XBridgeParamField(isGetter = true, keyPath = "device_id", required = true)
        String getDevice_id();

        @XBridgeParamField(isGetter = true, keyPath = Constant.KEY_DEVICE_MODEL, required = true)
        String getDevice_model();

        @XBridgeParamField(isGetter = true, keyPath = "device_platform", required = true)
        String getDevice_platform();

        @XBridgeParamField(isGetter = true, keyPath = Constant.KEY_DEVICE_TYPE, required = true)
        String getDevice_type();

        @XBridgeParamField(isGetter = true, keyPath = "innerAppName", required = true)
        String getInnerAppName();

        @XBridgeParamField(isGetter = true, keyPath = "install_id", required = true)
        String getInstall_id();

        @XBridgeParamField(isGetter = true, keyPath = OnekeyLoginConstants.NET_TYPE, required = true)
        String getNetType();

        @XBridgeParamField(isGetter = true, keyPath = "open_udid", required = true)
        String getOpen_udid();

        @XBridgeParamField(isGetter = true, keyPath = Constant.KEY_OS_VERSION, required = true)
        String getOs_version();

        @XBridgeParamField(isGetter = true, keyPath = "statusBarHeight", required = true)
        Number getStatusBarHeight();

        @XBridgeParamField(isGetter = true, keyPath = "user_id", required = true)
        String getUser_id();

        @XBridgeParamField(isGetter = true, keyPath = "versionCode", required = true)
        String getVersionCode();

        @XBridgeParamField(isGetter = false, keyPath = Constant.KEY_AID, required = true)
        void setAid(String str);

        @XBridgeParamField(isGetter = false, keyPath = "appName", required = true)
        void setAppName(String str);

        @XBridgeParamField(isGetter = false, keyPath = Constant.KEY_APP_VERSION2, required = true)
        void setAppVersion(String str);

        @XBridgeParamField(isGetter = false, keyPath = "appVersonCode", required = true)
        void setAppVersonCode(String str);

        @XBridgeParamField(isGetter = false, keyPath = "carrier", required = true)
        void setCarrier(String str);

        @XBridgeParamField(isGetter = false, keyPath = Constant.KEY_CHANNEL, required = true)
        void setChannel(String str);

        @XBridgeParamField(isGetter = false, keyPath = "device_id", required = true)
        void setDevice_id(String str);

        @XBridgeParamField(isGetter = false, keyPath = Constant.KEY_DEVICE_MODEL, required = true)
        void setDevice_model(String str);

        @XBridgeParamField(isGetter = false, keyPath = "device_platform", required = true)
        void setDevice_platform(String str);

        @XBridgeParamField(isGetter = false, keyPath = Constant.KEY_DEVICE_TYPE, required = true)
        void setDevice_type(String str);

        @XBridgeParamField(isGetter = false, keyPath = "innerAppName", required = true)
        void setInnerAppName(String str);

        @XBridgeParamField(isGetter = false, keyPath = "install_id", required = true)
        void setInstall_id(String str);

        @XBridgeParamField(isGetter = false, keyPath = OnekeyLoginConstants.NET_TYPE, required = true)
        void setNetType(String str);

        @XBridgeParamField(isGetter = false, keyPath = "open_udid", required = true)
        void setOpen_udid(String str);

        @XBridgeParamField(isGetter = false, keyPath = Constant.KEY_OS_VERSION, required = true)
        void setOs_version(String str);

        @XBridgeParamField(isGetter = false, keyPath = "statusBarHeight", required = true)
        void setStatusBarHeight(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "user_id", required = true)
        void setUser_id(String str);

        @XBridgeParamField(isGetter = false, keyPath = "versionCode", required = true)
        void setVersionCode(String str);
    }

    /* compiled from: AbsAppGetAppInfoMethodIDL.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$Companion;", "", "<init>", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsAppGetAppInfoMethodIDL.extensionMetaInfo;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }
}
