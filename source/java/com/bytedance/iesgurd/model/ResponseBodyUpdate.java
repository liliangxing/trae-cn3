package com.bytedance.iesgurd.model;

import com.bytedance.iesgurd.meta.PrepareMeta;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ResponseBodyUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/iesgurd/model/ResponseBodyUpdate;", "", "()V", "data", "Lcom/bytedance/iesgurd/model/ResponseBodyUpdate$ResponseBodyData;", "getData", "()Lcom/bytedance/iesgurd/model/ResponseBodyUpdate$ResponseBodyData;", "status", "", "getStatus", "()I", "ResponseBodyData", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ResponseBodyUpdate {

    @SerializedName("data")
    private final ResponseBodyData data;

    @SerializedName("status")
    private final int status;

    public final int getStatus() {
        return this.status;
    }

    public final ResponseBodyData getData() {
        return this.data;
    }

    /* compiled from: ResponseBodyUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R0\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/iesgurd/model/ResponseBodyUpdate$ResponseBodyData;", "", "()V", "cleanTasks", "", "", "Lcom/bytedance/iesgurd/model/CleanTask;", "getCleanTasks", "()Ljava/util/Map;", "resources", "", "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "getResources", "()Ljava/util/List;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class ResponseBodyData {

        @SerializedName("clean_tasks")
        private final Map<String, Map<String, CleanTask>> cleanTasks;

        @SerializedName("resources")
        private final List<PrepareMeta> resources;

        public final List<PrepareMeta> getResources() {
            return this.resources;
        }

        public final Map<String, Map<String, CleanTask>> getCleanTasks() {
            return this.cleanTasks;
        }
    }
}
