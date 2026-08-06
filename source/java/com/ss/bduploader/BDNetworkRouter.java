package com.ss.bduploader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.bduploader.smartserver.SmartRouting;
import java.io.File;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BDNetworkRouter extends BDAbstractUpload implements Handler.Callback {
    public static final int AuthTypeSTS2 = 0;
    public static final int AuthTypeServerAuth = 1;
    public static final int BDNetworkRoutModeDomain = 0;
    public static final int BDNetworkRoutModeTopNHost = 1;
    public static final int DataTransportProtocolGQuic = 2;
    public static final int DataTransportProtocolHttpVersion1 = 0;
    public static final int DataTransportProtocolHttpVersion2 = 1;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
    private static boolean IsErrored = false;
    public static final int IsFail = 2;
    public static final int IsInit = 0;
    public static final int IsStart = 1;
    public static final int IsStop = 4;
    public static final int KeIsAuthorization = 15;
    public static final int KeIsGetRedirectLocation = 14;
    public static final int KeyIsAliveMaxFailTime = 22;
    public static final int KeyIsAuthType = 416;
    public static final int KeyIsBackupNetworkType = 404;
    public static final int KeyIsDataTransportProtocol = 411;
    public static final int KeyIsDisableUploadInfo = 301;
    public static final int KeyIsEnableExternDNS = 21;
    public static final int KeyIsEnableExternNet = 26;
    public static final int KeyIsEnableFileTryHttps = 25;
    public static final int KeyIsEnableHeaderXStorageMode = 83;
    public static final int KeyIsEnableHttps = 19;
    public static final int KeyIsEnableKeepAlive = 20;
    public static final int KeyIsEnableMutiTask = 29;
    public static final int KeyIsEnablePostMethod = 23;
    public static final int KeyIsEnableQuic = 28;
    public static final int KeyIsExternFileReader = 200;
    public static final int KeyIsExternNetLoader = 27;
    public static final int KeyIsExternNetParameter = 41;
    public static final int KeyIsExtra = 58;
    public static final int KeyIsFileRetryCount = 6;
    public static final int KeyIsFileUploadDomain = 2;
    public static final int KeyIsGetAlgorithm = 52;
    public static final int KeyIsGetCoverUrI = 12;
    public static final int KeyIsGetCoverUrl = 11;
    public static final int KeyIsGetDNSIp = 75;
    public static final int KeyIsGetLog = 100;
    public static final int KeyIsGetObjectId = 51;
    public static final int KeyIsGetSecretKey = 50;
    public static final int KeyIsGetTosKey = 300;
    public static final int KeyIsGetVersion = 53;
    public static final int KeyIsGetVideoId = 10;
    public static final int KeyIsIntelligentInitial = 0;
    public static final int KeyIsIntelligentPredict = 1;
    public static final int KeyIsIsUseServerHost = 17;
    public static final int KeyIsIsUseUpHost = 18;
    public static final int KeyIsLogCallback = 78;
    public static final int KeyIsMainNetworkType = 403;
    public static final int KeyIsMaxFailTime = 13;
    public static final int KeyIsMediaDataReader = 201;
    public static final int KeyIsMediaInfo = 68;
    public static final int KeyIsNewHttpProxyLoader = 40;
    public static final int KeyIsObjectType = 54;
    public static final int KeyIsOpenResume = 70;
    public static final int KeyIsPathName = 0;
    public static final int KeyIsPlainObjectId = 59;
    public static final int KeyIsPolicyParams = 55;
    public static final int KeyIsPreUploadEncryptionMode = 74;
    public static final int KeyIsRouteWeight = 408;
    public static final int KeyIsSDKConfigFileDir = 417;
    public static final int KeyIsSDKContextFileDir = 418;
    public static final int KeyIsServerParameter = 16;
    public static final int KeyIsSetApplyHost = 46;
    public static final int KeyIsSetCustomConfig = 63;
    public static final int KeyIsSetDeviceID = 66;
    public static final int KeyIsSetEvStateEnable = 79;
    public static final int KeyIsSetLinkTurboEnable = 82;
    public static final int KeyIsSetMinSize = 77;
    public static final int KeyIsSetOpenBoe = 67;
    public static final int KeyIsSetProcessActionType = 65;
    public static final int KeyIsSetRegionName = 47;
    public static final int KeyIsSetResponeTimeOut = 76;
    public static final int KeyIsSetSpaceName = 45;
    public static final int KeyIsSetTraceId = 69;
    public static final int KeyIsSetTranTimeOutUnit = 64;
    public static final int KeyIsSetUserRefrence = 62;
    public static final int KeyIsSliceRetryCount = 5;
    public static final int KeyIsSliceSize = 8;
    public static final int KeyIsSliceTimeout = 7;
    public static final int KeyIsSocketNum = 9;
    public static final int KeyIsSourceMd5 = 57;
    public static final int KeyIsTcpOpenTimeOutMilliSec = 24;
    public static final int KeyIsTopAccessKey = 42;
    public static final int KeyIsTopSecretKey = 43;
    public static final int KeyIsTopSessionToken = 44;
    public static final int KeyIsUploadCookie = 4;
    public static final int KeyIsUserName = 1;
    public static final int KeyIsVideoUploadDomain = 3;
    public static final int MessageIsCallBackError = 101;
    public static final int MessageIsCallBackHeader = 102;
    public static final int MessageIsCallBackStage = 103;
    public static final int MessageIsCallBackStageEvent = 104;
    public static final int MessageIsNetRoutError = 112;
    public static final int MessageIsNetRoutVidInfoFirst = 110;
    public static final int MessageIsSpeedTestError = 106;
    public static final int MessageIsSpeedTestSuccess = 105;
    public static final int MessageIsSpeedTestUseless = 108;
    public static final int MessageIsnetRoutVidInfoAll = 111;
    public static final int MsgIsCallBackLog = 100;
    public static final int MsgIsComplete = 0;
    public static final int MsgIsFail = 2;
    public static final int MsgIsUpdateProgress = 1;
    public static final int MsgIsUploadCancel = 3;
    public static final int NetStateIsClose = -1;
    public static final int NetStateIsNotReachable = 0;
    public static final int NetStateIsReachable = 1;
    public static final int NetworkTypeOwn = 0;
    public static final int NetworkTypeTTNet = 1;
    public static final int RoutingQUIC = 0;
    public static final int RoutingTCP = 1;
    public static final int keyIsConfigString = 56;
    private long mEndTime;
    private long mHandle;
    private Handler mHandler;
    private BDNetworkRouterListener mListener;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private SmartRouting mSmartRouting;
    private long mStartTime;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;
    private boolean hasInit = false;
    private int mState = -1;
    private int mEstimatedFileSize = -1;

    private static native void _close(long j);

    private final native long _create(int i);

    private static native void _setContext(long j, String str);

    private static native void _setIntValue(long j, int i, int i2);

    private static native void _setStringValue(long j, int i, String str);

    private static native void _start(long j);

    private static native void _stop(long j);

    public void onLogInfo(int i, int i2, String str) {
    }

    public BDNetworkRouter(int i) throws Exception {
        this.mHandler = null;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWritedLock = reentrantReadWriteLock;
        this.mListener = null;
        if (Looper.myLooper() != null) {
            this.mHandler = new Handler(this);
        } else {
            this.mHandler = new Handler(Looper.getMainLooper(), this);
        }
        this.mReadLock = reentrantReadWriteLock.readLock();
        this.mWriteLock = reentrantReadWriteLock.writeLock();
        try {
            this.mHandle = _create(i);
        } catch (Throwable unused) {
            this.mHandle = 0L;
        }
        long j = this.mHandle;
        if (j == 0) {
            throw new Exception("create native network router fail");
        }
        _setIntValue(j, BDAbstractUpload.KeyIsEnableNativeLog, BDUploadUtil.mEnableNativeLog.booleanValue() ? 1 : 0);
    }

    public void onNotify(int i, long j, int i2, String str) {
        BDNetworkRouteInfo bDNetworkRouteInfo = new BDNetworkRouteInfo(str, i, (int) j);
        Handler handler = this.mHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.obj = bDNetworkRouteInfo;
            obtainMessage.sendToTarget();
        }
    }

    public int checkNet(int i, int i2) {
        BDNetworkRouterListener bDNetworkRouterListener = this.mListener;
        if (bDNetworkRouterListener != null) {
            return bDNetworkRouterListener.networkRouteCheckNetState(i, i2);
        }
        return 1;
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }

    public void setListener(BDNetworkRouterListener bDNetworkRouterListener) {
        this.mListener = bDNetworkRouterListener;
    }

    public void setUploadDomain(String str) {
        setStringValue(46, str);
    }

    public void setDataTransportProtocol(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 411, i);
    }

    public void setFileRetryCount(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 6, i);
    }

    public void setTranTimeOutUnit(int i) {
        long j = this.mHandle;
        if (j == 0 || i <= 0) {
            return;
        }
        _setIntValue(j, 64, i);
    }

    public void setMaxFailTime(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 13, i);
    }

    public void setTcpOpenTimeOutMilliSec(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 24, i);
    }

    public void setRWTimeout(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 7, i);
    }

    public void setEnableHttps(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 19, i);
    }

    public void setEnableExternDNS(int i) {
        long j = this.mHandle;
        if (j != 0) {
            if (i == 0 || i == 1) {
                _setIntValue(j, 21, i);
            }
        }
    }

    public void setNetworkType(int i, int i2) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, i, i2);
    }

    public void setProcessActionType(int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, 65, i);
    }

    public void setTopAccessKey(String str) {
        setStringValue(42, str);
    }

    public void setTopSecretKey(String str) {
        setStringValue(43, str);
    }

    public void setTopSessionToken(String str) {
        setStringValue(44, str);
    }

    public void setRegionName(String str) {
        setStringValue(47, str);
    }

    public void setSpaceName(String str) {
        setStringValue(45, str);
    }

    public void setServerParameter(String str) {
        long j = this.mHandle;
        if (j == 0 || str == null) {
            return;
        }
        _setStringValue(j, 16, str);
    }

    public void setTraceId(String str) {
        if (this.mHandle == 0 || str == null || str.isEmpty()) {
            return;
        }
        _setStringValue(this.mHandle, 69, str);
    }

    public void setRouteWeight(int i) {
        long j = this.mHandle;
        if (j == 0 || i <= 0) {
            return;
        }
        _setIntValue(j, 408, i);
    }

    private void setStringValue(int i, String str) {
        long j = this.mHandle;
        if (j == 0 || str == null) {
            return;
        }
        _setStringValue(j, i, str);
    }

    public void start() {
        this.mReadLock.lock();
        if (BDUploadUtil.sdkConfigDir != null && BDUploadUtil.sdkConfigDir.length() > 0) {
            setContextDir(BDUploadUtil.sdkConfigDir);
        }
        try {
            if (this.mHandle != 0) {
                this.mState = 1;
                this.mStartTime = System.currentTimeMillis();
                _start(this.mHandle);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void stop() {
        this.mWriteLock.lock();
        try {
            long j = this.mHandle;
            if (j != 0) {
                _stop(j);
                this.mState = 4;
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void close() {
        this.mWriteLock.lock();
        try {
            long j = this.mHandle;
            if (j != 0) {
                _close(j);
                this.mHandle = 0L;
                this.mState = 5;
                this.mHandler.removeCallbacksAndMessages(null);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.mListener == null || !(message.obj instanceof BDNetworkRouteInfo)) {
            return true;
        }
        BDNetworkRouteInfo bDNetworkRouteInfo = (BDNetworkRouteInfo) message.obj;
        this.mListener.onRouteContext(bDNetworkRouteInfo.mContextType, bDNetworkRouteInfo.mSpeed, bDNetworkRouteInfo.mContext);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003e  */
    @Override // com.ss.bduploader.BDAbstractUpload
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String intelligentInterface(int i, String str) {
        JSONObject jSONObject;
        Log.d("ttmn", "intelligentInterface:what:" + i + ",value:" + str);
        if (i == 0) {
            checkAndInit(str);
            preloadModel();
        } else if (i == 1) {
            jSONObject = processIntelligentPrediction(predictIntelligentTCPQUIC(insertFileSizeInfo(str)));
            if (jSONObject != null) {
                return "";
            }
            Log.d("intelligent_routing", "prediction result: " + jSONObject.toString());
            return jSONObject.toString();
        }
        jSONObject = null;
        if (jSONObject != null) {
        }
    }

    private String insertFileSizeInfo(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
            jSONObject.put(FrescoMonitorConst.FILE_SIZE, (this.mEstimatedFileSize / 1024) / 1024);
        } catch (Exception unused) {
            jSONObject = null;
        }
        return jSONObject == null ? str : jSONObject.toString();
    }

    private JSONObject processIntelligentPrediction(float f) {
        Log.d("intelligent routing", "process prediction result:" + f);
        JSONObject jSONObject = new JSONObject();
        if (f < 0.0f || f > 1.0f) {
            return null;
        }
        try {
            if (f < 0.5d) {
                jSONObject.put("intelligentRoutingResult", 0);
            } else {
                jSONObject.put("intelligentRoutingResult", 1);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private float predictIntelligentTCPQUIC(String str) {
        if (this.mSmartRouting == null) {
            return -1.0f;
        }
        try {
            return this.mSmartRouting.predictSpeedSync(new JSONObject(str));
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    private void checkAndInit(String str) {
        if (this.hasInit) {
            return;
        }
        this.hasInit = true;
        SmartRouting smartRouting = new SmartRouting();
        this.mSmartRouting = smartRouting;
        smartRouting.init();
        this.mSmartRouting.parseUrl(str);
        this.mSmartRouting.configServer();
    }

    private void preloadModel() {
        SmartRouting smartRouting = this.mSmartRouting;
        if (smartRouting != null) {
            smartRouting.preloadEnv();
        }
    }

    public void setAuthType(int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, 416, i);
    }

    public void setQueryAuth(String str) {
        long j = this.mHandle;
        if (j == 0 || str == null) {
            return;
        }
        _setStringValue(j, 15, str);
    }

    public void setSDKConfigDir(String str) {
        if (this.mHandle == 0 || str == null) {
            return;
        }
        BDUploadUtil.createDir(str);
        _setStringValue(this.mHandle, 417, str);
        setContextDir(str);
    }

    private void setContextDir(String str) {
        if (this.mHandle == 0 || str == null) {
            return;
        }
        String str2 = str + File.separator + BDUploadUtil.SpeedTestcontextDir;
        BDUploadUtil.createDir(str2);
        _setStringValue(this.mHandle, 418, str2);
    }

    public void setCustomHttpHeaders(TreeMap<String, Object> treeMap) {
        String mapToString;
        if (this.mHandle == 0 || treeMap == null || (mapToString = BDUploadUtil.mapToString(treeMap)) == null) {
            return;
        }
        setStringValue(BDAbstractUpload.KeyIsCustomHttpHeaders, mapToString);
    }
}
