package io.noties.markwon.html.customdata;

import android.text.Spanned;
import android.widget.TextView;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import io.noties.markwon.core.MarkwonTheme;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ICustomImgSpan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H&J\u0018\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020)H&J\u0010\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020&H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005R \u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001eX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lio/noties/markwon/html/customdata/ICustomImgSpan;", "", "endIndex", "", "getEndIndex", "()I", "imgBgColor", "getImgBgColor", "()Ljava/lang/Integer;", "imgCornerRadius", "getImgCornerRadius", "payload", "", "", "getPayload", "()Ljava/util/Map;", "replacementTextIsLink", "", "getReplacementTextIsLink", "()Z", "startIndex", "getStartIndex", SettingsTracker.TYPE_THEME, "Lio/noties/markwon/core/MarkwonTheme;", "getTheme", "()Lio/noties/markwon/core/MarkwonTheme;", "url", "getUrl", "()Ljava/lang/String;", "widget", "Lio/noties/markwon/html/customdata/ICustomImgWidget;", "getWidget", "()Lio/noties/markwon/html/customdata/ICustomImgWidget;", "setWidget", "(Lio/noties/markwon/html/customdata/ICustomImgWidget;)V", "afterAttach", "", "textView", "Landroid/widget/TextView;", "beforeAttach", "text", "Landroid/text/Spanned;", "onDetach", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public interface ICustomImgSpan {
    void afterAttach(TextView textView);

    void beforeAttach(TextView textView, Spanned text);

    int getEndIndex();

    Integer getImgBgColor();

    int getImgCornerRadius();

    Map<String, Object> getPayload();

    boolean getReplacementTextIsLink();

    int getStartIndex();

    MarkwonTheme getTheme();

    String getUrl();

    ICustomImgWidget getWidget();

    void onDetach(TextView textView);

    void setWidget(ICustomImgWidget iCustomImgWidget);
}
