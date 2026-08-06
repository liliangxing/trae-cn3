package com.ss.bduploader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.ss.bduploader.net.BDUploadDNSParser;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BDImageXUploaderBase extends BDAbstractUpload implements Handler.Callback {
    public static final int BDPreHeatModeLocalStorge = 2;
    public static final int BDPreHeatModeNone = 0;
    public static final int BDPreHeatModeReader = 1;
    public static final int BDPreHeatModeUseStorge = 3;
    public static final int BDUploadReaderTypeAndroidMedia = 2;
    public static final int BDUploadReaderTypeCallBack = 1;
    public static final int BDUploadReaderTypeFilePath = 0;
    public static final int CommitTypeCommit = 1;
    public static final int CommitTypeNoCommit = 0;
    public static final int CommitTypeNoDepend = 2;
    public static final int DataTransportProtocolGQuic = 2;
    public static final int DataTransportProtocolHttpVersion1 = 0;
    public static final int DataTransportProtocolHttpVersion2 = 1;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
    public static final int IsFail = 2;
    public static final int IsInit = 0;
    public static final int IsStart = 1;
    public static final int IsStop = 4;
    public static final int KeIsAuthorization = 15;
    public static final int KeIsGetRedirectLocation = 14;
    public static final int KeyIsAliveMaxFailTime = 22;
    public static final int KeyIsApplyAuth = 83;
    public static final int KeyIsBackupNetworkType = 404;
    public static final int KeyIsCommitAuth = 84;
    public static final int KeyIsDataTransportProtocol = 411;
    public static final int KeyIsEnableCommitUpload = 401;
    public static final int KeyIsEnableExternDNS = 21;
    public static final int KeyIsEnableHttps = 19;
    public static final int KeyIsEnableKeepAlive = 20;
    public static final int KeyIsEnablePostMethod = 23;
    public static final int KeyIsExtra = 58;
    public static final int KeyIsFileRetryCount = 6;
    public static final int KeyIsFileUploadDomain = 2;
    public static final int KeyIsGetAlgorithm = 52;
    public static final int KeyIsGetCoverUrI = 12;
    public static final int KeyIsGetCoverUrl = 11;
    public static final int KeyIsGetDNSIp = 75;
    public static final int KeyIsGetEncryptionMeta = 407;
    public static final int KeyIsGetImageMeta = 410;
    public static final int KeyIsGetImageURI = 409;
    public static final int KeyIsGetLog = 100;
    public static final int KeyIsGetObjectId = 51;
    public static final int KeyIsGetSecretKey = 50;
    public static final int KeyIsGetUUID = 1;
    public static final int KeyIsGetVersion = 53;
    public static final int KeyIsGetVideoId = 10;
    public static final int KeyIsImageCountThreshold = 438;
    public static final int KeyIsLogCallback = 78;
    public static final int KeyIsMainNetworkType = 403;
    public static final int KeyIsMaxFailTime = 13;
    public static final int KeyIsMediaDataReader = 201;
    public static final int KeyIsMetaInfoParams = 61;
    public static final int KeyIsObjectType = 54;
    public static final int KeyIsPathName = 0;
    public static final int KeyIsPlainObjectId = 59;
    public static final int KeyIsPolicyParams = 55;
    public static final int KeyIsPreUpload = 80;
    public static final int KeyIsPreUploadApply = 419;
    public static final int KeyIsPreUploadEncryptionMode = 74;
    public static final int KeyIsRouteWeight = 408;
    public static final int KeyIsSDKConfigFileDir = 417;
    public static final int KeyIsSDKContextFileDir = 418;
    public static final int KeyIsScenesTag = 85;
    public static final int KeyIsServerParameter = 16;
    public static final int KeyIsSetApplyHost = 46;
    public static final int KeyIsSetCustomConfig = 63;
    public static final int KeyIsSetDeviceID = 66;
    public static final int KeyIsSetOpenBoe = 67;
    public static final int KeyIsSetProcessAction = 65;
    public static final int KeyIsSetReaderType = 81;
    public static final int KeyIsSetRegionName = 47;
    public static final int KeyIsSetSpaceName = 45;
    public static final int KeyIsSetSpeedTestThresh = 406;
    public static final int KeyIsSetSpeedTestValue = 405;
    public static final int KeyIsSetTraceId = 69;
    public static final int KeyIsSetTranTimeOutUnit = 64;
    public static final int KeyIsSetfileNum = 71;
    public static final int KeyIsSliceRetryCount = 5;
    public static final int KeyIsSliceSize = 8;
    public static final int KeyIsSliceThreshold = 402;
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
    public static final int MessageIsCallBackStage = 103;
    public static final int MessageIsPreHeatComplete = 123;
    public static final int MessageIsPreHeatResultUsed = 124;
    public static final int MessageIsUploadCompleteTos = 122;
    public static final int MsgIsComplete = 0;
    public static final int MsgIsFail = 2;
    public static final int MsgIsSingleImageComplete = 6;
    public static final int MsgIsSingleImageFail = 7;
    public static final int MsgIsUpdateProgress = 1;
    public static final int MsgIsUploadCancel = 3;
    public static final int NetworkTypeNone = -1;
    public static final int NetworkTypeOwn = 0;
    public static final int NetworkTypeTTNet = 1;
    public static final int UploadFunctionTypeEncryption = 1;
    public static final int UploadFunctionTypeGetMedia = 2;
    public static final int UploadFunctionTypeNoProcess = 0;
    public static final int UploadFunctionTypeUploadMediaLog = 2;
    public static final int keyIsConfigString = 56;
    public static final int keyIsMediaData = 0;
    private static final int mInnerUploaderType = 1;
    private long mEndTime;
    protected long mHandle;
    private Handler mHandler;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private long mStartTime;
    private int mState;
    protected final ReentrantReadWriteLock.WriteLock mWriteLock;
    private int mImageNum = 0;
    private final ReentrantReadWriteLock mReadWritedLock = new ReentrantReadWriteLock();
    private BDImageXUploaderListener mListener = null;
    private BDImageXUploaderAbstractListener mAbstractListener = null;
    protected String mEnd2EndEncryptionAESKey = null;
    protected int mEnd2EndEncryptionOption = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public static native void _allowContinueUpload(long j);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native void _cancelUpload(long j);

    private static native void _close(long j);

    private final native long _create(int i);

    private static native long _getLongValue(long j, int i);

    private static native String _getStrByKeyAndIndex(long j, int i, int i2);

    private static native String _getStringValue(long j, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native void _mergeUpload(long j);

    private static native void _setFileData(long j, int i, byte[][] bArr);

    private static native void _setFileName(long j, int i, String[] strArr);

    private static native void _setFileNum(long j, int i);

    private static native void _setFilePaths(long j, int i, String[] strArr);

    private static native void _setFileStoreKeys(long j, int i, String[] strArr);

    private static native void _setInt64Value(long j, int i, long j2);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native void _setIntValue(long j, int i, int i2);

    private static native void _setObject(long j, int i, Object obj);

    private static native void _setSpecifiedContentType(long j, int i, String[] strArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native void _setStringValue(long j, int i, String str);

    private static native void _start(long j);

    private static native void _stop(long j);

    public BDImageXUploaderBase() throws Exception {
        this.mState = -1;
        this.mHandler = null;
        try {
            this.mHandle = _create(1);
        } catch (Throwable unused) {
            this.mHandle = 0L;
        }
        long j = this.mHandle;
        if (j == 0) {
            throw new Exception("create native uploader fail");
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
    }

    public static boolean isError() {
        return IsErrored;
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }

    public void setListener(BDImageXUploaderListener bDImageXUploaderListener) {
        this.mListener = bDImageXUploaderListener;
    }

    public void setAbstractListener(BDImageXUploaderAbstractListener bDImageXUploaderAbstractListener) {
        this.mAbstractListener = bDImageXUploaderAbstractListener;
    }

    @Override // com.ss.bduploader.BDAbstractUpload
    public String getStringFromExtern(int i) {
        if (i == 0) {
            BDImageXUploaderAbstractListener bDImageXUploaderAbstractListener = this.mAbstractListener;
            if (bDImageXUploaderAbstractListener != null) {
                return bDImageXUploaderAbstractListener.getStringFromExtern(i);
            }
        } else if (i == 1) {
            return UUID.randomUUID().toString();
        }
        return null;
    }

    private String getEnd2EndEncryptionAESKey() {
        String str;
        if (this.mEnd2EndEncryptionOption > 0 && ((str = this.mEnd2EndEncryptionAESKey) == null || str.length() == 0)) {
            this.mEnd2EndEncryptionAESKey = _getStringValue(this.mHandle, UploadKeys.KeyIsEnd2EndEncryptionAESKey);
        }
        return this.mEnd2EndEncryptionAESKey;
    }

    public void onNotify(int i, long j, int i2, String str) {
        BDImageXInfo bDImageXInfo;
        if (this.mState != 1) {
            return;
        }
        int i3 = (int) j;
        BDImageXInfo bDImageXInfo2 = null;
        if (i != 0) {
            if (i == 1) {
                bDImageXInfo = new BDImageXInfo(null, i2, i3, null, null, null);
            } else if (i == 2) {
                String dnsip = getDNSIP();
                if (dnsip != null && !dnsip.isEmpty()) {
                    setStringValue(75, dnsip);
                }
                addLogToManager(_getStringValue(this.mHandle, 100));
                this.mState = 2;
            } else if (i == 3) {
                addLogToManager(_getStringValue(this.mHandle, 100));
                this.mState = 2;
            } else if (i == 6) {
                this.mEndTime = System.currentTimeMillis();
                bDImageXInfo2 = new BDImageXInfo(_getStrByKeyAndIndex(this.mHandle, 409, i3), 0L, i3, _getStrByKeyAndIndex(this.mHandle, 410, i3), _getStrByKeyAndIndex(this.mHandle, 407, i3), new BDImageXE2EEncryptionInfo(getEnd2EndEncryptionAESKey(), null, null));
            } else if (i == 7) {
                bDImageXInfo = new BDImageXInfo(null, i2, i3, null, null, null);
                bDImageXInfo.mErrorMsg = str;
            } else if (i == 123) {
                bDImageXInfo = new BDImageXInfo(null, i3, i3, null, null, null);
            } else if (i == 124) {
                i3 = i3 != 0 ? 0 : 1;
            }
            bDImageXInfo2 = bDImageXInfo;
        } else {
            String dnsip2 = getDNSIP();
            if (dnsip2 != null && !dnsip2.isEmpty()) {
                setStringValue(75, dnsip2);
            }
            addLogToManager(_getStringValue(this.mHandle, 100));
            this.mState = 3;
        }
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = i;
        obtainMessage.arg1 = i3;
        obtainMessage.obj = bDImageXInfo2;
        obtainMessage.sendToTarget();
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
        if (this.mListener != null) {
            if (i == 103) {
                long time = new Date().getTime();
                BDImageXUploaderAbstractListener bDImageXUploaderAbstractListener = this.mAbstractListener;
                if (bDImageXUploaderAbstractListener != null) {
                    bDImageXUploaderAbstractListener.onUploadStage(i2, time);
                }
            }
            this.mListener.onLog(i, i2, str);
        }
    }

    public int checkNet(int i, int i2) {
        BDImageXUploaderListener bDImageXUploaderListener = this.mListener;
        if (bDImageXUploaderListener != null) {
            return bDImageXUploaderListener.imageXUploadCheckNetState(i, i2);
        }
        return 1;
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
        BDImageXInfo bDImageXInfo = (BDImageXInfo) message.obj;
        long j = bDImageXInfo != null ? bDImageXInfo.mProgress : 0L;
        if (i == 124) {
            j = message.arg1;
        }
        this.mListener.onNotify(i, j, bDImageXInfo);
        return true;
    }

    public String getDNSIP() {
        return BDUploadUtil.getDNSServerIP();
    }

    public void setProcessActionType(int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, 65, i);
    }

    public void setFilePath(int i, String[] strArr) {
        long j = this.mHandle;
        if (j == 0 || strArr == null || i <= 0) {
            return;
        }
        this.mImageNum = i;
        _setFilePaths(j, i, strArr);
        _setIntValue(this.mHandle, 81, 0);
    }

    public void setFileNum(int i) {
        long j = this.mHandle;
        if (j == 0 || i <= 0) {
            return;
        }
        this.mImageNum = i;
        _setFileNum(j, i);
    }

    public void setFileNum(int i, int i2) {
        long j = this.mHandle;
        if (j == 0 || i <= 0) {
            return;
        }
        this.mImageNum = i;
        _setFileNum(j, i);
        _setIntValue(this.mHandle, 438, i2);
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

    public void setServiceID(String str) {
        setStringValue(45, str);
    }

    public void setUploadDomain(String str) {
        if (this.mHandle == 0 || str == null) {
            return;
        }
        setStringValue(46, str);
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

    public void setSliceRetryCount(int i) {
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

    public void setEnableHttps(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 19, i);
    }

    public void setPolicyParams(TreeMap<String, Object> treeMap) {
        String mapToString;
        if (this.mHandle == 0 || treeMap == null || (mapToString = BDUploadUtil.mapToString(treeMap)) == null) {
            return;
        }
        setStringValue(55, mapToString);
    }

    public void setConfig(TreeMap<String, Object> treeMap) {
        String mapToString;
        if (this.mHandle == 0 || treeMap == null || (mapToString = BDUploadUtil.mapToString(treeMap)) == null) {
            return;
        }
        setStringValue(56, mapToString);
    }

    public void setMaxFailTime(int i) {
        long j = this.mHandle;
        if (j == 0 || i < 0) {
            return;
        }
        _setIntValue(j, 13, i);
    }

    public void setTranTimeOutUnit(int i) {
        long j = this.mHandle;
        if (j == 0 || i <= 0) {
            return;
        }
        _setIntValue(j, 64, i);
    }

    public void setEnableCommitUpload(int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, 401, i);
    }

    public void setEnableCommitUpload(boolean z) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, 401, z ? 1 : 0);
    }

    public void setEnableSkipMeta(boolean z) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, UploadKeys.KeyIsSkipMeta, z ? 1 : 0);
    }

    public void setEnableEnd2EndEncryption(int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        this.mEnd2EndEncryptionOption = i;
        _setIntValue(j, UploadKeys.KeyIsEnd2EndEncryptionOption, i);
    }

    public void setEnd2EndEncryptionPublicKey(String str) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setStringValue(j, UploadKeys.KeyIsEnd2EndEncryptionPublicKey, str);
    }

    public void setEnd2EndEncryptionAESKey(String str) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        this.mEnd2EndEncryptionAESKey = str;
        _setStringValue(j, UploadKeys.KeyIsEnd2EndEncryptionAESKey, str);
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
            if (this.mHandle != 0) {
                Log.e("ttmn", "before java stop");
                _stop(this.mHandle);
                addLogToManager(_getStringValue(this.mHandle, 100));
                this.mState = 4;
                Log.e("ttmn", "after java stop");
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

    public void addLogToManager(String str) {
        JSONObject jSONObject;
        if (BDUploadUtil.mSkipUploadLog.booleanValue()) {
            return;
        }
        String uuid = UUID.randomUUID().toString();
        if (uuid == null || uuid.length() <= 0) {
            uuid = "invalid_uuid";
        }
        try {
            jSONObject = new JSONObject(str);
            jSONObject.put("dns_version", BDUploadResolver.mDNSVersion);
            jSONObject.put("main_dns_type", BDUploadDNSParser.mGlobalMainType);
            jSONObject.put("main_back_type", BDUploadDNSParser.mGlobalBackType);
            jSONObject.put("back_delayed_time", BDUploadDNSParser.mGlobalBackUpDelayedTime);
            jSONObject.put("expired_time", BDUploadDNSParser.mGlobalDefaultExpiredTime);
            jSONObject.put("uuid", uuid);
            jSONObject.remove("event");
            jSONObject.put("event", "bd_image_upload_all");
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("image_array");
                if (jSONArray != null) {
                    jSONObject.remove("image_array");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                        jSONObject2.remove("event");
                        jSONObject2.put("event", "bd_image_upload_single");
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                        Iterator<String> keys = jSONObject3.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject2.put(next, jSONObject3.get(next));
                        }
                        jSONObject2.put("uuid", uuid);
                        UploadEventManager.instance.addEvent(jSONObject2);
                    }
                }
            } catch (Exception unused2) {
                Log.e("ttmn", "get image_array failed");
            }
        }
        UploadEventManager.instance.addEvent(jSONObject);
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

    public void setMediaDataReader(BDMediaDataReader bDMediaDataReader, int i) {
        long j = this.mHandle;
        if (j == 0 || bDMediaDataReader == null || i <= 0) {
            return;
        }
        _setIntValue(j, 71, i);
        _setIntValue(this.mHandle, 81, 2);
        _setObject(this.mHandle, 201, bDMediaDataReader);
    }

    private void setMediaDataReader(BDMediaDataReader bDMediaDataReader, int i, int i2) {
        if (this.mHandle == 0 || bDMediaDataReader == null || i <= 0) {
            return;
        }
        setMediaDataReader(bDMediaDataReader, i);
        _setIntValue(this.mHandle, 81, i2);
    }

    public void setFileName(int i, String[] strArr) {
        long j = this.mHandle;
        if (j == 0 || strArr == null || i <= 0) {
            return;
        }
        _setFileName(j, i, strArr);
    }

    public void setSpecifiedContentType(int i, String[] strArr) {
        long j = this.mHandle;
        if (j == 0 || strArr == null || i <= 0) {
            return;
        }
        _setSpecifiedContentType(j, i, strArr);
    }

    public void setFileStoreKeys(int i, String[] strArr) {
        long j = this.mHandle;
        if (j == 0 || strArr == null || i <= 0) {
            return;
        }
        _setFileStoreKeys(j, i, strArr);
    }

    public void setFileData(int i, byte[][] bArr) {
        long j = this.mHandle;
        if (j == 0 || bArr == null || i <= 0) {
            return;
        }
        _setFileData(j, i, bArr);
    }

    public void setScenesTag(String str) {
        long j = this.mHandle;
        if (j == 0 || str == null) {
            return;
        }
        _setStringValue(j, 85, str);
    }

    public void setSliceThreshold(int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, 402, i);
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

    public void setCustomHttpHeaders(TreeMap<String, Object> treeMap) {
        String mapToString;
        if (this.mHandle == 0 || treeMap == null || (mapToString = BDUploadUtil.mapToString(treeMap)) == null) {
            return;
        }
        setStringValue(BDAbstractUpload.KeyIsCustomHttpHeaders, mapToString);
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

    public void setFileExtension(String str) {
        setStringValue(1010, str);
    }

    public void setFilePrefix(String str) {
        setStringValue(1011, str);
    }

    public void setNetworkType(int i, int i2) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, i, i2);
    }
}
