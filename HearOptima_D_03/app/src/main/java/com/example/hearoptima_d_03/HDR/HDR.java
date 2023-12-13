package com.example.hearoptima_d_03.HDR;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class HDR { //Hearing Device Recommender

    private float leftACPTA = 0;
    private float rightACPTA = 0;
    private float leftBCPTA = 0;
    private float rightBCPTA = 0;
    private float leftWRS = 0;
    private float rightWRS = 0;


//    public HDR() {
//        this.leftACPTA = 25; //Normal 0~25
//        this.rightACPTA = 25;
//        this.leftBCPTA = 25;
//        this.rightBCPTA = 25;
//        this.leftWRS = 90; //Normal 90~100%
//        this.rightWRS = 90;
//    }

    public void setLeftACPTA(float leftACPTA) {
        this.leftACPTA = leftACPTA;
        Log.v("왼쪽 값들", "setLeftACPTA: " + leftACPTA); // leftACPTA 설정 로그
    }
    private float getLeftACPTA() {
        Log.v("왼쪽 값들", "getLeftACPTA: " + leftACPTA); // leftACPTA 반환 로그
        return leftACPTA;
    }
    public void setLeftBCPTA(float leftBCPTA) {
        this.leftBCPTA = leftBCPTA;
        Log.v("왼쪽 값들", "setLeftBCPTA: " + leftBCPTA); // leftBCPTA 설정 로그
    }
    private float getLeftBCPTA() {
        Log.v("왼쪽 값들", "getLeftBCPTA: " + leftBCPTA); // leftBCPTA 반환 로그
        return leftBCPTA;
    }
    public void setLeftWRS(float wrs) {
        this.leftWRS = wrs;
        Log.v("왼쪽 값들", "setLeftWRS: " + wrs); // leftWRS 설정 로그
    }
    private float getLeftWRS() {
        Log.v("왼쪽 값들", "getLeftWRS: " + leftWRS); // leftWRS 반환 로그
        return leftWRS;

    }


    public void setRightACPTA(float rightACPTA) {
        this.rightACPTA = rightACPTA;
        Log.v("오른쪽 값들", "setRightACPTA: " + rightACPTA); // leftACPTA 설정 로그
    }
    private float getRightACPTA() {
        Log.v("오른쪽 값들", "getRightACPTA: " + rightACPTA); // leftACPTA 반환 로그
        return rightACPTA;
    }
    public void setRightBCPTA(float rightBCPTA) {
        this.rightBCPTA = rightBCPTA;
        Log.v("오른쪽 값들", "setRightBCPTA: " + rightBCPTA); // leftBCPTA 설정 로그
    }
    private float getRightBCPTA() {
        Log.v("오른쪽 값들", "getRightBCPTA: " + rightBCPTA); // leftBCPTA 반환 로그
        return rightBCPTA;
    }
    public void setRightWRS(float wrs) {
        this.rightWRS = wrs;
        Log.v("오른쪽 값들", "setRightWRS: " + wrs); // leftWRS 설정 로그
    }
    public float getRightWRS() {
        Log.v("오른쪽 값들", "getRightWRS: " + rightWRS); // leftWRS 반환 로그
        return rightWRS;
    }

    private boolean checkCROS(){
        boolean retVal = false;

        if(getBadACPTA() >= 90 && getBadWRS() <= 40 && getGoodACPTA() < 20) {
            retVal = true;
        }
        return retVal;
    }
    private boolean checkSingleSidedDeafness() {
        boolean retVal = false;

        if(getBadACPTA() >= 90 && getBadWRS() <= 40){
            retVal = true;
        }
        return retVal;
    }
//    private boolean checkSingleSidedDeafness() {
//        boolean retVal = false;
//
//        if(getBadACPTA() >= 90 && getBadWRS() <= 40 && getGoodACPTA() < 20) {
//            retVal = true;
//        }
//        return retVal;
//    }

    private boolean checkBiCROS() {
        boolean retVal = false;

        if(getBadACPTA() >= 90 && getBadWRS() <= 40 && getGoodACPTA() >= 20 && getGoodWRS() >= 50) {
            retVal = true;
        }
        return retVal;
    }

    private float getBadACPTA() {
        return Math.max(getLeftACPTA(), getRightACPTA());
    }

    private float getGoodACPTA() {
        return Math.min(getLeftACPTA(), getRightACPTA());
    }

    private float getBadWRS() {
        return Math.min(getLeftWRS(), getRightWRS());
    }

    private float getGoodWRS() {
        return Math.max(getLeftWRS(), getRightWRS());
    }

    private float getLeftABG() {
        return Math.abs(getLeftACPTA() - getLeftBCPTA());
    }

    private float getRightABG() {
        return Math.abs(getRightACPTA() - getRightBCPTA());
    }

    private enum OI { None, Active, Traditional }
    private OI checkOsseointegratedImplant(float acPTA, float bcPTA, float ABG, float WRS) {
        OI retVal = OI.None;
        if(acPTA >= 25 && bcPTA <= 55 && ABG >= 10 && WRS >= 50) {
            retVal = OI.Active;
        }
        else if(acPTA >= 25 && bcPTA <= 65 && ABG >= 10 && WRS >= 50) {
            retVal = OI.Traditional;
        }
        return retVal;
    }

    private boolean checkOverTheCounter(float acPTA) {
        boolean retVal = false;
        if(acPTA >= 25 && acPTA <= 60) {
            retVal = true;
        }
        return retVal;
    }

    private boolean checkAirConductionHearingAids(float acPTA) {
        boolean retVal = false;
        if(acPTA >= 25) {
            retVal = true;
        }
        return retVal;
    }

    private WRS_RANGE checkWRSLevel(float WRS) {
        WRS_RANGE retValue = WRS_RANGE.NONE;
        if(WRS >= 90) {
            retValue = WRS_RANGE.EXCELLENT;
        }
        else if(WRS >= 80) {
            retValue = WRS_RANGE.GOOD;
        }
        else if(WRS >= 65) {
            retValue = WRS_RANGE.FAIR_TO_MODERATE;
        }
        else if(WRS >= 50) {
            retValue = WRS_RANGE.POOR;
        }
        else {
            retValue = WRS_RANGE.VERY_POOR;
        }
        return retValue;
    }

    public WRS_RANGE getHearingAidsHelpMsg(HDR_RANGE range) {
        WRS_RANGE retVal = WRS_RANGE.NONE;
        switch(range) {
            case LeftOverTheCounterHearingAids:
            case LeftAirConductionHearingAids:
                retVal = checkWRSLevel(getLeftWRS());
                break;
            case RightOverTheCounterHearingAids:
            case RightAirConductionHearingAids:
                retVal = checkWRSLevel(getRightWRS());
                break;
            default:
                break;
        }
        return retVal;
    }

    public List<HDR_RANGE> calculate() {
        List<HDR_RANGE> outList = new LinkedList<HDR_RANGE>();

        OI leftOI = checkOsseointegratedImplant(
                getLeftACPTA(), getLeftBCPTA(), getLeftABG(), getLeftWRS() );
        OI rightOI = checkOsseointegratedImplant(
                getRightACPTA(), getRightBCPTA(), getRightABG(), getRightWRS() );
        boolean leftOTC = checkOverTheCounter(getLeftACPTA());
        boolean rightOTC = checkOverTheCounter(getRightACPTA());
        boolean leftACHA = checkAirConductionHearingAids(getLeftACPTA());
        boolean rightACHA = checkAirConductionHearingAids(getRightACPTA());

        if (checkCROS()){
            outList.add(HDR_RANGE.CROS);
        } else if (checkBiCROS()) {
            outList.add(HDR_RANGE.BiCROS);
        }
        if(getBadACPTA() >= 60 && getBadWRS() <= 60) {
            if(checkSingleSidedDeafness()) {
                outList.add(HDR_RANGE.CochlearImplantation_Single);
            }
            else {
                outList.add(HDR_RANGE.CochlearImplantation);
            }
        }
        else if(leftOI == OI.Active || leftOI == OI.Traditional ||
                rightOI == OI.Active || rightOI == OI.Traditional) {
            if(leftOI == OI.Active) {
                if(checkSingleSidedDeafness()) {
                    String LeftActiveOsseointegratedImplant_Single = "왼쪽만 난청 : 액티브 골전도 보청기";
                    outList.add(HDR_RANGE.LeftActiveOsseointegratedImplant_Single);
                    outList.add(HDR_RANGE.LeftBoneConductionHearingAids_Single);
                }
                else {
                    outList.add(HDR_RANGE.LeftActiveOsseointegratedImplant);
                    outList.add(HDR_RANGE.LeftBoneConductionHearingAids);
                }
            }
            else if(leftOI == OI.Traditional) {
                if(checkSingleSidedDeafness()) {
                    outList.add(HDR_RANGE.LeftTraditionalOsseointegratedImplant_Single);
                }
                else {
                    outList.add(HDR_RANGE.LeftTraditionalOsseointegratedImplant);
                }
            }

            if(rightOI == OI.Active) {
                if(checkSingleSidedDeafness()) {
                    outList.add(HDR_RANGE.RightActiveOsseointegratedImplant_Single);
                    outList.add(HDR_RANGE.RightBoneConductionHearingAids_Single);
                }
                else {
                    outList.add(HDR_RANGE.RightActiveOsseointegratedImplant);
                    outList.add(HDR_RANGE.RightBoneConductionHearingAids);
                }
            }
            else if(rightOI == OI.Traditional) {
                if(checkSingleSidedDeafness()) {
                    outList.add(HDR_RANGE.RightTraditionalOsseointegratedImplant_Single);
                }
                else {
                    outList.add(HDR_RANGE.RightTraditionalOsseointegratedImplant);
                }
            }
        }
//        else if(checkSingleSidedDeafness()) {
//            outList.add(HDR_RANGE.CROS);
//        }
//        else if(checkBiCROS()) {
//            outList.add(HDR_RANGE.BiCROS);
//        }
        else if(leftOTC || rightOTC) {
            if(leftOTC) {
                outList.add(HDR_RANGE.LeftOverTheCounterHearingAids);
                outList.add(HDR_RANGE.LeftAirConductionHearingAids);
            }
            if(rightOTC) {
                outList.add(HDR_RANGE.RightOverTheCounterHearingAids);
                outList.add(HDR_RANGE.RightAirConductionHearingAids);
            }
        }
        else if(leftACHA || rightACHA) {
            //left
            if(leftACHA) {
                outList.add(HDR_RANGE.LeftAirConductionHearingAids);
            }
            if(rightACHA) {
                outList.add(HDR_RANGE.RightAirConductionHearingAids);
            }
        }
        else {
            String Normal = "정상";
            outList.add(HDR_RANGE.Normal);
        }
        return outList;
    }

    private float calculatePTA(float hz500, float hz1000, float hz2000) {
        return (hz500 + hz1000 + hz2000)/3;
    }

    //Air Conduction PTA
    public void setLeftACPTA(float hz500, float hz1000, float hz2000) {
        this.leftACPTA = calculatePTA(hz500, hz1000, hz2000);
    }

    public void setRightACPTA(float hz500, float hz1000, float hz2000) {
        this.rightACPTA = calculatePTA(hz500, hz1000, hz2000);
    }

    //Bone Conduction PTA
    public void setLeftBCPTA(float hz500, float hz1000, float hz2000) {
        this.leftBCPTA = calculatePTA(hz500, hz1000, hz2000);
    }

    public void setRightBCPTA(float hz500, float hz1000, float hz2000) {
        this.rightBCPTA = calculatePTA(hz500, hz1000, hz2000);
    }
}
