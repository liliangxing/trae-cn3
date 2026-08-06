package com.bytedance.bdturing.monitor;

import android.text.TextUtils;
import com.bytedance.apm.constant.ReportProtocal;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.net.CommonResponse;
import com.bytedance.bdturing.senseless.TimeOutWatchDog;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.ttnet.ITuringNetworkCallBack;
import com.bytedance.bdturing.ttnet.TuringCommonRequest;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class VerifyStateManager {
    private static final String HTTPS_SCHEME = "https://";
    private static final int MAX_RECORD_COUNT = 5;
    private static final String PATH_REPORT = "captcha/report_client_status";
    private static final int RETRY_COUNT = 1;
    private static final long TIME_PERIOD = 10000;
    private static volatile VerifyStateManager sInstance;
    private List<JSONObject> mConflictRecord = new ArrayList();
    private TimeOutWatchDog mDog;
    private String mReportUrl;
    private int mRetryCount;

    static /* synthetic */ int access$108(VerifyStateManager verifyStateManager) {
        int i = verifyStateManager.mRetryCount;
        verifyStateManager.mRetryCount = i + 1;
        return i;
    }

    private VerifyStateManager() {
    }

    public static VerifyStateManager getInstance() {
        if (sInstance == null) {
            synchronized (VerifyStateManager.class) {
                if (sInstance == null) {
                    sInstance = new VerifyStateManager();
                }
            }
        }
        return sInstance;
    }

    public void verifyConflict(AbstractRequest abstractRequest, String str) {
        if (abstractRequest == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportProtocal.KEY_LOG_ID, abstractRequest.getLogId());
            jSONObject.put("subtype", abstractRequest.getVerifyType());
            jSONObject.put("detail", abstractRequest.getDecision_detail());
            addRecord(jSONObject);
            if (this.mConflictRecord.size() >= 5) {
                uploadRecord();
            } else {
                startWatchDog();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startWatchDog() {
        TimeOutWatchDog timeOutWatchDog = this.mDog;
        if (timeOutWatchDog == null || !timeOutWatchDog.isRunning()) {
            TimeOutWatchDog timeOutWatchDog2 = new TimeOutWatchDog(new TimeOutWatchDog.Listener() { // from class: com.bytedance.bdturing.monitor.VerifyStateManager.1
                @Override // com.bytedance.bdturing.senseless.TimeOutWatchDog.Listener
                public void onTimeOut() {
                    VerifyStateManager.this.uploadRecord();
                }
            });
            this.mDog = timeOutWatchDog2;
            timeOutWatchDog2.start(10000L);
        }
    }

    private void addRecord(JSONObject jSONObject) {
        synchronized (VerifyStateManager.class) {
            this.mConflictRecord.add(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadRecord() {
        TimeOutWatchDog timeOutWatchDog = this.mDog;
        if (timeOutWatchDog != null && timeOutWatchDog.isRunning()) {
            this.mDog.cancel();
        }
        if (this.mConflictRecord.isEmpty()) {
            return;
        }
        this.mRetryCount = 0;
        synchronized (VerifyStateManager.class) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.mConflictRecord.size(); i++) {
                jSONArray.put(this.mConflictRecord.get(i));
            }
            this.mConflictRecord.clear();
            reportConflictRecord(jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportConflictRecord(final JSONArray jSONArray) {
        String reportUrl = getReportUrl();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CpuReportEvent.PERF_DATA_TYPE, "verify_conflict");
            jSONObject.put("data", jSONArray);
            new TuringCommonRequest(reportUrl, null, null, jSONObject, hashMap).doPost(new ITuringNetworkCallBack() { // from class: com.bytedance.bdturing.monitor.VerifyStateManager.2
                @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
                public void onResponse(CommonResponse commonResponse) {
                    if (commonResponse != null && commonResponse.code == 200) {
                        EventReport.verifyStateReportResult(true, "", null);
                        return;
                    }
                    EventReport.verifyStateReportResult(false, commonResponse != null ? commonResponse.message : "", null);
                    if (VerifyStateManager.this.mRetryCount < 1) {
                        VerifyStateManager.access$108(VerifyStateManager.this);
                        VerifyStateManager.this.reportConflictRecord(jSONArray);
                    }
                }

                @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
                public void onError(Throwable th) {
                    EventReport.verifyStateReportResult(false, "net work error:" + th, null);
                    if (VerifyStateManager.this.mRetryCount < 1) {
                        VerifyStateManager.access$108(VerifyStateManager.this);
                        VerifyStateManager.this.reportConflictRecord(jSONArray);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getReportUrl() {
        if (TextUtils.isEmpty(this.mReportUrl)) {
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
            this.mReportUrl = sb.append(PATH_REPORT).toString();
        }
        return this.mReportUrl;
    }
}
