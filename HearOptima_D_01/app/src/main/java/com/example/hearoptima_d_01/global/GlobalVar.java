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
}

