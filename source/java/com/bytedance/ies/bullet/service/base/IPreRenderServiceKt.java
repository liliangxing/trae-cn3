package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* compiled from: IPreRenderService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"provideSuffix", "", "Lcom/bytedance/ies/bullet/service/base/CacheType;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class IPreRenderServiceKt {

    /* compiled from: IPreRenderService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CacheType.values().length];
            try {
                iArr[CacheType.REUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CacheType.PRE_RENDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String provideSuffix(CacheType cacheType) {
        if (cacheType == null) {
            return "";
        }
        int i = WhenMappings.$EnumSwitchMapping$0[cacheType.ordinal()];
        return i != 1 ? i != 2 ? "" : "(PreRender)" : "(ReUse)";
    }
}
