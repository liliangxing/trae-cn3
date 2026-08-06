package com.bytedance.ies.bullet.service.schema;

import android.net.Uri;
import android.os.Bundle;
import kotlin.Metadata;

/* compiled from: ISchemaMutableData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "addParam", "", "key", "", "value", "Lcom/bytedance/ies/bullet/service/schema/IParam;", "cover", "", "appendBundle", "bundle", "Landroid/os/Bundle;", "removeParam", "setOriginUrl", "uri", "Landroid/net/Uri;", "setPath", "path", "setScheme", "scheme", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ISchemaMutableData extends ISchemaData {
    void addParam(String key, IParam value, boolean cover);

    void appendBundle(Bundle bundle);

    void removeParam(String key);

    void setOriginUrl(Uri uri);

    void setPath(String path);

    void setScheme(String scheme);
}
