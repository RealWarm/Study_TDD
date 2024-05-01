package com.study.tdd.chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) return PasswordStrength.INVALID;
        boolean lengthEnough = s.length() >=8;
        boolean containsNum = meetsContainingNumberCriteria(s);
        boolean containsUpp = meetsContainingUppercaseCriteria(s);

        if(lengthEnough && !containsNum && !containsUpp){
            return  PasswordStrength.WEAK;
        }
        if(!lengthEnough && containsNum && !containsUpp){
            return  PasswordStrength.WEAK;
        }
        if(!lengthEnough && !containsNum && containsUpp){
            return  PasswordStrength.WEAK;
        }
        if(!lengthEnough) {
            return PasswordStrength.NORMAL;
        }
        if (!containsNum) return PasswordStrength.NORMAL;
        if (!containsUpp) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;

    }//meter

    private boolean meetsContainingUppercaseCriteria(String s) {
        for(char ch : s.toCharArray()){
            if(Character.isUpperCase(ch)){
                return true;
            }
        }
        return false;
    }//meetsContainingUppercaseCriteria

    private boolean meetsContainingNumberCriteria(String s) {
        for(char ch : s.toCharArray()){
            if(ch>='0' && ch<=9){
                return true;
            }
        }
        return false;
    }//meetsContainingNumberCriteria


}