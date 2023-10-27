package com.example.hearoptima_d_01.global;

public final class TConst {
    public static final String DB_FILE = "HearingAidSearch.db";
    public static final int DB_VER = 1;

    public static final String DEFAULT_PHONE = "A24";
    public static final String DEFAULT_DEVICE = "BUDS2";

    public static final  int NO_HEARING = 0;
    public static final  int HEARING = 1;

    public static final int T_RIGHT = 11;
    public static final int T_LEFT = 12;

    public static final int HZ_ORDER [] = { 1000, 2000, 4000, 8000, 500, 250 };
    public static final int MIN_DBHL = 0;
    public static final int MAX_DBHL = 100;

    public static final int HEARING_LOSS_PTA []     = {20,      40,         55,         70,         90,         100};
    public static final String HEARING_LOSS_STR []  = {"정상",   "경도난청",  "중도난청",  "중고도난청", "고도난청",  "심도난청"};

    public static final int T_PTT = 21;
    public static final int T_WRS = 22;

    public static final String STR_PTT_TYPE = "PTA";
    public static final String STR_WRS_TYPE = "WRS";

    public static final String STR_LEFT_SIDE = "LEFT";
    public static final String STR_RIGHT_SIDE = "RIGHT";

    public static final String STR_GENDER_MALE = "남";
    public static final String STR_GENDER_FEMALE = "여";

}
