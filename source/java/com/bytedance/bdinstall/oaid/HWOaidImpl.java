package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.oaid.OaidApi;
import com.bytedance.bdinstall.oaid.ServiceBlockBinder;
import com.bytedance.bdinstall.oaid.uodis.OpenDeviceIdentifierService;
import com.bytedance.bdinstall.util.Singleton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class HWOaidImpl implements OaidApi {
    private static final String ACTION = "com.uodis.opendevice.OPENIDS_SERVICE";
    private static final String HWID = "com.huawei.hwid";
    private static final Singleton<Boolean> support = new Singleton<Boolean>() { // from class: com.bytedance.bdinstall.oaid.HWOaidImpl.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public Boolean create(Object... objArr) {
            return Boolean.valueOf(Oaid.isPackageExisted((Context) objArr[0], HWOaidImpl.HWID));
        }
    };

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Huawei";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSupport(Context context) {
        if (context == null) {
            return false;
        }
        return support.get(context).booleanValue();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context context) {
        return isSupport(context);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public HWOaid getOaid(Context context) {
        HWOaid hWOaid = new HWOaid();
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
            if (!TextUtils.isEmpty(string)) {
                hWOaid.oaid = string;
                hWOaid.isTrackLimit = Boolean.parseBoolean(string2);
                hWOaid.versionCode = 202003021704L;
                return hWOaid;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Pair<String, Boolean> tryFetchResult = tryFetchResult(context);
        if (tryFetchResult != null) {
            hWOaid.oaid = (String) tryFetchResult.first;
            hWOaid.isTrackLimit = ((Boolean) tryFetchResult.second).booleanValue();
            hWOaid.versionCode = getHwIdVersionCode(context);
        }
        return hWOaid;
    }

    private static int getHwIdVersionCode(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(HWID, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static Pair<String, Boolean> tryFetchResult(Context context) {
        return (Pair) new ServiceBlockBinder(context, new Intent(ACTION).setPackage(HWID), new ServiceBlockBinder.ServiceBindedListener<OpenDeviceIdentifierService, Pair<String, Boolean>>() { // from class: com.bytedance.bdinstall.oaid.HWOaidImpl.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public OpenDeviceIdentifierService asInterface(IBinder iBinder) {
                return OpenDeviceIdentifierService.Stub.asInterface(iBinder);
            }

            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public Pair<String, Boolean> fetchResult(OpenDeviceIdentifierService openDeviceIdentifierService) throws Exception {
                if (openDeviceIdentifierService == null) {
                    return null;
                }
                return new Pair<>(openDeviceIdentifierService.getOaid(), Boolean.valueOf(openDeviceIdentifierService.isOaidTrackLimited()));
            }
        }).blockFetchResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class HWOaid extends OaidApi.Result {
        long versionCode = 0;

        HWOaid() {
        }
    }
}
