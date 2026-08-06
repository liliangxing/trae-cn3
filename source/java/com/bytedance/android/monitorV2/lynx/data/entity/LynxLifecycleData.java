package com.bytedance.android.monitorV2.lynx.data.entity;

import com.bytedance.android.monitorV2.base.BaseMonitorData;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitorConstant;
import com.bytedance.android.monitorV2.util.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LynxLifecycleData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020'H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006+"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxLifecycleData;", "Lcom/bytedance/android/monitorV2/base/BaseMonitorData;", "()V", "firstScreen", "", "getFirstScreen", "()J", "setFirstScreen", "(J)V", "loadFailed", "getLoadFailed", "setLoadFailed", "loadFinish", "getLoadFinish", "setLoadFinish", "loadStart", "getLoadStart", "setLoadStart", "loadState", "", "getLoadState", "()I", "setLoadState", "(I)V", "receiveError", "getReceiveError", "setReceiveError", "runtimeReady", "getRuntimeReady", "setRuntimeReady", "showEnd", "getShowEnd", "setShowEnd", "showStart", "getShowStart", "setShowStart", "appendLifeCycleInfo", "", "dataJSON", "Lorg/json/JSONObject;", "fillInJsonObject", "jsonObject", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class LynxLifecycleData extends BaseMonitorData {
    private static final int STATE_INIT = 0;
    private long firstScreen;
    private long loadFailed;
    private long loadFinish;
    private long loadStart;
    private int loadState = STATE_UNKNOWN;
    private long receiveError;
    private long runtimeReady;
    private long showEnd;
    private long showStart;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int STATE_UNKNOWN = -1;
    private static final int STATE_LOADING = 1;
    private static final int STATE_LAOD_ERROR = 2;
    private static final int STATE_LOAD_SUCESS = 3;

    public final long getLoadStart() {
        return this.loadStart;
    }

    public final void setLoadStart(long j) {
        this.loadStart = j;
    }

    public final long getLoadFinish() {
        return this.loadFinish;
    }

    public final void setLoadFinish(long j) {
        this.loadFinish = j;
    }

    public final long getLoadFailed() {
        return this.loadFailed;
    }

    public final void setLoadFailed(long j) {
        this.loadFailed = j;
    }

    public final long getShowStart() {
        return this.showStart;
    }

    public final void setShowStart(long j) {
        this.showStart = j;
    }

    public final long getShowEnd() {
        return this.showEnd;
    }

    public final void setShowEnd(long j) {
        this.showEnd = j;
    }

    public final long getReceiveError() {
        return this.receiveError;
    }

    public final void setReceiveError(long j) {
        this.receiveError = j;
    }

    public final long getFirstScreen() {
        return this.firstScreen;
    }

    public final void setFirstScreen(long j) {
        this.firstScreen = j;
    }

    public final long getRuntimeReady() {
        return this.runtimeReady;
    }

    public final void setRuntimeReady(long j) {
        this.runtimeReady = j;
    }

    public final int getLoadState() {
        return this.loadState;
    }

    public final void setLoadState(int i) {
        this.loadState = i;
    }

    /* compiled from: LynxLifecycleData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxLifecycleData$Companion;", "", "()V", "STATE_INIT", "", "getSTATE_INIT", "()I", "STATE_LAOD_ERROR", "getSTATE_LAOD_ERROR", "STATE_LOADING", "getSTATE_LOADING", "STATE_LOAD_SUCESS", "getSTATE_LOAD_SUCESS", "STATE_UNKNOWN", "getSTATE_UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getSTATE_UNKNOWN() {
            return LynxLifecycleData.STATE_UNKNOWN;
        }

        public final int getSTATE_INIT() {
            return LynxLifecycleData.STATE_INIT;
        }

        public final int getSTATE_LOADING() {
            return LynxLifecycleData.STATE_LOADING;
        }

        public final int getSTATE_LAOD_ERROR() {
            return LynxLifecycleData.STATE_LAOD_ERROR;
        }

        public final int getSTATE_LOAD_SUCESS() {
            return LynxLifecycleData.STATE_LOAD_SUCESS;
        }
    }

    @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        appendLifeCycleInfo(jsonObject);
    }

    private final void appendLifeCycleInfo(JSONObject dataJSON) {
        JsonUtils.safePut(dataJSON, "load_start", this.loadStart);
        JsonUtils.safePut(dataJSON, LynxViewMonitorConstant.LOAD_FINISH, this.loadFinish);
        JsonUtils.safePut(dataJSON, LynxViewMonitorConstant.LOAD_FAILED, this.loadFailed);
        JsonUtils.safePut(dataJSON, "show_start", this.showStart);
        JsonUtils.safePut(dataJSON, "show_end", this.showEnd);
        JsonUtils.safePut(dataJSON, LynxViewMonitorConstant.RECEIVE_ERROR, this.receiveError);
        JsonUtils.safePut(dataJSON, "first_screen", this.firstScreen);
        JsonUtils.safePut(dataJSON, LynxViewMonitorConstant.RUNTIME_READY, this.runtimeReady);
    }
}
