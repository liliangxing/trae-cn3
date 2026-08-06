package com.bytedance.salamander.anniex;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.rts.foundation.RTSMapKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorEventTypingsBaseContainerBase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR6\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0010j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!¨\u0006("}, d2 = {"Lcom/bytedance/salamander/anniex/Internal;", "", "()V", "biz", "", "getBiz", "()Ljava/lang/String;", "setBiz", "(Ljava/lang/String;)V", "client_component", "Lcom/bytedance/salamander/anniex/ClientComponent;", "getClient_component", "()Lcom/bytedance/salamander/anniex/ClientComponent;", "setClient_component", "(Lcom/bytedance/salamander/anniex/ClientComponent;)V", "context", "", "Lcom/bytedance/rts/foundation/RTSMap;", "getContext", "()Ljava/util/Map;", "setContext", "(Ljava/util/Map;)V", "core_view_type", "Lcom/bytedance/salamander/anniex/CoreViewType;", "getCore_view_type", "()Lcom/bytedance/salamander/anniex/CoreViewType;", "setCore_view_type", "(Lcom/bytedance/salamander/anniex/CoreViewType;)V", "hit_sample", "", "getHit_sample", "()J", "setHit_sample", "(J)V", ReportConst.Params.SETTING_BID, "getSetting_bid", "setSetting_bid", "setting_id", "getSetting_id", "setSetting_id", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class Internal {
    private ClientComponent client_component;
    private CoreViewType core_view_type = CoreViewType.AnnieXCard;
    private String biz = "default_bid";
    private String setting_bid = AnniexMonitorEventTypingsBaseContainerBaseKt.getMonitorDefaultBid();
    private long setting_id = -1;
    private long hit_sample = -1;
    private Map<String, String> context = RTSMapKt.RTSMap();

    public CoreViewType getCore_view_type() {
        return this.core_view_type;
    }

    public void setCore_view_type(CoreViewType coreViewType) {
        Intrinsics.checkNotNullParameter(coreViewType, "<set-?>");
        this.core_view_type = coreViewType;
    }

    public String getBiz() {
        return this.biz;
    }

    public void setBiz(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.biz = str;
    }

    public ClientComponent getClient_component() {
        return this.client_component;
    }

    public void setClient_component(ClientComponent clientComponent) {
        this.client_component = clientComponent;
    }

    public String getSetting_bid() {
        return this.setting_bid;
    }

    public void setSetting_bid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.setting_bid = str;
    }

    public long getSetting_id() {
        return this.setting_id;
    }

    public void setSetting_id(long j) {
        this.setting_id = j;
    }

    public long getHit_sample() {
        return this.hit_sample;
    }

    public void setHit_sample(long j) {
        this.hit_sample = j;
    }

    public Map<String, String> getContext() {
        return this.context;
    }

    public void setContext(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.context = map;
    }
}
