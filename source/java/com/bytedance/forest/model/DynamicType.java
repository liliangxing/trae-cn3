package com.bytedance.forest.model;

import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: constants.kt */
@Deprecated(message = "use waitGeckoUpdate instead")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/forest/model/DynamicType;", "", "()V", "CHECK_UPDATE", "", "CHECK_UPDATE_ASYNC", "FORCE_UPDATE", "NO_UPDATE", "asWaitGeckoUpdate", "", URIQueryParamKeys.DYNAMIC, "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class DynamicType {
    public static final int CHECK_UPDATE = 1;
    public static final int CHECK_UPDATE_ASYNC = 3;
    public static final int FORCE_UPDATE = 2;
    public static final DynamicType INSTANCE = new DynamicType();
    public static final int NO_UPDATE = 0;

    public final boolean asWaitGeckoUpdate(int dynamic) {
        return dynamic == 1 || dynamic == 2;
    }

    private DynamicType() {
    }
}
