package com.bytedance.ies.bullet.service.schema;

import android.net.Uri;
import android.os.Bundle;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ISchemaData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010 \u001a\u00020!H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR \u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0012\u0010\u001e\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013¨\u0006\""}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "", "bundle", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "convertEndTimeStamp", "", "getConvertEndTimeStamp", "()J", "fragment", "", "getFragment", "()Ljava/lang/String;", "host", "getHost", "originUrl", "Landroid/net/Uri;", "getOriginUrl", "()Landroid/net/Uri;", "parseTimeStamp", "getParseTimeStamp", "path", "getPath", "queryItems", "", "getQueryItems", "()Ljava/util/Map;", "scheme", "getScheme", "url", "getUrl", "isWeb", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ISchemaData {
    Bundle getBundle();

    long getConvertEndTimeStamp();

    String getFragment();

    String getHost();

    Uri getOriginUrl();

    long getParseTimeStamp();

    String getPath();

    Map<String, String> getQueryItems();

    String getScheme();

    Uri getUrl();

    boolean isWeb();
}
