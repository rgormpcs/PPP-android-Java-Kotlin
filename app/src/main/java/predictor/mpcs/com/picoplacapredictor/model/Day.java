package predictor.mpcs.com.picoplacapredictor.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Day {

    private String date;
    private String time;

    public Day(String date, String time) {
        super();
        this.date = date;
        this.time = time;
    }

    public boolean dateLengthVerify(){
        return (date.length()>=8 && date.length()<=10);
    }
    public boolean timeLengthVerify(){
        return (time.length()>=4 && time.length()<=5);
    }
    public boolean verifyRestrictedTime(){
        String[] timeSplit=time.split(":");
        int hour= Integer.parseInt(timeSplit[0]);//try
        int minutes= Integer.parseInt(timeSplit[1]);
        if((hour>=7&&hour<=9)||(hour>=16&&hour<=19)){
            if(hour==9||hour==19){
                if ((minutes>0&&minutes<=30)){
                    return true;
                }else{
                    return false;
            }}else{
                return true;
            }
        }else {
            return false;
        }
    }

    public String dayOfDate() {
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        String dayOfDate="";
        try {
            Date dateTransform = format.parse(date);
            switch (dateTransform.getDay()){
                case 1: dayOfDate="Lunes";
                break;
                case 2: dayOfDate="Martes";
                    break;
                case 3: dayOfDate="Miercoles";
                    break;
                case 4: dayOfDate="Jueves";
                    break;
                case 5: dayOfDate="Viernes";
                    break;
                case 6: dayOfDate="Sabado";
                    break;
                case 0: dayOfDate="Domingo";
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return dayOfDate;
    }


    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

}

