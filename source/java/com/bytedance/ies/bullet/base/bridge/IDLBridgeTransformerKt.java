package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDLBridgeTransformer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\t\u001a\u0010\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u000b¨\u0006\f"}, d2 = {"bulletPermissionAdapt", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "privilege", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "getPlatformType", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "originPermissionAdapt", "Lcom/bytedance/ies/xbridge/XBridgeMethod$Access;", "xbridge2PermissionAdapt", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$Access;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IDLBridgeTransformerKt {

    /* compiled from: IDLBridgeTransformer.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[IBridgeMethod.Access.values().length];
            try {
                iArr[IBridgeMethod.Access.PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IBridgeMethod.Access.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IBridgeMethod.Access.PROTECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IBridgeMethod.Access.SECURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[XBridgeMethod.Access.values().length];
            try {
                iArr2[XBridgeMethod.Access.PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[XBridgeMethod.Access.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[XBridgeMethod.Access.PROTECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[XBridgeMethod.Access.SECURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[IDLXBridgeMethod.Access.values().length];
            try {
                iArr3[IDLXBridgeMethod.Access.PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[IDLXBridgeMethod.Access.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[IDLXBridgeMethod.Access.PROTECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[IDLXBridgeMethod.Access.SECURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final IDLXBridgeMethod.Access bulletPermissionAdapt(IBridgeMethod.Access access) {
        Intrinsics.checkNotNullParameter(access, "privilege");
        int i = WhenMappings.$EnumSwitchMapping$0[access.ordinal()];
        if (i == 1) {
            return IDLXBridgeMethod.Access.PUBLIC;
        }
        if (i == 2) {
            return IDLXBridgeMethod.Access.PRIVATE;
        }
        if (i == 3) {
            return IDLXBridgeMethod.Access.PROTECT;
        }
        if (i != 4) {
            return null;
        }
        return IDLXBridgeMethod.Access.SECURE;
    }

    public static final IDLXBridgeMethod.Access originPermissionAdapt(XBridgeMethod.Access access) {
        Intrinsics.checkNotNullParameter(access, "privilege");
        int i = WhenMappings.$EnumSwitchMapping$1[access.ordinal()];
        if (i == 1) {
            return IDLXBridgeMethod.Access.PUBLIC;
        }
        if (i == 2) {
            return IDLXBridgeMethod.Access.PRIVATE;
        }
        if (i == 3) {
            return IDLXBridgeMethod.Access.PROTECT;
        }
        if (i != 4) {
            return null;
        }
        return IDLXBridgeMethod.Access.SECURE;
    }

    public static final IDLXBridgeMethod.Access xbridge2PermissionAdapt(IDLXBridgeMethod.Access access) {
        Intrinsics.checkNotNullParameter(access, "privilege");
        int i = WhenMappings.$EnumSwitchMapping$2[access.ordinal()];
        if (i == 1) {
            return IDLXBridgeMethod.Access.PUBLIC;
        }
        if (i == 2) {
            return IDLXBridgeMethod.Access.PRIVATE;
        }
        if (i == 3) {
            return IDLXBridgeMethod.Access.PROTECT;
        }
        if (i != 4) {
            return null;
        }
        return IDLXBridgeMethod.Access.SECURE;
    }

    public static final XBridgePlatformType getPlatformType(IBDXBridgeContext iBDXBridgeContext) {
        Intrinsics.checkNotNullParameter(iBDXBridgeContext, "bridgeContext");
        if (iBDXBridgeContext.getPlatformType() == PlatformType.LYNX) {
            return XBridgePlatformType.LYNX;
        }
        if (iBDXBridgeContext.getPlatformType() == PlatformType.WEB) {
            return XBridgePlatformType.WEB;
        }
        return XBridgePlatformType.ALL;
    }
}
