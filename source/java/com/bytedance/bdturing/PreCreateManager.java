package com.bytedance.bdturing;

import android.app.Activity;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PreCreateManager {
    private boolean isPreCreateFinish;
    private WeakReference<VerifyDialog> mDialog;
    private long mPreCreateLoadStartTime;
    private long mPreCreateStartTime;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class InstanceHolder {
        private static PreCreateManager mInstance = new PreCreateManager();

        private InstanceHolder() {
        }
    }

    private PreCreateManager() {
        this.isPreCreateFinish = false;
    }

    public static PreCreateManager getInstance() {
        return InstanceHolder.mInstance;
    }

    public void setDialog(Activity activity, AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback) {
        if (abstractRequest.getActivity() != null) {
            abstractRequest.setPreCreate(true);
            this.mPreCreateStartTime = System.currentTimeMillis();
            VerifyDialog verifyDialog = new VerifyDialog(abstractRequest, bdTuringCallback);
            verifyDialog.create();
            this.mDialog = new WeakReference<>(verifyDialog);
            this.isPreCreateFinish = false;
        }
    }

    public long getPreCreateStartTime() {
        return this.mPreCreateStartTime;
    }

    public long getPreCreateLoadStartTime() {
        return this.mPreCreateLoadStartTime;
    }

    public void preCreateFinish() {
        this.isPreCreateFinish = true;
    }

    public boolean showDialog(int i) {
        WeakReference<VerifyDialog> weakReference = this.mDialog;
        if (weakReference == null) {
            return false;
        }
        VerifyDialog verifyDialog = weakReference.get();
        if (!this.isPreCreateFinish || verifyDialog == null || i != verifyDialog.getRequest().getType()) {
            return false;
        }
        this.isPreCreateFinish = false;
        this.mPreCreateLoadStartTime = System.currentTimeMillis();
        verifyDialog.callJsCode(JsCallParser.parseNativeCallJs(1, JsCallParser.REFRESH_VERIFY_VIEW, JsCallParser.VALUE_CALL, new JSONObject(), JsCallParser.REFRESH_VERIFY_VIEW));
        verifyDialog.show();
        return true;
    }
}
