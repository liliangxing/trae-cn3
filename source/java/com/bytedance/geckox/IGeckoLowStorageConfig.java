package com.bytedance.geckox;

import com.bytedance.geckox.model.Resources;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: IGeckoLowStorageConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007H&¨\u0006\f"}, d2 = {"Lcom/bytedance/geckox/IGeckoLowStorageConfig;", "", "extremeLowStorageEnable", "", "getLowStorageAvailable", "", "getLowStorageWhiteList", "", "", "Lcom/bytedance/geckox/model/Resources;", "getSensitiveStorageAvailable", "getSensitiveStorageBlockList", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public interface IGeckoLowStorageConfig {
    @Deprecated(message = "always true")
    boolean extremeLowStorageEnable();

    int getLowStorageAvailable();

    Map<String, Resources> getLowStorageWhiteList();

    int getSensitiveStorageAvailable();

    Map<String, Resources> getSensitiveStorageBlockList();
}
