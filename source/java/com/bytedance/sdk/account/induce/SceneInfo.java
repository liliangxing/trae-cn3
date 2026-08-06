package com.bytedance.sdk.account.induce;

/* loaded from: classes5.dex */
public class SceneInfo {
    final long percent;
    final long progress;
    final String scene;

    public static SceneInfo createProgress(String str, long j) {
        return new SceneInfo(str, j, -1L);
    }

    public static SceneInfo createPercent(String str, long j) {
        return new SceneInfo(str, 1L, j);
    }

    private SceneInfo(String str, long j, long j2) {
        this.scene = str;
        this.progress = j;
        this.percent = j2;
    }
}
