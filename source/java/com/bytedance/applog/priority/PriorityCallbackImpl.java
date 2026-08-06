package com.bytedance.applog.priority;

import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.CompressResult;
import com.bytedance.applog.IHeaderCustomTimelyCallback;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.monitor.MonitorUtils;
import com.bytedance.applog.monitor.p006v3.EventStage;
import com.bytedance.applog.monitor.p006v3.StageEventBasic;
import com.bytedance.applog.monitor.p006v3.StageEventType;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.util.Utils;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.common.utility.NetworkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PriorityCallbackImpl implements PriorityCallback {
    private static final List<String> loggerTags = Collections.singletonList("PriorityCallbackImpl");
    private final AppLogInstance appLogInstance;

    public PriorityCallbackImpl(AppLogInstance appLogInstance) {
        this.appLogInstance = appLogInstance;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public String getHeaderJson() {
        this.appLogInstance.getLogger().info(loggerTags, "****** priority callback get header json...", new Object[0]);
        JSONObject header = this.appLogInstance.getHeader();
        if (header == null) {
            return null;
        }
        IHeaderCustomTimelyCallback headerCustomCallback = this.appLogInstance.getHeaderCustomCallback();
        if (headerCustomCallback != null) {
            headerCustomCallback.updateHeader(header);
        }
        return header.toString();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public PriorityHttpResponse doHttpPost(String str, byte[] bArr) {
        PriorityHttpResponse priorityHttpResponse;
        long currentTimeMillis = System.currentTimeMillis();
        IAppLogLogger logger = this.appLogInstance.getLogger();
        List<String> list = loggerTags;
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = this.appLogInstance.isLogEnabled() ? new String(bArr) : Integer.valueOf(bArr.length);
        logger.info(list, "****** priority callback do http post, url: {}, buffer: {}", objArr);
        HashMap hashMap = new HashMap();
        if (this.appLogInstance.getLogCompressor() != null) {
            try {
                CompressResult compress = this.appLogInstance.getLogCompressor().compress(bArr);
                bArr = compress.getData();
                hashMap.putAll(compress.getHeaders());
            } catch (Throwable th) {
                this.appLogInstance.getLogger().error(loggerTags, "****** log compress toBytes failed", th, new Object[0]);
                this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.COMPRESS_ERROR_COUNT);
            }
        }
        if (this.appLogInstance.getEncryptAndCompress()) {
            bArr = this.appLogInstance.getApi().getEncryptUtils().encrypt(bArr);
            hashMap.remove("Content-Encoding");
            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        }
        try {
            String post = this.appLogInstance.getNetClient().post(this.appLogInstance.getApiParamsUtil().encryptSendLogUri(this.appLogInstance.getContext(), str), bArr, hashMap);
            if (Utils.isNotEmpty(post)) {
                priorityHttpResponse = new PriorityHttpResponse(200, "", post);
            } else {
                priorityHttpResponse = new PriorityHttpResponse(0, "response empty", null);
            }
        } catch (Throwable th2) {
            if (th2 instanceof RangersHttpException) {
                RangersHttpException rangersHttpException = th2;
                int responseCode = rangersHttpException.getResponseCode();
                String message = rangersHttpException.getMessage();
                this.appLogInstance.getLogger().error(loggerTags, "****** send resultCode: " + responseCode, th2, new Object[0]);
                priorityHttpResponse = new PriorityHttpResponse(responseCode, message, null);
            } else {
                priorityHttpResponse = new PriorityHttpResponse(0, th2.toString(), null);
            }
            this.appLogInstance.getMonitorHelper().sendError("send priority log error, url: " + str, new Throwable(priorityHttpResponse.toString()));
        }
        this.appLogInstance.getLogger().debug(loggerTags, "****** priority request cost {}ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return priorityHttpResponse;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableFast(this.appLogInstance.getContext());
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void printLog(int i, String str) {
        if (this.appLogInstance.isLogEnabled()) {
            if (i == 2) {
                this.appLogInstance.getLogger().info(loggerTags, str, new Object[0]);
                return;
            }
            if (i == 3) {
                this.appLogInstance.getLogger().warn(loggerTags, str, new Object[0]);
            } else if (i == 4) {
                this.appLogInstance.getLogger().error(loggerTags, str, new Object[0]);
            } else {
                this.appLogInstance.getLogger().debug(loggerTags, str, new Object[0]);
            }
        }
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorIncreaseStats(String str, int i) {
        this.appLogInstance.getMonitorHelper().increaseStats(str, i);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isMonitorEnabled() {
        return this.appLogInstance.getMonitorHelper().isEnabled();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorStage(String str, String str2, int i, int i2, String str3, String str4, long j) {
        if (isStageEnabled()) {
            MonitorUtils.stageEvent(this.appLogInstance.getMonitorHelper(), EventStage.fromLabel(str), new StageEventBasic(str2, i, str3, str4, j, StageEventType.fromLabel(i2)));
        }
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isStageEnabled() {
        return this.appLogInstance.getMonitorHelper().isStageEnabled();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorError(String str, String str2) {
        if (isMonitorEnabled()) {
            this.appLogInstance.getMonitorHelper().sendError(str, new Throwable(str2));
        }
    }
}
