package com.bytedance.bdinstall;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdinstall.event.VerifyMonitor;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class VerifyTicketWorker extends BaseWorker {
    private final InstallOptions mConfig;
    private final Env mEnv;
    private final DeviceManager mManager;
    private final Map<String, String> mTicketData;
    private final VerifyMonitor verifyMonitor;

    @Override // com.bytedance.bdinstall.BaseWorker
    protected String getName() {
        return "ticketGuard";
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public boolean needListenNetChange() {
        return true;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected boolean needNet() {
        return true;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected long nextInterval() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VerifyTicketWorker(InstallOptions installOptions, Env env, DeviceManager deviceManager, Map<String, String> map) {
        super(installOptions.getContext(), installOptions);
        this.mConfig = installOptions;
        this.mEnv = env;
        this.mManager = deviceManager;
        this.mTicketData = map;
        this.verifyMonitor = EventUtils.getInstance().getVerifyMonitor(installOptions.getAid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.BaseWorker
    public void updateFailCount(int i) {
        this.verifyMonitor.setFailCount(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.BaseWorker
    public void doEventTrack() {
        Map<String, Long> timestamp = this.mManager.getTicketGuardHelper().getTimestamp();
        if (timestamp.size() > 0) {
            this.verifyMonitor.setTimestampMap(timestamp);
        }
        EventUtils.onVerifyResult(this.mConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.BaseWorker
    public void onResult(boolean z) {
        this.verifyMonitor.setSuccess(!z ? 1 : 0);
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected long[] getRetryIntervals() {
        return Register.RETRY_DIFF;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected boolean doWork() {
        boolean z = false;
        try {
            JSONObject buildBody = buildBody();
            String uri = Uri.parse(this.mEnv.getConfig().getVerifyUri()).buildUpon().appendQueryParameter("req_id", RequestIdGenerator.getRequestId()).build().toString();
            z = Api.verify(this.mConfig.getNetworkClient(), BDInstall.getBDInstallConfig().getNetworkClientWrapper(), uri, buildBody, this.mConfig.encryptAndCompress(), this.mConfig.getEncryptor(), (TextUtils.isEmpty(buildBody.optString("device_id")) || TextUtils.isEmpty(buildBody.optString("install_id"))) ? false : true, this.mManager.getTicketGuardHelper().consumerTicketDataHeader(uri, this.mTicketData.get("ts_sign"), this.mManager.getConstHeader().optString(Api.KEY_ENCRYPT_IID), false));
            if (z) {
                stop();
            }
            DrLog.m139d("TicketGuard# [after verify] response result " + z);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    private JSONObject buildBody() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject constHeader = this.mManager.getConstHeader();
            jSONObject2.put("device_id", constHeader.optString("device_id"));
            jSONObject2.put(Api.KEY_TICKET_INSTALL_ID, constHeader.optString("install_id"));
            jSONObject2.put(Api.KEY_TICKET_APP_ID, constHeader.optString("aid"));
            jSONObject2.put("app_version", constHeader.optString("app_version"));
            jSONObject2.put("sdk_version", constHeader.optString("sdk_version"));
            jSONObject3.put(Api.KEY_ENCRYPT_DID, constHeader.optString(Api.KEY_ENCRYPT_DID));
            jSONObject3.put(Api.KEY_ENCRYPT_IID, constHeader.optString(Api.KEY_ENCRYPT_IID));
            jSONObject.put(Api.KEY_BASIC_CONTEXT, jSONObject2);
            jSONObject.put(Api.KEY_SECURITY_CONTEXT, jSONObject3);
            DrLog.m139d("TicketGuard# [before verify] doVerify request body is " + jSONObject);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
