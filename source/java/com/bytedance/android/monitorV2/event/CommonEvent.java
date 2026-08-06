package com.bytedance.android.monitorV2.event;

import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.entity.ContainerInfo;
import com.bytedance.android.monitorV2.entity.NativeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CommonEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/monitorV2/event/CommonEvent;", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "eventType", "", "(Ljava/lang/String;)V", "containerInfo", "Lcom/bytedance/android/monitorV2/entity/ContainerInfo;", "getContainerInfo", "()Lcom/bytedance/android/monitorV2/entity/ContainerInfo;", "setContainerInfo", "(Lcom/bytedance/android/monitorV2/entity/ContainerInfo;)V", "jsInfo", "Lorg/json/JSONObject;", "getJsInfo", "()Lorg/json/JSONObject;", "setJsInfo", "(Lorg/json/JSONObject;)V", "nativeInfo", "Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;", "getNativeInfo", "()Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;", "setNativeInfo", "(Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;)V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class CommonEvent extends HybridEvent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ContainerInfo containerInfo;
    private JSONObject jsInfo;
    private BaseNativeInfo nativeInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonEvent(String eventType) {
        super(eventType);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
    }

    public final BaseNativeInfo getNativeInfo() {
        return this.nativeInfo;
    }

    public final void setNativeInfo(BaseNativeInfo baseNativeInfo) {
        this.nativeInfo = baseNativeInfo;
    }

    public final ContainerInfo getContainerInfo() {
        return this.containerInfo;
    }

    public final void setContainerInfo(ContainerInfo containerInfo) {
        this.containerInfo = containerInfo;
    }

    public final JSONObject getJsInfo() {
        return this.jsInfo;
    }

    public final void setJsInfo(JSONObject jSONObject) {
        this.jsInfo = jSONObject;
    }

    /* compiled from: CommonEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/monitorV2/event/CommonEvent$Companion;", "", "()V", "create", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "eventType", "", "nativeInfo", "Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;", "beforeCreate", "Lkotlin/Function1;", "", "data", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CommonEvent create(String eventType, JSONObject data) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(data, "data");
            return create(eventType, new NativeInfo(eventType, data));
        }

        public static /* synthetic */ CommonEvent create$default(Companion companion, String str, BaseNativeInfo baseNativeInfo, int i, Object obj) {
            if ((i & 2) != 0) {
                baseNativeInfo = null;
            }
            return companion.create(str, baseNativeInfo);
        }

        public final CommonEvent create(String eventType, BaseNativeInfo nativeInfo) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            return create(eventType, nativeInfo, null);
        }

        public static /* synthetic */ CommonEvent create$default(Companion companion, String str, BaseNativeInfo baseNativeInfo, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                baseNativeInfo = null;
            }
            return companion.create(str, baseNativeInfo, function1);
        }

        public final CommonEvent create(String eventType, BaseNativeInfo nativeInfo, Function1<? super CommonEvent, Unit> beforeCreate) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            CommonEvent commonEvent = new CommonEvent(eventType);
            commonEvent.setNativeInfo(nativeInfo);
            if (beforeCreate != null) {
                beforeCreate.invoke(commonEvent);
            }
            commonEvent.onEventCreated();
            return commonEvent;
        }
    }
}
