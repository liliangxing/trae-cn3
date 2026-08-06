package com.bytedance.apm.alog;

import android.content.Context;
import java.util.List;

/* loaded from: classes3.dex */
public interface IAlogUploadStrategy {
    List<String> getUploadAlogFiles(Context context, String str, long j, long j2);
}
