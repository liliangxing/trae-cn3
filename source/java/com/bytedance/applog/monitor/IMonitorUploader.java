package com.bytedance.applog.monitor;

import java.util.List;

/* loaded from: classes3.dex */
public interface IMonitorUploader {
    boolean onUpload(List<ReportData> list);
}
