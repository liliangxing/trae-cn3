package com.bytedance.geckox.listener;

import android.util.Pair;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes3.dex */
public abstract class GeckoUpdateListener {
    @Deprecated
    public void onActivateFail(UpdatePackage updatePackage, Throwable th) {
    }

    @Deprecated
    public void onActivateSuccess(UpdatePackage updatePackage) {
    }

    public void onChannelAccess(GeckoParams geckoParams) {
    }

    @Deprecated
    public void onCheckRequestIntercept(int i, Map<String, List<Pair<String, Long>>> map, Throwable th) {
    }

    public void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> map, Throwable th) {
    }

    @Deprecated
    public void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> map, Map<String, List<UpdatePackage>> map2) {
    }

    @Deprecated
    public void onClean(String str) {
    }

    public void onCleanRes(GeckoParams geckoParams) {
    }

    public void onDownloadFail(UpdatePackage updatePackage, Throwable th) {
    }

    public void onDownloadProgress(UpdatePackage updatePackage, long j, long j2) {
    }

    public void onDownloadSuccess(UpdatePackage updatePackage) {
    }

    @Deprecated
    public void onLocalNewestVersion(LocalPackageModel localPackageModel) {
    }

    public void onUpdateFailed(UpdatePackage updatePackage, Throwable th) {
    }

    @Deprecated
    public void onUpdateFailed(String str, Throwable th) {
    }

    @Deprecated
    public void onUpdateFinish() {
    }

    public void onUpdateStart(UpdatePackage updatePackage) {
    }

    public void onUpdateSuccess(UpdatePackage updatePackage, long j) {
    }

    @Deprecated
    public void onUpdateSuccess(String str, long j) {
    }

    @Deprecated
    public void onUpdating(String str) {
    }

    /* loaded from: classes3.dex */
    public static class GeckoParams {
        public String accessKey;
        public String channel;
        public long version;

        public GeckoParams(String str, String str2, long j) {
            this.accessKey = str;
            this.channel = str2;
            this.version = j;
        }
    }
}
