package com.bytedance.mt.protector;

import android.util.Log;
import com.bytedance.keva.Keva;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

/* loaded from: classes4.dex */
public class ProtectorCallbackDefault implements IProtectorCallback {
    private static String PROTECTOR_THROWABLE_KEY = "protector_throwable_key";
    private static String PROTECTOR_THROWABLE_REPO = "protector_throwable_repo";
    public static final String TAG = "SafeCushion";

    @Override // com.bytedance.mt.protector.IProtectorCallback
    public void reportCustomException(Throwable th, String str, String str2, Map<String, String> map) {
    }

    @Override // com.bytedance.mt.protector.IProtectorCallback
    public void logd(String str, String str2, int i) {
        Log.d(str, str2);
    }

    @Override // com.bytedance.mt.protector.IProtectorCallback
    public void logi(String str, String str2, int i) {
        Log.i(str, str2);
    }

    @Override // com.bytedance.mt.protector.IProtectorCallback
    public void loge(String str, String str2, int i) {
        Log.e(str, str2);
    }

    @Override // com.bytedance.mt.protector.IProtectorCallback
    public void loge(String str, String str2, Throwable th, int i) {
        Log.e(str, str2, th);
    }

    @Override // com.bytedance.mt.protector.IProtectorCallback
    public void onProtected(ProtectorType protectorType, Throwable th) {
        Log.e(TAG, "onProtected " + protectorType.getName(), th);
        if (th != null) {
            Keva repo = Keva.getRepo(PROTECTOR_THROWABLE_REPO, 1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            repo.storeString(PROTECTOR_THROWABLE_KEY, byteArrayOutputStream.toString());
        }
    }

    @Override // com.bytedance.mt.protector.IProtectorCallback
    public void onReachProtector(ProtectorType protectorType, Throwable th) {
        Log.e(TAG, "onReachProtector " + protectorType.getName(), th);
    }

    public static String getLastProtectorStack() {
        Keva repo = Keva.getRepo(PROTECTOR_THROWABLE_REPO, 1);
        String string = repo.getString(PROTECTOR_THROWABLE_KEY, "");
        repo.clear();
        return string;
    }
}
