package com.bytedance.android.monitorV2.hybridSetting.localcache;

import android.os.Parcel;
import android.text.TextUtils;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfoAdapter;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingResponse;
import com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfig;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ConvertUtil;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LocalHybridSettingManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0012H\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0012H\u0003J\u001c\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0018\u001a\u00020\u0012H\u0003J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010\u0018\u001a\u00020\u0012H\u0003J?\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!2\u0006\u0010\u0018\u001a\u00020\u00122!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u0002H!0#H\u0083\b¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u001aH\u0003J\u001c\u0010+\u001a\u00020\u00122\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001cH\u0003J\b\u0010-\u001a\u00020\u0016H\u0007J\b\u0010.\u001a\u00020\u001aH\u0007J\b\u0010/\u001a\u00020\u001dH\u0007J\u0014\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fH\u0007J\b\u00102\u001a\u00020\u0014H\u0007J\b\u00103\u001a\u00020\u0014H\u0007J\b\u00104\u001a\u000205H\u0007J\b\u00106\u001a\u00020\u0014H\u0007J\u0016\u00107\u001a\u00020\u00122\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fH\u0003J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0010H\u0007J\u0018\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0004H\u0007JT\u0010@\u001a\u00020\u0012\"\u0004\b\u0000\u0010!2\u0006\u0010A\u001a\u0002H!26\u0010\"\u001a2\u0012\u0013\u0012\u00110$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H!¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020:0BH\u0083\b¢\u0006\u0002\u0010CR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/localcache/LocalHybridSettingManager;", "", "()V", "KEY_BID_INFO", "", "KEY_CHECK_FILTER", "KEY_DATA", "KEY_DURATION", "KEY_ENABLE_SWITCH", "KEY_ERRNO", "KEY_EVENT_SAMPLE", "KEY_HOST_LIST", "KEY_LAST_FETCH_TIME", "KEY_SETTING_ID", "KEY_UPDATE_TIME", "localCache", "Lcom/bytedance/android/monitorV2/hybridSetting/localcache/ILocalCacheAdapter;", "bidInfo2Bytes", "", "settingId", "", "bidInfo", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo;", "bytes2BidInfo", "byteArray", "bytes2CheckFilter", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/CheckFilter;", "bytes2EventSample", "", "", "bytes2HostList", "", "bytes2ValueWrapper", "T", "block", "Lkotlin/Function1;", "Landroid/os/Parcel;", "Lkotlin/ParameterName;", "name", "parcel", "([BLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "checkFilter2Bytes", "checkFilter", "eventSample2Bytes", "eventSample", "getBidInfo", "getCheckFilter", "getDuration", "getEventSample", "getHostList", "getLastFetchTime", "getSettingId", "getSwitchConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfig;", "getUpdateTime", "hostList2Bytes", "hostList", "setLocalCacheAdapter", "", "localCacheAdapter", "updateSetting", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/HybridSettingResponse;", "settingStr", "deviceId", "value2BytesWrapper", "value", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)[B", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LocalHybridSettingManager {
    public static final LocalHybridSettingManager INSTANCE = new LocalHybridSettingManager();
    private static final String KEY_BID_INFO = "bid_info";
    private static final String KEY_CHECK_FILTER = "check_filter";
    private static final String KEY_DATA = "data";
    private static final String KEY_DURATION = "duration";
    private static final String KEY_ENABLE_SWITCH = "enable_switch";
    private static final String KEY_ERRNO = "errno";
    private static final String KEY_EVENT_SAMPLE = "all_event_sample";
    private static final String KEY_HOST_LIST = "host_list";
    private static final String KEY_LAST_FETCH_TIME = "last_fetch_time";
    private static final String KEY_SETTING_ID = "setting_id";
    private static final String KEY_UPDATE_TIME = "update_time";
    private static ILocalCacheAdapter localCache;

    private LocalHybridSettingManager() {
    }

    @JvmStatic
    public static final void setLocalCacheAdapter(ILocalCacheAdapter localCacheAdapter) {
        Intrinsics.checkNotNullParameter(localCacheAdapter, "localCacheAdapter");
        localCache = localCacheAdapter;
    }

    @JvmStatic
    public static final HybridSettingResponse updateSetting(String settingStr, String deviceId) {
        Intrinsics.checkNotNullParameter(settingStr, "settingStr");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        HybridSettingResponse hybridSettingResponse = new HybridSettingResponse();
        ILocalCacheAdapter iLocalCacheAdapter = localCache;
        if (iLocalCacheAdapter != null) {
            try {
                JSONObject jSONObject = new JSONObject(settingStr);
                if (!(200 == JsonUtils.safeOptInt(jSONObject, KEY_ERRNO) && jSONObject.has("data"))) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    Object obj = jSONObject.get("data");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject2 = (JSONObject) obj;
                    SwitchConfig switchConfig = ConvertUtil.toSwitchConfig(JsonUtils.safeOptLong(jSONObject2, KEY_ENABLE_SWITCH));
                    Intrinsics.checkNotNullExpressionValue(switchConfig, "toSwitchConfig(JsonUtils…data, KEY_ENABLE_SWITCH))");
                    hybridSettingResponse.switchConfig = switchConfig;
                    hybridSettingResponse.updateTime = JsonUtils.safeOptLong(jSONObject2, KEY_UPDATE_TIME);
                    hybridSettingResponse.duration = JsonUtils.safeOptInt(jSONObject2, "duration");
                    hybridSettingResponse.settingId = JsonUtils.safeOptLong(jSONObject2, "setting_id");
                    Map<String, Integer> eventSampleMap = ConvertUtil.toEventSampleMap(JsonUtils.safeOptJsonObj(jSONObject2, KEY_EVENT_SAMPLE));
                    Intrinsics.checkNotNullExpressionValue(eventSampleMap, "toEventSampleMap(JsonUti…(data, KEY_EVENT_SAMPLE))");
                    hybridSettingResponse.allEventSample = eventSampleMap;
                    Set<String> hostWhiteSet = ConvertUtil.toHostWhiteSet(JsonUtils.safeOptJsonArray(jSONObject2, KEY_HOST_LIST));
                    Intrinsics.checkNotNullExpressionValue(hostWhiteSet, "toHostWhiteSet(JsonUtils…ray(data, KEY_HOST_LIST))");
                    hybridSettingResponse.hostWhiteSet = hostWhiteSet;
                    CheckFilter checkFilter = ConvertUtil.toCheckFilter(JsonUtils.safeOptJsonObj(jSONObject2, KEY_CHECK_FILTER));
                    Intrinsics.checkNotNullExpressionValue(checkFilter, "toCheckFilter(JsonUtils.…(data, KEY_CHECK_FILTER))");
                    hybridSettingResponse.checkFilter = checkFilter;
                    BidInfo bidInfo = ConvertUtil.toBidInfo(JsonUtils.safeOptJsonObj(jSONObject2, "bid_info"), hybridSettingResponse.settingId, true);
                    Intrinsics.checkNotNullExpressionValue(bidInfo, "toBidInfo(JsonUtils.safe…D_INFO), settingId, true)");
                    hybridSettingResponse.bidInfo = bidInfo;
                    iLocalCacheAdapter.clear();
                    iLocalCacheAdapter.putLong(KEY_ENABLE_SWITCH, hybridSettingResponse.switchConfig.mConfig);
                    iLocalCacheAdapter.putLong(KEY_UPDATE_TIME, hybridSettingResponse.updateTime);
                    iLocalCacheAdapter.putInt("duration", hybridSettingResponse.duration);
                    iLocalCacheAdapter.putLong("setting_id", hybridSettingResponse.settingId);
                    iLocalCacheAdapter.putBytes(KEY_EVENT_SAMPLE, eventSample2Bytes(hybridSettingResponse.allEventSample));
                    iLocalCacheAdapter.putBytes(KEY_HOST_LIST, hostList2Bytes(hybridSettingResponse.hostWhiteSet));
                    iLocalCacheAdapter.putBytes(KEY_CHECK_FILTER, checkFilter2Bytes(hybridSettingResponse.checkFilter));
                    iLocalCacheAdapter.putBytes("bid_info", bidInfo2Bytes(hybridSettingResponse.settingId, hybridSettingResponse.bidInfo));
                    if (!TextUtils.isEmpty(deviceId) && !Intrinsics.areEqual("0", deviceId)) {
                        iLocalCacheAdapter.putLong(KEY_LAST_FETCH_TIME, System.currentTimeMillis() / 1000);
                    }
                    return hybridSettingResponse;
                }
            } catch (Throwable th) {
                MonitorLog.m27e("LocalHybridSettingManager", "updateSetting failed. " + th.getMessage());
                ExceptionUtil.handleException(th);
                Unit unit = Unit.INSTANCE;
            }
        }
        return hybridSettingResponse;
    }

    @JvmStatic
    public static final SwitchConfig getSwitchConfig() {
        ILocalCacheAdapter iLocalCacheAdapter = localCache;
        SwitchConfig switchConfig = ConvertUtil.toSwitchConfig(iLocalCacheAdapter != null ? iLocalCacheAdapter.getLong(KEY_ENABLE_SWITCH) : 0L);
        Intrinsics.checkNotNullExpressionValue(switchConfig, "toSwitchConfig(config)");
        return switchConfig;
    }

    @JvmStatic
    public static final long getUpdateTime() {
        ILocalCacheAdapter iLocalCacheAdapter = localCache;
        if (iLocalCacheAdapter != null) {
            return iLocalCacheAdapter.getLong(KEY_UPDATE_TIME);
        }
        return 0L;
    }

    @JvmStatic
    public static final int getDuration() {
        ILocalCacheAdapter iLocalCacheAdapter = localCache;
        if (iLocalCacheAdapter != null) {
            return iLocalCacheAdapter.getInt("duration");
        }
        return 0;
    }

    @JvmStatic
    public static final long getSettingId() {
        ILocalCacheAdapter iLocalCacheAdapter = localCache;
        if (iLocalCacheAdapter != null) {
            return iLocalCacheAdapter.getLong("setting_id");
        }
        return 0L;
    }

    @JvmStatic
    public static final Map<String, Integer> getEventSample() {
        byte[] bytes;
        ILocalCacheAdapter iLocalCacheAdapter = localCache;
        if (iLocalCacheAdapter != null && (bytes = iLocalCacheAdapter.getBytes(KEY_EVENT_SAMPLE)) != null) {
            return bytes2EventSample(bytes);
        }
        return new HashMap();
    }

    @JvmStatic
    public static final Set<String> getHostList() {
        byte[] bytes;
        ILocalCacheAdapter iLocalCacheAdapter = localCache;
        if (iLocalCacheAdapter != null && (bytes = iLocalCacheAdapter.getBytes(KEY_HOST_LIST)) != null) {
            return bytes2HostList(bytes);
        }
        return new HashSet();
    }

    @JvmStatic
    public static final CheckFilter getCheckFilter() {
        byte[] bytes;
        ILocalCacheAdapter iLocalCacheAdapter = localCache;
        if (iLocalCacheAdapter != null && (bytes = iLocalCacheAdapter.getBytes(KEY_CHECK_FILTER)) != null) {
            return bytes2CheckFilter(bytes);
        }
        return new CheckFilter(null, null, null, 7, null);
    }

    @JvmStatic
    public static final BidInfo getBidInfo() {
        byte[] bytes;
        ILocalCacheAdapter iLocalCacheAdapter = localCache;
        if (iLocalCacheAdapter != null && (bytes = iLocalCacheAdapter.getBytes("bid_info")) != null) {
            return bytes2BidInfo(bytes);
        }
        return new BidInfo();
    }

    @JvmStatic
    public static final long getLastFetchTime() {
        ILocalCacheAdapter iLocalCacheAdapter = localCache;
        if (iLocalCacheAdapter != null) {
            return iLocalCacheAdapter.getLong(KEY_LAST_FETCH_TIME);
        }
        return 0L;
    }

    @JvmStatic
    private static final <T> byte[] value2BytesWrapper(T value, Function2<? super Parcel, ? super T, Unit> block) {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        try {
            obtain.setDataPosition(0);
            block.invoke(obtain, value);
            byte[] marshall = obtain.marshall();
            Intrinsics.checkNotNullExpressionValue(marshall, "parcel.marshall()");
            return marshall;
        } finally {
            InlineMarker.finallyStart(1);
            obtain.recycle();
            InlineMarker.finallyEnd(1);
        }
    }

    @JvmStatic
    private static final <T> T bytes2ValueWrapper(byte[] byteArray, Function1<? super Parcel, ? extends T> block) {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        try {
            obtain.unmarshall(byteArray, 0, byteArray.length);
            obtain.setDataPosition(0);
            return (T) block.invoke(obtain);
        } finally {
            InlineMarker.finallyStart(1);
            obtain.recycle();
            InlineMarker.finallyEnd(1);
        }
    }

    @JvmStatic
    private static final byte[] eventSample2Bytes(Map<String, Integer> eventSample) {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        try {
            obtain.setDataPosition(0);
            int size = eventSample.size();
            obtain.writeInt(size);
            if (size > 0) {
                Iterator<T> it = eventSample.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    obtain.writeString((String) entry.getKey());
                    obtain.writeInt(((Number) entry.getValue()).intValue());
                }
            }
            byte[] marshall = obtain.marshall();
            Intrinsics.checkNotNullExpressionValue(marshall, "parcel.marshall()");
            return marshall;
        } finally {
            obtain.recycle();
        }
    }

    @JvmStatic
    private static final Map<String, Integer> bytes2EventSample(byte[] byteArray) {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        try {
            obtain.unmarshall(byteArray, 0, byteArray.length);
            obtain.setDataPosition(0);
            HashMap hashMap = new HashMap();
            int readInt = obtain.readInt();
            if (readInt > 0) {
                for (int i = 0; i < readInt; i++) {
                    String readString = obtain.readString();
                    Intrinsics.checkNotNull(readString);
                    hashMap.put(readString, Integer.valueOf(obtain.readInt()));
                }
            }
            obtain.recycle();
            return hashMap;
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    @JvmStatic
    private static final byte[] hostList2Bytes(Set<String> hostList) {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        try {
            obtain.setDataPosition(0);
            int size = hostList.size();
            obtain.writeInt(size);
            if (size > 0) {
                Iterator<T> it = hostList.iterator();
                while (it.hasNext()) {
                    obtain.writeString((String) it.next());
                }
            }
            byte[] marshall = obtain.marshall();
            Intrinsics.checkNotNullExpressionValue(marshall, "parcel.marshall()");
            return marshall;
        } finally {
            obtain.recycle();
        }
    }

    @JvmStatic
    private static final Set<String> bytes2HostList(byte[] byteArray) {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        try {
            obtain.unmarshall(byteArray, 0, byteArray.length);
            obtain.setDataPosition(0);
            HashSet hashSet = new HashSet();
            if (obtain.readInt() > 0) {
                String readString = obtain.readString();
                Intrinsics.checkNotNull(readString);
                hashSet.add(readString);
            }
            obtain.recycle();
            return hashSet;
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    @JvmStatic
    private static final byte[] checkFilter2Bytes(CheckFilter checkFilter) {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        try {
            obtain.setDataPosition(0);
            checkFilter.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            Intrinsics.checkNotNullExpressionValue(marshall, "parcel.marshall()");
            return marshall;
        } finally {
            obtain.recycle();
        }
    }

    @JvmStatic
    private static final CheckFilter bytes2CheckFilter(byte[] byteArray) {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        try {
            obtain.unmarshall(byteArray, 0, byteArray.length);
            obtain.setDataPosition(0);
            CheckFilter createFromParcel = CheckFilter.CREATOR.createFromParcel(obtain);
            obtain.recycle();
            Intrinsics.checkNotNullExpressionValue(createFromParcel, "bytes2ValueWrapper(byteA…mParcel(parcel)\n        }");
            return createFromParcel;
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    @JvmStatic
    private static final byte[] bidInfo2Bytes(long settingId, BidInfo bidInfo) {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        try {
            obtain.setDataPosition(0);
            BidInfoAdapter.INSTANCE.adapter2BidInfoAdapter(settingId, bidInfo).writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            Intrinsics.checkNotNullExpressionValue(marshall, "parcel.marshall()");
            return marshall;
        } finally {
            obtain.recycle();
        }
    }

    @JvmStatic
    private static final BidInfo bytes2BidInfo(byte[] byteArray) {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        try {
            obtain.unmarshall(byteArray, 0, byteArray.length);
            obtain.setDataPosition(0);
            return BidInfoAdapter.CREATOR.createFromParcel(obtain).adapter2BidInfo();
        } finally {
            obtain.recycle();
        }
    }
}
