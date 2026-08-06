package io.noties.markwon.html.customdata;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomDataWidgetExt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lio/noties/markwon/html/customdata/CachedWidget;", "", "startIndex", "", "endIndex", "dataType", "", "dataValue", "dataValueId", "dataTag", "widget", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/noties/markwon/html/customdata/ICustomDataWidget;)V", "getDataTag", "()Ljava/lang/String;", "getDataType", "getDataValue", "getDataValueId", "getEndIndex", "()I", "getStartIndex", "getWidget", "()Lio/noties/markwon/html/customdata/ICustomDataWidget;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final /* data */ class CachedWidget {
    private final String dataTag;
    private final String dataType;
    private final String dataValue;
    private final String dataValueId;
    private final int endIndex;
    private final int startIndex;
    private final ICustomDataWidget widget;

    public static /* synthetic */ CachedWidget copy$default(CachedWidget cachedWidget, int i, int i2, String str, String str2, String str3, String str4, ICustomDataWidget iCustomDataWidget, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = cachedWidget.startIndex;
        }
        if ((i3 & 2) != 0) {
            i2 = cachedWidget.endIndex;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = cachedWidget.dataType;
        }
        String str5 = str;
        if ((i3 & 8) != 0) {
            str2 = cachedWidget.dataValue;
        }
        String str6 = str2;
        if ((i3 & 16) != 0) {
            str3 = cachedWidget.dataValueId;
        }
        String str7 = str3;
        if ((i3 & 32) != 0) {
            str4 = cachedWidget.dataTag;
        }
        String str8 = str4;
        if ((i3 & 64) != 0) {
            iCustomDataWidget = cachedWidget.widget;
        }
        return cachedWidget.copy(i, i4, str5, str6, str7, str8, iCustomDataWidget);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStartIndex() {
        return this.startIndex;
    }

    /* renamed from: component2, reason: from getter */
    public final int getEndIndex() {
        return this.endIndex;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDataType() {
        return this.dataType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDataValue() {
        return this.dataValue;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDataValueId() {
        return this.dataValueId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDataTag() {
        return this.dataTag;
    }

    /* renamed from: component7, reason: from getter */
    public final ICustomDataWidget getWidget() {
        return this.widget;
    }

    public final CachedWidget copy(int startIndex, int endIndex, String dataType, String dataValue, String dataValueId, String dataTag, ICustomDataWidget widget) {
        Intrinsics.checkParameterIsNotNull(dataType, "dataType");
        Intrinsics.checkParameterIsNotNull(dataValue, "dataValue");
        Intrinsics.checkParameterIsNotNull(dataValueId, "dataValueId");
        Intrinsics.checkParameterIsNotNull(dataTag, "dataTag");
        Intrinsics.checkParameterIsNotNull(widget, "widget");
        return new CachedWidget(startIndex, endIndex, dataType, dataValue, dataValueId, dataTag, widget);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof CachedWidget) {
                CachedWidget cachedWidget = (CachedWidget) other;
                if (this.startIndex == cachedWidget.startIndex) {
                    if (!(this.endIndex == cachedWidget.endIndex) || !Intrinsics.areEqual(this.dataType, cachedWidget.dataType) || !Intrinsics.areEqual(this.dataValue, cachedWidget.dataValue) || !Intrinsics.areEqual(this.dataValueId, cachedWidget.dataValueId) || !Intrinsics.areEqual(this.dataTag, cachedWidget.dataTag) || !Intrinsics.areEqual(this.widget, cachedWidget.widget)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((this.startIndex * 31) + this.endIndex) * 31;
        String str = this.dataType;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.dataValue;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.dataValueId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.dataTag;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        ICustomDataWidget iCustomDataWidget = this.widget;
        return hashCode4 + (iCustomDataWidget != null ? iCustomDataWidget.hashCode() : 0);
    }

    public String toString() {
        return "CachedWidget(startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", dataType=" + this.dataType + ", dataValue=" + this.dataValue + ", dataValueId=" + this.dataValueId + ", dataTag=" + this.dataTag + ", widget=" + this.widget + ")";
    }

    public CachedWidget(int i, int i2, String dataType, String dataValue, String dataValueId, String dataTag, ICustomDataWidget widget) {
        Intrinsics.checkParameterIsNotNull(dataType, "dataType");
        Intrinsics.checkParameterIsNotNull(dataValue, "dataValue");
        Intrinsics.checkParameterIsNotNull(dataValueId, "dataValueId");
        Intrinsics.checkParameterIsNotNull(dataTag, "dataTag");
        Intrinsics.checkParameterIsNotNull(widget, "widget");
        this.startIndex = i;
        this.endIndex = i2;
        this.dataType = dataType;
        this.dataValue = dataValue;
        this.dataValueId = dataValueId;
        this.dataTag = dataTag;
        this.widget = widget;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final String getDataType() {
        return this.dataType;
    }

    public final String getDataValue() {
        return this.dataValue;
    }

    public final String getDataValueId() {
        return this.dataValueId;
    }

    public /* synthetic */ CachedWidget(int i, int i2, String str, String str2, String str3, String str4, ICustomDataWidget iCustomDataWidget, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, str2, str3, (i3 & 32) != 0 ? "" : str4, iCustomDataWidget);
    }

    public final String getDataTag() {
        return this.dataTag;
    }

    public final ICustomDataWidget getWidget() {
        return this.widget;
    }
}
