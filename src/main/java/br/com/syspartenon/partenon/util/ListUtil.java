package br.com.syspartenon.partenon.util;

import java.util.List;

public class ListUtil {
    public static boolean contain(List sourceList, Object objectToVerify, String propertyToCompare) {
        for(Object o : sourceList){
            if(ReflectionUtil.equals(o, objectToVerify, propertyToCompare))
                return true;
        }
        return false;
    }
    
    public static void remove(List sourceList, Object objectToRemove, String propertyToCompare) {
        for(Object o : sourceList){
            if(ReflectionUtil.equals(o, objectToRemove, propertyToCompare)){
                sourceList.remove(o);
                break;
            }
        }
    }
}
