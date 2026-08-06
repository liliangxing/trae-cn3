package com.bytedance.timon.clipboard.suite.storage;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timon.foundation.TimonFoundation;
import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ClipboardSuiteStorageHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/storage/ClipboardSuiteStorageHelper;", "", "()V", "REPO_NAME", "", "TAG", "repo", "Lcom/bytedance/timon/foundation/interfaces/IStoreRepo;", "getRepo", "()Lcom/bytedance/timon/foundation/interfaces/IStoreRepo;", "repo$delegate", "Lkotlin/Lazy;", "getLastWriteTimestamp", "", "token", "(Ljava/lang/String;)Ljava/lang/Long;", "writeLastWriteTimestamp", "", ReportConstant.COMMON_TIMESTAMP, "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ClipboardSuiteStorageHelper {
    private static final String REPO_NAME = "timon_clipboard_suite_repo";
    private static final String TAG = "ClipboardSuite";
    public static final ClipboardSuiteStorageHelper INSTANCE = new ClipboardSuiteStorageHelper();

    /* renamed from: repo$delegate, reason: from kotlin metadata */
    private static final Lazy repo = LazyKt.lazy(new Function0<IStoreRepo>() { // from class: com.bytedance.timon.clipboard.suite.storage.ClipboardSuiteStorageHelper$repo$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IStoreRepo m1040invoke() {
            return TimonFoundation.INSTANCE.getKvStore().getRepo(TMEnv.INSTANCE.getApplication(), "timon_clipboard_suite_repo", 0);
        }
    });

    private final IStoreRepo getRepo() {
        return (IStoreRepo) repo.getValue();
    }

    private ClipboardSuiteStorageHelper() {
    }

    public final Long getLastWriteTimestamp(String token) {
        if (token == null) {
            TMLogger.INSTANCE.m219d("ClipboardSuite", "getLastWriteTimestamp token is null ");
            return null;
        }
        long j = -1;
        long j2 = getRepo().getLong(token, j);
        if (j2 != j) {
            return Long.valueOf(j2);
        }
        TMLogger.INSTANCE.m219d("ClipboardSuite", "getLastReadTimestamp timestamp is null ");
        return null;
    }

    public final void writeLastWriteTimestamp(String token, long timestamp) {
        if (token == null) {
            TMLogger.INSTANCE.m219d("ClipboardSuite", "writeReadTimestamp token is null ");
        } else {
            getRepo().putLong(token, timestamp);
        }
    }
}
