package io.noties.prism4j.languages;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import io.noties.prism4j.GrammarUtils;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Prism_cpp {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Grammar extend = GrammarUtils.extend(GrammarUtils.require(prism4j, "c"), "cpp", Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("\\b(?:alignas|alignof|asm|auto|bool|break|case|catch|char|char16_t|char32_t|class|compl|const|constexpr|const_cast|continue|decltype|default|delete|do|double|dynamic_cast|else|enum|explicit|export|extern|float|for|friend|goto|if|inline|int|int8_t|int16_t|int32_t|int64_t|uint8_t|uint16_t|uint32_t|uint64_t|long|mutable|namespace|new|noexcept|nullptr|operator|private|protected|public|register|reinterpret_cast|return|short|signed|sizeof|static|static_assert|static_cast|struct|switch|template|this|thread_local|throw|try|typedef|typeid|typename|union|unsigned|using|virtual|void|volatile|wchar_t|while)\\b"))), Prism4j.token("operator", Prism4j.pattern(Pattern.compile("--?|\\+\\+?|!=?|<{1,2}=?|>{1,2}=?|->|:{1,2}|={1,2}|\\^|~|%|&{1,2}|\\|\\|?|\\?|\\*|\\/|\\b(?:and|and_eq|bitand|bitor|not|not_eq|or|or_eq|xor|xor_eq)\\b"))));
        GrammarUtils.insertBeforeToken(extend, "function", Prism4j.token(WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE, Prism4j.pattern(Pattern.compile("\\b(?:true|false)\\b"))));
        GrammarUtils.insertBeforeToken(extend, "keyword", Prism4j.token("class-name", Prism4j.pattern(Pattern.compile("(class\\s+)\\w+", 2), true)));
        GrammarUtils.insertBeforeToken(extend, WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.token("raw-string", Prism4j.pattern(Pattern.compile("R\"([^()\\\\ ]{0,16})\\([\\s\\S]*?\\)\\1\""), false, true, WsChannelMultiProcessSharedProvider.STRING_TYPE)));
        return extend;
    }
}
