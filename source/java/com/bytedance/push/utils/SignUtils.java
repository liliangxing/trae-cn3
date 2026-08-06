package com.bytedance.push.utils;

import android.util.Base64;
import android.util.Log;
import com.bytedance.android.sdk.bdticketguard.key.TeeKeyHelperKt;
import com.bytedance.push.interfaze.ISDKMonitor;
import com.ss.android.ug.bus.UgBusFramework;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: classes4.dex */
public class SignUtils {

    /* loaded from: classes4.dex */
    public static class Result {
        public String msg;
        public boolean result;
    }

    public static Result verifySign(String str, String str2, String str3) {
        Result result = new Result();
        try {
            Logger.v("Sign", "c = " + str + ", key = " + str2 + ", sig = " + str3);
            PublicKey generatePublic = KeyFactory.getInstance(TeeKeyHelperKt.KEY_PAIR_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
            byte[] bytes = str.getBytes("UTF-8");
            byte[] decode = Base64.decode(str3, 8);
            Signature signature = Signature.getInstance(TeeKeyHelperKt.SIGNATURE_ALGORITHM);
            signature.initVerify(generatePublic);
            signature.update(bytes);
            result.result = signature.verify(decode);
            if (result.result) {
                result.msg = "success";
            } else {
                result.msg = "verify failed when call verify method";
            }
        } catch (Throwable th) {
            ((ISDKMonitor) UgBusFramework.getService(ISDKMonitor.class)).ensureNotReachHere(th);
            result.msg = "exception : " + Log.getStackTraceString(th);
            result.result = false;
        }
        return result;
    }
}
