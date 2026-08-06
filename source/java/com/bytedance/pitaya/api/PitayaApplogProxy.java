package com.bytedance.pitaya.api;

import android.content.Context;
import android.util.Log;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.pitaya.api.bean.PTYApplogEvent;
import com.bytedance.pitaya.api.bean.PTYApplogEventType;
import com.bytedance.pitaya.api.bean.PTYProxySetting;
import com.bytedance.pitaya.api.feature.IPTYEventVerify;
import com.bytedance.pitaya.api.util.ContextContainer;
import com.bytedance.pitaya.api.util.FifoQueue;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: PitayaApplogProxy.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"J\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/pitaya/api/PitayaApplogProxy;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "Lcom/bytedance/pitaya/api/feature/IPTYEventVerify;", "()V", "APPLOG_CFGPATH", "", "getAPPLOG_CFGPATH", "()Ljava/lang/String;", "TAG", "getTAG", "cache", "Lcom/bytedance/pitaya/api/util/FifoQueue;", "Lcom/bytedance/pitaya/api/bean/PTYApplogEvent;", "filterSet", "", EventConstants.PARAM_SOURCE_INIT, "", "getInit", "()Z", "setInit", "(Z)V", "stoped", "cacheSize", "", "setting", "Lcom/bytedance/pitaya/api/bean/PTYProxySetting;", "isValidEvent", SchemaConstants.INNER_PARAM_EVENT_NAME, "onEvent", "", "extParams", "Lorg/json/JSONObject;", "storeCache", "callback", "Lcom/bytedance/pitaya/api/PTYApplogImplCallback;", "stringToSet", "str", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PitayaApplogProxy implements ReflectionCall, IPTYEventVerify {
    private volatile FifoQueue<PTYApplogEvent> cache;
    private volatile boolean init;
    private volatile boolean stoped;
    private final String TAG = "PTY-ApplogProxy";
    private final String APPLOG_CFGPATH = "/Pitaya/CFG/APPLOG_CACHE_KEY";
    private volatile Set<String> filterSet = new LinkedHashSet();

    public final String getTAG() {
        return this.TAG;
    }

    public final String getAPPLOG_CFGPATH() {
        return this.APPLOG_CFGPATH;
    }

    public final boolean getInit() {
        return this.init;
    }

    public final void setInit(boolean z) {
        this.init = z;
    }

    public final boolean init(PTYProxySetting setting) {
        File filesDir;
        Intrinsics.checkNotNullParameter(setting, "setting");
        if (setting.getUseCustomApplogEvents()) {
            this.filterSet = stringToSet(setting.getCustomApplogEvents());
            if (this.filterSet.size() == 0) {
                Log.i(this.TAG, "init failed filterSet is empty");
                return false;
            }
            Log.i(this.TAG, "init success filterSet : " + setting.getCustomApplogEvents());
        } else {
            StringBuilder sb = new StringBuilder();
            Context context = ContextContainer.INSTANCE.getContext();
            File file = new File(sb.append((context == null || (filesDir = context.getFilesDir()) == null) ? null : filesDir.getAbsolutePath()).append(this.APPLOG_CFGPATH).toString());
            if (!file.exists()) {
                this.init = true;
                this.stoped = true;
                Log.i(this.TAG, "init failed for no config");
                return false;
            }
            try {
                String readText = FilesKt.readText(file, Charsets.UTF_8);
                this.filterSet = stringToSet(readText);
                Log.i(this.TAG, "init success filterSet : " + readText);
            } catch (Exception unused) {
                return false;
            }
        }
        this.cache = new FifoQueue<>(setting.getMaxApplogEventCacheNum());
        this.init = true;
        return true;
    }

    public final void onEvent(String eventName, String extParams) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        if (this.init && this.filterSet.size() > 0 && this.filterSet.contains(eventName)) {
            synchronized (this) {
                if (this.stoped) {
                    return;
                }
                FifoQueue<PTYApplogEvent> fifoQueue = this.cache;
                if (fifoQueue != null) {
                    fifoQueue.add(new PTYApplogEvent(eventName, extParams, PTYApplogEventType.COLD_START));
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public final void onEvent(String eventName, JSONObject extParams) {
        String jSONObject;
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        if (this.init && this.filterSet.size() > 0 && this.filterSet.contains(eventName)) {
            synchronized (this) {
                if (this.stoped) {
                    return;
                }
                if (extParams != null) {
                    try {
                        jSONObject = extParams.toString();
                    } catch (Throwable unused) {
                        return;
                    }
                } else {
                    jSONObject = null;
                }
                FifoQueue<PTYApplogEvent> fifoQueue = this.cache;
                if (fifoQueue != null) {
                    fifoQueue.add(new PTYApplogEvent(eventName, jSONObject, PTYApplogEventType.COLD_START));
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public final void storeCache(PTYApplogImplCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Log.i(this.TAG, "storeCache size : " + cacheSize() + ' ');
        synchronized (this) {
            this.stoped = true;
            if (cacheSize() == 0) {
                return;
            }
            FifoQueue<PTYApplogEvent> fifoQueue = this.cache;
            Intrinsics.checkNotNull(fifoQueue);
            Iterator<PTYApplogEvent> it = fifoQueue.iterator();
            while (it.hasNext()) {
                callback.onEvent(it.next());
            }
            FifoQueue<PTYApplogEvent> fifoQueue2 = this.cache;
            if (fifoQueue2 != null) {
                fifoQueue2.clear();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final int cacheSize() {
        int size;
        synchronized (this) {
            FifoQueue<PTYApplogEvent> fifoQueue = this.cache;
            size = fifoQueue != null ? fifoQueue.size() : 0;
        }
        return size;
    }

    private final Set<String> stringToSet(String str) {
        List split$default = str != null ? StringsKt.split$default(str, new String[]{","}, false, 0, 6, (Object) null) : null;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = false;
        if (split$default != null && (!split$default.isEmpty())) {
            z = true;
        }
        if (z) {
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                linkedHashSet.add((String) it.next());
            }
        }
        return linkedHashSet;
    }

    @Override // com.bytedance.pitaya.api.feature.IPTYEventVerify
    public boolean isValidEvent(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        return !(eventName.length() == 0) && this.init && this.filterSet.size() > 0 && this.filterSet.contains(eventName);
    }
}
