package com.lld.designPatterns.behavioral.chainOfResponsibility;

/* Application Usage: ATM/Vending Machine/Design Logger */

public class Client {
    public static void main(String[] args) {
        System.out.println("Chain of Responsibility!");

        LogProcessor logObj = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logObj.log(LogProcessor.INFO, "just for info");
        logObj.log(LogProcessor.ERROR, "exception happend");
        logObj.log(LogProcessor.DEBUG, "need to debug this");
    }
}
