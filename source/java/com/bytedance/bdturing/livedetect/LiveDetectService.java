package com.bytedance.bdturing.livedetect;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.VerifyTaskHandler;
import com.bytedance.bdturing.livedetect.net.CommonResponse;
import com.bytedance.bdturing.livedetect.net.INetWorkCallBack;
import com.bytedance.bdturing.livedetect.pty.FrameDetectResult;
import com.bytedance.bdturing.livedetect.pty.TuringPTYManager;
import com.bytedance.bdturing.monitor.VerifyStateManager;
import com.bytedance.bdturing.ttnet.ITuringNetworkCallBack;
import com.bytedance.bdturing.ttnet.TuringCommonRequest;
import com.bytedance.bdturing.utils.EnCryptUtil;
import com.bytedance.bdturing.utils.JsonUtils;
import com.bytedance.bdturing.utils.SPUtil;
import com.bytedance.bdturing.utils.UtilsKt;
import com.bytedance.bdturing.verify.ITuringVerifyService;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.bdturing.verify.request.LiveDetectRequest;
import com.bytedance.bdturing.verify.request.RiskInfoRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LiveDetectService implements ITuringVerifyService {
    public static final int BITMAP_COMPRESS_QUALITY = 95;
    private static final String CAMERA_PERMISSION_KEY = "camera_permission_key";
    private static final String PERMISSION_STATE_NOT_REQUESTED = "0";
    private static final String PERMISSION_STATE_REQUESTED = "1";
    private static final long PTY_INIT_DELAY = 5000;
    private static final String SP_FILE_NAME = "turing_live_detect_cfg";
    private static volatile LiveDetectService sInstance;
    private boolean isOnVerify;
    private final List<IByteNNLoadCallBack> mByteNNLoadCallBackList = new ArrayList();
    private BdTuringCallback mCallback;
    private AbstractRequest mRequest;

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean isProcess(int i) {
        return 16 == i;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public boolean isSenseless() {
        return false;
    }

    private LiveDetectService() {
    }

    public static LiveDetectService getInstance() {
        if (sInstance == null) {
            synchronized (LiveDetectService.class) {
                if (sInstance == null) {
                    sInstance = new LiveDetectService();
                }
            }
        }
        return sInstance;
    }

    public void init(final Context context) {
        LiveModelResManager.getInstance().init(context);
        VerifyTaskHandler.getInstance().postRunnableDelay(new Runnable() { // from class: com.bytedance.bdturing.livedetect.LiveDetectService.1
            @Override // java.lang.Runnable
            public void run() {
                if (LiveDetectService.this.useByteNN()) {
                    LiveModelResManager.getInstance().downLoadModelInNeed();
                } else {
                    TuringPTYManager.getInstance().initPTY(context, null, BdTuring.class.getName());
                }
            }
        }, 5000L);
    }

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean execute(AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback) {
        boolean z;
        AbstractRequest abstractRequest2;
        EventReport.verifyStart(abstractRequest);
        if (abstractRequest instanceof RiskInfoRequest) {
            z = abstractRequest.getSkipConfirm();
            abstractRequest2 = ((RiskInfoRequest) abstractRequest).getInnerRequest();
        } else {
            z = false;
            abstractRequest2 = null;
        }
        if (abstractRequest2 == null || !(abstractRequest2 instanceof LiveDetectRequest)) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putValue(jSONObject, "errorMsg", "request type is not LiveDetectRequest!");
            bdTuringCallback.onFail(BdTuring.VERIFY_FAIL_NOT_SUPPORT, jSONObject);
            return true;
        }
        if (isOnVerify()) {
            bdTuringCallback.onFail(BdTuring.VERIFY_FAIL_CONFLICT, null);
            VerifyStateManager.getInstance().verifyConflict(abstractRequest, "");
            EventReport.verifyConflict(abstractRequest, "LiveDetectService");
            return true;
        }
        Activity activity = abstractRequest.getActivity();
        if (activity == null) {
            EventReport.sdkStateError(abstractRequest, "activity_is_null");
            bdTuringCallback.onFail(1, null);
            return true;
        }
        this.mRequest = abstractRequest;
        this.mCallback = bdTuringCallback;
        if (!z) {
            TuringLiveDetectGuideActivity.startActivity(activity, ((LiveDetectRequest) abstractRequest2).getDetail());
            EventReport.startActivity(true, TuringLiveDetectGuideActivity.class.getName(), abstractRequest);
        } else {
            turn2DetectPage(abstractRequest, activity, ((LiveDetectRequest) abstractRequest2).getDetail());
        }
        return true;
    }

    public void turn2DetectPage(AbstractRequest abstractRequest, Activity activity, String str) {
        if (getInstance().useByteNN()) {
            TuringLiveByteNNActivity.startActivity(activity, str);
            EventReport.startActivity(true, TuringLiveByteNNActivity.class.getName(), abstractRequest);
        } else {
            TuringLivePTYActivity.startActivity(activity, str);
            EventReport.startActivity(true, TuringLivePTYActivity.class.getName(), abstractRequest);
        }
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public synchronized boolean isOnVerify() {
        return this.isOnVerify;
    }

    public synchronized void setOnVerify(boolean z) {
        EventReport.VerifyStateChange(z, "LiveDetectService", this.mRequest);
        this.isOnVerify = z;
    }

    public AbstractRequest getRequest() {
        return this.mRequest;
    }

    public void createSession(String str, final INetWorkCallBack iNetWorkCallBack) {
        String liveGetUrl = LiveAuthConfig.getLiveGetUrl();
        HashMap hashMap = new HashMap();
        hashMap.put("detail", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Content-Type", "application/json; charset=utf-8");
        try {
            new TuringCommonRequest(liveGetUrl, hashMap, null, hashMap2).doPost(new ITuringNetworkCallBack() { // from class: com.bytedance.bdturing.livedetect.LiveDetectService.2
                @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
                public void onResponse(CommonResponse commonResponse) {
                    EventReport.createSession(commonResponse.code == 200, commonResponse.message, LiveDetectService.this.mRequest);
                    INetWorkCallBack iNetWorkCallBack2 = iNetWorkCallBack;
                    if (iNetWorkCallBack2 != null) {
                        iNetWorkCallBack2.onResponse(commonResponse.code, commonResponse.data, commonResponse.message);
                    }
                }

                @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
                public void onError(Throwable th) {
                    INetWorkCallBack iNetWorkCallBack2 = iNetWorkCallBack;
                    if (iNetWorkCallBack2 != null) {
                        iNetWorkCallBack2.onError(th);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            if (iNetWorkCallBack != null) {
                iNetWorkCallBack.onError(e);
            }
        }
    }

    public void verify(String str, String str2, String str3, FrameDetectResult frameDetectResult, final INetWorkCallBack iNetWorkCallBack) {
        String liveVerifyUrl = LiveAuthConfig.getLiveVerifyUrl();
        HashMap hashMap = new HashMap();
        hashMap.put("detail", str);
        hashMap.put("ticket", str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("data", buildVerifyData(str3, frameDetectResult));
        HashMap hashMap3 = new HashMap();
        hashMap3.put("Content-Type", "application/json; charset=utf-8");
        try {
            new TuringCommonRequest(liveVerifyUrl, hashMap, hashMap2, hashMap3).doPost(new ITuringNetworkCallBack() { // from class: com.bytedance.bdturing.livedetect.LiveDetectService.3
                @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
                public void onResponse(CommonResponse commonResponse) {
                    INetWorkCallBack iNetWorkCallBack2 = iNetWorkCallBack;
                    if (iNetWorkCallBack2 != null) {
                        iNetWorkCallBack2.onResponse(commonResponse.code, commonResponse.data, commonResponse.message, commonResponse.sec_message);
                    }
                }

                @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
                public void onError(Throwable th) {
                    INetWorkCallBack iNetWorkCallBack2 = iNetWorkCallBack;
                    if (iNetWorkCallBack2 != null) {
                        iNetWorkCallBack2.onError(th);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            if (iNetWorkCallBack != null) {
                iNetWorkCallBack.onError(e);
            }
        }
    }

    private String buildVerifyData(String str, FrameDetectResult... frameDetectResultArr) {
        String bitmapToBase64;
        if (frameDetectResultArr == null || frameDetectResultArr.length == 0 || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (FrameDetectResult frameDetectResult : frameDetectResultArr) {
                JSONObject jSONObject = new JSONObject();
                if (frameDetectResult.data.rgbBytes != null && frameDetectResult.data.rgbBytes.length > 0) {
                    bitmapToBase64 = UtilsKt.bitmapToBase64(frameDetectResult.data.rgbBytes);
                } else {
                    bitmapToBase64 = UtilsKt.bitmapToBase64(frameDetectResult.data.bitmap, 95);
                }
                jSONObject.put("image", bitmapToBase64);
                JSONArray jSONArray2 = new JSONArray();
                if (frameDetectResult.boxRectInfo != null) {
                    for (int i = 0; i < frameDetectResult.boxRectInfo.size(); i++) {
                        jSONArray2.put(frameDetectResult.boxRectInfo.get(i));
                    }
                }
                jSONObject.put("roi", jSONArray2);
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("images", jSONArray);
            return EnCryptUtil.aesEncrypt(jSONObject2.toString(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void onResult(int i, JSONObject jSONObject) {
        setOnVerify(false);
        EventReport.statisticVerifyResult(i, this.mRequest);
        BdTuringCallback bdTuringCallback = this.mCallback;
        if (bdTuringCallback != null) {
            if (i == 0) {
                bdTuringCallback.onSuccess(i, jSONObject);
            } else {
                bdTuringCallback.onFail(i, jSONObject);
            }
            this.mCallback = null;
        }
    }

    public boolean isRequestCameraPermissionFirstTime() {
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        Context applicationContext = config != null ? config.getApplicationContext() : null;
        return "0".equals(applicationContext != null ? SPUtil.getString(applicationContext, "turing_live_detect_cfg", CAMERA_PERMISSION_KEY, "0") : "0");
    }

    public void updatePermissionState() {
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        Context applicationContext = config != null ? config.getApplicationContext() : null;
        if (applicationContext != null) {
            SPUtil.puString(applicationContext, "turing_live_detect_cfg", CAMERA_PERMISSION_KEY, "1");
        }
    }

    public boolean detectPageShowing() {
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        Activity topActivity = config != null ? config.getTopActivity() : null;
        return topActivity != null && ((topActivity instanceof TuringLivePTYActivity) || (topActivity instanceof TuringLiveByteNNActivity));
    }

    public boolean useByteNN() {
        return LiveAuthConfig.useByteNN();
    }

    public boolean byteNNDispatchEnable() {
        return LiveAuthConfig.liveDispatchEnable();
    }

    public Pair<Boolean, String> liveDetectState() {
        if (useByteNN()) {
            boolean isModelFileReady = LiveModelResManager.getInstance().isModelFileReady();
            boolean isByteNNLoad = isByteNNLoad();
            return new Pair<>(Boolean.valueOf(isModelFileReady && isByteNNLoad), "modelFileReady:" + isModelFileReady + ";byteNNSoReady=" + isByteNNLoad);
        }
        return new Pair<>(Boolean.valueOf(TuringPTYManager.getInstance().isPTYReady()), "");
    }

    public boolean preInit(Context context, String str) {
        if (!useByteNN()) {
            return initPTYInNeed(context, str);
        }
        return loadModelFileNNInNeed(str);
    }

    private boolean loadModelFileNNInNeed(String str) {
        boolean isModelFileReady = LiveModelResManager.getInstance().isModelFileReady();
        if (!isModelFileReady) {
            LiveModelResManager.getInstance().downLoadModelFile(str);
        }
        return isModelFileReady;
    }

    private boolean initPTYInNeed(Context context, String str) {
        TuringPTYManager.getInstance().initPTY(context, null, str);
        TuringPTYManager.getInstance().preheatInNeed();
        boolean isPTYReady = TuringPTYManager.getInstance().isPTYReady();
        EventReport.initPTY(isPTYReady, str);
        return isPTYReady;
    }

    public boolean isByteNNLoad() {
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        IByteNNDepend byteNNDepend = config != null ? config.getByteNNDepend() : null;
        return byteNNDepend != null && byteNNDepend.isByteNNSoReady();
    }

    public void removeByteNNCallBack(IByteNNLoadCallBack iByteNNLoadCallBack) {
        this.mByteNNLoadCallBackList.remove(iByteNNLoadCallBack);
    }

    private void addByteNNCallBack(IByteNNLoadCallBack iByteNNLoadCallBack) {
        if (iByteNNLoadCallBack == null || this.mByteNNLoadCallBackList.contains(iByteNNLoadCallBack)) {
            return;
        }
        this.mByteNNLoadCallBackList.add(iByteNNLoadCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchByteNNLoadResult(boolean z, String str, int i) {
        for (IByteNNLoadCallBack iByteNNLoadCallBack : this.mByteNNLoadCallBackList) {
            if (iByteNNLoadCallBack != null) {
                if (z) {
                    try {
                        iByteNNLoadCallBack.onSuccess(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    iByteNNLoadCallBack.onFail(str, i);
                }
            }
        }
        this.mByteNNLoadCallBackList.clear();
    }

    public void loadByteNNInNeed(final String str, IByteNNLoadCallBack iByteNNLoadCallBack) {
        if (isByteNNLoad()) {
            if (iByteNNLoadCallBack != null) {
                iByteNNLoadCallBack.onSuccess("");
                return;
            }
            return;
        }
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        IByteNNDepend byteNNDepend = config != null ? config.getByteNNDepend() : null;
        if (byteNNDepend != null) {
            addByteNNCallBack(iByteNNLoadCallBack);
            final long currentTimeMillis = System.currentTimeMillis();
            byteNNDepend.loadLibrary(new IByteNNLoadCallBack() { // from class: com.bytedance.bdturing.livedetect.LiveDetectService.4
                @Override // com.bytedance.bdturing.livedetect.IByteNNLoadCallBack
                public void onSuccess(String str2) {
                    EventReport.LoadByteNNPlugin(str, true, "track" + str2, System.currentTimeMillis() - currentTimeMillis);
                    LiveDetectService.this.dispatchByteNNLoadResult(true, str2, 0);
                }

                @Override // com.bytedance.bdturing.livedetect.IByteNNLoadCallBack
                public void onFail(String str2, int i) {
                    EventReport.LoadByteNNPlugin(str, false, "track:" + str2 + ",typeCode:" + i, System.currentTimeMillis() - currentTimeMillis);
                    LiveDetectService.this.dispatchByteNNLoadResult(false, str2, i);
                }
            });
        } else if (iByteNNLoadCallBack != null) {
            iByteNNLoadCallBack.onFail("ByteNN_Depend is null", -1);
        }
    }
}
