package com.sparta.dr.connectionmanager;

public enum Language {
    AF("af"),
    AL("al"),
    AR("ar"),
    AZ("az"),
    BG("bg"),
    CA("ca"),
    CZ("cz"),
    DA("da"),
    DE("de"),
    EL("el"),
    EN("en"),
    EU("eu"),
    FA("fa"),
    FI("fi"),
    FR("fr"),
    GL("gl"),
    HE("he"),
    HI("hi"),
    HR("hr"),
    HU("hu"),
    ID("id"),
    IT("it"),
    JA("ja"),
    KR("kr"),
    LA("la"),
    LT("lt"),
    MK("mk"),
    NO("no"),
    NL("nl"),
    PL("pl"),
    PT("pt"),
    PT_BR("pt_br"),
    RO("ro"),
    RU("ru"),
    SV_SE("sv, se"),
    SK("sk"),
    SL("sl"),
    SP_ES("sp, es"),
    SR("sr"),
    TH("th"),
    TR("tr"),
    UA_UK("ua, uk"),
    VI("vi"),
    ZH_CN("zh_cn"),
    ZH_TW("zh_tw"),
    ZU("zu");

    private String value;

    Language(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
