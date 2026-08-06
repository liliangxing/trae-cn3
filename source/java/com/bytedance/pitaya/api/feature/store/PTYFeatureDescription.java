package com.bytedance.pitaya.api.feature.store;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYFeatureDescription.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0015\u0018\u0000 #2\u00020\u0001:\u0001#B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u0006$"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureDescription;", "Lcom/bytedance/pitaya/api/feature/store/PTYMetaFeatureDescription;", "featureName", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "eventFilter", "eventField", "type", "", "featureSource", "dump", "", "maxCacheCount", "divideTimeType", "subFeatures", "", "startSessionEvent", "endSessionEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZIILjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getDivideTimeType", "()I", "getDump", "()Z", "getEndSessionEvent", "()Ljava/lang/String;", "getEventField", "getEventFilter", "getEventName", "getFeatureName", "getFeatureSource", "getMaxCacheCount", "getStartSessionEvent", "getSubFeatures", "()Ljava/util/List;", "getType", "Companion", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class PTYFeatureDescription extends PTYMetaFeatureDescription {
    public static final int PTYDivideTimeApplog = 2;
    public static final int PTYDivideTimeCustom = 3;
    public static final int PTYDivideTimeForeground = 1;
    public static final int PTYDivideTimeLaunch = 0;
    public static final int PTYDivideTimeUnknown = 999;
    public static final int PTYFEDataTypeKVNumic = 1;
    public static final int PTYFEDataTypeKVString = 0;
    public static final int PTYFEDataTypeSeqDict = 6;
    public static final int PTYFEDataTypeSeqNumic = 3;
    public static final int PTYFEDataTypeSeqString = 2;
    public static final int PTYFEDataTypeSessionNumic = 5;
    public static final int PTYFEDataTypeSessionString = 4;
    public static final int PTYFEDataTypeUnkown = 999;
    public static final int PTYFeatureSourceApplog = 0;
    public static final int PTYFeatureSourceNative = 1;
    public static final int PTYFeatureSourceUnkown = 999;
    private final int divideTimeType;
    private final boolean dump;
    private final String endSessionEvent;
    private final String eventField;
    private final String eventFilter;
    private final String eventName;
    private final String featureName;
    private final int featureSource;
    private final int maxCacheCount;
    private final String startSessionEvent;
    private final List<PTYMetaFeatureDescription> subFeatures;
    private final int type;

    @Override // com.bytedance.pitaya.api.feature.store.PTYMetaFeatureDescription
    public String getFeatureName() {
        return this.featureName;
    }

    @Override // com.bytedance.pitaya.api.feature.store.PTYMetaFeatureDescription
    public String getEventName() {
        return this.eventName;
    }

    @Override // com.bytedance.pitaya.api.feature.store.PTYMetaFeatureDescription
    public String getEventFilter() {
        return this.eventFilter;
    }

    @Override // com.bytedance.pitaya.api.feature.store.PTYMetaFeatureDescription
    public String getEventField() {
        return this.eventField;
    }

    @Override // com.bytedance.pitaya.api.feature.store.PTYMetaFeatureDescription
    public int getType() {
        return this.type;
    }

    public final int getFeatureSource() {
        return this.featureSource;
    }

    public final boolean getDump() {
        return this.dump;
    }

    public final int getMaxCacheCount() {
        return this.maxCacheCount;
    }

    public final int getDivideTimeType() {
        return this.divideTimeType;
    }

    public /* synthetic */ PTYFeatureDescription(String str, String str2, String str3, String str4, int i, int i2, boolean z, int i3, int i4, List list, String str5, String str6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i5 & 2) != 0 ? null : str2, (i5 & 4) != 0 ? null : str3, (i5 & 8) != 0 ? null : str4, i, (i5 & 32) != 0 ? 0 : i2, (i5 & 64) != 0 ? false : z, (i5 & 128) != 0 ? 0 : i3, (i5 & 256) != 0 ? 999 : i4, (i5 & 512) != 0 ? new ArrayList() : list, (i5 & 1024) != 0 ? null : str5, (i5 & 2048) != 0 ? null : str6);
    }

    public final List<PTYMetaFeatureDescription> getSubFeatures() {
        return this.subFeatures;
    }

    public final String getStartSessionEvent() {
        return this.startSessionEvent;
    }

    public final String getEndSessionEvent() {
        return this.endSessionEvent;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PTYFeatureDescription(String featureName, String str, String str2, String str3, int i, int i2, boolean z, int i3, int i4, List<PTYMetaFeatureDescription> subFeatures, String str4, String str5) {
        super(featureName, str, str2, str3, i);
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(subFeatures, "subFeatures");
        this.featureName = featureName;
        this.eventName = str;
        this.eventFilter = str2;
        this.eventField = str3;
        this.type = i;
        this.featureSource = i2;
        this.dump = z;
        this.maxCacheCount = i3;
        this.divideTimeType = i4;
        this.subFeatures = subFeatures;
        this.startSessionEvent = str4;
        this.endSessionEvent = str5;
    }
}
