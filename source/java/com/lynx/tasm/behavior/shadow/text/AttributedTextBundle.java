package com.lynx.tasm.behavior.shadow.text;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public class AttributedTextBundle {
    private HashMap<Integer, NativeLayoutNodeSpan> mInlineViewMap;
    private final CharSequence mSpan;
    private final TextAttributes mTextAttributes;

    public AttributedTextBundle(CharSequence charSequence, TextAttributes textAttributes) {
        this.mSpan = charSequence;
        this.mTextAttributes = textAttributes;
    }

    public CharSequence getSpan() {
        return this.mSpan;
    }

    public TextAttributes getTextAttributes() {
        return this.mTextAttributes;
    }

    public void setInlineViewMap(HashMap<Integer, NativeLayoutNodeSpan> hashMap) {
        this.mInlineViewMap = hashMap;
    }

    public NativeLayoutNodeSpan getNativeLayoutNodeSpan(int i) {
        HashMap<Integer, NativeLayoutNodeSpan> hashMap = this.mInlineViewMap;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(Integer.valueOf(i));
    }

    public Set<Map.Entry<Integer, NativeLayoutNodeSpan>> getNativeLayoutNodeSpans() {
        HashMap<Integer, NativeLayoutNodeSpan> hashMap = this.mInlineViewMap;
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        return this.mInlineViewMap.entrySet();
    }
}
