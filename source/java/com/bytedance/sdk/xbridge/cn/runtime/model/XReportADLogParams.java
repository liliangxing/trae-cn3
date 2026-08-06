package com.bytedance.sdk.xbridge.cn.runtime.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XReportADLogParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u000b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/model/XReportADLogParams;", "", "label", "", "tag", "refer", "groupID", "creativeID", "logExtra", "idlExtraParams", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getCreativeID", "()Ljava/lang/String;", "getGroupID", "getIdlExtraParams", "()Ljava/util/Map;", "getLabel", "getLogExtra", "getRefer", "getTag", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class XReportADLogParams {
    private final String creativeID;
    private final String groupID;
    private final Map<String, Object> idlExtraParams;
    private final String label;
    private final String logExtra;
    private final String refer;
    private final String tag;

    public XReportADLogParams(String label, String tag, String str, String str2, String str3, String str4, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.label = label;
        this.tag = tag;
        this.refer = str;
        this.groupID = str2;
        this.creativeID = str3;
        this.logExtra = str4;
        this.idlExtraParams = map;
    }

    public /* synthetic */ XReportADLogParams(String str, String str2, String str3, String str4, String str5, String str6, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : map);
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getRefer() {
        return this.refer;
    }

    public final String getGroupID() {
        return this.groupID;
    }

    public final String getCreativeID() {
        return this.creativeID;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final Map<String, Object> getIdlExtraParams() {
        return this.idlExtraParams;
    }
}
