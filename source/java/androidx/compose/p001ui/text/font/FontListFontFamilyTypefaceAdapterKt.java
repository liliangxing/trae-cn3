package androidx.compose.p001ui.text.font;

import androidx.compose.p001ui.text.font.AsyncTypefaceCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\fH\u0002¨\u0006\r"}, d2 = {"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1<? super TypefaceRequest, ? extends Object> function1) {
        Object invoke;
        Font font;
        List list2;
        List list3;
        Object obj;
        Font font2;
        int size = list.size();
        List list4 = null;
        for (int i = 0; i < size; i++) {
            Font font3 = list.get(i);
            int loadingStrategy = font3.getLoadingStrategy();
            if (!FontLoadingStrategy.m2224equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m2229getBlockingPKNRLFQ())) {
                if (!FontLoadingStrategy.m2224equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m2230getOptionalLocalPKNRLFQ())) {
                    list3 = list4;
                    if (FontLoadingStrategy.m2224equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m2228getAsyncPKNRLFQ())) {
                        AsyncTypefaceCache.AsyncTypefaceResult m2188get1ASDuI8 = asyncTypefaceCache.m2188get1ASDuI8(font3, platformFontLoader);
                        if (m2188get1ASDuI8 == null) {
                            if (list3 == null) {
                                list4 = CollectionsKt.mutableListOf(new Font[]{font3});
                            } else {
                                list3.add(font3);
                            }
                        } else if (!AsyncTypefaceCache.AsyncTypefaceResult.m2194isPermanentFailureimpl(m2188get1ASDuI8.m2196unboximpl()) && m2188get1ASDuI8.m2196unboximpl() != null) {
                            return TuplesKt.to(list3, FontSynthesis_androidKt.m2258synthesizeTypefaceFxwP2eA(typefaceRequest.m2283getFontSynthesisGVVA2EU(), m2188get1ASDuI8.m2196unboximpl(), font3, typefaceRequest.getFontWeight(), typefaceRequest.m2282getFontStyle_LCdwA()));
                        }
                    } else {
                        throw new IllegalStateException("Unknown font type " + font3);
                    }
                } else {
                    synchronized (asyncTypefaceCache.cacheLock) {
                        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font3, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                        if (asyncTypefaceResult == null) {
                            asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                        }
                        if (asyncTypefaceResult != null) {
                            obj = asyncTypefaceResult.m2196unboximpl();
                            font2 = font3;
                            list3 = list4;
                        } else {
                            Unit unit = Unit.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                obj = Result.constructor-impl(platformFontLoader.loadBlocking(font3));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            font2 = font3;
                            list3 = list4;
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font3, platformFontLoader, obj, false, 8, null);
                        }
                    }
                    if (obj != null) {
                        return TuplesKt.to(list3, FontSynthesis_androidKt.m2258synthesizeTypefaceFxwP2eA(typefaceRequest.m2283getFontSynthesisGVVA2EU(), obj, font2, typefaceRequest.getFontWeight(), typefaceRequest.m2282getFontStyle_LCdwA()));
                    }
                }
                list4 = list3;
            } else {
                synchronized (asyncTypefaceCache.cacheLock) {
                    AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font3, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                    if (asyncTypefaceResult2 == null) {
                        asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                    }
                    if (asyncTypefaceResult2 != null) {
                        invoke = asyncTypefaceResult2.m2196unboximpl();
                        font = font3;
                        list2 = list4;
                    } else {
                        Unit unit2 = Unit.INSTANCE;
                        try {
                            invoke = platformFontLoader.loadBlocking(font3);
                        } catch (Exception unused) {
                            invoke = function1.invoke(typefaceRequest);
                        }
                        font = font3;
                        list2 = list4;
                        AsyncTypefaceCache.put$default(asyncTypefaceCache, font3, platformFontLoader, invoke, false, 8, null);
                    }
                }
                if (invoke == null) {
                    invoke = function1.invoke(typefaceRequest);
                }
                return TuplesKt.to(list2, FontSynthesis_androidKt.m2258synthesizeTypefaceFxwP2eA(typefaceRequest.m2283getFontSynthesisGVVA2EU(), invoke, font, typefaceRequest.getFontWeight(), typefaceRequest.m2282getFontStyle_LCdwA()));
            }
        }
        return TuplesKt.to(list4, function1.invoke(typefaceRequest));
    }
}
