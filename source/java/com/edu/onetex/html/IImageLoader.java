package com.edu.onetex.html;

import android.widget.ImageView;
import com.bytedance.bdturing.methods.JsCallParser;
import kotlin.Metadata;

/* compiled from: HtmlEngine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\nJ\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lcom/edu/onetex/html/IImageLoader;", "", "load", "", "imageview", "Landroid/widget/ImageView;", "url", "", JsCallParser.VALUE_CALLBACK, "Lcom/edu/onetex/html/IImageLoader$ILoadResult;", "ILoadResult", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface IImageLoader {

    /* compiled from: HtmlEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/edu/onetex/html/IImageLoader$ILoadResult;", "", "onLoadFailed", "", "onLoadSuccess", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public interface ILoadResult {
        void onLoadFailed();

        void onLoadSuccess();
    }

    void load(ImageView imageview, String url, ILoadResult callback);
}
