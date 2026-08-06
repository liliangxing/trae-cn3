package com.bytedance.platform.settingsx.map;

import androidx.core.util.Pair;
import com.bytedance.platform.settingsx.api.internal.ProtoUtils;
import com.bytedance.platform.settingsx.api.map.MappedData;
import com.bytedance.platform.settingsx.map.MappedLeafData;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DataMapManager {
    static final String SEPARATOR = ">";
    private static final String TAG = "DataMapManager";
    private static final int TYPE_BRANCH = 1;
    private static final int TYPE_LEAF = 2;

    public static Pair<Map<Integer, List<MappedData>>, Map<Integer, Set<String>>> convert(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        traverseJsonTree(jSONObject, "", hashMap, hashMap2);
        return new Pair<>(hashMap, hashMap2);
    }

    private static void traverseJsonTree(Object obj, String str, Map<Integer, List<MappedData>> map, Map<Integer, Set<String>> map2) {
        if (obj != null && (obj instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                String str2 = str + SEPARATOR + next;
                int hashCode = str2.hashCode();
                Set<String> set = map2.get(Integer.valueOf(hashCode));
                if (set == null) {
                    set = new HashSet<>();
                    map2.put(Integer.valueOf(hashCode), set);
                }
                set.add(str2);
                List<MappedData> list = map.get(Integer.valueOf(hashCode));
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(Integer.valueOf(hashCode), list);
                }
                if (opt instanceof Boolean) {
                    list.add(new MappedLeafData(hashCode, next, opt, MappedLeafData.Type.BOOLEAN));
                } else if ((opt instanceof Byte) || (opt instanceof Character) || (opt instanceof Integer) || (opt instanceof Short)) {
                    list.add(new MappedLeafData(hashCode, next, opt, MappedLeafData.Type.INT));
                } else if (opt instanceof Long) {
                    list.add(new MappedLeafData(hashCode, next, opt, MappedLeafData.Type.LONG));
                } else if (opt instanceof Float) {
                    list.add(new MappedLeafData(hashCode, next, opt, MappedLeafData.Type.FLOAT));
                } else if (opt instanceof Double) {
                    list.add(new MappedLeafData(hashCode, next, opt, MappedLeafData.Type.DOUBLE));
                } else if (opt instanceof String) {
                    list.add(new MappedLeafData(hashCode, next, opt, MappedLeafData.Type.STRING));
                } else if (opt instanceof JSONArray) {
                    list.add(new MappedLeafData(hashCode, next, opt, MappedLeafData.Type.ARRAY));
                } else if (opt instanceof JSONObject) {
                    if (MapCacheIndex.needCache(hashCode)) {
                        list.add(new MappedLeafData(hashCode, next, opt, MappedLeafData.Type.MAP));
                    } else {
                        traverseJsonTree(opt, str2, map, map2);
                    }
                }
            }
        }
    }

    public static void writeMappedData(CodedOutputStream codedOutputStream, List<MappedData> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            codedOutputStream.writeInt32NoTag(list.size());
            for (MappedData mappedData : list) {
                if (mappedData instanceof MappedLeafData) {
                    codedOutputStream.writeRawByte(2);
                    codedOutputStream.writeStringNoTag(mappedData.getName());
                    codedOutputStream.writeRawByte(((MappedLeafData) mappedData).getType().ordinal());
                    Object value = ((MappedLeafData) mappedData).getValue();
                    switch (C04841.f79x2d0dfd57[((MappedLeafData) mappedData).getType().ordinal()]) {
                        case 1:
                            codedOutputStream.writeBoolNoTag(((Boolean) value).booleanValue());
                            break;
                        case 2:
                            codedOutputStream.writeInt32NoTag(((Integer) value).intValue());
                            break;
                        case 3:
                            codedOutputStream.writeInt64NoTag(((Long) value).longValue());
                            break;
                        case 4:
                            codedOutputStream.writeFloatNoTag(((Float) value).floatValue());
                            break;
                        case 5:
                            codedOutputStream.writeDoubleNoTag(((Double) value).doubleValue());
                            break;
                        case 6:
                        case 7:
                        case 8:
                            codedOutputStream.writeStringNoTag(toNonNullString(value));
                            break;
                        default:
                            codedOutputStream.writeStringNoTag("");
                            break;
                    }
                } else if (mappedData instanceof MappedBranchData) {
                    boolean z = true;
                    codedOutputStream.writeRawByte(1);
                    codedOutputStream.writeStringNoTag(mappedData.getName());
                    if (((MappedBranchData) mappedData).getValue() == null) {
                        z = false;
                    }
                    codedOutputStream.writeBoolNoTag(z);
                    if (z) {
                        codedOutputStream.writeStringNoTag(((MappedBranchData) mappedData).getValue());
                    }
                    ProtoUtils.writeIntListToProto(codedOutputStream, ((MappedBranchData) mappedData).getChildrenHashPtr());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.bytedance.platform.settingsx.map.DataMapManager$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static /* synthetic */ class C04841 {

        /* renamed from: $SwitchMap$com$bytedance$platform$settingsx$map$MappedLeafData$Type */
        static final /* synthetic */ int[] f79x2d0dfd57;

        static {
            int[] iArr = new int[MappedLeafData.Type.values().length];
            f79x2d0dfd57 = iArr;
            try {
                iArr[MappedLeafData.Type.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f79x2d0dfd57[MappedLeafData.Type.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f79x2d0dfd57[MappedLeafData.Type.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f79x2d0dfd57[MappedLeafData.Type.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f79x2d0dfd57[MappedLeafData.Type.DOUBLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f79x2d0dfd57[MappedLeafData.Type.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f79x2d0dfd57[MappedLeafData.Type.MAP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f79x2d0dfd57[MappedLeafData.Type.ARRAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private static String toNonNullString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static List<MappedData> readMappedData(int i, CodedInputStream codedInputStream) {
        Object valueOf;
        try {
            int readInt32 = codedInputStream.readInt32();
            ArrayList arrayList = new ArrayList(readInt32);
            for (int i2 = 0; i2 < readInt32; i2++) {
                byte readRawByte = codedInputStream.readRawByte();
                if (readRawByte == 2) {
                    String readString = codedInputStream.readString();
                    MappedLeafData.Type type = MappedLeafData.Type.getType(codedInputStream.readRawByte());
                    switch (C04841.f79x2d0dfd57[type.ordinal()]) {
                        case 1:
                            valueOf = Boolean.valueOf(codedInputStream.readBool());
                            break;
                        case 2:
                            valueOf = Integer.valueOf(codedInputStream.readInt32());
                            break;
                        case 3:
                            valueOf = Long.valueOf(codedInputStream.readInt64());
                            break;
                        case 4:
                            valueOf = Float.valueOf(codedInputStream.readFloat());
                            break;
                        case 5:
                            valueOf = Double.valueOf(codedInputStream.readDouble());
                            break;
                        case 6:
                        default:
                            valueOf = codedInputStream.readString();
                            break;
                        case 7:
                            valueOf = new JSONObject(codedInputStream.readString());
                            break;
                        case 8:
                            valueOf = new JSONArray(codedInputStream.readString());
                            break;
                    }
                    arrayList.add(new MappedLeafData(i, readString, valueOf, type));
                } else if (readRawByte == 1) {
                    arrayList.add(MappedBranchData.getInstance(i, codedInputStream.readString(), codedInputStream.readBool() ? codedInputStream.readString() : null, ProtoUtils.readProtoToIntList(codedInputStream)));
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MappedLeafData.Type getObjectType(Object obj) {
        if ((obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Integer) || (obj instanceof Short)) {
            return MappedLeafData.Type.INT;
        }
        if (obj instanceof Long) {
            return MappedLeafData.Type.LONG;
        }
        if (obj instanceof Float) {
            return MappedLeafData.Type.FLOAT;
        }
        if (obj instanceof Double) {
            return MappedLeafData.Type.DOUBLE;
        }
        if (obj instanceof Boolean) {
            return MappedLeafData.Type.BOOLEAN;
        }
        if (obj instanceof String) {
            return MappedLeafData.Type.STRING;
        }
        return MappedLeafData.Type.STRING;
    }
}
