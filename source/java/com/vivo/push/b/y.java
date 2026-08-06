package com.vivo.push.b;

import android.text.TextUtils;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.vcloud.strategy.StrategyCenter;
import java.util.HashMap;

/* compiled from: ReporterCommand.java */
/* loaded from: classes7.dex */
public final class y extends com.vivo.push.v {
    private HashMap<String, String> a;
    private long b;

    public y() {
        super(StrategyCenter.EVENT_PLAY_RELATED_PRELOAD_FINISHED);
    }

    public y(long j) {
        this();
        this.b = j;
    }

    public final void a(HashMap<String, String> hashMap) {
        this.a = hashMap;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        dVar.a("ReporterCommand.EXTRA_PARAMS", this.a);
        dVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        this.a = (HashMap) dVar.d("ReporterCommand.EXTRA_PARAMS");
        this.b = dVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "ReporterCommand（" + this.b + ")";
    }

    public final void e() {
        if (this.a == null) {
            com.vivo.push.util.t.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder append = new StringBuilder("report message reportType:").append(this.b).append(",msgId:");
        String str = this.a.get(com.heytap.mcssdk.constant.b.c);
        if (TextUtils.isEmpty(str)) {
            str = this.a.get(MultiProcessPushMessageDatabaseHelper.COL_MESSAGE_ID);
        }
        com.vivo.push.util.t.d("ReporterCommand", append.append(str).toString());
    }
}
