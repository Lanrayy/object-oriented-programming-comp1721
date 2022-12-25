package comp1721.cwk1;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class CovidDataset {
    //field for Covid dataset
    //A list that will store Covid Datasets
    private List<CaseRecord> caseRecordList = new ArrayList<>();


    public void readDailyCases(String filename) throws IOException {
        //will read from the file given by string filename: DONE
        //will output convert each of the lines in the files to a CaseRecord: DONE
        //Store in a Covid Dataset Class: DONE
        //Will need an exception specification: DONE
        //Reading data from the file should clear out any data previously held covid dataset: DONE
        //It is ok for the dataset to be empty: DONE
        //It is ok for the data set to contain column headings: DONE

        Path path = Paths.get(filename);
        LocalDate date;
        int staff;
        int student;
        int other;

        List<String> lines = Files.readAllLines(path);

        //iterate over the lines in the list
        for(int i = 0; i < lines.size(); i++){

            //if the size of list is 1 i.e. contains only the header
            //overwrite content in the CovidDataSet
            if(lines.size() == 1){
                caseRecordList.remove(i);
            }

            //skips the header
            if(i == 0){
                continue;
            }

            String line = lines.get(i);
            //System.out.println(line);

            String[] attributes = line.split(",");

            if(attributes.length != 4){
                throw new DatasetException("Missing Column");
            }

            date = LocalDate.parse(attributes[0]);
            staff = Integer.parseInt(attributes[1]);
            student = Integer.parseInt(attributes[2]);
            other = Integer.parseInt(attributes[3]);

            //create new case record
            CaseRecord newRecord = new CaseRecord(date, staff, student, other);

            //add the case record to the list
            caseRecordList.add(newRecord);

        }

    }

    public int size() {
        int size;
        size = caseRecordList.size();
        return size;
    }

    public void addRecord(CaseRecord rec) {
        caseRecordList.add(rec);
    }


    public CaseRecord getRecord(int index) {
        CaseRecord rec;
        if (index < 0 || index >= caseRecordList.size()) {
            throw new DatasetException("Please enter a valid index");
        }

        rec = caseRecordList.get(index);
        return rec;
    }


    public CaseRecord dailyCasesOn(LocalDate day) {
        int found = 0;
        for (int i = 0; i < caseRecordList.size(); i++) {
            //get each case record
            CaseRecord rec = caseRecordList.get(i);

            //compare the dates on the case record
            if (rec.getDate() == day){
                //if the dates match, return the caseRecord
                found++;
                return rec;
            }
        }

        if (found == 0) {
            throw new DatasetException("No Cases could be found on the specified date");
        }
        return null;
    }


    public void writeActiveCases(String filename) throws IOException {
        Path path = Paths.get(filename);

        if(caseRecordList.size() < 10){
            throw new DatasetException("Size is too small");
        }


        try(PrintWriter out = new PrintWriter(Files.newBufferedWriter(path))){
            LocalDate date = null;

            int caseSize = caseRecordList.size();

            out.printf("Date,Staff,Students,Other\n");

            for(int i = 0; i < caseSize; i++){
                if(i <= 8){
                    continue;
                }

                int sumStudentCases = 0;
                int sumStaffCases = 0;
                int sumOtherCases = 0;


                CaseRecord currentDayRecord = caseRecordList.get(i);

                date = currentDayRecord.getDate();



                for( int j = i; j > (i -10); j --){

                    CaseRecord currentRecord = caseRecordList.get(j);

                    int currentStudentCase = currentRecord.getStudentCases();
                    sumStudentCases += currentStudentCase;

                    int currentStaffCase = currentRecord.getStaffCases();
                    sumStaffCases += currentStaffCase;

                    int currentOtherCase = currentRecord.getOtherCases();
                    sumOtherCases += currentOtherCase;


                }

                out.printf("%s,%d,%d,%d\n",date,sumStaffCases, sumStudentCases, sumOtherCases);
            }
        }



    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        CovidDataset that = (CovidDataset) o;
        return Objects.equals(caseRecordList, that.caseRecordList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseRecordList);
    }
}
