package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;
import com.bytedance.platform.settingsx.internal.InstanceCache;
import com.bytedance.platform.settingsx.internal.InstanceCreator;
import com.bytedance.platform.settingsx.internal.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ConvertFactory {
    public static ITypeConverter get(Class<?> cls) {
        if (Integer.class.isAssignableFrom(cls)) {
            return (ITypeConverter) InstanceCache.obtain(Int2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda12
                @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                public final Object create(Class cls2) {
                    return ConvertFactory.lambda$get$0(cls2);
                }
            });
        }
        if (Boolean.class.isAssignableFrom(cls)) {
            return (ITypeConverter) InstanceCache.obtain(Boolean2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda13
                @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                public final Object create(Class cls2) {
                    return ConvertFactory.lambda$get$1(cls2);
                }
            });
        }
        if (Float.class.isAssignableFrom(cls)) {
            return (ITypeConverter) InstanceCache.obtain(Float2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda14
                @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                public final Object create(Class cls2) {
                    return ConvertFactory.lambda$get$2(cls2);
                }
            });
        }
        if (Double.class.isAssignableFrom(cls)) {
            return (ITypeConverter) InstanceCache.obtain(Double2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda15
                @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                public final Object create(Class cls2) {
                    return ConvertFactory.lambda$get$3(cls2);
                }
            });
        }
        if (Long.class.isAssignableFrom(cls)) {
            return (ITypeConverter) InstanceCache.obtain(Long2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda1
                @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                public final Object create(Class cls2) {
                    return ConvertFactory.lambda$get$4(cls2);
                }
            });
        }
        if (Integer.class.isAssignableFrom(cls)) {
            return (ITypeConverter) InstanceCache.obtain(Int2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda2
                @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                public final Object create(Class cls2) {
                    return ConvertFactory.lambda$get$5(cls2);
                }
            });
        }
        if (Short.class.isAssignableFrom(cls)) {
            return (ITypeConverter) InstanceCache.obtain(Short2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda3
                @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                public final Object create(Class cls2) {
                    return ConvertFactory.lambda$get$6(cls2);
                }
            });
        }
        if (String.class.isAssignableFrom(cls)) {
            return (ITypeConverter) InstanceCache.obtain(Str2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda4
                @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                public final Object create(Class cls2) {
                    return ConvertFactory.lambda$get$7(cls2);
                }
            });
        }
        if (JSONObject.class.isAssignableFrom(cls)) {
            return (ITypeConverter) InstanceCache.obtain(JSONObject2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda5
                @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                public final Object create(Class cls2) {
                    return ConvertFactory.lambda$get$8(cls2);
                }
            });
        }
        if (JSONArray.class.isAssignableFrom(cls)) {
            return (ITypeConverter) InstanceCache.obtain(JSONArray2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda6
                @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                public final Object create(Class cls2) {
                    return ConvertFactory.lambda$get$9(cls2);
                }
            });
        }
        throw new RuntimeException("not support convert class " + cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$0(Class cls) {
        return new Int2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$1(Class cls) {
        return new Boolean2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$2(Class cls) {
        return new Float2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$3(Class cls) {
        return new Double2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$4(Class cls) {
        return new Long2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$5(Class cls) {
        return new Int2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$6(Class cls) {
        return new Short2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$7(Class cls) {
        return new Str2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$8(Class cls) {
        return new JSONObject2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$9(Class cls) {
        return new JSONArray2StrConvert();
    }

    public static ITypeConverter get(TypeToken typeToken) {
        Class rawType = typeToken.getRawType();
        if (List.class.isAssignableFrom(rawType)) {
            Class cls = (Class) ((ParameterizedType) typeToken.getType()).getActualTypeArguments()[0];
            if (String.class.isAssignableFrom(cls)) {
                return (ITypeConverter) InstanceCache.obtain(StrList2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda0
                    @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                    public final Object create(Class cls2) {
                        return ConvertFactory.lambda$get$10(cls2);
                    }
                });
            }
            if (Integer.class.isAssignableFrom(cls)) {
                return (ITypeConverter) InstanceCache.obtain(IntList2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda7
                    @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                    public final Object create(Class cls2) {
                        return ConvertFactory.lambda$get$11(cls2);
                    }
                });
            }
        } else if (Set.class.isAssignableFrom(rawType)) {
            Class cls2 = (Class) ((ParameterizedType) typeToken.getType()).getActualTypeArguments()[0];
            if (String.class.isAssignableFrom(cls2)) {
                return (ITypeConverter) InstanceCache.obtain(StrSet2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda8
                    @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                    public final Object create(Class cls3) {
                        return ConvertFactory.lambda$get$12(cls3);
                    }
                });
            }
            if (Integer.class.isAssignableFrom(cls2)) {
                return (ITypeConverter) InstanceCache.obtain(IntSet2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda9
                    @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                    public final Object create(Class cls3) {
                        return ConvertFactory.lambda$get$13(cls3);
                    }
                });
            }
        } else if (Map.class.isAssignableFrom(rawType)) {
            ParameterizedType parameterizedType = (ParameterizedType) typeToken.getType();
            Class cls3 = (Class) parameterizedType.getActualTypeArguments()[0];
            Class cls4 = (Class) parameterizedType.getActualTypeArguments()[1];
            if (String.class.isAssignableFrom(cls3)) {
                if (String.class.isAssignableFrom(cls4)) {
                    return (ITypeConverter) InstanceCache.obtain(StrMap2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda10
                        @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                        public final Object create(Class cls5) {
                            return ConvertFactory.lambda$get$14(cls5);
                        }
                    });
                }
                if (Integer.class.isAssignableFrom(cls4)) {
                    return (ITypeConverter) InstanceCache.obtain(IntMap2StrConvert.class, new InstanceCreator() { // from class: com.bytedance.platform.settingsx.convert.ConvertFactory$$ExternalSyntheticLambda11
                        @Override // com.bytedance.platform.settingsx.internal.InstanceCreator
                        public final Object create(Class cls5) {
                            return ConvertFactory.lambda$get$15(cls5);
                        }
                    });
                }
            }
        }
        throw new RuntimeException("not support convert token " + typeToken.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$10(Class cls) {
        return new StrList2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$11(Class cls) {
        return new IntList2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$12(Class cls) {
        return new StrSet2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$13(Class cls) {
        return new IntSet2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$14(Class cls) {
        return new StrMap2StrConvert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$15(Class cls) {
        return new IntMap2StrConvert();
    }
}
