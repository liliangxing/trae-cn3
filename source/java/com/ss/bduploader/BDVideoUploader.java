package com.ss.bduploader;

import android.text.TextUtils;
import android.util.Log;
import com.ss.bduploader.smartserver.SmartRouting;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BDVideoUploader extends BDVideoUploaderBase {
    public static final int RoutingQUIC = 0;
    public static final int RoutingTCP = 1;
    private JSONObject mEstimatedVideoInfo;
    private SmartRouting mSmartRouting;
    private boolean hasInit = false;
    private int mEstimatedVideoRate = 0;
    private int mEstimatedVideoDuration = 0;
    private int mEstimatedFileSize = -1;

    public void setProcessActionType(int i) {
        if (this.mHandle == 0) {
            return;
        }
        _setIntValue(this.mHandle, 65, i);
    }

    public void setPolicyParams(TreeMap<String, Object> treeMap) {
        if (this.mHandle == 0 || treeMap == null) {
            return;
        }
        String mapToString = BDUploadUtil.mapToString(treeMap);
        if (TextUtils.isEmpty(mapToString)) {
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

    public void setQueryAuth(String str) {
        if (this.mHandle == 0 || str == null) {
            return;
        }
        _setStringValue(this.mHandle, 15, str);
    }

    public void setExternFileReader(BDExternalFileReader bDExternalFileReader) {
        if (this.mHandle == 0 || bDExternalFileReader == null) {
            return;
        }
        _setIntValue(this.mHandle, 71, 1);
        _setObject(this.mHandle, 200, bDExternalFileReader);
    }

    public void setCustomConfig(TreeMap<String, Object> treeMap) {
        JSONObject mapToJSON;
        if (this.mHandle == 0 || treeMap == null || (mapToJSON = BDUploadUtil.mapToJSON(treeMap)) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("custom_config", mapToJSON);
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                return;
            }
            setStringValue(63, jSONObject2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.bduploader.BDVideoUploaderBase
    public void allowMergeUpload() {
        if (this.mHandle == 0) {
            return;
        }
        _mergeUpload(this.mHandle);
    }

    @Override // com.ss.bduploader.BDVideoUploaderBase
    public void setPreUploadEncryptionMode(int i) {
        if (this.mHandle == 0) {
            return;
        }
        _setIntValue(this.mHandle, 74, i);
    }

    public void cancelUpload() {
        this.mWriteLock.lock();
        if (this.mHandle == 0) {
            this.mWriteLock.unlock();
        } else {
            _cancelUpload(this.mHandle);
            this.mWriteLock.unlock();
        }
    }

    public void setSpeedTestValue(int i) {
        if (this.mHandle == 0) {
            return;
        }
        _setIntValue(this.mHandle, 405, i);
    }

    public void setSpeedTestThresh(int i) {
        if (this.mHandle == 0) {
            return;
        }
        _setIntValue(this.mHandle, 406, i);
    }

    public void setExternMinSIze(int i) {
        if (this.mHandle == 0 || i <= 0) {
            return;
        }
        _setIntValue(this.mHandle, 77, i);
    }

    public void setDataTransportProtocol(int i) {
        if (this.mHandle == 0 || i < 0) {
            return;
        }
        _setIntValue(this.mHandle, 411, i);
    }

    public void setContext(String str) {
        if (this.mHandle == 0 || str == null) {
            return;
        }
        _setContext(this.mHandle, str);
    }

    public void setExternalReaderMode(int i) {
        if (this.mHandle == 0 || i < 0) {
            return;
        }
        _setIntValue(this.mHandle, 412, i);
    }

    public void setPrivateVideo(boolean z) {
        if (this.mHandle == 0) {
            return;
        }
        _setIntValue(this.mHandle, BDVideoUploaderBase.KeyIsPrivateVideo, z ? 1 : 0);
    }

    public void setAuthType(int i) {
        if (this.mHandle == 0) {
            return;
        }
        _setIntValue(this.mHandle, 416, i);
    }

    public void setUserReference(String str) {
        if (this.mHandle == 0 || str == null) {
            return;
        }
        _setStringValue(this.mHandle, 62, str);
    }

    public void setCustomNetworkTimeoutParams(int i, int i2, int i3, int i4, int i5) {
        if (this.mHandle == 0) {
            return;
        }
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsSocketConnectTimeout, i);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsSocketReadTimeout, i2);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsSocketWriteTimeout, i3);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsTotalRequestTimeout, i4);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsSDKRetryPolicy, i5);
    }

    public void setRetryStatesOption(int i) {
        if (this.mHandle == 0) {
            return;
        }
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsRetryStatesOption, i);
    }

    public void setTTNetEngineFallbackOption(int i) {
        if (this.mHandle == 0) {
            return;
        }
        _setIntValue(this.mHandle, UploadKeys.KeyIsTTNetEngineFallback, i);
    }

    public void setSkipCode2ndFileSize(long j) {
        if (this.mHandle == 0) {
            return;
        }
        _setInt64Value(this.mHandle, BDVideoUploaderBase.KeyIsSkipCode2ndFileSize, j);
    }

    public void setEstimatedVideoInfo(TreeMap<String, Object> treeMap) {
        if (this.mHandle == 0 || treeMap.isEmpty()) {
            return;
        }
        JSONObject mapToJSON = BDUploadUtil.mapToJSON(treeMap);
        this.mEstimatedVideoInfo = mapToJSON;
        if (mapToJSON == null) {
            return;
        }
        Log.d("ttmn", "Estimated video info:" + this.mEstimatedVideoInfo);
        try {
            this.mEstimatedVideoDuration = this.mEstimatedVideoInfo.getInt("durationMs") / 1000;
            this.mEstimatedVideoRate = this.mEstimatedVideoInfo.getInt("bitrateKb");
            _setStringValue(this.mHandle, UploadKeys.KeyIsEstimatedVideoInfo, this.mEstimatedVideoInfo.toString());
            Log.d("ttmn", "Grab estimated video info" + this.mEstimatedVideoInfo + " duration:" + this.mEstimatedVideoDuration + " bitrate:" + this.mEstimatedVideoRate);
        } catch (JSONException unused) {
            Log.d("ttmn", "Grab estimated video info error, duration:" + this.mEstimatedVideoDuration + " bitrate:" + this.mEstimatedVideoRate);
        }
    }

    public void setVideoMetaData(String str) {
        if (this.mHandle == 0 || str == null) {
            return;
        }
        _setStringValue(this.mHandle, BDVideoUploaderBase.KeyIsVideoMetaData, str);
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

    private String insertFileSizeInfo(String str) {
        JSONObject jSONObject;
        try {
            int i = this.mEstimatedVideoDuration * this.mEstimatedVideoRate;
            this.mEstimatedFileSize = i > 0 ? i : this.mEstimatedFileSize;
            Log.d("ttmn", "Used estimated file size: " + this.mEstimatedFileSize + "calculated:" + i);
            jSONObject = new JSONObject(str);
            jSONObject.put("est_file_size", this.mEstimatedFileSize / 1024);
        } catch (Exception unused) {
            jSONObject = null;
        }
        return jSONObject == null ? str : jSONObject.toString();
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
}
