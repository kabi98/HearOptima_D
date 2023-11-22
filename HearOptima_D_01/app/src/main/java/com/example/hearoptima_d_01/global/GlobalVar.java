package com.example.hearoptima_d_01.global;
//
//import com.example.hearfi_01.audioTest.PTT.PttThreshold;
//import com.example.hearfi_01.entity.HearingTest.HrTestGroup;
import com.example.hearoptima_d_01.entity.Utils.Account;

import java.util.ArrayList;

public class GlobalVar {

    public static int g_MenuNum = -1;
    public static String g_MenuType = "";
    public static String g_MenuSide = "";
/////////////////////////////////////////////////////////////

    public static int g_TestType = 0;
    public static int g_TestSide = 0;
    public static int g_PttRightDBHL = 0;
    public static int g_PttLeftDBHL = 0;

//
//    public static ArrayList<PttThreshold> g_alPttRightThreshold = new ArrayList<>();
//    public static ArrayList<PttThreshold> g_alPttLeftThreshold = new ArrayList<>();
//
//    public static HrTestGroup g_TestGroup = new HrTestGroup();


    public static int g_wrsNumber = 0;

    public static String g_RightResult = null;
    public static Integer g_RightCount = 0;
    public static Integer g_RightNum = 0;

    public static String g_LeftResult = null;
    public static Integer g_LeftCount = 0;

    public static Integer g_LeftNum = 0;
    public static Account g_AccLogin = new Account();
    public static Account g_AccJoin = new Account();

    public static int g_TgId = 0;
    public static int g_userVolume  = 0;

    public static int TG_ID = 0;
    public static int TS_ID = 0;
    public static int LIMIT = 0;
    public static int C_NUM = 0;
    public static int DAY = 1;

    //DAY_1 = 1일차
    //DAY_2 = 2일차
    //DAY_3 = 3일차
    //DAY_4 = 4일차
    //DAY_5 = 5일차
    //DAY_6 = 6일차
    //DAY_7 = 7일차
    //DAY_8 = 8일차
    //DAY_9 = 9일차
    //DAY_10 = 10일차

    public static int LEVEL=0;
    //LEVEL_1 = 초급 훈련
    //LEVEL_2 = 중급 훈련
    //LEVEL_3 = 도전 훈련


    public static int NOISE = 1;
    //NOISE_1 = 소음 없음
    //NOISE_2 = 옹알이 소음
    //NOISE_3 = 백색 소음
    //NOISE_4 = 음성 소음

    public static int TYPE =0;
    //TYPE_1 = 단어 훈련
    //TYPE_2 = 문장 훈련
    //TYPE_3 = 도전 훈련
    public static int WORD_STEP = 0;

    public static int SEN_TYPE = 0;

//    public static Account user = new Account(1,"01012345678","010-1234-5678","admin","추인하","male","19980928");
//
//    public static int USER_VOLUME= 7;
//
//    public static HrTestGroup T_GROUP = new HrTestGroup();
//    public static HrTestSet T_SET = new HrTestSet();
}

