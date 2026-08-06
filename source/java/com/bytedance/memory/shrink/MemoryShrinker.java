package com.bytedance.memory.shrink;

import com.bytedance.memory.api.MemoryApi;
import com.bytedance.memory.common.MemoryLog;
import com.bytedance.memory.common.ZipUtil;
import com.bytedance.memory.dump.DumpFileProvider;
import com.bytedance.memory.event.EventUtils;
import com.bytedance.memory.heap.HeapSaver;
import com.bytedance.memory.model.MemoryWidgetConfig;
import com.bytedance.memory.upload.MemoryNetApi;
import com.bytedance.services.apm.api.EnsureManager;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MemoryShrinker {
    public static File shrink(File file, File file2) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            EventUtils.uploadCategoryEvent(EventUtils.SHRINK_BEGIN);
            MemoryWidgetConfig.ShrinkConfig shrinkConfig = MemoryApi.getInstance().getInitConfig().getShrinkConfig();
            File file3 = new File(DumpFileProvider.getInstance().getShrinkFolder(), HeapSaver.SHRINK_TYPE_MINI);
            if (shrinkConfig != null && !EventUtils.getDumpEventNoDebug(EventUtils.CLOSE_NATIVE_SHRINK)) {
                if (shrinkConfig.shrinkHprof(file, file3)) {
                    EventUtils.uploadCategoryEvent("native_shrink");
                    HeapSaver.getInstance().setHprofType(3);
                } else {
                    EventUtils.uploadCategoryEvent("java_shrink");
                    new HprofBufferShrinker().shrink(file, file2);
                    ZipUtil.deflater(file2, file3, true);
                    HeapSaver.getInstance().setHprofType(5);
                }
            } else {
                EventUtils.uploadCategoryEvent("deepShrink");
                boolean z = MemoryApi.getInstance().getInitConfig().isDeepShrink() && EventUtils.getMemoryEvent(MemoryNetApi.HPROF_SHRINK_DEEP);
                if (z) {
                    EventUtils.uploadCategoryEvent(EventUtils.SHRINK_DEEP_BEGIN);
                }
                new HprofBufferShrinker().shrink(file, file2, z);
                ZipUtil.deflater(file2, file3, true);
                HeapSaver.getInstance().setHprofType(5);
                if (z) {
                    EventUtils.uploadCategoryEvent(EventUtils.SHRINK_DEEP_END);
                }
            }
            EventUtils.uploadCategoryEvent(EventUtils.SHRINK_END);
            EventUtils.uploadMetricEvent(EventUtils.SHRINK_TIME, System.currentTimeMillis() - currentTimeMillis);
            EventUtils.uploadMetricEvent(EventUtils.ORIGIN_SIZE, file.length() / 1024);
            EventUtils.uploadMetricEvent(EventUtils.SHRINK_SIZE, file3.length() / 1024);
            MemoryLog.m101i("shrink hprof file %s, size: %dk to %s, size: %dk, use time:%d", file.getPath(), Long.valueOf(file.length() / 1024), file3.getPath(), Long.valueOf(file3.length() / 1024), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (!file3.exists()) {
                return null;
            }
            if (file3.length() > 0) {
                return file3;
            }
            return null;
        } catch (Exception e) {
            EnsureManager.ensureNotReachHere(e, "shrink failed");
            EventUtils.uploadCategoryEvent("shrink_error_exception");
            e.printStackTrace();
            return null;
        }
    }
}
