package com.bytedance.common.utility;

import android.content.Context;
import android.content.pm.Signature;
import android.util.DisplayMetrics;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class SignUtils {
    private static final int POS_0 = 0;
    private static final int POS_1 = 1;
    private static final int POS_2 = 2;
    private static final int POS_3 = 3;
    private static final int POS_NUM = 4;

    private SignUtils() {
    }

    public static boolean checkSignature(Context context, String str) {
        Signature[] appSignatures;
        Signature[] apkSignatures = getApkSignatures(context, str);
        if (apkSignatures == null || (appSignatures = getAppSignatures(context)) == null) {
            return true;
        }
        for (Signature signature : appSignatures) {
            for (Signature signature2 : apkSignatures) {
                if (signature.equals(signature2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Signature[] getAppSignatures(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        } catch (Exception e) {
            Logger.w("SignUtils", "failed to get package signatures: " + e);
            return null;
        }
    }

    public static Signature[] getApkSignatures(Context context, String str) {
        Signature[] signatureArr;
        try {
            signatureArr = context.getPackageManager().getPackageArchiveInfo(str, 64).signatures;
        } catch (Exception e) {
            Logger.w("SignUtils", "failed to get package signatures: " + e);
            signatureArr = null;
        }
        return signatureArr == null ? getApkSignaturesCompatible(str) : signatureArr;
    }

    public static byte[] getApkSignature(String str) {
        try {
            Signature[] apkSignaturesCompatible = getApkSignaturesCompatible(str);
            if (apkSignaturesCompatible == null) {
                return null;
            }
            return apkSignaturesCompatible[0].toByteArray();
        } catch (Exception e) {
            Logger.w("SignUtils", "failed to get package signatures: " + e);
            return null;
        }
    }

    private static Signature[] getApkSignaturesCompatible(String str) {
        try {
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            Class[] clsArr = new Class[1];
            Object[] objArr = new Object[1];
            Object newInstance = cls.newInstance();
            new DisplayMetrics().setToDefaults();
            Method declaredMethod = cls.getDeclaredMethod("parsePackage", File.class, Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(newInstance, new File(str), 64);
            cls.getDeclaredMethod("collectCertificates", invoke.getClass(), Integer.TYPE).invoke(newInstance, invoke, 64);
            return (Signature[]) invoke.getClass().getDeclaredField("mSignatures").get(invoke);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
