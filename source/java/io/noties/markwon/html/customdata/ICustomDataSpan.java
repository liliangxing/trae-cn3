package io.noties.markwon.html.customdata;

import android.text.Spanned;
import android.widget.TextView;
import io.noties.markwon.html.IRecyclableSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICustomDataSpan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0018\u0010\n\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0018\u0010\u0010\u001a\u00020\u0011X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lio/noties/markwon/html/customdata/ICustomDataSpan;", "Lio/noties/markwon/html/IRecyclableSpan;", "dataExtra", "", "getDataExtra", "()Ljava/lang/String;", "dataTag", "getDataTag", "dataType", "getDataType", "dataValue", "getDataValue", "setDataValue", "(Ljava/lang/String;)V", "dataValueId", "getDataValueId", "needRefresh", "", "getNeedRefresh", "()Z", "setNeedRefresh", "(Z)V", "afterAttach", "", "textView", "Landroid/widget/TextView;", "beforeAttach", "text", "Landroid/text/Spanned;", "onDetach", "onReuse", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public interface ICustomDataSpan extends IRecyclableSpan {

    /* compiled from: ICustomDataSpan.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static void onReuse(ICustomDataSpan iCustomDataSpan, TextView textView, Spanned text) {
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            Intrinsics.checkParameterIsNotNull(text, "text");
        }
    }

    void afterAttach(TextView textView);

    void beforeAttach(TextView textView, Spanned text);

    String getDataExtra();

    String getDataTag();

    String getDataType();

    String getDataValue();

    String getDataValueId();

    boolean getNeedRefresh();

    void onDetach(TextView textView);

    void onReuse(TextView textView, Spanned text);

    void setDataValue(String str);

    void setNeedRefresh(boolean z);
}
