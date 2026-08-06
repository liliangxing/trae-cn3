package com.bytedance.android.anniex.solutions.card.model;

import com.bytedance.android.anniex.solutions.card.model.Actions;
import com.bytedance.android.anniex.solutions.card.util.DataTypeAdapter;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetaContent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0003Ju\u0010\u001b\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001R$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\""}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/model/MetaContent;", "", "jsb", "", "", "Lcom/bytedance/android/anniex/solutions/card/model/Actions$JSBAction;", "actions", "Lcom/bytedance/android/anniex/solutions/card/model/Actions$HighExec;", "onShow", "onHide", "onViewLoad", Constants.KEY_DATA, "(Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/android/anniex/solutions/card/model/Actions$HighExec;Lcom/bytedance/android/anniex/solutions/card/model/Actions$HighExec;Lcom/bytedance/android/anniex/solutions/card/model/Actions$HighExec;Ljava/util/Map;)V", "getActions", "()Ljava/util/Map;", "getData", "getJsb", "getOnHide", "()Lcom/bytedance/android/anniex/solutions/card/model/Actions$HighExec;", "getOnShow", "getOnViewLoad", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final /* data */ class MetaContent {

    @SerializedName("actions")
    private final Map<String, Actions.HighExec> actions;

    @SerializedName(Constants.KEY_DATA)
    @JsonAdapter(DataTypeAdapter.class)
    private final Map<String, Object> data;

    @SerializedName("jsb")
    private final Map<String, Actions.JSBAction> jsb;

    @SerializedName("onHide")
    private final Actions.HighExec onHide;

    @SerializedName("onShow")
    private final Actions.HighExec onShow;

    @SerializedName("onViewLoad")
    private final Actions.HighExec onViewLoad;

    public MetaContent() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MetaContent copy$default(MetaContent metaContent, Map map, Map map2, Actions.HighExec highExec, Actions.HighExec highExec2, Actions.HighExec highExec3, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            map = metaContent.jsb;
        }
        if ((i & 2) != 0) {
            map2 = metaContent.actions;
        }
        Map map4 = map2;
        if ((i & 4) != 0) {
            highExec = metaContent.onShow;
        }
        Actions.HighExec highExec4 = highExec;
        if ((i & 8) != 0) {
            highExec2 = metaContent.onHide;
        }
        Actions.HighExec highExec5 = highExec2;
        if ((i & 16) != 0) {
            highExec3 = metaContent.onViewLoad;
        }
        Actions.HighExec highExec6 = highExec3;
        if ((i & 32) != 0) {
            map3 = metaContent.data;
        }
        return metaContent.copy(map, map4, highExec4, highExec5, highExec6, map3);
    }

    public final Map<String, Actions.JSBAction> component1() {
        return this.jsb;
    }

    public final Map<String, Actions.HighExec> component2() {
        return this.actions;
    }

    /* renamed from: component3, reason: from getter */
    public final Actions.HighExec getOnShow() {
        return this.onShow;
    }

    /* renamed from: component4, reason: from getter */
    public final Actions.HighExec getOnHide() {
        return this.onHide;
    }

    /* renamed from: component5, reason: from getter */
    public final Actions.HighExec getOnViewLoad() {
        return this.onViewLoad;
    }

    public final Map<String, Object> component6() {
        return this.data;
    }

    public final MetaContent copy(Map<String, Actions.JSBAction> jsb, Map<String, Actions.HighExec> actions, Actions.HighExec onShow, Actions.HighExec onHide, Actions.HighExec onViewLoad, Map<String, ? extends Object> data) {
        return new MetaContent(jsb, actions, onShow, onHide, onViewLoad, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaContent)) {
            return false;
        }
        MetaContent metaContent = (MetaContent) other;
        return Intrinsics.areEqual(this.jsb, metaContent.jsb) && Intrinsics.areEqual(this.actions, metaContent.actions) && Intrinsics.areEqual(this.onShow, metaContent.onShow) && Intrinsics.areEqual(this.onHide, metaContent.onHide) && Intrinsics.areEqual(this.onViewLoad, metaContent.onViewLoad) && Intrinsics.areEqual(this.data, metaContent.data);
    }

    public int hashCode() {
        Map<String, Actions.JSBAction> map = this.jsb;
        int hashCode = (map == null ? 0 : map.hashCode()) * 31;
        Map<String, Actions.HighExec> map2 = this.actions;
        int hashCode2 = (hashCode + (map2 == null ? 0 : map2.hashCode())) * 31;
        Actions.HighExec highExec = this.onShow;
        int hashCode3 = (hashCode2 + (highExec == null ? 0 : highExec.hashCode())) * 31;
        Actions.HighExec highExec2 = this.onHide;
        int hashCode4 = (hashCode3 + (highExec2 == null ? 0 : highExec2.hashCode())) * 31;
        Actions.HighExec highExec3 = this.onViewLoad;
        int hashCode5 = (hashCode4 + (highExec3 == null ? 0 : highExec3.hashCode())) * 31;
        Map<String, Object> map3 = this.data;
        return hashCode5 + (map3 != null ? map3.hashCode() : 0);
    }

    public String toString() {
        return "MetaContent(jsb=" + this.jsb + ", actions=" + this.actions + ", onShow=" + this.onShow + ", onHide=" + this.onHide + ", onViewLoad=" + this.onViewLoad + ", data=" + this.data + ')';
    }

    public MetaContent(Map<String, Actions.JSBAction> map, Map<String, Actions.HighExec> map2, Actions.HighExec highExec, Actions.HighExec highExec2, Actions.HighExec highExec3, Map<String, ? extends Object> map3) {
        this.jsb = map;
        this.actions = map2;
        this.onShow = highExec;
        this.onHide = highExec2;
        this.onViewLoad = highExec3;
        this.data = map3;
    }

    public /* synthetic */ MetaContent(Map map, Map map2, Actions.HighExec highExec, Actions.HighExec highExec2, Actions.HighExec highExec3, Map map3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : map2, (i & 4) != 0 ? null : highExec, (i & 8) != 0 ? null : highExec2, (i & 16) != 0 ? null : highExec3, (i & 32) != 0 ? null : map3);
    }

    public final Map<String, Actions.JSBAction> getJsb() {
        return this.jsb;
    }

    public final Map<String, Actions.HighExec> getActions() {
        return this.actions;
    }

    public final Actions.HighExec getOnShow() {
        return this.onShow;
    }

    public final Actions.HighExec getOnHide() {
        return this.onHide;
    }

    public final Actions.HighExec getOnViewLoad() {
        return this.onViewLoad;
    }

    public final Map<String, Object> getData() {
        return this.data;
    }
}
