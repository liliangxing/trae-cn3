package com.ss.bduploader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.ss.bduploader.BDVideoInfo;
import com.ss.bduploader.net.BDUploadDNSParser;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BDVideoUploaderBase extends BDAbstractUpload implements Handler.Callback {
    public static final int AuthTypeSTS2 = 0;
    public static final int AuthTypeServerAuth = 1;
    public static final int BDUploadReaderTypeAndroidMedia = 2;
    public static final int BDUploadReaderTypeCallBack = 1;
    public static final int BDUploadReaderTypeFilePath = 0;
    public static final int DataTransportProtocolGQuic = 2;
    public static final int DataTransportProtocolHttpVersion1 = 0;
    public static final int DataTransportProtocolHttpVersion2 = 1;
    public static final int ExternalReaderModeSequence = 1;
    public static final int ExternalReaderModeSkipHeader = 0;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
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
    public static final int KeyIsDynamicSliceForceConfig = 447;
    public static final int KeyIsDynamicSliceHighSize = 450;
    public static final int KeyIsDynamicSliceLowSize = 448;
    public static final int KeyIsDynamicSliceNormalSize = 449;
    public static final int KeyIsEnableExternDNS = 21;
    public static final int KeyIsEnableExternNet = 26;
    public static final int KeyIsEnableFileTryHttps = 25;
    public static final int KeyIsEnableHeaderXStorageMode = 83;
    public static final int KeyIsEnableHttps = 19;
    public static final int KeyIsEnableKeepAlive = 20;
    public static final int KeyIsEnableLogicalPart = 86;
    public static final int KeyIsEnableMutiTask = 29;
    public static final int KeyIsEnablePostMethod = 23;
    public static final int KeyIsEnableQuic = 28;
    public static final int KeyIsExternFileReader = 200;
    public static final int KeyIsExternNetLoader = 27;
    public static final int KeyIsExternNetParameter = 41;
    public static final int KeyIsExternalReaderMode = 412;
    public static final int KeyIsExtra = 58;
    public static final int KeyIsFileRetryCount = 6;
    public static final int KeyIsFileUploadDomain = 2;
    public static final int KeyIsGetAlgorithm = 52;
    public static final int KeyIsGetCoverUrI = 12;
    public static final int KeyIsGetCoverUrl = 11;
    public static final int KeyIsGetDNSIp = 75;
    public static final int KeyIsGetEncryptionMeta = 407;
    public static final int KeyIsGetLog = 100;
    public static final int KeyIsGetObjectId = 51;
    public static final int KeyIsGetSecretKey = 50;
    public static final int KeyIsGetTosKey = 300;
    public static final int KeyIsGetUUID = 1;
    public static final int KeyIsGetUploadErrorMessage = 415;
    public static final int KeyIsGetVersion = 53;
    public static final int KeyIsGetVideoId = 10;
    public static final int KeyIsIsUseServerHost = 17;
    public static final int KeyIsIsUseUpHost = 18;
    public static final int KeyIsLogCallback = 78;
    public static final int KeyIsMainNetworkType = 403;
    public static final int KeyIsMaxFailTime = 13;
    public static final int KeyIsMaxUploadSpeedThresh = 413;
    public static final int KeyIsMediaDataReader = 201;
    public static final int KeyIsMediaInfo = 68;
    public static final int KeyIsNewHttpProxyLoader = 40;
    public static final int KeyIsObjectType = 54;
    public static final int KeyIsOpenResume = 70;
    public static final int KeyIsPathName = 0;
    public static final int KeyIsPlainObjectId = 59;
    public static final int KeyIsPolicyParams = 55;
    public static final int KeyIsPreUploadEncryptionMode = 74;
    public static final int KeyIsPrivateVideo = 414;
    public static final int KeyIsRouteWeight = 408;
    public static final int KeyIsSDKConfigFileDir = 417;
    public static final int KeyIsSDKContextFileDir = 418;
    public static final int KeyIsScenesTag = 85;
    public static final int KeyIsServerParameter = 16;
    public static final int KeyIsSetApplyHost = 46;
    public static final int KeyIsSetCustomConfig = 63;
    public static final int KeyIsSetDeviceID = 66;
    public static final int KeyIsSetEvStateEnable = 79;
    public static final int KeyIsSetLinkTurboEnable = 82;
    public static final int KeyIsSetMinSize = 77;
    public static final int KeyIsSetOpenBoe = 67;
    public static final int KeyIsSetProcessActionType = 65;
    public static final int KeyIsSetReaderType = 81;
    public static final int KeyIsSetRegionName = 47;
    public static final int KeyIsSetResponeTimeOut = 76;
    public static final int KeyIsSetSpaceName = 45;
    public static final int KeyIsSetSpeedTestThresh = 406;
    public static final int KeyIsSetSpeedTestValue = 405;
    public static final int KeyIsSetTraceId = 69;
    public static final int KeyIsSetTranTimeOutUnit = 64;
    public static final int KeyIsSetUserRefrence = 62;
    public static final int KeyIsSkipCode2ndFileSize = 446;
    public static final int KeyIsSliceRetryCount = 5;
    public static final int KeyIsSliceSize = 8;
    public static final int KeyIsSliceTimeout = 7;
    public static final int KeyIsSocketNum = 9;
    public static final int KeyIsSourceMd5 = 57;
    public static final int KeyIsTcpOpenTimeOutMilliSec = 24;
    public static final int KeyIsTopAccessKey = 42;
    public static final int KeyIsTopSecretKey = 43;
    public static final int KeyIsTopSessionToken = 44;
    public static final int KeyIsTosEncStorageMode = 451;
    public static final int KeyIsUploadCookie = 4;
    public static final int KeyIsUserName = 1;
    public static final int KeyIsVideoMetaData = 445;
    public static final int KeyIsVideoUploadDomain = 3;
    public static final int MAX_HEADER_SIZE = 20;
    public static final int MessageIsCallBackError = 101;
    public static final int MessageIsCallBackHeader = 102;
    public static final int MessageIsCallBackSingleEventLog = 107;
    public static final int MessageIsCallBackStage = 103;
    public static final int MessageIsCallBackStageEvent = 104;
    public static final int MessageIsDiskResumeInfoError = 120;
    public static final int MessageIsNetRoutError = 112;
    public static final int MessageIsNetRoutVidInfoFirst = 110;
    public static final int MessageIsReadSliceUserCancel = 121;
    public static final int MessageIsSpeedTestError = 106;
    public static final int MessageIsSpeedTestSuccess = 105;
    public static final int MessageIsSpeedTestUseless = 108;
    public static final int MessageIsnetRoutVidInfoAll = 111;
    public static final int MsgIsAllVideosComplete = 10;
    public static final int MsgIsCallBackLog = 100;
    public static final int MsgIsComplete = 0;
    public static final int MsgIsFail = 2;
    public static final int MsgIsFlushComplete = 50;
    public static final int MsgIsSingleVideoComplete = 8;
    public static final int MsgIsSingleVideoFail = 9;
    public static final int MsgIsUpdateProgress = 1;
    public static final int MsgIsUploadCancel = 3;
    public static final int NetStateIsClose = -1;
    public static final int NetStateIsNotReachable = 0;
    public static final int NetStateIsReachable = 1;
    public static final int NetworkTypeNone = -1;
    public static final int NetworkTypeOwn = 0;
    public static final int NetworkTypeTTNet = 1;
    public static final int VideoUploadFunctionTypeEncryption = 1;
    public static final int VideoUploadFunctionTypeNoProcess = 0;
    public static final int keyIsConfigString = 56;
    public static final int keyIsMediaData = 0;
    int headerIndex;
    private long mEndTime;
    protected long mHandle;
    private Handler mHandler;
    private String[] mHeaders;
    private JSONObject mJsonInfo;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private long mStartTime;
    private int mState;
    protected final ReentrantReadWriteLock.WriteLock mWriteLock;
    private final ReentrantReadWriteLock mReadWritedLock = new ReentrantReadWriteLock();
    protected BDVideoUploaderListener mListener = null;
    protected BDVideoUploaderAbstractListener mAbstractListener = null;
    private Lock mHeadersLock = new ReentrantLock();
    private boolean mFinish = false;
    private boolean mEnableVideoPatch = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public static native void _cancelUpload(long j);

    private static native void _close(long j);

    private final native long _create();

    private static native long _getLongValue(long j, int i);

    private static native String _getStrByKeyAndIndex(long j, int i, int i2);

    private static native String _getStringValue(long j, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native void _mergeUpload(long j);

    private static native void _setAIGCMeta(long j, int i, String[] strArr, String[] strArr2, String[] strArr3);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native void _setContext(long j, String str);

    private static native void _setFilePaths(long j, int i, String[] strArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native void _setInt64Value(long j, int i, long j2);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native void _setIntValue(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native void _setObject(long j, int i, Object obj);

    private static native void _setPoster(long j, float f);

    private static native void _setPosterMeta(long j, int i, String[] strArr);

    private static native void _setSpecifiedContentType(long j, int i, String[] strArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native void _setStringValue(long j, int i, String str);

    private static native void _start(long j);

    private static native void _stop(long j);

    public BDVideoUploaderBase() throws Exception {
        this.mState = -1;
        this.mHandler = null;
        try {
            this.mHandle = _create();
        } catch (Throwable th) {
            this.mHandle = 0L;
            Log.d("ttmn", th.toString());
        }
        long j = this.mHandle;
        if (j == 0) {
            throw new Exception("create native uploader fail:" + ((Object) mErrorMsg));
        }
        _setIntValue(j, BDAbstractUpload.KeyIsEnableNativeLog, BDUploadUtil.mEnableNativeLog.booleanValue() ? 1 : 0);
        if (Looper.myLooper() != null) {
            this.mHandler = new Handler(this);
        } else {
            this.mHandler = new Handler(Looper.getMainLooper(), this);
        }
        this.mReadLock = this.mReadWritedLock.readLock();
        this.mWriteLock = this.mReadWritedLock.writeLock();
        this.mState = 0;
        getDNSIP();
        this.mHeaders = new String[20];
        for (int i = 0; i < 20; i++) {
            this.mHeaders[i] = null;
        }
        this.headerIndex = 0;
        setTraceId(UUID.randomUUID().toString());
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsXQuicLibAvailable, BDUploadUtil.xquicAvalilable() ? 1 : 0);
        setBatchVideoId();
    }

    public void setAbstractListener(BDVideoUploaderAbstractListener bDVideoUploaderAbstractListener) {
        this.mAbstractListener = bDVideoUploaderAbstractListener;
    }

    public static boolean isError() {
        return IsErrored;
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }

    public void setListener(BDVideoUploaderListener bDVideoUploaderListener) {
        this.mListener = bDVideoUploaderListener;
    }

    public void onNotify(int i, long j, int i2, String str) {
        BDVideoInfo bDVideoInfo;
        String str2;
        if (this.mState != 1) {
            return;
        }
        Log.d("ttmn", "onNotify, what:" + i + ", parameter:" + j + ", code:" + i2);
        if (i != 0) {
            if (i != 1) {
                str2 = "ttmn";
                if (i == 2) {
                    String dnsip = getDNSIP();
                    if (dnsip != null && !dnsip.isEmpty()) {
                        setStringValue(75, dnsip);
                    }
                    bDVideoInfo = new BDVideoInfo(null, null, j, _getStringValue(this.mHandle, 415), _getStringValue(this.mHandle, 14), null, null);
                    parseLog();
                    this.mState = 2;
                } else if (i == 3) {
                    parseLog();
                    bDVideoInfo = new BDVideoInfo(null, null, j, null, _getStringValue(this.mHandle, 14), null, null);
                } else if (i != 50) {
                    if (i != 120) {
                        if (i != 121) {
                            switch (i) {
                                case 8:
                                    int i3 = (int) j;
                                    bDVideoInfo = new BDVideoInfo(_getStrByKeyAndIndex(this.mHandle, 10, i3), _getStrByKeyAndIndex(this.mHandle, 12, i3), j, i2, null, _getStrByKeyAndIndex(this.mHandle, 300, i3), _getStrByKeyAndIndex(this.mHandle, 68, i3), _getStrByKeyAndIndex(this.mHandle, 407, i3), _getStrByKeyAndIndex(this.mHandle, 1002, i3));
                                    break;
                                case 9:
                                    bDVideoInfo = new BDVideoInfo(null, null, j, i2, str, null, null, null, null);
                                    break;
                                case 10:
                                    parseLog();
                                    bDVideoInfo = new BDVideoInfo(null, null, j, null, null, null, null);
                                    this.mState = 3;
                                    break;
                                default:
                                    bDVideoInfo = null;
                                    break;
                            }
                        } else {
                            String dnsip2 = getDNSIP();
                            if (dnsip2 != null && !dnsip2.isEmpty()) {
                                setStringValue(75, dnsip2);
                            }
                            bDVideoInfo = new BDVideoInfo(null, null, j, _getStringValue(this.mHandle, 415), _getStringValue(this.mHandle, 14), null, null);
                            parseLog();
                            this.mState = 2;
                        }
                    }
                }
                Message obtainMessage = this.mHandler.obtainMessage();
                obtainMessage.what = i;
                obtainMessage.obj = bDVideoInfo;
                obtainMessage.sendToTarget();
            }
            str2 = "ttmn";
            Log.d(str2, "what:" + i + ", parameter:" + j + ", code:" + i2);
            if (this.mEnableVideoPatch) {
                bDVideoInfo = new BDVideoInfo(null, null, j, i2, null, null, null, null, null);
            } else {
                bDVideoInfo = new BDVideoInfo(null, null, j, null, null, null, null);
            }
            Message obtainMessage2 = this.mHandler.obtainMessage();
            obtainMessage2.what = i;
            obtainMessage2.obj = bDVideoInfo;
            obtainMessage2.sendToTarget();
        }
        this.mEndTime = System.currentTimeMillis();
        String _getStringValue = _getStringValue(this.mHandle, 10);
        String _getStringValue2 = _getStringValue(this.mHandle, 1017);
        BDVideoInfo bDVideoInfo2 = new BDVideoInfo(_getStringValue, _getStringValue(this.mHandle, 12), j, null, _getStringValue(this.mHandle, 300), _getStringValue(this.mHandle, 68), _getStringValue(this.mHandle, 407), _getStringValue(this.mHandle, 1002));
        bDVideoInfo2.mMid = _getStringValue2;
        String dnsip3 = getDNSIP();
        if (dnsip3 != null && !dnsip3.isEmpty()) {
            setStringValue(75, dnsip3);
        }
        parseLog();
        this.mState = 3;
        bDVideoInfo = bDVideoInfo2;
        Message obtainMessage22 = this.mHandler.obtainMessage();
        obtainMessage22.what = i;
        obtainMessage22.obj = bDVideoInfo;
        obtainMessage22.sendToTarget();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class LogInfo {
        private int code;
        private String info;

        public int getCode() {
            return this.code;
        }

        public String getInfo() {
            return this.info;
        }

        public LogInfo(int i, String str) {
            this.code = i;
            this.info = str;
        }
    }

    public void onLogInfo(int i, int i2, String str) {
        if (this.mState != 1) {
            return;
        }
        LogInfo logInfo = new LogInfo(i2, str);
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = logInfo;
        obtainMessage.sendToTarget();
    }

    public void onLogInfoSync(int i, int i2, String str) {
        JSONObject jSONObject;
        if (i == 102 && !TextUtils.isEmpty(str)) {
            try {
                this.mHeadersLock.lock();
                if (this.headerIndex >= 20) {
                    this.headerIndex = 0;
                }
                String[] strArr = this.mHeaders;
                int i3 = this.headerIndex;
                strArr[i3] = str;
                this.headerIndex = i3 + 1;
                return;
            } finally {
                this.mHeadersLock.unlock();
            }
        }
        if (i == 104) {
            if (this.mAbstractListener != null) {
                new HashMap(20);
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    JSONObject jSONObject3 = this.mJsonInfo;
                    if (jSONObject3 != null) {
                        Iterator<String> keys = jSONObject3.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject2.put(next, this.mJsonInfo.get(next));
                        }
                    }
                    BDUploadUtil.jsonToHashMap(jSONObject2);
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (i == 103) {
            long time = new Date().getTime() / 1000;
            BDVideoUploaderListener bDVideoUploaderListener = this.mListener;
            if (bDVideoUploaderListener != null) {
                bDVideoUploaderListener.onUploadVideoStage(i2, time);
            }
        }
        if (i == 107) {
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception unused) {
                jSONObject = null;
            }
            UploadEventManager.instance.addEvent(jSONObject);
            BDVideoUploaderAbstractListener bDVideoUploaderAbstractListener = this.mAbstractListener;
            if (bDVideoUploaderAbstractListener != null) {
                bDVideoUploaderAbstractListener.onEventLog();
            }
        }
        BDVideoUploaderListener bDVideoUploaderListener2 = this.mListener;
        if (bDVideoUploaderListener2 != null) {
            bDVideoUploaderListener2.onLog(i, i2, str);
        }
    }

    public int checkNet(int i, int i2) {
        Log.e("ttmn", "checketNet");
        BDVideoUploaderListener bDVideoUploaderListener = this.mListener;
        if (bDVideoUploaderListener == null) {
            return 1;
        }
        return bDVideoUploaderListener.videoUploadCheckNetState(i, i2);
    }

    public String getDNSIP() {
        return BDUploadUtil.getDNSServerIP();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (message.obj instanceof LogInfo) {
            LogInfo logInfo = (LogInfo) message.obj;
            onLogInfoSync(i, logInfo.getCode(), logInfo.getInfo());
            return true;
        }
        if (this.mListener == null) {
            return true;
        }
        BDVideoInfo bDVideoInfo = (BDVideoInfo) message.obj;
        this.mListener.onNotify(i, bDVideoInfo != null ? bDVideoInfo.mProgress : 0L, bDVideoInfo);
        return true;
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

    public void setSpaceName(String str) {
        setStringValue(45, str);
    }

    public void setUploadDomain(String str) {
        if (this.mHandle == 0 || str == null) {
            return;
        }
        setStringValue(46, str);
    }

    public void setExternFileReader(BDMultiExternalFileReader bDMultiExternalFileReader, int i) {
        if (this.mHandle == 0 || bDMultiExternalFileReader == null || i <= 0) {
            return;
        }
        setEnableBatch();
        _setIntValue(this.mHandle, 71, i);
        _setIntValue(this.mHandle, 81, 1);
        _setObject(this.mHandle, 200, bDMultiExternalFileReader);
    }

    public void setPathName(String str) {
        setStringValue(0, str);
    }

    public void setFilePath(int i, String[] strArr) {
        if (this.mHandle == 0 || strArr == null || i <= 0) {
            return;
        }
        setEnableBatch();
        _setFilePaths(this.mHandle, i, strArr);
        _setIntValue(this.mHandle, 81, 0);
    }

    private void setEnableBatch() {
        this.mEnableVideoPatch = true;
        _setIntValue(this.mHandle, 304, 1);
    }

    public void setObjectType(String str) {
        if (this.mHandle == 0 || str == null || str.equals("")) {
            return;
        }
        setStringValue(54, str);
    }

    public void setStringValue(int i, String str) {
        long j = this.mHandle;
        if (j == 0 || str == null) {
            return;
        }
        _setStringValue(j, i, str);
    }

    public void setServerParameter(String str) {
        long j = this.mHandle;
        if (j == 0 || str == null) {
            return;
        }
        _setStringValue(j, 16, str);
    }

    public void setEnableHttps(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 19, i);
    }

    public void setEnableBigFile(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 83, i);
    }

    public void setEnableLogicalPart(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 86, i);
    }

    public void setCustomHttpHeaders(TreeMap<String, Object> treeMap) {
        String mapToString;
        if (this.mHandle == 0 || treeMap == null || (mapToString = BDUploadUtil.mapToString(treeMap)) == null) {
            return;
        }
        setStringValue(BDAbstractUpload.KeyIsCustomHttpHeaders, mapToString);
    }

    public void setEnableKeepAlive(int i) {
        long j = this.mHandle;
        if (j != 0) {
            if (i == 0 || i == 1) {
                _setIntValue(j, 20, i);
            }
        }
    }

    public void setEnableExternDNS(int i) {
        long j = this.mHandle;
        if (j != 0) {
            if (i == 0 || i == 1) {
                _setIntValue(j, 21, i);
            }
        }
    }

    public void setEnableFiletryHttps(int i) {
        long j = this.mHandle;
        if (j != 0) {
            if (i == 0 || i == 1) {
                _setIntValue(j, 25, i);
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

    public void setAliveMaxFailTime(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 22, i);
    }

    public void setTcpOpenTimeOutMilliSec(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 24, i);
    }

    public void setPoster(float f) {
        long j = this.mHandle;
        if (j == 0 || f < 0.0f) {
            return;
        }
        _setPoster(j, f);
    }

    public void setRWTimeout(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 7, i);
    }

    public void setSliceSize(int i) {
        long j = this.mHandle;
        if (j == 0 || i <= 0) {
            return;
        }
        _setIntValue(j, 8, i);
    }

    public void setSocketNum(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 9, i);
    }

    public void setMaxConcurrentFileNum(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 400, i);
    }

    public void setSliceReTryCount(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 5, i);
    }

    public void setFileRetryCount(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 6, i);
    }

    public void setMaxFailTime(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 13, i);
    }

    public void setMediaDataReader(BDMediaDataReader bDMediaDataReader) {
        long j = this.mHandle;
        if (j == 0 || bDMediaDataReader == null) {
            return;
        }
        _setIntValue(j, 81, 2);
        _setObject(this.mHandle, 201, bDMediaDataReader);
    }

    public void setTranTimeOutUnit(int i) {
        long j = this.mHandle;
        if (j == 0 || i <= 0) {
            return;
        }
        _setIntValue(j, 64, i);
    }

    public void setScenesTag(String str) {
        long j = this.mHandle;
        if (j == 0 || str == null) {
            return;
        }
        _setStringValue(j, 85, str);
    }

    public void start() {
        this.mWriteLock.lock();
        if (BDUploadUtil.sdkConfigDir != null && BDUploadUtil.sdkConfigDir.length() > 0) {
            setContextDir(BDUploadUtil.sdkConfigDir);
            setDiskResumeDir(BDUploadUtil.sdkConfigDir);
            setRetryStatesDir(BDUploadUtil.sdkConfigDir);
        }
        try {
            if (this.mHandle != 0) {
                this.mFinish = false;
                this.mState = 1;
                this.mStartTime = System.currentTimeMillis();
                _start(this.mHandle);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void stop() {
        this.mWriteLock.lock();
        try {
            long j = this.mHandle;
            if (j != 0) {
                _stop(j);
                String dnsip = getDNSIP();
                if (dnsip != null && !dnsip.isEmpty()) {
                    setStringValue(75, dnsip);
                }
                parseLog();
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
                _stop(j);
                parseLog();
                _close(this.mHandle);
                this.mHandle = 0L;
                this.mState = 5;
                this.mHandler.removeCallbacksAndMessages(null);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    private void parseLog() {
        if (this.mFinish) {
            return;
        }
        this.mFinish = true;
        addLogToManager(_getStringValue(this.mHandle, 100));
    }

    public JSONObject addLogToManager(String str) {
        JSONObject jSONObject;
        JSONArray jSONArray = null;
        if (BDUploadUtil.mSkipUploadLog.booleanValue()) {
            return null;
        }
        String uuid = UUID.randomUUID().toString();
        try {
            jSONObject = new JSONObject(str);
            jSONObject.put("dns_version", BDUploadResolver.mDNSVersion);
            jSONObject.put("main_dns_type", BDUploadDNSParser.mGlobalMainType);
            jSONObject.put("main_back_type", BDUploadDNSParser.mGlobalBackType);
            jSONObject.put("back_delayed_time", BDUploadDNSParser.mGlobalBackUpDelayedTime);
            jSONObject.put("expired_time", BDUploadDNSParser.mGlobalDefaultExpiredTime);
            JSONObject jSONObject2 = this.mJsonInfo;
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, this.mJsonInfo.get(next));
                }
            }
            String str2 = "";
            try {
                this.mHeadersLock.lock();
                for (int i = 0; i < 20; i++) {
                    if (!TextUtils.isEmpty(this.mHeaders[i])) {
                        str2 = str2 + "#" + this.mHeaders[i];
                    }
                }
                this.mHeadersLock.unlock();
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("cdn_headers", str2);
                }
            } catch (Throwable th) {
                this.mHeadersLock.unlock();
                throw th;
            }
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            try {
                Object obj = jSONObject.get("video_array");
                if (obj instanceof JSONArray) {
                    jSONArray = (JSONArray) obj;
                    jSONObject.remove("video_array");
                }
                int i2 = jSONObject.getInt("file_num");
                for (int i3 = 0; i3 < i2; i3++) {
                    JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                    jSONObject3.remove("event");
                    jSONObject3.put("event", "bd_video_upload");
                    if (jSONArray != null && jSONArray.length() > i3) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
                        Iterator<String> keys2 = jSONObject4.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            jSONObject3.put(next2, jSONObject4.get(next2));
                        }
                    }
                    jSONObject3.put("uuid", uuid);
                    UploadEventManager.instance.addEvent(jSONObject3);
                }
                return jSONObject;
            } catch (Exception e) {
                Log.e("ttmn", "get video_array failed" + e);
            }
        }
        UploadEventManager.instance.addEvent(jSONObject);
        return jSONObject;
    }

    public void setTraceId(String str) {
        if (this.mHandle == 0 || str == null || str.isEmpty()) {
            return;
        }
        _setStringValue(this.mHandle, 69, str);
    }

    public void setOpenBoe(boolean z) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        if (z) {
            _setIntValue(j, 67, 1);
        } else {
            _setIntValue(j, 67, 0);
        }
    }

    public void setEnableLogCallBack(boolean z) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        if (z) {
            _setIntValue(j, 78, 1);
        } else {
            _setIntValue(j, 78, 0);
        }
    }

    public void allowMergeUpload() {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _mergeUpload(j);
    }

    public void setPreUploadEncryptionMode(int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, 74, i);
    }

    @Override // com.ss.bduploader.BDAbstractUpload
    public String getStringFromExtern(int i) {
        if (i == 0) {
            BDVideoUploaderListener bDVideoUploaderListener = this.mListener;
            if (bDVideoUploaderListener != null) {
                return bDVideoUploaderListener.getStringFromExtern(i);
            }
        } else if (i == 1) {
            return UUID.randomUUID().toString();
        }
        return null;
    }

    public void setResponseTimeOut(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 76, i);
    }

    public void setMaxUploadSpeedThresh(int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, KeyIsMaxUploadSpeedThresh, i);
    }

    private void setDiskResumeDir(String str) {
        if (this.mHandle == 0 || str == null) {
            return;
        }
        String str2 = str + File.separator + BDUploadUtil.DiskResumeConfigDir;
        BDUploadUtil.createDir(str2);
        _setStringValue(this.mHandle, 303, str2);
    }

    private void setRetryStatesDir(String str) {
        if (this.mHandle == 0 || str == null) {
            return;
        }
        String str2 = str + File.separator + BDUploadUtil.RetryStatesInfoDir;
        BDUploadUtil.createDir(str2);
        _setStringValue(this.mHandle, BDAbstractUpload.KeyIsRetryStatesDir, str2);
    }

    public void setDiskResumeUniqueKey(String str) {
        if (this.mHandle == 0 || str == null || str.isEmpty()) {
            return;
        }
        _setStringValue(this.mHandle, 301, str);
    }

    public void setDiskResumeOption(int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, 302, i);
    }

    private void setBatchVideoId() {
        String uuid = UUID.randomUUID().toString();
        if (uuid == null || uuid.length() <= 0) {
            return;
        }
        _setStringValue(this.mHandle, 420, uuid);
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

    public void setSDKMaxRetryCount(int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, BDAbstractUpload.KeyIsSDKMaxRetryCount, i);
    }

    public void setSDKMaxRetryTimeout(int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, BDAbstractUpload.KeyIsSDKMaxRetryTimeout, i);
    }

    public void setSpecifiedContentType(int i, String[] strArr) {
        long j = this.mHandle;
        if (j == 0 || strArr == null || i <= 0) {
            return;
        }
        _setSpecifiedContentType(j, i, strArr);
    }

    public void setDynamicSliceParams(int i, int i2, int i3) {
        long j = this.mHandle;
        if (j == 0 || i <= 0 || i2 <= 0 || i3 <= 0) {
            return;
        }
        _setIntValue(j, KeyIsDynamicSliceForceConfig, 1);
        _setIntValue(this.mHandle, KeyIsDynamicSliceLowSize, i);
        _setIntValue(this.mHandle, KeyIsDynamicSliceNormalSize, i2);
        _setIntValue(this.mHandle, 450, i3);
    }

    public void setTosEncStorageMode(int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, 451, i);
    }

    public void setAIGCMeta(BDVideoInfo.AIGCMeta aIGCMeta) {
        setAIGCMetaForBatch(1, new BDVideoInfo.AIGCMeta[]{aIGCMeta});
    }

    public void setAIGCMetaForBatch(int i, BDVideoInfo.AIGCMeta[] aIGCMetaArr) {
        if (this.mHandle == 0 || aIGCMetaArr == null || i <= 0) {
            return;
        }
        int min = Math.min(i, aIGCMetaArr.length);
        String[] strArr = new String[min];
        String[] strArr2 = new String[min];
        String[] strArr3 = new String[min];
        for (int i2 = 0; i2 < min; i2++) {
            BDVideoInfo.AIGCMeta aIGCMeta = aIGCMetaArr[i2];
            if (aIGCMeta != null) {
                strArr[i2] = aIGCMeta.Label;
                strArr2[i2] = aIGCMetaArr[i2].ContentProducer;
                strArr3[i2] = aIGCMetaArr[i2].ContentPropagator;
            }
        }
        _setAIGCMeta(this.mHandle, min, strArr, strArr2, strArr3);
    }

    public void setPosterMeta(String str) {
        setPosterMetaForBatch(1, new String[]{str});
    }

    public void setPosterMetaForBatch(int i, String[] strArr) {
        if (this.mHandle == 0 || strArr == null || i <= 0) {
            return;
        }
        _setPosterMeta(this.mHandle, Math.min(i, strArr.length), strArr);
    }
}
