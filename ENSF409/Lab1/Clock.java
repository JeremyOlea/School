class Clock {

    private int day; 
    private int hour;
    private int minute;
    private int second;

    private int getDay() {
        return day;
    }

    private int getHour() {
        return hour;
    }

    private int getMinute() {
        return minute;
    }

    private int getSecond() {
        return second;
    }

    private void setDay(int time) {
        day = time;
    }

    private void setHour(int time) {
        if(time < 23 || time > 0)
            hour = time;
        else
            System.out.println("Invalid time: Hour remains unchanged");
    }

    private void setMinute(int time) {
        if(time < 59 || time > 0)
            minute = time;
        else
            System.out.println("Invalid time: Minute remains unchanged");
    }

    private void setSecond(int time) {
        if(time < 59 || time > 0)
            second = time;
        else
            System.out.println("Invalid time: Second remains unchanged");
    }

    Clock() {
        day = 0;
        hour = 0;
        minute = 0;
        second = 0;
    }

    Clock(int day, int hour, int minute, int second) {
        this.day = day;
        this.hour = hour;
        this. minute = minute;
        this.second = second;
    }

    private void increment(int second) {
        this.second += second;
        if(this.second > 59) {
            minute += this.second / 60;
            this.second = this.second % 60;
            if(minute > 59) {
                hour += minute / 60;
                minute = minute % 60;
                if(hour > 23) {
                    day += hour / 24;
                    hour = hour % 24;
                }
                
            }
        }
    }

    private int calculateTotalSeconds() {
        int totalSeconds = day*86400 + hour*3600 + minute*60 + second;
        return totalSeconds;
    }

    public static void main(String[] args) {

        Clock t1 = new Clock();
        t1.setHour(23);
        t1.setDay(1);
        t1.setMinute(59);
        t1.setSecond(16);
        //prints: 1:23:59:16
        System.out.println(t1.getDay() + ":" + t1.getHour() + ":" + t1.getMinute() + ":" + t1.getSecond());

        t1.increment(44);
        //prints: 2:0:0:0
        System.out.println(t1.getDay() + ":" + t1.getHour() + ":" + t1.getMinute() + ":" + t1.getSecond());
        //prints: 172,800
        System.out.printf("The total elapsed time in seconds is %d\n", t1.calculateTotalSeconds());

        Clock t2 = new Clock(3, 1, 4, 5);
        t2.setHour(25);
        t2.setHour(17);
        t2.setMinute(55);
        t2.setSecond(59);

        System.out.println(t2.getDay() + ":" + t2.getHour() + ":" + t2.getMinute() + ":" + t2.getSecond());

        t2.increment(1000);
        System.out.println(t2.getDay() + ":" + t2.getHour() + ":" + t2.getMinute() + ":" + t2.getSecond());

        System.out.printf("The total elapsed time in seconds is %d\n", t2.calculateTotalSeconds());
    }

}