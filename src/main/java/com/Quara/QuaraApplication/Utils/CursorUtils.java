package com.Quara.QuaraApplication.Utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Component
public class CursorUtils {
    public static Boolean isValidCursor(String cursor) {
        if (cursor == null || cursor.isEmpty()) {
            return false;
        }
        try {
            LocalDateTime.parse(cursor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static LocalDateTime parseCursor(String cursor){
        if(!isValidCursor(cursor)){
            throw new IllegalArgumentException("Invalid cursor format");
        }
        return LocalDateTime.parse(cursor);
    }
}
