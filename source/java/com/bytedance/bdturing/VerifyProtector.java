package com.bytedance.bdturing;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.bdturing.comonui.AlertDialogParam;
import com.bytedance.bdturing.comonui.TuringAlertDialog;
import com.bytedance.bdturing.comonui.TuringAlertDialogCallBack;
import com.bytedance.bdturing.livedetect.net.CommonResponse;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.ttnet.ITuringNetworkCallBack;
import com.bytedance.bdturing.ttnet.TuringCommonRequest;
import com.bytedance.bdturing.utils.JsonUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class VerifyProtector {
    private static final String HTTPS_SCHEME = "https://";
    public static final String NOTIFY_DATA_KEY = "notify_data";
    private static final String PATH = "combined_verify/notify";
    private static final int RETRY_COUNT = 1;
    private static volatile VerifyProtector sInstance;
    private WeakReference<TuringAlertDialog> mDialogRef;
    private int mRetryNum = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface NotifyCallBack {
        void onFail(int i, String str);

        void onSuccess();
    }

    static /* synthetic */ int access$008(VerifyProtector verifyProtector) {
        int i = verifyProtector.mRetryNum;
        verifyProtector.mRetryNum = i + 1;
        return i;
    }

    private VerifyProtector() {
    }

    public static VerifyProtector getInstance() {
        if (sInstance == null) {
            synchronized (VerifyProtector.class) {
                if (sInstance == null) {
                    sInstance = new VerifyProtector();
                }
            }
        }
        return sInstance;
    }

    public void sendVerifyResult(JSONObject jSONObject, JSONObject jSONObject2, NotifyCallBack notifyCallBack) {
        String host = getHost();
        if (TextUtils.isEmpty(host)) {
            notifyCallBack.onFail(3, "");
            return;
        }
        this.mRetryNum = 0;
        sendResultInner(host + PATH, JsonUtils.jsonToMap(jSONObject2), JsonUtils.jsonToMap(jSONObject), notifyCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResultInner(final String str, final Map<String, String> map, final Map<String, String> map2, final NotifyCallBack notifyCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        new TuringCommonRequest(str, map, map2, hashMap).doPost(new ITuringNetworkCallBack() { // from class: com.bytedance.bdturing.VerifyProtector.1
            @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
            public void onResponse(CommonResponse commonResponse) {
                LogUtil.m160d("VerifyProtector", "====>onResponse:mRetryNum=" + VerifyProtector.this.mRetryNum + ":response=" + commonResponse);
                if (commonResponse.code != 200) {
                    if (VerifyProtector.this.mRetryNum >= 1) {
                        VerifyProtector.this.handleFail(str, map, map2, commonResponse.code, commonResponse.message, notifyCallBack);
                        return;
                    } else {
                        VerifyProtector.access$008(VerifyProtector.this);
                        VerifyProtector.this.sendResultInner(str, map, map2, notifyCallBack);
                        return;
                    }
                }
                notifyCallBack.onSuccess();
            }

            @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
            public void onError(Throwable th) {
                LogUtil.m161e("VerifyProtector", "====>onError:mRetryNum=" + VerifyProtector.this.mRetryNum + ":throwable" + th);
                if (VerifyProtector.this.mRetryNum >= 1) {
                    VerifyProtector.this.handleFail(str, map, map2, 3, "", notifyCallBack);
                } else {
                    VerifyProtector.access$008(VerifyProtector.this);
                    VerifyProtector.this.sendResultInner(str, map, map2, notifyCallBack);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFail(final String str, final Map<String, String> map, final Map<String, String> map2, final int i, final String str2, final NotifyCallBack notifyCallBack) {
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        Activity topActivity = config != null ? config.getTopActivity() : null;
        if (topActivity == null) {
            notifyCallBack.onFail(i, str2);
            return;
        }
        try {
            final Activity activity = topActivity;
            topActivity.runOnUiThread(new Runnable() { // from class: com.bytedance.bdturing.VerifyProtector.2
                @Override // java.lang.Runnable
                public void run() {
                    String string = activity.getString(C0603R.string.turing_net_error_dlg_fail_title);
                    String string2 = activity.getString(C0603R.string.turing_verify_retry_content);
                    AlertDialogParam alertDialogParam = new AlertDialogParam();
                    alertDialogParam.title = string;
                    alertDialogParam.contentText = string2;
                    alertDialogParam.lefBtnText = activity.getString(C0603R.string.turing_verify_cancel);
                    alertDialogParam.rightBtnText = activity.getString(C0603R.string.turing_verify_retry);
                    TuringAlertDialog turingAlertDialog = new TuringAlertDialog(activity, alertDialogParam, true, new TuringAlertDialogCallBack() { // from class: com.bytedance.bdturing.VerifyProtector.2.1
                        @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
                        public void onLeftBtnClick() {
                            if (VerifyProtector.this.mDialogRef != null && VerifyProtector.this.mDialogRef.get() != null) {
                                ((TuringAlertDialog) VerifyProtector.this.mDialogRef.get()).dismiss();
                                VerifyProtector.this.mDialogRef.clear();
                                VerifyProtector.this.mDialogRef = null;
                            }
                            notifyCallBack.onFail(i, str2);
                        }

                        @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
                        public void onRightBtnClick() {
                            if (VerifyProtector.this.mDialogRef != null && VerifyProtector.this.mDialogRef.get() != null) {
                                ((TuringAlertDialog) VerifyProtector.this.mDialogRef.get()).dismiss();
                                VerifyProtector.this.mDialogRef.clear();
                                VerifyProtector.this.mDialogRef = null;
                            }
                            VerifyProtector.this.sendResultInner(str, map, map2, notifyCallBack);
                        }

                        @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
                        public void onCancel() {
                            if (VerifyProtector.this.mDialogRef != null && VerifyProtector.this.mDialogRef.get() != null) {
                                ((TuringAlertDialog) VerifyProtector.this.mDialogRef.get()).dismiss();
                                VerifyProtector.this.mDialogRef.clear();
                                VerifyProtector.this.mDialogRef = null;
                            }
                            notifyCallBack.onFail(i, str2);
                        }
                    });
                    VerifyProtector.this.mDialogRef = new WeakReference(turingAlertDialog);
                    turingAlertDialog.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            notifyCallBack.onFail(i, str2);
        }
    }

    private String getHost() {
        String host = SettingsManager.INSTANCE.getHost(SettingsManager.VERIFY_SERVICE);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(host)) {
            if (!host.startsWith("https://")) {
                sb.append("https://");
            }
            sb.append(host);
            if (!host.endsWith("/")) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
}
