package com.example.soncord_1;

import java.util.List;

public class HDRMain {
    public static void main(String[] args) {
        // Example code
        //1. setting
        HDR hdr = new HDR();
        hdr.setLeftACPTA(90);
        hdr.setRightACPTA(19);
        hdr.setLeftBCPTA(70);
        hdr.setRightBCPTA(15, 55, 70);
        hdr.setLeftWRS(35);
        hdr.setRightWRS(35);

        //2. run
        List<HDR_RANGE> outputList = hdr.calculate();

        //3. output
        for(HDR_RANGE out : outputList) {
            System.out.println(out + ", Help msg:" + hdr.getHearingAidsHelpMsg(out));
        }

    }

}