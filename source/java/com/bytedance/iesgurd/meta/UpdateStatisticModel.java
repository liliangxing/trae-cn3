package com.bytedance.iesgurd.meta;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UpdateStatisticModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020&J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020.R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00063"}, d2 = {"Lcom/bytedance/iesgurd/meta/UpdateStatisticModel;", "", "()V", "durationActive", "", "getDurationActive", "()J", "setDurationActive", "(J)V", "durationBytepatch", "getDurationBytepatch", "setDurationBytepatch", "durationDecompressZstd", "getDurationDecompressZstd", "setDurationDecompressZstd", "durationDownload", "getDurationDownload", "setDurationDownload", "durationDownloadLastTime", "getDurationDownloadLastTime", "setDurationDownloadLastTime", "durationLastStage", "getDurationLastStage", "setDurationLastStage", "durationTotal", "getDurationTotal", "setDurationTotal", "durationUnzip", "getDurationUnzip", "setDurationUnzip", "durationZipPatch", "getDurationZipPatch", "setDurationZipPatch", "stageDataMap", "", "", "Lcom/bytedance/iesgurd/meta/UpdateStatisticModel$StageData;", "updateResult", "", "getUpdateResult", "()Z", "setUpdateResult", "(Z)V", "getStageData", "withPatch", "putDataToJson", "", "jsonObject", "Lorg/json/JSONObject;", "resetDuration", "StageData", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class UpdateStatisticModel {
    private long durationActive;
    private long durationBytepatch;
    private long durationDecompressZstd;
    private long durationDownload;
    private long durationDownloadLastTime;
    private long durationLastStage;
    private long durationTotal;
    private long durationUnzip;
    private long durationZipPatch;
    private final Map<String, StageData> stageDataMap = new HashMap();
    private boolean updateResult;

    public final boolean getUpdateResult() {
        return this.updateResult;
    }

    public final void setUpdateResult(boolean z) {
        this.updateResult = z;
    }

    public final long getDurationTotal() {
        return this.durationTotal;
    }

    public final void setDurationTotal(long j) {
        this.durationTotal = j;
    }

    public final long getDurationLastStage() {
        return this.durationLastStage;
    }

    public final void setDurationLastStage(long j) {
        this.durationLastStage = j;
    }

    public final long getDurationDownload() {
        return this.durationDownload;
    }

    public final void setDurationDownload(long j) {
        this.durationDownload = j;
    }

    public final long getDurationDownloadLastTime() {
        return this.durationDownloadLastTime;
    }

    public final void setDurationDownloadLastTime(long j) {
        this.durationDownloadLastTime = j;
    }

    public final long getDurationActive() {
        return this.durationActive;
    }

    public final void setDurationActive(long j) {
        this.durationActive = j;
    }

    public final long getDurationUnzip() {
        return this.durationUnzip;
    }

    public final void setDurationUnzip(long j) {
        this.durationUnzip = j;
    }

    public final long getDurationDecompressZstd() {
        return this.durationDecompressZstd;
    }

    public final void setDurationDecompressZstd(long j) {
        this.durationDecompressZstd = j;
    }

    public final long getDurationBytepatch() {
        return this.durationBytepatch;
    }

    public final void setDurationBytepatch(long j) {
        this.durationBytepatch = j;
    }

    public final long getDurationZipPatch() {
        return this.durationZipPatch;
    }

    public final void setDurationZipPatch(long j) {
        this.durationZipPatch = j;
    }

    public final StageData getStageData(boolean withPatch) {
        String str = withPatch ? "patch_" : "full_";
        StageData stageData = this.stageDataMap.get(str);
        if (stageData != null) {
            return stageData;
        }
        StageData stageData2 = new StageData(str);
        this.stageDataMap.put(str, stageData2);
        return stageData2;
    }

    public final void resetDuration() {
        this.durationDownload = 0L;
        this.durationActive = 0L;
        this.durationUnzip = 0L;
        this.durationDecompressZstd = 0L;
        this.durationBytepatch = 0L;
        this.durationZipPatch = 0L;
    }

    public final void putDataToJson(JSONObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "jsonObject");
        jsonObject.put("update_result", !this.updateResult ? 1 : 0);
        long j = this.durationTotal;
        if (j > 0) {
            jsonObject.put("dur_total", j);
        }
        long j2 = this.durationLastStage;
        if (j2 > 0) {
            jsonObject.put("dur_last_stage", j2);
        }
        long j3 = this.durationDownload;
        if (j3 > 0) {
            jsonObject.put("dur_download", j3);
        }
        long j4 = this.durationDownloadLastTime;
        if (j4 > 0) {
            jsonObject.put("dur_download_last_time", j4);
        }
        long j5 = this.durationActive;
        if (j5 > 0) {
            jsonObject.put("dur_active", j5);
        }
        long j6 = this.durationUnzip;
        if (j6 > 0) {
            jsonObject.put("dur_unzip", j6);
        }
        long j7 = this.durationDecompressZstd;
        if (j7 > 0) {
            jsonObject.put("dur_decompress_zstd", j7);
        }
        long j8 = this.durationBytepatch;
        if (j8 > 0) {
            jsonObject.put("dur_bytepatch", j8);
        }
        long j9 = this.durationZipPatch;
        if (j9 > 0) {
            jsonObject.put("dur_zip_patch", j9);
        }
        Iterator<StageData> it = this.stageDataMap.values().iterator();
        while (it.hasNext()) {
            it.next().putDataToJson(jsonObject);
        }
    }

    /* compiled from: UpdateStatisticModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u0004¨\u0006%"}, d2 = {"Lcom/bytedance/iesgurd/meta/UpdateStatisticModel$StageData;", "", "prefix", "", "(Ljava/lang/String;)V", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "errMsg", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "failedTimes", "getFailedTimes", "setFailedTimes", "result", "", "getResult", "()Z", "setResult", "(Z)V", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "url", "getUrl", "setUrl", "putDataToJson", "", "jsonObject", "Lorg/json/JSONObject;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes4.dex */
    public static final class StageData {
        private int errCode;
        private String errMsg;
        private int failedTimes;
        private final String prefix;
        private boolean result;
        private long startTime;
        private String url;

        public StageData(String prefix) {
            Intrinsics.checkParameterIsNotNull(prefix, "prefix");
            this.prefix = prefix;
            this.startTime = System.currentTimeMillis();
        }

        public final boolean getResult() {
            return this.result;
        }

        public final void setResult(boolean z) {
            this.result = z;
        }

        public final int getErrCode() {
            return this.errCode;
        }

        public final void setErrCode(int i) {
            this.errCode = i;
        }

        public final String getErrMsg() {
            return this.errMsg;
        }

        public final void setErrMsg(String str) {
            this.errMsg = str;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public final int getFailedTimes() {
            return this.failedTimes;
        }

        public final void setFailedTimes(int i) {
            this.failedTimes = i;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final void setStartTime(long j) {
            this.startTime = j;
        }

        public final void putDataToJson(JSONObject jsonObject) {
            Intrinsics.checkParameterIsNotNull(jsonObject, "jsonObject");
            boolean z = true;
            jsonObject.put(this.prefix + "result", !this.result ? 1 : 0);
            jsonObject.put(this.prefix + "url", this.url);
            String str = this.errMsg;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (!z) {
                jsonObject.put(this.prefix + StrategyConstants.ERR_MSG, this.errMsg);
            }
            if (this.errCode != 0) {
                jsonObject.put(this.prefix + "err_code", this.errCode);
            }
            if (this.failedTimes > 0) {
                jsonObject.put(this.prefix + "download_failed_times", this.failedTimes);
            }
        }
    }
}
