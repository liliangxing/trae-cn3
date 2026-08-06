package com.bytedance.common.utility.persistent;

import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class SharedPrefsEditorCompat {
    static final EditorImpl IMPL = new GingerbreadEditorImpl();

    /* loaded from: classes3.dex */
    interface EditorImpl {
        void apply(SharedPreferences.Editor editor);
    }

    /* loaded from: classes3.dex */
    static class BaseEditorImpl implements EditorImpl {
        BaseEditorImpl() {
        }

        @Override // com.bytedance.common.utility.persistent.SharedPrefsEditorCompat.EditorImpl
        public void apply(SharedPreferences.Editor editor) {
            editor.commit();
        }
    }

    /* loaded from: classes3.dex */
    static class GingerbreadEditorImpl implements EditorImpl {
        GingerbreadEditorImpl() {
        }

        @Override // com.bytedance.common.utility.persistent.SharedPrefsEditorCompat.EditorImpl
        public void apply(SharedPreferences.Editor editor) {
            editor.apply();
        }
    }

    public static void apply(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        IMPL.apply(editor);
    }
}
