package com.necer.calendar;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.necer.enumeration.CalendarState;
import com.necer.utils.Attrs;
import com.necer.utils.AttrsUtil;

import org.joda.time.LocalDate;

import java.util.List;

/**
 * 华为日历
 * Created by necer on 2018/11/14.
 */
public class EmuiCalendar extends NCalendar {
    public EmuiCalendar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected float getMonthCalendarAutoWeekEndY() {
        return -monthHeight * 4 / 5;
    }

    @Override
    protected float getMonthYOnWeekState(LocalDate localDate) {
        return weekHeight - monthHeight;
    }

    @Override
    protected float getGestureMonthUpOffset(float dy) {
        return getGestureChildUpOffset(dy);
    }

    @Override
    protected float getGestureMonthDownOffset(float dy) {
        return getGestureChildDownOffset(dy);
    }

    @Override
    protected float getGestureChildDownOffset(float dy) {
        float maxOffset = monthHeight - childView.getY();
        return getOffset(Math.abs(dy), maxOffset);
    }

    @Override
    protected float getGestureChildUpOffset(float dy) {
        float maxOffset = childView.getY() - weekHeight;
        return getOffset(dy, maxOffset);
    }


    @Override
    protected void setWeekVisible(boolean isUp) {

        if (monthCalendar.getVisibility() != VISIBLE) {
            monthCalendar.setVisibility(VISIBLE);
        }

        if (calendarState == CalendarState.MONTH && isMonthCalendarWeekState() && isUp && weekCalendar.getVisibility() != VISIBLE) {
            weekCalendar.setVisibility(VISIBLE);
        } else if (calendarState == CalendarState.WEEK && monthCalendar.getY() <= -monthCalendar.getDistanceFromTop(weekCalendar.getFirstDate()) && weekCalendar.getVisibility() != VISIBLE) {
            weekCalendar.setVisibility(VISIBLE);
        } else if (monthCalendar.getY() >= -monthCalendar.getDistanceFromTop(weekCalendar.getFirstDate()) && !isUp && weekCalendar.getVisibility() != INVISIBLE) {
            weekCalendar.setVisibility(INVISIBLE);
        }
    }


}
