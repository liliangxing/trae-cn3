package com.bytedance.forest.model;

import com.bytedance.forest.pollyfill.CDNFetchDepender;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.OfflineUtil;
import com.bytedance.forest.utils.RepoUtils;
import com.bytedance.geckox.utils.MD5Utils;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResponseCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class HttpResponseCache$updateFromOnline$1 implements Runnable {
    final /* synthetic */ Ref.ObjectRef $cacheKey;
    final /* synthetic */ String $expiredCacheKey;
    final /* synthetic */ ForestLogger $logger;
    final /* synthetic */ Map $modifiedHeaders;
    final /* synthetic */ Response $response;
    final /* synthetic */ HttpResponseCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpResponseCache$updateFromOnline$1(HttpResponseCache httpResponseCache, Ref.ObjectRef objectRef, ForestLogger forestLogger, Response response, Map map, String str) {
        this.this$0 = httpResponseCache;
        this.$cacheKey = objectRef;
        this.$logger = forestLogger;
        this.$response = response;
        this.$modifiedHeaders = map;
        this.$expiredCacheKey = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File file;
        if (this.this$0.isStale()) {
            return;
        }
        final File file2 = new File(CDNFetchDepender.INSTANCE.getDirectory(), (String) this.$cacheKey.element);
        if (!file2.exists()) {
            file = this.this$0.file;
            if (file != null) {
                try {
                    file.renameTo(file2);
                    this.$response.setFilePath(file2.getAbsolutePath());
                    final String fromMapToString = OfflineUtil.INSTANCE.fromMapToString(this.$modifiedHeaders);
                    RepoUtils.INSTANCE.storeStringJustDisk((String) this.$cacheKey.element, fromMapToString);
                    ForestLogger.printOptimize$default(this.$logger, 4, "ResponseCache", false, null, null, new Function0<String>() { // from class: com.bytedance.forest.model.HttpResponseCache$updateFromOnline$1$$special$$inlined$let$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "json recorded: " + fromMapToString + " for key:" + ((String) this.$cacheKey.element);
                        }
                    }, 28, null);
                    this.this$0.file = file2;
                    RepoUtils.INSTANCE.delete(this.$expiredCacheKey);
                    final String stringToMd5 = MD5Utils.stringToMd5(fromMapToString);
                    ForestLogger.printOptimize$default(this.$logger, 4, "ResponseCache", true, null, null, new Function0<String>() { // from class: com.bytedance.forest.model.HttpResponseCache$updateFromOnline$1$$special$$inlined$let$lambda$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "json recorded: " + stringToMd5 + " for key:" + ((String) this.$cacheKey.element);
                        }
                    }, 24, null);
                    return;
                } catch (Throwable th) {
                    ForestLogger.print$default(this.$logger, 6, "ResponseCache", "rename failed", true, th, null, 32, null);
                    return;
                }
            }
            return;
        }
        ForestLogger.print$default(this.$logger, 6, "ResponseCache", "update but new file already existed", true, null, null, 48, null);
    }
}
