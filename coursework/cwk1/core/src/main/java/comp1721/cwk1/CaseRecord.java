package comp1721.cwk1;

import java.time.LocalDate;

public class CaseRecord {
    //fields for the CaseRecord class
    private LocalDate date;
    private int staffCases;
    private int studentCases;
    private int otherCases;

    //constructor with 4 variables
    public CaseRecord(LocalDate d, int staff, int student, int other){
        date = d;
        if( checkStaffCases(staff)){
            staffCases = staff;
        }

        if(checkStudentCases(student)) {
            studentCases = student;
        }

        if(checkOtherCases(other)){
            otherCases = other;
        }
    }


    //
    //getter methods for the class
    //
    public LocalDate getDate(){
        return date;
    }

    public int getStaffCases(){
        return staffCases;
    }

    public int getStudentCases(){
        return studentCases;
    }

    public int getOtherCases(){
        return otherCases;
    }

    public int totalCases(){
        int total;
        total = staffCases + studentCases + otherCases;
        return total;
    }

    //override the default toString method
    @Override
    public String toString(){
        
        return String.format("%s: %d staff, %d students, %d other",date,
                staffCases, studentCases, otherCases);
    }

    //
    //these methods checks that the fields have a value grater than 0
    //

    public boolean checkStaffCases(int staff){
        if(staff < 0){
            throw new DatasetException("Number of staff cases should be >= 0");
        }else{
            staffCases = staff;
            return true;
        }
    }

    public boolean checkStudentCases(int student){
        if(student < 0){
            throw new DatasetException("Number of staff cases should be >= 0");
        }else{
            studentCases = student;
            return true;
        }
    }

    public boolean checkOtherCases(int other){
        if(other < 0){
            throw new DatasetException("Number of other cases should be >= 0");
        } else{
            otherCases = other;
            return true;
        }
    }
}
