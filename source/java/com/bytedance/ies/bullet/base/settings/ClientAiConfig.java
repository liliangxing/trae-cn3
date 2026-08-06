package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClientAiConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/ClientAiConfig;", "", "()V", "enableBlankDetectConfig", "", "", "getEnableBlankDetectConfig", "()Ljava/util/Map;", "setEnableBlankDetectConfig", "(Ljava/util/Map;)V", "workerJsFileMd5CheckList", "", "getWorkerJsFileMd5CheckList", "()Ljava/util/List;", "setWorkerJsFileMd5CheckList", "(Ljava/util/List;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class ClientAiConfig {

    @SerializedName("worker_js_file_md5_check_list")
    private List<String> workerJsFileMd5CheckList = CollectionsKt.listOf("84c1a41d47b9a3b566656c5d0fd24703");

    @SerializedName("enable_blank_detect_config")
    private Map<String, String> enableBlankDetectConfig = new LinkedHashMap();

    public final List<String> getWorkerJsFileMd5CheckList() {
        return this.workerJsFileMd5CheckList;
    }

    public final void setWorkerJsFileMd5CheckList(List<String> list) {
        this.workerJsFileMd5CheckList = list;
    }

    public final Map<String, String> getEnableBlankDetectConfig() {
        return this.enableBlankDetectConfig;
    }

    public final void setEnableBlankDetectConfig(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.enableBlankDetectConfig = map;
    }
}
