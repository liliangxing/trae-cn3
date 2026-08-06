package com.lynx.tasm.fontface;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class FontFace {
    private String fontFamily;
    private StyledTypeface mStyledTypeface;
    private List<Pair<TYPE, String>> src = new ArrayList();

    /* loaded from: classes7.dex */
    public enum TYPE {
        URL,
        LOCAL
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStyledTypeface(StyledTypeface styledTypeface) {
        this.mStyledTypeface = styledTypeface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StyledTypeface getTypeface() {
        return this.mStyledTypeface;
    }

    public List<Pair<TYPE, String>> getSrc() {
        return this.src;
    }

    public void setFontFamily(String str) {
        this.fontFamily = str;
    }

    public void addUrl(String str) {
        this.src.add(new Pair<>(TYPE.URL, str));
    }

    public void addLocal(String str) {
        this.src.add(new Pair<>(TYPE.LOCAL, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSameFontFace(FontFace fontFace) {
        if (this == fontFace) {
            return true;
        }
        for (Pair<TYPE, String> pair : this.src) {
            Iterator<Pair<TYPE, String>> it = fontFace.src.iterator();
            while (it.hasNext()) {
                if (pair.equals(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }
}
