//code for example 

import java.util.Scanner;
 import java.util.*;
 import java.util.List;
 
public class SalaryCalculation {

private static double HourlyWageConst = 0;

....

public static double SixDays(double HourlyWageConst)				//Function to calculate salary for six days week
	{
		System.out.println("Six Days Work:");
		
		double ConstRegularWorkHour5Day = 8;						//Constants for the function
		double ConstAdditionalWorkHour1255Day = 10;
		double ConstNormalWorkWeekHours = 42;
		double ConstHoursBetweenRegilarTo150Per = 2;
		
		double RegularWorkingHours = 0;								//System variables for the function
		double AdditionalWorkHours125per = 0;
		double AdditionalWorkHours150per = 0;
		double WeeklyAdditionalHours = 0;
		double HourlyWage =  HourlyWageConst;
		double DailyWorkingHours = 0;
		
		
		int j = 0;													//An array of days
		List<String> day_num = new ArrayList<String>();
		day_num.add("DAY 1");
		day_num.add("DAY 2");
		day_num.add("DAY 3");
		day_num.add("DAY 4");
		day_num.add("DAY 5");
		day_num.add("DAY 6");
		
		for(int i=0; i<6; i++)										//Summarized workdays loop
		{
			
			System.out.println(day_num.get(j));
			j++;
			
			Scanner scan11 = new Scanner( System.in );				//enter work hours
			System.out.println("Please enter your Daily Working Hours: ");
			DailyWorkingHours = scan11.nextDouble();
			
			if(DailyWorkingHours<=ConstRegularWorkHour5Day)			//case only regular hours				
			{
				RegularWorkingHours=RegularWorkingHours+DailyWorkingHours;
				System.out.println("Detail hours: " + " Regular Working Hours: "+ DailyWorkingHours);
			}
			else if(ConstRegularWorkHour5Day<DailyWorkingHours && DailyWorkingHours<=ConstAdditionalWorkHour1255Day)		//case regular + 125% hours
			{
				RegularWorkingHours= RegularWorkingHours + ConstRegularWorkHour5Day;
				AdditionalWorkHours125per = (DailyWorkingHours - ConstRegularWorkHour5Day) + AdditionalWorkHours125per;
				System.out.println("Detail hours: "+" Regular Working Hours: "+ ConstRegularWorkHour5Day + " + Additional Work Hours 125%: " + (DailyWorkingHours-ConstRegularWorkHour5Day)  );
			}
			else if( DailyWorkingHours > ConstAdditionalWorkHour1255Day)													//case regular + 125% + 150% hours
			{
				RegularWorkingHours =RegularWorkingHours +ConstRegularWorkHour5Day;
				AdditionalWorkHours125per = AdditionalWorkHours125per + ConstHoursBetweenRegilarTo150Per;
				AdditionalWorkHours150per = (DailyWorkingHours - ConstAdditionalWorkHour1255Day) + AdditionalWorkHours150per;
				System.out.println("Detail hours: "+" Regular Working Hours: " + ConstRegularWorkHour5Day + " + Additional Work Hours 125%: " + ConstHoursBetweenRegilarTo150Per + " + Additional Work Hours 150%: " + (DailyWorkingHours-ConstAdditionalWorkHour1255Day));
			}
		}
		
		if (RegularWorkingHours > ConstNormalWorkWeekHours)			//case have more then standard regular work hours for week
		{
			AdditionalWorkHours125per = (RegularWorkingHours - ConstNormalWorkWeekHours) + AdditionalWorkHours125per;
			WeeklyAdditionalHours = (RegularWorkingHours - ConstNormalWorkWeekHours);
			RegularWorkingHours = ConstNormalWorkWeekHours;
		}
		
		System.out.println("Your Regular Working Hours: " + RegularWorkingHours);				//print detail salary and hours for week
		System.out.println("Your Additional Work Hours 125%: " + AdditionalWorkHours125per);
		System.out.println("Your Additional Work Hours 150%: " + AdditionalWorkHours150per);
		System.out.println("Your Weekly Additional Hours 125% (Included in Additional Work Hours 125%): " + WeeklyAdditionalHours);
		double HourlyWage125per = HourlyWage +0.25*HourlyWage;
		double HourlyWage150per = HourlyWage +0.5*HourlyWage;

		double WeeklySalary= (RegularWorkingHours*HourlyWage) + (AdditionalWorkHours125per*HourlyWage125per)+ (AdditionalWorkHours150per*HourlyWage150per);

		System.out.println("Your Weekly Salary is: " + WeeklySalary + " N.I.S.");
		return WeeklySalary;
	}
