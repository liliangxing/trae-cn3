package com.bytedance.sdk.xbridge.cn.protocol;

import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sync.SyncConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* compiled from: APTContract.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\"\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/APTContract;", "", "()V", "XBRIDGE_CREATOR_PACKAGE", "", "findCreatorByMethodName", "methodName", "prefix", "findCreatorByMethodNameAndBiz", "biz", "findXBridge3CreatorByNameSpaceAndMethodName", LynxBridgeCall.NAME_SPACE, "getCreatorClassName", "getCreatorClassNameAndBiz", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class APTContract {
    public static final APTContract INSTANCE = new APTContract();
    private static final String XBRIDGE_CREATOR_PACKAGE = "com.bytedance.xbridge.cn.gen";

    private APTContract() {
    }

    private final String getCreatorClassName(String methodName, String prefix) {
        String replace$default = StringsKt.replace$default(methodName, ".", SyncConstants.SEPARATOR, false, 4, (Object) null);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s_Creator_%s", Arrays.copyOf(new Object[]{prefix, replace$default}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @JvmStatic
    public static final String findCreatorByMethodName(String methodName, String prefix) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return "com.bytedance.xbridge.cn.gen." + INSTANCE.getCreatorClassName(methodName, prefix);
    }

    private final String getCreatorClassNameAndBiz(String methodName, String prefix, String biz) {
        String replace$default = StringsKt.replace$default(methodName, ".", SyncConstants.SEPARATOR, false, 4, (Object) null);
        String replace$default2 = StringsKt.replace$default(biz, ".", SyncConstants.SEPARATOR, false, 4, (Object) null);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s_Creator_%s_%s", Arrays.copyOf(new Object[]{prefix, replace$default, replace$default2}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @JvmStatic
    public static final String findCreatorByMethodNameAndBiz(String methodName, String prefix, String biz) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(biz, "biz");
        return "com.bytedance.xbridge.cn.gen." + INSTANCE.getCreatorClassNameAndBiz(methodName, prefix, biz);
    }

    @JvmStatic
    public static final String findXBridge3CreatorByNameSpaceAndMethodName(String namespace, String methodName) {
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return "com.bytedance.xbridge.cn.gen.xbridge3_" + namespace + "_Creator_" + StringsKt.replace$default(methodName, ".", SyncConstants.SEPARATOR, false, 4, (Object) null);
    }
}
