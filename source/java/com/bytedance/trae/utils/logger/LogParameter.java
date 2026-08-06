package com.bytedance.trae.utils.logger;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FormatLogBuilder.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/bytedance/trae/utils/logger/LogParameter;", "", "what", "", "linkID", "", "eventType", "whereInfo", "who", "source", "params", "", "Lcom/bytedance/trae/utils/logger/LogKey;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getWhat", "()Ljava/lang/String;", "setWhat", "(Ljava/lang/String;)V", "getLinkID", "()Ljava/util/List;", "setLinkID", "(Ljava/util/List;)V", "getEventType", "setEventType", "getWhereInfo", "setWhereInfo", "getWho", "setWho", "getSource", "setSource", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LogParameter {
    private String eventType;
    private List<String> linkID;
    private Map<LogKey, Object> params;
    private String source;
    private String what;
    private String whereInfo;
    private String who;

    public LogParameter(String what, List<String> list, String str, String str2, String str3, String str4, Map<LogKey, Object> map) {
        Intrinsics.checkNotNullParameter(what, "what");
        this.what = what;
        this.linkID = list;
        this.eventType = str;
        this.whereInfo = str2;
        this.who = str3;
        this.source = str4;
        this.params = map;
    }

    public /* synthetic */ LogParameter(String str, List list, String str2, String str3, String str4, String str5, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) == 0 ? map : null);
    }

    public final String getWhat() {
        return this.what;
    }

    public final void setWhat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.what = str;
    }

    public final List<String> getLinkID() {
        return this.linkID;
    }

    public final void setLinkID(List<String> list) {
        this.linkID = list;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final void setEventType(String str) {
        this.eventType = str;
    }

    public final String getWhereInfo() {
        return this.whereInfo;
    }

    public final void setWhereInfo(String str) {
        this.whereInfo = str;
    }

    public final String getWho() {
        return this.who;
    }

    public final void setWho(String str) {
        this.who = str;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final Map<LogKey, Object> getParams() {
        return this.params;
    }

    public final void setParams(Map<LogKey, Object> map) {
        this.params = map;
    }
}
