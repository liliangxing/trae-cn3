package com.bytedance.bdturing.livedetect.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.C0603R;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.live.TuringLive;
import com.bytedance.bdturing.livedetect.DebugInfoCallBack;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.bytedance.bdturing.livedetect.camera.CameraFrameDataCallBack;
import com.bytedance.bdturing.livedetect.camera.ImageDataWrapper;
import com.bytedance.bdturing.livedetect.camera.ImageUtil;
import com.bytedance.bdturing.livedetect.camera.TuringCamera2Helper;
import com.bytedance.bdturing.livedetect.pty.DetectRecord;
import com.bytedance.bdturing.livedetect.pty.DetectResultParser;
import com.bytedance.bdturing.livedetect.pty.FrameDetectResult;
import com.bytedance.bdturing.livedetect.pty.TuringPTYManager;
import com.bytedance.bdturing.livedetect.view.LiveDetectMaskView;
import com.bytedance.bdturing.utils.JsonUtils;
import com.bytedance.pitaya.api.PTYTaskResultCallback;
import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYPackageInfo;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LiveDetectView extends FrameLayout implements TextureView.SurfaceTextureListener, CameraFrameDataCallBack, LiveDetectMaskView.BoxStateListener {
    private static final int IDLE = 0;
    private static final int MAX_DISPLAY_WIDTH = 720;
    private static final int MAX_RECORD_SIZE = 200;
    private static final int MSG_MAX_LEN = 1024;
    private static final int ON_DETECTING = 2;
    private static final int PENDING_START = 1;
    public static final int PTY_ERROR_INFO_SIZE = 30;
    private static final int STOP = 3;
    private static final String TAG = "LiveDetectView";
    private static final int TARGET_HEIGHT = 640;
    private static final int TARGET_WITH = 480;
    private DetectDebugView imageDetectDebugInfoView;
    private long infoDisplayTime;
    private boolean isPreheated;
    private LiveDetectMaskView.BoxStateListener mBoxStateListener;
    private TuringCamera2Helper mCamera2Helper;
    private CountDownTimer mCountDownTimer;
    DebugInfoCallBack mDebugInfoCallBack;
    private List<DetectRecord> mDetectRecord;
    private DetectStateCallback mDetectStateCallBack;
    private JSONObject mLastFrameResult;
    private String mLatestPtyErrorMsg;
    private JSONArray mPtyErrorInfoArray;
    private AtomicInteger mState;
    private AutoFixTextureView mTextureView;
    private Handler mUiHandler;
    private float mWidthHeightRatio;
    private LiveDetectMaskView maskView;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface DetectStateCallback {
        public static final int DETECT_STATE_IDLE = 0;
        public static final int DETECT_STATE_START = 1;
        public static final int DETECT_STATE_STOP = 2;
        public static final int ERROR_CAMERA_EXCEPTION = 1000;

        void onDetectTimeOut();

        void onError(int i, String str);

        void onFrameImageDetectResult(FrameDetectResult frameDetectResult);

        void onStateChange(int i);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public LiveDetectView(Context context) {
        this(context, null);
    }

    public LiveDetectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveDetectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = new AtomicInteger(0);
        this.mDetectStateCallBack = null;
        this.mDetectRecord = new ArrayList();
        this.mDebugInfoCallBack = null;
        this.infoDisplayTime = 0L;
        LayoutInflater.from(context).inflate(C0603R.layout.turing_live_detect_view_layout, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0603R.styleable.turing_detect_view);
        this.mWidthHeightRatio = obtainStyledAttributes.getFloat(C0603R.styleable.turing_detect_view_width_height_ratio, 0.0f);
        obtainStyledAttributes.recycle();
        init();
    }

    private void init() {
        this.mTextureView = (AutoFixTextureView) findViewById(C0603R.id.turing_live_detect_view);
        TuringCamera2Helper turingCamera2Helper = new TuringCamera2Helper((Activity) getContext(), this.mTextureView);
        this.mCamera2Helper = turingCamera2Helper;
        turingCamera2Helper.setCamaraFrameDataCallBack(this);
        this.mTextureView.setSurfaceTextureListener(this);
        this.mUiHandler = new Handler();
        this.maskView = (LiveDetectMaskView) findViewById(C0603R.id.turing_ldv_mask);
        this.imageDetectDebugInfoView = (DetectDebugView) findViewById(C0603R.id.turing_ldv_debug_info);
        this.maskView.setBoxStateListener(this);
        this.maskView.setDebugMode(isDebugMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDetectTimeOut() {
        DetectStateCallback detectStateCallback = this.mDetectStateCallBack;
        if (detectStateCallback != null) {
            detectStateCallback.onDetectTimeOut();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (1 == this.mState.get()) {
            startDetect();
        }
    }

    public void setDetectStateCallBack(DetectStateCallback detectStateCallback) {
        this.mDetectStateCallBack = detectStateCallback;
    }

    public void startDetect() {
        this.isPreheated = TuringPTYManager.getInstance().isPreheated();
        if (this.mState.get() == 2) {
            return;
        }
        if (!this.mTextureView.isAvailable()) {
            this.mState.set(1);
            return;
        }
        startTimer();
        this.maskView.startScanAnim();
        this.maskView.showBoxMask(true);
        this.mState.set(2);
        noticeStateChange(this.mState.get());
        this.mDetectRecord = new ArrayList();
        this.mCamera2Helper.startCamera();
    }

    private void noticeStateChange(int i) {
        if (this.mDetectStateCallBack == null) {
            return;
        }
        final int i2 = 2;
        if (i == 2) {
            i2 = 1;
        } else if (i != 3) {
            i2 = 0;
        }
        this.mUiHandler.post(new Runnable() { // from class: com.bytedance.bdturing.livedetect.view.LiveDetectView.1
            @Override // java.lang.Runnable
            public void run() {
                if (LiveDetectView.this.mDetectStateCallBack != null) {
                    LiveDetectView.this.mDetectStateCallBack.onStateChange(i2);
                }
            }
        });
    }

    public void stopDetect() {
        if (this.mState.get() != 2) {
            return;
        }
        this.mState.set(3);
        this.maskView.stopAnim();
        stopTimer();
        noticeStateChange(this.mState.get());
        this.mCamera2Helper.stopCamera();
        reportDetectRecord();
        reportPtyErrorInfo();
    }

    public void resumeDetect() {
        if (this.mState.get() != 3) {
            return;
        }
        if (!this.mTextureView.isAvailable()) {
            this.mState.set(1);
            return;
        }
        this.maskView.startScanAnim();
        this.mState.set(2);
        noticeStateChange(this.mState.get());
        this.mCamera2Helper.startCamera();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public void release() {
        stopTimer();
        stopDetect();
        this.mDetectStateCallBack = null;
        TuringCamera2Helper turingCamera2Helper = this.mCamera2Helper;
        if (turingCamera2Helper != null) {
            turingCamera2Helper.release();
            this.mCamera2Helper = null;
        }
        Handler handler = this.mUiHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mUiHandler = null;
        }
        reportDetectRecord();
        TuringPTYManager.getInstance().release();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        if (size > MAX_DISPLAY_WIDTH) {
            size = MAX_DISPLAY_WIDTH;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((int) ((size * 1.0f) / this.mWidthHeightRatio), 1073741824));
    }

    private void byteNNDetect(ImageDataWrapper imageDataWrapper, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (imageDataWrapper.bitmap.getWidth() != TARGET_WITH || imageDataWrapper.bitmap.getHeight() != TARGET_HEIGHT) {
            Bitmap bitmap = imageDataWrapper.bitmap;
            imageDataWrapper.bitmap = ImageUtil.scaleBitmapCropCenter(imageDataWrapper.bitmap, TARGET_WITH, TARGET_HEIGHT);
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        byte[] convertBitmapToRgbBytes = ImageUtil.convertBitmapToRgbBytes(imageDataWrapper.bitmap);
        LiveDetectMaskView liveDetectMaskView = this.maskView;
        ArrayList<Float> boxRectInfo = liveDetectMaskView != null ? liveDetectMaskView.getBoxRectInfo() : null;
        if (boxRectInfo == null || boxRectInfo.size() != 4) {
            return;
        }
        String detectImg = TuringLive.getInstance().detectImg(convertBitmapToRgbBytes, new float[]{boxRectInfo.get(0).floatValue(), boxRectInfo.get(1).floatValue(), boxRectInfo.get(2).floatValue(), boxRectInfo.get(3).floatValue()});
        if (TextUtils.isEmpty(detectImg)) {
            return;
        }
        DetectRecord detectRecord = new DetectRecord();
        detectRecord.dataConvertTime = jSONObject != null ? jSONObject.optLong("convert_camera_data_time_use") : 0L;
        try {
            JSONObject jSONObject2 = new JSONObject(detectImg);
            this.mLastFrameResult = jSONObject2;
            FrameDetectResult parseDetectResult = DetectResultParser.parseDetectResult(jSONObject2, boxRectInfo);
            long currentTimeMillis2 = System.currentTimeMillis();
            this.mLastFrameResult.put("ts", currentTimeMillis2);
            parseDetectResult.data = imageDataWrapper;
            detectRecord.f101ts = currentTimeMillis2;
            detectRecord.status = parseDetectResult.status;
            detectRecord.engineTime = System.currentTimeMillis() - currentTimeMillis;
            detectRecord.log = parseDetectResult.logInfo;
            noticeDetectResult(parseDetectResult);
            if (isDebugMode()) {
                JsonUtils.putValue(jSONObject, "pty_time_use", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (parseDetectResult != null) {
                    JsonUtils.putValue(jSONObject, "status", Integer.valueOf(parseDetectResult.status));
                    JsonUtils.putValue(jSONObject, "debugInfo", parseDetectResult.logInfo);
                }
                showDebugInfo(parseDetectResult);
                displayTestInfo(true, null, null, null, jSONObject);
            }
            recordResult(detectRecord);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pitayaDetect(final ImageDataWrapper imageDataWrapper, final JSONObject jSONObject) {
        if (this.mState.get() != 2) {
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        LiveDetectMaskView liveDetectMaskView = this.maskView;
        final ArrayList<Float> boxRectInfo = liveDetectMaskView != null ? liveDetectMaskView.getBoxRectInfo() : null;
        final long currentTimeMillis = System.currentTimeMillis();
        Bitmap bitmap = imageDataWrapper.bitmap;
        final DetectRecord detectRecord = new DetectRecord();
        detectRecord.dataConvertTime = jSONObject != null ? jSONObject.optLong("convert_camera_data_time_use") : 0L;
        TuringPTYManager.getInstance().imgIdentify(bitmap, boxRectInfo, new PTYTaskResultCallback() { // from class: com.bytedance.bdturing.livedetect.view.LiveDetectView.2
            public void onResult(boolean z, PTYError pTYError, PTYTaskData pTYTaskData, PTYPackageInfo pTYPackageInfo) {
                try {
                    try {
                        LiveDetectView.this.recordPTYErrorInfo(z, pTYError, pTYTaskData, pTYPackageInfo);
                        FrameDetectResult parseDetectResult = DetectResultParser.parseDetectResult(pTYTaskData, (ArrayList<Float>) boxRectInfo);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (parseDetectResult != null) {
                            parseDetectResult.data = imageDataWrapper;
                            detectRecord.f101ts = currentTimeMillis2;
                            detectRecord.status = parseDetectResult.status;
                            detectRecord.engineTime = System.currentTimeMillis() - currentTimeMillis;
                            LiveDetectView.this.noticeDetectResult(parseDetectResult);
                        }
                        LiveDetectView.this.mLastFrameResult = pTYTaskData != null ? pTYTaskData.getParams() : null;
                        if (LiveDetectView.this.mLastFrameResult != null) {
                            LiveDetectView.this.mLastFrameResult.put("ts", currentTimeMillis2);
                        }
                        if (LiveDetectView.this.isDebugMode()) {
                            JsonUtils.putValue(jSONObject, "pty_time_use", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            if (parseDetectResult != null) {
                                JsonUtils.putValue(jSONObject, "status", Integer.valueOf(parseDetectResult.status));
                                JsonUtils.putValue(jSONObject, "debugInfo", parseDetectResult.logInfo);
                            }
                            LiveDetectView.this.showDebugInfo(parseDetectResult);
                            LiveDetectView.this.displayTestInfo(z, pTYError, pTYTaskData, pTYPackageInfo, jSONObject);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await();
            recordResult(detectRecord);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.bdturing.livedetect.camera.CameraFrameDataCallBack
    public void onFrameData(ImageDataWrapper imageDataWrapper, JSONObject jSONObject) {
        if (LiveDetectService.getInstance().useByteNN()) {
            byteNNDetect(imageDataWrapper, jSONObject);
        } else {
            pitayaDetect(imageDataWrapper, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordPTYErrorInfo(boolean z, PTYError pTYError, PTYTaskData pTYTaskData, PTYPackageInfo pTYPackageInfo) {
        String str;
        if (z && pTYError == null) {
            return;
        }
        try {
            JSONArray jSONArray = this.mPtyErrorInfoArray;
            if (jSONArray == null || jSONArray.length() <= 30) {
                String str2 = "";
                String pTYError2 = pTYError != null ? pTYError.toString() : "";
                String str3 = this.mLatestPtyErrorMsg;
                if (str3 == null || !str3.equals(pTYError2)) {
                    this.mLatestPtyErrorMsg = pTYError2;
                    if (this.mPtyErrorInfoArray == null) {
                        this.mPtyErrorInfoArray = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("success", z);
                    if (pTYError2.length() > 1024) {
                        pTYError2 = pTYError2.substring(0, 1024);
                    }
                    jSONObject.put("ptyError", pTYError2);
                    if (pTYTaskData == null || pTYTaskData.getParams() == null) {
                        str = "";
                    } else {
                        str = pTYTaskData.getParams().toString();
                        if (str.length() > 1024) {
                            str = str.substring(0, 1024);
                        }
                    }
                    jSONObject.put("outputData", str);
                    if (pTYPackageInfo != null) {
                        String pTYPackageInfo2 = pTYPackageInfo.toString();
                        if (pTYPackageInfo2.length() > 1024) {
                            pTYPackageInfo2 = pTYPackageInfo2.substring(0, 1024);
                        }
                        str2 = pTYPackageInfo2;
                    }
                    jSONObject.put("ptyPackageInfo", str2);
                    this.mPtyErrorInfoArray.put(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reportPtyErrorInfo() {
        try {
            JSONArray jSONArray = this.mPtyErrorInfoArray;
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            EventReport.liveDetectError(BdTuring.PTY_RUN_ERROR, this.mPtyErrorInfoArray.toString(), LiveDetectService.getInstance().getRequest());
            this.mPtyErrorInfoArray = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reportDetectRecord() {
        try {
            List<DetectRecord> list = this.mDetectRecord;
            if (list == null || list.size() <= 0) {
                return;
            }
            EventReport.sendDetectDetail(this.mDetectRecord, this.isPreheated, this.mLastFrameResult, LiveDetectService.getInstance().getRequest());
            this.mDetectRecord = null;
            this.mLastFrameResult = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebugMode() {
        if (BdTuring.getInstance().getConfig() != null) {
            return BdTuring.getInstance().getConfig().isLiveDebugMode();
        }
        return false;
    }

    private void recordResult(DetectRecord detectRecord) {
        List<DetectRecord> list;
        if (detectRecord == null || (list = this.mDetectRecord) == null || list.size() >= 200) {
            return;
        }
        this.mDetectRecord.add(detectRecord);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDebugInfo(final FrameDetectResult frameDetectResult) {
        if (frameDetectResult != null) {
            this.mUiHandler.post(new Runnable() { // from class: com.bytedance.bdturing.livedetect.view.LiveDetectView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (frameDetectResult != null) {
                        LiveDetectView.this.imageDetectDebugInfoView.updateInfo(frameDetectResult.mKeyPtList, frameDetectResult.mFaceBoxList);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.bdturing.livedetect.camera.CameraFrameDataCallBack
    public void onCameraException(final int i, final Exception exc) {
        Handler handler;
        if (this.mDetectStateCallBack == null || (handler = this.mUiHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.bytedance.bdturing.livedetect.view.LiveDetectView.4
            @Override // java.lang.Runnable
            public void run() {
                if (LiveDetectView.this.mState.get() != 3) {
                    LiveDetectView.this.mDetectStateCallBack.onError(i, exc.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void noticeDetectResult(final FrameDetectResult frameDetectResult) {
        Handler handler;
        if (this.mDetectStateCallBack == null || (handler = this.mUiHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.bytedance.bdturing.livedetect.view.LiveDetectView.5
            @Override // java.lang.Runnable
            public void run() {
                if (LiveDetectView.this.mDetectStateCallBack == null || LiveDetectView.this.mState.get() != 2) {
                    return;
                }
                LiveDetectView.this.mDetectStateCallBack.onFrameImageDetectResult(frameDetectResult);
            }
        });
    }

    public void setDebugInfoCallBack(DebugInfoCallBack debugInfoCallBack) {
        this.mDebugInfoCallBack = debugInfoCallBack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayTestInfo(final boolean z, final PTYError pTYError, final PTYTaskData pTYTaskData, PTYPackageInfo pTYPackageInfo, final JSONObject jSONObject) {
        if ((jSONObject != null ? jSONObject.optInt("status", -1) : -1) == 0 || System.currentTimeMillis() - this.infoDisplayTime >= 100) {
            this.infoDisplayTime = System.currentTimeMillis();
            Handler handler = this.mUiHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.bytedance.bdturing.livedetect.view.LiveDetectView.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("success", z);
                            jSONObject2.put("ptyError", pTYError);
                            jSONObject2.put("outputData", pTYTaskData);
                            jSONObject2.put("convert_camera_data_time_use", jSONObject.optLong("convert_camera_data_time_use"));
                            jSONObject2.put("pty_time_use", jSONObject.optLong("pty_time_use"));
                            jSONObject2.put("status", jSONObject.optInt("status", -1));
                            jSONObject2.put("debugInfo", jSONObject.optString("debugInfo", ""));
                            if (LiveDetectView.this.mDebugInfoCallBack != null) {
                                LiveDetectView.this.mDebugInfoCallBack.debugInfo(jSONObject2);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public void setDetectTimeOut(final long j) {
        if (j <= 0) {
            return;
        }
        this.mCountDownTimer = new CountDownTimer(j, 1000L) { // from class: com.bytedance.bdturing.livedetect.view.LiveDetectView.7
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (((int) (j2 / 1000)) == ((int) (((float) j) * 0.4f)) / 1000) {
                    LiveDetectView.this.maskView.showBoxMask(false);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                LiveDetectView.this.onDetectTimeOut();
            }
        };
    }

    private void startTimer() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    private void stopTimer() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void setBoxStateListener(LiveDetectMaskView.BoxStateListener boxStateListener) {
        this.mBoxStateListener = boxStateListener;
    }

    @Override // com.bytedance.bdturing.livedetect.view.LiveDetectMaskView.BoxStateListener
    public void onBoxSizeChange(Rect rect) {
        LiveDetectMaskView.BoxStateListener boxStateListener = this.mBoxStateListener;
        if (boxStateListener != null) {
            boxStateListener.onBoxSizeChange(rect);
        }
    }

    public void setDetectResult(boolean z) {
        this.maskView.updateDetectState(z ? 3 : 0);
    }
}
