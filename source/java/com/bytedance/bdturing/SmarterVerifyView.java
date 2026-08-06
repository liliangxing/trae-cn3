package com.bytedance.bdturing;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.bdturing.OnTouchSmarterListener;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.utils.UtilsKt;
import com.bytedance.bdturing.verify.request.SmarterVerifyRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SmarterVerifyView extends FrameLayout {
    public static final String TAG = "SmarterVerifyView";
    private BdTuringCallback mCallback;
    private OnTouchSmarterListener mSmarterListener;

    public SmarterVerifyView(Context context) {
        super(context);
        this.mSmarterListener = new OnTouchSmarterListener();
    }

    public SmarterVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSmarterListener = new OnTouchSmarterListener();
    }

    public SmarterVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSmarterListener = new OnTouchSmarterListener();
    }

    public SmarterVerifyView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mSmarterListener = new OnTouchSmarterListener();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!BdTuring.getInstance().isInitDone()) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mSmarterListener.onActionDownEvent();
            return false;
        }
        if (action != 1) {
            return false;
        }
        this.mSmarterListener.onActionUpEvent(motionEvent, new OnTouchSmarterListener.SmarterCallback() { // from class: com.bytedance.bdturing.SmarterVerifyView.1
            @Override // com.bytedance.bdturing.OnTouchSmarterListener.SmarterCallback
            public void execute(JSONObject jSONObject) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("click_coordinate");
                    jSONArray.put(SmarterVerifyView.this.getWidth());
                    jSONArray.put(SmarterVerifyView.this.getHeight());
                    Log.i(SmarterVerifyView.TAG, "data = " + jSONObject);
                    SmarterVerifyView.this.showSmarterVerifyDialog(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSmarterVerifyDialog(JSONObject jSONObject) {
        BdTuring bdTuring = BdTuring.getInstance();
        SmarterVerifyRequest smarterVerifyRequest = new SmarterVerifyRequest(SettingsManager.SMARTER_VIEW_SERVICE, jSONObject);
        smarterVerifyRequest.setLoading(false);
        bdTuring.showVerifyDialog(UtilsKt.findActivity(getContext()), smarterVerifyRequest, this.mCallback);
    }

    public void setCallBack(BdTuringCallback bdTuringCallback) {
        this.mCallback = bdTuringCallback;
    }
}
