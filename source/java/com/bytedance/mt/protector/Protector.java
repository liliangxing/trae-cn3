package com.bytedance.mt.protector;

import com.bytedance.keva.Keva;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class Protector {
    private static final int COMMON_INIT = 2;
    private static final int IMMEDIATELY_INIT = 1;
    private static final int UNINIT = 0;
    private static volatile boolean canWorking;
    private static volatile boolean mEnable;
    private static volatile boolean mHasSetConf;
    private static volatile int mInitType;
    private static volatile IProtectorCallback mCallback = new ProtectorCallbackDefault();
    private static String PROTECTOR_CONFIG_REPO_NAME = "safe_protector_config_repo";
    private static String PROTECTOR_CONFIG_KEY = "safe_protector_config_key";
    private static String PROTECTOR_ENABLE_KEY = "safe_protector_enable_key";
    private static String INTERNAL_EXCEPTION = "safe_protector_internal_exception";

    public static void init(boolean z) {
        mEnable = z;
        mInitType = 2;
        Keva.getRepo(PROTECTOR_CONFIG_REPO_NAME, 1).storeBoolean(PROTECTOR_ENABLE_KEY, mEnable);
    }

    public static void register(IProtectorCallback iProtectorCallback) {
        mCallback = iProtectorCallback;
    }

    public static void setConf(JsonArray jsonArray) {
        LogUtils.m114i("setConf");
        ThrowableDisposer.getInstance().setConf(jsonArray);
        mHasSetConf = true;
        Keva.getRepo(PROTECTOR_CONFIG_REPO_NAME, 1).storeString(PROTECTOR_CONFIG_KEY, jsonArray != null ? jsonArray.toString() : "[]");
    }

    private static void loadConfImmediately() {
        if (mHasSetConf) {
            return;
        }
        String string = Keva.getRepo(PROTECTOR_CONFIG_REPO_NAME, 1).getString(PROTECTOR_CONFIG_KEY, "[]");
        LogUtils.m114i(String.format("loadConfImmediately lastConfig %s", string));
        try {
            setConf(new JsonParser().parse(string).getAsJsonArray());
        } catch (Throwable th) {
            String str = INTERNAL_EXCEPTION;
            reportCustomException(th, str, str);
        }
    }

    public static ThrowableDisposerResult disposeThrowable(ProtectorType protectorType, Throwable th) {
        ThrowableDisposerResult throwableDisposerResult;
        IProtectorCallback callback = getCallback();
        if (callback != null) {
            try {
                throwableDisposerResult = ThrowableDisposer.getInstance().disposeThrowable(protectorType, th);
            } catch (Throwable th2) {
                String str = INTERNAL_EXCEPTION;
                reportCustomException(th2, str, str);
                throwableDisposerResult = null;
            }
            if (throwableDisposerResult != null) {
                callback.onProtected(protectorType, th);
                return throwableDisposerResult;
            }
            callback.onReachProtector(protectorType, th);
        }
        return null;
    }

    public static void unInit() {
        mCallback = new ProtectorCallbackDefault();
        mEnable = false;
        mHasSetConf = false;
        mInitType = 0;
    }

    public static void setCanWorking(boolean z) {
        canWorking = z;
    }

    public static boolean getCanWorking() {
        return canWorking;
    }

    public static boolean enable() {
        if (!getCanWorking()) {
            return false;
        }
        if (mInitType == 0) {
            mEnable = Keva.getRepo(PROTECTOR_CONFIG_REPO_NAME, 1).getBoolean(PROTECTOR_ENABLE_KEY, mEnable);
            mInitType = 1;
            loadConfImmediately();
            LogUtils.m114i(String.format("IMMEDIATELY_INIT lastEnable: %b", Boolean.valueOf(mEnable)));
        }
        return mEnable;
    }

    public static IProtectorCallback getCallback() {
        return mCallback;
    }

    public static JsonElement getSelfData() {
        return SelfDataManager.getInstance().toJsonObject();
    }

    public static String getLastProtectorStack() {
        return ProtectorCallbackDefault.getLastProtectorStack();
    }

    public static void reportCustomException(Throwable th, String str, String str2) {
        HashMap hashMap = new HashMap();
        JsonObject jsonObject = SelfDataManager.getInstance().toJsonObject(th);
        if (jsonObject != null) {
            hashMap.put("Protector/SelfData", jsonObject.toString());
        }
        getCallback().reportCustomException(th, str, str2, hashMap);
    }

    public static void reportCustomException(Throwable th, String str) {
        reportCustomException(th, str, "TYPE_CRASH_CUSTOMER_EXCEPTION");
    }
}
