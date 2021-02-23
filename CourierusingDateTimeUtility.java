package workout;

import java.time.LocalDate;
import java.util.Scanner;

public class CourierusingDateTimeUtility {
		public static double timeTravelledAtThisDate(LocalDate date, double workingHours) {
			String s = date.toString();
			String sub = s.substring(5);
			sub = "assignment.logistics_day11.D" + sub.substring(0,2) + sub.substring(3);
			try {
				Date dateObj = (Date)Class.forName(sub).newInstance();
				return dateObj.workingHours(workingHours);
			}
			catch(Exception ex) {
				return workingHours;
			}
		}
		
		public static double timeTravelledAtThisDay(LocalDate date, double workingHours) {
			String day = "assignment.logistics_day11." + date.getDayOfWeek().toString();
			try {
				Day dayObj = (Day)Class.forName(day).newInstance();
				return dayObj.workingHours(workingHours, date);
			}
			catch(Exception ex) {
				return workingHours;
			}
		}
		
		public static void main(String[] args) {
			System.out.println("Welcome to Courier Services");
			System.out.println("* * * * * * * * * * * * *");
			double distance; //= 90;
			double avgSpeed; //= 45;
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter the distance : ");
			distance=scan.nextDouble();
			System.out.println("Enter the Average Speed : ");
			avgSpeed=scan.nextDouble();
			double time = distance/avgSpeed;
			double workingHours = 9;
			double timeTravelled;
			double startTimeOfDelivery = 9;
			LocalDate date = LocalDate.now();
			while(time>workingHours) {
				timeTravelled = workingHours;
				timeTravelled = Math.min(timeTravelled, timeTravelledAtThisDate(date, workingHours));
				timeTravelled = Math.min(timeTravelled, timeTravelledAtThisDay(date, workingHours));
				time -= timeTravelled;
				date = date.plusDays(1);
			}
			System.out.println("Delivery at: "+date+" at time "+(startTimeOfDelivery+time));
		}
	}

	abstract class Day{
		public abstract double workingHours(double dailyWorkingHours, LocalDate date);
	}

	class SUNDAY extends Day{
		@Override
		public double workingHours(double dailyWorkingHours, LocalDate date) {
			return 0;
		}
	}

	class SATURDAY extends Day{
		@Override
		public double workingHours(double dailyWorkingHours, LocalDate date) {
			if(date.getDayOfMonth()>7)
				return 0;
			return dailyWorkingHours;
		}
	}

	abstract class Date{
		public abstract int workingHours(double dailyWorkingHours);
	}

	class D0101 extends Date{
		@Override
		public int workingHours(double dailyWorkingHours) {
			return 0;
		}
	}

	class D0126 extends Date{
		@Override
		public int workingHours(double dailyWorkingHours) {
			return 0;
		}
	}

	class D0815 extends Date{
		@Override
		public int workingHours(double dailyWorkingHours) {
			return 0;
		}
	}

	class D1002 extends Date{
		@Override
		public int workingHours(double dailyWorkingHours) {
			return 0;
		}
	}
