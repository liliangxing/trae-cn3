package com.bytedance.lynx.service.model;

import android.app.Application;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxServiceConfig.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0016\u0018\u0000 /2\u00020\u0001:\u0003-./B\u008d\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010'R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001a¨\u00060"}, d2 = {"Lcom/bytedance/lynx/service/model/LynxServiceConfig;", "", "context", "Landroid/app/Application;", "accessKey", "", "host", "dir", "appId", "appVersion", "updateVersionCode", "deviceId", "region", "channel", "isDebug", "", "monitorHost", "additionInit", "Lkotlin/Function0;", "", "disableGeckoResourceCheck", "settingsHost", "adapterType", "Lcom/bytedance/lynx/service/model/LynxServiceConfig$AdapterType;", "(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;ZLjava/lang/String;Lcom/bytedance/lynx/service/model/LynxServiceConfig$AdapterType;)V", "getAccessKey", "()Ljava/lang/String;", "getAdapterType", "()Lcom/bytedance/lynx/service/model/LynxServiceConfig$AdapterType;", "getAdditionInit", "()Lkotlin/jvm/functions/Function0;", "getAppId", "getAppVersion", "getChannel", "getContext", "()Landroid/app/Application;", "getDeviceId", "getDir", "getDisableGeckoResourceCheck", "()Z", "getHost", "getMonitorHost", "getRegion", "getSettingsHost", "getUpdateVersionCode", "AdapterType", "Builder", "Companion", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class LynxServiceConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DIR_NAME = "offlineX";
    private final String accessKey;
    private final AdapterType adapterType;
    private final Function0<Unit> additionInit;
    private final String appId;
    private final String appVersion;
    private final String channel;
    private final Application context;
    private final String deviceId;
    private final String dir;
    private final boolean disableGeckoResourceCheck;
    private final String host;
    private final boolean isDebug;
    private final String monitorHost;
    private final String region;
    private final String settingsHost;
    private final String updateVersionCode;

    /* compiled from: LynxServiceConfig.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/lynx/service/model/LynxServiceConfig$AdapterType;", "", "(Ljava/lang/String;I)V", "COMMON", "GLOBAL", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum AdapterType {
        COMMON,
        GLOBAL
    }

    public /* synthetic */ LynxServiceConfig(Application application, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10, Function0 function0, boolean z2, String str11, AdapterType adapterType, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10, function0, z2, str11, adapterType);
    }

    private LynxServiceConfig(Application application, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10, Function0<Unit> function0, boolean z2, String str11, AdapterType adapterType) {
        this.context = application;
        this.accessKey = str;
        this.host = str2;
        this.dir = str3;
        this.appId = str4;
        this.appVersion = str5;
        this.updateVersionCode = str6;
        this.deviceId = str7;
        this.region = str8;
        this.channel = str9;
        this.isDebug = z;
        this.monitorHost = str10;
        this.additionInit = function0;
        this.disableGeckoResourceCheck = z2;
        this.settingsHost = str11;
        this.adapterType = adapterType;
    }

    public final Application getContext() {
        return this.context;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getDir() {
        return this.dir;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: isDebug, reason: from getter */
    public final boolean getIsDebug() {
        return this.isDebug;
    }

    public final String getMonitorHost() {
        return this.monitorHost;
    }

    public final Function0<Unit> getAdditionInit() {
        return this.additionInit;
    }

    public final boolean getDisableGeckoResourceCheck() {
        return this.disableGeckoResourceCheck;
    }

    public final String getSettingsHost() {
        return this.settingsHost;
    }

    public final AdapterType getAdapterType() {
        return this.adapterType;
    }

    /* compiled from: LynxServiceConfig.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0086\bø\u0001\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"Lcom/bytedance/lynx/service/model/LynxServiceConfig$Companion;", "", "()V", "DIR_NAME", "", "build", "Lcom/bytedance/lynx/service/model/LynxServiceConfig;", "context", "Landroid/app/Application;", "block", "Lkotlin/Function1;", "Lcom/bytedance/lynx/service/model/LynxServiceConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LynxServiceConfig build(Application context, Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder(context);
            block.invoke(builder);
            return builder.build();
        }
    }

    /* compiled from: LynxServiceConfig.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010 \u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0015J\u000e\u0010&\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010)\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010*\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010+\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010,\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010-\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0004R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/lynx/service/model/LynxServiceConfig$Builder;", "", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "accessKey", "", "adapterType", "Lcom/bytedance/lynx/service/model/LynxServiceConfig$AdapterType;", "additionInit", "Lkotlin/Function0;", "", "appId", "appVersion", "channel", "getContext", "()Landroid/app/Application;", "setContext", "deviceId", "dir", "disableGeckoResourceCheck", "", "host", "isDebug", "monitorHost", "region", "settingsHost", "updateVersionCode", "build", "Lcom/bytedance/lynx/service/model/LynxServiceConfig;", "setAccessKey", "setAdapterType", "setAdditionInit", "setAppId", "setAppVersion", "setChannel", "setDebug", "debug", "setDeviceId", "setDir", "setDisableGeckoResourceCheck", "setHost", "setMonitorHost", "setRegion", "setSettingsHost", "setUpdateVersionCode", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder {
        private String accessKey;
        private AdapterType adapterType;
        private Function0<Unit> additionInit;
        private String appId;
        private String appVersion;
        private String channel;
        private Application context;
        private String deviceId;
        private String dir;
        private boolean disableGeckoResourceCheck;
        private String host;
        private boolean isDebug;
        private String monitorHost;
        private String region;
        private String settingsHost;
        private String updateVersionCode;

        public Builder(Application context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.host = "";
            this.dir = "offlineX";
            this.region = "";
            this.appId = "";
            this.appVersion = "";
            this.channel = "";
            this.updateVersionCode = "";
            this.deviceId = "";
            this.accessKey = "";
            this.monitorHost = "";
            this.additionInit = new Function0<Unit>() { // from class: com.bytedance.lynx.service.model.LynxServiceConfig$Builder$additionInit$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
            this.settingsHost = "";
            this.adapterType = AdapterType.COMMON;
        }

        public final Application getContext() {
            return this.context;
        }

        public final void setContext(Application application) {
            Intrinsics.checkNotNullParameter(application, "<set-?>");
            this.context = application;
        }

        public final void setDebug(boolean debug) {
            this.isDebug = debug;
        }

        public final void setAccessKey(String accessKey) {
            Intrinsics.checkNotNullParameter(accessKey, "accessKey");
            this.accessKey = accessKey;
        }

        public final void setHost(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            this.host = host;
        }

        public final void setDir(String dir) {
            Intrinsics.checkNotNullParameter(dir, "dir");
            this.dir = dir;
        }

        public final void setRegion(String region) {
            Intrinsics.checkNotNullParameter(region, "region");
            this.region = region;
        }

        public final void setAppId(String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            this.appId = appId;
        }

        public final void setAppVersion(String appVersion) {
            Intrinsics.checkNotNullParameter(appVersion, "appVersion");
            this.appVersion = appVersion;
        }

        public final void setChannel(String channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.channel = channel;
        }

        public final void setUpdateVersionCode(String updateVersionCode) {
            Intrinsics.checkNotNullParameter(updateVersionCode, "updateVersionCode");
            this.updateVersionCode = updateVersionCode;
        }

        public final void setDeviceId(String deviceId) {
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            if (deviceId.length() == 0) {
                this.deviceId = "0";
            } else {
                this.deviceId = deviceId;
            }
        }

        public final void setMonitorHost(String monitorHost) {
            Intrinsics.checkNotNullParameter(monitorHost, "monitorHost");
            this.monitorHost = monitorHost;
        }

        public final void setAdditionInit(Function0<Unit> additionInit) {
            Intrinsics.checkNotNullParameter(additionInit, "additionInit");
            this.additionInit = additionInit;
        }

        public final void setDisableGeckoResourceCheck(boolean disableGeckoResourceCheck) {
            this.disableGeckoResourceCheck = disableGeckoResourceCheck;
        }

        public final void setSettingsHost(String settingsHost) {
            Intrinsics.checkNotNullParameter(settingsHost, "settingsHost");
            this.settingsHost = settingsHost;
        }

        public final void setAdapterType(AdapterType adapterType) {
            Intrinsics.checkNotNullParameter(adapterType, "adapterType");
            this.adapterType = adapterType;
        }

        public final LynxServiceConfig build() {
            return new LynxServiceConfig(this.context, this.accessKey, this.host, this.dir, this.appId, this.appVersion, this.updateVersionCode, this.deviceId, this.region, this.channel, this.isDebug, this.monitorHost, this.additionInit, this.disableGeckoResourceCheck, this.settingsHost, this.adapterType, null);
        }
    }
}
