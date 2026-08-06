package com.bytedance.ies.bullet.core;

import kotlin.Metadata;

/* compiled from: BulletMonitorContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/core/LoadStage;", "", "stage", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStage", "()Ljava/lang/String;", "BEGIN", "START_LOAD", "DOWNLOAD_TEMPLATE", "END", "UPDATE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum LoadStage {
    BEGIN("begin"),
    START_LOAD("start_load"),
    DOWNLOAD_TEMPLATE("download_template"),
    END("end"),
    UPDATE("update");

    private final String stage;

    LoadStage(String str) {
        this.stage = str;
    }

    public final String getStage() {
        return this.stage;
    }
}
