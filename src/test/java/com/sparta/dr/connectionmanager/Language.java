package com.sparta.dr.connectionmanager;

public enum Language {
    AFRIKAANS("af"),
    ALBANIAN("al"),
    ARABIC("ar"),
    AZERBAIJANI("az"),
    BULGARIAN("bg"),
    CATALAN("ca"),
    CZECH("cz"),
    DANISH("da"),
    GERMAN("de"),
    GREEK("el"),
    ENGLISH("en"),
    BASQUE("eu"),
    PERSIAN_FARSI("fa"),
    FINNISH("fi"),
    FRENCH("fr"),
    GALICIAN("gl"),
    HEBREW("he"),
    HINDI("hi"),
    CROATIAN("hr"),
    HUNGARIAN("hu"),
    INDONESIAN("id"),
    ITALIAN("it"),
    JAPANESE("ja"),
    KOREAN("kr"),
    LATVIAN("la"),
    LITHUANIAN("lt"),
    MACEDONIAN("mk"),
    NORWEGIAN("no"),
    DUTCH("nl"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    PORTUGUÊS_BRASIL("pt_br"),
    ROMANIAN("ro"),
    RUSSIAN("ru"),
    SWEDISH("sv, se"),
    SLOVAK("sk"),
    SLOVENIAN("sl"),
    SPANISH("sp, es"),
    SERBIAN("sr"),
    THAI("th"),
    TURKISH("tr"),
    UKRAINIAN("ua, uk"),
    VIETNAMESE("vi"),
    CHINESE_SIMPLIFIED("zh_cn"),
    CHINESE_TRADITIONAL("zh_tw"),
    ZULU("zu");

    private String value;

    Language(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
