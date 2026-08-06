package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.strategy.provider.BaseStrategyConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MotionStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R*\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/MotionStrategyConfig;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyConfig;", "sceneMatchMap", "", "", "", "", "(Ljava/util/Map;)V", "getSceneMatchMap", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class MotionStrategyConfig extends BaseStrategyConfig {

    @SerializedName("scene_match_map")
    private final Map<String, List<Long>> sceneMatchMap;

    /* JADX WARN: Multi-variable type inference failed */
    public MotionStrategyConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ MotionStrategyConfig(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map);
    }

    public final Map<String, List<Long>> getSceneMatchMap() {
        return this.sceneMatchMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MotionStrategyConfig(Map<String, ? extends List<Long>> map) {
        this.sceneMatchMap = map;
    }
}
