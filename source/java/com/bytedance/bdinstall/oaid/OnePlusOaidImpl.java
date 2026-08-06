package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.OaidApi;
import com.bytedance.bdinstall.oaid.ServiceBlockBinder;
import com.bytedance.bdinstall.oaid.impl.IOpenID;
import com.bytedance.bdinstall.util.Singleton;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class OnePlusOaidImpl implements OaidApi {
    private final OaidApi mFallback;
    private Singleton<Boolean> support;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnePlusOaidImpl() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnePlusOaidImpl(OaidApi oaidApi) {
        this.support = new Singleton<Boolean>() { // from class: com.bytedance.bdinstall.oaid.OnePlusOaidImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.bdinstall.util.Singleton
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
                } catch (Exception unused) {
                    return false;
                }
            }
        };
        this.mFallback = oaidApi;
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        Boolean bool = this.support.get(context);
        if (this.mFallback != null && !bool.booleanValue()) {
            return this.mFallback.support(context);
        }
        return bool.booleanValue();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(final Context context) {
        if (this.mFallback != null && !this.support.get(new Object[0]).booleanValue()) {
            return this.mFallback.getOaid(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new ServiceBlockBinder(context, intent, new ServiceBlockBinder.ServiceBindedListener<IOpenID, String>() { // from class: com.bytedance.bdinstall.oaid.OnePlusOaidImpl.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public IOpenID asInterface(IBinder iBinder) {
                return IOpenID.Stub.asInterface(iBinder);
            }

            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
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

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return (this.mFallback == null || this.support.get(new Object[0]).booleanValue()) ? "OnePlus/Oppo" : this.mFallback.getName();
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
