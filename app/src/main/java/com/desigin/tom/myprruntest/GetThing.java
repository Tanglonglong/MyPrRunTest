package com.desigin.tom.myprruntest;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/1/8.
 */
public class GetThing {

    public static String doSomething(Context paramContext)
    {
        ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService(paramContext.ACTIVITY_SERVICE);
        String packgeName=null;
        try
        {
            if ((Build.VERSION.SDK_INT >= 21))
            {
                System.out.println("%%%5555555555555555555555555");
                packgeName = fuckTwo(localActivityManager, paramContext);
            }
            else
            {
                System.out.println("%%%0000000000000000000000000000000");
                String str = ((ActivityManager.RunningTaskInfo)localActivityManager.getRunningTasks(1).get(0)).topActivity.getPackageName();
                packgeName = str;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return packgeName;
    }

    public static String fuckTwo(ActivityManager paramActivityManager, Context paramContext)
    {
        String str=null;
        List localList = paramActivityManager.getRunningAppProcesses();
        ArrayList localArrayList = new ArrayList(localList.size());
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
            if (localRunningAppProcessInfo.importance == 100)
                localArrayList.addAll(Arrays.asList(localRunningAppProcessInfo.pkgList));
        }
        System.out.println("Current running processes: " + TextUtils.join(", ", localArrayList));
        if (localArrayList.size() > 0){
            str = (String)localArrayList.get(0);
        }

        return str;
    }


}
