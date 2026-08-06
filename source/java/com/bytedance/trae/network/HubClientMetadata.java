package com.bytedance.trae.network;

import android.os.Build;
import com.bytedance.trae.platform.service.ApplogService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HubClientMetadata.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/network/HubClientMetadata;", "", "deviceName", "", "<init>", "(Ljava/lang/String;)V", "getDeviceName", "()Ljava/lang/String;", "Companion", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HubClientMetadata {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEFAULT_DEVICE_NAME = "Android";
    private static final int MAX_DEVICE_NAME_LENGTH = 256;
    private final String deviceName;

    public /* synthetic */ HubClientMetadata(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private HubClientMetadata(String str) {
        this.deviceName = str;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    /* compiled from: HubClientMetadata.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\r\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/network/HubClientMetadata$Companion;", "", "<init>", "()V", "MAX_DEVICE_NAME_LENGTH", "", "DEFAULT_DEVICE_NAME", "", "resolve", "Lcom/bytedance/trae/network/HubClientMetadata;", "manufacturer", "model", "deviceId", "fromSystem", "toSafeDeviceName", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HubClientMetadata resolve(String manufacturer, String model, String deviceId) {
            String safeDeviceName = toSafeDeviceName(manufacturer);
            String safeDeviceName2 = toSafeDeviceName(model);
            if (safeDeviceName != null) {
                if (safeDeviceName2 != null) {
                    if (!StringsKt.startsWith(safeDeviceName2, safeDeviceName, true)) {
                        safeDeviceName = StringsKt.take(safeDeviceName + ' ' + safeDeviceName2, 256);
                    }
                }
                if (safeDeviceName == null && (safeDeviceName = toSafeDeviceName(deviceId)) == null) {
                    safeDeviceName = "Android";
                }
                return new HubClientMetadata(safeDeviceName, null);
            }
            safeDeviceName = safeDeviceName2;
            if (safeDeviceName == null) {
                safeDeviceName = "Android";
            }
            return new HubClientMetadata(safeDeviceName, null);
        }

        public final HubClientMetadata fromSystem() {
            return resolve(Build.MANUFACTURER, Build.MODEL, ApplogService.INSTANCE.getDeviceId());
        }

        private final String toSafeDeviceName(String str) {
            String obj;
            if (str != null) {
                String str2 = str;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < str2.length(); i++) {
                    char charAt = str2.charAt(i);
                    if (!Character.isISOControl(charAt)) {
                        sb.append(charAt);
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                if (sb2 != null && (obj = StringsKt.trim(sb2).toString()) != null) {
                    if (!(obj.length() > 0)) {
                        obj = null;
                    }
                    if (obj != null) {
                        return StringsKt.take(obj, 256);
                    }
                }
            }
            return null;
        }
    }
}
