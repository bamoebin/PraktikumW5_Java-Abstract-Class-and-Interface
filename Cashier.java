public class Cashier extends AbstractStoreEmployee {

    // Menambahkan variabel khusus untuk Cashier, jam kerja.
    private double TheirOvertime;

    // Konstruktor untuk Cashier
    public Cashier(double numberOfHoursWorked, double hourlyRate, String storeDetails,
                   double basePay, String employeeName, double overtime) {
        super(numberOfHoursWorked, hourlyRate, storeDetails, basePay, employeeName);
        this.TheirOvertime = overtime;
    }

    public double getOvertime(){
        return this.TheirOvertime;
    }

    // Implementasi dari method abstract di AbstractStoreEmployee
    @Override
    public double calculatePay() {
        return super.getBasePay() + (super.getHourlyRate() * TheirOvertime) + bonusHour((int)getNumberOfHoursWorked());
    }

    // Implementasi dari method abstract di Employee interface
    @Override
    public boolean checkPromotionEligibility() {
        if (calculatePay() > 1000.0) {

            return true;
        } else {

            return false;
        }
    }

    @Override
    public boolean fired(){
        if (this.calculatePay() < 300) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Store Details: " + getStoreDetails()+ "\nEmployee Name: " + getEmployeeName()
                + "\nBase Pay: $" + getBasePay() + "\nNumber of Hours worked: " + getNumberOfHoursWorked() + "hrs"
                + "\nPayment Rate per hour: $" + getHourlyRate() + "/hr"+"\nOvertime hours : "+ getOvertime()+" hour/s";
    }

    @Override
    public double bonusHour(int hour){
        int shiftHour = hour;
        double bonuses = 0;
        while (shiftHour >= 0) {
            if (shiftHour >= 50) {
                bonuses += 20;
                shiftHour -=50;
            }else{break;}
        }
        return bonuses;
    }
}

