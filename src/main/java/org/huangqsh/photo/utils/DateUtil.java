package org.huangqsh.photo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.util.StringUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DateUtil {
	
	public static final int  DATE_SCOPE_DAY = 0;
    public static final int  DATE_SCOPE_WEEK = 1;
    public static final int  DATE_SCOPE_MONTH = 2;
    public static final int  DATE_ACCURACY_MILLISECOND = 0;
    public static final int  DATE_ACCURACY_SECOND = 1;
	
	private static final String[] DATE_FORMATE = new String[]{
		"yyyy-MM-dd HH:mm:ss.SSSSSS",
		"yyyy-MM-dd HH:mm:ss.SSS",
		"yyyy-MM-dd HH:mm:ss",
		"yyyy-MM-dd HH:mm",
		"yyyy-MM-dd",
		"yyyy/MM/dd HH:mm:ss.SSSSSS",
		"yyyy/MM/dd HH:mm:ss.SSS",
		"yyyy/MM/dd HH:mm:ss",
		"yyyy/MM/dd HH:mm",
		"yyyy/MM/dd",
		"yyyy/M/d H:m:s.SSSSSS",
		"yyyy/M/d H:m:s.SSS",
		"yyyy/M/d H:m:s",
		"yyyy/M/d H:m",
		"yyyy/M/d",
		"HH:mm:ss.SSSSSS",
		"HH:mm:ss.SSS",
		"HH:mm:ss",
		"HH:mm",
		"H:m:s.SSSSSS",
		"H:m:s.SSS",
		"H:m:s",
		"H:m"
	};

	public static String formatDateString(final Date date) {
		return formatDateString(date, null);
	}
	
	public static String formatDateString(final Date date, final String format) {
        // 格式化日期
        SimpleDateFormat objSimpleDateFormat = null;
        // 如果未设定格式，则赋给默认值。
        if (StringUtils.isEmpty(format)) {
            objSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            objSimpleDateFormat = new SimpleDateFormat(format);
        }
        // 返回格式化后的字符串
        return date == null ? "" : objSimpleDateFormat.format(date);
    }
	public static String formatDateStringByLocale(final Date date, final String format, Locale local) { 
		// 格式化日期
        SimpleDateFormat objSimpleDateFormat = null;
        // 如果未设定格式，则赋给默认值。
        if (StringUtils.isEmpty(format) && local == null) {
            objSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else if(StringUtils.isEmpty(format) && local != null){
            objSimpleDateFormat = new SimpleDateFormat(format, local);
        } else if(!StringUtils.isEmpty(format) && local == null) {
        	objSimpleDateFormat = new SimpleDateFormat(format);
        } else if(!StringUtils.isEmpty(format) && local != null) {
        	objSimpleDateFormat = new SimpleDateFormat(format, local);
        }
        // 返回格式化后的字符串
        return date == null ? "" : objSimpleDateFormat.format(date);
	}
	public static Date formatDate(final String dateString) {
		return formatDate(dateString, null);
	}
	
	public static Date formatDate(final String dateString, String format) {
        if (StringUtils.isEmpty(dateString) || StringUtils.isEmpty(dateString)) {
            return null;
        }
        Date objDate = null;
        // 如果未设定格式，则赋给默认值。
        if (StringUtils.isEmpty(format)) {
        	for (int i = 0, len = DATE_FORMATE.length; i < len; i++) {
        		format = DATE_FORMATE[i];
        		// 格式化日期
                SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat(format);
                try {// 解析时间，如果抛出异常的话就设为空
                	objDate = objSimpleDateFormat.parse(dateString);
                	break;
                } catch (Throwable e) {
                	if(log.isInfoEnabled()){
                		log.info("将时间字符串" + dateString + "解析成" + format + "格式时出错。");
                	}
                }
			}
        }else{
        	SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat(format);
        	try {// 解析时间，如果抛出异常的话就设为空
            	objDate = objSimpleDateFormat.parse(dateString);
            } catch (Throwable e) {
            	if(log.isInfoEnabled()){
            		log.info("将时间字符串" + dateString + "解析成" + format + "格式时出错。");
            	}
            }
        }
        // 返回生成的日期对象
        return objDate;
    }
	
	public static String convertDateFormat(String dateString, String formatFrom, String formatTo) {
        String newString = "";
        if (!StringUtils.isEmpty(dateString)) {
            SimpleDateFormat dateFormatForm = new SimpleDateFormat(formatFrom);
            SimpleDateFormat dateFormatTo = new SimpleDateFormat(formatTo);
            try {
                Date objTempDate = dateFormatForm.parse(dateString);
                newString = dateFormatTo.format(objTempDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return newString;
    }
	
	/**
     * 获得时间区间开始
     *
     * @param date 某个时间
     * @param scope 时间区间的范围，0表示一天，1表示一周，2表示一个月
     * @return 返回长度为2的时间数组，第一个是区间的开始时间，第二个是区间的结束时间，精确到秒
     */
    public static Date getDateScopeStart(Date date, int scope){
    	if(date == null){
    		return null;
    	}
    	return getDateScope(date, scope)[0];
    }
    
    /**
     * 获得时间区间结束
     *
     * @param date 某个时间
     * @param scope 时间区间的范围，0表示一天，1表示一周，2表示一个月
     * @param accuracy 控制精度，0为毫秒，1为秒
     * @return 返回长度为2的时间数组，第一个是区间的开始时间，第二个是区间的结束时间
     */
    public static Date getDateScopeStart(Date date, int scope, int accuracy) {
    	if(date == null){
    		return null;
    	}
    	return getDateScope(date, scope, accuracy)[0];
    }
    
    /**
     * 获得时间区间开始
     *
     * @param date 某个时间
     * @param scope 时间区间的范围，0表示一天，1表示一周，2表示一个月
     * @return 返回长度为2的时间数组，第一个是区间的开始时间，第二个是区间的结束时间，精确到秒
     */
    public static Date getDateScopeEnd(Date date, int scope){
    	if(date == null){
    		return null;
    	}
    	return getDateScope(date, scope)[1];
    }
    
    /**
     * 获得时间区间结束
     *
     * @param date 某个时间
     * @param scope 时间区间的范围，0表示一天，1表示一周，2表示一个月
     * @param accuracy 控制精度，0为毫秒，1为秒
     * @return 返回长度为2的时间数组，第一个是区间的开始时间，第二个是区间的结束时间
     */
    public static Date getDateScopeEnd(Date date, int scope, int accuracy) {
    	if(date == null){
    		return null;
    	}
    	return getDateScope(date, scope, accuracy)[1];
    }
    
	/**
     * 获得时间区间
     *
     * @param date 某个时间
     * @param scope 时间区间的范围，0表示一天，1表示一周，2表示一个月
     * @return 返回长度为2的时间数组，第一个是区间的开始时间，第二个是区间的结束时间，精确到秒
     */
    public static Date[] getDateScope(Date date, int scope){
    	return getDateScope(date, scope, DATE_ACCURACY_MILLISECOND);
    }
	
	/**
     * 获得时间区间
     *
     * @param date 某个时间
     * @param scope 时间区间的范围，0表示一天，1表示一周，2表示一个月
     * @param accuracy 控制精度，0为毫秒，1为秒
     * @return 返回长度为2的时间数组，第一个是区间的开始时间，第二个是区间的结束时间
     */
    public static Date[] getDateScope(Date date, int scope, int accuracy) {
        Date startDateOneDay = null;// 一天的开始时间
        Date endDateOneDay = null;// 一天的结束时间，这两个组成一天的时间区间
        Calendar objNowDate = Calendar.getInstance();
        objNowDate.setTime(date);
        int iYear = objNowDate.get(Calendar.YEAR);
        int iMonth = objNowDate.get(Calendar.MONTH);
        int iStartDay = objNowDate.get(Calendar.DAY_OF_MONTH);
        int iEndDay = iStartDay;
        iYear = objNowDate.get(Calendar.YEAR);
        if (scope == 2) {
            iStartDay = 1;// 只需把天设为1
            iEndDay = objNowDate.getActualMaximum(Calendar.DAY_OF_MONTH);
            objNowDate.set(iYear, iMonth, iStartDay, 0, 0, 0);
            if(accuracy == 0){
            	objNowDate.set(Calendar.MILLISECOND, 0);
            }
            startDateOneDay = objNowDate.getTime();
            objNowDate.set(iYear, iMonth, iEndDay, 23, 59, 59);
            if(accuracy == 0){
            	objNowDate.set(Calendar.MILLISECOND, 999);
            }
            endDateOneDay = objNowDate.getTime();
        } else if (scope == 1) {
            Calendar nowDate = Calendar.getInstance();
            nowDate.add(Calendar.DAY_OF_MONTH, 1 - nowDate.get(Calendar.DAY_OF_WEEK));
            nowDate.set(Calendar.HOUR_OF_DAY, 0);
            nowDate.set(Calendar.MINUTE, 0);
            nowDate.set(Calendar.SECOND, 0);
            if(accuracy == 0){
            	nowDate.set(Calendar.MILLISECOND, 0);
            }
            startDateOneDay = nowDate.getTime();
            Calendar nowDate1 = Calendar.getInstance();
            nowDate1.add(Calendar.DAY_OF_MONTH, 7 - nowDate1.get(Calendar.DAY_OF_WEEK));
            nowDate1.set(Calendar.HOUR_OF_DAY, 23);
            nowDate1.set(Calendar.MINUTE, 59);
            nowDate1.set(Calendar.SECOND, 59);
            if(accuracy == 0){
            	nowDate1.set(Calendar.MILLISECOND, 999);
            }
            endDateOneDay = nowDate1.getTime();
        } else if (scope == 0) {
            objNowDate.set(iYear, iMonth, iStartDay, 0, 0, 0);
            if(accuracy == 0){
            	objNowDate.set(Calendar.MILLISECOND, 0);
            }
            startDateOneDay = objNowDate.getTime();
            objNowDate.set(iYear, iMonth, iEndDay, 23, 59, 59);
            if(accuracy == 0){
            	objNowDate.set(Calendar.MILLISECOND, 999);
            }
            endDateOneDay = objNowDate.getTime();
        }

        return new Date[] { startDateOneDay, endDateOneDay };
    }
    
    /**
     * 返回跨越两个指定日期的日期和时间边界的数目。
     * @param flag 指定对日期的哪一部分计算差异的参数。0代表年，1代表月，2代表天，3代表小时，4代表分钟，5代表秒，6代表毫秒
     * @param startDate 计算中的开始日期
     * @param endDate 计算中的结束日期
     * @return
     */
    public static long DateDiffNew(int flag, Date startDate, Date endDate){
    	Calendar startCal = Calendar.getInstance();
    	startCal.setTime(startDate);
    	Calendar endCal = Calendar.getInstance();
    	endCal.setTime(endDate);
    	long count = 0;
    	if(flag == 0){
    		int startYearValue = startCal.get(Calendar.YEAR);
        	int endYearValue = endCal.get(Calendar.YEAR);
        	count = endYearValue - startYearValue;
    	}else if(flag == 1){
    		int startYearValue = startCal.get(Calendar.YEAR);
        	int endYearValue = endCal.get(Calendar.YEAR);
        	int startMonthValue = startCal.get(Calendar.MONTH);
        	int endMonthValue = endCal.get(Calendar.MONTH);
        	count = (endYearValue - startYearValue) * 12 + endMonthValue - startMonthValue;
    	}else if(flag == 2){
    		startDate = trimToDay(startDate);
    		endDate = trimToDay(endDate);
    		count = (endDate.getTime() - startDate.getTime())/3600000/24;
    	}else if(flag == 3){
    		startDate = trimDate(startDate, 3);
    		endDate = trimDate(endDate, 3);
    		count = (endDate.getTime() - startDate.getTime())/3600000;
    	}else if(flag == 4){
    		startDate = trimDate(startDate, 4);
    		endDate = trimDate(endDate, 4);
    		count = (endDate.getTime() - startDate.getTime())/60000;
    	}else if(flag == 5){
    		startDate = trimDate(startDate, 5);
    		endDate = trimDate(endDate, 5);
    		count = (endDate.getTime() - startDate.getTime())/1000;
    	}else if(flag == 6){
    		count = endDate.getTime() - startDate.getTime();
    	}
    	return count;
    }
    
    /**
     * 某一时间类型前的时间
     * @param nowDate
     * @return
     */
    public static Date prevDay(int datepart, int count, Date nowDate){
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(nowDate);
    	calendar.add(datepart, count);
    	return calendar.getTime();
    }
    
    /**
     * 将时间部分置0，日期部分不变
     * @param date
     * @return
     */
    public static Date trimToDay(Date date){
    	return trimDate(date, 2);
    }
    
    public static Date trimToYear(Date date){
    	return trimDate(date, 0);
    }
    
    public static Date trimToMonth(Date date){
    	return trimDate(date, 1);
    }
    
    public static Date trimToHour(Date date){
    	return trimDate(date, 3);
    }
    
    public static Date trimToMinute(Date date){
    	return trimDate(date, 4);
    }
    
    public static Date trimToSecond(Date date){
    	return trimDate(date, 5);
    }
    
    /**
     * 将时间部分置0
     * @param date
     * @param flag 0代表年，1代表月，2代表天，3代表小时，4代表分钟，5代表秒，6代表毫秒
     * @return
     */
    public static Date trimDate(Date date, int flag){
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	Date newDate = null;
    	if(flag == 0){
    		cal.set(Calendar.MONTH, 0);
    		cal.set(Calendar.DAY_OF_MONTH, 1);
    		cal.set(Calendar.HOUR_OF_DAY, 0);
        	cal.set(Calendar.MINUTE, 0);
        	cal.set(Calendar.SECOND, 0);
        	cal.set(Calendar.MILLISECOND, 0);
    	}else if(flag == 1){
    		cal.set(Calendar.DAY_OF_MONTH, 1);
    		cal.set(Calendar.HOUR_OF_DAY, 0);
        	cal.set(Calendar.MINUTE, 0);
        	cal.set(Calendar.SECOND, 0);
        	cal.set(Calendar.MILLISECOND, 0);
    	}else if(flag == 2){
    		cal.set(Calendar.HOUR_OF_DAY, 0);
        	cal.set(Calendar.MINUTE, 0);
        	cal.set(Calendar.SECOND, 0);
        	cal.set(Calendar.MILLISECOND, 0);
    	}else if(flag == 3){
    		cal.set(Calendar.MINUTE, 0);
        	cal.set(Calendar.SECOND, 0);
        	cal.set(Calendar.MILLISECOND, 0);
    	}else if(flag == 4){
    		cal.set(Calendar.SECOND, 0);
        	cal.set(Calendar.MILLISECOND, 0);
    	}else if(flag == 5){
    		cal.set(Calendar.MILLISECOND, 0);
    	}else if(flag == 6){
    		//do nothing
    	}
    	newDate = cal.getTime();
    	return newDate;
    }
    /**
     *
     * @param inDate
     * @return 当前时期+inDate的时间
     */
    public static Date setDateToNow( Date inDate){
    	Calendar inCal = Calendar.getInstance();
    	Calendar nowCal = Calendar.getInstance();
    	inCal.setTime(inDate);
        nowCal.setTime(new Date());
        int year = nowCal.get(Calendar.YEAR);
        int month = nowCal.get(Calendar.MONTH);
        int day = nowCal.get(Calendar.DAY_OF_YEAR);
        inCal.set(Calendar.YEAR, year);
        inCal.set(Calendar.MONTH, month);
        inCal.set(Calendar.DAY_OF_YEAR, day);
        return inCal.getTime();
    }
    /**
     * 将时间转为CRON表达式
     * @param date
     * @return
     */
    public static String toCronExpression(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		StringBuilder sb = new StringBuilder();
		sb.append(cal.get(Calendar.SECOND));
		sb.append(" ");
		sb.append(cal.get(Calendar.MINUTE));
		sb.append(" ");
		sb.append(cal.get(Calendar.HOUR_OF_DAY));
		sb.append(" ");
		sb.append(cal.get(Calendar.DAY_OF_MONTH));
		sb.append(" ");
		sb.append(cal.get(Calendar.MONTH) + 1);
		sb.append(" ? ");
		sb.append(cal.get(Calendar.YEAR));
		return sb.toString();
	}
    
    /**
     * 获取传入时间月份的第一天
     * @param date
     * @return
     */
    public static Date getStartOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
        return calendar.getTime();
    }
    /**
     * 获取传入时间月份的最后一天
     * @param date
     * @return
     */
    public static Date getEndOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));//设置为1号,当前日期既为本月第一天 
        return calendar.getTime();  	
    }
    
    public static Calendar getCalendar(Date date){
    	Calendar cal = Calendar.getInstance();
    	if(date != null){
    		cal.setTime(date);
    	}
    	return cal;
    }

}
