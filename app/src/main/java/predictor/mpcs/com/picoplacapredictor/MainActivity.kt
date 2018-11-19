package predictor.mpcs.com.picoplacapredictor

import predictor.mpcs.com.picoplacapredictor.model.*
import predictor.mpcs.com.picoplacapredictor.util.*
import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import predictor.mpcs.com.picoplacapredictor.util.Util

class MainActivity : AppCompatActivity() {
    var dateString ="10"
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         var dateCalendar=findViewById<CalendarView>(R.id.dateCalendar)
         dateCalendar?.setOnDateChangeListener { view, year, month, dayOfMonth ->
             //month start on 0 then add 1 to show the correct month
            dateString ="${dayOfMonth}/${(month + 1)}/${year}"
         }

         val buttonPredict = findViewById<Button>(R.id.buttonPredict)

        buttonPredict.setOnClickListener {
            view -> predict()
        }
    }


    fun predict(){
        var vehicle = Vehicle(findViewById<TextView>(R.id.placaText).text.toString())
        /*var day = Day(findViewById<TextView>(R.id.dateText).text.toString(),findViewById<TextView>(R.id.timeText).text.toString())*/
        var day = Day(dateString,findViewById<TextView>(R.id.timeText).text.toString())
        val text=findViewById(R.id.resultado)as TextView
        var message="Datos incorrectos"


        if(vehicle.licensePlateNumberLengthVerify()&&(day.dateLengthVerify()&&day.timeLengthVerify())){
            if((day.dayOfDate()!="Saturday")&&(day.dayOfDate()!="Sunday")){
                if(day.dayOfDate()==vehicle.verifyRestrictedDayByLicensePlate()){
                    if(day.verifyRestrictedTime()){
                        message="Tu vehiculo con placa:${vehicle.getLicensePlateNumber()} " +
                                " tiene restriccion en: ${day.dayOfDate()}, ${day.date} a las: ${day.time}"
                        return text.setText(message)
                    }else{
                        message="Tu vehiculo con placa:${vehicle.getLicensePlateNumber()} " +
                                "no tiene restriccion en: ${day.dayOfDate()}, ${day.date} a las: ${day.time}"
                        return text.setText(message)
                    }
                }else{
                    message="Tu vehiculo con placa:${vehicle.getLicensePlateNumber()} " +
                            "no tiene restriccion en: ${day.dayOfDate()}, ${day.date} a las: ${day.time}"
                    return text.setText(message)
                }
            }else{
                message="No hay restricción de circulación los fines de semana"
                return text.setText(message)


            }
        }
        return text.setText(message)
    }


}
