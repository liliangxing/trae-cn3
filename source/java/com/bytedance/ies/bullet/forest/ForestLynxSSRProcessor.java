package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.bytedance.forest.postprocessor.ProcessableData;
import com.bytedance.forest.postprocessor.ProcessedData;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: lynx_ssr_processor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0007H\u0002R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestLynxSSRProcessor;", "Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "Lcom/bytedance/ies/bullet/forest/LynxSSRData;", "sessionId", "", "bid", "preDecode", "", "preloadSubResources", "allowOnMainThread", "(Ljava/lang/String;Ljava/lang/String;ZZZ)V", "onProcess", "Lcom/bytedance/forest/postprocessor/ProcessedData;", "data", "Lcom/bytedance/forest/postprocessor/ProcessableData;", "performHydrateTemplateRequest", "", "hydrateUrl", "isPreload", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestLynxSSRProcessor extends ForestPostProcessor<LynxSSRData> {
    private static final String HYDRATE_URL_KEY = "x-hydrate-url";
    public static final int SSR_BODY_TYPE_INIT_DATA = 2;
    public static final int SSR_BODY_TYPE_SSR_RESULT = 1;
    private static final int SSR_MAGIC_NUMBER_SIZE = 4;
    public static final int SSR_STATUS_SUCCESS = 0;
    private final String bid;
    private final boolean preDecode;
    private final boolean preloadSubResources;
    private final String sessionId;

    public /* synthetic */ ForestLynxSSRProcessor(String str, String str2, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? true : z3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForestLynxSSRProcessor(String str, String str2, boolean z, boolean z2, boolean z3) {
        super(z3);
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "bid");
        this.sessionId = str;
        this.bid = str2;
        this.preDecode = z;
        this.preloadSubResources = z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if (r0 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ProcessedData<LynxSSRData> onProcess(ProcessableData data) {
        String str;
        int readInt;
        Intrinsics.checkNotNullParameter(data, "data");
        ResourceFrom resFrom = data.getResFrom();
        boolean z = true;
        int i = 0;
        if (resFrom != null) {
            if (!(resFrom != ResourceFrom.MEMORY)) {
                resFrom = null;
            }
        }
        resFrom = data.getOriginFrom();
        if (resFrom == null) {
            resFrom = ResourceFrom.CDN;
        }
        if (resFrom == ResourceFrom.GECKO || resFrom == ResourceFrom.BUILTIN) {
            throw new IllegalStateException("a " + resFrom + " resource is a CSR template, no need to parse SSR chunks!");
        }
        Map httpHeader = data.getHttpHeader();
        if (httpHeader == null || (str = (String) httpHeader.get(HYDRATE_URL_KEY)) == null || !StringsKt.startsWith$default(str, "http", false, 2, (Object) null)) {
            str = null;
        }
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (z) {
            HybridLogger hybridLogger = HybridLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("read SSR hydrate url failed, except a http url but received ");
            Map httpHeader2 = data.getHttpHeader();
            HybridLogger.w$default(hybridLogger, "LynxSSR", sb.append(httpHeader2 != null ? (String) httpHeader2.get(HYDRATE_URL_KEY) : null).toString(), null, null, 12, null);
        } else {
            performHydrateTemplateRequest(str, data.isPreload());
        }
        if (str == null) {
            str = "";
        }
        InputStream dataStream = data.getDataStream();
        for (int i2 = 0; i2 < 4; i2++) {
            dataStream.read();
        }
        int read = dataStream.read();
        if (read != 0) {
            throw new IllegalStateException("SSR failed, status:" + read + '!');
        }
        int read2 = dataStream.read();
        if (read2 <= 0) {
            throw new IOException("read SSR response failed, chunk count " + read2 + " less than ZERO!");
        }
        ArrayList arrayList = new ArrayList(read2);
        for (int i3 = 0; i3 < read2; i3++) {
            int read3 = dataStream.read();
            readInt = Lynx_ssr_processorKt.readInt(dataStream);
            if (readInt <= 0) {
                throw new IOException("read SSR response failed, length of chunk " + i3 + " is " + readInt + '!');
            }
            byte[] bArr = new byte[readInt];
            int i4 = 0;
            while (i4 < readInt) {
                int read4 = dataStream.read(bArr, i4, readInt - i4);
                if (read4 == -1) {
                    break;
                }
                i4 += read4;
            }
            if (i4 < readInt) {
                throw new IOException("read SSR response failed, except length of chunk " + i3 + " is " + readInt + " but received " + i4);
            }
            arrayList.add(new ReactLynxSSRChunk(read3, bArr));
        }
        if (arrayList.size() != read2) {
            throw new IOException("read SSR response failed, except count of chunks is " + read2 + " but received " + arrayList.size());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            i += ((ReactLynxSSRChunk) it.next()).getBody().length;
        }
        return new ProcessedData<>(i + str.length(), new LynxSSRData(arrayList, str));
    }

    private final void performHydrateTemplateRequest(String hydrateUrl, boolean isPreload) {
        TaskConfig taskConfig = new TaskConfig(null, 1, null);
        taskConfig.setBid(this.bid);
        taskConfig.setCdnUrl(hydrateUrl);
        taskConfig.setLoadToMemory(true);
        taskConfig.setCustomMaxAge(5);
        boolean z = isPreload && this.preloadSubResources;
        if (!this.preDecode) {
            r1.preload((r24 & 1) != 0 ? ForestLoader.INSTANCE.getDefault() : null, hydrateUrl, z, this.sessionId, PreloadType.LYNX, true, "ssr_processor", (r24 & 128) != 0 ? null : taskConfig, (r24 & 256) != 0 ? false : true, (r24 & 512) != 0 ? null : null);
        } else {
            r2.preloadWithProcessor((r26 & 1) != 0 ? ForestLoader.INSTANCE.getDefault() : null, hydrateUrl, z, this.sessionId, PreloadType.LYNX, true, "ssr_processor", (r26 & 128) != 0 ? null : taskConfig, (r26 & 256) != 0 ? false : true, new TemplateBundleProcessor(hydrateUrl, false, 2, null), (r26 & 1024) != 0 ? null : null);
        }
    }
}
