package kg.megacom.NaTv.utils.models;

public enum Language {

    UNKNOWN,
    KG,
    RU;


    public static Language getLang(int langId){
        switch (langId){
            case 1:return KG;
            case 2:return RU;
            default:return RU;
        }
    }
}
