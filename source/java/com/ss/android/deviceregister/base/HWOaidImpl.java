package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.oaid.uodis.OpenDeviceIdentifierService;
import com.ss.android.deviceregister.base.OaidApi;
import com.ss.android.deviceregister.base.ServiceBlockBinder;
import com.ss.android.deviceregister.utils.Singleton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class HWOaidImpl implements OaidApi {
    private static final String ACTION = "com.uodis.opendevice.OPENIDS_SERVICE";
    private static final String HWID = "com.huawei.hwid";
    private static final Singleton<Boolean> support = new Singleton<Boolean>() { // from class: com.ss.android.deviceregister.base.HWOaidImpl.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ss.android.deviceregister.utils.Singleton
        public Boolean create(Object... objArr) {
            return Boolean.valueOf(OaidWrapper.isPackageExisted((Context) objArr[0], HWOaidImpl.HWID));
        }
    };

    @Override // com.ss.android.deviceregister.base.OaidApi
    public String getName(Context context) {
        return "HW";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSupport(Context context) {
        if (context == null) {
            return false;
        }
        return support.get(context).booleanValue();
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public boolean support(Context context) {
        return isSupport(context);
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public OaidApi.Result getOaid(Context context) {
        OaidApi.Result result = new OaidApi.Result();
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
            if (!TextUtils.isEmpty(string)) {
                result.oaid = string;
                result.isTrackLimit = Boolean.parseBoolean(string2);
                result.versionCode = 202003021704L;
                return result;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Pair<String, Boolean> tryFetchResult = tryFetchResult(context);
        if (tryFetchResult != null) {
            result.oaid = (String) tryFetchResult.first;
            result.isTrackLimit = ((Boolean) tryFetchResult.second).booleanValue();
            result.versionCode = getHwIdVersionCode(context);
        }
        return result;
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
        return (Pair) new ServiceBlockBinder(context, new Intent(ACTION).setPackage(HWID), new ServiceBlockBinder.ServiceBindedListener<OpenDeviceIdentifierService, Pair<String, Boolean>>() { // from class: com.ss.android.deviceregister.base.HWOaidImpl.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public OpenDeviceIdentifierService asInterface(IBinder iBinder) {
                return OpenDeviceIdentifierService.Stub.asInterface(iBinder);
            }

            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public Pair<String, Boolean> fetchResult(OpenDeviceIdentifierService openDeviceIdentifierService) throws Exception {
                if (openDeviceIdentifierService == null) {
                    return null;
                }
                return new Pair<>(openDeviceIdentifierService.getOaid(), Boolean.valueOf(openDeviceIdentifierService.isOaidTrackLimited()));
            }
        }).blockFetchResult();
    }
}
