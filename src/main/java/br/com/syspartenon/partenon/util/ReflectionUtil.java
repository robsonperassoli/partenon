package br.com.syspartenon.partenon.util;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReflectionUtil {
    public static boolean equals(Object source, Object destination, String propertyToCompare){
        if(!source.getClass().equals(destination.getClass())) 
            return false;
        
        for(Field f : source.getClass().getDeclaredFields()){
            f.setAccessible(true);
            if(f.getName().equals(propertyToCompare)){
                Object sourceValue = getPropertyValue(source, propertyToCompare);
                Object destinationValue = getPropertyValue(destination, propertyToCompare);
                if(sourceValue == null || destinationValue == null){
                    if(sourceValue == null && destinationValue == null)
                        return true;
                    else
                        return false;
                }else
                    return sourceValue.equals(destinationValue);
            }
        }
        
        return false;
    }
    
    public static Object getPropertyValue(Object source, String property){
        for(Field f : source.getClass().getDeclaredFields()){
            f.setAccessible(true);
            if(f.getName().equals(property)){
                try {
                    return f.get(source);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ReflectionUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ReflectionUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
        }
        return null;
    }
}
