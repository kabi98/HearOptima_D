package com.example.hearoptima_d_01.HDR;

//UHS-Unilateral Hearing Loss, Single sided deafness
public enum HDR_RANGE {
    Normal("정상"),
    CochlearImplantation("인공와우"),
    CochlearImplantation_Single("한쪽 인공와우"),
    LeftActiveOsseointegratedImplant("양쪽 난청 : 왼쪽은 액티브 골전도 보청기"),
    RightActiveOsseointegratedImplant("양쪽 난청 : 오른쪽은 액티브 골전도 보청기"),
    LeftActiveOsseointegratedImplant_Single("왼쪽만 난청 : 액티브 골전도 보청기"),
    RightActiveOsseointegratedImplant_Single("오른쪽만 난청 : 액티브 골전도 보청기"),
    LeftTraditionalOsseointegratedImplant("양쪽 난청 : 왼쪽은 골전도 보청기(수술)"),
    RightTraditionalOsseointegratedImplant("양쪽 난청 : 오른쪽은 골전도 보청기(수술)"),
    LeftTraditionalOsseointegratedImplant_Single("왼쪽만 난청 : 골전도 보청기(수술)"),
    RightTraditionalOsseointegratedImplant_Single("오른쪽만 난청 : 골전도 보청기(수술)"),
    LeftAirConductionHearingAids("왼쪽 기본 보청기"),
    RightAirConductionHearingAids("오른쪽 기본 보청기"),
    CROS("크로스 보청기"),
    BiCROS("바이크로스 보청기"),
    LeftBoneConductionHearingAids("양쪽 난청 : 왼쪽은 골전도 보청기(착용)"),
    RightBoneConductionHearingAids("양쪽 난청 : 오른쪽은 골전도 보청기(착용)"),
    LeftBoneConductionHearingAids_Single("왼쪽만 난청 : 골전도 보청기(착용)"),
    RightBoneConductionHearingAids_Single("오른쪽만 난청 : 골전도 보청기(착용)"),
    LeftOverTheCounterHearingAids("왼쪽 오티씨 보청기"),
    RightOverTheCounterHearingAids("오른쪽 오티씨 보청기");

    private final String description;

    HDR_RANGE(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}