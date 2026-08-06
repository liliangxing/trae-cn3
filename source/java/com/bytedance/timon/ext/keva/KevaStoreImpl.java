package com.bytedance.timon.ext.keva;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.bytedance.timon.foundation.interfaces.IStore;
import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KevaStoreImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/timon/ext/keva/KevaStoreImpl;", "Lcom/bytedance/timon/foundation/interfaces/IStore;", "()V", "storeRepoMap", "", "", "Lcom/bytedance/timon/foundation/interfaces/IStoreRepo;", "getRepo", "context", "Landroid/content/Context;", "repoName", "mode", "", "getUniqueRepoKey", "ext-keva_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class KevaStoreImpl implements IStore {
    private final Map<String, IStoreRepo> storeRepoMap = new LinkedHashMap();

    @Override // com.bytedance.timon.foundation.interfaces.IStore
    public IStoreRepo getRepo(Context context, String repoName, int mode) {
        Intrinsics.checkParameterIsNotNull(repoName, "repoName");
        String uniqueRepoKey = getUniqueRepoKey(repoName, mode);
        IStoreRepo iStoreRepo = this.storeRepoMap.get(uniqueRepoKey);
        if (iStoreRepo != null) {
            return iStoreRepo;
        }
        Keva repo = Keva.getRepo(repoName, mode);
        Intrinsics.checkExpressionValueIsNotNull(repo, "keva");
        KevaStoreRepoImpl kevaStoreRepoImpl = new KevaStoreRepoImpl(repo);
        this.storeRepoMap.put(uniqueRepoKey, kevaStoreRepoImpl);
        return kevaStoreRepoImpl;
    }

    private final String getUniqueRepoKey(String repoName, int mode) {
        return repoName + '_' + mode;
    }
}
