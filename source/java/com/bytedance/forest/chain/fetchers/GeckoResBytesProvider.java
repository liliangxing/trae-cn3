package com.bytedance.forest.chain.fetchers;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.BytesProvider;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.LogReportNode;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.OfflineUtil;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import com.bytedance.iesgurd.IESGurdResData;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GeckoFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/GeckoResBytesProvider;", "Lcom/bytedance/forest/model/BytesProvider;", "geckoData", "Lcom/bytedance/iesgurd/IESGurdResData;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "accessKey", "", "channel", "bundle", "(Lcom/bytedance/iesgurd/IESGurdResData;Lcom/bytedance/forest/model/Response;Lcom/bytedance/forest/utils/ForestPipelineContext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isMultiProvider", "", "provideInputStream", "Ljava/io/InputStream;", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class GeckoResBytesProvider implements BytesProvider {
    private final String accessKey;
    private final String bundle;
    private final String channel;
    private final ForestPipelineContext context;
    private final IESGurdResData geckoData;
    private final Response response;

    @Override // com.bytedance.forest.model.BytesProvider
    public boolean isMultiProvider() {
        return true;
    }

    public GeckoResBytesProvider(IESGurdResData iESGurdResData, Response response, ForestPipelineContext forestPipelineContext, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(iESGurdResData, "geckoData");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "context");
        Intrinsics.checkParameterIsNotNull(str, "accessKey");
        Intrinsics.checkParameterIsNotNull(str2, "channel");
        Intrinsics.checkParameterIsNotNull(str3, "bundle");
        this.geckoData = iESGurdResData;
        this.response = response;
        this.context = forestPipelineContext;
        this.accessKey = str;
        this.channel = str2;
        this.bundle = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[Catch: Exception -> 0x008c, TryCatch #0 {Exception -> 0x008c, blocks: (B:2:0x0000, B:4:0x0012, B:9:0x0019, B:11:0x0025, B:16:0x0031, B:20:0x0045, B:22:0x006e, B:24:0x007b, B:26:0x0084), top: B:1:0x0000 }] */
    @Override // com.bytedance.forest.model.BytesProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InputStream provideInputStream() {
        boolean z;
        InputStream data;
        boolean z2;
        try {
            z = OfflineUtil.INSTANCE.getGkfsCleaning$forest_release().get();
            data = this.geckoData.getData();
        } catch (Exception e) {
            this.context.getLogger().printOptimize(6, ForestBuffer.TAG, true, e, LogReportNode.GECKO_GET_INPUT_STREAM_ERROR, new Function0<String>() { // from class: com.bytedance.forest.chain.fetchers.GeckoResBytesProvider$provideInputStream$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final String invoke() {
                    IESGurdResData iESGurdResData;
                    Response response;
                    StringBuilder sb = new StringBuilder("error occurs when getting input stream from gecko, file: ");
                    iESGurdResData = GeckoResBytesProvider.this.geckoData;
                    StringBuilder append = sb.append(iESGurdResData.getPath()).append(", useGkFS:");
                    response = GeckoResBytesProvider.this.response;
                    return append.append(response.getUseGkFS()).append(", e:").append(e.getMessage()).toString();
                }
            });
        }
        if (data != null && (!(data instanceof GkFSFileInputStream) || !z)) {
            return data;
        }
        String path = this.geckoData.getPath();
        String str = path;
        if (str != null && str.length() != 0) {
            z2 = false;
            if (!z2) {
                File file = new File(path);
                if (GkFSUtils.INSTANCE.useGkFS(this.accessKey, this.channel) && !z) {
                    String convertBundlePath = GkFSUtils.INSTANCE.convertBundlePath(this.accessKey, this.channel, this.bundle);
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
                    File file2 = new File(StringsKt.replace$default(absolutePath, this.bundle, convertBundlePath, false, 4, (Object) null));
                    if (file2.exists()) {
                        this.response.setUseGkFS(true);
                        return new GkFSFileInputStream(file2);
                    }
                    return new FileInputStream(file);
                }
                return new FileInputStream(file);
            }
            return null;
        }
        z2 = true;
        if (!z2) {
        }
        return null;
    }
}
