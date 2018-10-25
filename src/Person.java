public class Person {
    private int daysOfWorking;
    private boolean isEmployed;
    private double score;
    public Person(){
        this.daysOfWorking = 0;
        this.isEmployed = false;
        this.score = 1.00;
    }

    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public int getDaysOfWorking() {
        return daysOfWorking;
    }
    public void addDaysOfWorking() {
        this.daysOfWorking += 1;
    }

    public boolean getIsEmployed() {
        return isEmployed;
    }

    public void employ() {
        isEmployed = true;
    }
    public void unemploy(){isEmployed = false; }
}
