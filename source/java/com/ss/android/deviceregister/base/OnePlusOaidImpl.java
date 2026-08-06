package com.ss.android.deviceregister.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.heytap.openid.IOpenID;
import com.ss.android.deviceregister.base.OaidApi;
import com.ss.android.deviceregister.base.ServiceBlockBinder;
import com.ss.android.deviceregister.utils.Singleton;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class OnePlusOaidImpl implements OaidApi {
    private final OaidApi mCallback;
    private Singleton<Boolean> support;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnePlusOaidImpl() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnePlusOaidImpl(OaidApi oaidApi) {
        this.support = new Singleton<Boolean>() { // from class: com.ss.android.deviceregister.base.OnePlusOaidImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ss.android.deviceregister.utils.Singleton
            public Boolean create(Object... objArr) {
                long j;
                try {
                    PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    if (packageInfo == null) {
                        return false;
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        j = packageInfo.getLongVersionCode();
                    } else {
                        j = packageInfo.versionCode;
                    }
                    return Boolean.valueOf(j >= 1);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
        this.mCallback = oaidApi;
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        OaidApi oaidApi = this.mCallback;
        return (oaidApi == null || !oaidApi.support(context)) ? this.support.get(context).booleanValue() : this.mCallback.support(context);
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public OaidApi.Result getOaid(final Context context) {
        OaidApi oaidApi = this.mCallback;
        if (oaidApi != null && oaidApi.support(context)) {
            return this.mCallback.getOaid(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new ServiceBlockBinder(context, intent, new ServiceBlockBinder.ServiceBindedListener<IOpenID, String>() { // from class: com.ss.android.deviceregister.base.OnePlusOaidImpl.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public IOpenID asInterface(IBinder iBinder) {
                return IOpenID.Stub.asInterface(iBinder);
            }

            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public String fetchResult(IOpenID iOpenID) throws Exception {
                if (iOpenID == null) {
                    return null;
                }
                String sign = OnePlusOaidImpl.this.getSign(context);
                if (TextUtils.isEmpty(sign)) {
                    return null;
                }
                return iOpenID.getSerID(context.getPackageName(), sign, "OUID");
            }
        }).blockFetchResult();
        OaidApi.Result result = new OaidApi.Result();
        result.oaid = str;
        return result;
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public String getName(Context context) {
        OaidApi oaidApi = this.mCallback;
        return (oaidApi == null || !oaidApi.support(context)) ? "OnePlus/Oppo" : this.mCallback.getName(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002d A[Catch: Exception -> 0x0054, TryCatch #0 {Exception -> 0x0054, blocks: (B:11:0x0025, B:13:0x002d, B:15:0x0039, B:17:0x004f), top: B:10:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getSign(Context context) {
        Signature[] signatureArr;
        MessageDigest messageDigest;
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (packageInfo != null) {
            signatureArr = packageInfo.signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
                        }
                        return sb.toString();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        signatureArr = null;
        if (signatureArr != null) {
            byte[] byteArray2 = signatureArr[0].toByteArray();
            messageDigest = MessageDigest.getInstance("SHA1");
            if (messageDigest != null) {
            }
        }
        return null;
    }
}
