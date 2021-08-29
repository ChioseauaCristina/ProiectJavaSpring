package com.Chioseaua.springbootsecondapp;

public class Administrator extends User{
    private String adminName;
    private String email;
    FileReplace fileReplace = new FileReplace();

    public void fileReplace(int i, String item, String item1) {
        fileReplace.updateFile(i, item, item1);
    }
    public void fileReplace(String item) {
        fileReplace.updateFile(item);
    }
}
