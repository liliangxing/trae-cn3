package com.bytedance.pitaya.api.feature.store;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYMetaFeatureDescription.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYMetaFeatureDescription;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "featureName", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "eventFilter", "eventField", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getEventField", "()Ljava/lang/String;", "getEventFilter", "getEventName", "getFeatureName", "getType", "()I", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class PTYMetaFeatureDescription implements ReflectionCall {
    private final String eventField;
    private final String eventFilter;
    private final String eventName;
    private final String featureName;
    private final int type;

    public PTYMetaFeatureDescription(String featureName, String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        this.featureName = featureName;
        this.eventName = str;
        this.eventFilter = str2;
        this.eventField = str3;
        this.type = i;
    }

    public /* synthetic */ PTYMetaFeatureDescription(String str, String str2, String str3, String str4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, i);
    }

    public String getFeatureName() {
        return this.featureName;
    }

    public String getEventName() {
        return this.eventName;
    }

    public String getEventFilter() {
        return this.eventFilter;
    }

    public String getEventField() {
        return this.eventField;
    }

    public int getType() {
        return this.type;
    }
}
