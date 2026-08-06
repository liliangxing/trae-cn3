package com.bytedance.vcloud.strategy;

import com.ss.android.portrait.api.IColdBootSolariaPortraitChangeListener;
import com.ss.android.portrait.api.INearLineSolariaPortraitChangeListener;
import com.ss.android.portrait.api.PortraitCenterService;
import com.ss.android.portrait.api.PortraitDataType;
import com.ss.android.portrait.api.PortraitElement;
import com.ss.android.portrait.api.PortraitProducer;
import com.ss.android.portrait.api.PortraitType;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PortraitService.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0011\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013H\u0016J\u001c\u0010\u0011\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0086 ¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\tH\u0096 J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001bH\u0086 J0\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J/\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/vcloud/strategy/PortraitService;", "Lcom/ss/android/portrait/api/INearLineSolariaPortraitChangeListener;", "Lcom/ss/android/portrait/api/IColdBootSolariaPortraitChangeListener;", "Lcom/ss/android/portrait/api/PortraitProducer;", "<init>", "()V", "service", "Lcom/ss/android/portrait/api/PortraitCenterService;", "release", "", "getStrategyPortrait", "", "strategyName", "", "key", "params", "Lorg/json/JSONObject;", "onNearLineSolariaPortraitChanged", "changeKeyList", "", "", "([Ljava/lang/String;)V", "onColdBootSolariaPortraitChanged", "containsKey", "", "type", "Lcom/ss/android/portrait/api/PortraitType;", "", "getPortrait", "Lcom/ss/android/portrait/api/PortraitElement;", "preload-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PortraitService extends PortraitProducer implements INearLineSolariaPortraitChangeListener, IColdBootSolariaPortraitChangeListener {
    private final PortraitCenterService service;

    /* compiled from: PortraitService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PortraitDataType.values().length];
            try {
                iArr[PortraitDataType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PortraitDataType.BOOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PortraitDataType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PortraitDataType.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PortraitDataType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final native boolean containsKey(String key, int type);

    public final native Object getPortrait(String key, String strategyName, int type, JSONObject params);

    public native void onColdBootSolariaPortraitChanged();

    public final native void onNearLineSolariaPortraitChanged(String[] changeKeyList);

    public PortraitService() {
        PortraitCenterService instanceWithoutInit = PortraitCenterService.Companion.instanceWithoutInit();
        this.service = instanceWithoutInit;
        instanceWithoutInit.addNearLineSolariaPortraitChangeListener(this);
        instanceWithoutInit.addColdBootSolariaPortraitChangeListener(this);
        instanceWithoutInit.registerProducer(this);
    }

    public final void release() {
        this.service.removeNearLineSolariaPortraitChangeListener(this);
        this.service.removeColdBootSolariaPortraitChangeListener(this);
        this.service.unregisterProducer(this);
    }

    public final Object getStrategyPortrait(String strategyName, String key, JSONObject params) {
        Object valueOf;
        Intrinsics.checkNotNullParameter(strategyName, "strategyName");
        Intrinsics.checkNotNullParameter(key, "key");
        PortraitElement strategyPortrait = this.service.getStrategyPortrait(strategyName, key, PortraitType.ALL, params);
        if (strategyPortrait == null) {
            return null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.service.getPortraitDataType(key).ordinal()];
        if (i == 1) {
            valueOf = Integer.valueOf(PortraitElement.asInt$default(strategyPortrait, 0, 1, (Object) null));
        } else if (i == 2) {
            valueOf = Boolean.valueOf(PortraitElement.asBoolean$default(strategyPortrait, false, 1, (Object) null));
        } else if (i == 3) {
            valueOf = Double.valueOf(PortraitElement.asDouble$default(strategyPortrait, 0.0d, 1, (Object) null));
        } else if (i == 4) {
            valueOf = strategyPortrait.asString();
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            valueOf = strategyPortrait.get();
        }
        return valueOf;
    }

    public void onNearLineSolariaPortraitChanged(List<String> changeKeyList) {
        Intrinsics.checkNotNullParameter(changeKeyList, "changeKeyList");
        onNearLineSolariaPortraitChanged((String[]) changeKeyList.toArray(new String[0]));
    }

    public boolean containsKey(String key, PortraitType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (key == null) {
            return false;
        }
        return containsKey(key, type.getType());
    }

    public PortraitElement getPortrait(String key, String strategyName, PortraitType type, JSONObject params) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (key == null) {
            return null;
        }
        return new PortraitElement(getPortrait(key, strategyName, type.getType(), params));
    }
}
