package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.webx.addr.AddressParam;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.ipc.HonorApiAvailability$PackageStates;
import java.io.Closeable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/* renamed from: com.hihonor.push.sdk.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0909b {
    /* renamed from: a */
    public static String m745a(byte[] bArr) {
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m747a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e) {
            C0912c.m757a("DeflateUtil", "close", e);
        }
    }

    /* renamed from: a */
    public static byte[] m748a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        try {
            byte[] bytes = upperCase.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (((byte) (Byte.decode("0x" + new String(new byte[]{bytes[i2]}, StandardCharsets.UTF_8)).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i2 + 1]}, StandardCharsets.UTF_8)).byteValue());
            }
        } catch (NumberFormatException e) {
            String str2 = "hex string 2 byte array exception : " + e.getMessage();
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m749a(byte[] bArr, int i) {
        if (bArr == null) {
            return bArr;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (i < 0) {
                bArr[i2] = (byte) (bArr[i2] << (-i));
            } else {
                bArr[i2] = (byte) (bArr[i2] >> i);
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m750a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr != null) {
            int length = bArr.length;
            if (bArr2.length != length) {
                return null;
            }
            bArr3 = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
            }
        }
        return bArr3;
    }

    /* renamed from: b */
    public static int m751b(Context context) {
        HonorApiAvailability$PackageStates honorApiAvailability$PackageStates;
        if (context != null) {
            RemoteServiceBean m741a = m741a(context);
            String packageName = m741a.getPackageName();
            String str = "service package name is " + packageName;
            if (TextUtils.isEmpty(packageName)) {
                honorApiAvailability$PackageStates = HonorApiAvailability$PackageStates.NOT_INSTALLED;
            } else {
                try {
                    if (context.getPackageManager().getApplicationInfo(packageName, 0).enabled) {
                        honorApiAvailability$PackageStates = HonorApiAvailability$PackageStates.ENABLED;
                    } else {
                        honorApiAvailability$PackageStates = HonorApiAvailability$PackageStates.DISABLED;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    honorApiAvailability$PackageStates = HonorApiAvailability$PackageStates.NOT_INSTALLED;
                }
            }
            if (HonorApiAvailability$PackageStates.NOT_INSTALLED.equals(honorApiAvailability$PackageStates)) {
                Log.i("HonorApiAvailability", "push service is not installed");
                return 8002008;
            }
            if (HonorApiAvailability$PackageStates.DISABLED.equals(honorApiAvailability$PackageStates)) {
                Log.i("HonorApiAvailability", "push service is disabled");
                return 8002007;
            }
            if (!TextUtils.equals(packageName, "android") || TextUtils.isEmpty(m741a.getPackageSignature())) {
                return 8002006;
            }
            return HonorPushErrorEnum.SUCCESS.statusCode;
        }
        throw new NullPointerException("context must not be null.");
    }

    /* renamed from: a */
    public static <TResult> C0908a1<TResult> m740a(Callable<TResult> callable) {
        ExecutorService executorService = C0945o0.f747c.f749b;
        C0943n0 c0943n0 = new C0943n0();
        try {
            executorService.execute(new RunnableC0967z0(c0943n0, callable));
        } catch (Exception e) {
            c0943n0.m776a(e);
        }
        return c0943n0.f745a;
    }

    /* renamed from: a */
    public static void m746a(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }

    /* renamed from: a */
    public static <TResult> TResult m743a(C0908a1<TResult> c0908a1) throws ExecutionException, InterruptedException {
        boolean z;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (c0908a1.f684a) {
                z = c0908a1.f685b;
            }
            if (!z) {
                C0965y0 c0965y0 = new C0965y0();
                C0945o0 c0945o0 = C0945o0.f747c;
                c0908a1.m733a(new C0963x0(c0945o0.f748a, c0965y0)).m733a(new C0959v0(c0945o0.f748a, c0965y0)).m733a(new C0951r0(c0945o0.f748a, c0965y0));
                c0965y0.f791a.await();
            }
            if (c0908a1.m738e()) {
                return c0908a1.m736c();
            }
            throw new ExecutionException(c0908a1.m735b());
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    /* renamed from: a */
    public static RequestHeader m739a() throws ApiException {
        String string;
        Context m773a = C0937l.f734e.m773a();
        String str = null;
        try {
            Object obj = m773a.getPackageManager().getApplicationInfo(m773a.getPackageName(), 128).metaData.get("com.hihonor.push.app_id");
            if (obj != null) {
                str = String.valueOf(obj);
            }
        } catch (PackageManager.NameNotFoundException e) {
            C0912c.m757a("ConfigUtils", "getPushAppId", e);
        }
        if (!TextUtils.isEmpty(str)) {
            String str2 = "checkPushAppId Parameter is " + str;
            String m744a = m744a(m773a, m773a.getPackageName());
            if (!TextUtils.isEmpty(m744a)) {
                String str3 = "checkPushCertFingerprint Parameter is " + m744a;
                RequestHeader requestHeader = new RequestHeader();
                requestHeader.setPackageName(m773a.getPackageName());
                requestHeader.setAppId(str);
                requestHeader.setCertificateFingerprint(m744a);
                C0916d c0916d = C0916d.f695b;
                requestHeader.setPushToken(c0916d.m761b(m773a));
                synchronized (c0916d) {
                    c0916d.m759a(m773a);
                    SharedPreferences sharedPreferences = C0916d.f694a.f725a;
                    string = sharedPreferences != null ? sharedPreferences.getString("key_aaid", "") : "";
                    if (TextUtils.isEmpty(string)) {
                        string = UUID.randomUUID().toString().replace("-", "");
                        String str4 = "getRandomUUID UUID =" + string;
                        C0916d.f694a.m769a("key_aaid", string);
                    }
                }
                requestHeader.setAAID(string);
                requestHeader.setSdkVersion(70061303);
                return requestHeader;
            }
            C0912c.m756a("checkPushConfig Parameter is missing.");
            throw HonorPushErrorEnum.ERROR_CERT_FINGERPRINT_EMPTY.toApiException();
        }
        C0912c.m756a("checkPushConfig Parameter is missing");
        throw HonorPushErrorEnum.ERROR_NO_APPID.toApiException();
    }

    /* renamed from: a */
    public static ApiException m742a(Exception exc) {
        if (exc.getCause() instanceof ApiException) {
            return (ApiException) exc.getCause();
        }
        if (exc instanceof ApiException) {
            return (ApiException) exc;
        }
        return new ApiException(-1, exc.getMessage());
    }

    /* renamed from: a */
    public static RemoteServiceBean m741a(Context context) {
        RemoteServiceBean remoteServiceBean = new RemoteServiceBean();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("android", "com.hihonor.android.pushagentproxy.HiPushService"));
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices.size() > 0) {
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                String str = next.serviceInfo.applicationInfo.packageName;
                String m744a = m744a(context, str);
                remoteServiceBean.setPackageName(str);
                remoteServiceBean.setPackageServiceName(next.serviceInfo.name);
                remoteServiceBean.setPackageSignature(m744a);
            }
        }
        return remoteServiceBean;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x004b -> B:12:0x004c). Please report as a decompilation issue!!! */
    /* renamed from: a */
    public static String m744a(Context context, String str) {
        Signature[] signatureArr;
        String str2;
        SigningInfo signingInfo;
        String str3 = "getCertFingerprint pkgName=" + str + "isOnlyOne=true";
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 30) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
            if (packageInfo != null && (signingInfo = packageInfo.signingInfo) != null) {
                if (signingInfo.hasMultipleSigners()) {
                    signatureArr = signingInfo.getApkContentsSigners();
                } else {
                    signatureArr = signingInfo.getSigningCertificateHistory();
                }
            }
            signatureArr = null;
        } else {
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 64);
            if (packageInfo2 != null) {
                signatureArr = packageInfo2.signatures;
            }
            signatureArr = null;
        }
        if (signatureArr != null && signatureArr.length > 0) {
            int length = signatureArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                try {
                    byte[] digest = MessageDigest.getInstance("SHA256").digest(signatureArr[i].toByteArray());
                    StringBuilder sb = new StringBuilder();
                    for (byte b : digest) {
                        String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.ENGLISH);
                        if (upperCase.length() == 1) {
                            sb.append(AddressParam.TYPE_DISAPPROVE);
                        }
                        sb.append(upperCase);
                    }
                    str2 = sb.toString();
                } catch (NoSuchAlgorithmException unused) {
                    str2 = null;
                }
                if (str2 != null) {
                    arrayList.add(str2);
                    break;
                }
                i++;
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String) arrayList.get(0);
    }
}
