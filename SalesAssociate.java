/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.annotation.Inherited;

/**
 * This is the SalesAssociate class file extends AbstractStoreEmployee class
 * file.
 *
 * @author Goteti Santosh Ravi Teja
 */
public class SalesAssociate extends AbstractStoreEmployee {

    private final double salesRate;

    /**
     * This is a argument constructor which Initializes variable salesRate and
     * need to call its super class to initialize other variables
     *
     * @param salesRate - The parameter Percentage of sales done by a
     * SalesAssociate is passed.
     * @param numberOfHoursWorked - The parameter Number of hours worked is
     * passed.
     * @param hourlyRate - The parameter Hourly Rate is passed.
     * @param storeDetails - The parameter Details of the Store is passed.
     * @param associateName - The parameter Name of the Sales Associate is
     * passed.
     * @param basePay - The parameter Base pay is passed.
     */
    public SalesAssociate(double salesRate, double numberOfHoursWorked, double hourlyRate,
            String storeDetails, String associateName, double basePay) {
        super(numberOfHoursWorked, hourlyRate, storeDetails, basePay, associateName);
        this.salesRate = salesRate;
    }

    /**
     * Returns the total commission of the Sales Associate in dollars.
     *
     * @return - This method returns the commission in dollars.
     */
    @Override
    public double calculateCommission() {
        if (getSalesRate() > 30) {
            return super.getBasePay() * COMMISSION_RATE;
        } else {
            return 0.0;
        }
    }

    /**
     * Returns calculated Pay of the Sales Associate. The calculated pay is the
     * sum of basePay, commission and the product of number of hours worked and
     * hourly rate.
     *
     * @return - This method returns Payment of the Sales Associate.
     */
    @Override
    public double calculatePay() {
        return super.getBasePay() + calculateCommission() + 
                (super.getNumberOfHoursWorked() * super.getHourlyRate())+bonusHour((int)getNumberOfHoursWorked());
    }

    /**
     * Checks if the employee should be awarded with a promotion.
     *
     * @return - This method returns boolean the eligibility status for
     * promotion for an employee.
     */
    @Override
    public boolean checkPromotionEligibility() {
        if (calculatePay() > 1000.0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Percentage of sales done by a SalesAssociate.
     *
     * @return- This method returns double Percentage of sales done by a
     * SalesAssociate.
     */
    public double getSalesRate() {
        return salesRate * 100;
    }

    /**
     * Returns the String representation of Sales. Append Super Class toString()
     * along with the Sales Rate.
     *
     * @return - This method returns a String representation of Sales and
     * Employee details.
     */
    @Override
    public String toString() {
        return super.toString() + "Sales Rate: " + getSalesRate() + "%";
    }

    @Override
    public boolean fired(){
        if (this.calculatePay() < 350) {
            return true;
        }else{
            return false;
        }
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