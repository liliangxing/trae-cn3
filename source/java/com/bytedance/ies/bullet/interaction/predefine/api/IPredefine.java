package com.bytedance.ies.bullet.interaction.predefine.api;

import android.net.Uri;
import com.bytedance.ies.bullet.interaction.predefine.model.MetaModelConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: IPredefine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J$\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\r2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/api/IPredefine;", "", "findTargetJsFile", "", "uri", "Landroid/net/Uri;", "metaModelConfig", "Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaModelConfig;", "matchRule", "", "", "getTargetJsFiles", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "predefine", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPredefine {
    void findTargetJsFile(Uri uri, MetaModelConfig metaModelConfig);

    void findTargetJsFile(Uri uri, List<String> matchRule);

    ArrayList<String> getTargetJsFiles(Uri uri);

    void predefine(Uri uri);
}
