package com.bytedance.ies.argus.api.params;

import android.view.InputDevice;
import android.view.MotionEvent;
import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ArgusMotionEventParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010&\u001a\u0004\u0018\u00010\bJ\n\u0010'\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010(\u001a\u00020\bJ\u0012\u0010)\u001a\u0004\u0018\u00010!2\u0006\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u0004\u0018\u00010!2\u0006\u0010*\u001a\u00020+H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006-"}, d2 = {"Lcom/bytedance/ies/argus/api/params/ArgusMotionEventParams;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/api/params/ArgusMotionEventRewritePayload;", "event", "Landroid/view/MotionEvent;", "pageInfo", "Lcom/bytedance/ies/argus/api/params/IFePageInfo;", "loadUrl", "", "(Landroid/view/MotionEvent;Lcom/bytedance/ies/argus/api/params/IFePageInfo;Ljava/lang/String;)V", "getEvent", "()Landroid/view/MotionEvent;", "isVirtual", "", "()Ljava/lang/Boolean;", "getLoadUrl", "()Ljava/lang/String;", "setLoadUrl", "(Ljava/lang/String;)V", "motionDid", "", "Ljava/lang/Integer;", "motionEventDesc", "motionToolType", "pageFeId", "", "getPageFeId", "()Ljava/lang/Long;", "getPageInfo", "()Lcom/bytedance/ies/argus/api/params/IFePageInfo;", "setPageInfo", "(Lcom/bytedance/ies/argus/api/params/IFePageInfo;)V", "printObj", "Lorg/json/JSONObject;", "getPrintObj", "()Lorg/json/JSONObject;", "printObj$delegate", "Lkotlin/Lazy;", "initMotionEventDesc", "initRewritePayload", Api.COL_TAG, "toALogObject", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "toMonitorObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusMotionEventParams extends BaseAspectParams<ArgusMotionEventRewritePayload> {
    private final MotionEvent event;
    private String loadUrl;
    private Integer motionDid;
    private String motionEventDesc;
    private String motionToolType;
    private IFePageInfo pageInfo;

    /* renamed from: printObj$delegate, reason: from kotlin metadata */
    private final Lazy printObj;

    public /* synthetic */ ArgusMotionEventParams(MotionEvent motionEvent, IFePageInfo iFePageInfo, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(motionEvent, (i & 2) != 0 ? null : iFePageInfo, (i & 4) != 0 ? null : str);
    }

    public final MotionEvent getEvent() {
        return this.event;
    }

    public final IFePageInfo getPageInfo() {
        return this.pageInfo;
    }

    public final void setPageInfo(IFePageInfo iFePageInfo) {
        this.pageInfo = iFePageInfo;
    }

    public final String getLoadUrl() {
        return this.loadUrl;
    }

    public final void setLoadUrl(String str) {
        this.loadUrl = str;
    }

    public ArgusMotionEventParams(MotionEvent motionEvent, IFePageInfo iFePageInfo, String str) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        this.event = motionEvent;
        this.pageInfo = iFePageInfo;
        this.loadUrl = str;
        try {
            Result.Companion companion = Result.Companion;
            this.motionDid = Integer.valueOf(motionEvent.getDeviceId());
            Integer valueOf = Integer.valueOf(motionEvent.getPointerCount());
            String str2 = null;
            if (!(valueOf.intValue() >= 1)) {
                valueOf = null;
            }
            if (valueOf != null) {
                valueOf.intValue();
                int toolType = motionEvent.getToolType(0);
                if (toolType == 0) {
                    str2 = "TOOL_TYPE_UNKNOWN";
                } else if (toolType == 1) {
                    str2 = "TOOL_TYPE_FINGER";
                } else if (toolType == 3) {
                    str2 = "TOOL_TYPE_MOUSE";
                } else if (toolType == 4) {
                    str2 = "TOOL_TYPE_ERASER";
                }
                this.motionToolType = str2;
            }
            this.motionEventDesc = initMotionEventDesc();
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        this.printObj = LazyKt.lazy(new Function0<JSONObject>() { // from class: com.bytedance.ies.argus.api.params.ArgusMotionEventParams$printObj$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final JSONObject invoke() {
                Integer num;
                String str3;
                JSONObject jSONObject = new JSONObject();
                ArgusMotionEventParams argusMotionEventParams = ArgusMotionEventParams.this;
                ArgusMotionEventRewritePayload rewritePayload = argusMotionEventParams.getRewritePayload();
                JSONUtilsKt.safelyPut(jSONObject, "scene", rewritePayload != null ? rewritePayload.getSceneTag() : null);
                JSONUtilsKt.safelyPutWithDefault(jSONObject, "url", argusMotionEventParams.getLoadUrl());
                JSONUtilsKt.safelyPutWithDefault(jSONObject, "fe_id", argusMotionEventParams.getPageFeId());
                JSONUtilsKt.safelyPutWithDefault(jSONObject, "is_virtual", argusMotionEventParams.isVirtual());
                num = argusMotionEventParams.motionDid;
                JSONUtilsKt.safelyPutWithDefault(jSONObject, "motion_did", num);
                str3 = argusMotionEventParams.motionToolType;
                JSONUtilsKt.safelyPutWithDefault(jSONObject, "tool_type", str3);
                return jSONObject;
            }
        });
    }

    public final Long getPageFeId() {
        IFePageInfo iFePageInfo = this.pageInfo;
        if (iFePageInfo != null) {
            return Long.valueOf(iFePageInfo.getFeId());
        }
        return null;
    }

    public final Boolean isVirtual() {
        InputDevice device;
        Integer num = this.motionDid;
        if (num == null || (device = InputDevice.getDevice(num.intValue())) == null) {
            return null;
        }
        return Boolean.valueOf(device.isVirtual());
    }

    public final String tag() {
        return this.motionDid + '_' + this.motionToolType;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public ArgusMotionEventRewritePayload initRewritePayload() {
        return new ArgusMotionEventRewritePayload(null, 1, null);
    }

    private final JSONObject getPrintObj() {
        return (JSONObject) this.printObj.getValue();
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toALogObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return getPrintObj();
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toMonitorObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject printObj = getPrintObj();
        JSONUtilsKt.safelyPut(printObj, "event", this.motionEventDesc);
        return printObj;
    }

    public final String initMotionEventDesc() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            int action = this.event.getAction();
            obj = Result.constructor-impl(MapsKt.mapOf(new Pair[]{TuplesKt.to("action", action != 0 ? action != 1 ? action != 2 ? action != 3 ? "UNKNOWN_ACTION" : "ACTION_CANCEL" : "ACTION_MOVE" : "ACTION_UP" : "ACTION_DOWN"), TuplesKt.to("x", Float.valueOf(this.event.getX())), TuplesKt.to("y", Float.valueOf(this.event.getY()))}).toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (String) obj;
    }
}
