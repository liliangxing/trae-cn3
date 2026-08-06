package com.ss.bduploader;

import android.util.Log;
import com.ss.bduploader.util.BDUrlDispatch;
import com.ss.bduploader.util.CustomVerify;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BDAbstractUpload {
    protected static boolean IsErrored = false;
    public static final int KeyIsBatchSessionKey = 420;
    public static final int KeyIsCustomHttpHeaders = 430;
    public static final int KeyIsDiskResumeDir = 303;
    public static final int KeyIsDiskResumeOption = 302;
    public static final int KeyIsDiskResumeUniqueKey = 301;
    public static final int KeyIsEnableNativeLog = 421;
    public static final int KeyIsRetryStatesDir = 433;
    public static final int KeyIsRetryStatesOption = 434;
    public static final int KeyIsSDKMaxRetryCount = 426;
    public static final int KeyIsSDKMaxRetryTimeout = 428;
    public static final int KeyIsSDKRetryPolicy = 427;
    public static final int KeyIsSocketConnectTimeout = 422;
    public static final int KeyIsSocketReadTimeout = 423;
    public static final int KeyIsSocketWriteTimeout = 424;
    public static final int KeyIsTotalRequestTimeout = 425;
    public static final int KeyIsXQuicLibAvailable = 429;
    public static final int NetworkTypeNone = -1;
    public static final int NetworkTypeOwn = 0;
    public static final int NetworkTypeProxy = 4;
    public static final int NetworkTypeTTNet = 1;
    public static final int SDKRetryPolicyMaxFailTime = 0;
    public static final int SDKRetryPolicyMaxRetryCount = 1;
    public static StringBuffer mErrorMsg;

    public String getStringFromExtern(int i) {
        return "";
    }

    static {
        mErrorMsg = new StringBuffer("error:");
        StringBuffer stringBuffer = new StringBuffer("error:");
        mErrorMsg = stringBuffer;
        if (BDUploadUtil.initInternal(stringBuffer)) {
            return;
        }
        IsErrored = true;
    }

    public BDAbstractUpload() throws Exception {
        StringBuffer stringBuffer = new StringBuffer("error:");
        mErrorMsg = stringBuffer;
        BDUploadUtil.initInternal(stringBuffer);
    }

    public String getDispatchByUrl(String str, String str2) {
        if (!BDUploadUtil.mEnableDisaptch.booleanValue()) {
            Log.d("ttmn", "enableDispatch is:" + BDUploadUtil.mEnableDisaptch);
            return null;
        }
        return BDUrlDispatch.inst().getDispatchUrl(str, str2);
    }

    public int doVerify(byte[][] bArr, String str, String str2) {
        return CustomVerify.doVerify(bArr, str, str2);
    }

    public String intelligentInterface(int i, String str) {
        Log.d("ttmn", "IntelligentInterface:" + i + str);
        return "testIntelligentInterface return";
    }
}
