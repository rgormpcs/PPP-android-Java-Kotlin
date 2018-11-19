package predictor.mpcs.com.picoplacapredictor.util


import android.content.Context
import android.widget.Toast
import predictor.mpcs.com.picoplacapredictor.MainActivity

class Util(var context:Context){

    fun messegeToastShort(message:String, length:Int= Toast.LENGTH_SHORT){
        val ToastMessage: Any = Toast.makeText(context,message,length).show()
    }
    //don´t need context as a parameter cause extention funtion of Context give a diferent behaviour
    fun Context.messegeToastShort2(message:String, length:Int= Toast.LENGTH_SHORT){
        val ToastMessage: Any = Toast.makeText(this,message,length).show()
    }
    fun niceToast(message: String, tag: String = MainActivity::class.java.simpleName, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, "$tag: $message", length).show()
    }
}

