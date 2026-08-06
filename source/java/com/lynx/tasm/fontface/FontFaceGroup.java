package com.lynx.tasm.fontface;

import android.util.Pair;
import com.lynx.tasm.behavior.shadow.text.TypefaceCache;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class FontFaceGroup {
    private List<Pair<TypefaceCache.TypefaceListener, Integer>> mListeners = new ArrayList();
    private Set<FontFace> mFontFaces = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addListener(Pair<TypefaceCache.TypefaceListener, Integer> pair) {
        if (pair == null) {
            return;
        }
        this.mListeners.add(pair);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<FontFace> getFontFaces() {
        return this.mFontFaces;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Pair<TypefaceCache.TypefaceListener, Integer>> getListeners() {
        return this.mListeners;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFontFace(FontFace fontFace) {
        this.mFontFaces.add(fontFace);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSameFontFace(FontFace fontFace) {
        if (this.mFontFaces.contains(fontFace)) {
            return true;
        }
        Iterator<FontFace> it = this.mFontFaces.iterator();
        while (it.hasNext()) {
            if (it.next().isSameFontFace(fontFace)) {
                return true;
            }
        }
        return false;
    }
}
