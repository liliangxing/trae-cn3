package com.bytedance.salamander.adapter;

import android.os.Build;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import com.bytedance.rts.foundation.RTSStringKt;
import com.xiaomi.mipush.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FoundationDeviceImpl.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/salamander/adapter/DeviceInfoImpl;", "Lcom/bytedance/salamander/adapter/DeviceInfoProvider;", "()V", Constants.PHONE_BRAND, "", "isSimulator", "", "modelID", "modelName", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class DeviceInfoImpl implements DeviceInfoProvider {
    @Override // com.bytedance.salamander.adapter.DeviceInfoProvider
    public String modelName() {
        return "Unknown";
    }

    @Override // com.bytedance.salamander.adapter.DeviceInfoProvider
    public boolean isSimulator() {
        String str = Build.FINGERPRINT;
        Intrinsics.checkNotNull(str);
        if (!StringsKt.startsWith$default(str, "generic", false, 2, (Object) null)) {
            String str2 = Build.FINGERPRINT;
            Intrinsics.checkNotNull(str2);
            if (!StringsKt.startsWith$default(str2, "unknown", false, 2, (Object) null)) {
                String str3 = Build.MODEL;
                Intrinsics.checkNotNull(str3);
                if (!RTSStringKt.includes$default(str3, "google_sdk", 0, 2, null)) {
                    String str4 = Build.MODEL;
                    Intrinsics.checkNotNull(str4);
                    String lowerCase = RTSStringKt.toLowerCase(str4);
                    Intrinsics.checkNotNull(lowerCase);
                    if (!RTSStringKt.includes$default(lowerCase, "droid4x", 0, 2, null)) {
                        String str5 = Build.MODEL;
                        Intrinsics.checkNotNull(str5);
                        if (!RTSStringKt.includes$default(str5, "Emulator", 0, 2, null)) {
                            String str6 = Build.MODEL;
                            Intrinsics.checkNotNull(str6);
                            if (!RTSStringKt.includes$default(str6, "Android SDK built for x86", 0, 2, null)) {
                                String str7 = Build.MANUFACTURER;
                                Intrinsics.checkNotNull(str7);
                                if (!RTSStringKt.includes$default(str7, "Genymotion", 0, 2, null)) {
                                    String str8 = Build.HARDWARE;
                                    Intrinsics.checkNotNull(str8);
                                    if (!RTSStringKt.includes$default(str8, "goldfish", 0, 2, null)) {
                                        String str9 = Build.HARDWARE;
                                        Intrinsics.checkNotNull(str9);
                                        if (!RTSStringKt.includes$default(str9, "ranchu", 0, 2, null)) {
                                            String str10 = Build.HARDWARE;
                                            Intrinsics.checkNotNull(str10);
                                            if (!RTSStringKt.includes$default(str10, "vbox86", 0, 2, null)) {
                                                String str11 = Build.PRODUCT;
                                                Intrinsics.checkNotNull(str11);
                                                if (!RTSStringKt.includes$default(str11, MonitorConstants.MONITOR_FROM_SDK, 0, 2, null)) {
                                                    String str12 = Build.PRODUCT;
                                                    Intrinsics.checkNotNull(str12);
                                                    if (!RTSStringKt.includes$default(str12, "google_sdk", 0, 2, null)) {
                                                        String str13 = Build.PRODUCT;
                                                        Intrinsics.checkNotNull(str13);
                                                        if (!RTSStringKt.includes$default(str13, "sdk_google", 0, 2, null)) {
                                                            String str14 = Build.PRODUCT;
                                                            Intrinsics.checkNotNull(str14);
                                                            if (!RTSStringKt.includes$default(str14, "sdk_x86", 0, 2, null)) {
                                                                String str15 = Build.PRODUCT;
                                                                Intrinsics.checkNotNull(str15);
                                                                if (!RTSStringKt.includes$default(str15, "vbox86p", 0, 2, null)) {
                                                                    String str16 = Build.PRODUCT;
                                                                    Intrinsics.checkNotNull(str16);
                                                                    if (!RTSStringKt.includes$default(str16, "emulator", 0, 2, null)) {
                                                                        String str17 = Build.PRODUCT;
                                                                        Intrinsics.checkNotNull(str17);
                                                                        if (!RTSStringKt.includes$default(str17, "simulator", 0, 2, null)) {
                                                                            String str18 = Build.BOARD;
                                                                            Intrinsics.checkNotNull(str18);
                                                                            String lowerCase2 = RTSStringKt.toLowerCase(str18);
                                                                            Intrinsics.checkNotNull(lowerCase2);
                                                                            if (!RTSStringKt.includes$default(lowerCase2, "nox", 0, 2, null)) {
                                                                                String str19 = Build.BOOTLOADER;
                                                                                Intrinsics.checkNotNull(str19);
                                                                                String lowerCase3 = RTSStringKt.toLowerCase(str19);
                                                                                Intrinsics.checkNotNull(lowerCase3);
                                                                                if (!RTSStringKt.includes$default(lowerCase3, "nox", 0, 2, null)) {
                                                                                    String str20 = Build.HARDWARE;
                                                                                    Intrinsics.checkNotNull(str20);
                                                                                    String lowerCase4 = RTSStringKt.toLowerCase(str20);
                                                                                    Intrinsics.checkNotNull(lowerCase4);
                                                                                    if (!RTSStringKt.includes$default(lowerCase4, "nox", 0, 2, null)) {
                                                                                        String str21 = Build.PRODUCT;
                                                                                        Intrinsics.checkNotNull(str21);
                                                                                        String lowerCase5 = RTSStringKt.toLowerCase(str21);
                                                                                        Intrinsics.checkNotNull(lowerCase5);
                                                                                        if (!RTSStringKt.includes$default(lowerCase5, "nox", 0, 2, null)) {
                                                                                            String str22 = Build.SERIAL;
                                                                                            Intrinsics.checkNotNull(str22);
                                                                                            String lowerCase6 = RTSStringKt.toLowerCase(str22);
                                                                                            Intrinsics.checkNotNull(lowerCase6);
                                                                                            if (!RTSStringKt.includes$default(lowerCase6, "nox", 0, 2, null)) {
                                                                                                String str23 = Build.BRAND;
                                                                                                Intrinsics.checkNotNull(str23);
                                                                                                if (!StringsKt.startsWith$default(str23, "generic", false, 2, (Object) null)) {
                                                                                                    return false;
                                                                                                }
                                                                                                String str24 = Build.DEVICE;
                                                                                                Intrinsics.checkNotNull(str24);
                                                                                                if (!StringsKt.startsWith$default(str24, "generic", false, 2, (Object) null)) {
                                                                                                    return false;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // com.bytedance.salamander.adapter.DeviceInfoProvider
    public String brand() {
        String str = Build.BRAND;
        return str == null ? "" : str;
    }

    @Override // com.bytedance.salamander.adapter.DeviceInfoProvider
    public String modelID() {
        String str = Build.MODEL;
        return str == null ? "" : str;
    }
}
