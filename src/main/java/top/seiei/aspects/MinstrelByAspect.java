package top.seiei.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import top.seiei.bean.Minstrel;

@Aspect
public class MinstrelByAspect {

    @Autowired
    private Minstrel minstrel;

    /**
     * @Poincut 注释用于定义命名的切点
     */
    @Pointcut("execution(* top.seiei.bean.BraveKnight.embarkOnQuest(..))")
    public void embarkOnQuest() {}

    @Before("embarkOnQuest()")
    public void singBeforeQuest() {
        minstrel.singBeforeQuest();
    }

    @AfterReturning("embarkOnQuest()")
    public void singAfterQuest() {
        minstrel.singAfterQuest();
    }

    /**
     * 环绕通知需要接受一个 ProceedingJoinPoint 对象作为参数，它实质存储了被通知的方法
     * 在通知方法中做完所需要的事情后，一定要将控制权交给被通知的方法，此时调用 ProceedingJoinPoint 的 proceed 方法
     * 当然，不交还控制权也是可以的
     * @param joinPoint
     */
    @Around("embarkOnQuest()")
    public void singAroundQuest(ProceedingJoinPoint joinPoint) {
        try {
            minstrel.singBeforeQuest();
            joinPoint.proceed();
            minstrel.singAfterQuest();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
