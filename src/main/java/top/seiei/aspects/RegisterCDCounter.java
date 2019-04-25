package top.seiei.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class RegisterCDCounter {

    public Map<Integer, Integer> cdCounts = new HashMap<>();

    @Pointcut("execution(* top.seiei.bean.CDPlayer.registerCD(Integer)) && args(cdId)")
    public void trackRegisterCD(int cdId) {};

    @AfterReturning("trackRegisterCD(cdId)")
    public void countTrack(int cdId) {
        Integer currentCount = cdCounts.containsKey(cdId) ? cdCounts.get(cdId) : 0;
        cdCounts.put(cdId, currentCount + 1);
    }
}
