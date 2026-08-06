package com.bytedance.sdk.xbridge.cn.info;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsXGetAppInfoMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\r\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL$XGetAppInfoParamModel;", "Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL$XGetAppInfoResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "Companion", "XBridgeBeanXGetAppInfoSafeArea", "XGetAppInfoParamModel", "XGetAppInfoResultModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsXGetAppInfoMethodIDL extends XCoreIDLBridgeMethod<XGetAppInfoParamModel, XGetAppInfoResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "19946"));

    @XBridgeMethodName(name = "x.getAppInfo", results = {"appID", "installID", "appName", Constant.KEY_APP_VERSION2, "updateVersionCode", Constant.KEY_CHANNEL, SettingsTracker.TYPE_LANGUAGE, "isTeenMode", "isBaseMode", "appTheme", "deviceID", "osVersion", "statusBarHeight", "devicePlatform", "deviceModel", OnekeyLoginConstants.NET_TYPE, "networkType", "carrier", "is32Bit", "idfa", "screenWidth", "screenHeight", "screenOrientation", "safeArea"})
    private final String name = "x.getAppInfo";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PROTECT;

    /* compiled from: AbsXGetAppInfoMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL$XBridgeBeanXGetAppInfoSafeArea;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "<set-?>", "", "marginBottom", "getMarginBottom", "()Ljava/lang/Number;", "setMarginBottom", "(Ljava/lang/Number;)V", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "marginTop", "getMarginTop", "setMarginTop", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXGetAppInfoSafeArea extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "marginBottom", required = true)
        Number getMarginBottom();

        @XBridgeParamField(isGetter = true, keyPath = "marginLeft", required = true)
        Number getMarginLeft();

        @XBridgeParamField(isGetter = true, keyPath = "marginRight", required = true)
        Number getMarginRight();

        @XBridgeParamField(isGetter = true, keyPath = "marginTop", required = true)
        Number getMarginTop();

        @XBridgeParamField(isGetter = false, keyPath = "marginBottom", required = true)
        void setMarginBottom(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "marginLeft", required = true)
        void setMarginLeft(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "marginRight", required = true)
        void setMarginRight(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "marginTop", required = true)
        void setMarginTop(Number number);
    }

    /* compiled from: AbsXGetAppInfoMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL$XGetAppInfoParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XGetAppInfoParamModel extends XBaseParamModel {
    }

    /* compiled from: AbsXGetAppInfoMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsXGetAppInfoMethodIDL.extensionMetaInfo;
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

    /* compiled from: AbsXGetAppInfoMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0013\bg\u0018\u0000 T2\u00020\u0001:\u0001TR(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR(\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR(\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR(\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR(\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR(\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR(\u0010!\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR(\u0010$\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR(\u0010(\u001a\u0004\u0018\u00010'2\b\u0010\u0002\u001a\u0004\u0018\u00010'8g@gX¦\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R(\u0010,\u001a\u0004\u0018\u00010'2\b\u0010\u0002\u001a\u0004\u0018\u00010'8g@gX¦\u000e¢\u0006\f\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R(\u0010.\u001a\u0004\u0018\u00010'2\b\u0010\u0002\u001a\u0004\u0018\u00010'8g@gX¦\u000e¢\u0006\f\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R(\u00100\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR(\u00103\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR(\u00106\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR(\u00109\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR(\u0010=\u001a\u0004\u0018\u00010<2\b\u0010\u0002\u001a\u0004\u0018\u00010<8g@gX¦\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR(\u0010C\u001a\u0004\u0018\u00010B2\b\u0010\u0002\u001a\u0004\u0018\u00010B8g@gX¦\u000e¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR(\u0010H\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR(\u0010K\u001a\u0004\u0018\u00010B2\b\u0010\u0002\u001a\u0004\u0018\u00010B8g@gX¦\u000e¢\u0006\f\u001a\u0004\bL\u0010E\"\u0004\bM\u0010GR(\u0010N\u001a\u0004\u0018\u00010B2\b\u0010\u0002\u001a\u0004\u0018\u00010B8g@gX¦\u000e¢\u0006\f\u001a\u0004\bO\u0010E\"\u0004\bP\u0010GR(\u0010Q\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\b¨\u0006U"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL$XGetAppInfoResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "<set-?>", "", "appID", "getAppID", "()Ljava/lang/String;", "setAppID", "(Ljava/lang/String;)V", "appName", "getAppName", "setAppName", "appTheme", "getAppTheme", "setAppTheme", Constant.KEY_APP_VERSION2, "getAppVersion", "setAppVersion", "carrier", "getCarrier", "setCarrier", Constant.KEY_CHANNEL, "getChannel", "setChannel", "deviceID", "getDeviceID", "setDeviceID", "deviceModel", "getDeviceModel", "setDeviceModel", "devicePlatform", "getDevicePlatform", "setDevicePlatform", "idfa", "getIdfa", "setIdfa", "installID", "getInstallID", "setInstallID", "", "is32Bit", "()Ljava/lang/Boolean;", "set32Bit", "(Ljava/lang/Boolean;)V", "isBaseMode", "setBaseMode", "isTeenMode", "setTeenMode", SettingsTracker.TYPE_LANGUAGE, "getLanguage", "setLanguage", OnekeyLoginConstants.NET_TYPE, "getNetType", "setNetType", "networkType", "getNetworkType", "setNetworkType", "osVersion", "getOsVersion", "setOsVersion", "Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL$XBridgeBeanXGetAppInfoSafeArea;", "safeArea", "getSafeArea", "()Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL$XBridgeBeanXGetAppInfoSafeArea;", "setSafeArea", "(Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL$XBridgeBeanXGetAppInfoSafeArea;)V", "", "screenHeight", "getScreenHeight", "()Ljava/lang/Number;", "setScreenHeight", "(Ljava/lang/Number;)V", "screenOrientation", "getScreenOrientation", "setScreenOrientation", "screenWidth", "getScreenWidth", "setScreenWidth", "statusBarHeight", "getStatusBarHeight", "setStatusBarHeight", "updateVersionCode", "getUpdateVersionCode", "setUpdateVersionCode", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XGetAppInfoResultModel extends XBaseResultModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String XGetAppInfoScreenOrientationLandscape = "landscape";
        public static final String XGetAppInfoScreenOrientationPortrait = "portrait";

        @XBridgeParamField(isGetter = true, keyPath = "appID", required = true)
        String getAppID();

        @XBridgeParamField(isGetter = true, keyPath = "appName", required = true)
        String getAppName();

        @XBridgeParamField(isGetter = true, keyPath = "appTheme", required = true)
        String getAppTheme();

        @XBridgeParamField(isGetter = true, keyPath = Constant.KEY_APP_VERSION2, required = true)
        String getAppVersion();

        @XBridgeParamField(isGetter = true, keyPath = "carrier", required = true)
        String getCarrier();

        @XBridgeParamField(isGetter = true, keyPath = Constant.KEY_CHANNEL, required = true)
        String getChannel();

        @XBridgeParamField(isGetter = true, keyPath = "deviceID", required = true)
        String getDeviceID();

        @XBridgeParamField(isGetter = true, keyPath = "deviceModel", required = true)
        String getDeviceModel();

        @XBridgeParamField(isGetter = true, keyPath = "devicePlatform", required = true)
        String getDevicePlatform();

        @XBridgeParamField(isGetter = true, keyPath = "idfa", required = false)
        String getIdfa();

        @XBridgeParamField(isGetter = true, keyPath = "installID", required = true)
        String getInstallID();

        @XBridgeParamField(isGetter = true, keyPath = SettingsTracker.TYPE_LANGUAGE, required = true)
        String getLanguage();

        @XBridgeParamField(isGetter = true, keyPath = OnekeyLoginConstants.NET_TYPE, required = true)
        String getNetType();

        @XBridgeParamField(isGetter = true, keyPath = "networkType", required = true)
        String getNetworkType();

        @XBridgeParamField(isGetter = true, keyPath = "osVersion", required = true)
        String getOsVersion();

        @XBridgeParamField(isGetter = true, keyPath = "safeArea", nestedClassType = XBridgeBeanXGetAppInfoSafeArea.class, required = false)
        XBridgeBeanXGetAppInfoSafeArea getSafeArea();

        @XBridgeParamField(isGetter = true, keyPath = "screenHeight", required = true)
        Number getScreenHeight();

        @XBridgeStringEnum(option = {"landscape", "portrait"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "screenOrientation", required = true)
        String getScreenOrientation();

        @XBridgeParamField(isGetter = true, keyPath = "screenWidth", required = true)
        Number getScreenWidth();

        @XBridgeParamField(isGetter = true, keyPath = "statusBarHeight", required = true)
        Number getStatusBarHeight();

        @XBridgeParamField(isGetter = true, keyPath = "updateVersionCode", required = true)
        String getUpdateVersionCode();

        @XBridgeParamField(isGetter = true, keyPath = "is32Bit", required = true)
        Boolean is32Bit();

        @XBridgeParamField(isGetter = true, keyPath = "isBaseMode", required = true)
        Boolean isBaseMode();

        @XBridgeParamField(isGetter = true, keyPath = "isTeenMode", required = true)
        Boolean isTeenMode();

        @XBridgeParamField(isGetter = false, keyPath = "is32Bit", required = true)
        void set32Bit(Boolean bool);

        @XBridgeParamField(isGetter = false, keyPath = "appID", required = true)
        void setAppID(String str);

        @XBridgeParamField(isGetter = false, keyPath = "appName", required = true)
        void setAppName(String str);

        @XBridgeParamField(isGetter = false, keyPath = "appTheme", required = true)
        void setAppTheme(String str);

        @XBridgeParamField(isGetter = false, keyPath = Constant.KEY_APP_VERSION2, required = true)
        void setAppVersion(String str);

        @XBridgeParamField(isGetter = false, keyPath = "isBaseMode", required = true)
        void setBaseMode(Boolean bool);

        @XBridgeParamField(isGetter = false, keyPath = "carrier", required = true)
        void setCarrier(String str);

        @XBridgeParamField(isGetter = false, keyPath = Constant.KEY_CHANNEL, required = true)
        void setChannel(String str);

        @XBridgeParamField(isGetter = false, keyPath = "deviceID", required = true)
        void setDeviceID(String str);

        @XBridgeParamField(isGetter = false, keyPath = "deviceModel", required = true)
        void setDeviceModel(String str);

        @XBridgeParamField(isGetter = false, keyPath = "devicePlatform", required = true)
        void setDevicePlatform(String str);

        @XBridgeParamField(isGetter = false, keyPath = "idfa", required = false)
        void setIdfa(String str);

        @XBridgeParamField(isGetter = false, keyPath = "installID", required = true)
        void setInstallID(String str);

        @XBridgeParamField(isGetter = false, keyPath = SettingsTracker.TYPE_LANGUAGE, required = true)
        void setLanguage(String str);

        @XBridgeParamField(isGetter = false, keyPath = OnekeyLoginConstants.NET_TYPE, required = true)
        void setNetType(String str);

        @XBridgeParamField(isGetter = false, keyPath = "networkType", required = true)
        void setNetworkType(String str);

        @XBridgeParamField(isGetter = false, keyPath = "osVersion", required = true)
        void setOsVersion(String str);

        @XBridgeParamField(isGetter = false, keyPath = "safeArea", nestedClassType = XBridgeBeanXGetAppInfoSafeArea.class, required = false)
        void setSafeArea(XBridgeBeanXGetAppInfoSafeArea xBridgeBeanXGetAppInfoSafeArea);

        @XBridgeParamField(isGetter = false, keyPath = "screenHeight", required = true)
        void setScreenHeight(Number number);

        @XBridgeStringEnum(option = {"landscape", "portrait"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "screenOrientation", required = true)
        void setScreenOrientation(String str);

        @XBridgeParamField(isGetter = false, keyPath = "screenWidth", required = true)
        void setScreenWidth(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "statusBarHeight", required = true)
        void setStatusBarHeight(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "isTeenMode", required = true)
        void setTeenMode(Boolean bool);

        @XBridgeParamField(isGetter = false, keyPath = "updateVersionCode", required = true)
        void setUpdateVersionCode(String str);

        /* compiled from: AbsXGetAppInfoMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL$XGetAppInfoResultModel$Companion;", "", "()V", "XGetAppInfoScreenOrientationLandscape", "", "XGetAppInfoScreenOrientationPortrait", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String XGetAppInfoScreenOrientationLandscape = "landscape";
            public static final String XGetAppInfoScreenOrientationPortrait = "portrait";

            private Companion() {
            }
        }
    }
}
