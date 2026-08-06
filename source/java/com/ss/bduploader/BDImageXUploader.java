package com.ss.bduploader;

import android.text.TextUtils;
import java.util.TreeMap;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BDImageXUploader extends BDImageXUploaderBase {
    public void setPreUpload(boolean z) {
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

    public void SetExtraParams(JSONObject jSONObject) {
        if (this.mHandle == 0 || jSONObject == null) {
            return;
        }
        setStringValue(61, jSONObject.toString());
    }

    public void setPreheatUploader(boolean z) {
        if (this.mHandle == 0) {
            return;
        }
        _setIntValue(this.mHandle, 419, z ? 1 : 0);
    }

    public void setPreheatUploader(int i) {
        if (this.mHandle == 0) {
            return;
        }
        _setIntValue(this.mHandle, 419, i);
    }

    public void startPreHeat() {
        setPreheatUploader(2);
        start();
    }

    public void allowContinueUpload() {
        if (this.mHandle == 0) {
            return;
        }
        _allowContinueUpload(this.mHandle);
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

    public void setDataTransportProtocol(int i) {
        if (this.mHandle == 0 || i < 0) {
            return;
        }
        _setIntValue(this.mHandle, 411, i);
    }

    public void setObjectType(String str) {
        setStringValue(54, str);
    }

    public void allowMergeUpload() {
        if (this.mHandle == 0) {
            return;
        }
        _mergeUpload(this.mHandle);
    }

    public void setPreUploadEncryptionMode(int i) {
        String uuid;
        if (this.mHandle == 0) {
            return;
        }
        if (i == 2 && (uuid = UUID.randomUUID().toString()) != null && uuid.length() > 0) {
            _setStringValue(this.mHandle, 420, uuid);
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
}
