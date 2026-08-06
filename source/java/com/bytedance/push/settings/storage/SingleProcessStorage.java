package com.bytedance.push.settings.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class SingleProcessStorage extends SharedPreferenceStorage {
    private final Context mContext;
    private final String mStorageKey;

    public SingleProcessStorage(Context context, String str) {
        super(context, str);
        this.mStorageKey = str;
        this.mContext = context;
    }

    @Override // com.bytedance.push.settings.storage.SharedPreferenceStorage, com.bytedance.push.settings.storage.Storage
    public EditorImpl edit() {
        return new EditorImpl(this.mContext, super.edit());
    }

    /* loaded from: classes4.dex */
    public final class EditorImpl implements SharedPreferences.Editor {
        private final Context mContext;
        private final SharedPreferences.Editor mImpl;
        private Map<String, String> mValues = new ConcurrentHashMap();

        EditorImpl(Context context, SharedPreferences.Editor editor) {
            this.mContext = context;
            this.mImpl = editor;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.mImpl.putString(str, str2);
            if (TextUtils.equals(SingleProcessStorage.this.getString(str), str2)) {
                this.mValues.remove(str);
            } else {
                this.mValues.put(str, "string");
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            throw new UnsupportedOperationException("not support putStringSet");
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            this.mImpl.putInt(str, i);
            if (i == SingleProcessStorage.this.getInt(str)) {
                this.mValues.remove(str);
            } else {
                this.mValues.put(str, "integer");
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            this.mImpl.putLong(str, j);
            if (j == SingleProcessStorage.this.getLong(str)) {
                this.mValues.remove(str);
            } else {
                this.mValues.put(str, "long");
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            this.mImpl.putFloat(str, f);
            if (f == SingleProcessStorage.this.getFloat(str)) {
                this.mValues.remove(str);
            } else {
                this.mValues.put(str, "float");
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.mImpl.putBoolean(str, z);
            if (z == SingleProcessStorage.this.getBoolean(str)) {
                this.mValues.remove(str);
            } else {
                this.mValues.put(str, "boolean");
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.mImpl.remove(str);
            this.mValues.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            throw new UnsupportedOperationException("clear not support");
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            boolean commit = this.mImpl.commit();
            notifyChanged();
            return commit;
        }

        private void notifyChanged() {
            this.mValues.clear();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.mImpl.apply();
            notifyChanged();
        }
    }
}
