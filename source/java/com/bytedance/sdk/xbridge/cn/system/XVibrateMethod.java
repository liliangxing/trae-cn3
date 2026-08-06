package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.system.idl.AbsXVibrateMethodIDL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XVibrateMethod.kt */
@XBridgeMethod(name = "x.vibrate")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XVibrateMethod;", "Lcom/bytedance/sdk/xbridge/cn/system/idl/AbsXVibrateMethodIDL;", "()V", "TAG", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/system/idl/AbsXVibrateMethodIDL$XVibrateParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/system/idl/AbsXVibrateMethodIDL$XVibrateResultModel;", "VibrationStyle", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XVibrateMethod extends AbsXVibrateMethodIDL {
    private final String TAG = "XVibrateMethod";

    /* compiled from: XVibrateMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XVibrateMethod$VibrationStyle;", "", "amplitude", "", "(Ljava/lang/String;II)V", "getAmplitude", "()I", "LIGHT", "MEDIUM", "HEAVY", "UNKNOWN", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public enum VibrationStyle {
        LIGHT(50),
        MEDIUM(125),
        HEAVY(ReducerConstants.REQUEST_CODE),
        UNKNOWN(0);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int amplitude;

        VibrationStyle(int i) {
            this.amplitude = i;
        }

        public final int getAmplitude() {
            return this.amplitude;
        }

        /* compiled from: XVibrateMethod.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XVibrateMethod$VibrationStyle$Companion;", "", "()V", "getVibrationStyleByName", "Lcom/bytedance/sdk/xbridge/cn/system/XVibrateMethod$VibrationStyle;", "name", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final VibrationStyle getVibrationStyleByName(String name) {
                if (name != null) {
                    try {
                        String upperCase = name.toUpperCase();
                        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
                        return VibrationStyle.valueOf(upperCase);
                    } catch (Exception unused) {
                        return VibrationStyle.UNKNOWN;
                    }
                }
                return VibrationStyle.UNKNOWN;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXVibrateMethodIDL.XVibrateParamModel params, CompletionBlock<AbsXVibrateMethodIDL.XVibrateResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            XBridge.log("Context is null");
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context is null.", null, 4, null);
            return;
        }
        try {
            VibrationStyle vibrationStyleByName = VibrationStyle.INSTANCE.getVibrationStyleByName(params.getStyle());
            if (vibrationStyleByName == VibrationStyle.UNKNOWN) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "Illegal style", null, 4, null);
                return;
            }
            int amplitude = vibrationStyleByName.getAmplitude();
            Number duration = params.getDuration();
            Long valueOf = duration != null ? Long.valueOf(duration.longValue()) : null;
            Object systemService = ownerActivity.getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            Vibrator vibrator = (Vibrator) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(valueOf != null ? VibrationEffect.createOneShot(valueOf.longValue(), amplitude) : null, (AudioAttributes) null);
            } else if (valueOf != null) {
                vibrator.vibrate(valueOf.longValue());
            }
            XBridge.log("Vibrate success");
            callback.onSuccess((XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXVibrateMethodIDL.XVibrateResultModel.class)), "vibrate execute success.");
        } catch (Exception e) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Can not get vibrate service.", null, 4, null);
            XBridge.log(String.valueOf(e.getMessage()));
        }
    }
}
