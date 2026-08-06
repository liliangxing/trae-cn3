package com.bytedance.ies.argus.api.interfaces;

import com.bytedance.ies.argus.api.params.ArgusResourceLoaderInfo;
import kotlin.Metadata;

/* compiled from: ArgusInitDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/ILifeCycleDepend;", "", "onLynxSignFailed", "", "argusResourceInfo", "Lcom/bytedance/ies/argus/api/params/ArgusResourceLoaderInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public interface ILifeCycleDepend {
    void onLynxSignFailed(ArgusResourceLoaderInfo argusResourceInfo);
}
