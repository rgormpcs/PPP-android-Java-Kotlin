package predictor.mpcs.com.picoplacapredictor.model;


public class Vehicle {
    private String licensePlateNumber;

    public Vehicle(String licensePlateNumber) {
        super();
        this.licensePlateNumber = licensePlateNumber;
    }

    public boolean licensePlateNumberLengthVerify() {
        return (licensePlateNumber.length()>=7 && licensePlateNumber.length()<=8);
    }

    public String verifyRestrictedDayByLicensePlate() {
        int lastDigit=Integer.parseInt(licensePlateNumber.substring(licensePlateNumber.length()-1,licensePlateNumber.length()));

        String day="";
        if(lastDigit==1 || lastDigit==2){
            day="Lunes";
        }else if (lastDigit==3 || lastDigit==4){
            day= "Martes";
        }else if (lastDigit==5 || lastDigit==6){
            day= "Miercoles";
        }else if (lastDigit==7 || lastDigit==8){
            day= "Jueves";
        }else if (lastDigit==9 || lastDigit==0){
            day= "Viernes";
        }
    return day;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }
}
