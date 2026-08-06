package com.bytedance.pitaya.api.feature;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IKVStore.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0003H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000eH&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u0003H&J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H&J\u0016\u0010\u0018\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H&J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0014H&J\u0016\u0010\u001c\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/pitaya/api/feature/IKVStore;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "aid", "", "getAid", "()Ljava/lang/String;", "businessName", "getBusinessName", "inMemory", "", "getInMemory", "()Z", "append", "data", "Lorg/json/JSONObject;", "contain", "key", "getCacheWithTryLock", "getKVData", "getValueForKey", "", "getValueForKeys", "keys", "", "removeKeys", "setKVData", "setValueForKey", "value", "tryGetValuesForRequest", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public interface IKVStore extends ReflectionCall {
    boolean append(JSONObject data);

    boolean contain(String key);

    String getAid();

    String getBusinessName();

    JSONObject getCacheWithTryLock();

    boolean getInMemory();

    JSONObject getKVData();

    Object getValueForKey(String key);

    JSONObject getValueForKeys(List<String> keys);

    boolean removeKeys(List<String> keys);

    boolean setKVData(JSONObject data);

    boolean setValueForKey(String key, Object value);

    String tryGetValuesForRequest(List<String> keys);
}
