package org.jetbrains.compose.resources;

import com.bytedance.android.live.core.setting.v2.tools.SettingV2Monitor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: ResourceReader.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lorg/jetbrains/compose/resources/ResourceReader;", "", SettingV2Monitor.REPORT_TYPE_READ, "", "path", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readPart", "offset", "", "size", "(Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUri", "library_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes9.dex */
public interface ResourceReader {
    String getUri(String path);

    Object read(String str, Continuation<? super byte[]> continuation);

    Object readPart(String str, long j, long j2, Continuation<? super byte[]> continuation);
}
