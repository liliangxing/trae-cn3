package com.bytedance.platform.settingsx.storage;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.platform.settingsx.api.GlobalConfig;
import com.bytedance.platform.settingsx.api.map.MappedData;
import com.bytedance.platform.settingsx.api.storage.HashBlockIndex;
import com.bytedance.platform.settingsx.api.storage.IBlock;
import com.bytedance.platform.settingsx.api.storage.IBlockIndex;
import com.bytedance.platform.settingsx.convert.ConvertUtils;
import com.bytedance.platform.settingsx.map.FixedKeyIndex;
import com.bytedance.platform.settingsx.map.MappedLeafData;
import com.bytedance.push.utils.RomVersionParamHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class Storage {
    private static final String KEY_LOCAL_APP_SETTINGS_DATA = "key_local_app_settings_data";
    public static final String SETTINGSX_SUFFIX = ".sx";
    private static final String TAG = "Storage";
    private JSONObject allAppSettingsJson;
    private final Map<Integer, Future<IBlock>> loadedBlockIndex = new ConcurrentHashMap();
    private final Object lock = new Object();
    private IBlockIndex mBlockIndex;
    private String mSettingsId;
    private SharedPreferences mSharedP;
    private String namePrefix;
    private Map<Integer, Set<String>> settingsKeyPathIndex;
    private StorageType storageType;
    private static final AtomicInteger GENERATOR = new AtomicInteger();
    private static ExecutorService scheduler = Executors.newSingleThreadExecutor();

    public Storage(StorageType storageType) {
        this.storageType = storageType;
    }

    public void init(String str, int i, String str2) {
        this.namePrefix = str;
        this.mSettingsId = str2;
        this.mBlockIndex = new HashBlockIndex(i + 1);
        for (int i2 = 0; i2 < i; i2++) {
            loadBlock(i2);
        }
        this.mSharedP = GlobalConfig.getSp().getSharedPreferences(GlobalConfig.getContext(), "__local_settings_data.sp", 0);
    }

    public Integer getInt(int i, String str, int i2, boolean z) {
        try {
            Object valueFromStorage = getValueFromStorage(i, str, i2);
            if (valueFromStorage == null && z) {
                valueFromStorage = getValueFromAllData(i, str);
            }
            if (valueFromStorage != null) {
                return (Integer) valueFromStorage;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void putInt(int i, String str, Integer num, int i2) {
        putObject(i, str, num, i2, MappedLeafData.Type.INT);
    }

    public Long getLong(int i, String str, int i2, boolean z) {
        try {
            Object valueFromStorage = getValueFromStorage(i, str, i2);
            if (valueFromStorage == null && z) {
                valueFromStorage = getValueFromAllData(i, str);
            }
            if (valueFromStorage == null) {
                return null;
            }
            if (valueFromStorage instanceof Integer) {
                return Long.valueOf(((Integer) valueFromStorage).longValue());
            }
            return (Long) valueFromStorage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void putLong(int i, String str, Long l, int i2) {
        putObject(i, str, l, i2, MappedLeafData.Type.LONG);
    }

    public Float getFloat(int i, String str, int i2, boolean z) {
        try {
            Object valueFromStorage = getValueFromStorage(i, str, i2);
            if (valueFromStorage == null && z) {
                valueFromStorage = getValueFromAllData(i, str);
            }
            if (valueFromStorage == null) {
                return null;
            }
            if (valueFromStorage instanceof Double) {
                return Float.valueOf(((Double) valueFromStorage).floatValue());
            }
            return (Float) valueFromStorage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void putFloat(int i, String str, Float f, int i2) {
        putObject(i, str, f, i2, MappedLeafData.Type.FLOAT);
    }

    public Double getDouble(int i, String str, int i2, boolean z) {
        try {
            Object valueFromStorage = getValueFromStorage(i, str, i2);
            if (valueFromStorage == null && z) {
                valueFromStorage = getValueFromAllData(i, str);
            }
            if (valueFromStorage == null) {
                return null;
            }
            if (valueFromStorage instanceof Float) {
                return Double.valueOf(((Float) valueFromStorage).doubleValue());
            }
            return (Double) valueFromStorage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void putDouble(int i, String str, Double d, int i2) {
        putObject(i, str, d, i2, MappedLeafData.Type.DOUBLE);
    }

    public Boolean getBoolean(int i, String str, int i2, boolean z) {
        try {
            Object valueFromStorage = getValueFromStorage(i, str, i2);
            if (valueFromStorage == null && z) {
                valueFromStorage = getValueFromAllData(i, str);
            }
            if (valueFromStorage == null) {
                return null;
            }
            if (valueFromStorage instanceof CharSequence) {
                return Boolean.valueOf(ConvertUtils.convertValueToBoolean((CharSequence) valueFromStorage, false));
            }
            return (Boolean) valueFromStorage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void putBoolean(int i, String str, Boolean bool, int i2) {
        putObject(i, str, bool, i2, MappedLeafData.Type.BOOLEAN);
    }

    public JSONObject getJsonObject(int i, String str, int i2, boolean z) {
        try {
            Object valueFromStorage = getValueFromStorage(i, str, i2);
            if (valueFromStorage == null && z) {
                valueFromStorage = getValueFromAllData(i, str);
            }
            if (valueFromStorage != null) {
                return (JSONObject) valueFromStorage;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void putJsonObject(int i, String str, JSONObject jSONObject, int i2) {
        putObject(i, str, jSONObject, i2, MappedLeafData.Type.MAP);
    }

    public JSONArray getJsonArray(int i, String str, int i2, boolean z) {
        try {
            Object valueFromStorage = getValueFromStorage(i, str, i2);
            if (valueFromStorage == null && z) {
                valueFromStorage = getValueFromAllData(i, str);
            }
            if (valueFromStorage != null) {
                return (JSONArray) valueFromStorage;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void putJsonArray(int i, String str, JSONArray jSONArray, int i2) {
        putObject(i, str, jSONArray, i2, MappedLeafData.Type.ARRAY);
    }

    public String getString(int i, String str, int i2, boolean z) {
        Object valueFromStorage = getValueFromStorage(i, str, i2);
        if (valueFromStorage == null && z) {
            valueFromStorage = getValueFromAllData(i, str);
        }
        if (valueFromStorage != null) {
            return valueFromStorage.toString();
        }
        return null;
    }

    public void putString(int i, String str, String str2, int i2) {
        putObject(i, str, str2, i2, MappedLeafData.Type.STRING);
    }

    private void putObject(int i, String str, Object obj, int i2, MappedLeafData.Type type) {
        if (this.storageType == StorageType.APP_SETTINGS) {
            throw new RuntimeException("server settings disallow put data by local");
        }
        IBlock hashBlock = getHashBlock(i);
        if (hashBlock != null) {
            List<MappedData> object = hashBlock.getObject(i, null);
            object.add(new MappedLeafData(i, str, obj, type));
            hashBlock.putObject(i, object);
            hashBlock.sync();
        }
        IBlock forceBlock = getForceBlock(i2);
        if (i2 <= -1 || forceBlock == null || forceBlock == hashBlock) {
            return;
        }
        List<MappedData> object2 = forceBlock.getObject(i, null);
        object2.add(new MappedLeafData(i, str, obj, type));
        forceBlock.putObject(i, object2);
        forceBlock.sync();
    }

    public boolean contains(int i, String str, int i2) {
        return getValueFromStorage(i, str, i2) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object getValueFromStorage(int i, String str, int i2) {
        List<MappedData> list;
        if (i2 > -1) {
            if (this.storageType == StorageType.APP_SETTINGS) {
                FixedKeyIndex.record(i, i2);
            }
            IBlock forceBlock = getForceBlock(i2);
            if (forceBlock != null) {
                list = forceBlock.getObject(i, null);
                if (list != null || list.isEmpty()) {
                    list = getHashBlock(i).getObject(i, null);
                }
                if (list != null) {
                    for (MappedData mappedData : list) {
                        if ((mappedData instanceof MappedLeafData) && TextUtils.equals(mappedData.getName(), str)) {
                            return ((MappedLeafData) mappedData).getValue();
                        }
                    }
                }
                return null;
            }
        }
        list = null;
        if (list != null) {
        }
        list = getHashBlock(i).getObject(i, null);
        if (list != null) {
        }
        return null;
    }

    public void update(Map<Integer, List<MappedData>> map, Map<Integer, Set<String>> map2, JSONObject jSONObject) {
        if (this.storageType == StorageType.LOCAL_SETTINGS) {
            throw new RuntimeException("local settings disallow call update func");
        }
        syncAllToBlock(map);
        recordPathIndex(map2);
    }

    private void recordPathIndex(final Map<Integer, Set<String>> map) {
        this.settingsKeyPathIndex = map;
        GlobalConfig.getIOWritePool().execute(new Runnable() { // from class: com.bytedance.platform.settingsx.storage.Storage.1
            @Override // java.lang.Runnable
            public void run() {
                Storage.this.getPathIndexSp().edit().putString("path_map", new JSONObject(map).toString()).apply();
            }
        });
    }

    private JSONObject getAllAppSettings() {
        if (this.allAppSettingsJson == null) {
            synchronized (this.lock) {
                if (this.allAppSettingsJson == null) {
                    String string = this.mSharedP.getString(convertKey(KEY_LOCAL_APP_SETTINGS_DATA, this.mSettingsId), "");
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            this.allAppSettingsJson = new JSONObject(string);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return this.allAppSettingsJson;
    }

    private static String convertKey(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str + RomVersionParamHelper.SEPARATOR + str2;
    }

    public Object getValueFromAllData(int i, String str) {
        Set<String> set = getPathIndex().get(Integer.valueOf(i));
        if (set == null || set.size() <= 0) {
            return null;
        }
        JSONObject allAppSettings = getAllAppSettings();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String[] split = it.next().split(">");
            if (split != null && split.length > 0) {
                Object obj = allAppSettings;
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (obj instanceof JSONObject) {
                        obj = ((JSONObject) obj).opt(split[i2]);
                        if (i2 + 1 == split.length && TextUtils.equals(str, split[i2])) {
                            FixedKeyIndex.record(i, this.mBlockIndex.getBlockIndexByKey(i).intValue());
                            return obj;
                        }
                    }
                }
            }
        }
        return null;
    }

    private Map<Integer, Set<String>> getPathIndex() {
        if (this.settingsKeyPathIndex == null) {
            synchronized (this.lock) {
                if (this.settingsKeyPathIndex == null) {
                    String string = getPathIndexSp().getString("path_map", "{}");
                    HashMap hashMap = new HashMap();
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray = jSONObject.optJSONArray(next);
                            if (optJSONArray != null) {
                                HashSet hashSet = new HashSet();
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    hashSet.add(optJSONArray.optString(i));
                                }
                                hashMap.put(Integer.valueOf(Integer.parseInt(next)), hashSet);
                            } else {
                                hashMap.put(Integer.valueOf(Integer.parseInt(next)), null);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    this.settingsKeyPathIndex = hashMap;
                }
            }
        }
        return this.settingsKeyPathIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences getPathIndexSp() {
        return GlobalConfig.getSp().getSharedPreferences(GlobalConfig.getContext(), this.namePrefix + "settingsx_key_path", 0);
    }

    private IBlock getHashBlock(int i) {
        Integer blockIndexByKey = this.mBlockIndex.getBlockIndexByKey(i);
        if (blockIndexByKey != null) {
            return getBlockByIndex(blockIndexByKey);
        }
        return null;
    }

    private IBlock getForceBlock(int i) {
        Integer valueOf = i >= 0 ? Integer.valueOf(i) : null;
        if (valueOf != null) {
            return getBlockByIndex(valueOf);
        }
        return null;
    }

    private IBlock getBlockByIndex(Integer num) {
        try {
            return loadBlock(num.intValue()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private List<IBlock> getAllBlock() {
        Collection<Future<IBlock>> values = this.loadedBlockIndex.values();
        ArrayList arrayList = new ArrayList();
        Iterator<Future<IBlock>> it = values.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    private Future<IBlock> loadBlock(final int i) {
        Future<IBlock> future = this.loadedBlockIndex.get(Integer.valueOf(i));
        if (future == null) {
            synchronized (this.loadedBlockIndex) {
                future = this.loadedBlockIndex.get(Integer.valueOf(i));
                if (future == null) {
                    future = GlobalConfig.getIOReadPool().submit(new Callable() { // from class: com.bytedance.platform.settingsx.storage.Storage$$ExternalSyntheticLambda0
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return Storage.this.m229xd22cf773(i);
                        }
                    });
                    this.loadedBlockIndex.put(Integer.valueOf(i), future);
                }
            }
        }
        return future;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: newBlock, reason: merged with bridge method [inline-methods] */
    public IBlock m229xd22cf773(int i) {
        return GlobalConfig.getBlockCreator().create(this.namePrefix + i + SETTINGSX_SUFFIX);
    }

    private void syncAllToBlock(Map<Integer, List<MappedData>> map) {
        for (Map.Entry<Integer, List<MappedData>> entry : map.entrySet()) {
            int intValue = entry.getKey().intValue();
            List<MappedData> value = entry.getValue();
            IBlock hashBlock = getHashBlock(intValue);
            if (hashBlock != null) {
                hashBlock.putObject(intValue, value);
            }
            int blockIndex = FixedKeyIndex.getBlockIndex(intValue);
            IBlock forceBlock = getForceBlock(blockIndex);
            if (blockIndex > -1 && forceBlock != null && forceBlock != hashBlock) {
                forceBlock.putObject(intValue, value);
            }
        }
        Iterator<IBlock> it = getAllBlock().iterator();
        while (it.hasNext()) {
            it.next().sync();
        }
    }
}
