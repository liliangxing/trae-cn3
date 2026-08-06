package com.bytedance.trae.applog.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.BDInstallInitHook;
import com.bytedance.applog.InitConfig;
import com.bytedance.bdinstall.Builder;
import com.bytedance.bdinstall.ISstInfoProvider;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.ss.android.deviceregister.DeviceRegisterManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AppLogInitHookHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper;", "", "<init>", "()V", "TAG", "", "preInit", "", "setupInitHook", "config", "Lcom/bytedance/applog/InitConfig;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppLogInitHookHelper {
    public static final AppLogInitHookHelper INSTANCE = new AppLogInitHookHelper();
    private static final String TAG = "AppLogInitHookHelper";

    private AppLogInitHookHelper() {
    }

    public final void preInit() {
        try {
            AppHost.INSTANCE.getApplication().getSharedPreferences("ug_install_settings_pref", 0).edit().putString("serial_number", "").apply();
            DeviceRegisterManager.checkPermissionBeforeCallSensitiveApi(true);
        } catch (Throwable th) {
            TraeLogUtil.INSTANCE.w(TAG, "detect serial_number failed", th);
        }
    }

    public final void setupInitHook(InitConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setBDInstallInitHook(new BDInstallInitHook() { // from class: com.bytedance.trae.applog.impl.AppLogInitHookHelper$setupInitHook$1
            public void afterHook() {
            }

            public void beforeInit(Builder builder) {
                if (builder != null) {
                    builder.setSSTInfoProvider(new ISstInfoProvider() { // from class: com.bytedance.trae.applog.impl.AppLogInitHookHelper$setupInitHook$1$beforeInit$1
                        public String getDefaultImeiOrMeid(Context context, InstallOptions options) {
                            return "";
                        }

                        public String getImei(Context context, int slotIndex, InstallOptions options) {
                            return "";
                        }

                        public String getMac(Context context, InstallOptions options) {
                            return "";
                        }

                        public String getMeid(Context context, int slotIndex, InstallOptions options) {
                            return "";
                        }

                        public String[] getSimSerialNumbers(Context context, InstallOptions options) {
                            return new String[0];
                        }

                        public String reflectGetDeviceIdWithSlotIndex(Context context, int slotIndex) {
                            return "";
                        }

                        public String getSerial(Context context, InstallOptions options) {
                            TraeLogUtil.INSTANCE.d("getSerial", "getSerial callback");
                            return "";
                        }

                        public JSONArray getIPV6Address(Context context) {
                            String upperCase;
                            String str;
                            String str2;
                            String upperCase2;
                            List emptyList;
                            String str3 = "dummy0";
                            String str4 = "iterator(...)";
                            JSONArray jSONArray = new JSONArray();
                            try {
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            if (NetworkInterface.getNetworkInterfaces() == null) {
                                return new JSONArray();
                            }
                            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                            while (it.hasNext()) {
                                NetworkInterface networkInterface = (NetworkInterface) it.next();
                                String name = networkInterface.getName();
                                if (Intrinsics.areEqual(str3, name) || Intrinsics.areEqual("wlan0", name)) {
                                    Iterator it2 = Collections.list(networkInterface.getInetAddresses()).iterator();
                                    Intrinsics.checkNotNullExpressionValue(it2, str4);
                                    while (it2.hasNext()) {
                                        String hostAddress = ((InetAddress) it2.next()).getHostAddress();
                                        if (!TextUtils.isEmpty(hostAddress)) {
                                            Intrinsics.checkNotNull(hostAddress);
                                            if (!(StringsKt.indexOf$default(hostAddress, ':', 0, false, 6, (Object) null) < 0)) {
                                                int indexOf$default = StringsKt.indexOf$default(hostAddress, '%', 0, false, 6, (Object) null);
                                                if (Intrinsics.areEqual(str3, name)) {
                                                    JSONObject jSONObject = new JSONObject();
                                                    jSONObject.put(DBData.FIELD_TYPE, "client_tun");
                                                    if (indexOf$default < 0) {
                                                        Locale locale = Locale.getDefault();
                                                        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                                                        upperCase = hostAddress.toUpperCase(locale);
                                                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                                                    } else {
                                                        String substring = hostAddress.substring(0, indexOf$default);
                                                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                                        Locale locale2 = Locale.getDefault();
                                                        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                                                        upperCase = substring.toUpperCase(locale2);
                                                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                                                    }
                                                    jSONObject.put("value", upperCase);
                                                    jSONArray.put(jSONObject);
                                                } else {
                                                    if (Intrinsics.areEqual("wlan0", name)) {
                                                        str = str3;
                                                        str2 = str4;
                                                    } else {
                                                        str = str3;
                                                        str2 = str4;
                                                        List split = new Regex("::").split(hostAddress, 0);
                                                        if (!split.isEmpty()) {
                                                            ListIterator listIterator = split.listIterator(split.size());
                                                            while (listIterator.hasPrevious()) {
                                                                if (!(((String) listIterator.previous()).length() == 0)) {
                                                                    emptyList = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        emptyList = CollectionsKt.emptyList();
                                                        if (StringsKt.equals("fe80", ((String[]) emptyList.toArray(new String[0]))[0], true)) {
                                                        }
                                                        str3 = str;
                                                        str4 = str2;
                                                    }
                                                    JSONObject jSONObject2 = new JSONObject();
                                                    jSONObject2.put(DBData.FIELD_TYPE, "client_anpi");
                                                    if (indexOf$default < 0) {
                                                        Locale locale3 = Locale.getDefault();
                                                        Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
                                                        upperCase2 = hostAddress.toUpperCase(locale3);
                                                        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                                                    } else {
                                                        String substring2 = hostAddress.substring(0, indexOf$default);
                                                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                                        Locale locale4 = Locale.getDefault();
                                                        Intrinsics.checkNotNullExpressionValue(locale4, "getDefault(...)");
                                                        upperCase2 = substring2.toUpperCase(locale4);
                                                        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                                                    }
                                                    jSONObject2.put("value", upperCase2);
                                                    jSONArray.put(jSONObject2);
                                                    str3 = str;
                                                    str4 = str2;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return jSONArray;
                        }
                    });
                }
            }
        });
    }
}
