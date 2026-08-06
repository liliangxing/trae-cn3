package com.bytedance.applog.isolate;

import java.util.Map;

/* loaded from: classes3.dex */
public interface IDataIsolateCallback {
    boolean afterIsolate();

    boolean allowIsolateDataReport(DataIsolateKey dataIsolateKey, String str);

    boolean beforeIsolate();

    Map<String, String> generateIsolateHttpHeader();
}
