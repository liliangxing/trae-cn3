package com.larus.business.markdown.api.depend;

import android.graphics.Bitmap;
import kotlin.Metadata;

/* compiled from: IMarkdownConfig.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\"\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/larus/business/markdown/api/depend/OnLatexUrlCallBack;", "", "onFailure", "", "onSuccess", "latexImg", "Landroid/graphics/Bitmap;", "width", "", "height", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface OnLatexUrlCallBack {
    void onFailure();

    void onSuccess(Bitmap latexImg, float width, float height);
}
