package com.bytedance.ies.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.LruCache;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class SharedPrefHelper {
    private static LruCache<String, SharedPrefHelper> mHelpers = null;
    private static String sDefaultFileName = "default_app_sp";
    private static int sMaxHelpersCount = 3;
    private SharedPreferences.Editor mEditor;
    private final SharedPreferences mSharedPreferences;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public enum Type {
        STRING,
        INTEGER,
        BOOLEAN,
        FLOAT,
        LONG,
        STRING_SET,
        ALL
    }

    public static void setDefaultFileName(String str) {
        sDefaultFileName = str;
    }

    public static void setMaxHelpersCount(int i) {
        if (i > 0) {
            sMaxHelpersCount = i;
        }
    }

    public static SharedPrefHelper from(Context context) {
        return from(context, sDefaultFileName);
    }

    public static SharedPrefHelper from(Context context, String str) {
        if (context == null) {
            throw new NullPointerException("null context!!");
        }
        if (mHelpers == null) {
            mHelpers = new LruCache<>(sMaxHelpersCount);
        }
        SharedPrefHelper sharedPrefHelper = mHelpers.get(str);
        if (sharedPrefHelper != null) {
            return sharedPrefHelper;
        }
        SharedPrefHelper sharedPrefHelper2 = new SharedPrefHelper(context, str);
        mHelpers.put(str, sharedPrefHelper2);
        return sharedPrefHelper2;
    }

    private SharedPrefHelper(Context context, String str) {
        this.mSharedPreferences = context.getSharedPreferences(str, 0);
    }

    public SharedPrefHelper put(String str, Object obj) {
        ensureEditor();
        if (obj instanceof String) {
            this.mEditor.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            this.mEditor.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            this.mEditor.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            this.mEditor.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            this.mEditor.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Set) {
            this.mEditor.putStringSet(str, (Set) obj);
        } else {
            this.mEditor.putString(str, String.valueOf(obj));
        }
        return this;
    }

    public void putEnd(String str, Object obj) {
        put(str, obj);
        end();
    }

    public SharedPrefHelper remove(String str) {
        ensureEditor();
        this.mEditor.remove(str);
        return this;
    }

    public SharedPrefHelper clear() {
        ensureEditor();
        this.mEditor.clear();
        end();
        return this;
    }

    public boolean contains(String str) {
        return this.mSharedPreferences.contains(str);
    }

    public SharedPreferences getSharePreferences() {
        return this.mSharedPreferences;
    }

    public void end() {
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            SharedPrefsEditorCompat.apply(editor);
        }
    }

    private void ensureEditor() {
        if (this.mEditor == null) {
            this.mEditor = this.mSharedPreferences.edit();
        }
    }

    private <T> T get(String str, Type type, Object obj) {
        return (T) getValue(str, type, obj);
    }

    public String getString(String str, String str2) {
        return (String) get(str, Type.STRING, str2);
    }

    public int getInt(String str, int i) {
        return ((Integer) get(str, Type.INTEGER, Integer.valueOf(i))).intValue();
    }

    public boolean getBoolean(String str, boolean z) {
        return ((Boolean) get(str, Type.BOOLEAN, Boolean.valueOf(z))).booleanValue();
    }

    public float getFloat(String str, float f) {
        return ((Float) get(str, Type.FLOAT, Float.valueOf(f))).floatValue();
    }

    public long getLong(String str, long j) {
        return ((Long) get(str, Type.LONG, Long.valueOf(j))).longValue();
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return (Set) get(str, Type.STRING_SET, set);
    }

    public Map<String, ?> getAll() {
        return (Map) get("", Type.ALL, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.ies.utility.SharedPrefHelper$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$ies$utility$SharedPrefHelper$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$bytedance$ies$utility$SharedPrefHelper$Type = iArr;
            try {
                iArr[Type.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$ies$utility$SharedPrefHelper$Type[Type.INTEGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$ies$utility$SharedPrefHelper$Type[Type.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$ies$utility$SharedPrefHelper$Type[Type.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$ies$utility$SharedPrefHelper$Type[Type.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$ies$utility$SharedPrefHelper$Type[Type.STRING_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bytedance$ies$utility$SharedPrefHelper$Type[Type.ALL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private Object getValue(String str, Type type, Object obj) {
        switch (AnonymousClass1.$SwitchMap$com$bytedance$ies$utility$SharedPrefHelper$Type[type.ordinal()]) {
            case 1:
                return this.mSharedPreferences.getString(str, (String) obj);
            case 2:
                return Integer.valueOf(this.mSharedPreferences.getInt(str, ((Integer) obj).intValue()));
            case 3:
                return Boolean.valueOf(this.mSharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
            case 4:
                return Float.valueOf(this.mSharedPreferences.getFloat(str, ((Float) obj).floatValue()));
            case 5:
                return Long.valueOf(this.mSharedPreferences.getLong(str, ((Long) obj).longValue()));
            case 6:
                return this.mSharedPreferences.getStringSet(str, (Set) obj);
            case 7:
                return this.mSharedPreferences.getAll();
            default:
                return obj;
        }
    }
}
