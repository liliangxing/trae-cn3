package io.noties.markwon.html.jsoup.parser;

import io.noties.markwon.html.jsoup.nodes.DocumentType;
import io.noties.markwon.html.jsoup.parser.Token;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public enum TokeniserState {
    Data { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.1
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                tokeniser.emit(characterReader.consume());
            } else {
                if (current == '&') {
                    tokeniser.advanceTransition(CharacterReferenceInData);
                    return;
                }
                if (current == '<') {
                    tokeniser.advanceTransition(TagOpen);
                } else if (current == 65535) {
                    tokeniser.emit(new Token.EOF());
                } else {
                    tokeniser.emit(characterReader.consumeData());
                }
            }
        }
    },
    CharacterReferenceInData { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.2
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readCharRef(tokeniser, Data);
        }
    },
    Rcdata { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.3
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit(TokeniserState.replacementChar);
            } else {
                if (current == '&') {
                    tokeniser.advanceTransition(CharacterReferenceInRcdata);
                    return;
                }
                if (current == '<') {
                    tokeniser.advanceTransition(RcdataLessthanSign);
                } else if (current == 65535) {
                    tokeniser.emit(new Token.EOF());
                } else {
                    tokeniser.emit(characterReader.consumeToAny('&', '<', TokeniserState.nullChar));
                }
            }
        }
    },
    CharacterReferenceInRcdata { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.4
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readCharRef(tokeniser, Rcdata);
        }
    },
    Rawtext { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.5
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readData(tokeniser, characterReader, this, RawtextLessthanSign);
        }
    },
    ScriptData { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.6
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readData(tokeniser, characterReader, this, ScriptDataLessthanSign);
        }
    },
    PLAINTEXT { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.7
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit(TokeniserState.replacementChar);
            } else if (current == 65535) {
                tokeniser.emit(new Token.EOF());
            } else {
                tokeniser.emit(characterReader.consumeTo(TokeniserState.nullChar));
            }
        }
    },
    TagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.8
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == '!') {
                tokeniser.advanceTransition(MarkupDeclarationOpen);
                return;
            }
            if (current == '/') {
                tokeniser.advanceTransition(EndTagOpen);
                return;
            }
            if (current == '?') {
                tokeniser.advanceTransition(BogusComment);
                return;
            }
            if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(true);
                tokeniser.transition(TagName);
            } else {
                tokeniser.error(this);
                tokeniser.emit('<');
                tokeniser.transition(Data);
            }
        }
    },
    EndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.9
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.emit("</");
                tokeniser.transition(Data);
            } else if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniser.transition(TagName);
            } else if (characterReader.matches('>')) {
                tokeniser.error(this);
                tokeniser.advanceTransition(Data);
            } else {
                tokeniser.error(this);
                tokeniser.advanceTransition(BogusComment);
            }
        }
    },
    TagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.10
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.tagPending.appendTagName(characterReader.consumeTagName());
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.tagPending.appendTagName(TokeniserState.replacementStr);
                return;
            }
            if (consume != ' ') {
                if (consume == '/') {
                    tokeniser.transition(SelfClosingStartTag);
                    return;
                }
                if (consume == '>') {
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                } else if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                    tokeniser.tagPending.appendTagName(consume);
                    return;
                }
            }
            tokeniser.transition(BeforeAttributeName);
        }
    },
    RcdataLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.11
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(RCDATAEndTagOpen);
            } else {
                if (characterReader.matchesLetter() && tokeniser.appropriateEndTagName() != null && !characterReader.containsIgnoreCase("</" + tokeniser.appropriateEndTagName())) {
                    tokeniser.tagPending = tokeniser.createTagPending(false).name(tokeniser.appropriateEndTagName());
                    tokeniser.emitTagPending();
                    characterReader.unconsume();
                    tokeniser.transition(Data);
                    return;
                }
                tokeniser.emit("<");
                tokeniser.transition(Rcdata);
            }
        }
    },
    RCDATAEndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.12
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniser.tagPending.appendTagName(characterReader.current());
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.advanceTransition(RCDATAEndTagName);
                return;
            }
            tokeniser.emit("</");
            tokeniser.transition(Rcdata);
        }
    },
    RCDATAEndTagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.13
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                String consumeLetterSequence = characterReader.consumeLetterSequence();
                tokeniser.tagPending.appendTagName(consumeLetterSequence);
                tokeniser.dataBuffer.append(consumeLetterSequence);
                return;
            }
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniser.transition(BeforeAttributeName);
                    return;
                } else {
                    anythingElse(tokeniser, characterReader);
                    return;
                }
            }
            if (consume == '/') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniser.transition(SelfClosingStartTag);
                    return;
                } else {
                    anythingElse(tokeniser, characterReader);
                    return;
                }
            }
            if (consume == '>') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                } else {
                    anythingElse(tokeniser, characterReader);
                    return;
                }
            }
            anythingElse(tokeniser, characterReader);
        }

        private void anythingElse(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.emit("</" + tokeniser.dataBuffer.toString());
            characterReader.unconsume();
            tokeniser.transition(Rcdata);
        }
    },
    RawtextLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.14
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(RawtextEndTagOpen);
            } else {
                tokeniser.emit('<');
                tokeniser.transition(Rawtext);
            }
        }
    },
    RawtextEndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.15
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readEndTag(tokeniser, characterReader, RawtextEndTagName, Rawtext);
        }
    },
    RawtextEndTagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.16
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, Rawtext);
        }
    },
    ScriptDataLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.17
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '!') {
                tokeniser.emit("<!");
                tokeniser.transition(ScriptDataEscapeStart);
            } else if (consume == '/') {
                tokeniser.createTempBuffer();
                tokeniser.transition(ScriptDataEndTagOpen);
            } else {
                tokeniser.emit("<");
                characterReader.unconsume();
                tokeniser.transition(ScriptData);
            }
        }
    },
    ScriptDataEndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.18
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readEndTag(tokeniser, characterReader, ScriptDataEndTagName, ScriptData);
        }
    },
    ScriptDataEndTagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.19
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, ScriptData);
        }
    },
    ScriptDataEscapeStart { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.20
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('-')) {
                tokeniser.emit('-');
                tokeniser.advanceTransition(ScriptDataEscapeStartDash);
            } else {
                tokeniser.transition(ScriptData);
            }
        }
    },
    ScriptDataEscapeStartDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.21
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('-')) {
                tokeniser.emit('-');
                tokeniser.advanceTransition(ScriptDataEscapedDashDash);
            } else {
                tokeniser.transition(ScriptData);
            }
        }
    },
    ScriptDataEscaped { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.22
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
                return;
            }
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit(TokeniserState.replacementChar);
            } else if (current == '-') {
                tokeniser.emit('-');
                tokeniser.advanceTransition(ScriptDataEscapedDash);
            } else if (current == '<') {
                tokeniser.advanceTransition(ScriptDataEscapedLessthanSign);
            } else {
                tokeniser.emit(characterReader.consumeToAny('-', '<', TokeniserState.nullChar));
            }
        }
    },
    ScriptDataEscapedDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.23
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
                return;
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.emit(TokeniserState.replacementChar);
                tokeniser.transition(ScriptDataEscaped);
            } else if (consume == '-') {
                tokeniser.emit(consume);
                tokeniser.transition(ScriptDataEscapedDashDash);
            } else if (consume == '<') {
                tokeniser.transition(ScriptDataEscapedLessthanSign);
            } else {
                tokeniser.emit(consume);
                tokeniser.transition(ScriptDataEscaped);
            }
        }
    },
    ScriptDataEscapedDashDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.24
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
                return;
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.emit(TokeniserState.replacementChar);
                tokeniser.transition(ScriptDataEscaped);
            } else {
                if (consume == '-') {
                    tokeniser.emit(consume);
                    return;
                }
                if (consume == '<') {
                    tokeniser.transition(ScriptDataEscapedLessthanSign);
                } else if (consume == '>') {
                    tokeniser.emit(consume);
                    tokeniser.transition(ScriptData);
                } else {
                    tokeniser.emit(consume);
                    tokeniser.transition(ScriptDataEscaped);
                }
            }
        }
    },
    ScriptDataEscapedLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.25
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createTempBuffer();
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.emit("<" + characterReader.current());
                tokeniser.advanceTransition(ScriptDataDoubleEscapeStart);
                return;
            }
            if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(ScriptDataEscapedEndTagOpen);
            } else {
                tokeniser.emit('<');
                tokeniser.transition(ScriptDataEscaped);
            }
        }
    },
    ScriptDataEscapedEndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.26
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniser.tagPending.appendTagName(characterReader.current());
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.advanceTransition(ScriptDataEscapedEndTagName);
                return;
            }
            tokeniser.emit("</");
            tokeniser.transition(ScriptDataEscaped);
        }
    },
    ScriptDataEscapedEndTagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.27
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.28
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, ScriptDataDoubleEscaped, ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.29
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit(TokeniserState.replacementChar);
            } else if (current == '-') {
                tokeniser.emit(current);
                tokeniser.advanceTransition(ScriptDataDoubleEscapedDash);
            } else if (current == '<') {
                tokeniser.emit(current);
                tokeniser.advanceTransition(ScriptDataDoubleEscapedLessthanSign);
            } else if (current == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
            } else {
                tokeniser.emit(characterReader.consumeToAny('-', '<', TokeniserState.nullChar));
            }
        }
    },
    ScriptDataDoubleEscapedDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.30
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.emit(TokeniserState.replacementChar);
                tokeniser.transition(ScriptDataDoubleEscaped);
            } else if (consume == '-') {
                tokeniser.emit(consume);
                tokeniser.transition(ScriptDataDoubleEscapedDashDash);
            } else if (consume == '<') {
                tokeniser.emit(consume);
                tokeniser.transition(ScriptDataDoubleEscapedLessthanSign);
            } else if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
            } else {
                tokeniser.emit(consume);
                tokeniser.transition(ScriptDataDoubleEscaped);
            }
        }
    },
    ScriptDataDoubleEscapedDashDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.31
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.emit(TokeniserState.replacementChar);
                tokeniser.transition(ScriptDataDoubleEscaped);
                return;
            }
            if (consume == '-') {
                tokeniser.emit(consume);
                return;
            }
            if (consume == '<') {
                tokeniser.emit(consume);
                tokeniser.transition(ScriptDataDoubleEscapedLessthanSign);
            } else if (consume == '>') {
                tokeniser.emit(consume);
                tokeniser.transition(ScriptData);
            } else if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
            } else {
                tokeniser.emit(consume);
                tokeniser.transition(ScriptDataDoubleEscaped);
            }
        }
    },
    ScriptDataDoubleEscapedLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.32
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('/')) {
                tokeniser.emit('/');
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(ScriptDataDoubleEscapeEnd);
                return;
            }
            tokeniser.transition(ScriptDataDoubleEscaped);
        }
    },
    ScriptDataDoubleEscapeEnd { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.33
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, ScriptDataEscaped, ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.34
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                characterReader.unconsume();
                tokeniser.transition(AttributeName);
                return;
            }
            if (consume != ' ') {
                if (consume != '\"' && consume != '\'') {
                    if (consume == '/') {
                        tokeniser.transition(SelfClosingStartTag);
                        return;
                    }
                    if (consume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.transition(Data);
                        return;
                    }
                    if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                        return;
                    }
                    switch (consume) {
                        case '<':
                        case '=':
                            break;
                        case '>':
                            tokeniser.emitTagPending();
                            tokeniser.transition(Data);
                            return;
                        default:
                            tokeniser.tagPending.newAttribute();
                            characterReader.unconsume();
                            tokeniser.transition(AttributeName);
                            return;
                    }
                }
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                tokeniser.tagPending.appendAttributeName(consume);
                tokeniser.transition(AttributeName);
            }
        }
    },
    AttributeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.35
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.tagPending.appendAttributeName(characterReader.consumeToAnySorted(attributeNameCharsSorted));
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != ' ') {
                    if (consume != '\"' && consume != '\'') {
                        if (consume == '/') {
                            tokeniser.transition(SelfClosingStartTag);
                            return;
                        }
                        if (consume == 65535) {
                            tokeniser.eofError(this);
                            tokeniser.transition(Data);
                            return;
                        }
                        if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                            switch (consume) {
                                case '<':
                                    break;
                                case '=':
                                    tokeniser.transition(BeforeAttributeValue);
                                    return;
                                case '>':
                                    tokeniser.emitTagPending();
                                    tokeniser.transition(Data);
                                    return;
                                default:
                                    tokeniser.tagPending.appendAttributeName(consume);
                                    return;
                            }
                        }
                    }
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeName(consume);
                    return;
                }
                tokeniser.transition(AfterAttributeName);
                return;
            }
            tokeniser.error(this);
            tokeniser.tagPending.appendAttributeName(TokeniserState.replacementChar);
        }
    },
    AfterAttributeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.36
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeName(TokeniserState.replacementChar);
                tokeniser.transition(AttributeName);
                return;
            }
            if (consume != ' ') {
                if (consume != '\"' && consume != '\'') {
                    if (consume == '/') {
                        tokeniser.transition(SelfClosingStartTag);
                        return;
                    }
                    if (consume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.transition(Data);
                        return;
                    }
                    if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                        return;
                    }
                    switch (consume) {
                        case '<':
                            break;
                        case '=':
                            tokeniser.transition(BeforeAttributeValue);
                            return;
                        case '>':
                            tokeniser.emitTagPending();
                            tokeniser.transition(Data);
                            return;
                        default:
                            tokeniser.tagPending.newAttribute();
                            characterReader.unconsume();
                            tokeniser.transition(AttributeName);
                            return;
                    }
                }
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                tokeniser.tagPending.appendAttributeName(consume);
                tokeniser.transition(AttributeName);
            }
        }
    },
    BeforeAttributeValue { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.37
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue(TokeniserState.replacementChar);
                tokeniser.transition(AttributeValue_unquoted);
                return;
            }
            if (consume != ' ') {
                if (consume == '\"') {
                    tokeniser.transition(AttributeValue_doubleQuoted);
                    return;
                }
                if (consume != '`') {
                    if (consume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.emitTagPending();
                        tokeniser.transition(Data);
                        return;
                    }
                    if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                        return;
                    }
                    if (consume == '&') {
                        characterReader.unconsume();
                        tokeniser.transition(AttributeValue_unquoted);
                        return;
                    }
                    if (consume == '\'') {
                        tokeniser.transition(AttributeValue_singleQuoted);
                        return;
                    }
                    switch (consume) {
                        case '<':
                        case '=':
                            break;
                        case '>':
                            tokeniser.error(this);
                            tokeniser.emitTagPending();
                            tokeniser.transition(Data);
                            return;
                        default:
                            characterReader.unconsume();
                            tokeniser.transition(AttributeValue_unquoted);
                            return;
                    }
                }
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue(consume);
                tokeniser.transition(AttributeValue_unquoted);
            }
        }
    },
    AttributeValue_doubleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.38
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String consumeToAny = characterReader.consumeToAny(attributeDoubleValueCharsSorted);
            if (consumeToAny.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAny);
            } else {
                tokeniser.tagPending.setEmptyAttributeValue();
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue(TokeniserState.replacementChar);
                return;
            }
            if (consume == '\"') {
                tokeniser.transition(AfterAttributeValue_quoted);
                return;
            }
            if (consume != '&') {
                if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                } else {
                    tokeniser.tagPending.appendAttributeValue(consume);
                    return;
                }
            }
            int[] consumeCharacterReference = tokeniser.consumeCharacterReference('\"', true);
            if (consumeCharacterReference != null) {
                tokeniser.tagPending.appendAttributeValue(consumeCharacterReference);
            } else {
                tokeniser.tagPending.appendAttributeValue('&');
            }
        }
    },
    AttributeValue_singleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.39
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String consumeToAny = characterReader.consumeToAny(attributeSingleValueCharsSorted);
            if (consumeToAny.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAny);
            } else {
                tokeniser.tagPending.setEmptyAttributeValue();
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue(TokeniserState.replacementChar);
                return;
            }
            if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
                return;
            }
            if (consume != '&') {
                if (consume == '\'') {
                    tokeniser.transition(AfterAttributeValue_quoted);
                    return;
                } else {
                    tokeniser.tagPending.appendAttributeValue(consume);
                    return;
                }
            }
            int[] consumeCharacterReference = tokeniser.consumeCharacterReference('\'', true);
            if (consumeCharacterReference != null) {
                tokeniser.tagPending.appendAttributeValue(consumeCharacterReference);
            } else {
                tokeniser.tagPending.appendAttributeValue('&');
            }
        }
    },
    AttributeValue_unquoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.40
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String consumeToAnySorted = characterReader.consumeToAnySorted(attributeValueUnquoted);
            if (consumeToAnySorted.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAnySorted);
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != ' ') {
                    if (consume != '\"' && consume != '`') {
                        if (consume == 65535) {
                            tokeniser.eofError(this);
                            tokeniser.transition(Data);
                            return;
                        }
                        if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                            if (consume == '&') {
                                int[] consumeCharacterReference = tokeniser.consumeCharacterReference('>', true);
                                if (consumeCharacterReference != null) {
                                    tokeniser.tagPending.appendAttributeValue(consumeCharacterReference);
                                    return;
                                } else {
                                    tokeniser.tagPending.appendAttributeValue('&');
                                    return;
                                }
                            }
                            if (consume != '\'') {
                                switch (consume) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        tokeniser.emitTagPending();
                                        tokeniser.transition(Data);
                                        return;
                                    default:
                                        tokeniser.tagPending.appendAttributeValue(consume);
                                        return;
                                }
                            }
                        }
                    }
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue(consume);
                    return;
                }
                tokeniser.transition(BeforeAttributeName);
                return;
            }
            tokeniser.error(this);
            tokeniser.tagPending.appendAttributeValue(TokeniserState.replacementChar);
        }
    },
    AfterAttributeValue_quoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.41
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(BeforeAttributeName);
                return;
            }
            if (consume == '/') {
                tokeniser.transition(SelfClosingStartTag);
                return;
            }
            if (consume == '>') {
                tokeniser.emitTagPending();
                tokeniser.transition(Data);
            } else if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
            } else {
                tokeniser.error(this);
                characterReader.unconsume();
                tokeniser.transition(BeforeAttributeName);
            }
        }
    },
    SelfClosingStartTag { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.42
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '>') {
                tokeniser.tagPending.selfClosing = true;
                tokeniser.emitTagPending();
                tokeniser.transition(Data);
            } else if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
            } else {
                tokeniser.error(this);
                characterReader.unconsume();
                tokeniser.transition(BeforeAttributeName);
            }
        }
    },
    BogusComment { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.43
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            characterReader.unconsume();
            Token.Comment comment = new Token.Comment();
            comment.bogus = true;
            comment.data.append(characterReader.consumeTo('>'));
            tokeniser.emit(comment);
            tokeniser.advanceTransition(Data);
        }
    },
    MarkupDeclarationOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.44
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchConsume("--")) {
                tokeniser.createCommentPending();
                tokeniser.transition(CommentStart);
            } else if (characterReader.matchConsumeIgnoreCase("DOCTYPE")) {
                tokeniser.transition(Doctype);
            } else if (characterReader.matchConsume("[CDATA[")) {
                tokeniser.createTempBuffer();
                tokeniser.transition(CdataSection);
            } else {
                tokeniser.error(this);
                tokeniser.advanceTransition(BogusComment);
            }
        }
    },
    CommentStart { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.45
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.data.append(TokeniserState.replacementChar);
                tokeniser.transition(Comment);
                return;
            }
            if (consume == '-') {
                tokeniser.transition(CommentStartDash);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else {
                tokeniser.commentPending.data.append(consume);
                tokeniser.transition(Comment);
            }
        }
    },
    CommentStartDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.46
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.data.append(TokeniserState.replacementChar);
                tokeniser.transition(Comment);
                return;
            }
            if (consume == '-') {
                tokeniser.transition(CommentStartDash);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else {
                tokeniser.commentPending.data.append(consume);
                tokeniser.transition(Comment);
            }
        }
    },
    Comment { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.47
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.commentPending.data.append(TokeniserState.replacementChar);
            } else if (current == '-') {
                tokeniser.advanceTransition(CommentEndDash);
            } else {
                if (current == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;
                }
                tokeniser.commentPending.data.append(characterReader.consumeToAny('-', TokeniserState.nullChar));
            }
        }
    },
    CommentEndDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.48
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.data.append('-').append(TokeniserState.replacementChar);
                tokeniser.transition(Comment);
            } else {
                if (consume == '-') {
                    tokeniser.transition(CommentEnd);
                    return;
                }
                if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                } else {
                    tokeniser.commentPending.data.append('-').append(consume);
                    tokeniser.transition(Comment);
                }
            }
        }
    },
    CommentEnd { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.49
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.data.append("--").append(TokeniserState.replacementChar);
                tokeniser.transition(Comment);
                return;
            }
            if (consume == '!') {
                tokeniser.error(this);
                tokeniser.transition(CommentEndBang);
                return;
            }
            if (consume == '-') {
                tokeniser.error(this);
                tokeniser.commentPending.data.append('-');
                return;
            }
            if (consume == '>') {
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else {
                tokeniser.error(this);
                tokeniser.commentPending.data.append("--").append(consume);
                tokeniser.transition(Comment);
            }
        }
    },
    CommentEndBang { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.50
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.data.append("--!").append(TokeniserState.replacementChar);
                tokeniser.transition(Comment);
                return;
            }
            if (consume == '-') {
                tokeniser.commentPending.data.append("--!");
                tokeniser.transition(CommentEndDash);
                return;
            }
            if (consume == '>') {
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else {
                tokeniser.commentPending.data.append("--!").append(consume);
                tokeniser.transition(Comment);
            }
        }
    },
    Doctype { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.51
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(BeforeDoctypeName);
                return;
            }
            if (consume != '>') {
                if (consume == 65535) {
                    tokeniser.eofError(this);
                } else {
                    tokeniser.error(this);
                    tokeniser.transition(BeforeDoctypeName);
                    return;
                }
            }
            tokeniser.error(this);
            tokeniser.createDoctypePending();
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.emitDoctypePending();
            tokeniser.transition(Data);
        }
    },
    BeforeDoctypeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.52
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createDoctypePending();
                tokeniser.transition(DoctypeName);
                return;
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.name.append(TokeniserState.replacementChar);
                tokeniser.transition(DoctypeName);
                return;
            }
            if (consume != ' ') {
                if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.createDoctypePending();
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                }
                if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                    return;
                }
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.name.append(consume);
                tokeniser.transition(DoctypeName);
            }
        }
    },
    DoctypeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.53
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.doctypePending.name.append(characterReader.consumeLetterSequence());
                return;
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != ' ') {
                    if (consume == '>') {
                        tokeniser.emitDoctypePending();
                        tokeniser.transition(Data);
                        return;
                    }
                    if (consume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.doctypePending.forceQuirks = true;
                        tokeniser.emitDoctypePending();
                        tokeniser.transition(Data);
                        return;
                    }
                    if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                        tokeniser.doctypePending.name.append(consume);
                        return;
                    }
                }
                tokeniser.transition(AfterDoctypeName);
                return;
            }
            tokeniser.error(this);
            tokeniser.doctypePending.name.append(TokeniserState.replacementChar);
        }
    },
    AfterDoctypeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.54
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (characterReader.matchesAny('\t', '\n', '\r', '\f', ' ')) {
                characterReader.advance();
                return;
            }
            if (characterReader.matches('>')) {
                tokeniser.emitDoctypePending();
                tokeniser.advanceTransition(Data);
                return;
            }
            if (characterReader.matchConsumeIgnoreCase(DocumentType.PUBLIC_KEY)) {
                tokeniser.doctypePending.pubSysKey = DocumentType.PUBLIC_KEY;
                tokeniser.transition(AfterDoctypePublicKeyword);
            } else if (characterReader.matchConsumeIgnoreCase(DocumentType.SYSTEM_KEY)) {
                tokeniser.doctypePending.pubSysKey = DocumentType.SYSTEM_KEY;
                tokeniser.transition(AfterDoctypeSystemKeyword);
            } else {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.advanceTransition(BogusDoctype);
            }
        }
    },
    AfterDoctypePublicKeyword { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.55
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(BeforeDoctypePublicIdentifier);
                return;
            }
            if (consume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(DoctypePublicIdentifier_doubleQuoted);
                return;
            }
            if (consume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(DoctypePublicIdentifier_singleQuoted);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.error(this);
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.transition(BogusDoctype);
        }
    },
    BeforeDoctypePublicIdentifier { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.56
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniser.transition(DoctypePublicIdentifier_doubleQuoted);
                return;
            }
            if (consume == '\'') {
                tokeniser.transition(DoctypePublicIdentifier_singleQuoted);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.error(this);
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.transition(BogusDoctype);
        }
    },
    DoctypePublicIdentifier_doubleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.57
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.publicIdentifier.append(TokeniserState.replacementChar);
                return;
            }
            if (consume == '\"') {
                tokeniser.transition(AfterDoctypePublicIdentifier);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.doctypePending.publicIdentifier.append(consume);
        }
    },
    DoctypePublicIdentifier_singleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.58
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.publicIdentifier.append(TokeniserState.replacementChar);
                return;
            }
            if (consume == '\'') {
                tokeniser.transition(AfterDoctypePublicIdentifier);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.doctypePending.publicIdentifier.append(consume);
        }
    },
    AfterDoctypePublicIdentifier { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.59
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(BetweenDoctypePublicAndSystemIdentifiers);
                return;
            }
            if (consume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (consume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            } else {
                if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                }
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(BogusDoctype);
            }
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.60
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (consume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            } else {
                if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                }
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(BogusDoctype);
            }
        }
    },
    AfterDoctypeSystemKeyword { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.61
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(BeforeDoctypeSystemIdentifier);
                return;
            }
            if (consume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (consume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.error(this);
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.emitDoctypePending();
        }
    },
    BeforeDoctypeSystemIdentifier { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.62
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (consume == '\'') {
                tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.error(this);
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.transition(BogusDoctype);
        }
    },
    DoctypeSystemIdentifier_doubleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.63
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.systemIdentifier.append(TokeniserState.replacementChar);
                return;
            }
            if (consume == '\"') {
                tokeniser.transition(AfterDoctypeSystemIdentifier);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.doctypePending.systemIdentifier.append(consume);
        }
    },
    DoctypeSystemIdentifier_singleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.64
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.systemIdentifier.append(TokeniserState.replacementChar);
                return;
            }
            if (consume == '\'') {
                tokeniser.transition(AfterDoctypeSystemIdentifier);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.doctypePending.systemIdentifier.append(consume);
        }
    },
    AfterDoctypeSystemIdentifier { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.65
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            } else {
                if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                }
                tokeniser.error(this);
                tokeniser.transition(BogusDoctype);
            }
        }
    },
    BogusDoctype { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.66
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            } else {
                if (consume != 65535) {
                    return;
                }
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }
        }
    },
    CdataSection { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.67
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.dataBuffer.append(characterReader.consumeTo("]]>"));
            if (characterReader.matchConsume("]]>") || characterReader.isEmpty()) {
                tokeniser.emit(new Token.CData(tokeniser.dataBuffer.toString()));
                tokeniser.transition(Data);
            }
        }
    };

    private static final char eof = 65535;
    static final char nullChar = 0;
    static final char[] attributeSingleValueCharsSorted = {nullChar, '&', '\''};
    static final char[] attributeDoubleValueCharsSorted = {nullChar, '\"', '&'};
    static final char[] attributeNameCharsSorted = {nullChar, '\t', '\n', '\f', '\r', ' ', '\"', '\'', '/', '<', '=', '>'};
    static final char[] attributeValueUnquoted = {nullChar, '\t', '\n', '\f', '\r', ' ', '\"', '&', '\'', '<', '=', '>', '`'};
    private static final char replacementChar = 65533;
    private static final String replacementStr = String.valueOf(replacementChar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void read(Tokeniser tokeniser, CharacterReader characterReader);

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleDataEndTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState) {
        if (characterReader.matchesLetter()) {
            String consumeLetterSequence = characterReader.consumeLetterSequence();
            tokeniser.tagPending.appendTagName(consumeLetterSequence);
            tokeniser.dataBuffer.append(consumeLetterSequence);
            return;
        }
        boolean z = true;
        if (tokeniser.isAppropriateEndTagToken() && !characterReader.isEmpty()) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(BeforeAttributeName);
            } else if (consume == '/') {
                tokeniser.transition(SelfClosingStartTag);
            } else if (consume == '>') {
                tokeniser.emitTagPending();
                tokeniser.transition(Data);
            } else {
                tokeniser.dataBuffer.append(consume);
            }
            z = false;
        }
        if (z) {
            tokeniser.emit("</" + tokeniser.dataBuffer.toString());
            tokeniser.transition(tokeniserState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readData(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        char current = characterReader.current();
        if (current == 0) {
            tokeniser.error(tokeniserState);
            characterReader.advance();
            tokeniser.emit(replacementChar);
        } else if (current == '<') {
            tokeniser.advanceTransition(tokeniserState2);
        } else if (current == 65535) {
            tokeniser.emit(new Token.EOF());
        } else {
            tokeniser.emit(characterReader.consumeToAny('<', nullChar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readCharRef(Tokeniser tokeniser, TokeniserState tokeniserState) {
        int[] consumeCharacterReference = tokeniser.consumeCharacterReference(null, false);
        if (consumeCharacterReference == null) {
            tokeniser.emit('&');
        } else {
            tokeniser.emit(consumeCharacterReference);
        }
        tokeniser.transition(tokeniserState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readEndTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.matchesLetter()) {
            tokeniser.createTagPending(false);
            tokeniser.transition(tokeniserState);
        } else {
            tokeniser.emit("</");
            tokeniser.transition(tokeniserState2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleDataDoubleEscapeTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.matchesLetter()) {
            String consumeLetterSequence = characterReader.consumeLetterSequence();
            tokeniser.dataBuffer.append(consumeLetterSequence);
            tokeniser.emit(consumeLetterSequence);
            return;
        }
        char consume = characterReader.consume();
        if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ' || consume == '/' || consume == '>') {
            if (tokeniser.dataBuffer.toString().equals("script")) {
                tokeniser.transition(tokeniserState);
            } else {
                tokeniser.transition(tokeniserState2);
            }
            tokeniser.emit(consume);
            return;
        }
        characterReader.unconsume();
        tokeniser.transition(tokeniserState2);
    }
}
