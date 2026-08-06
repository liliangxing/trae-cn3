package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.bytedance.forest.postprocessor.ProcessableData;
import com.bytedance.forest.postprocessor.ProcessedData;
import com.bytedance.forest.utils.LogUtils;
import com.lynx.tasm.TemplateBundle;
import java.io.InputStream;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TemplateBundleProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/forest/TemplateBundleProcessor;", "Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "Lcom/lynx/tasm/TemplateBundle;", "codeCacheSourceUrl", "", "allowOnMainThread", "", "(Ljava/lang/String;Z)V", "onProcess", "Lcom/bytedance/forest/postprocessor/ProcessedData;", "data", "Lcom/bytedance/forest/postprocessor/ProcessableData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TemplateBundleProcessor extends ForestPostProcessor<TemplateBundle> {
    private final String codeCacheSourceUrl;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TemplateBundleProcessor() {
        this(r2, false, 3, r2);
        String str = null;
    }

    public TemplateBundleProcessor(String str, boolean z) {
        super(z);
        this.codeCacheSourceUrl = str;
    }

    public /* synthetic */ TemplateBundleProcessor(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? true : z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        com.bytedance.forest.utils.LogUtils.i$default(com.bytedance.forest.utils.LogUtils.INSTANCE, "TemplateBundleProcessor", "====preCodeCache======", false, (kotlin.jvm.functions.Function3) null, (java.lang.String) null, (java.util.Map) null, 60, (java.lang.Object) null);
        r0.postJsCacheGenerationTask(r18.getOriginUrl(), false);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067 A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:7:0x001b, B:9:0x005b, B:14:0x0067, B:15:0x00a8, B:20:0x007e, B:22:0x0086, B:27:0x0090), top: B:6:0x001b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007e A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:7:0x001b, B:9:0x005b, B:14:0x0067, B:15:0x00a8, B:20:0x007e, B:22:0x0086, B:27:0x0090), top: B:6:0x001b, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ProcessedData<TemplateBundle> onProcess(ProcessableData data) {
        boolean z;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.isPreload()) {
            InputStream dataStream = data.getDataStream();
            try {
                InputStream inputStream = dataStream;
                try {
                    LogUtils.i$default(LogUtils.INSTANCE, "TemplateBundleProcessor", "TemplateBundleProcessor onProcess", false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
                    byte[] readBytes = ByteStreamsKt.readBytes(inputStream);
                    int length = (readBytes.length * 3) / 2;
                    LogUtils.i$default(LogUtils.INSTANCE, "TemplateBundleProcessor", "size: " + length, false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
                    TemplateBundle fromTemplate = TemplateBundle.fromTemplate(readBytes);
                    String str = this.codeCacheSourceUrl;
                    boolean z2 = true;
                    if (str != null && str.length() != 0) {
                        z = false;
                        if (z) {
                            LogUtils.i$default(LogUtils.INSTANCE, "TemplateBundleProcessor", "====preCodeCache======", false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
                            fromTemplate.postJsCacheGenerationTask(this.codeCacheSourceUrl, false);
                        } else {
                            String originUrl = data.getOriginUrl();
                            if (originUrl != null && originUrl.length() != 0) {
                                z2 = false;
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(fromTemplate, "fromTemplate(templateArr…  }\n                    }");
                        ProcessedData<TemplateBundle> processedData = new ProcessedData<>(length, fromTemplate);
                        CloseableKt.closeFinally(dataStream, (Throwable) null);
                        return processedData;
                    }
                    z = true;
                    if (z) {
                    }
                    Unit unit2 = Unit.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(fromTemplate, "fromTemplate(templateArr…  }\n                    }");
                    ProcessedData<TemplateBundle> processedData2 = new ProcessedData<>(length, fromTemplate);
                    CloseableKt.closeFinally(dataStream, (Throwable) null);
                    return processedData2;
                } finally {
                }
            } finally {
            }
        } else {
            LogUtils.i$default(LogUtils.INSTANCE, "TemplateBundleProcessor", "Only preload request can be processed", false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
            throw new Throwable("Only preload request can be processed");
        }
    }
}
